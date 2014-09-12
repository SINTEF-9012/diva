/**
 * Copyright 2014 SINTEF <brice.morin@sintef.no>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package diva.rest.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import diva.BoolVariableValue;
import diva.BooleanVariable;
import diva.Context;
import diva.ContextExpression;
import diva.Dimension;
import diva.DivaFactory;
import diva.EnumLiteral;
import diva.EnumVariable;
import diva.EnumVariableValue;
import diva.Priority;
import diva.PriorityRule;
import diva.Property;
import diva.PropertyValue;
import diva.Scenario;
import diva.Term;
import diva.VariabilityModel;
import diva.Variable;
import diva.Variant;
import diva.VariantExpression;
import diva.helpers.DivaHelper;
import diva.parser.DivaExpressionParser;
import diva.rest.input.AdaptRule;
import diva.rest.input.ConsumerProfile;
import diva.rest.input.ServiceAttribute;
import diva.rest.input.ServiceCategory;
import diva.rest.input.ServiceDependency;

public class DivaRoot {
	
	private DivaFactory factory = DivaFactory.eINSTANCE;
	
	private String combinedId = null;
	private Date timeQueried = null;

	
	public Date getTimeQueried() {
		return timeQueried;
	}

	public void setTimeQueried(Date timeQueried) {
		this.timeQueried = timeQueried;
	}

	public String getCombinedId() {
		return combinedId;
	}

	public void setCombinedId(String combinedId) {
		this.combinedId = combinedId;
	}
	
	

	ConfigurationsPool configPool = null;
	protected VariabilityModel root = null;
	
	protected DivaRoot(VariabilityModel root){
		this.root = root;
	}

	public DivaRoot(URI uri){
		ResourceSet rs = new ResourceSetImpl();
		Resource res = rs.createResource(uri);
		try{
			res.load(Collections.EMPTY_MAP);
			this.root = (VariabilityModel) res.getContents().get(0);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Collection<Scenario> getScenarios(){
		return root.getSimulation().getScenario();
	}
	
	public void runSimulation(){
		if(root.getSimulation()==null)
			return;
		DivaHelper.computeSuitableConfigurations(root, 0);
		
		setTimeQueried(Calendar.getInstance().getTime());
		
		root.getSimulation().populatePriorities();
		root.getSimulation().populateScores();
		root.getSimulation().populateVerdicts();
		configPool = new ConfigurationsPool(
					root.getSimulation().getScenario().get(0).getContext().get(0)
				);
	}
	
	private void updateCategoryAndService(){
		List<String> cats = ServiceCategory.INSTANCE.getCategories();
		for(String cat : cats){
			Dimension dim = factory.createDimension();
			dim.setId(cat);
			dim.setName(cat);
			dim.setLower(0);
			dim.setUpper(1);
			root.getDimension().add(dim);
			
			for(String svc : ServiceCategory.INSTANCE.getServices(cat)){
				Variant var = factory.createVariant();
				var.setId(svc);
				var.setName(svc);
				dim.getVariant().add(var);
				var.setType(dim);
				
				for(Property property : root.getProperty()){
					PropertyValue value = factory.createPropertyValue();
					value.setProperty(property);
					var.getPropertyValue().add(value);
				}
				
			}
		}
	}
	
	/*Before Category*/
	private void updatePropertyDef(){
		for(String s : ServiceAttribute.INSTANCE.listCommonAttributes()){
			Property p = factory.createProperty();
			p.setDirection(0);
			p.setName(s);
			p.setId(s);
			root.getProperty().add(p);
		}
		
	}
	
	private void updateFixed(){

		
		
		AdaptRule rules = AdaptRule.INSTANCE;
		for(String ruleName : rules.allRuleNames()){
			PriorityRule rule = factory.createPriorityRule();
			rule.setId(ruleName);
			rule.setName(ruleName);
			for(Property p : root.getProperty()){
				Priority priority = factory.createPriority();
				priority.setProperty(p);
				priority.setPriority(rules.getPriority(ruleName, p.getId()));
			}
		}
	}
	private void updateAutoFullAvailability(){
		for(Dimension dim : root.getDimension())
			for(Variant vrt : dim.getVariant()){
				
				String name = vrt.getName();
				
				EnumVariable variable = factory.createEnumVariable();
				variable.setName(name+"S");
				variable.setId(name+"S");
				EnumLiteral avail = factory.createEnumLiteral();
				avail.setName(name+"A");
				avail.setId(name+"A");
				EnumLiteral fail = factory.createEnumLiteral();
				fail.setName(name+"F");
				fail.setId(name+"F");
				variable.getLiteral().add(avail);
				variable.getLiteral().add(fail);
				
				root.getContext().add(variable);
					
				if(vrt.getAvailable() == null){
					vrt.setAvailable(factory.createContextExpression());
				}
				ContextExpression expr = vrt.getAvailable();
				expr.setText(String.format("%sS=%sA", name, name));
				try{
					Term term = DivaExpressionParser.parse(root, expr.getText().trim());
					expr.setTerm(term);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
				
			}
		
		BooleanVariable bv = factory.createBooleanVariable();
		bv.setName("CpuOLoad");
		bv.setId("CpuOLoad");
		root.getContext().add(bv);
		
		bv = factory.createBooleanVariable();
		bv.setName("RamOLoad");
		bv.setId("RamOLoad");
		root.getContext().add(bv);
		
	}
	
	private void updateAvailable(){
		for(Dimension dim : root.getDimension())
			for(Variant vrt : dim.getVariant()){
				List<String> requiredIds = new ArrayList<String>();
				for(Variable var : root.getContext()){
					Object val = ServiceAttribute.INSTANCE.get(vrt.getId(), var.getId());
					if(val == null || !(val instanceof Boolean) || !((Boolean) val).booleanValue())
						continue;
					requiredIds.add(var.getId());
				}
				String res = "";
				Iterator<String> it = requiredIds.iterator();
				if(it.hasNext()){
					res = res + it.next();
					while(it.hasNext()){
						res = res + " or " + it.next();
					}
					
					if(vrt.getAvailable() == null){
						vrt.setAvailable(factory.createContextExpression());
					}
					ContextExpression expr = vrt.getAvailable();
					expr.setText(res);
					try{
						Term term = DivaExpressionParser.parse(root, expr.getText().trim());
						expr.setTerm(term);
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				
				
			}
		
	}
	
	private void updateProperty(){
		
		for(Dimension dim : root.getDimension()){
			for(Variant var : dim.getVariant()){
				for(PropertyValue pv : var.getPropertyValue()){
					Object res = ServiceAttribute.INSTANCE.get(
							var.getId(), 
							pv.getProperty().getId()
						);
					if(res != null && res instanceof Integer)
						var.getPropertyValue().get(0).setValue((Integer)res);
					// TODO: handle properties in other types.
				}
			}
		}
	}
	
	private void updateProfileContext(String consumer, String profile){
		Context context = root.getSimulation().getScenario().get(0).getContext().get(0);
		context.getVariable().clear();
		Map<String, Object> prf = (Map<String, Object>) ConsumerProfile.INSTANCE.getRequired(consumer, profile);
		
		if(prf != null){
			for(Variable v: root.getContext()){
				Object value = prf.get(v.getName());
				if(v instanceof EnumVariable){
					EnumLiteral el = null;
					if(value == null)
						el = ((EnumVariable) v).getLiteral().get(0);
					for(EnumLiteral literal : ((EnumVariable) v).getLiteral()){
						if(literal.getName().equals(value))
							el = literal;
					}
					EnumVariableValue vv = factory.createEnumVariableValue();
					vv.setVariable(v);
					vv.setLiteral(el);
					context.getVariable().add(vv);
				}
				else{
					BoolVariableValue vv = factory.createBoolVariableValue();
					vv.setVariable(v);
					if(Boolean.valueOf(true).equals(value)){
						vv.setBool(true);
					}
					else
						vv.setBool(false);
					context.getVariable().add(vv);
				}
			}
			
			for(Dimension d : root.getDimension()){
				if(Boolean.valueOf(true).equals(prf.get(d.getName()))){
					d.setLower(1);
				}
			}
		}
	}
	
	private void updateDependency(){
		for(Dimension dim : root.getDimension()){
			for(Variant var : dim.getVariant()){
				List<String> dep = ServiceDependency.INSTANCE.getDependency(var.getId());
				if(dep == null || dep.isEmpty())
					continue;
				if(var.getDependency() == null){
					VariantExpression expr = factory.createVariantExpression();
					var.setDependency(expr);
				}
				Iterator<String> it = dep.iterator();
				String s = it.next();
				while(it.hasNext()){
					s = s + " and " + it.next();
				}
				var.getDependency().setText(s);
				try {
					Term term =  DivaExpressionParser.parse(root, s.trim());
					var.getDependency().setTerm(term);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void updateModel() {
		
		root.getDimension().clear();
		root.getContext().clear();
		root.getRule().clear();
		root.getProperty().clear();
		updatePropertyDef();
		updateCategoryAndService();
		updateDependency();
		updateProperty();
		updateAutoFullAvailability();
		updateFixed();
	}
	

	public void updateOnRequest(String consumer, String profile){
		this.updateProfileContext(consumer, profile);
		//this.updateProperty();
	}
	
	public DivaRoot fork(){
		VariabilityModel model = EcoreUtil.copy(root);
		return new DivaRoot(model);
	}
	
	public ConfigurationsPool getConfigurationPool(){
		return configPool;
	}
	
	public void saveModel(org.eclipse.emf.common.util.URI uri){
		Resource res = new XMIResourceImpl(uri);
		res.getContents().add(root);
		try {
			res.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
