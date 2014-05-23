package diva.rest.input;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ServiceAttribute {

	public static ServiceAttribute INSTANCE = new ServiceAttribute();
	
	Random random = new Random();
	
	public List<String> listAttributes(String service){
		return Collections.EMPTY_LIST;
	}
	
	public List<String> listCommonAttributes(){
		return Arrays.asList("Avail");
	}
	
	public Object get(String service, String attribute){
		return random.nextInt(10);
	}
	
	
}


