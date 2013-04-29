/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva_configuration.impl;

import diva_configuration.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Diva_configurationFactoryImpl extends EFactoryImpl implements Diva_configurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Diva_configurationFactory init() {
		try {
			Diva_configurationFactory theDiva_configurationFactory = (Diva_configurationFactory)EPackage.Registry.INSTANCE.getEFactory("http://diva_configuration/1.0"); 
			if (theDiva_configurationFactory != null) {
				return theDiva_configurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Diva_configurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diva_configurationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Diva_configurationPackage.SUITABLE_CONFIGURATIONS: return createSuitableConfigurations();
			case Diva_configurationPackage.CONFIGURATION: return createConfiguration();
			case Diva_configurationPackage.ASPECT: return createAspect();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SuitableConfigurations createSuitableConfigurations() {
		SuitableConfigurationsImpl suitableConfigurations = new SuitableConfigurationsImpl();
		return suitableConfigurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration createConfiguration() {
		ConfigurationImpl configuration = new ConfigurationImpl();
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Aspect createAspect() {
		AspectImpl aspect = new AspectImpl();
		return aspect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diva_configurationPackage getDiva_configurationPackage() {
		return (Diva_configurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Diva_configurationPackage getPackage() {
		return Diva_configurationPackage.eINSTANCE;
	}

} //Diva_configurationFactoryImpl
