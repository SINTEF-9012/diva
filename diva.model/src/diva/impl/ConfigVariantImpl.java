/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import diva.ConfigVariant;
import diva.DivaPackage;
import diva.Property;
import diva.PropertyValue;
import diva.Score;
import diva.Variant;
import diva.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Config Variant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link diva.impl.ConfigVariantImpl#getVariant <em>Variant</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigVariantImpl extends ScoredElementImpl implements ConfigVariant {
	/**
	 * The cached value of the '{@link #getVariant() <em>Variant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariant()
	 * @generated
	 * @ordered
	 */
	protected Variant variant;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigVariantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DivaPackage.Literals.CONFIG_VARIANT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variant getVariant() {
		if (variant != null && variant.eIsProxy()) {
			InternalEObject oldVariant = (InternalEObject)variant;
			variant = (Variant)eResolveProxy(oldVariant);
			if (variant != oldVariant) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DivaPackage.CONFIG_VARIANT__VARIANT, oldVariant, variant));
			}
		}
		return variant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variant basicGetVariant() {
		return variant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariant(Variant newVariant) {
		Variant oldVariant = variant;
		variant = newVariant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DivaPackage.CONFIG_VARIANT__VARIANT, oldVariant, variant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(Visitor<C, R> visitor, C context) {
		return visitor.visitConfigVariant(this, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DivaPackage.CONFIG_VARIANT__VARIANT:
				if (resolve) return getVariant();
				return basicGetVariant();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DivaPackage.CONFIG_VARIANT__VARIANT:
				setVariant((Variant)newValue);
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
			case DivaPackage.CONFIG_VARIANT__VARIANT:
				setVariant((Variant)null);
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
			case DivaPackage.CONFIG_VARIANT__VARIANT:
				return variant != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @generated NOT
	 */
	public int getContribution(Property property) {
		for(PropertyValue pv : getVariant().getPropertyValue()) {
			if (pv.getProperty() == property)
				return pv.getValue();
		}
		return 0;
	}

	/**
	 * @generated NOT
	 */
	public void computeTotalScore() {
		setTotalScore(0);
		for(Score s : getScore())
			setTotalScore(getTotalScore() + s.getScore());		
	}

} //ConfigVariantImpl
