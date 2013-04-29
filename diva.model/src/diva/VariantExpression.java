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
 * A representation of the model object '<em><b>Variant Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see diva.DivaPackage#getVariantExpression()
 * @model
 * @generated
 */
public interface VariantExpression extends Expression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitVariantExpression(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitVariantExpression(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // VariantExpression
