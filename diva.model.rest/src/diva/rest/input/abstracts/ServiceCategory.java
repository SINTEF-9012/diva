package diva.rest.input.abstracts;

import java.util.List;

import diva.rest.input.local.ServiceCategoryLocal;

public abstract class ServiceCategory {

	public static ServiceCategory INSTANCE = new ServiceCategoryLocal();
	
	public ServiceCategory() {
		super();
	}

	public abstract List<String> getServices(String category);

	public abstract List<String> getCategories();
	
	public abstract List<String> getGroup(String service);

}