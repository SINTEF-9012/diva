package diva.rest.resources;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import diva.rest.model.DcSession;

/**
 * The Rest command framework for Dependency checking. 
 * @author Hui Song
 *
 */
@Path("/fpr/dc/")
@Produces(MediaType.APPLICATION_JSON)
public class DependencyChecking {
	
	ObjectMapper mapper = new ObjectMapper();
	
	private static Map<String, DcSession> sessions = new HashMap<String, DcSession>();
	
	/**
	 * curl -X PUT -d "[\"song::hui\", \"morin::brice\"]" http://127.0.0.1:8089/fpr/dc/id
	 * @param requestId
	 * @param services
	 * @return
	 */
	@Path("/{requestId}/")
	@PUT
	public Object putRequest(
			@PathParam("requestId") String requestId,
			String services
		
	){
		try {
			List<String> serviceIds = mapper.readValue(services, new TypeReference<List<String>>() {});
			
			System.out.println(serviceIds.size());
			
			if(sessions.containsKey(requestId))
				return String.format("Request named %s exists", requestId);
			DcSession session = new DcSession(requestId);
			sessions.put(requestId, session);
			session.addServices(serviceIds);
			return session.getMissed();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error: " + e.getMessage();
		}
	}
	
	/**
	 * curl -X POST -d "[\"chauvel::franck\"]" http://127.0.0.1:8089/fpr/dc/id  
	 * @param requestId
	 * @param services
	 * @return
	 */
	@Path("/{requestId}/")
	@POST
	public Object postRequest(
			@PathParam("requestId") String requestId,
			String services
	){
		List<String> serviceIds;
		try {
			serviceIds = mapper.readValue(services, new TypeReference<List<String>>() {});
			DcSession session = sessions.get(requestId);
			session.addServices(serviceIds);
			if(session == null)
				return "request does not exist";
			return session.getMissed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error: " + e.getMessage();
		}
		
	}
	
	/**
	 * curl http://127.0.0.1:8089/fpr/dc/id
	 * @param requestId
	 * @return
	 */
	@Path("/{requestId}")
	@GET
	public Object getRequest(
			@PathParam("requestId") String requestId
	){
		
		try {
			
			DcSession session = sessions.get(requestId);
			if(session == null)
				return "request does not exist";
			return session.getMissed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error: " + e.getMessage();
		}

	}
	
	/**
	 * curl -X DELETE http://127.0.0.1:8089/fpr/dc/id
	 * @param requestId
	 */
	@Path("/{requestId}")
	@DELETE
	public void deleteRequest(
			@PathParam("requestId") String requestId
	){
		sessions.remove(requestId);
	}
}
