package diva.rest.input.sparql;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import diva.rest.input.ServiceCategory;

public class ServiceCategorySparql extends ServiceCategory{
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
			throw new RuntimeException("Wrong result", e);
		}
		return result;
	}
}
