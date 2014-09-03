package diva.rest.input.sparql;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import diva.rest.input.ServiceAttribute;

public class ServiceAttributeSparql extends ServiceAttribute {
	
	private static Map<String, List<String>> alias = new HashMap<String, List<String>>();
	
	static{
		alias.put("sp:hasAvailability", Arrays.asList("Avail", "Availability", "availability", "hasAvailability"));
	}
	
	@Override
	public List<String> listCommonAttributes(){
		return Arrays.asList("sp:hasAvailability");
	}
	
	public Object get(String service, String attribute){
		String attr = attribute;
		for(Map.Entry<String,List<String>> entry : alias.entrySet()){
			if(entry.getValue().contains(attribute))
				attr = entry.getKey();
		}
		
		String s = ServiceCategorySparql.resolveService(service);
		
		String q = 
				"SELECT ?value \n" +
				"FROM NAMED <http://www.broker-cloud.eu/service-descriptions/CAS>\n" +
				"\n" +
				"WHERE\n" +
				"  {\n" +
				"    GRAPH ?src\n" +
				"    { "+ s +" sp:hasAvailability ?v\n" +
				"      optional {?v gr:hasValue ?value} ." +
				"    }\n" +
				"  }";
		try{ 
			Collection r = SparqlQuery.INSTANCE.queryToJsonResults(q);
			return ((Map)((Map)r.iterator().next()).get("value")).get("value");
		}
		catch(Exception e){
			throw new RuntimeException("Query or result not valid", e);
		}
		
	}
	

}
