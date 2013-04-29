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
 * A representation of the model object '<em><b>Variant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link diva.Variant#getType <em>Type</em>}</li>
 *   <li>{@link diva.Variant#getPropertyValue <em>Property Value</em>}</li>
 *   <li>{@link diva.Variant#getDependency <em>Dependency</em>}</li>
 *   <li>{@link diva.Variant#getAvailable <em>Available</em>}</li>
 *   <li>{@link diva.Variant#getRequired <em>Required</em>}</li>
 *   <li>{@link diva.Variant#getWeaveLevel <em>Weave Level</em>}</li>
 * </ul>
 * </p>
 *
 * @see diva.DivaPackage#getVariant()
 * @model
 * @generated
 */
public interface Variant extends NamedElement, ModelContainer {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link diva.Dimension#getVariant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' container reference.
	 * @see #setType(Dimension)
	 * @see diva.DivaPackage#getVariant_Type()
	 * @see diva.Dimension#getVariant
	 * @model opposite="variant" required="true" transient="false"
	 * @generated
	 */
	Dimension getType();

	/**
	 * Sets the value of the '{@link diva.Variant#getType <em>Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' container reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Dimension value);

	/**
	 * Returns the value of the '<em><b>Property Value</b></em>' containment reference list.
	 * The list contents are of type {@link diva.PropertyValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Value</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Value</em>' containment reference list.
	 * @see diva.DivaPackage#getVariant_PropertyValue()
	 * @model containment="true"
	 * @generated
	 */
	EList<PropertyValue> getPropertyValue();

	/**
	 * Returns the value of the '<em><b>Dependency</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependency</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependency</em>' containment reference.
	 * @see #setDependency(VariantExpression)
	 * @see diva.DivaPackage#getVariant_Dependency()
	 * @model containment="true"
	 * @generated
	 */
	VariantExpression getDependency();

	/**
	 * Sets the value of the '{@link diva.Variant#getDependency <em>Dependency</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependency</em>' containment reference.
	 * @see #getDependency()
	 * @generated
	 */
	void setDependency(VariantExpression value);

	/**
	 * Returns the value of the '<em><b>Available</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available</em>' containment reference.
	 * @see #setAvailable(ContextExpression)
	 * @see diva.DivaPackage#getVariant_Available()
	 * @model containment="true"
	 * @generated
	 */
	ContextExpression getAvailable();

	/**
	 * Sets the value of the '{@link diva.Variant#getAvailable <em>Available</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Available</em>' containment reference.
	 * @see #getAvailable()
	 * @generated
	 */
	void setAvailable(ContextExpression value);

	/**
	 * Returns the value of the '<em><b>Required</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required</em>' containment reference.
	 * @see #setRequired(ContextExpression)
	 * @see diva.DivaPackage#getVariant_Required()
	 * @model containment="true"
	 * @generated
	 */
	ContextExpression getRequired();

	/**
	 * Sets the value of the '{@link diva.Variant#getRequired <em>Required</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required</em>' containment reference.
	 * @see #getRequired()
	 * @generated
	 */
	void setRequired(ContextExpression value);

	/**
	 * Returns the value of the '<em><b>Weave Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weave Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weave Level</em>' attribute.
	 * @see #setWeaveLevel(int)
	 * @see diva.DivaPackage#getVariant_WeaveLevel()
	 * @model dataType="diva.Integer"
	 * @generated
	 */
	int getWeaveLevel();

	/**
	 * Sets the value of the '{@link diva.Variant#getWeaveLevel <em>Weave Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weave Level</em>' attribute.
	 * @see #getWeaveLevel()
	 * @generated
	 */
	void setWeaveLevel(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitVariant(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitVariant(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // Variant
