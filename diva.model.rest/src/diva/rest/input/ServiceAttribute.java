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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ServiceAttribute {

	public static ServiceAttribute INSTANCE = new ServiceAttribute();
	
	Random random = new Random();
	
	private Map<String, Object> fakedRepo = new HashMap<String, Object>();
	
	private void initFake(){
		fakedRepo.put("GoogleMap-Bicycle", true);
		fakedRepo.put("GoogleMap-LiveTraffic", true);
		fakedRepo.put("BingMap-LiveTraffic", true);
	}
	
	public ServiceAttribute(){
		initFake();
	}
	
	public List<String> listAttributes(String service){
		return Collections.EMPTY_LIST;
	}
	
	public List<String> listCommonAttributes(){
		return Arrays.asList("Avail");
	}
	
	public Object get(String service, String attribute){
		if("FailTen".equals(attribute))
			return random.nextInt(10);
		
		return fakedRepo.get(service+"-"+attribute);
		
	}
	
	
}


