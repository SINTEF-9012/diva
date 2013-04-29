/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva;

import diva.visitors.Visitor;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dimension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link diva.Dimension#getVariant <em>Variant</em>}</li>
 *   <li>{@link diva.Dimension#getProperty <em>Property</em>}</li>
 *   <li>{@link diva.Dimension#getUpper <em>Upper</em>}</li>
 *   <li>{@link diva.Dimension#getLower <em>Lower</em>}</li>
 *   <li>{@link diva.Dimension#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see diva.DivaPackage#getDimension()
 * @model
 * @generated
 */
public interface Dimension extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Variant</b></em>' containment reference list.
	 * The list contents are of type {@link diva.Variant}.
	 * It is bidirectional and its opposite is '{@link diva.Variant#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variant</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variant</em>' containment reference list.
	 * @see diva.DivaPackage#getDimension_Variant()
	 * @see diva.Variant#getType
	 * @model opposite="type" containment="true"
	 * @generated
	 */
	EList<Variant> getVariant();

	/**
	 * Returns the value of the '<em><b>Property</b></em>' reference list.
	 * The list contents are of type {@link diva.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' reference list.
	 * @see diva.DivaPackage#getDimension_Property()
	 * @model
	 * @generated
	 */
	EList<Property> getProperty();

	/**
	 * Returns the value of the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper</em>' attribute.
	 * @see #setUpper(int)
	 * @see diva.DivaPackage#getDimension_Upper()
	 * @model dataType="diva.Integer"
	 * @generated
	 */
	int getUpper();

	/**
	 * Sets the value of the '{@link diva.Dimension#getUpper <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper</em>' attribute.
	 * @see #getUpper()
	 * @generated
	 */
	void setUpper(int value);

	/**
	 * Returns the value of the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower</em>' attribute.
	 * @see #setLower(int)
	 * @see diva.DivaPackage#getDimension_Lower()
	 * @model dataType="diva.Integer"
	 * @generated
	 */
	int getLower();

	/**
	 * Sets the value of the '{@link diva.Dimension#getLower <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower</em>' attribute.
	 * @see #getLower()
	 * @generated
	 */
	void setLower(int value);

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link diva.MultiplicityConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see diva.DivaPackage#getDimension_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<MultiplicityConstraint> getConstraints();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitDimension(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitDimension(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // Dimension
