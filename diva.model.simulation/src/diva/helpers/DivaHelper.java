package diva.helpers;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import diva.Configuration;
import diva.Context;
import diva.Dimension;
import diva.Scenario;
import diva.VariabilityModel;
import diva.VariableValue;
import diva.Variant;
import diva.alloy.AlloyWrapper;

public class DivaHelper {

	public static VariabilityModel load(File file) {
		ResourceSet rs = new ResourceSetImpl();
		URI xmiuri = URI.createFileURI(file.getAbsolutePath());
		Resource model = rs.createResource(xmiuri);
		try {
			model.load(null);
			return (VariabilityModel) model.getContents().get(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void save(VariabilityModel model, String uri) {
		// Create a resource set.
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the default resource factory -- only needed for stand-alone!
		// this tells EMF to use XML to save the model
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		// Get the URI of the model file.
		URI fileURI = URI.createFileURI(new File(uri).getAbsolutePath());

		// Create a resource for this file.
		Resource resource = resourceSet.createResource(fileURI);

		// Add the model objects to the contents.
		resource.getContents().add(model);

		// Save the contents of the resource to the file system.
		try
		{
			resource.save(Collections.EMPTY_MAP); // the map can pass special saving options to the operation
		} catch (IOException e) {
			e.printStackTrace();
			/* error handling */
		}
	}

	public static void computeSuitableConfigurations(VariabilityModel model) {

		Map<String, Variant> variants = new HashMap<String, Variant>();
		for(Dimension d : model.getDimension()) {
			for(Variant v : d.getVariant()) {
				variants.put(v.getId(), v);
			}
		}
		
		StringBuilder builder = new StringBuilder();
		model.toAlloy(builder);
		final String model2Alloy = builder.toString();

		int size = 0;
		for(Scenario scn : model.getSimulation().getScenario()) {
			size += scn.getContext().size();
		}
		//System.out.println("#cpu: " + Runtime.getRuntime().availableProcessors());
		ExecutorService executor = Executors.newFixedThreadPool(Math.min(Runtime.getRuntime().availableProcessors(), size));
		Map<Context, Future<List<Configuration>>> results = Collections.synchronizedMap(new HashMap<Context, Future<List<Configuration>>>());

		for(Scenario scn : model.getSimulation().getScenario()) {
			for(Context ctx : scn.getContext()) {
				ctx.getConfiguration().clear();
				String context = "";
				int i = 0;
				for(VariableValue v : ctx.getVariable()) {
					if (i > 0)
						context += " and ";
					StringBuilder b = new StringBuilder();
					v.toAlloy(b);
					context += b.toString();
					i++;
				}
				Callable<List<Configuration>> worker = new AlloyWrapper(model2Alloy, context, new  HashMap<>(variants));
				results.put(ctx, executor.submit(worker));
			}
		}
		executor.shutdown();
		while(!executor.isTerminated()) {
			//wait
		}

		for(Entry<Context, Future<List<Configuration>>> entry : results.entrySet()) {
			Context ctx = entry.getKey();
			try {
				ctx.getConfiguration().addAll(entry.getValue().get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		} 

	}

}
