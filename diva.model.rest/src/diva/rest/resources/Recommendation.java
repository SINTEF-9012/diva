package diva.rest.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
import diva.rest.input.local.ConsumerProfileLocal;
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
	 * curl http://127.0.0.1:8089/fpr/recommendations/sc/abc/profile/001
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
			Repository.registerRoot(combinedId, root);
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
	 * curl http://127.0.0.1:8089/fpr/recommendations/sc/abc/profile/001/full
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
		Map<String, Object> res = new TreeMap<String, Object>();
		List<String> lst = this.getRecommList(scId, profileId);
		for(String s : lst){
			res.put(s, getRecommConfig(s));
		}
		return res;
	}
	
	/**
	 * curl http://127.0.0.1:8089/fpr/recommendations/sc/abc/profile/001/provider
	 * @param scId
	 * @param profileId
	 * @return
	 */
	@Path("sc/{scId}/profile/{profileId}/provider")
	@GET
	public Object getRecommListForProvider(
			@PathParam("scId") String scId, 
			@PathParam("profileId") String profileId
	){
		try{
		Map<String, Object> res = new TreeMap<String, Object>();

		String combinedId = scId+"-"+profileId;
		DivaRoot root = Repository.mainRoot.fork();
		root.updateOnRequest(scId, profileId);
		Repository.registerRoot(combinedId, root);
		root.runSimulation(true);
		try{
			//This is odd: without this sleep, curl gets a "empty result", even if res is not null
			Thread.sleep(10);
		}catch(Exception e){
			//This sleep seems to be interrupted every time (by whom I don't know).
		}
		List<String> lst = root.getConfigurationPool().queryScProfile(scId, profileId);

		for(String s : lst){
			res.put(s, getRecommConfig(s));
		}
		return res;
		}
		catch(Exception e){
			e.printStackTrace();
			return "wrong";
		}
	}
	
	/*
	 * curl http://127.0.0.1:8089/fpr/recommendations/abc-001--0/config
	 * This query should be invoked after one {@link #getRecommList} invocation, otherwise
	 * there is no "abc-001--0" id.
	 * 
	 */
	@Path("{recommId}/config")
	@GET
	public Object getRecommConfig(
			@PathParam("recommId") String recommId
	){
		try{
			List<String> res = new ArrayList<String>();
			
			ConfigurationsPool pool = this.getConfigPool(recommId);
			
			Collection<String> configured = pool.getConfNames(recommId);
			Collection<String> used = ConsumerProfileLocal.INSTANCE.getCurrentServices(this.getUserProfileId(recommId));
			
			Set<String> toAdd = new HashSet<String>(configured);
			Set<String> toRemove = new HashSet<String>(used);
			
			toAdd.removeAll(used);
			toRemove.removeAll(configured);
			
			for(String s : toAdd){
				res.add("+" + s);
			}
			
			for(String s : toRemove){
				res.add("-" + s);
			}
			
			res.add("Score: "+pool.getConf(recommId).getTotalScore());
			pool.addQueriedString(recommId+" - "+res.toString());
			
			
			return res;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * curl http://127.0.0.1:8089/fpr/recommendations/abc-001--0/reason
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
	 * curl http://127.0.0.1:8089/fpr/recommendations/abc-001--0/response
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
	 * curl -X PUT -d "yes" http://127.0.0.1:8089/fpr/recommendations/abc-001--0/response
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
	
	@Path("history")
	@GET
	public Object getHistory(){
		List<Object> res = new LinkedList<Object>();
		
		for(DivaRoot root : Repository.historyRoots){
		
			Map<String, Object> item = new LinkedHashMap<String, Object>();
		
			item.put("request", root.getCombinedId());
			List<String> configs = new LinkedList<String>();
			ConfigurationsPool pool = root.getConfigurationPool();
			for(String id : pool.listAllQueried()){
				configs.add(id);
			}
			
			item.put("configs", configs);
			item.put("time", root.getTimeQueried().toLocaleString());
			item.put("responses", pool.getFullResponseRepr());
			
			res.add(item);
		}
		
		return res;
	}
	

	private ConfigurationsPool getConfigPool(String recommId){
		String prefix = getUserProfileId(recommId);
		ConfigurationsPool pool = Repository.divaRoots.get(prefix).getConfigurationPool();
		return pool;
	}
	
	private String getUserProfileId(String recommId){
		return recommId.split("--")[0];
	}
	
}
