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
package diva.ksimulator.ui;

import java.io.File;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import diva.DivaFactory;
import diva.SimulationModel;
import diva.VariabilityModel;
import diva.helpers.DivaHelper;


public class RunCreateExhaustiveSimulation implements IObjectActionDelegate, Runnable {

	protected StructuredSelection currentSelection;
    protected IFile file;
	
	public RunCreateExhaustiveSimulation() {
		super();
	}
	
	public void run() {
		
		String file_uri = file.getLocation().toOSString();
		
		System.out.println("Launching DiVA Simulator on file : " + file_uri + "...");
		long start = System.currentTimeMillis();
		
		try {			
				
			VariabilityModel model = DivaHelper.load(new File(file_uri));
			
			if (model.getSimulation() != null) {
				SimulationModel sim = DivaFactory.eINSTANCE.createSimulationModel();
				model.setSimulation(sim);
				model.getSimulation().createExhaustiveSimulation();
			}
			
			DivaHelper.save(model, file_uri);
			
			System.out.println("Execution terminated successfully. Took: " + (System.currentTimeMillis() - start) + " ms");	
			
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		new Thread(this).start();
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		
		if (selection instanceof StructuredSelection)
		{
			currentSelection = (StructuredSelection)selection;
			Iterator it = currentSelection.iterator();

			while(it.hasNext()) {
				file = (IFile)it.next();
			}

		}
		
	}

}
