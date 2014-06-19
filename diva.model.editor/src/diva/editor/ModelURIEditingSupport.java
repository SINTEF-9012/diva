package diva.editor;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.swt.widgets.Composite;

import diva.DivaPackage;
import diva.Model;
import diva.VariabilityModel;

public class ModelURIEditingSupport extends EditingSupport {

	protected DiVATableEditor editor;
	protected EReference property;

	public ModelURIEditingSupport(ColumnViewer viewer, EReference property, DiVATableEditor editor) {
		super(viewer);
		this.property = property;
		this.editor = editor;
	}

	@Override
	protected boolean canEdit(Object element) {
		Model m = getModel(element);
		if (m != null) return true;
		else return false;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		CellEditor result = null;
		//result = new TextCellEditor((Composite) getViewer().getControl());
		result = new URIDialogCellEditor((Composite) getViewer().getControl(), "CEP Query Selection");
		return result;
	}

	@Override
	protected Object getValue(Object element) {
		Object result = "";
		Model m = getModel(element);
		if (m != null) {
				result = m.getUri();
		}
		return result;
	}
	
	protected VariabilityModel getContainingModel(EObject target) {
		EObject current = target;
		VariabilityModel result = null;
		while (result == null && current != null)  {
			if (current instanceof VariabilityModel) result = (VariabilityModel)current;
			current = current.eContainer();
		}
		return result;
	}

	@Override
	protected void setValue(Object element, Object value) {
		if (value == null) { // Need this check because somehow this gets
			// called with value null
			return;
		}
		
		Model m = getModel(element);
		
		if (m != null) {
			SetCommand cmd = new SetCommand(editor.getEditingDomain(), m, DivaPackage.eINSTANCE.getModel_Uri(), value.toString().trim());
			editor.getEditingDomain().getCommandStack().execute(cmd);
			EObject target = (EObject) element;
			getViewer().update(target, null);
		}
	}
	
	protected Model getModel(Object element) {
		Model result = null;
		if (element instanceof EObject) {
			EObject target = (EObject) element;
			if (((EClass)property.eContainer()).isInstance(target)) {
				result = (Model) target.eGet(property);
			}
		}
		return result;
	}
}
