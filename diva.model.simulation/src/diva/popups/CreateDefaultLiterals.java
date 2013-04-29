package diva.popups;

import java.util.Iterator;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import diva.Property;
import diva.editor.DiVATableEditor;

public class CreateDefaultLiterals implements IObjectActionDelegate, Runnable {

	protected StructuredSelection currentSelection;
    protected Property prop;
	
	public CreateDefaultLiterals() {
		super();
	}
	
	public void run() {
		
		if( editor != null && prop != null) {
			editor.createDefaultProperties(prop);
		}
		
	}
	
	DiVATableEditor editor;

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		
		if (targetPart instanceof DiVATableEditor) {
			editor = (DiVATableEditor)targetPart;
		}
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
				Object obj = it.next();
				if (obj instanceof Property) {
					prop = (Property)obj;
				}
			}

		}
		
	}
	
}