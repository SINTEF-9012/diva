/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva.impl;

import org.eclipse.emf.ecore.EClass;

import diva.DivaPackage;
import diva.OrTerm;
import diva.Term;
import diva.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Or Term</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OrTermImpl extends NaryTermImpl implements OrTerm {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrTermImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DivaPackage.Literals.OR_TERM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(Visitor<C, R> visitor, C context) {
		return visitor.visitOrTerm(this, context);
	}

	/**
	 * @generated NOT
	 */
	public void toAlloy(StringBuilder builder) {
		builder.append("(");
		int i = 0;
		for(Term t : getTerm()) {
			if (i > 0)
				builder.append(" or ");
			t.toAlloy(builder);
			i++;
		}
		builder.append(")");
	}
	
} //OrTermImpl
