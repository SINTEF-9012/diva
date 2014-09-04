package diva.rest.input.sparql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import diva.rest.input.ServiceAttribute;

public class ServiceAttributeSparql extends ServiceAttribute {
	
	private static Map<String, List<String>> alias = new HashMap<String, List<String>>();
	private static Map<String, String> literals = new HashMap<String, String>();
	static{
		alias.put("sp:hasAvailability", Arrays.asList("Avail", "Availability", "availability", "hasAvailability"));
		alias.put("gr:hasPriceSpecification", Arrays.asList("Price", "hasPriceSpecification"));
		alias.put("cas:hasMinimumResponseTime", Arrays.asList("minimumResponseTime") );
		literals.put("sp:hasAvailability", "gr:hasValue");
		literals.put("gr:hasPriceSpecification", "gr:hasCurrencyValue");
		literals.put("cas:hasMinimumResponseTime", "gr:hasValue");
	}
	
	@Override
	public List<String> listCommonAttributes(){
		ArrayList<String> result = new ArrayList<String>();
		result.addAll(literals.keySet());
		return result;
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
				"    { "+ s +" " + attr + " ?v\n" +
				"      optional {?v " + literals.get(attr) + " ?value} ." +
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
