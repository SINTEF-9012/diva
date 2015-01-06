package diva.rest.resources;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
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
	
	private List<String> allcontexts = Arrays.asList("CpuOLoad", "RamOLoad");
	
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
			
			Map value = (Map)((Map.Entry)entry).getValue();
			String serviceName = value.get("service").toString();
			List<String> cause = (List<String>) value.get("cause");
			
			result = result + "\n" + root.updateFailureLikelihood(serviceName, key);
			for(String s : allcontexts){
				if(cause.contains(s))
					result = result + "\n" + root.updateFailureLikelihood(s, "true");
				else
					result = result + "\n" + root.updateFailureLikelihood(s, "recovered");
				
			}
			
			
		}
		return result;
	}
	
	@GET
	@Path("/cep/ping")
	public String getPing(){
		return "pong";
	}
}
