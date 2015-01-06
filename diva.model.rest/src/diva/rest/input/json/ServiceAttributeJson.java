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
package diva.rest.input.json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import diva.rest.input.abstracts.ServiceAttribute;

public class ServiceAttributeJson extends ServiceAttribute {

	public static ServiceAttributeJson INSTANCE = new ServiceAttributeJson();
	
	Random random = new Random();
	
	private Map<String, Object> fakedRepo = new HashMap<String, Object>();
	
	private void initFake(){
		//MonolithicDBServiceLevelProfile

		fakedRepo.put("SmallMonolithicDBServiceLevelProfile-VarAmountOfDBAllocatedVCPUs", 0);
		fakedRepo.put("MediumMonolithicDBServiceLevelProfile-VarAmountOfDBAllocatedVCPUs", 1);
		fakedRepo.put("LargeMonolithicDBServiceLevelProfile-VarAmountOfDBAllocatedVCPUs", 2);

		fakedRepo.put("SmallMonolithicDBServiceLevelProfile-VarSpeedOfDBAllocatedVCPUs", 0);
		fakedRepo.put("MediumMonolithicDBServiceLevelProfile-VarSpeedOfDBAllocatedVCPUs", 0);
		fakedRepo.put("LargeMonolithicDBServiceLevelProfile-VarSpeedOfDBAllocatedVCPUs", 0);

		fakedRepo.put("SmallMonolithicDBServiceLevelProfile-VarAmountOfDBAllocatedMemory", 0);
		fakedRepo.put("MediumMonolithicDBServiceLevelProfile-VarAmountOfDBAllocatedMemory", 3);
		fakedRepo.put("LargeMonolithicDBServiceLevelProfile-VarAmountOfDBAllocatedMemory", 4);

		fakedRepo.put("SmallMonolithicDBServiceLevelProfile-VarMaxQPSSupported", 0);
		fakedRepo.put("MediumMonolithicDBServiceLevelProfile-VarMaxQPSSupported", 0);
		fakedRepo.put("LargeMonolithicDBServiceLevelProfile-VarMaxQPSSupported", 0);

		fakedRepo.put("SmallMonolithicDBServiceLevelProfile-VarMaxTPSSupported", 0);
		fakedRepo.put("MediumMonolithicDBServiceLevelProfile-VarMaxTPSSupported", 0);
		fakedRepo.put("LargeMonolithicDBServiceLevelProfile-VarMaxTPSSupported", 0);

		//ClusteredDBServiceLevelProfile

		fakedRepo.put("SmallClusteredDBServiceLevelProfile-VarAmountOfDBAllocatedVCPUsPerNode", 0);
		fakedRepo.put("MediumClusteredDBServiceLevelProfile-VarAmountOfDBAllocatedVCPUsPerNode", 1);
		fakedRepo.put("LargeClusteredDBServiceLevelProfile-VarAmountOfDBAllocatedVCPUsPerNode", 2);

		fakedRepo.put("SmallClusteredDBServiceLevelProfile-VarSpeedOfDBAllocatedVCPUsPerNode", 0);
		fakedRepo.put("MediumClusteredDBServiceLevelProfile-VarSpeedOfDBAllocatedVCPUsPerNode", 1);
		fakedRepo.put("LargeClusteredDBServiceLevelProfile-VarSpeedOfDBAllocatedVCPUsPerNode", 2);

		fakedRepo.put("SmallClusteredDBServiceLevelProfile-VarAmountOfDBAllocatedMemoryPerNode", 0);
		fakedRepo.put("MediumClusteredDBServiceLevelProfile-VarAmountOfDBAllocatedMemoryPerNode", 0);
		fakedRepo.put("LargeClusteredDBServiceLevelProfile-VarAmountOfDBAllocatedMemoryPerNode", 0);

		fakedRepo.put("SmallClusteredDBServiceLevelProfile-VarMaxQPSSupported", 0);
		fakedRepo.put("MediumClusteredDBServiceLevelProfile-VarMaxQPSSupported", 0);
		fakedRepo.put("LargeClusteredDBServiceLevelProfile-VarMaxQPSSupported", 0);

		fakedRepo.put("SmallClusteredDBServiceLevelProfile-VarMaxTPSSupported", 0);
		fakedRepo.put("MediumClusteredDBServiceLevelProfile-VarMaxTPSSupported", 0);
		fakedRepo.put("LargeClusteredDBServiceLevelProfile-VarMaxTPSSupported", 0);

		fakedRepo.put("SmallClusteredDBServiceLevelProfile-VarAmountOfClusterNodes", 2);
		fakedRepo.put("MediumClusteredDBServiceLevelProfile-VarAmountOfClusterNodes", 8);
		fakedRepo.put("LargeClusteredDBServiceLevelProfile-VarAmountOfClusterNodes", 8);

		fakedRepo.put("SmallClusteredDBServiceLevelProfile-VarReplicationRatio", 1);
		fakedRepo.put("MediumClusteredDBServiceLevelProfile-VarReplicationRatio", 2);
		fakedRepo.put("LargeClusteredDBServiceLevelProfile-VarReplicationRatio", 4);

		//ElasticDBServiceLevelProfile

		fakedRepo.put("SmallElasticDBServiceLevelProfile-VarAmountOfDBAllocatedVCPUsPerNode", 0);
		fakedRepo.put("MediumElasticDBServiceLevelProfile-VarAmountOfDBAllocatedVCPUsPerNode", 1);
		fakedRepo.put("LargeElasticDBServiceLevelProfile-VarAmountOfDBAllocatedVCPUsPerNode", 2);

		fakedRepo.put("SmallElasticDBServiceLevelProfile-VarSpeedOfDBAllocatedVCPUsPerNode", 0);
		fakedRepo.put("MediumElasticDBServiceLevelProfile-VarSpeedOfDBAllocatedVCPUsPerNode", 1);
		fakedRepo.put("LargeElasticDBServiceLevelProfile-VarSpeedOfDBAllocatedVCPUsPerNode", 2);

		fakedRepo.put("SmallElasticDBServiceLevelProfile-VarAmountOfDBAllocatedMemoryPerNode", 0);
		fakedRepo.put("MediumElasticDBServiceLevelProfile-VarAmountOfDBAllocatedMemoryPerNode", 0);
		fakedRepo.put("LargeElasticDBServiceLevelProfile-VarAmountOfDBAllocatedMemoryPerNode", 0);

		fakedRepo.put("SmallElasticDBServiceLevelProfile-VarMaxQPSSupported", 0);
		fakedRepo.put("MediumElasticDBServiceLevelProfile-VarMaxQPSSupported", 0);
		fakedRepo.put("LargeElasticDBServiceLevelProfile-VarMaxQPSSupported", 0);

		fakedRepo.put("SmallElasticDBServiceLevelProfile-VarMaxTPSSupported", 0);
		fakedRepo.put("MediumElasticDBServiceLevelProfile-VarMaxTPSSupported", 0);
		fakedRepo.put("LargeElasticDBServiceLevelProfile-VarMaxTPSSupported", 0);

		fakedRepo.put("SmallElasticDBServiceLevelProfile-VarAmountOfClusterNodes", 2);
		fakedRepo.put("MediumElasticDBServiceLevelProfile-VarAmountOfClusterNodes", 4);
		fakedRepo.put("LargeElasticDBServiceLevelProfile-VarAmountOfClusterNodes", 8);

		fakedRepo.put("SmallElasticDBServiceLevelProfile-VarDBScaleUpFactor", 2);
		fakedRepo.put("MediumElasticDBServiceLevelProfile-VarDBScaleUpFactor", 4);
		fakedRepo.put("LargeElasticDBServiceLevelProfile-VarDBScaleUpFactor", 8);

		//SingleInstanceASServiceLevelProfile

		fakedRepo.put("SmallSingleInstanceASServiceLevelProfile-VarAmountOfASAllocatedVCPUs", 0);
		fakedRepo.put("MediumSingleInstanceASServiceLevelProfile-VarAmountOfASAllocatedVCPUs", 1);
		fakedRepo.put("LargeSingleInstanceASServiceLevelProfile-VarAmountOfASAllocatedVCPUs", 2);

		fakedRepo.put("SmallSingleInstanceASServiceLevelProfile-VarSpeedOfASAllocatedVCPUs", 0);
		fakedRepo.put("MediumSingleInstanceASServiceLevelProfile-VarSpeedOfASAllocatedVCPUs", 0);
		fakedRepo.put("LargeSingleInstanceASServiceLevelProfile-VarSpeedOfASAllocatedVCPUs", 0);

		fakedRepo.put("SmallSingleInstanceASServiceLevelProfile-VarAmountOfASAllocatedMemory", 0);
		fakedRepo.put("MediumSingleInstanceASServiceLevelProfile-VarAmountOfASAllocatedMemory", 6);
		fakedRepo.put("LargeSingleInstanceASServiceLevelProfile-VarAmountOfASAllocatedMemory", 8);

		fakedRepo.put("SmallSingleInstanceASServiceLevelProfile-VarMaxRequestsPerSecond", 0);
		fakedRepo.put("MediumSingleInstanceASServiceLevelProfile-VarMaxRequestsPerSecond", 1);
		fakedRepo.put("LargeSingleInstanceASServiceLevelProfile-VarMaxRequestsPerSecond", 2);

		//ClusteredASServiceLevelProfile

		fakedRepo.put("SmallClusteredASServiceLevelProfile-VarAmountOfASAllocatedVCPUs", 0);
		fakedRepo.put("MediumClusteredASServiceLevelProfile-VarAmountOfASAllocatedVCPUs", 1);
		fakedRepo.put("LargeClusteredASServiceLevelProfile-VarAmountOfASAllocatedVCPUs", 2);

		fakedRepo.put("SmallClusteredASServiceLevelProfile-VarSpeedOfASAllocatedVCPUs", 0);
		fakedRepo.put("MediumClusteredASServiceLevelProfile-VarSpeedOfASAllocatedVCPUs", 0);
		fakedRepo.put("LargeClusteredASServiceLevelProfile-VarSpeedOfASAllocatedVCPUs", 0);

		fakedRepo.put("SmallClusteredASServiceLevelProfile-VarAmountOfASAllocatedMemory", 0);
		fakedRepo.put("MediumClusteredASServiceLevelProfile-VarAmountOfASAllocatedMemory", 1);
		fakedRepo.put("LargeClusteredASServiceLevelProfile-VarAmountOfASAllocatedMemory", 2);

		fakedRepo.put("SmallClusteredASServiceLevelProfile-VarMaxRequestsPerSecond", 0);
		fakedRepo.put("MediumClusteredASServiceLevelProfile-VarMaxRequestsPerSecond", 1);
		fakedRepo.put("LargeClusteredASServiceLevelProfile-VarMaxRequestsPerSecond", 2);

		fakedRepo.put("SmallClusteredASServiceLevelProfile-VarAmountOfWebBalancingNodes", 2);
		fakedRepo.put("MediumClusteredASServiceLevelProfile-VarAmountOfWebBalancingNodes", 4);
		fakedRepo.put("LargeClusteredASServiceLevelProfile-VarAmountOfWebBalancingNodes", 8);

		//ElasticASServiceLevelProfile

		fakedRepo.put("SmallElasticASServiceLevelProfile-VarAmountOfASAllocatedVCPUs", 0);
		fakedRepo.put("MediumElasticASServiceLevelProfile-VarAmountOfASAllocatedVCPUs", 1);
		fakedRepo.put("LargeElasticASServiceLevelProfile-VarAmountOfASAllocatedVCPUs", 2);

		fakedRepo.put("SmallElasticASServiceLevelProfile-VarSpeedOfASAllocatedVCPUs", 0);
		fakedRepo.put("MediumElasticASServiceLevelProfile-VarSpeedOfASAllocatedVCPUs", 0);
		fakedRepo.put("LargeElasticASServiceLevelProfile-VarSpeedOfASAllocatedVCPUs", 0);

		fakedRepo.put("SmallElasticASServiceLevelProfile-VarAmountOfASAllocatedMemory", 0);
		fakedRepo.put("MediumElasticASServiceLevelProfile-VarAmountOfASAllocatedMemory", 1);
		fakedRepo.put("LargeElasticASServiceLevelProfile-VarAmountOfASAllocatedMemory", 2);

		fakedRepo.put("SmallElasticASServiceLevelProfile-VarMaxRequestsPerSecond", 0);
		fakedRepo.put("MediumElasticASServiceLevelProfile-VarMaxRequestsPerSecond", 1);
		fakedRepo.put("LargeElasticASServiceLevelProfile-VarMaxRequestsPerSecond", 2);

		fakedRepo.put("SmallElasticASServiceLevelProfile-VarAmountOfWebBalancingNodes", 2);
		fakedRepo.put("MediumElasticASServiceLevelProfile-VarAmountOfWebBalancingNodes", 4);
		fakedRepo.put("LargeElasticASServiceLevelProfile-VarAmountOfWebBalancingNodes", 8);

		fakedRepo.put("SmallElasticASServiceLevelProfile-VarASScaleUpFactor", 2);
		fakedRepo.put("MediumElasticASServiceLevelProfile-VarASScaleUpFactor", 4);
		fakedRepo.put("LargeElasticASServiceLevelProfile-VarASScaleUpFactor", 8);

		//MeteredServiceLevelProfile

		fakedRepo.put("SmallMeteredServiceLevelProfile-VarMaxUplinkBandwidth", 0);
		fakedRepo.put("MediumMeteredServiceLevelProfile-VarMaxUplinkBandwidth", 0);
		fakedRepo.put("LargeMeteredServiceLevelProfile-VarMaxUplinkBandwidth", 0);

		fakedRepo.put("SmallMeteredServiceLevelProfile-VarMaxDownlinkBandwidth", 0);
		fakedRepo.put("MediumMeteredServiceLevelProfile-VarMaxDownlinkBandwidth", 1);
		fakedRepo.put("LargeMeteredServiceLevelProfile-VarMaxDownlinkBandwidth", 2);

		fakedRepo.put("SmallMeteredServiceLevelProfile-VarMaxAmountOfTrafficPermitted", 1);
		fakedRepo.put("MediumMeteredServiceLevelProfile-VarMaxAmountOfTrafficPermitted", 3);
		fakedRepo.put("LargeMeteredServiceLevelProfile-VarMaxAmountOfTrafficPermitted", 5);

		//UnmeteredServiceLevelProfile

		fakedRepo.put("SmallUnmeteredServiceLevelProfile-VarMaxUplinkBandwidth", 0);
		fakedRepo.put("MediumUnmeteredServiceLevelProfile-VarMaxUplinkBandwidth", 0);
		fakedRepo.put("LargeUnmeteredServiceLevelProfile-VarMaxUplinkBandwidth", 0);

		fakedRepo.put("SmallUnmeteredServiceLevelProfile-VarMaxDownlinkBandwidth", 0);
		fakedRepo.put("MediumUnmeteredServiceLevelProfile-VarMaxDownlinkBandwidth", 1);
		fakedRepo.put("LargeUnmeteredServiceLevelProfile-VarMaxDownlinkBandwidth", 2);

		//OrbiServiceLevelProfile

		fakedRepo.put("SmallOrbiServiceLevelProfile-VarAmountOfConcurrentUsers", 0);
		fakedRepo.put("MediumOrbiServiceLevelProfile-VarAmountOfConcurrentUsers", 0);
		fakedRepo.put("LargeOrbiServiceLevelProfile-VarAmountOfConcurrentUsers", 0);

		fakedRepo.put("SmallOrbiServiceLevelProfile-VarMaxAmountOfUsers", 0);
		fakedRepo.put("MediumOrbiServiceLevelProfile-VarMaxAmountOfUsers", 0);
		fakedRepo.put("LargeOrbiServiceLevelProfile-VarMaxAmountOfUsers", 0);

		fakedRepo.put("SmallOrbiServiceLevelProfile-VarUpTimePercentage", 0);
		fakedRepo.put("MediumOrbiServiceLevelProfile-VarUpTimePercentage", 0);
		fakedRepo.put("LargeOrbiServiceLevelProfile-VarUpTimePercentage", 0);
		
		
	}
	
