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
	

	public ConfigurationsPool(Context context){
		int i = 0;
		for(Configuration conf : context.getConfiguration()){
			pool.put(String.valueOf(i), conf);
			original.add(conf);
			i += 1;
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
				String configId = combinedId + "-" + String.valueOf(i);
				pool.put(configId, conf);
				newIds.add(configId);
				i = i + 1;
			}
				
		}
		idPool.put(combinedId, newIds);
		return newIds;
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
