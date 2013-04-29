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
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
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

import diva.Dimension;
import diva.DivaPackage;
import diva.Property;
import diva.PropertyLiteral;
import diva.PropertyValue;
import diva.VariabilityModel;
import diva.Variant;
import diva.impl.DivaFactoryImpl;
import diva.visitors.Visitable;

public class QoSPropertyEditorPane extends DiVATableEditorPane implements Adapter {

	public QoSPropertyEditorPane(DiVATableEditor editor, IWorkbenchPage page,
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
		if (notification.getNotifier() instanceof Dimension) {
			treeViewerWithColumns.update(notification.getNotifier(), null);
			for(Variant v : ((Dimension)notification.getNotifier()).getVariant())
				treeViewerWithColumns.update(v, null);
		}
		if (notification.getNotifier() instanceof VariabilityModel) {
			VariabilityModel m = (VariabilityModel)notification.getNotifier();
			for(Dimension d : m.getDimension()) {
				if (!d.eAdapters().contains(this))d.eAdapters().add(this);
			}
			for(Property p : m.getProperty()) {
				if (!p.eAdapters().contains(this))p.eAdapters().add(this);
			}
			if (notification.getFeature() == DivaPackage.eINSTANCE.getVariabilityModel_Property()) {
				initializeTableTreeViewer();
			}
		}
		if (notification.getNotifier() instanceof PropertyValue) {
			treeViewerWithColumns.update(((PropertyValue)notification.getNotifier()).eContainer(), null);
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
		for(TreeColumn c : columns) c.dispose();
		columns.clear();
		
		tree.setLayoutData(new FillLayout());
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		// tree.setBackground(DiVABackgroundProvider.varColor);

		treeViewerWithColumns.setContentProvider(new VariantContentProvider(
				editor.getAdaptedFactory()));

		// get the model
		Resource r = editor.getEditingDomain().getResourceSet().getResources().get(0);
		
		// Find the VariabilityModel and set the input
		for (EObject o : r.getContents()) {
			if (o instanceof VariabilityModel) {
				createPropertyColumns(treeViewerWithColumns,
						(VariabilityModel) o);
				treeViewerWithColumns.setInput(o);
				if (!o.eAdapters().contains(this)) o.eAdapters().add(this);
				for(Dimension d : ((VariabilityModel) o).getDimension()) {
					d.eAdapters().add(this);
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

		/* Column 0 is always the tree itself */
		viewerColumn = new TreeViewerColumn(viewer, SWT.LEAD);
		column = viewerColumn.getColumn();
		columns.add(column);
		// column.setText("Type");
		// column.setToolTipText("Type of the context variable");
		column.setWidth(100);
		viewerColumn.setLabelProvider(new DiVALabelProvider(
				new AdapterFactoryLabelProvider(editor.getAdaptedFactory())));

		for (Property p : m.getProperty()) {
			if (!p.eAdapters().contains(this))p.eAdapters().add(this);
			viewerColumn = new TreeViewerColumn(viewer, SWT.LEAD);
			column = viewerColumn.getColumn();
			columns.add(column);
			column.setText(""+p.getName());
			// column.setToolTipText(descriptor.description);
			column.setAlignment(SWT.CENTER);
			column.setWidth(100);
			viewerColumn.setLabelProvider(new QoSPropertyColumnLabelProvider(p));
			viewerColumn.setEditingSupport(new QoSPropertyEditingSupport(viewer, p));
		}

	}

	class VariantContentProvider extends AdapterFactoryContentProvider {

		public VariantContentProvider(AdapterFactory adapterFactory) {
			super(adapterFactory);
		}

		
		public Object[] getChildren(Object object) {
			if (object instanceof VariabilityModel) {
				return ((VariabilityModel) object).getDimension().toArray();
			} else if (object instanceof Variant) {
				return new Object[0];
			}
			else if (object instanceof Dimension) {
				return ((Dimension) object).getVariant().toArray();
			}
			return super.getChildren(object);
		}

		
		public boolean hasChildren(Object object) {
			if (object instanceof VariabilityModel) {
				return ((VariabilityModel) object).getDimension().size() != 0;
			} else if (object instanceof Variant) {
				return false;
			}
			else if (object instanceof Dimension) {
				return ((Dimension) object).getVariant().size() != 0;
			}
			return super.hasChildren(object);
		}

		
		public Object[] getElements(Object object) {
			if (object instanceof VariabilityModel) {
				return ((VariabilityModel) object).getDimension().toArray();
			} else if (object instanceof Variant) {
				return new Object[0];
			}
			else if (object instanceof Dimension) {
				return ((Dimension) object).getVariant().toArray();
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
		return list;
	}
	
	//static String[] QosValues = {"-", "Very Low", "Low", "Medium", "High", "Very High" };

	public class QoSPropertyEditingSupport extends EditingSupport {

		protected Property property;

		public QoSPropertyEditingSupport(ColumnViewer viewer, Property property) {
			super(viewer);
			this.property = property;
		}

		
		protected boolean canEdit(Object element) {
			if (element instanceof Variant) {
				Variant v = (Variant)element;
				if (!v.getType().getProperty().contains(property)) {
					return false;
				}
			}
			return true;
		}

		
		protected CellEditor getCellEditor(Object element) {
			CellEditor result = null;
			if (element instanceof Variant) {
				String[] choices = new String[property.getLiteral().size()];
				for (int i = 0; i< property.getLiteral().size(); i++) choices[i] = property.getLiteral().get(i).getName();
				result = new ComboBoxCellEditor((Composite) getViewer().getControl(), choices);
			}
			else if (element instanceof Dimension) {
				result = new CheckboxCellEditor((Composite) getViewer().getControl(), SWT.CHECK);
			}
			return result;
		}

		
		protected Object getValue(Object element) {
			Object result = null;
			if (element instanceof Variant) {
				Variant v = (Variant)element;
				PropertyValue pv = null;
				for(PropertyValue o : v.getPropertyValue())
					if (o.getProperty() == property) pv = o;
				if (pv != null) {
					// find the index of the property literal having this value
					int res;
					for (res = 0; res < property.getLiteral().size(); res++) {
						if (property.getLiteral().get(res).getValue() == pv.getValue()) break;
					}
					result = res;
				}
				else result = 0;
			}
			else if (element instanceof Dimension) {
				Dimension d = (Dimension)element;
				result = d.getProperty().contains(property);
			}
			return result;
		}

		
		protected void setValue(Object element, Object value) {
			if (value == null) { // Need this check because somehow this gets called with value null
				return;
			}
			if (element instanceof Variant) {
				Variant v = (Variant)element;
				PropertyValue pv = null;
				for(PropertyValue o : v.getPropertyValue())
					if (o.getProperty() == property) pv = o;
				if (pv != null) {
					// Find the value from the index
					int idx = (Integer)value;
					SetCommand cmd = new SetCommand(editor.getEditingDomain(), pv, DivaPackage.eINSTANCE.getPropertyValue_Value(), property.getLiteral().get(idx).getValue());
					editor.getEditingDomain().getCommandStack().execute(cmd);
				}
				getViewer().update(v, null);
			}
			else if (element instanceof Dimension) {
				Dimension d = (Dimension)element;
				if ( ((Boolean)value).booleanValue() ) {
					if(!d.getProperty().contains(property)) {
						d.getProperty().add(property);
						AddCommand cmd = new AddCommand(editor.getEditingDomain(), d.getProperty(), property);
						editor.getEditingDomain().getCommandStack().execute(cmd);
					}
				}
				else {
					RemoveCommand cmd = new RemoveCommand(editor.getEditingDomain(), d.getProperty(), property);
					editor.getEditingDomain().getCommandStack().execute(cmd);
				}
				
				getViewer().update(d, null);
				for (Variant v : d.getVariant()) getViewer().update(v, null);
			}

			
		}
	}

	public class QoSPropertyColumnLabelProvider extends ColumnLabelProvider {

		protected Property property;

		private org.eclipse.swt.graphics.Color fNoEditColor;

		private final static String NOEDIT_STRING = "-";

		public QoSPropertyColumnLabelProvider(Property property) {
			super();
			this.property = property;
			this.fNoEditColor = new org.eclipse.swt.graphics.Color(Display
					.getCurrent(), 230, 230, 230);
		}

		
		public String getText(Object element) {
			
			if (element instanceof Variant) {
				Variant v = (Variant)element;
				
				if (v.getType().getProperty().contains(property)) {
					PropertyValue pv = null;
					for(PropertyValue o : v.getPropertyValue())
						if (o.getProperty() == property) pv = o;
					if (pv == null) {
						pv = DivaFactoryImpl.init().createPropertyValue();
						pv.setProperty(property);
						pv.setValue(0);
						AddCommand cmd = new AddCommand(editor.getEditingDomain(),v.getPropertyValue(), pv);
						editor.getEditingDomain().getCommandStack().execute(cmd);
					}
					//if (pv.getValue()<0) pv.setValue(0);
					//else if (pv.getValue()>=QosValues.length) pv.setValue(QosValues.length-1);
					if (!pv.eAdapters().contains(QoSPropertyEditorPane.this)) pv.eAdapters().add(QoSPropertyEditorPane.this);
					
					//search in the property
					for (PropertyLiteral l : property.getLiteral()) {
						if (l.getValue() == pv.getValue()) return l.getName();
					}
					
					return "" + pv.getValue();
				}
				else {
					return NOEDIT_STRING;
				}
			}
			else if (element instanceof Dimension) {
				Dimension d = (Dimension)element;
				return ""+ d.getProperty().contains(property);
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
			
			if (element instanceof Variant) {
				Variant v = (Variant)element;
				if (!v.getType().getProperty().contains(property)) {
					return this.fNoEditColor;
				}
			}
			
			if (element instanceof Visitable) {
				return ((Visitable) element).accept(DiVABackgroundProvider
						.getInstance(), null);
			}
			
			return super.getBackground(element);
		}
	}
}
