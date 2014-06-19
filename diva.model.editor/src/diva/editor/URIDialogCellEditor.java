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
