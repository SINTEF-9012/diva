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

public interface IReasoning {
	
	/**
	 * Simplified interface to a reasoning engine
	 * 
	 * @param model_uri the uri of the diva model
	 * @param context_uri the uri of a diva_context model
	 * @return The uri of a diva_configuration model
	 */
	public String getBestConfigurations(String model_uri, String context_uri);
	
}
