package diva.rest.model;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import diva.Scenario;
import diva.VariabilityModel;

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
	
}
