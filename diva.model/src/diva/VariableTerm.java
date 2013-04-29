/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link diva.VariableTerm#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see diva.DivaPackage#getVariableTerm()
 * @model abstract="true"
 * @generated
 */
public interface VariableTerm extends Term {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(Variable)
	 * @see diva.DivaPackage#getVariableTerm_Variable()
	 * @model required="true"
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link diva.VariableTerm#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Variable value);

} // VariableTerm
