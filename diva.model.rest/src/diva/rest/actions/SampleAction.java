package diva.rest.actions;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.jface.dialogs.MessageDialog;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import diva.rest.Demo;
import diva.rest.model.ConfigurationsPool;
import diva.rest.model.DivaRoot;
import diva.rest.model.Repository;
import diva.rest.resources.DependencyChecking;
import diva.rest.resources.Recommendation;

/**
 * Our sample action implements workbench action delegate.
 * The action proxy will be created by the workbench and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be 
 * delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class SampleAction implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;
	/**
	 * The constructor.
	 */
	public SampleAction() {
	}

	/**
	 * The action has been activated. The argument of the
	 * method represents the 'real' action sitting
	 * in the workbench UI.
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) {
		
		//load a diva model
		Repository.mainRoot = new DivaRoot(
					org.eclipse.emf.common.util.URI
						.createPlatformResourceURI("org.diva.samples/model/broker/Broker.diva")
				);
//		Repository.configPool = new ConfigurationsPool(
//					Repository.mainRoot.getScenarios().iterator().next().getContext().get(0)
//				);
		
		
		URI uri = UriBuilder.fromUri("http://0.0.0.0/").port(8089).build();
		ResourceConfig resourceConfig = new ResourceConfig(Demo.class);
		resourceConfig.register(Recommendation.class);
		resourceConfig.register(DependencyChecking.class);
		resourceConfig.register(JacksonJsonProvider.class);  //Using Jackson for JSON wrapping
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri,resourceConfig);
		try {
			server.start();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		new Thread(){
			@Override
			public void run(){
				while(true){
					Repository.mainRoot.updateModel();
//					Repository.mainRoot.runSimulation();
//					Repository.configPool = new ConfigurationsPool(
//							Repository.mainRoot.getScenarios().iterator().next().getContext().get(0)
//						);
					try {
						sleep(60000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	/**
	 * Selection in the workbench has been changed. We 
	 * can change the state of the 'real' action here
	 * if we want, but this can only happen after 
	 * the delegate has been created.
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * We can use this method to dispose of any system
	 * resources we previously allocated.
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
	}

	/**
	 * We will cache window object in order to
	 * be able to provide parent shell for the message dialog.
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
}