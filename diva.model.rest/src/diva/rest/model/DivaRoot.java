package diva.rest.model;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import diva.Dimension;
import diva.Scenario;
import diva.VariabilityModel;
import diva.Variant;
import diva.helpers.DivaHelper;
import diva.rest.input.ServiceAttribute;

public class DivaRoot {
	
	
	protected VariabilityModel root = null;

	public DivaRoot(URI uri){
		ResourceSet rs = new ResourceSetImpl();
		Resource res = rs.createResource(uri);
		try{
			res.load(Collections.EMPTY_MAP);
			root = (VariabilityModel) res.getContents().get(0);
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
	}
	
	public void updateProperty(){
		for(Dimension dim : root.getDimension()){
			for(Variant var : dim.getVariant()){
				Object res = ServiceAttribute.INSTANCE.get(var.getId(), "avail");
				var.getPropertyValue().get(0).setValue((Integer)res);
			}
		}
	}
}
