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

import diva.DivaPackage;
import diva.Expression;
import diva.PriorityRule;
import diva.Property;
import diva.PropertyPriority;
import diva.Rule;
import diva.VariabilityModel;
import diva.impl.DivaFactoryImpl;
import diva.visitors.Visitable;

public class PriorityRuleEditorPane extends DiVATableEditorPane implements Adapter {

	public PriorityRuleEditorPane(DiVATableEditor editor, IWorkbenchPage page, IWorkbenchPart part) {
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
		if (notification.getNotifier() instanceof Rule) {
			treeViewerWithColumns.update(notification.getNotifier(), null);
		}
		if (notification.getNotifier() instanceof Expression) {
			if (treeViewerWithColumns.isBusy()) return;
			System.out.println("notify");
			treeViewerWithColumns.update(((EObject)notification.getNotifier()).eContainer(), null);
			
		}
		if (notification.getNotifier() instanceof VariabilityModel) {
			VariabilityModel m = (VariabilityModel) notification.getNotifier();
			for (Rule d : m.getRule()) {
				if (!d.eAdapters().contains(this))
					d.eAdapters().add(this);
			}
			for (Property p : m.getProperty()) {
				if (!p.eAdapters().contains(this))
					p.eAdapters().add(this);
			}
			if (notification.getFeature() == DivaPackage.eINSTANCE.getVariabilityModel_Property()) {
				initializeTableTreeViewer();
			}
		}
		if (notification.getNotifier() instanceof PropertyPriority) {
			treeViewerWithColumns.update(((PropertyPriority) notification.getNotifier()).eContainer(), null);
		}
		if (notification.getNotifier() instanceof Property) {
			initializeTableTreeViewer();
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
		for (TreeColumn c : columns)
			c.dispose();
		columns.clear();

		tree.setLayoutData(new FillLayout());
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);

		treeViewerWithColumns.setContentProvider(new PriorityRuleContentProvider(editor.getAdaptedFactory()));

		// get the model
		Resource r = editor.getEditingDomain().getResourceSet().getResources().get(0);

		createColumns(treeViewerWithColumns);
		
		createExpressionColumn(DivaPackage.eINSTANCE.getPriorityRule_Context(), this);
		
		
		// Find the VariabilityModel and set the input
		for (EObject o : r.getContents()) {
			if (o instanceof VariabilityModel) {
				createPropertyColumns(treeViewerWithColumns, (VariabilityModel) o);
				treeViewerWithColumns.setInput(o);
				if (!o.eAdapters().contains(this))
					o.eAdapters().add(this);
				for (Rule rule : ((VariabilityModel) o).getRule()) {
					if (!rule.eAdapters().contains(this)) rule.eAdapters().add(this);
				}
				break;
			}
		}
		treeViewerWithColumns.expandAll();
		// resize all the columns
		for (TreeColumn c : columns)
			c.pack();
	}

	protected void createPropertyColumns(TreeViewer viewer, VariabilityModel m) {
		TreeViewerColumn viewerColumn;
		TreeColumn column;

		for (Property p : m.getProperty()) {
			if (!p.eAdapters().contains(this))
				p.eAdapters().add(this);
			viewerColumn = new TreeViewerColumn(viewer, SWT.LEAD);
			column = viewerColumn.getColumn();
			columns.add(column);
			column.setText("" + p.getName());
			// column.setToolTipText(descriptor.description);
			column.setAlignment(SWT.CENTER);
			column.setWidth(100);
			viewerColumn.setLabelProvider(new PriorityRuleColumnLabelProvider(p));
			viewerColumn.setEditingSupport(new PriorityRuleEditingSupport(viewer, p));
		}

	}

	class PriorityRuleContentProvider extends AdapterFactoryContentProvider {

		public PriorityRuleContentProvider(AdapterFactory adapterFactory) {
			super(adapterFactory);
		}

		
		public Object[] getChildren(Object object) {
			if (object instanceof VariabilityModel) {
				return ((VariabilityModel) object).getRule().toArray();
			} else {
				return new Object[0];
			}
		}

		
		public boolean hasChildren(Object object) {
			if (object instanceof VariabilityModel) {
				return ((VariabilityModel) object).getRule().size() != 0;
			} else {
				return false;
			}
		}

		
		public Object[] getElements(Object object) {
			if (object instanceof VariabilityModel) {
				return ((VariabilityModel) object).getRule().toArray();
			} else {
				return new Object[0];
			}
		}
	}

