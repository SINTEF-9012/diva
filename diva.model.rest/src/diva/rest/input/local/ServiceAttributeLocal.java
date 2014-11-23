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
package diva.rest.input.local;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import diva.rest.input.abstracts.ServiceAttribute;

public class ServiceAttributeLocal extends ServiceAttribute {

	public static ServiceAttributeLocal INSTANCE = new ServiceAttributeLocal();
	
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
		fakedRepo.put("MediumMonolithicDBServiceLevelProfile-VarAmountOfDBAllocatedMemory", 0);
		fakedRepo.put("LargeMonolithicDBServiceLevelProfile-VarAmountOfDBAllocatedMemory", 2);

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
		fakedRepo.put("MediumClusteredDBServiceLevelProfile-VarSpeedOfDBAllocatedVCPUsPerNode", 0);
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

		fakedRepo.put("SmallClusteredDBServiceLevelProfile-VarAmountOfClusterNodes", 1);
		fakedRepo.put("MediumClusteredDBServiceLevelProfile-VarAmountOfClusterNodes", 2);
		fakedRepo.put("LargeClusteredDBServiceLevelProfile-VarAmountOfClusterNodes", 4);

		fakedRepo.put("SmallClusteredDBServiceLevelProfile-VarReplicationRatio", 0);
		fakedRepo.put("MediumClusteredDBServiceLevelProfile-VarReplicationRatio", 0);
		fakedRepo.put("LargeClusteredDBServiceLevelProfile-VarReplicationRatio", 0);

		//ElasticDBServiceLevelProfile

		fakedRepo.put("SmallElasticDBServiceLevelProfile-VarAmountOfDBAllocatedVCPUsPerNode", 0);
		fakedRepo.put("MediumElasticDBServiceLevelProfile-VarAmountOfDBAllocatedVCPUsPerNode", 1);
		fakedRepo.put("LargeElasticDBServiceLevelProfile-VarAmountOfDBAllocatedVCPUsPerNode", 2);

		fakedRepo.put("SmallElasticDBServiceLevelProfile-VarSpeedOfDBAllocatedVCPUsPerNode", 0);
		fakedRepo.put("MediumElasticDBServiceLevelProfile-VarSpeedOfDBAllocatedVCPUsPerNode", 0);
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

		fakedRepo.put("SmallElasticDBServiceLevelProfile-VarAmountOfClusterNodes", 1);
		fakedRepo.put("MediumElasticDBServiceLevelProfile-VarAmountOfClusterNodes", 2);
		fakedRepo.put("LargeElasticDBServiceLevelProfile-VarAmountOfClusterNodes", 4);

		fakedRepo.put("SmallElasticDBServiceLevelProfile-VarDBScaleUpFactor", 1);
		fakedRepo.put("MediumElasticDBServiceLevelProfile-VarDBScaleUpFactor", 1);
		fakedRepo.put("LargeElasticDBServiceLevelProfile-VarDBScaleUpFactor", 2);

		//SingleInstanceASServiceLevelProfile

		fakedRepo.put("SmallSingleInstanceASServiceLevelProfile-VarAmountOfASAllocatedVCPUs", 0);
		fakedRepo.put("MediumSingleInstanceASServiceLevelProfile-VarAmountOfASAllocatedVCPUs", 1);
		fakedRepo.put("LargeSingleInstanceASServiceLevelProfile-VarAmountOfASAllocatedVCPUs", 2);

		fakedRepo.put("SmallSingleInstanceASServiceLevelProfile-VarSpeedOfASAllocatedVCPUs", 0);
		fakedRepo.put("MediumSingleInstanceASServiceLevelProfile-VarSpeedOfASAllocatedVCPUs", 0);
		fakedRepo.put("LargeSingleInstanceASServiceLevelProfile-VarSpeedOfASAllocatedVCPUs", 0);

		fakedRepo.put("SmallSingleInstanceASServiceLevelProfile-VarAmountOfASAllocatedMemory", 0);
		fakedRepo.put("MediumSingleInstanceASServiceLevelProfile-VarAmountOfASAllocatedMemory", 1);
		fakedRepo.put("LargeSingleInstanceASServiceLevelProfile-VarAmountOfASAllocatedMemory", 2);

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

		fakedRepo.put("SmallClusteredASServiceLevelProfile-VarAmountOfWebBalancingNodes", 1);
		fakedRepo.put("MediumClusteredASServiceLevelProfile-VarAmountOfWebBalancingNodes", 2);
		fakedRepo.put("LargeClusteredASServiceLevelProfile-VarAmountOfWebBalancingNodes", 4);

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

		fakedRepo.put("SmallElasticASServiceLevelProfile-VarAmountOfWebBalancingNodes", 1);
		fakedRepo.put("MediumElasticASServiceLevelProfile-VarAmountOfWebBalancingNodes", 2);
		fakedRepo.put("LargeElasticASServiceLevelProfile-VarAmountOfWebBalancingNodes", 4);

		fakedRepo.put("SmallElasticASServiceLevelProfile-VarASScaleUpFactor", 1);
		fakedRepo.put("MediumElasticASServiceLevelProfile-VarASScaleUpFactor", 2);
		fakedRepo.put("LargeElasticASServiceLevelProfile-VarASScaleUpFactor", 3);

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
	
	public ServiceAttributeLocal(){
		initFake();
	}
	
	@Override
	public List<String> listAttributes(String service){
		return Collections.EMPTY_LIST;
	}
	
	@Override
	public List<String> listCommonAttributes(){
		return Arrays.asList(
				"VarMaxDownlinkBandwidth",
				"VarMaxRequestsPerSecond",
				"VarAmountOfDBAllocatedMemory",
				"VarMaxTPSSupported",
				"VarAmountOfDBAllocatedMemoryPerNode",
				"VarAmountOfASAllocatedMemory",
				"VarAmountOfWebBalancingNodes",
				"VarMaxAmountOfUsers",
				"VarSpeedOfDBAllocatedVCPUs",
				"VarAmountOfClusterNodes",
				"VarSpeedOfDBAllocatedVCPUsPerNode",
				"VarMaxUplinkBandwidth",
				"VarSpeedOfASAllocatedVCPUs",
				"VarAmountOfDBAllocatedVCPUsPerNode",
				"VarDBScaleUpFactor",
				"VarAmountOfDBAllocatedVCPUs",
				"VarUpTimePercentage",
				"VarMaxQPSSupported",
				"VarMaxAmountOfTrafficPermitted",
				"VarAmountOfConcurrentUsers",
				"VarAmountOfASAllocatedVCPUs",
				"VarASScaleUpFactor",
				"VarReplicationRatio"
			);
	}
	

	
	
	@Override
	public Object get(String service, String attribute){
		
		if(fakedRepo.containsKey(service+"-"+attribute))
			return fakedRepo.get(service+"-"+attribute);
		else
			return 0;
		
	}
	
	
}


