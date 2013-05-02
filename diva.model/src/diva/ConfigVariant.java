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
 * A representation of the model object '<em><b>Config Variant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link diva.ConfigVariant#getVariant <em>Variant</em>}</li>
 * </ul>
 * </p>
 *
 * @see diva.DivaPackage#getConfigVariant()
 * @model
 * @generated
 */
public interface ConfigVariant extends ScoredElement {
	/**
	 * Returns the value of the '<em><b>Variant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variant</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variant</em>' reference.
	 * @see #setVariant(Variant)
	 * @see diva.DivaPackage#getConfigVariant_Variant()
	 * @model required="true"
	 * @generated
	 */
	Variant getVariant();

	/**
	 * Sets the value of the '{@link diva.ConfigVariant#getVariant <em>Variant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variant</em>' reference.
	 * @see #getVariant()
	 * @generated
	 */
	void setVariant(Variant value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitConfigVariant(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitConfigVariant(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

	/**
	 * @generated NOT
	 * @param property
	 * @return
	 */
	int getContribution(Property property);

	/**
	 * @generated NOT
	 */
	void computeTotalScore();

} // ConfigVariant
