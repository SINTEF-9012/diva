package diva.editor;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

import diva.DivaPackage;
import diva.Expression;
import diva.Term;
import diva.VariabilityModel;
import diva.parser.DivaExpressionParser;

public class ExpressionEditingSupport extends EditingSupport {

	protected DiVATableEditor editor;
	protected EReference property;

	public ExpressionEditingSupport(ColumnViewer viewer, EReference property, DiVATableEditor editor) {
		super(viewer);
		this.property = property;
		this.editor = editor;
	}

	@Override
	protected boolean canEdit(Object element) {
		Expression exp = getExpression(element);
		if (exp != null) return true;
		else return false;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		CellEditor result = null;
		result = new TextCellEditor((Composite) getViewer().getControl());
		return result;
	}

	@Override
	protected Object getValue(Object element) {
		Object result = "";
		Expression exp = getExpression(element);
		if (exp != null) {
				result = exp.getText();
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
		
		Expression exp = getExpression(element);
		
		if (exp != null) {
			EObject target = (EObject) element;
			if (value.toString().trim().equals("")) {
				SetCommand cmd = new SetCommand(editor.getEditingDomain(), exp, DivaPackage.eINSTANCE.getExpression_Text(), "");
				editor.getEditingDomain().getCommandStack().execute(cmd);
			} else {
				Term term = null;
				SetCommand cmd1 = new SetCommand(editor.getEditingDomain(), exp, DivaPackage.eINSTANCE.getExpression_Text(), value.toString().trim());
				editor.getEditingDomain().getCommandStack().execute(cmd1);
				try {
					term = DivaExpressionParser.parse((VariabilityModel) getContainingModel(target), value.toString().trim());
					SetCommand cmd2 = new SetCommand(editor.getEditingDomain(), exp, DivaPackage.eINSTANCE.getExpression_Term(), term);
					editor.getEditingDomain().getCommandStack().execute(cmd2);
				} catch (Throwable t) {
					//System.out.println("Error parsing " + value + "\n" + t.getMessage());
				}
			}
			getViewer().update(target, null);
		}
	}
	
	protected Expression getExpression(Object element) {
		Expression result = null;
		if (element instanceof EObject) {
			EObject target = (EObject) element;
			if (((EClass)property.eContainer()).isInstance(target)) {
				result = (Expression) target.eGet(property);
			}
		}
		return result;
	}
}
