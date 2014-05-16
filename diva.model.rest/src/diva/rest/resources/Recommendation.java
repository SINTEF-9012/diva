package diva.rest.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import diva.ConfigVariant;
import diva.Configuration;
import diva.rest.model.Repository;

/**
 * 
 * @author Hui Song
 *
 */
@Path("fpr/recommendations/")
@Produces(MediaType.APPLICATION_JSON)
public class Recommendation {
	@GET
	public String getRoot(){
		return "hello";
	}
	
	/**
	 * curl http://127.0.0.1:8089/fpr/recommendations/sc/hui/profile/001
	 * 
	 * @param scId
	 * @param profileId
	 * @return
	 */
	@Path("sc/{scId}/profile/{profileId}/")
	@GET
	public List<String> getRecommList(
			@PathParam("scId") String scId, 
			@PathParam("profileId") String profileId
	){
		List<String> res = Repository.configPool.queryScProfile(scId, profileId);
		//GenericEntity<List<String>> entity = new GenericEntity<List<String>>(res){};
		//return Response.ok(entity).build();
		return res;
	}
	
	/*
	 * curl http://127.0.0.1:8089/fpr/recommendations/hui-001-0/config
	 * This query should be invoked after one {@link #getRecommList} invocation, otherwise
	 * there is no "hui-001-0" id.
	 * 
	 */
	@Path("{recommId}/config")
	@GET
	public Object getRecommConfig(
			@PathParam("recommId") String recommId
	){
		try{
			List<String> res = new ArrayList<String>();
			for(ConfigVariant cv : Repository.configPool.getConf(recommId).getVariant()){
				res.add(cv.getVariant().getName());
			}
			return res;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * curl http://127.0.0.1:8089/fpr/recommendations/hui-001-0/reason
	 * @param recommId
	 * @return
	 */
	@Path("{recommID}/reason")
	@GET
	public Object getRecommReason(
			@PathParam("recommId") String recommId
	){
		return "I don't know how to express the rationale yet";
	}
	
	/**
	 * curl http://127.0.0.1:8089/fpr/recommendations/hui-001-0/response
	 * 
	 * @param recommId
	 * @return
	 */
	@Path("{recommID}/response")
	@GET
	public Object getResponse(
			@PathParam("recommID") String recommId
	){
		System.out.println("here " + "recommID");
		return Repository.configPool.getResponse(recommId);
	}
	
	/**
	 * curl -X PUT -d "yes" http://127.0.0.1:8089/fpr/recommendations/hui-001-0/response
	 * @param recommId
	 * @param accepted
	 */
	@Path("{recommID}/response/")
	@PUT
	public void putResponse(
			@PathParam("recommID") String recommId,
			String accepted
	){
		System.out.println("here "+recommId+accepted);
		Repository.configPool.setResponse(recommId, "yes".equals(accepted));	
	}
}
