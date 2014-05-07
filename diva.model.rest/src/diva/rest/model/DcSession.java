package diva.rest.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Each per request id
 * @author Hui Song
 *
 */
public class DcSession {
	
	private String requestId;
	private Set<String> allServices = new HashSet<String>();
	
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
		return allServices;
	}

}