	/**
	 * @return list of {@link ColumnDescriptor}s
	 * @generated
	 */
	protected List<ColumnDescriptor> getColumnDescriptors() {
		ArrayList<ColumnDescriptor> list = new ArrayList<ColumnDescriptor>();
		list.add(new ColumnDescriptor("Name", null, "name"));
		list.add(new ColumnDescriptor("ID", null, "id"));
		//list.add(new ColumnDescriptor("Guard", null, "context"));
		return list;
	}

	static String[] PriorityValues = { "-", "Very Low", "Low", "Medium", "High", "Very High" };

	public class PriorityRuleEditingSupport extends EditingSupport {

		protected Property property;

		public PriorityRuleEditingSupport(ColumnViewer viewer, Property property) {
			super(viewer);
			this.property = property;
		}

		
		protected boolean canEdit(Object element) {
			if (element instanceof PriorityRule)
				return true;
			else
				return false;
		}

		
		protected CellEditor getCellEditor(Object element) {
			CellEditor result = null;
			if (element instanceof PriorityRule) {
				result = new ComboBoxCellEditor((Composite) getViewer().getControl(), PriorityValues);
			}
			return result;
		}

		
		protected Object getValue(Object element) {
			Object result = null;
			if (element instanceof PriorityRule) {
				PriorityRule r = (PriorityRule) element;
				PropertyPriority pp = null;
				for (PropertyPriority o : r.getPriority())
					if (o.getProperty() == property)
						pp = o;
				if (pp != null)
					result = pp.getPriority();
				else
					result = 0;
			}
			return result;
		}

		
		protected void setValue(Object element, Object value) {
			if (value == null) { // Need this check because somehow this gets
				// called with value null
				return;
			}
			if (element instanceof PriorityRule) {
				PriorityRule r = (PriorityRule) element;
				PropertyPriority pp = null;
				for (PropertyPriority o : r.getPriority())
					if (o.getProperty() == property)
						pp = o;
				if (pp != null) {
					SetCommand cmd = new SetCommand(editor.getEditingDomain(), pp, DivaPackage.eINSTANCE.getPropertyPriority_Priority(), value);
					editor.getEditingDomain().getCommandStack().execute(cmd);
				}
				getViewer().update(r, null);
			}
		}
	}

	public class PriorityRuleColumnLabelProvider extends ColumnLabelProvider {

		protected Property property;

		private org.eclipse.swt.graphics.Color fNoEditColor;

		private final static String NOEDIT_STRING = "-";

		public PriorityRuleColumnLabelProvider(Property property) {
			super();
			this.property = property;
			this.fNoEditColor = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 230, 230, 230);
		}

		
		public String getText(Object element) {

			if (element instanceof PriorityRule) {
				PriorityRule r = (PriorityRule) element;
				PropertyPriority pp = null;
				for (PropertyPriority o : r.getPriority())
					if (o.getProperty() == property)
						pp = o;
				if (pp == null) {
					pp = DivaFactoryImpl.init().createPropertyPriority();
					pp.setProperty(property);
					pp.setPriority(0);
					AddCommand cmd = new AddCommand(editor.getEditingDomain(), r.getPriority(), pp);
					editor.getEditingDomain().getCommandStack().execute(cmd);
				}
				if (pp.getPriority() < 0)
					pp.setPriority(0);
				else if (pp.getPriority() >= PriorityValues.length)
					pp.setPriority(PriorityValues.length - 1);
				if (!pp.eAdapters().contains(PriorityRuleEditorPane.this))
					pp.eAdapters().add(PriorityRuleEditorPane.this);
				return PriorityValues[pp.getPriority()];
			}
			return NOEDIT_STRING;
		}

		
		public org.eclipse.swt.graphics.Image getImage(Object element) {
			return super.getImage(element);
		}

		
		public void dispose() {
			this.fNoEditColor.dispose();
			super.dispose();
		}

		
		public org.eclipse.swt.graphics.Color getBackground(Object element) {

			if (element instanceof PriorityRule) {
				PriorityRule r = (PriorityRule) element;
				PropertyPriority pp = null;
				for (PropertyPriority o : r.getPriority())
					if (o.getProperty() == property)
						pp = o;
				if (pp != null && pp.getPriority() == 0) {
					return fNoEditColor;
				}
			}
			
			if (element instanceof Visitable) {
				return ((Visitable) element).accept(DiVABackgroundProvider.getInstance(), null);
			}

			return super.getBackground(element);
		}
	}
	
}
