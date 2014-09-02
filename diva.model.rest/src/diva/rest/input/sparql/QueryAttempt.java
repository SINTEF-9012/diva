package diva.rest.input.sparql;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;

public class QueryAttempt {
	public void testQuery() throws URISyntaxException, ClientProtocolException, IOException{
		String query =
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
	    		"prefix skos:  <http://www.w3.org/2004/02/skos/core#>\n" +
	    		"\n" +
	    		"SELECT ?x ?category ?depends\n" +
	    		"FROM NAMED <http://www.broker-cloud.eu/service-descriptions/CAS>\n" +
	    		"\n" +
	    		"WHERE\n" +
	    		"  {\n" +
	    		"    GRAPH ?src\n" +
	    		"    { ####?x cas:hasFunctionalServiceCategory ?category .\n" +
	    		"      ?x cas:dependsOn ?depends\n" +
	    		"    }\n" +
	    		"  }";
		
		
		URI uri = new URIBuilder("http://netserv.seerc.org:3030/BrokerAtCloud/query")
						.addParameter("query", query)
						.addParameter("output", "json")
						.build();
		
		
		HttpGet httpget = new HttpGet(uri);
		
		DefaultHttpClient client = new DefaultHttpClient();
		HttpResponse  response = client.execute(httpget);
		
		HttpEntity entity = response.getEntity();
		
		
		String s = IOUtils.toString(entity.getContent());
		
		System.out.println(s);
	}
	
	public static void main(String[] args) throws ClientProtocolException, URISyntaxException, IOException{
		System.out.println(new ServiceCategorySparql().getCategories());
	}
}
