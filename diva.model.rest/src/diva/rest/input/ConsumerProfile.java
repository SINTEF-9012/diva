package diva.rest.input;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ConsumerProfile {

	public static ConsumerProfile INSTANCE = new ConsumerProfile();
	
	Random random = new Random();
	
	private Map<String, Object> fakedRequired = new HashMap<String, Object>();
	
	private void initFake(){
		Map<String, Object> prf = new HashMap<String, Object>();
		prf.put("Bicycle", true);
		prf.put("LiveTraffic", false);
		fakedRequired.put("hui-001", prf);
		
		prf = new HashMap<String, Object>();
		prf.put("Bicycle", false);
		prf.put("LiveTraffic", true);
		fakedRequired.put("hui-002", prf);
	}
	
	public ConsumerProfile(){
		initFake();
	}
	
	
	public Object getRequired(String consumer, String profile){
		
		return fakedRequired.get(consumer+"-"+profile);
		
	}
	
	
}


