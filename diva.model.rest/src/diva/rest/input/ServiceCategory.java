package diva.rest.input;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ServiceCategory {
	
	public static ServiceCategory INSTANCE = new ServiceCategory();
	
	public List<String> getCategories(){
		return Arrays.asList("Map");
	}
	
	public List<String> getServices(String category){
		if("Map".equals(category)){
			return Arrays.asList("Google Map", "Bing Map", "Apple Map");
		}
		else
			return Collections.EMPTY_LIST;
	}
	
	

}
