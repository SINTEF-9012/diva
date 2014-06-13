package diva.rest.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Repository {

	public static DivaRoot mainRoot = null;
	
	public static Map<String, DivaRoot> divaRoots = new HashMap<String, DivaRoot>();
	
	public static List<DivaRoot> historyRoots = new LinkedList<DivaRoot>();
	
	public static void registerRoot(String combinedId, DivaRoot root){
		divaRoots.put(combinedId, root);
		root.setCombinedId(combinedId);
		historyRoots.add(root);
	}
	
}
