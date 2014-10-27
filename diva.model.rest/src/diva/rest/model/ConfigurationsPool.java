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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import diva.ConfigVariant;
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
	
	
	Collection<String> queried = new HashSet<String>();
	
	public void addQueriedString(String s){
		queried.add(s);
	}
	
	public Collection<String> listAllQueried(){
		return queried;
	}
	

	public ConfigurationsPool(Context context){
		int i = context.getConfiguration().size();
		List<Configuration> confs = new ArrayList<Configuration>();
		confs.addAll(context.getConfiguration());
		Collections.sort(confs, new Comparator<Configuration>(){

			@Override
			public int compare(Configuration o1, Configuration o2) {
				return Integer.compare(o1.getTotalScore(), o2.getTotalScore());
			}
			
		});
		for(Configuration conf : confs){
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
	
	public Collection<String> getConfNames(String id){
		Configuration config = pool.get(id);
		
		List<String> res = new ArrayList<String>();
		for(ConfigVariant cv : config.getVariant()){
			res.add(cv.getVariant().getName());
		}
		
		return res;
		
	}
	
	public List<String> queryScProfile(String sc, String profile){
		String combinedId = sc + "-" + profile;
		if(idPool.containsKey(combinedId))
			return idPool.get(combinedId);
		
		List<String> newIds = new LinkedList<String>();
		int i = 0;
		for(int j = original.size()-1; j>=0; j--){
			Configuration conf = original.get(j);
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

	public String getFullResponseRepr(){
		return responsePool.toString();
	}
	
}
