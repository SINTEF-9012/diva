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
package diva.reasoning;

import java.io.File;

import diva.DivaFactory;
import diva.SimulationModel;
import diva.VariabilityModel;
import diva.helpers.DivaHelper;

public class Reasoner {
	
	public static void clean(VariabilityModel model) {
		model.clean();		
	}

	public static void clean(String file_uri) {
		System.out.println("Launching DiVA Simulator on file : " + file_uri + "...");
		long start = System.currentTimeMillis();
		
		
		try {				
			VariabilityModel model = DivaHelper.load(new File(file_uri));
			clean(model);
			DivaHelper.save(model, file_uri);

			System.out.println("Execution terminated successfully. Took: " + (System.currentTimeMillis() - start) + " ms");			
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public static void createExhaustiveSimulation(VariabilityModel model) {
		if (model.getSimulation() != null) {
			SimulationModel sim = DivaFactory.eINSTANCE.createSimulationModel();
			model.setSimulation(sim);
			model.getSimulation().createExhaustiveSimulation();
		}		
	}
	
	public static void createExhaustiveSimulation(String file_uri) {
		System.out.println("Launching DiVA Simulator on file : " + file_uri + "...");
		long start = System.currentTimeMillis();
		
		try {			
				
			VariabilityModel model = DivaHelper.load(new File(file_uri));
			
			createExhaustiveSimulation(model);
			
			DivaHelper.save(model, file_uri);
			
			System.out.println("Execution terminated successfully. Took: " + (System.currentTimeMillis() - start) + " ms");	
			
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public static void exportAdaptationStateMachine(VariabilityModel model, String file_uri) {
		DivaHelper.toThingML(model, file_uri + ".thingml");
	}
	
	public static void exportAdaptationStateMachine(String file_uri) {
		System.out.println("Launching DiVA Simulator on file : " + file_uri + "...\n\n");
		
		try {				
			VariabilityModel model = DivaHelper.load(new File(file_uri));
		   
			exportAdaptationStateMachine(model, file_uri);
			
			System.out.println("\n\nExecution terminated successfully.");			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public static void populateCompleteSimulation(VariabilityModel model) {
		if (model.getSimulation() != null) {
			DivaHelper.computeSuitableConfigurations(model, 0);
			model.getSimulation().populatePriorities();
			model.getSimulation().populateScores();
			model.getSimulation().populateVerdicts();
		}		
	}
	
	public static void populateCompleteSimulation(String file_uri) {
		System.out.println("Launching DiVA Simulator on file : " + file_uri + "...");
		long start = System.currentTimeMillis();
		
		try {			
				
			VariabilityModel model = DivaHelper.load(new File(file_uri));
			
			populateCompleteSimulation(model);
			
			DivaHelper.save(model, file_uri);
			
			System.out.println("Execution terminated successfully. Took: " + (System.currentTimeMillis() - start) + " ms");	
			
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public static void populatePriorities(VariabilityModel model) {
		if (model.getSimulation() != null)
			model.getSimulation().populatePriorities();		
	}
	
	public static void populatePriorities(String file_uri) {
		System.out.println("Launching DiVA Simulator on file : " + file_uri + "...");
		long start = System.currentTimeMillis();
		
		try {			
				
			VariabilityModel model = DivaHelper.load(new File(file_uri));
			
			populatePriorities(model);
			
			DivaHelper.save(model, file_uri);
			
			System.out.println("Execution terminated successfully. Took: " + (System.currentTimeMillis() - start) + " ms");	
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public static void populateScores(VariabilityModel model) {
		if (model.getSimulation() != null)
			model.getSimulation().populateScores();
				
	}
	
	public static void populateScores(String file_uri) {
		System.out.println("Launching DiVA Simulator on file : " + file_uri + "...");
		long start = System.currentTimeMillis();
		
		try {			
				
			VariabilityModel model = DivaHelper.load(new File(file_uri));
			
			populateScores(model);

			DivaHelper.save(model, file_uri);
			
			System.out.println("Execution terminated successfully. Took: " + (System.currentTimeMillis() - start) + " ms");			
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public static void populateValidConfigurations(VariabilityModel model) {
		DivaHelper.computeSuitableConfigurations(model, 0);
	}
	
	public static void populateValidConfigurations(String file_uri) {
		System.out.println("Launching DiVA Simulator on file : " + file_uri + "...");
		long start = System.currentTimeMillis();

		try {			

			VariabilityModel model = DivaHelper.load(new File(file_uri));

			populateValidConfigurations(model);
			

			DivaHelper.save(model, file_uri);

			System.out.println("Execution terminated successfully. Took: " + (System.currentTimeMillis() - start) + " ms");

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public static void populateVerdicts(VariabilityModel model) {
		if (model.getSimulation() != null)
			model.getSimulation().populateVerdicts();		
	}
	
	public static void populateVerdicts(String file_uri) {
		System.out.println("Launching DiVA Simulator on file : " + file_uri + "...");
		long start = System.currentTimeMillis();
		
		try {			
		    
			VariabilityModel model = DivaHelper.load(new File(file_uri));
			
			populateVerdicts(model);
			
			DivaHelper.save(model, file_uri);
			
			System.out.println("Execution terminated successfully. Took: " + (System.currentTimeMillis() - start) + " ms");	
			
			
		} catch (Throwable e) {
			e.printStackTrace();
		}		
	}
	
	public static void printAlloySpecs(String file_uri) {
		StringBuilder builder = new StringBuilder();
		model.toAlloy(builder);
		System.out.println(builder.toString());		
	}

		
	
	public static void printAlloySpecs(String file_uri) {
		System.out.println("Launching DiVA Simulator on file : " + file_uri.getLocation().toOSString() + "...\n\n");
		
		try {			
				
			VariabilityModel model = DivaHelper.load(new File(file_uri));
		    			
			printAlloySpecs(file_uri);
			
			System.out.println("\n\nExecution terminated successfully.");
			
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
}
