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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;

import diva.BoolVariableValue;
import diva.BooleanVariable;
import diva.Context;
import diva.DivaPackage;
import diva.EnumLiteral;
import diva.EnumVariable;
import diva.EnumVariableValue;
import diva.Scenario;
import diva.SimulationModel;
import diva.VariabilityModel;
import diva.Variable;
import diva.VariableValue;
import diva.impl.DivaFactoryImpl;


public class SimulationInputEditor extends DiVATableEditorPane implements Adapter {

	public SimulationInputEditor(DiVATableEditor editor, IWorkbenchPage page,
			IWorkbenchPart part) {
		super(editor, page, part);
	}

	Notifier eNotifier;
	
	public Notifier getTarget() {
		return eNotifier;
	}
	
	public boolean isAdapterForType(Object type) {
		return false;
	}
	
	public void notifyChanged(Notification notification) {
		if (notification.getNotifier() instanceof Scenario) {
			treeViewerWithColumns.update(notification.getNotifier(), null);
			for(Context c : ((Scenario)notification.getNotifier()).getContext())
				treeViewerWithColumns.update(c, null);
		}
		if (notification.getNotifier() instanceof SimulationModel) {
			SimulationModel m = (SimulationModel)notification.getNotifier();
			for(Scenario d : m.getScenario()) {
				if (!d.eAdapters().contains(this))d.eAdapters().add(this);
			}
		}
		if (notification.getNotifier() instanceof VariabilityModel) {
			VariabilityModel m = (VariabilityModel)notification.getNotifier();
			if (notification.getFeature() == DivaPackage.eINSTANCE.getVariabilityModel_Simulation()) {
				SimulationModel sm = m.getSimulation();
				if (sm != null) {
					treeViewerWithColumns.setInput(sm);
					if (!sm.eAdapters().contains(this)) sm.eAdapters().add(this);
					for(Scenario d : sm.getScenario()) {
						d.eAdapters().add(this);
					}
				}
			}
		}
		if (notification.getNotifier() instanceof VariableValue) {
			treeViewerWithColumns.update(((VariableValue)notification.getNotifier()).eContainer(), null);
		}
	}
	
	
	public void setTarget(Notifier newTarget) {
		eNotifier = newTarget;	
	}
	
	/**
	 * Initializes the table tree viewer, creating columns and setting up
	 * editing. {@link #treeViewerWithColumns} should be valid before calling.
	 */
	protected void initializeTableTreeViewer() {

		Tree tree = treeViewerWithColumns.getTree();
		
		// Get rid of any existing stuff
		for(TreeColumn c : columns) c.dispose();
		columns.clear();
		
		tree.setLayoutData(new FillLayout());
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);

		treeViewerWithColumns.setContentProvider(new SimulationInputContentProvider(
				editor.getAdaptedFactory()));

		// get the model
		Resource r = editor.getEditingDomain().getResourceSet().getResources().get(0);
		
		createColumns(treeViewerWithColumns);
		
		// Find the SimulationModel and set the input
		for (EObject o : r.getContents()) {
			if (o instanceof VariabilityModel) {
				if (!o.eAdapters().contains(this)) o.eAdapters().add(this);
				createVariableColumns(treeViewerWithColumns, (VariabilityModel)o);
				createExpressionColumn(DivaPackage.eINSTANCE.getContext_Oracle(), this);
				SimulationModel sm = ((VariabilityModel)o).getSimulation();
				if (sm != null) {
					treeViewerWithColumns.setInput(sm);
					if (!sm.eAdapters().contains(this)) sm.eAdapters().add(this);
					for(Scenario d : sm.getScenario()) {
						d.eAdapters().add(this);
					}
				}
				break;
			}
		}
		
		
		
