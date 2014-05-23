package diva.rest.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import diva.Configuration;
import diva.Context;

/**
 * 
 * A Configuration Pool mains a set of configurations under a particular context. It means that
 * whenever the context is changed, a new pool should be created.
 * 
 * Given that the context is not changed, 
 * 
 * @author Hui Song
 *
 */
public class ConfigurationsPool {
	
	Map<String, Configuration> pool = new HashMap<String, Configuration>();
	List<Configuration> original = new ArrayList<Configuration>();
	
	Map<String, List<String>> idPool = new HashMap<String, List<String>>();
	Map<String, Boolean> responsePool = new HashMap<String, Boolean>();
	

	public ConfigurationsPool(Context context){
		int i = context.getConfiguration().size();
		for(Configuration conf : context.getConfiguration()){
			pool.put(String.format("%2d", i), conf);
			original.add(conf);
			i -= 1;
		}
	}
	
	public Collection<String> confIds(){
		return pool.keySet();
	}
	
	
	public Configuration getConf(String id){
		return pool.get(id);
	}
	
	public List<String> queryScProfile(String sc, String profile){
		String combinedId = sc + "-" + profile;
		if(idPool.containsKey(combinedId))
			return idPool.get(combinedId);
		
		List<String> newIds = new LinkedList<String>();
		int i = 0;
		for(Configuration conf : original){
			if(filterConfig(sc, profile)){
				String configId = combinedId + "--" + String.valueOf(i);
				pool.put(configId, conf);
				newIds.add(configId);
				i = i + 1;
			}
				
		}
		idPool.put(combinedId, newIds);
		return newIds;
	}
	
	/**
	 * @TODO Need to do something besides merely recording the decision
	 * @param id
	 * @param decision
	 */
	public void setResponse(String id, boolean decision){
		
		responsePool.put(id, decision);
	}
	
	/**
	 * Could be "false" (rejected), "true" (accepted), or "null" (no response on this recomm yet)
	 * @param id
	 * @return
	 */
	public Boolean getResponse(String id){
		return responsePool.get(id);
	}
	
	/**
	 * Not implemented yet
	 * @param sc
	 * @param profile
	 * @return
	 */
	private boolean filterConfig(String sc, String profile){
		return true;
	}

	
	
}
