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
 * A representation of the model object '<em><b>Or Term</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see diva.DivaPackage#getOrTerm()
 * @model
 * @generated
 */
public interface OrTerm extends NaryTerm {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitOrTerm(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitOrTerm(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // OrTerm
