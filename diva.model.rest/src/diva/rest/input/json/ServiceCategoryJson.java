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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import diva.rest.input.abstracts.ServiceCategory;

public class ServiceCategoryJson extends ServiceCategory {
	
	public List<String> prefixes = Arrays.asList("Small", "Medium", "Large");
	
	public List<String> profilePrefix = Arrays.asList(
			"Monolithic", "Clustered", "Elastic", 
			"SingleInstance", "Metered", "Unmetered" );
	
	
	public static ServiceCategoryJson INSTANCE = new ServiceCategoryJson();
	
	public Map<String, List<String>> fakeRepo = new HashMap<String, List<String>>();
	
	public ServiceCategoryJson(){
		initFake();
	}
	
//	private void initFake(){
//		fakeRepo.put("Map", 
//				Arrays.asList("GoogleMap", "BingMap", "AppleMap")
//			);
//		fakeRepo.put("PubTrans", 
//				Arrays.asList("Metro")
//			);
//		fakeRepo.put("RoutePlan", 
//				Arrays.asList("FakeRouter", "ToyRouter")
//			);
//	}
	
	private void initFake(){
		fakeRepo.put("DatabaseOfferingServiceModel", 
				Arrays.asList(
						"SmallMonolithicDBServiceLevelProfile", 
						"MediumMonolithicDBServiceLevelProfile", 
						"LargeMonolithicDBServiceLevelProfile",
						"SmallClusteredDBServiceLevelProfile",
						"MediumClusteredDBServiceLevelProfile",
						"LargeClusteredDBServiceLevelProfile",
						"SmallElasticDBServiceLevelProfile",
						"MediumElasticDBServiceLevelProfile",
						"LargeElasticDBServiceLevelProfile"
					)
			);
		fakeRepo.put("ApplicationServerOfferingServiceModel", 
				Arrays.asList(
						"SmallSingleInstanceASServiceLevelProfile", 
						"MediumSingleInstanceASServiceLevelProfile", 
						"LargeSingleInstanceASServiceLevelProfile",
						"SmallClusteredASServiceLevelProfile",
						"MediumClusteredASServiceLevelProfile",
						"LargeClusteredASServiceLevelProfile",
						"SmallElasticASServiceLevelProfile",
						"MediumElasticASServiceLevelProfile",
						"LargeElasticASServiceLevelProfile"
					)
			);
		fakeRepo.put("NetworkCapacityOfferingServiceModel", 
				Arrays.asList(
						"SmallMeteredServiceLevelProfile", 
						"MediumMeteredServiceLevelProfile", 
						"LargeMeteredServiceLevelProfile",
						"SmallUnmeteredServiceLevelProfile",
						"MediumUnmeteredServiceLevelProfile",
						"LargeUnmeteredServiceLevelProfile"
					)
			);
		fakeRepo.put("OrbiOfferingServiceModel", 
				Arrays.asList(
						"GoldenOrbiServiceLevelProfile", 
						"SilverOrbiServiceLevelProfile",
						"BronzeOrbiServiceLevelProfile",
						"FreeOrbiServiceLevelProfile")
			);
	}
	
	@Override
	public List<String> getCategories(){
		Set<String> cats = new HashSet<String>();
		
		for(Object i : JsonRoot.INSTANCE.offerings){
			Map<String, Object> m = (Map<String,Object>) i;
			String profile = m.get(JsonRoot.ServiceLevelProfile).toString();
			for(String s : this.profilePrefix){
				if(profile.startsWith(s)){
					profile = profile.substring(s.length());
					break;
				}
					
			}
			cats.add(profile);
		}
		return new ArrayList<String>(cats);
	}
	
	@Override
	public List<String> getServices(String category){
		Set<String> sers = new HashSet<String>();
		
		for(Object i : JsonRoot.INSTANCE.offerings){
			Map<String, Object> m = (Map<String,Object>) i;
			if(m.get(JsonRoot.ServiceLevelProfile).toString().endsWith(category))
				sers.add(m.get(JsonRoot.OfferingName).toString());
		}
		return new ArrayList<String>(sers);
	}

	@Override
	public List<String> getGroup(String service) {
		List<String> result = new ArrayList<String>();
		Map<String, Object> offering = JsonRoot.INSTANCE.getOffering(service);
		if(offering == null)
			return result;
		String policy = offering.get(JsonRoot.ServiceLevelProfile).toString();
		for(Object i : JsonRoot.INSTANCE.offerings){
			Map<String, Object> m = (Map<String,Object>) i;
			if(policy.equals(m.get(JsonRoot.ServiceLevelProfile)))
				result.add(m.get(JsonRoot.OfferingName).toString());
		}
		return result;
			
	}
	
	

}
