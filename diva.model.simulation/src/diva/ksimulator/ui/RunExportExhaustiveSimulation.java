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

public class RunExportExhaustiveSimulation implements IObjectActionDelegate, Runnable {

	protected StructuredSelection currentSelection;
    protected IFile file;
	
	public RunExportExhaustiveSimulation() {
		super();
	}
	
	public void run() {
		
		/*IOConsole console = new EclipseConsole("DiVA Simulator");
		console.println(new InfoMessage("Launching DiVA Simulator on file : " + file.getLocation().toOSString() + "..."));*/
		
		System.out.println("Launching DiVA Simulator on file : " + file.getLocation().toOSString() + "...");
		
		try {			
				
			String file_uri = "file:/" + file.getLocation().toOSString();
		    
			//TODO: call exportExhaustiveSimulation
			/*KExecMain.run("exportExhaustiveSimulation", file_uri, console);
			
			console.println(new OKMessage("Execution terminated successfully."));*/
			
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
			Iterator it = currentSelection.iterator();

			while(it.hasNext()) {
				file = (IFile)it.next();
			}

		}
		
	}

}
