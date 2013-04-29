/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva.impl;

import org.eclipse.emf.ecore.EClass;

import diva.BooleanVariable;
import diva.DivaPackage;
import diva.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class BooleanVariableImpl extends VariableImpl implements BooleanVariable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DivaPackage.Literals.BOOLEAN_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(Visitor<C, R> visitor, C context) {
		return visitor.visitBooleanVariable(this, context);
	}
	
	/**
	 * @generated NOT
	 */
	public void toAlloy(StringBuilder builder) {
		builder.append("lone sig " + getId() + " extends Context {}\n");
	}

} //BooleanVariableImpl
