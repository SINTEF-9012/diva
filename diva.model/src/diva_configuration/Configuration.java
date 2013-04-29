/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva_configuration;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link diva_configuration.Configuration#getScore <em>Score</em>}</li>
 *   <li>{@link diva_configuration.Configuration#getAspect <em>Aspect</em>}</li>
 * </ul>
 * </p>
 *
 * @see diva_configuration.Diva_configurationPackage#getConfiguration()
 * @model
 * @generated
 */
public interface Configuration extends EObject {
	/**
	 * Returns the value of the '<em><b>Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Score</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Score</em>' attribute.
	 * @see #setScore(int)
	 * @see diva_configuration.Diva_configurationPackage#getConfiguration_Score()
	 * @model
	 * @generated
	 */
	int getScore();

	/**
	 * Sets the value of the '{@link diva_configuration.Configuration#getScore <em>Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Score</em>' attribute.
	 * @see #getScore()
	 * @generated
	 */
	void setScore(int value);

	/**
	 * Returns the value of the '<em><b>Aspect</b></em>' containment reference list.
	 * The list contents are of type {@link diva_configuration.Aspect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aspect</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspect</em>' containment reference list.
	 * @see diva_configuration.Diva_configurationPackage#getConfiguration_Aspect()
	 * @model containment="true"
	 * @generated
	 */
	EList<Aspect> getAspect();

} // Configuration
