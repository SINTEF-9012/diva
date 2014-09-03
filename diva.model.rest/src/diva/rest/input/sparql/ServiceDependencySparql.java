package diva.rest.input.sparql;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import diva.rest.input.ServiceDependency;

public class ServiceDependencySparql extends ServiceDependency {
	@Override
	public List<String> getDependency(String srv){
		String service = ServiceCategorySparql.resolveService(srv);
		
		String q = 
				"SELECT ?dependency \n" +
				"FROM NAMED <http://www.broker-cloud.eu/service-descriptions/CAS>\n" +
				"\n" +
				"WHERE\n" +
				"  {\n" +
				"    GRAPH ?src\n" +
				"    { " + service + " cas:dependsOn ?dependency \n" +
				"    }\n" +
				"  }";
		try{
			Collection mBindings = SparqlQuery.INSTANCE.queryToJsonResults(q);
			ArrayList<String> result = new ArrayList<String>();
			for(Object x : mBindings){
				Map m = (Map) x;
				Map dep = (Map)m.get("dependency");
				result.add(dep.get("value").toString()); 
			}
			return result;
		}
		catch(Exception e){
			throw new RuntimeException("Wrong query or results", e);
		}
	}
}
