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
 * A representation of the model object '<em><b>Enum Variable Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link diva.EnumVariableValue#getLiteral <em>Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see diva.DivaPackage#getEnumVariableValue()
 * @model
 * @generated
 */
public interface EnumVariableValue extends VariableValue {
	/**
	 * Returns the value of the '<em><b>Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' reference.
	 * @see #setLiteral(EnumLiteral)
	 * @see diva.DivaPackage#getEnumVariableValue_Literal()
	 * @model required="true"
	 * @generated
	 */
	EnumLiteral getLiteral();

	/**
	 * Sets the value of the '{@link diva.EnumVariableValue#getLiteral <em>Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal</em>' reference.
	 * @see #getLiteral()
	 * @generated
	 */
	void setLiteral(EnumLiteral value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitEnumVariableValue(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitEnumVariableValue(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // EnumVariableValue
