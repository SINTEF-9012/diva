/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva.impl;

import org.eclipse.emf.ecore.EClass;

import diva.ContextExpression;
import diva.DivaPackage;
import diva.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ContextExpressionImpl extends ExpressionImpl implements ContextExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContextExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DivaPackage.Literals.CONTEXT_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(Visitor<C, R> visitor, C context) {
		return visitor.visitContextExpression(this, context);
	}

} //ContextExpressionImpl
