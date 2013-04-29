package diva.ksimulator.ui;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/*import diva.ksimulator.KExecMain;

import fr.irisa.triskell.eclipse.console.EclipseConsole;
import fr.irisa.triskell.eclipse.console.IOConsole;
import fr.irisa.triskell.eclipse.console.messages.ErrorMessage;
import fr.irisa.triskell.eclipse.console.messages.InfoMessage;
import fr.irisa.triskell.eclipse.console.messages.OKMessage;
import fr.irisa.triskell.eclipse.console.messages.ThrowableMessage;*/

public class RunSimulationCoverageMultiple implements IObjectActionDelegate, Runnable {

	protected StructuredSelection currentSelection;

	
	public RunSimulationCoverageMultiple() {
		super();
	}
	
	public void run() {
		
		IFile file;
		Iterator it = currentSelection.iterator();
		
		/*IOConsole console = new EclipseConsole("DiVA Coverage Data");
		console.println(new InfoMessage("Launching DiVA Coverage analyser..."));*/
		
		System.out.println("Launching DiVA Coverage analyser...");
		
		try {			
			
			while(it.hasNext()) {
				file = (IFile)it.next();
				String file_uri = "file:/" + file.getLocation().toOSString();
				//TODO: call printCSVCoverage
				//KExecMain.run("printCSVCoverage", file_uri, console);
			}
			
			//console.println(new OKMessage("Execution terminated successfully."));
			
			System.out.println("Execution terminated successfully.");
			
			
		} catch (Throwable e) {
			/*console.println(new ErrorMessage("Runtime error : "));
			console.println(new ThrowableMessage(e));*/
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

		}
		
	}

}
