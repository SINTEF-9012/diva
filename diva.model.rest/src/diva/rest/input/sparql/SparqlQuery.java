package diva.rest.input.sparql;

import java.io.IOException;
import java.net.URI;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.core.commands.operations.DefaultOperationHistory;

public class SparqlQuery {
	
	public static SparqlQuery INSTANCE = new SparqlQuery();
	
	
	public String prefixes = 
	        "prefix sp: <http://www.broker-cloud.eu/service-descriptions/CAS/service-provider#> \n" +
    		"prefix fc: <http://www.broker-cloud.eu/service-descriptions/CAS/categories#>   \n" +
    		"prefix cas: <http://www.broker-cloud.eu/service-descriptions/CAS/broker#> \n" +
    		"prefix owl: <http://www.w3.org/2002/07/owl#>  \n" +
    		"prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>  \n" +
    		"prefix xml: <http://www.w3.org/XML/1998/namespace> \n" +
    		"prefix xsd: <http://www.w3.org/2001/XMLSchema#> \n" +
    		"prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n" +
    		"prefix foaf: <http://xmlns.com/foaf/0.1/> \n" +
    		"prefix dcterms: <http://purl.org/dc/terms/>\n" +
    		"prefix usdl-sla: <http://www.linked-usdl.org/ns/usdl-sla#>\n" +
    		"prefix usdl-core: <http://www.linked-usdl.org/ns/usdl-core#>\n" +
    		"prefix s: <http://schema.org/>\n" +
    		"prefix gr: <http://purl.org/goodrelations/v1>\n" +
    		"prefix skos:  <http://www.w3.org/2004/02/skos/core#>";
	
	public String defaultOutput = "Text";
	
	public String server = "http://netserv.seerc.org:3030/BrokerAtCloud/query";
	
	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String query(String query, String output){
		String q = prefixes + "\n" + query;
		
		if(output == null){
			output = defaultOutput;
		}
		
		try{
			URI uri = new URIBuilder(
					"http://netserv.seerc.org:3030/BrokerAtCloud/query")
					.addParameter("query", q).addParameter("output", output)
					.build();


			HttpGet httpget = new HttpGet(uri);
			DefaultHttpClient client = new DefaultHttpClient();
			HttpResponse  response = client.execute(httpget);
	
			HttpEntity entity = response.getEntity();

			String s = IOUtils.toString(entity.getContent());
			
			return s;
		}
		catch(Exception e){
			throw new RuntimeException( "Query Server Problem", e);
		}
	}
	
	public Map queryToJsonMap(String query) throws JsonParseException, JsonMappingException, IOException{
		 String s = query(query, "json");
		 
		 System.out.println(s);
		 
		 ObjectMapper mapper = new ObjectMapper();
		 
		 return mapper.readValue(s, Map.class);
		 
		
	}
	
	public Collection queryToJsonResults(String query) throws JsonParseException, JsonMappingException, IOException{
		Map m = queryToJsonMap(query);
		Map mResults = (Map) m.get("results");
		Collection mBindings = (Collection) mResults.get("bindings");
		return mBindings;
	}

}
