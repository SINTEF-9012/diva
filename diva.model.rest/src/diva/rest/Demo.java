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
