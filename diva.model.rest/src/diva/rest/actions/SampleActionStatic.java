/**
 * Copyright 2014 SINTEF <brice.morin@sintef.no>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package diva.rest.actions;

import java.io.IOException;
import java.net.URI;
import java.util.Calendar;
import java.util.Collections;

import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.jface.dialogs.MessageDialog;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import diva.VariabilityModel;
import diva.helpers.DivaHelper;
import diva.rest.Demo;
import diva.rest.model.ConfigurationsPool;
import diva.rest.model.DivaRoot;
import diva.rest.model.Repository;
import diva.rest.resources.DependencyChecking;
import diva.rest.resources.PubSub;
import diva.rest.resources.Recommendation;

/**
 * Our sample action implements workbench action delegate.
 * The action proxy will be created by the workbench and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be 
 * delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class SampleActionStatic implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;
	/**
	 * The constructor.
	 */
	public SampleActionStatic() {
	}

	/**
	 * The action has been activated. The argument of the
	 * method represents the 'real' action sitting
	 * in the workbench UI.
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) {
		
		//doit("Orbi-ref");
		doit("Orbi-comp");
		
	}

	private void doit(String file) {
		VariabilityModel root = null;
		ResourceSet rs = new ResourceSetImpl();
		Resource res = rs.createResource(org.eclipse.emf.common.util.URI
				.createPlatformResourceURI("BrokerAtCloud/model/"+file+".diva"));
		try{
			res.load(Collections.EMPTY_MAP);
			root = (VariabilityModel) res.getContents().get(0);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		if(root.getSimulation()==null)
			return;
		root.getSimulation().populatePriorities();
		root.getSimulation().populateScores();
		root.getSimulation().populateVerdicts();
		DivaHelper.computeSuitableConfigurations(root, 0);
		root.getSimulation().populateScores();
		root.getSimulation().populateVerdicts();
		
		Resource res2 = rs.createResource(org.eclipse.emf.common.util.URI.createPlatformResourceURI(
				"BrokerAtCloud/model/"+file+"-gen.diva"));
		
		res2.getContents().add(root);
		try {
			res2.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public void updateAndSave(){
		DivaRoot d = Repository.mainRoot.fork();
		d.updateModel();
		d.updateOnRequest("abc", "001");
		d.saveModel(org.eclipse.emf.common.util.URI
				.createPlatformResourceURI("BrokerAtCloud/model/Orbi-generated.diva"));
	}
}