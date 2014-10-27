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

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import diva.rest.input.abstracts.ServiceAttribute;

public class ServiceAttributeLocal extends ServiceAttribute {

	public static ServiceAttributeLocal INSTANCE = new ServiceAttributeLocal();
	
	Random random = new Random();
	
	private Map<String, Object> fakedRepo = new HashMap<String, Object>();
	
	private void initFake(){
		fakedRepo.put("LyncAddr-Price", 1);
		fakedRepo.put("LyncAddr-Response", 3);
		fakedRepo.put("LyncAddr-CPU", 1);
		fakedRepo.put("LyncAddr-RAM", 4);
		fakedRepo.put("LyncAddr-Failure", 0);
		
		fakedRepo.put("GMailAddr-Price", 0);
		fakedRepo.put("GMailAddr-Response", 3);
		fakedRepo.put("GMailAddr-CPU", 1);
		fakedRepo.put("GMailAddr-RAM", 10);
		fakedRepo.put("GMailAddr-Failure", 0);
		
		fakedRepo.put("OutlookCal-Price", 0);
		fakedRepo.put("OutlookCal-Response", 5);
		fakedRepo.put("OutlookCal-CPU", 1);
		fakedRepo.put("OutlookCal-RAM", 3);
		fakedRepo.put("OutlookCal-Failure", 0);
		
		fakedRepo.put("GoogleCal-Price", 0);
		fakedRepo.put("GoogleCal-Response", 3);
		fakedRepo.put("GoogleCal-CPU", 3);
		fakedRepo.put("GoogleCal-RAM", 1);
		fakedRepo.put("GoogleCal-Failure", 0);
		
		fakedRepo.put("BingMap-Price", 0);
		fakedRepo.put("BingMap-Response", 9);
		fakedRepo.put("BingMap-CPU", 1);
		fakedRepo.put("BingMap-RAM", 3);
		fakedRepo.put("BingMap-Failure", 0);
		
		fakedRepo.put("YellowMap-Price", 1);
		fakedRepo.put("YellowMap-Response", 3);
		fakedRepo.put("YellowMap-CPU", 1);
		fakedRepo.put("YellowMap-RAM", 1);
		fakedRepo.put("YellowMap-Failure", 0);	
		
		fakedRepo.put("GoogleMap-Price", 1);
		fakedRepo.put("GoogleMap-Response", 3);
		fakedRepo.put("GoogleMap-CPU", 1);
		fakedRepo.put("GoogleMap-RAM", 10);
		fakedRepo.put("GoogleMap-Failure", 0);	
		
	}
	
	public ServiceAttributeLocal(){
		initFake();
	}
	
	@Override
	public List<String> listAttributes(String service){
		return Collections.EMPTY_LIST;
	}
	
	@Override
	public List<String> listCommonAttributes(){
		return Arrays.asList("Price","Failure", "Response","CPU","RAM");
	}
	

	
	
	@Override
	public Object get(String service, String attribute){
		if("FailTen".equals(attribute))
			return random.nextInt(10);
		
		return fakedRepo.get(service+"-"+attribute);
		
	}
	
	
}


