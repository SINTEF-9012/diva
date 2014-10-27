package diva.rest.resources;

import java.io.IOException;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import diva.Dimension;
import diva.rest.model.DivaRoot;
import diva.rest.model.Repository;

@Path("subscriptions/")
@Produces(MediaType.APPLICATION_JSON)
public class PubSub {
	private final String cepId = "fprcep";
	
	@POST
	@Path("/cep/"+cepId)
	public Object cepEvent(String event){
		ObjectMapper mapper = new ObjectMapper();
		Object e;
		try {
			e = mapper.readValue(event, Map.class);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "Wrong event format";
		}
		DivaRoot root = Repository.mainRoot;
		String result = "results:";
		for(Object entry : ((Map)e).entrySet()){
			
			String key = ((Map.Entry)entry).getKey().toString();
			String value = ((Map.Entry)entry).getValue().toString();
			result = result + "\n" + root.updateFailureLikelihood(key, value);
			
		}
		return result;
	}
	
	@GET
	@Path("/cep/ping")
	public String getPing(){
		return "pong";
	}
}
