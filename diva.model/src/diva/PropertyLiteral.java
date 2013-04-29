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
 * A representation of the model object '<em><b>Property Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link diva.PropertyLiteral#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see diva.DivaPackage#getPropertyLiteral()
 * @model
 * @generated
 */
public interface PropertyLiteral extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(int)
	 * @see diva.DivaPackage#getPropertyLiteral_Value()
	 * @model dataType="diva.Integer"
	 * @generated
	 */
	int getValue();

	/**
	 * Sets the value of the '{@link diva.PropertyLiteral#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitPropertyLiteral(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitPropertyLiteral(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // PropertyLiteral
