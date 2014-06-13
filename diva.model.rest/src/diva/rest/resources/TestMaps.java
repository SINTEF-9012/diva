package diva.rest.resources;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestMaps {
	
	public static void main(String[] args){
		Map<String, String> testMap = new LinkedHashMap<String, String>();
		
		testMap.put("fse", "fse");
		testMap.put("bbc", "bbc");
		testMap.put("add", "add");
		testMap.put("mbc", "mbc");
		testMap.put("eff", "eff");
		
		System.out.println(testMap.keySet());
	}

}
