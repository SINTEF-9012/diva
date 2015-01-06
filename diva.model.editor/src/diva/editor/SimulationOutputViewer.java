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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;

import diva.ConfigVariant;
import diva.Configuration;
import diva.Context;
import diva.Priorities;
import diva.Priority;
import diva.Property;
import diva.Scenario;
import diva.Score;
import diva.ScoredElement;
import diva.SimulationModel;
import diva.VariabilityModel;
import diva.Verdict;


public class SimulationOutputViewer extends DiVATableEditorPane implements Adapter {

	public SimulationOutputViewer(DiVATableEditor editor, IWorkbenchPage page,
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

		treeViewerWithColumns.setContentProvider(new SimulationViewerContentProvider(
				editor.getAdaptedFactory()));

		// get the model
		Resource r = editor.getEditingDomain().getResourceSet().getResources().get(0);
		
		// Find the SimulationModel and set the input
		for (EObject o : r.getContents()) {
			if (o instanceof VariabilityModel) {
				if (!o.eAdapters().contains(this)) o.eAdapters().add(this);
				createPropertiesColumns(treeViewerWithColumns, (VariabilityModel)o);
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
		treeViewerWithColumns.expandToLevel(2);
		// resize all the columns
		for (TreeColumn c : columns)
			c.pack();
	}

	protected void createPropertiesColumns(TreeViewer viewer, VariabilityModel m) {
		TreeViewerColumn viewerColumn;
		TreeColumn column;

		/* Column 0 is always the tree itself */
		viewerColumn = new TreeViewerColumn(viewer, SWT.LEAD);
		column = viewerColumn.getColumn();
		columns.add(column);
		// column.setText("Type");
		// column.setToolTipText("Type of the context variable");
		column.setWidth(100);
		viewerColumn.setLabelProvider(new VerdictBackgroundLabelProvider(
				new AdapterFactoryLabelProvider(editor.getAdaptedFactory())));

		for (Property p : m.getProperty()) {
			viewerColumn = new TreeViewerColumn(viewer, SWT.LEAD);
			column = viewerColumn.getColumn();
			columns.add(column);
			column.setText(""+p.getId());
			column.setToolTipText(""+p.getName());
			column.setAlignment(SWT.CENTER);
			column.setWidth(100);
			viewerColumn.setLabelProvider(new ScoreValueColumnLabelProvider(p));
		}
		
		viewerColumn = new TreeViewerColumn(viewer, SWT.LEAD);
		column = viewerColumn.getColumn();
		columns.add(column);
		column.setText("Total");
		column.setToolTipText("Total Score");
		column.setAlignment(SWT.CENTER);
		column.setWidth(100);
		viewerColumn.setLabelProvider(new ScoreValueColumnLabelProvider(null));
	}
	
	class VerdictBackgroundLabelProvider extends DiVALabelProvider {

		private org.eclipse.swt.graphics.Color fNoEditColor;
		private org.eclipse.swt.graphics.Color redColor;
		private org.eclipse.swt.graphics.Color greenColor;
		
		public VerdictBackgroundLabelProvider(AdapterFactoryLabelProvider adapterFactoryLabelProvider) {
			super(adapterFactoryLabelProvider);
			this.fNoEditColor = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 230, 230, 230);
			this.redColor = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 255, 200, 200);
			this.greenColor = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 200, 255, 200);
		}
		
		
		public void dispose() {
			this.fNoEditColor.dispose();
			this.greenColor.dispose();
			this.redColor.dispose();
			super.dispose();
		}
		
		
		public org.eclipse.swt.graphics.Color getBackground(Object element) {
			
			if (element instanceof Scenario) { 
				for (Context c : ((Scenario) element).getContext()) {
					if (c.getVerdict() == Verdict.PASS) {
						
					}
					else if (c.getVerdict() == Verdict.FAIL) {
						return this.redColor;
					}
					else return this.fNoEditColor;
				}
				return this.greenColor;
			}
			else if (element instanceof Context) { 
				if (((Context) element).getVerdict() == Verdict.PASS)
					return this.greenColor;
				else if (((Context) element).getVerdict() == Verdict.FAIL)
					return this.redColor;
				else return this.fNoEditColor;
			}
			else if (element instanceof Configuration) {
				if (((Configuration) element).getVerdict() == Verdict.PASS)
					return this.greenColor;
				else if (((Configuration) element).getVerdict() == Verdict.FAIL)
					return this.redColor;
				else return this.fNoEditColor;
			}
			else {
				return this.fNoEditColor;
			}
		}
	}
	
	class SimulationViewerContentProvider extends AdapterFactoryContentProvider {

		public SimulationViewerContentProvider(AdapterFactory adapterFactory) {
			super(adapterFactory);
		}

		
		public Object[] getChildren(Object object) {
			if (object instanceof SimulationModel) {
				return ((SimulationModel) object).getScenario().toArray();
			} 
			else if (object instanceof Scenario) {
				return ((Scenario) object).getContext().toArray();
			}
			else if (object instanceof Context) {
				Context c = (Context)object;
				Comparator<Configuration> comp = new Comparator<Configuration>(){
					
					public int compare(Configuration c1, Configuration c2) {
						return c2.getTotalScore() - c1.getTotalScore();
				}};
				ArrayList<Configuration> list = new ArrayList<Configuration>();
				list.addAll(c.getConfiguration());
				Collections.sort(list, comp);
				return list.toArray();
			}
			else if (object instanceof Configuration) {
				return ((Configuration) object).getVariant().toArray();
			}
			else if (object instanceof ConfigVariant) return new Object[0];
			else if (object instanceof Priorities) return new Object[0];
			return super.getChildren(object);
		}

		
		public boolean hasChildren(Object object) {
			if (object instanceof SimulationModel) {
				return ((SimulationModel) object).getScenario().size() != 0;
			} 
			else if (object instanceof Context) {
				return ((Context) object).getConfiguration().size() != 0;
			}
			else if (object instanceof Scenario) {
				return ((Scenario) object).getContext().size() != 0;
			}
			else if (object instanceof Configuration) {
				return ((Configuration) object).getVariant().size() != 0;
			}
			else if (object instanceof ConfigVariant) return false;
			else if (object instanceof Priorities) return false;
			return super.hasChildren(object);
		}

		
		public Object[] getElements(Object object) {
			return getChildren(object);
		}
	}

	/**
	 * @return list of {@link ColumnDescriptor}s
	 * @generated
	 */
	protected List<ColumnDescriptor> getColumnDescriptors() {
		ArrayList<ColumnDescriptor> list = new ArrayList<ColumnDescriptor>();
		return list;
	}

	static String[] PriorityValues = { "Lowest", "Very Low", "Low", "Medium", "High", "Very High", "Very High", "Very High","Very High","Very High","Very High","Very High","Very High","Very High" };
	
	public class ScoreValueColumnLabelProvider extends ColumnLabelProvider {

		protected Property property;

		private org.eclipse.swt.graphics.Color fNoEditColor;
		private org.eclipse.swt.graphics.Color redColor;
		private org.eclipse.swt.graphics.Color greenColor;

		private final static String NOEDIT_STRING = "-";

		public ScoreValueColumnLabelProvider(Property property) {
			super();
			this.property = property;
			this.fNoEditColor = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 230, 230, 230);
			this.redColor = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 255, 200, 200);
			this.greenColor = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 200, 255, 200);
		}

		
		public String getText(Object element) {
			
			if (element instanceof ScoredElement) {
				ScoredElement cfg = (ScoredElement)element;
				if (property == null) return "" + cfg.getTotalScore();
				Score score = null;
				for (Score s : cfg.getScore()) {
					if (s.getProperty() == property) {
						score = s;
						break;
					}
				}
				if (score != null) return "" + score.getScore();
				else return NOEDIT_STRING;
			}
			else if (element instanceof Context) {
				Context cfg = (Context)element;
				if (property == null) return NOEDIT_STRING;
				Priority priority = null;
				for (Priority p : cfg.getPriority()) {
					if (p.getProperty() == property) {
						priority = p;
						break;
					}
				}
				if (priority != null) return "" + PriorityValues[priority.getPriority()];
				else return NOEDIT_STRING;
			}
			return NOEDIT_STRING;
		}

		
		public org.eclipse.swt.graphics.Image getImage(Object element) {
			return super.getImage(element);
		}

		
		public void dispose() {
			this.fNoEditColor.dispose();
			this.greenColor.dispose();
			this.redColor.dispose();
			super.dispose();
		}

		
		public org.eclipse.swt.graphics.Color getBackground(Object element) {
			
			if (element instanceof Scenario) { 
				for (Context c : ((Scenario) element).getContext()) {
					if (c.getVerdict() == Verdict.PASS) {
						
					}
					else if (c.getVerdict() == Verdict.FAIL) {
						return this.redColor;
					}
					else return this.fNoEditColor;
				}
				return this.greenColor;
			}
			else if (element instanceof Context) { 
				if (((Context) element).getVerdict() == Verdict.PASS)
					return this.greenColor;
				else if (((Context) element).getVerdict() == Verdict.FAIL)
					return this.redColor;
				else return this.fNoEditColor;
			}
			else if (element instanceof Configuration) {
				if (((Configuration) element).getVerdict() == Verdict.PASS)
					return this.greenColor;
				else if (((Configuration) element).getVerdict() == Verdict.FAIL)
					return this.redColor;
				else return this.fNoEditColor;
			}
			else {
				return this.fNoEditColor;
			}
		}
	}
}
