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
 * A representation of the model object '<em><b>Suitable Configurations</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link diva_configuration.SuitableConfigurations#getConfigurations <em>Configurations</em>}</li>
 * </ul>
 * </p>
 *
 * @see diva_configuration.Diva_configurationPackage#getSuitableConfigurations()
 * @model
 * @generated
 */
public interface SuitableConfigurations extends EObject {
	/**
	 * Returns the value of the '<em><b>Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link diva_configuration.Configuration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configurations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configurations</em>' containment reference list.
	 * @see diva_configuration.Diva_configurationPackage#getSuitableConfigurations_Configurations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Configuration> getConfigurations();

} // SuitableConfigurations
