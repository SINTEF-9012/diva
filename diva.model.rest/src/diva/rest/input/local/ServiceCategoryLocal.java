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
package diva.rest.input.local;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import diva.rest.input.abstracts.ServiceCategory;

public class ServiceCategoryLocal extends ServiceCategory {
	
	public static ServiceCategoryLocal INSTANCE = new ServiceCategoryLocal();
	
	public Map<String, List<String>> fakeRepo = new HashMap<String, List<String>>();
	
	public ServiceCategoryLocal(){
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
		return new ArrayList<String>(fakeRepo.keySet());
	}
	
	@Override
	public List<String> getServices(String category){
		return fakeRepo.get(category);
	}
	
	

}
