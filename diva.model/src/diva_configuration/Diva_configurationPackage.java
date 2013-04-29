/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva_configuration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see diva_configuration.Diva_configurationFactory
 * @model kind="package"
 * @generated
 */
public interface Diva_configurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "diva_configuration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://diva_configuration/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "diva_configuration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Diva_configurationPackage eINSTANCE = diva_configuration.impl.Diva_configurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link diva_configuration.impl.SuitableConfigurationsImpl <em>Suitable Configurations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva_configuration.impl.SuitableConfigurationsImpl
	 * @see diva_configuration.impl.Diva_configurationPackageImpl#getSuitableConfigurations()
	 * @generated
	 */
	int SUITABLE_CONFIGURATIONS = 0;

	/**
	 * The feature id for the '<em><b>Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUITABLE_CONFIGURATIONS__CONFIGURATIONS = 0;

	/**
	 * The number of structural features of the '<em>Suitable Configurations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUITABLE_CONFIGURATIONS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link diva_configuration.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva_configuration.impl.ConfigurationImpl
	 * @see diva_configuration.impl.Diva_configurationPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__SCORE = 0;

	/**
	 * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__ASPECT = 1;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link diva_configuration.impl.AspectImpl <em>Aspect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see diva_configuration.impl.AspectImpl
	 * @see diva_configuration.impl.Diva_configurationPackageImpl#getAspect()
	 * @generated
	 */
	int ASPECT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Aspect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link diva_configuration.SuitableConfigurations <em>Suitable Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Suitable Configurations</em>'.
	 * @see diva_configuration.SuitableConfigurations
	 * @generated
	 */
	EClass getSuitableConfigurations();

	/**
	 * Returns the meta object for the containment reference list '{@link diva_configuration.SuitableConfigurations#getConfigurations <em>Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configurations</em>'.
	 * @see diva_configuration.SuitableConfigurations#getConfigurations()
	 * @see #getSuitableConfigurations()
	 * @generated
	 */
	EReference getSuitableConfigurations_Configurations();

	/**
	 * Returns the meta object for class '{@link diva_configuration.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see diva_configuration.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link diva_configuration.Configuration#getScore <em>Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Score</em>'.
	 * @see diva_configuration.Configuration#getScore()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Score();

	/**
	 * Returns the meta object for the containment reference list '{@link diva_configuration.Configuration#getAspect <em>Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aspect</em>'.
	 * @see diva_configuration.Configuration#getAspect()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Aspect();

	/**
	 * Returns the meta object for class '{@link diva_configuration.Aspect <em>Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aspect</em>'.
	 * @see diva_configuration.Aspect
	 * @generated
	 */
	EClass getAspect();

	/**
	 * Returns the meta object for the attribute '{@link diva_configuration.Aspect#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see diva_configuration.Aspect#getName()
	 * @see #getAspect()
	 * @generated
	 */
	EAttribute getAspect_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Diva_configurationFactory getDiva_configurationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link diva_configuration.impl.SuitableConfigurationsImpl <em>Suitable Configurations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva_configuration.impl.SuitableConfigurationsImpl
		 * @see diva_configuration.impl.Diva_configurationPackageImpl#getSuitableConfigurations()
		 * @generated
		 */
		EClass SUITABLE_CONFIGURATIONS = eINSTANCE.getSuitableConfigurations();

		/**
		 * The meta object literal for the '<em><b>Configurations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUITABLE_CONFIGURATIONS__CONFIGURATIONS = eINSTANCE.getSuitableConfigurations_Configurations();

		/**
		 * The meta object literal for the '{@link diva_configuration.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva_configuration.impl.ConfigurationImpl
		 * @see diva_configuration.impl.Diva_configurationPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Score</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__SCORE = eINSTANCE.getConfiguration_Score();

		/**
		 * The meta object literal for the '<em><b>Aspect</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__ASPECT = eINSTANCE.getConfiguration_Aspect();

		/**
		 * The meta object literal for the '{@link diva_configuration.impl.AspectImpl <em>Aspect</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see diva_configuration.impl.AspectImpl
		 * @see diva_configuration.impl.Diva_configurationPackageImpl#getAspect()
		 * @generated
		 */
		EClass ASPECT = eINSTANCE.getAspect();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASPECT__NAME = eINSTANCE.getAspect_Name();

	}

} //Diva_configurationPackage
