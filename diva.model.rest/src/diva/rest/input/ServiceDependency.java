package diva.rest.input;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceDependency {
	
	public static ServiceDependency INSTANCE = new ServiceDependency();
	
	private Map<String, List<String>> fakeRepo = new HashMap<String, List<String>>();
	
	private void initFake(){
		fakeRepo.put("Metro", Arrays.asList("BingMap"));
		fakeRepo.put("FakeRouter", Arrays.asList("Metro"));
		fakeRepo.put("ToyRouter", Arrays.asList("GoogleMap"));
	}
	
	public ServiceDependency(){
		initFake();
	}
	
	public List<String> getDependency(String srv){
		return fakeRepo.get(srv);
	}
}
