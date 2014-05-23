package diva.rest.model;

import java.util.Iterator;
import java.util.List;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import diva.Dimension;
import diva.DivaFactory;
import diva.Scenario;
import diva.Term;
import diva.VariabilityModel;
import diva.Variant;
import diva.VariantExpression;
import diva.helpers.DivaHelper;
import diva.parser.DivaExpressionParser;
import diva.rest.input.ServiceAttribute;
import diva.rest.input.ServiceDependency;

public class DivaRoot {
	
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
		root.getSimulation().populatePriorities();
		root.getSimulation().populateScores();
		root.getSimulation().populateVerdicts();
		configPool = new ConfigurationsPool(
					root.getSimulation().getScenario().get(0).getContext().get(0)
				);
	}
	
	private void updateProperty(){
		for(Dimension dim : root.getDimension()){
			for(Variant var : dim.getVariant()){
				Object res = ServiceAttribute.INSTANCE.get(var.getId(), "avail");
				var.getPropertyValue().get(0).setValue((Integer)res);
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
					VariantExpression expr = DivaFactory.eINSTANCE.createVariantExpression();
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
		
		updateProperty();
		updateDependency();
		
	}
	
	public void updateCustomerProfile(String sc, String profile){
		//TODO: obtain profile information and update the context (and values)
	}
	
	public DivaRoot fork(){
		VariabilityModel model = EcoreUtil.copy(root);
		return new DivaRoot(model);
	}
	
	public ConfigurationsPool getConfigurationPool(){
		return configPool;
	}
	
	
}
