package diva.reasoning;

public interface IReasoning {
	
	/**
	 * Simplified interface to a reasoning engine
	 * 
	 * @param model_uri the uri of the diva model
	 * @param context_uri the uri of a diva_context model
	 * @return The uri of a diva_configuration model
	 */
	public String getBestConfigurations(String model_uri, String context_uri);
	
}
