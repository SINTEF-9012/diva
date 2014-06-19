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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;

import diva.VariabilityModel;

public class PropertyEditorPane extends DiVATableEditorPane {
	
	public PropertyEditorPane(DiVATableEditor editor, IWorkbenchPage page, IWorkbenchPart part) {
		super(editor, page, part);
	}
	
	/** Initializes the table tree viewer, creating columns and setting up editing.
	 *  {@link #treeViewerWithColumns} should be valid before calling.
	 */
	protected void initializeTableTreeViewer() {

		Tree tree = treeViewerWithColumns.getTree();
		tree.setLayoutData(new FillLayout());
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		//tree.setBackground(DiVABackgroundProvider.ctxColor);

		createColumns(treeViewerWithColumns);

		treeViewerWithColumns
				.setContentProvider(new ContextContentProvider(editor.getAdaptedFactory()));
		
		// get the model
		Resource r = editor.getEditingDomain().getResourceSet().getResources().get(0);
		
		// Find the VariabilityModel and set the input
		for (EObject o : r.getContents()) {
			if (o instanceof VariabilityModel) {
				treeViewerWithColumns.setInput(o);
				break;
			}
		}
		
		// resize all the columns
		treeViewerWithColumns.expandAll();
		for(TreeColumn c : columns) c.pack();
		treeViewerWithColumns.collapseAll();
	}
	
	class ContextContentProvider extends AdapterFactoryContentProvider {

		public ContextContentProvider(AdapterFactory adapterFactory) {
			super(adapterFactory);
		}

		@Override
		public Object[] getChildren(Object object) {
			if (object instanceof VariabilityModel) {
				return ((VariabilityModel)object).getProperty().toArray();
			}
			return super.getChildren(object);
		}

		@Override
		public boolean hasChildren(Object object) {
			if (object instanceof VariabilityModel) {
				return ((VariabilityModel)object).getProperty().size() != 0;
			}
			return super.hasChildren(object);
		}

		@Override
		public Object[] getElements(Object object) {
			if (object instanceof VariabilityModel) {
				return ((VariabilityModel)object).getProperty().toArray();
			}
			return super.getElements(object);
		}
	}

	/**
	 * @return list of {@link ColumnDescriptor}s
	 * @generated
	 */
	protected List<ColumnDescriptor> getColumnDescriptors() {
		ArrayList<ColumnDescriptor> list = new ArrayList<ColumnDescriptor>();
		list.add(new ColumnDescriptor("Name", null, "name"));
		//list.add(new ColumnDescriptor("ID", null, "id"));
		list.add(new ColumnDescriptor("Direction", null, "direction"));
		list.add(new ColumnDescriptor("Value", null, "value"));
		return list;
	}
	

}
