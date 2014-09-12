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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceDependency {
	
	public static ServiceDependency INSTANCE = new ServiceDependency();
	
	private Map<String, List<String>> fakeRepo = new HashMap<String, List<String>>();
	
	private void initFake(){
		fakeRepo.put("LyncAddr", Arrays.asList("OutlookCal"));
		fakeRepo.put("OutlookCal", Arrays.asList("LyncAddr"));
	}
	
	public ServiceDependency(){
		initFake();
	}
	
	public List<String> getDependency(String srv){
		return fakeRepo.get(srv);
	}
}
