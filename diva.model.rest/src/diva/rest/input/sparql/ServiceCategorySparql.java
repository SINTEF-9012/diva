package diva.rest.input.sparql;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import diva.rest.input.local.ServiceCategoryLocal;

public class ServiceCategorySparql extends ServiceCategoryLocal{
	
	public static final String categoryPrefix = "fc";
	
	
	public List<String> getCategories(){
		String q = 
				"SELECT ?category \n" +
				"FROM NAMED <http://www.broker-cloud.eu/service-descriptions/CAS>\n" +
				"\n" +
				"WHERE\n" +
				"  {\n" +
				"    GRAPH ?src\n" +
				"    { ?category rdf:type skos:Concept\n" +
				"    }\n" +
				"  }";
		List<String> result = new ArrayList<String>();
		try{
			Map m = SparqlQuery.INSTANCE.queryToJsonMap(q);
			Map mResults = (Map) m.get("results");
			Collection mBindings = (Collection) mResults.get("bindings");
			for(Object x : mBindings){
				Map mCategory =(Map) ((Map) x).get("category");
				result.add(mCategory.get("value").toString());
			}
		}
		catch(Exception e){
			throw new RuntimeException("Wrong query or result", e);
		}
		return result;
	}
	
	@Override
	public List<String> getServices(String category){
		String cateName = "";
		if(category.startsWith("fc:"))
			cateName = category;
		else if(category.startsWith("http://www.broker-cloud.eu/service-descriptions/CAS/categories#")){
			String name = category.split("#")[1];
			cateName = "fc:" + name;
		}
		else{
			throw new RuntimeException("category name should start with <fc:> or <http://www.broker-cloud.eu/service-descriptions/CAS/categories#");
		}
		
		String q = 
				"SELECT ?service \n" +
				"FROM NAMED <http://www.broker-cloud.eu/service-descriptions/CAS>\n" +
				"\n" +
				"WHERE\n" +
				"  {\n" +
				"    GRAPH ?src\n" +
				"    { ?service cas:hasFunctionalServiceCategory " + cateName + "\n" +
				"    }\n" +
				"  }";
		try{
			Collection mBindings = SparqlQuery.INSTANCE.queryToJsonResults(q);
			ArrayList<String> result = new ArrayList<String>();
			for(Object x : mBindings){
				Map m = (Map) x;
				Map service = (Map)m.get("service");
				result.add(service.get("value").toString()); 
			}
			return result;
		}
		catch(Exception e){
			throw new RuntimeException("Wrong query or results", e);
		}
	}
	
	public static String resolveService(String s){
		String result = s;
		if(s.startsWith("http://www.broker-cloud.eu/service-descriptions/CAS/service-provider#")){
			s = "sp:" + s.split("#")[1];
		}
		else if(s.startsWith("sp:")){
			result = s;
			
		}
		else
			throw new RuntimeException("service name should start with <http://www.broker-cloud.eu/service-descriptions/CAS/service-provider> or <sp:>");
		return result;
	}
	
}
