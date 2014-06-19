/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva.impl;

import org.eclipse.emf.ecore.EClass;

import diva.BoolVariableValue;
import diva.BooleanTerm;
import diva.Configuration;
import diva.Context;
import diva.DivaPackage;
import diva.VariableValue;
import diva.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Term</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class BooleanTermImpl extends VariableTermImpl implements BooleanTerm {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanTermImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DivaPackage.Literals.BOOLEAN_TERM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(final Visitor<C, R> visitor, final C context) {
		return visitor.visitBooleanTerm(this, context);
	}
	
	/**
	 * @generated NOT
	 */
	public void toAlloy(StringBuilder builder) {
		builder.append("one " + getVariable().getId());
	}

	/**
	 * @generated NOT
	 */
	public boolean eval(Context ctx, Configuration cfg) {
		for(VariableValue vv : ctx.getVariable()) {
			if (vv.getVariable() == getVariable()) {
				return ((BoolVariableValue)vv).isBool();
			}
		}
		return false;
	}

} //BooleanTermImpl
