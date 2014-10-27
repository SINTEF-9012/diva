package diva.rest.input.rest;

import java.net.URI;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;

public class RestInvoker {
	
	public String uri = "";
	
	public String invoke(){
		try{
			URI uri = new URIBuilder(
						"http://netserv.seerc.org:3030/BrokerAtCloud/query")
	
					.addParameter("output", "json").build();
	
			HttpGet httpget = new HttpGet(uri);
	
			DefaultHttpClient client = new DefaultHttpClient();
			HttpResponse response = client.execute(httpget);
	
			HttpEntity entity = response.getEntity();
	
			String s = IOUtils.toString(entity.getContent());
			
			return s;
		}
		catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
