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
package diva.rest.input.json;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import diva.rest.input.abstracts.ServiceDependency;

public class ServiceDependencyJson extends ServiceDependency {
	
	public static ServiceDependencyJson INSTANCE = new ServiceDependencyJson();
	
	private Map<String, List<String>> fakeRepo = new HashMap<String, List<String>>();
	
	private void initFake(){
		fakeRepo.put("GoldenOrbiServiceLevelProfile", 
				Arrays.asList(
						"SmallElasticDBServiceLevelProfile",
						"LargeElasticASServiceLevelProfile",
						"LargeMeteredServiceLevelProfile"
						
					));
		
		
		fakeRepo.put("SilverOrbiServiceLevelProfile", 
				Arrays.asList(
						"SmallElasticDBServiceLevelProfile",
						"MediumClusteredASServiceLevelProfile",
						"LargeMeteredServiceLevelProfile"
						));
		
		fakeRepo.put("BronzeOrbiServiceLevelProfile", 
				Arrays.asList(
						"MediumClusteredDBServiceLevelProfile",
						"SmallClusteredASServiceLevelProfile",
						"MediumUnmeteredServiceLevelProfile"
						));
		
		fakeRepo.put("FreeOrbiServiceLevelProfile", 
				Arrays.asList(
						"MediumMonolithicDBServiceLevelProfile",
						"MediumSingleInstanceASServiceLevelProfile",
						"SmallUnmeteredServiceLevelProfile"
				));
		
	}
	
	public ServiceDependencyJson(){
		initFake();
	}
	
	@Override
	public List<String> getDependency(String srv){
		return fakeRepo.get(srv);
	}
}
