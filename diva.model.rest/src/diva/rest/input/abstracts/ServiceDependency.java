package diva.rest.input.abstracts;

import java.util.List;

import diva.rest.input.local.ServiceDependencyLocal;

public abstract class ServiceDependency {
	
	public static ServiceDependency INSTANCE = new ServiceDependencyLocal();

	public ServiceDependency() {
		super();
	}

	public abstract List<String> getDependency(String srv);

}