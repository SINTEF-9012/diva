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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceCategory {
	
	public static ServiceCategory INSTANCE = new ServiceCategory();
	
	public Map<String, List<String>> fakeRepo = new HashMap<String, List<String>>();
	
	public ServiceCategory(){
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
		fakeRepo.put("Map", 
				Arrays.asList("GoogleMap", "BingMap", "YellowMap")
			);
		fakeRepo.put("Calendar", 
				Arrays.asList("OutlookCal", "GoogleCal")
			);
		fakeRepo.put("Address", 
				Arrays.asList("LyncAddr", "GMailAddr")
			);
	}
	
	public List<String> getCategories(){
		return new ArrayList<String>(fakeRepo.keySet());
	}
	
	public List<String> getServices(String category){
		return fakeRepo.get(category);
	}
	
	

}
