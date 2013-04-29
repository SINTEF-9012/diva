/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva_configuration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import diva_configuration.Configuration;
import diva_configuration.Diva_configurationPackage;
import diva_configuration.SuitableConfigurations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Suitable Configurations</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link diva_configuration.impl.SuitableConfigurationsImpl#getConfigurations <em>Configurations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SuitableConfigurationsImpl extends EObjectImpl implements SuitableConfigurations {
	/**
	 * The cached value of the '{@link #getConfigurations() <em>Configurations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurations()
	 * @generated
	 * @ordered
	 */
	protected EList<Configuration> configurations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SuitableConfigurationsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Diva_configurationPackage.Literals.SUITABLE_CONFIGURATIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Configuration> getConfigurations() {
		if (configurations == null) {
			configurations = new EObjectContainmentEList<Configuration>(Configuration.class, this, Diva_configurationPackage.SUITABLE_CONFIGURATIONS__CONFIGURATIONS);
		}
		return configurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Diva_configurationPackage.SUITABLE_CONFIGURATIONS__CONFIGURATIONS:
				return ((InternalEList<?>)getConfigurations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Diva_configurationPackage.SUITABLE_CONFIGURATIONS__CONFIGURATIONS:
				return getConfigurations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Diva_configurationPackage.SUITABLE_CONFIGURATIONS__CONFIGURATIONS:
				getConfigurations().clear();
				getConfigurations().addAll((Collection<? extends Configuration>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Diva_configurationPackage.SUITABLE_CONFIGURATIONS__CONFIGURATIONS:
				getConfigurations().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Diva_configurationPackage.SUITABLE_CONFIGURATIONS__CONFIGURATIONS:
				return configurations != null && !configurations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SuitableConfigurationsImpl
