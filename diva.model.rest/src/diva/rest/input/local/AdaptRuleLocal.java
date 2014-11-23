package diva.rest.input.local;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import diva.rest.input.abstracts.AdaptRule;

public class AdaptRuleLocal extends AdaptRule {

	public static AdaptRuleLocal INSTANCE = new AdaptRuleLocal();
	
	private Map<String, Map<String, String>> fakedRepo = new HashMap<String, Map<String, String>>();
	
	private void initFake(){
		Map<String, String> ms = new HashMap<String, String>();
		
		ms.put("rule", "CpuOLoad");
		ms.put("VarAmountOfDBAllocatedVCPUs", "5");
		ms.put("VarAmountOfDBAllocatedVCPUsPerNode", "5");
		ms.put("VarAmountOfClusterNodes", "2");
		

		fakedRepo.put("AvoidCPUFailure", ms);
		
		ms = new HashMap<String, String>();
		ms.put("rule", "RamOLoad");
		ms.put("VarAmountOfDBAllocatedMemory", "5");
		ms.put("VarAmountOfDBAllocatedMemoryPerNode", "5");
		ms.put("VarAmountOfClusterNodes", "2");
		
		fakedRepo.put("AvoidMemFailure", ms);
		
	}
	
	public AdaptRuleLocal(){
		initFake();
	}
	
	@Override
	public Collection<String> allRuleNames(){
		return fakedRepo.keySet();
	}
	
	@Override
	public String getRule(String name){
		return fakedRepo.get(name).get("rule");
	}
	
	@Override
	public int getPriority(String name, String property){
		String res = fakedRepo.get(name).get(property);
		if(res == null)
			return 1;
		return Integer.parseInt(res);
	}
}