	public ServiceAttributeJson(){
		initFake();
	}
	
	@Override
	public List<String> listAttributes(String service){
		return Collections.EMPTY_LIST;
	}
	
	@Override
	public List<String> listCommonAttributes(){
		Set<String> vars = new HashSet<String>();
		for(Object i : JsonRoot.INSTANCE.offerings){
			Map<String, Object> m = (Map<String, Object>) i;
			List<Map<String, Object>> varspace = (List<Map<String, Object>>) m.get(JsonRoot.VariableSpace);
			for(Map<String, Object> var : varspace){
				vars.add(var.get(JsonRoot.VarName).toString());
			}
		}
		return new ArrayList<String>(vars);
	}
	

	
	
	@Override
	public Object get(String service, String attribute){
		Map<String, Object> offering = JsonRoot.INSTANCE.getOffering(service);
		List<Map<String, Object>> varspace = (List<Map<String, Object>>) offering.get(JsonRoot.VariableSpace);
		for(Map<String, Object> var : varspace){
			if(attribute.equals(var.get(JsonRoot.VarName))){
				Object value = var.get(JsonRoot.MaxAcceptableThreshold);
				if(value == null)
					value = var.get(JsonRoot.MinAcceptableThreshold);
				if(value != null)
					return convert(value.toString(), 
							var.get(JsonRoot.VarType).toString(),
							var.get(JsonRoot.VarMeasType).toString());
				
			}		
		}
		return 0;
	}
	
	private int convert(String value, String type, String meas){
		if("Float".equals(type)){
			double d = Double.valueOf(value).doubleValue();
			if(d<1)
				d = d * 10;
			return  Double.valueOf( d ).intValue();
		}
		if("Integer".equals(type) || "Int".equals(type)){
			return Integer.valueOf(value);
		}
		return 0;
	}
}


