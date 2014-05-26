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


