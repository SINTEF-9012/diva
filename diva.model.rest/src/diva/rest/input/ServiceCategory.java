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
	
	private void initFake(){
		fakeRepo.put("Map", 
				Arrays.asList("GoogleMap", "BingMap", "AppleMap")
			);
		fakeRepo.put("PubTrans", 
				Arrays.asList("Metro")
			);
		fakeRepo.put("RoutePlan", 
				Arrays.asList("FakeRouter", "ToyRouter")
			);
	}
	
	public List<String> getCategories(){
		return new ArrayList<String>(fakeRepo.keySet());
	}
	
	public List<String> getServices(String category){
		return fakeRepo.get(category);
	}
	
	

}
