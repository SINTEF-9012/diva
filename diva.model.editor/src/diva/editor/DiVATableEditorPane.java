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



import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;

import editorparts.TableEditorPane;

public abstract class DiVATableEditorPane extends TableEditorPane {

	protected DiVATableEditor editor;
	
	public DiVATableEditorPane(DiVATableEditor editor, IWorkbenchPage page, IWorkbenchPart part) {
		super(editor.getAdapterFactory(), page, part);
		this.editor = editor;
		createControl(editor.getViewerPaneContainer());
		treeViewerWithColumns = (TreeViewer)getViewer();
		initializeTableTreeViewer();
	}
	
	protected void createExpressionColumn(EReference property, Adapter adapter) {
		// create the column to edit the guard
		TreeViewerColumn viewerColumn;
		TreeColumn column;
		viewerColumn = new TreeViewerColumn(treeViewerWithColumns, SWT.LEAD);
		column = viewerColumn.getColumn();
		columns.add(column);
		column.setText(property.getName());
		column.setAlignment(SWT.CENTER);
		column.setWidth(100);
		viewerColumn.setLabelProvider(new ExpressionColumnLabelProvider(property, treeViewerWithColumns, editor));
		viewerColumn.setEditingSupport(new ExpressionEditingSupport(treeViewerWithColumns, property, editor));
		
		// This is to enable tooltips on the cells:
		ColumnViewerToolTipSupport.enableFor(treeViewerWithColumns);
	}

	@Override
	public void requestActivation() {
		super.requestActivation();
		editor.setCurrentViewerPane(this);
	}

}
