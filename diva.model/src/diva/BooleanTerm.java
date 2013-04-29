/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva;

import diva.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Term</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see diva.DivaPackage#getBooleanTerm()
 * @model
 * @generated
 */
public interface BooleanTerm extends VariableTerm {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitBooleanTerm(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitBooleanTerm(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // BooleanTerm
