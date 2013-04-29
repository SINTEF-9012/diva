package diva.editor;

import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class URIDialogCellEditor extends DialogCellEditor {

	protected Shell shell;
	protected String title;
	
	public URIDialogCellEditor(Composite parent, String title) {
		super(parent);
		this.shell = parent.getShell();
		this.title = title;
	}
	
	@Override
	protected Object openDialogBox(Control cellEditorWindow) {
		ResourceDialog d = new ResourceDialog(shell, title, SWT.OPEN | SWT.SINGLE );
		d.setBlockOnOpen(true);
		if (d.open() == ResourceDialog.OK) {
			return d.getURIText();
		}
		return null;
	}

}
