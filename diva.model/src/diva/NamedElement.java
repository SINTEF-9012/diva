/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link diva.NamedElement#getName <em>Name</em>}</li>
 *   <li>{@link diva.NamedElement#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see diva.DivaPackage#getNamedElement()
 * @model abstract="true"
 * @generated
 */
public interface NamedElement extends DiVAModelElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see diva.DivaPackage#getNamedElement_Name()
	 * @model dataType="diva.String"
	 * @generated
	 */
	String getName();
	
	/**
	 * @generated NOT
	 * @return
	 */
	String getNameNoSpace();
	
	/**
	 * Sets the value of the '{@link diva.NamedElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see diva.DivaPackage#getNamedElement_Id()
	 * @model dataType="diva.String"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link diva.NamedElement#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // NamedElement
