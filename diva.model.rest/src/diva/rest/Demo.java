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
package diva.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.emf.common.util.URI;

import diva.rest.model.DivaRoot;

@Path("fpr/{username: [a-zA-Z]*}")
public class Demo {
	private static int count = 0;
	private static DivaRoot root = null;
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt(@PathParam("username") String user){
		if(root == null){
			root = new DivaRoot(URI.createPlatformResourceURI("org.diva.samples/model/flood/flood.diva"));
		}
		count += 1;
		return "hello " + user + " " + count + " - " + root.getScenarios().iterator().next().getName();
	}
}
