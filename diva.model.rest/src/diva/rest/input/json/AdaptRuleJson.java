package diva.rest.input.json;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import diva.rest.input.abstracts.AdaptRule;

public class AdaptRuleJson extends AdaptRule {

	public static AdaptRuleJson INSTANCE = new AdaptRuleJson();
	
	private Map<String, Map<String, String>> fakedRepo = new HashMap<String, Map<String, String>>();
	
	private void initFake(){
		Map<String, String> ms = new HashMap<String, String>();
		
		ms.put("rule", "CpuOLoad");
		ms.put("VarAmountOfDBAllocatedVCPUs", "5");
		ms.put("VarAmountOfDBAllocatedVCPUsPerNode", "5");
		ms.put("VarAmountOfASAllocatedVCPUs", "5");
		ms.put("VarAmountOfWebBalancingNodes", "2");
		ms.put("VarASScaleUpFactor", "8");
		ms.put("VarDBScaleUpFactor", "4");
		ms.put("VarAmountOfClusterNodes", "2");
		

		fakedRepo.put("AvoidCPUFailure", ms);
		
		ms = new HashMap<String, String>();
		ms.put("rule", "RamOLoad");
		ms.put("VarAmountOfDBAllocatedMemory", "8");
		ms.put("VarAmountOfDBAllocatedMemoryPerNode", "8");
		ms.put("VarAmountOfASAllocatedMemory", "8");
		ms.put("VarAmountOfWebBalancingNodes", "2");
		ms.put("VarASScaleUpFactor", "8");
		ms.put("VarDBScaleUpFactor", "4");
		ms.put("VarAmountOfClusterNodes", "2");
		
		fakedRepo.put("AvoidMemFailure", ms);
		
//		ms = new HashMap<String, String>();
//		ms.put("rule", "Normal");
//		ms.put("VarAmountOfDBAllocatedMemory", "1");
//		ms.put("VarAmountOfDBAllocatedMemoryPerNode", "1");
//		ms.put("VarAmountOfASAllocatedMemory", "1");
//		ms.put("VarAmountOfWebBalancingNodes", "1");
//		ms.put("VarASScaleUpFactor", "2");
//		ms.put("VarDBScaleUpFactor", "2");
//		ms.put("VarAmountOfClusterNodes", "2");
//		
//		fakedRepo.put("AvoidMemFailure", ms);
		
		
		
	}
	
	public AdaptRuleJson(){
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