		//treeViewerWithColumns.expandAll();
		// resize all the columns
		for (TreeColumn c : columns)
			c.pack();
	}
	
	/**
	 * @return list of {@link ColumnDescriptor}s
	 * @generated
	 */
	protected List<ColumnDescriptor> getColumnDescriptors() {
		ArrayList<ColumnDescriptor> list = new ArrayList<ColumnDescriptor>();
		list.add(new ColumnDescriptor("Name", null, "name"));
		//list.add(new ColumnDescriptor("ID", null, "id"));
		//list.add(new ColumnDescriptor("Guard", null, "context"));
		return list;
	}

	protected void createVariableColumns(TreeViewer viewer, VariabilityModel m) {
		TreeViewerColumn viewerColumn;
		TreeColumn column;

		/* Column 0 is always the tree itself */
		//viewerColumn = new TreeViewerColumn(viewer, SWT.LEAD);
		//column = viewerColumn.getColumn();
		//columns.add(column);
		// column.setText("Type");
		// column.setToolTipText("Type of the context variable");
		//column.setWidth(100);
		//viewerColumn.setLabelProvider(new DiVALabelProvider(
		//		new AdapterFactoryLabelProvider(editor.getAdaptedFactory())));

		for (Variable v : m.getContext()) {
			viewerColumn = new TreeViewerColumn(viewer, SWT.LEAD);
			column = viewerColumn.getColumn();
			columns.add(column);
			column.setText(""+v.getId());
			// column.setToolTipText(descriptor.description);
			column.setAlignment(SWT.CENTER);
			column.setWidth(100);
			viewerColumn.setLabelProvider(new VariableValueColumnLabelProvider(v));
			viewerColumn.setEditingSupport(new VariableValueEditingSupport(viewer, v));
		}
	}

	class SimulationInputContentProvider extends AdapterFactoryContentProvider {

		public SimulationInputContentProvider(AdapterFactory adapterFactory) {
			super(adapterFactory);
		}

		
		public Object[] getChildren(Object object) {
			if (object instanceof SimulationModel) {
				return ((SimulationModel) object).getScenario().toArray();
			} else if (object instanceof Context) {
				return new Object[0];
			}
			else if (object instanceof Scenario) {
				return ((Scenario) object).getContext().toArray();
			}
			return super.getChildren(object);
		}

		
		public boolean hasChildren(Object object) {
			if (object instanceof SimulationModel) {
				return ((SimulationModel) object).getScenario().size() != 0;
			} else if (object instanceof Context) {
				return false;
			}
			else if (object instanceof Scenario) {
				return ((Scenario) object).getContext().size() != 0;
			}
			return super.hasChildren(object);
		}

		
		public Object[] getElements(Object object) {
			if (object instanceof SimulationModel) {
				return ((SimulationModel) object).getScenario().toArray();
			} else if (object instanceof Context) {
				return new Object[0];
			}
			else if (object instanceof Scenario) {
				return ((Scenario) object).getContext().toArray();
			}
			return super.getElements(object);
		}
	}

	public class VariableValueEditingSupport extends EditingSupport {

		protected Variable variable;

		public VariableValueEditingSupport(ColumnViewer viewer, Variable variable) {
			super(viewer);
			this.variable = variable;
		}

		
		protected boolean canEdit(Object element) {
			if (element instanceof Context) {
				return true;
			}
			else return false;
		}

		
		protected CellEditor getCellEditor(Object element) {
			CellEditor result = null;
			if (element instanceof Context) {
				if (variable instanceof BooleanVariable) {
					result = new CheckboxCellEditor((Composite) getViewer().getControl(), SWT.CHECK);
				}
				else if (variable instanceof EnumVariable){
					EnumVariable ev = (EnumVariable)variable;
					String[] literals = new String[ev.getLiteral().size()];
					for (int i=0; i<literals.length; i++) literals[i] = ev.getLiteral().get(i).getName(); 
					result = new ComboBoxCellEditor((Composite) getViewer().getControl(), literals);
				}
			}
			return result;
		}

		
		protected Object getValue(Object element) {
			Object result = null;
			if (element instanceof Context) {
				Context c = (Context)element;
				VariableValue vv = null;
				for (VariableValue v : c.getVariable()) if(v.getVariable() == variable) { vv = v; break; }
					
				if (variable instanceof BooleanVariable) {
					BoolVariableValue bvv = (BoolVariableValue)vv;
					result = bvv.isBool();
				}
				else if (variable instanceof EnumVariable){
					EnumVariable ev = (EnumVariable)variable;
					EnumVariableValue evv = (EnumVariableValue)vv;
					result = ev.getLiteral().indexOf(evv.getLiteral());
				}
			}
			return result;
		}

		
		protected void setValue(Object element, Object value) {
			if (value == null) { // Need this check because somehow this gets called with value null
				return;
			}
			
			if (element instanceof Context) {
				Context c = (Context)element;
				VariableValue vv = null;
				for (VariableValue v : c.getVariable()) if(v.getVariable() == variable) { vv = v; break; }
					
				if (variable instanceof BooleanVariable) {
					BoolVariableValue bvv = (BoolVariableValue)vv;
					SetCommand cmd = new SetCommand(editor.getEditingDomain(), bvv, DivaPackage.eINSTANCE.getBoolVariableValue_Bool(), value);
					editor.getEditingDomain().getCommandStack().execute(cmd);
				}
				else if (variable instanceof EnumVariable){
					EnumVariable ev = (EnumVariable)variable;
					EnumVariableValue evv = (EnumVariableValue)vv;
					EnumLiteral lit = ev.getLiteral().get((Integer)value);
					SetCommand cmd = new SetCommand(editor.getEditingDomain(), evv, DivaPackage.eINSTANCE.getEnumVariableValue_Literal(), lit);
					editor.getEditingDomain().getCommandStack().execute(cmd);
				}
			}
		}
	}

	public class VariableValueColumnLabelProvider extends ColumnLabelProvider {

		protected Variable variable;

		private org.eclipse.swt.graphics.Color fNoEditColor;

		private final static String NOEDIT_STRING = "-";

		public VariableValueColumnLabelProvider(Variable variable) {
			super();
			this.variable = variable;
			this.fNoEditColor = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 230, 230, 230);
		}

		
		public String getText(Object element) {
			String result = NOEDIT_STRING;
			if (element instanceof Context) {
				Context c = (Context)element;
				VariableValue vv = null;
				for (VariableValue v : c.getVariable()) if(v.getVariable() == variable) { vv = v; break; }
					
				if (variable instanceof BooleanVariable) {
					BoolVariableValue bvv = (BoolVariableValue)vv;
					// Create the variable value if it does not exist
					if (bvv == null) {
						bvv = DivaFactoryImpl.init().createBoolVariableValue();
						bvv.setBool(false);
						bvv.setVariable(variable);
						AddCommand cmd = new AddCommand(editor.getEditingDomain(), c, DivaPackage.eINSTANCE.getContext_Variable(), bvv);
						editor.getEditingDomain().getCommandStack().execute(cmd);
					}
					if(!bvv.eAdapters().contains(SimulationInputEditor.this))bvv.eAdapters().add(SimulationInputEditor.this);
					result = "" + bvv.isBool();
				}
				else if (variable instanceof EnumVariable){
					EnumVariable ev = (EnumVariable)variable;
					EnumVariableValue evv = (EnumVariableValue)vv;
					// Create the variable value if it does not exist
					if (evv == null) {
						evv = DivaFactoryImpl.init().createEnumVariableValue();
						evv.setVariable(variable);
						evv.setLiteral(ev.getLiteral().get(0));
						AddCommand cmd = new AddCommand(editor.getEditingDomain(), c, DivaPackage.eINSTANCE.getContext_Variable(), evv);
						editor.getEditingDomain().getCommandStack().execute(cmd);
					}
					if(!evv.eAdapters().contains(SimulationInputEditor.this))evv.eAdapters().add(SimulationInputEditor.this);
					result = evv.getLiteral().getName();
				}
			}
			return result;
		}

		
		public org.eclipse.swt.graphics.Image getImage(Object element) {
			return super.getImage(element);
		}

		
		public void dispose() {
			this.fNoEditColor.dispose();
			super.dispose();
		}

		
		public org.eclipse.swt.graphics.Color getBackground(Object element) {
			
			if (element instanceof Context) {
				Context c = (Context)element;
				VariableValue vv = null;
				for (VariableValue v : c.getVariable()) if(v.getVariable() == variable) { vv = v; break; }
				if (variable instanceof BooleanVariable && vv != null) {
					if (!((BoolVariableValue)vv).isBool()) return this.fNoEditColor;
				}
				return ((Context)element).accept(DiVABackgroundProvider.getInstance(), null);
			}
			else {
				return this.fNoEditColor;
			}
		}
	}
}
