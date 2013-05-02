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

import diva.VariabilityModel;
import diva.helpers.DivaHelper;

public class RunPopulateCompleteSimulation implements IObjectActionDelegate, Runnable {

	protected StructuredSelection currentSelection;
	protected IFile file;

	public RunPopulateCompleteSimulation() {
		super();
	}

	public void run() {

		String file_uri = file.getLocation().toOSString();
		
		System.out.println("Launching DiVA Simulator on file : " + file_uri + "...");
		long start = System.currentTimeMillis();
		
		try {			
				
			VariabilityModel model = DivaHelper.load(new File(file_uri));
			
			if (model.getSimulation() != null) {
				DivaHelper.computeSuitableConfigurations(model);
				model.getSimulation().populatePriorities();
				model.getSimulation().populateScores();
				model.getSimulation().populateVerdicts();
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
