package diva.rest.input;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AdaptRule {

	public static AdaptRule INSTANCE = new AdaptRule();
	
	private Map<String, Map<String, String>> fakedRepo = new HashMap<String, Map<String, String>>();
	
	private void initFake(){
		Map<String, String> ms = new HashMap<String, String>();
		ms.put("rule", "(GoogleCalS=GoogleCalF or OutlookCalS=OutlookF)");
		ms.put("Failure", "5");
		fakedRepo.put("Recover", ms);
		
		ms = new HashMap<String, String>();
		ms.put("rule", "not ((CpuOLoad or RamOLoad))");
		ms.put("Price", "5");
		ms.put("Response", "4");
		fakedRepo.put("ReduceCost", ms);
		
		ms = new HashMap<String, String>();
		ms.put("rule", "CpuOLoad");
		ms.put("Cpu", "5");
		fakedRepo.put("AvoidCPUFailure", ms);
		
		ms = new HashMap<String, String>();
		ms.put("rule", "RamOLoad");
		ms.put("Price", "5");
		ms.put("Response", "4");
		fakedRepo.put("Recover", ms);
		
	}
	
	public AdaptRule(){
		initFake();
	}
	
	public Collection<String> allRuleNames(){
		return fakedRepo.keySet();
	}
	
	public String getRule(String name){
		return fakedRepo.get(name).get("rule");
	}
	
	public int getPriority(String name, String property){
		String res = fakedRepo.get(name).get(property);
		if(res == null)
			return 0;
		return Integer.parseInt(res);
	}
}
