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
 * A representation of the model object '<em><b>Enum Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see diva.DivaPackage#getEnumLiteral()
 * @model
 * @generated
 */
public interface EnumLiteral extends NamedElement, CEPable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitEnumLiteral(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitEnumLiteral(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // EnumLiteral
