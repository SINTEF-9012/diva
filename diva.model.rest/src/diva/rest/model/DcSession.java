package diva.rest.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import diva.rest.input.ServiceDependency;

/**
 * Each per request id
 * @author Hui Song
 *
 */
public class DcSession {
	
	private String requestId;
	private Set<String> allServices = new HashSet<String>();
	
	private DivaRoot root = null;
	
	public void setDivaRoot(DivaRoot root){
		this.root = root;
	}
	
	private Collection<String> checkOneStep(){
		Set<String> required = new HashSet<String>();
		for(String s : allServices){
			try{
				List<String> dep = ServiceDependency.INSTANCE.getDependency(s);
				if(dep !=null)
					required.addAll(dep);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		required.removeAll(allServices);
		return required;
	}
	
	public DcSession(String requestId){
		this.requestId = requestId;
	}
	
	public void addServices(List<String> services){
		allServices.addAll(services);
	}
	
	/**
	 * Empty List means the dependency is satisfied
	 * A mock one requires exactly the existing requested services
	 * @return
	 */
	public Collection<String> getMissed(){
		return checkOneStep();
	}

}
