package diva.rest.input.abstracts;

import java.util.List;

import diva.rest.input.local.ServiceAttributeLocal;

public abstract class ServiceAttribute {
	
	public static ServiceAttribute INSTANCE = new ServiceAttributeLocal();

	public ServiceAttribute() {
		super();
	}

	public abstract Object get(String service, String attribute);

	public abstract List<String> listCommonAttributes();

	public abstract List<String> listAttributes(String service);

}