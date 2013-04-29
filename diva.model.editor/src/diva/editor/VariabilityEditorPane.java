package diva.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;

import diva.DivaPackage;
import diva.Expression;
import diva.MultiplicityConstraint;
import diva.VariabilityModel;
import diva.Variant;

public class VariabilityEditorPane extends DiVATableEditorPane implements Adapter {

	Notifier eNotifier;

	
	public Notifier getTarget() {
		return eNotifier;
	}

	
	public boolean isAdapterForType(Object type) {
		return false;
	}

	
	public void notifyChanged(Notification notification) {
		if (treeViewerWithColumns.isBusy()) return;
		if (notification.getNotifier() instanceof Expression) {
			treeViewerWithColumns.update(((EObject)notification.getNotifier()).eContainer(), null);
		}
	}
	
	
	public void setTarget(Notifier newTarget) {
		eNotifier = newTarget;
	}

	public VariabilityEditorPane(DiVATableEditor editor, IWorkbenchPage page, IWorkbenchPart part) {
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

		createColumns(treeViewerWithColumns);
		
		createExpressionColumn(DivaPackage.eINSTANCE.getVariant_Dependency(), this);
		createExpressionColumn(DivaPackage.eINSTANCE.getVariant_Available(), this);
		createExpressionColumn(DivaPackage.eINSTANCE.getVariant_Required(), this);

		treeViewerWithColumns
				.setContentProvider(new VariantContentProvider(editor.getAdaptedFactory()));
		
		// get the model
		Resource r = editor.getEditingDomain().getResourceSet().getResources().get(0);
		
		// Find the VariabilityModel and set the input
		for (EObject o : r.getContents()) {
			if (o instanceof VariabilityModel) {
				treeViewerWithColumns.setInput(o);
				break;
			}
		}
		
		treeViewerWithColumns.expandAll();
		// resize all the columns
		for(TreeColumn c : columns) c.pack();
		
		
	}
	
	class VariantContentProvider extends AdapterFactoryContentProvider {

		public VariantContentProvider(AdapterFactory adapterFactory) {
			super(adapterFactory);
		}

		
		public Object[] getChildren(Object object) {
			if (object instanceof VariabilityModel) {
				return ((VariabilityModel)object).getDimension().toArray();
			}
			else if(object instanceof Variant) {
				return new Object[0];
			}
			else if(object instanceof MultiplicityConstraint) {
				return new Object[0];
			}
			return super.getChildren(object);
		}

		
		public boolean hasChildren(Object object) {
			if (object instanceof VariabilityModel) {
				return ((VariabilityModel)object).getDimension().size() != 0;
			}
			else if(object instanceof Variant) {
				return false;
			}
			else if(object instanceof MultiplicityConstraint) {
				return false;
			}
			return super.hasChildren(object);
		}

		
		public Object[] getElements(Object object) {
			if (object instanceof VariabilityModel) {
				return ((VariabilityModel)object).getDimension().toArray();
			}
			else if(object instanceof Variant) {
				return new Object[0];
			}
			else if(object instanceof MultiplicityConstraint) {
				return new Object[0];
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
		list.add(new ColumnDescriptor("ID", null, "id"));
		list.add(new ColumnDescriptor("Lower", null, "lower"));
		list.add(new ColumnDescriptor("Upper", null, "upper"));
		//list.add(new ColumnDescriptor("Dependency", null, "dependency"));
		//list.add(new ColumnDescriptor("Available", null, "available"));
		//list.add(new ColumnDescriptor("Required", null, "required"));
		return list;
	}

}
