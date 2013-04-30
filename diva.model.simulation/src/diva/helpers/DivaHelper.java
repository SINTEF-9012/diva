package diva.helpers;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import diva.VariabilityModel;

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

}
