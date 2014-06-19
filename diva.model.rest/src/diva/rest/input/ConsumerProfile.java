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
package diva.rest.input;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class ConsumerProfile {

	public static ConsumerProfile INSTANCE = new ConsumerProfile();
	
	private static final String CURRENT_USED = "CURRENT_USED";
	
	Random random = new Random();
	
	private Map<String, Object> fakedRequired = new HashMap<String, Object>();
	
	private void initFake(){
		Map<String, Object> prf = new HashMap<String, Object>();
		prf.put("Bicycle", true);
		prf.put("LiveTraffic", false);
		//I put currently used services here too, but in practice, it may be obtained from 
		//a different service
		prf.put(CURRENT_USED, new HashSet<String>(Arrays.asList(
					"AppleMap"
				))	
			);
		fakedRequired.put("abc-001", prf);
		
		prf = new HashMap<String, Object>();
		prf.put("Bicycle", false);
		prf.put("LiveTraffic", true);
		prf.put("RoutePlan", true);
		prf.put(CURRENT_USED, new HashSet<String>(Arrays.asList(
				"BingMap", "FakeRouter", "Metro"
			))	
		);
		fakedRequired.put("abc-002", prf);	
	}
	
	public ConsumerProfile(){
		initFake();
	}
	
	
	public Object getRequired(String consumer, String profile){
		
		return fakedRequired.get(combineIds(consumer, profile));
		
	}
	
	private String combineIds(String consumer, String profile){
		return consumer+"-"+profile;
	}
	
	public Collection<String> getCurrentServices(String consumer, String profile){
		return this.getCurrentServices(combineIds(consumer, profile));
	}
	
	public Collection<String> getCurrentServices(String consumerProfile){
		Set<String> current = (Set<String>)((Map)fakedRequired.get(consumerProfile)).get(CURRENT_USED);
		return new HashSet<String>( current);
	}
	
	
}


