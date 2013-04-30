package diva.helpers;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import diva.Configuration;
import diva.Context;
import diva.Dimension;
import diva.DivaFactory;
import diva.VariabilityModel;
import diva.VariableValue;
import diva.Variant;
import diva.alloy.AlloyWrapper;
import edu.mit.csail.sdg.alloy4.Err;

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

	public static Set<Configuration> computeSuitableConfigurations(Context ctx, VariabilityModel model) {
		Set<Configuration> result = new HashSet<Configuration>();
		ctx.getConfiguration().clear();

		StringBuilder builder = new StringBuilder();
		model.toAlloy(builder);
		final String model2Alloy = builder.toString();

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

		try {
			String alloyResult = AlloyWrapper.computeConfigurations(model2Alloy, context);
			
			System.out.println(alloyResult);
			
			for(String solution : alloyResult.split("\n")) {
				
				System.out.println("Solution: " + solution);
				
				Configuration nc = DivaFactory.eINSTANCE.createConfiguration();
				for(String atom : solution.split(" ")) {
					for(Dimension d : model.getDimension()) {
						for(Variant v : d.getVariant()) {
							if(atom.equals(v.getId())) {
								nc.addVariant(v);
							}
						}
					}
				}
				if (nc.getVariant().size() > 0) {
					ctx.getConfiguration().add(nc);
					result.add(nc);//TODO: check if that is really useful to return a result since we modify the current model...
				}
			}
		} catch (Err e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

}
