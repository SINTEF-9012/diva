/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva;

import org.eclipse.emf.common.util.EList;

import diva.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link diva.EnumVariable#getLiteral <em>Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see diva.DivaPackage#getEnumVariable()
 * @model
 * @generated
 */
public interface EnumVariable extends Variable {
	/**
	 * Returns the value of the '<em><b>Literal</b></em>' containment reference list.
	 * The list contents are of type {@link diva.EnumLiteral}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' containment reference list.
	 * @see diva.DivaPackage#getEnumVariable_Literal()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<EnumLiteral> getLiteral();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitEnumVariable(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitEnumVariable(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // EnumVariable
