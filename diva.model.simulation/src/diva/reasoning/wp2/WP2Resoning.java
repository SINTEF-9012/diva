package diva.reasoning.wp2;

import diva.reasoning.IReasoning;
/*import org.kermeta.core.helper.JarHelper;
import org.kermeta.interpreter.api.InitializationError;
import org.kermeta.interpreter.api.Interpreter;
import org.kermeta.interpreter.api.InterpreterMode;
import org.kermeta.interpreter.api.RunCommandLine;
import org.kermeta.interpreter.helper.KermetaLauncher;
//import org.kermeta.io.loader.Loader;
import org.kermeta.io.plugin.IOPlugin;*/
/*import fr.irisa.triskell.eclipse.console.LocalIOConsole;
import fr.irisa.triskell.kermeta.exceptions.NotRegisteredURIException;
import fr.irisa.triskell.kermeta.exceptions.URIMalformedException;
import fr.irisa.triskell.kermeta.modelhelper.ModelingUnitHelper;
import fr.irisa.triskell.kermeta.runtime.basetypes.StdIO;
import fr.irisa.triskell.kermeta.runtime.loader.emf.LoaderJob;
import fr.irisa.triskell.kermeta.typechecker.KermetaTypeChecker;*/

public class WP2Resoning implements IReasoning {

	public static String DIVA_KERMETA_CODE = "platform:/plugin/kermeta/WP2Reasoner.kmt";
	
	public String getBestConfigurations(String modelUri, String contextUri) {
		
		String result = null;
		
/*		try {
			
			URL jarURL = JarHelper.locateContainerJar(KermetaTypeChecker.class);
	    	if(jarURL != null && jarURL.toString().endsWith(".jar")){
	    		//internalLog.debug(" option -K NOT seen. Trying jar protocol with " + jarURL.toExternalForm());
		    	String kermetaStandardURI = "jar:" + jarURL.toExternalForm() + "!/src/kermeta/framework.km";
		    	IOPlugin.FRAMEWORK_KM_URI = kermetaStandardURI;
	    	}
	    	
	    	jarURL = JarHelper.locateContainerJar(LoaderJob.class);
	    	if(jarURL != null && jarURL.toString().endsWith(".jar")){
		    	
		    	String kconfLocation = "jar:" + jarURL.toExternalForm() + "!/instances/";
				URIConverterImpl.URI_MAP.put(URI.createURI("kconf:/loader/"), URI.createURI(kconfLocation));
				
	    	}
	    	
	    	jarURL = JarHelper.locateContainerJar(WP2Resoning.class);
	    	
	    	if(jarURL != null && jarURL.toString().endsWith(".jar")){
	    		String rootlocation = "jar:" + jarURL.toExternalForm() + "!/";
	    		System.out.println("rootlocation = " + rootlocation);
	    		URIConverterImpl.URI_MAP.put(URI.createURI("platform:/plugin/"), URI.createURI(rootlocation));
				URIConverterImpl.URI_MAP.put(URI.createURI("platform:/resource/"), URI.createURI(rootlocation));
	    	}
	    	else {
	    		URIConverterImpl.URI_MAP.put(URI.createURI("platform:/plugin/"), URI.createURI("file:///opt/eclipses/eclipse-modeling-galileo-incubation-linux-gtk-x86_64-DIVA_dev/workspace/"));
				URIConverterImpl.URI_MAP.put(URI.createURI("platform:/resource/"), URI.createURI("file:///opt/eclipses/eclipse-modeling-galileo-incubation-linux-gtk-x86_64-DIVA_dev/workspace/"));
	    	}
			
			Interpreter interpreter = new Interpreter(DIVA_KERMETA_CODE, InterpreterMode.RUN, null);
			interpreter.setStreams(new LocalIOConsole());		
			interpreter.setEntryPoint("diva::WP2Reasoner", "getBestConfigurations");
			String[] parameters = new String[2];
			parameters[0] = modelUri;
			parameters[1] = contextUri;
			interpreter.setParameters(parameters);

			
			result = fr.irisa.triskell.kermeta.runtime.basetypes.String.getValue(interpreter.launch());
		} catch (NotRegisteredURIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URIMalformedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InitializationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/	
		return result;

	}
	
	public static void main(String[] args) {
		String modelURI = "file:///opt/eclipses/eclipse-modeling-galileo-incubation-linux-gtk-x86_64-DIVA_dev/workspace/eu.ict_diva.study.CAS/design/scenario1.diva";
		String ctxURI = "file:///opt/eclipses/eclipse-modeling-galileo-incubation-linux-gtk-x86_64-DIVA_dev/workspace/diva.model/test/context.xmi";
		
		IReasoning r = new WP2Resoning();
		r.getBestConfigurations(modelURI, ctxURI);
	}

}
