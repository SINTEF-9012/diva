package diva.rest.model;

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

import diva.BoolVariableValue;
import diva.Context;
import diva.ContextExpression;
import diva.Dimension;
import diva.DivaFactory;
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
			for(Map.Entry<String, Object> entry : prf.entrySet()){
				Object value = entry.getValue();
				Variable var = null;
				for(Variable v : root.getContext())
					if(v.getId().equals(entry.getKey()))
						var = v;
				
				if(value instanceof Boolean && var != null){
					BoolVariableValue bvv = factory.createBoolVariableValue();
					bvv.setVariable(var);
					bvv.setBool(((Boolean)value).booleanValue());
					context.getVariable().add(bvv);
				}
				
				//Check if a user want a service from any dimension
				for(Dimension d : root.getDimension()){
					if(Boolean.valueOf(true).equals(entry.getValue()) && 
							d.getName().equals(entry.getKey())){
						d.setLower(1);
					}
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
		updateCategoryAndService();
		updateDependency();
		updateAvailable();
	}
	

	public void updateOnRequest(String consumer, String profile){
		this.updateProfileContext(consumer, profile);
		this.updateProperty();
	}
	
	public DivaRoot fork(){
		VariabilityModel model = EcoreUtil.copy(root);
		return new DivaRoot(model);
	}
	
	public ConfigurationsPool getConfigurationPool(){
		return configPool;
	}
	
	
}
