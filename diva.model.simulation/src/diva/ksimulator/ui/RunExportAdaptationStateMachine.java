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


public class RunExportAdaptationStateMachine implements IObjectActionDelegate, Runnable {

	protected StructuredSelection currentSelection;
    protected IFile file;
	
	public RunExportAdaptationStateMachine() {
		super();
	}
	
	public void run() {
		
		System.out.println("Launching DiVA Simulator on file : " + file.getLocation().toOSString() + "...\n\n");
		
		try {			
				
			String file_uri = file.getLocation().toOSString();
			VariabilityModel model = DivaHelper.load(new File(file_uri));
		    			
			DivaHelper.toThingML(model);
			
			System.out.println("\n\nExecution terminated successfully.");			
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
			Iterator<StructuredSelection> it = currentSelection.iterator();

			while(it.hasNext()) {
				file = (IFile)it.next();
			}

		}
		
	}

}