package diva.rest.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import diva.Score;
import diva.rest.model.ConfigurationsPool;
import diva.rest.model.DivaRoot;
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
	public Object getRoot(){
		return Arrays.asList("hello", "world");
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

			String combinedId = scId+"-"+profileId;
			DivaRoot root = Repository.mainRoot.fork();
			root.updateOnRequest(scId, profileId);
			Repository.divaRoots.put(combinedId, root);
			root.runSimulation();
			try{
				//This is odd: without this sleep, curl gets a "empty result", even if res is not null
				Thread.sleep(10);
			}catch(Exception e){
				//This sleep seems to be interrupted every time (by whom I don't know).
			}
			List<String> res = root.getConfigurationPool().queryScProfile(scId, profileId);
		
			return res;
	}
	
	/**
	 * curl http://127.0.0.1:8089/fpr/recommendations/sc/hui/profile/001/full
	 * @param scId
	 * @param profileId
	 * @return
	 */
	@Path("sc/{scId}/profile/{profileId}/full")
	@GET
	public Map getRecommListFull(
			@PathParam("scId") String scId, 
			@PathParam("profileId") String profileId
	){
		Map<String, Object> res = new HashMap<String, Object>();
		List<String> lst = this.getRecommList(scId, profileId);
		for(String s : lst){
			res.put(s, getRecommConfig(s));
		}
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
			
			Configuration config = this.getConfigPool(recommId).getConf(recommId);
			for(ConfigVariant cv : config.getVariant()){
				res.add(cv.getVariant().getName());
			}
			res.add("Total Score" + config.getTotalScore());
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
			@PathParam("recommID") String recommId
	){
		try{
			List<String> res = new ArrayList<String>();
			Configuration config = this.getConfigPool(recommId).getConf(recommId);
			res.add("Total: " + String.valueOf(config.getTotalScore()));
			for(Score score : config.getScore()){
				res.add(score.toString());
			}
			return res;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
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
		return this.getConfigPool(recommId).getResponse(recommId);
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
		this.getConfigPool(recommId).setResponse(recommId, "yes".equals(accepted));	
	}
	

	private ConfigurationsPool getConfigPool(String recommId){
		String prefix = recommId.split("--")[0];
		ConfigurationsPool pool = Repository.divaRoots.get(prefix).getConfigurationPool();
		return pool;
	}
	
}
