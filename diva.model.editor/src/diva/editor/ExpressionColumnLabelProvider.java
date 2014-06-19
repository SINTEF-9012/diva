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

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import diva.DivaPackage;
import diva.Expression;
import diva.Term;
import diva.VariabilityModel;
import diva.impl.DivaFactoryImpl;
import diva.parser.DivaExpressionParser;

public class ExpressionColumnLabelProvider extends ColumnLabelProvider implements Adapter {

	protected EReference property;

	private org.eclipse.swt.graphics.Color redColor;
	private org.eclipse.swt.graphics.Color greenColor;
	private org.eclipse.swt.graphics.Color fNoEditColor;
	
	private TreeViewer viewer;
	protected DiVATableEditor editor;

	private final static String NOEDIT_STRING = "-";

	public ExpressionColumnLabelProvider(EReference property, TreeViewer viewer, DiVATableEditor editor) {
		super();
		this.property = property;
		this.viewer = viewer;
		this.editor = editor;
		this.redColor = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 255, 200, 200);
		this.greenColor = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 200, 255, 200);
		this.fNoEditColor = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 230, 230, 230);	
	}
	
	Notifier eNotifier;

	
	public Notifier getTarget() {
		return eNotifier;
	}

	
	public boolean isAdapterForType(Object type) {
		return false;
	}

	
	public void notifyChanged(Notification notification) {
		if (viewer.isBusy()) return;
		if (notification.isTouch()) return;
		if (notification.getNotifier() instanceof Expression) {
			Expression exp = (Expression)notification.getNotifier();
			if (notification.getFeature() == DivaPackage.eINSTANCE.getExpression_Text()) {
				if (exp.getText() == null || exp.getText().trim() == "") {
					if (exp.getTerm() != null) {
						// remove the term
						SetCommand cmd = new SetCommand(editor.getEditingDomain(), exp, DivaPackage.eINSTANCE.getExpression_Term(), null);
						editor.getEditingDomain().getCommandStack().execute(cmd);
					}
				}
				else {
					// Parse and update the expression term
					try {
						Term term = DivaExpressionParser.parse((VariabilityModel) getContainingModel(exp), exp.getText().trim());
						SetCommand cmd = new SetCommand(editor.getEditingDomain(), exp, DivaPackage.eINSTANCE.getExpression_Term(), term);
						editor.getEditingDomain().getCommandStack().execute(cmd);
					} catch (Throwable t) {
						SetCommand cmd = new SetCommand(editor.getEditingDomain(), exp, DivaPackage.eINSTANCE.getExpression_Term(), null);
						editor.getEditingDomain().getCommandStack().execute(cmd);
					}
				}
				viewer.update(((EObject)notification.getNotifier()).eContainer(), null);
			}
			else if (notification.getFeature() == DivaPackage.eINSTANCE.getExpression_Term()) {
				
			}
		}
	}
	
	
	public void setTarget(Notifier newTarget) {
		eNotifier = newTarget;
	}
	
	
	public Color getToolTipBackgroundColor(Object element) {
		Expression exp = getExpression(element);
		if (exp != null) {
			if (fixObject(element)) {
				return greenColor;
			}
			else {
				return redColor;
			}
		}
		return super.getToolTipBackgroundColor(element);
	}
	
	
	public String getToolTipText(Object element) {
		Expression exp = getExpression(element);
		if (exp != null) {
			EObject target = (EObject) element;
			if (fixObject(element)) {
				return null;
			}
			else {
				try {
					DivaExpressionParser.parse(getContainingModel(target), exp.getText().trim());
					return null;
				} catch (Throwable t) {
					return t.getMessage();
				}
			}
		}
		return super.getToolTipText(element);
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

	// return true if no errors and false otherwise. 
	// return false if there is no expression
	protected boolean fixObject(Object element) {
		Expression exp = getExpression(element);
		
		if (exp == null) {
			// create an empty expression
			if (element instanceof EObject) {
				EObject target = (EObject) element;
				if (((EClass)property.eContainer()).isInstance(target)) {
					Expression nexp = null;
					if (property.getEType() == DivaPackage.eINSTANCE.getExpression())
						nexp = DivaFactoryImpl.init().createExpression();
					else if (property.getEType() == DivaPackage.eINSTANCE.getContextExpression())
						nexp = DivaFactoryImpl.init().createContextExpression();
					else if (property.getEType() == DivaPackage.eINSTANCE.getVariantExpression())
						nexp = DivaFactoryImpl.init().createVariantExpression();
					nexp.setText("");
					SetCommand cmd = new SetCommand(editor.getEditingDomain(), target, property, nexp);
					editor.getEditingDomain().getCommandStack().execute(cmd);
					exp = nexp;
				}
			}
		}
		
		if (exp != null) {
			EObject target = (EObject) element;
			
			if (!exp.eAdapters().contains(this)) exp.eAdapters().add(this);
			
			if (exp.getText() == null || exp.getText().trim().equals("")) {
				if (exp.getTerm() == null) {
					return true;
				} else {
					SetCommand cmd1 = new SetCommand(editor.getEditingDomain(), exp, DivaPackage.eINSTANCE.getExpression_Text(), DivaExpressionParser
							.print(exp.getTerm()));
					editor.getEditingDomain().getCommandStack().execute(cmd1);
					return true;
				}
			} else {
				if (exp.getTerm() == null) {
					Term term = null;
					try {
						term = DivaExpressionParser.parse(getContainingModel(target), exp.getText().trim());
						CompoundCommand cc = new CompoundCommand();
						SetCommand cmd1 = new SetCommand(editor.getEditingDomain(), exp, DivaPackage.eINSTANCE.getExpression_Text(), exp.getText().trim());
						SetCommand cmd2 = new SetCommand(editor.getEditingDomain(), exp, DivaPackage.eINSTANCE.getExpression_Term(), term);
						cc.append(cmd1);
						cc.append(cmd2);
						editor.getEditingDomain().getCommandStack().execute(cc);
						return true;
					} catch (Throwable t) {
						//System.out.println("Error parsing " + exp.getText().trim() + "\n" + t.getMessage());
						return false;
					}
				} else {
					try {
						DivaExpressionParser.parse(getContainingModel(target), exp.getText().trim());
						return true;
					} catch (Throwable t) {
						//System.out.println("Error parsing " + exp.getText().trim() + "\n" + t.getMessage());
						return false;
					}
				}
			}
		}
		else {
			
		}
		return false;
	}

	
	public String getText(Object element) {
		String result = NOEDIT_STRING;
		fixObject(element);
		Expression exp = getExpression(element);
		if (exp != null) {
			result = exp.getText();
		}
		return result;
	}

	
	public org.eclipse.swt.graphics.Image getImage(Object element) {
		return super.getImage(element);
	}

	
	public void dispose() {
		this.greenColor.dispose();
		this.redColor.dispose();
		this.fNoEditColor.dispose();
		super.dispose();
	}

	
	public org.eclipse.swt.graphics.Color getBackground(Object element) {
		Expression exp = getExpression(element);
		if (exp != null) {
			if (fixObject(element)) {
				return greenColor;
			}
			else {
				return redColor;
			}
		}
		return fNoEditColor;
	
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