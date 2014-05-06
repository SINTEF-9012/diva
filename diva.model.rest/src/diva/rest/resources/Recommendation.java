package diva.rest.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import diva.Configuration;
import diva.rest.model.Repository;

@Path("fpr/recommendations/")
@Produces(MediaType.APPLICATION_JSON)
public class Recommendation {
	@GET
	public String getRoot(){
		return "hello";
	}
	
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
	
	@Path("{recommId}/config")
	@GET
	public Object getRecommConfig(
			@PathParam("recommId") String recommId
	){
		try{
			return Repository.configPool.getConf(recommId).getTotalScore();
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
}
