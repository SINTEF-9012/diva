package diva.rest.input.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.MappingJsonFactory;

import diva.rest.input.abstracts.ServiceCategory;

public class JsonRoot {
	
	public static final String OfferingName = "OfferingName";
	public static final String ServiceProvider = "ServiceProvider";
	public static final String ServiceLevelProfile = "ServiceLevelProfile";
	public static final String VariableSpace = "VariableSpace";
	public static final String VarName = "VarName";
	public static final String MinAcceptableThreshold = "MinAcceptableThreshold";
	public static final String MaxAcceptableThreshold = "MaxAcceptableThreshold";
	public static final String VarType = "VarType";
	public static final String VarMeasType = "VarMeasType";
	
	
	
	
	public static JsonRoot INSTANCE = new JsonRoot();
	public List offerings = null;
	
	public JsonRoot(){
		try {
			JsonParser jsonParser = new MappingJsonFactory().createJsonParser(new File("./orbi.json"));
			this.offerings = jsonParser.readValueAs(ArrayList.class);
			
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
		System.out.println(INSTANCE.offerings);
		ServiceCategory sc = new ServiceCategoryJson();
		System.out.println(sc.getCategories());
		System.out.println(sc.getServices("OrbiServiceLevelProfile"));
		System.out.println(sc.getServices("SomethingElse"));

	}
	
	public Map<String,Object> getOffering(String name){
		for(Object i : offerings){
			Map<String, Object> map = (Map<String, Object>) i;
			if(name.equals(map.get(JsonRoot.OfferingName)))
				return map;
		}
		return null;
	}

}
