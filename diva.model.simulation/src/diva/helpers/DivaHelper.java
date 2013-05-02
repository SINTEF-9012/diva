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
import java.util.concurrent.ExecutorCompletionService;
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
		ExecutorCompletionService<Entry<Context, List<Configuration>>> ecs = new ExecutorCompletionService<Entry<Context, List<Configuration>>>(executor);
		//List<Future<Entry<Context, List<Configuration>>>> results = new ArrayList<Future<Entry<Context, List<Configuration>>>>();
		
		for(Scenario scn : model.getSimulation().getScenario()) {
			for(Context ctx : scn.getContext()) {	
				if(ctx.getConfiguration().size() == 0) {//to enable incremental checking
					Callable<Entry<Context, List<Configuration>>> worker = new AlloyWrapper(model2Alloy, ctx, new  HashMap<>(variants));
					/*results.add(*/ecs.submit(worker)/*)*/;
				}
			}
		}
		executor.shutdown();

		/*try {
			while(!executor.isTerminated()) {
				Thread.currentThread().sleep(250);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		try {
			int i = 0;
			while (i < size) {
				Future<Entry<Context, List<Configuration>>> entry = ecs.poll();
				while(entry != null) {
					Context ctx = entry.get().getKey();
					try {
						ctx.getConfiguration().addAll(entry.get().getValue());
					} catch (InterruptedException | ExecutionException e) {
						e.printStackTrace();
					}
					entry = ecs.poll();
					i++;
				}
				String tempPath = File.createTempFile("PartialSimulation", ".diva").getAbsolutePath();
				DivaHelper.save(model, tempPath);
				System.out.println("Partial Simulation stored: " + tempPath);
				Thread.currentThread().sleep(250);
			}
		} catch (InterruptedException | IOException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
