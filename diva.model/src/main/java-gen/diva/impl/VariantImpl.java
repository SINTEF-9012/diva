/**
 * Copyright 2014 SINTEF <brice.morin@sintef.no>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package diva.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import diva.ContextExpression;
import diva.Dimension;
import diva.DivaPackage;
import diva.PropertyValue;
import diva.Variant;
import diva.VariantExpression;
import diva.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link diva.impl.VariantImpl#getType <em>Type</em>}</li>
 *   <li>{@link diva.impl.VariantImpl#getPropertyValue <em>Property Value</em>}</li>
 *   <li>{@link diva.impl.VariantImpl#getDependency <em>Dependency</em>}</li>
 *   <li>{@link diva.impl.VariantImpl#getAvailable <em>Available</em>}</li>
 *   <li>{@link diva.impl.VariantImpl#getRequired <em>Required</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariantImpl extends NamedElementImpl implements Variant {
	/**
	 * The cached value of the '{@link #getPropertyValue() <em>Property Value</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyValue()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyValue> propertyValue;

	/**
	 * The cached value of the '{@link #getDependency() <em>Dependency</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependency()
	 * @generated
	 * @ordered
	 */
	protected VariantExpression dependency;

	/**
	 * The cached value of the '{@link #getAvailable() <em>Available</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailable()
	 * @generated
	 * @ordered
	 */
	protected ContextExpression available;

	/**
	 * The cached value of the '{@link #getRequired() <em>Required</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequired()
	 * @generated
	 * @ordered
	 */
	protected ContextExpression required;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DivaPackage.Literals.VARIANT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dimension getType() {
		if (eContainerFeatureID() != DivaPackage.VARIANT__TYPE) return null;
		return (Dimension)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(Dimension newType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newType, DivaPackage.VARIANT__TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Dimension newType) {
		if (newType != eInternalContainer() || (eContainerFeatureID() != DivaPackage.VARIANT__TYPE && newType != null)) {
			if (EcoreUtil.isAncestor(this, newType))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, DivaPackage.DIMENSION__VARIANT, Dimension.class, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DivaPackage.VARIANT__TYPE, newType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyValue> getPropertyValue() {
		if (propertyValue == null) {
			propertyValue = new EObjectContainmentEList<PropertyValue>(PropertyValue.class, this, DivaPackage.VARIANT__PROPERTY_VALUE);
		}
		return propertyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariantExpression getDependency() {
		return dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDependency(VariantExpression newDependency, NotificationChain msgs) {
		VariantExpression oldDependency = dependency;
		dependency = newDependency;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DivaPackage.VARIANT__DEPENDENCY, oldDependency, newDependency);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependency(VariantExpression newDependency) {
		if (newDependency != dependency) {
			NotificationChain msgs = null;
			if (dependency != null)
				msgs = ((InternalEObject)dependency).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DivaPackage.VARIANT__DEPENDENCY, null, msgs);
			if (newDependency != null)
				msgs = ((InternalEObject)newDependency).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DivaPackage.VARIANT__DEPENDENCY, null, msgs);
			msgs = basicSetDependency(newDependency, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DivaPackage.VARIANT__DEPENDENCY, newDependency, newDependency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextExpression getAvailable() {
		return available;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAvailable(ContextExpression newAvailable, NotificationChain msgs) {
		ContextExpression oldAvailable = available;
		available = newAvailable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DivaPackage.VARIANT__AVAILABLE, oldAvailable, newAvailable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAvailable(ContextExpression newAvailable) {
		if (newAvailable != available) {
			NotificationChain msgs = null;
			if (available != null)
				msgs = ((InternalEObject)available).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DivaPackage.VARIANT__AVAILABLE, null, msgs);
			if (newAvailable != null)
				msgs = ((InternalEObject)newAvailable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DivaPackage.VARIANT__AVAILABLE, null, msgs);
			msgs = basicSetAvailable(newAvailable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DivaPackage.VARIANT__AVAILABLE, newAvailable, newAvailable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextExpression getRequired() {
		return required;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequired(ContextExpression newRequired, NotificationChain msgs) {
		ContextExpression oldRequired = required;
		required = newRequired;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DivaPackage.VARIANT__REQUIRED, oldRequired, newRequired);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequired(ContextExpression newRequired) {
		if (newRequired != required) {
			NotificationChain msgs = null;
			if (required != null)
				msgs = ((InternalEObject)required).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DivaPackage.VARIANT__REQUIRED, null, msgs);
			if (newRequired != null)
				msgs = ((InternalEObject)newRequired).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DivaPackage.VARIANT__REQUIRED, null, msgs);
			msgs = basicSetRequired(newRequired, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DivaPackage.VARIANT__REQUIRED, newRequired, newRequired));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(final Visitor<C, R> visitor, final C context) {
		return visitor.visitVariant(this, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DivaPackage.VARIANT__TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetType((Dimension)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DivaPackage.VARIANT__TYPE:
				return basicSetType(null, msgs);
			case DivaPackage.VARIANT__PROPERTY_VALUE:
				return ((InternalEList<?>)getPropertyValue()).basicRemove(otherEnd, msgs);
			case DivaPackage.VARIANT__DEPENDENCY:
				return basicSetDependency(null, msgs);
			case DivaPackage.VARIANT__AVAILABLE:
				return basicSetAvailable(null, msgs);
			case DivaPackage.VARIANT__REQUIRED:
				return basicSetRequired(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case DivaPackage.VARIANT__TYPE:
				return eInternalContainer().eInverseRemove(this, DivaPackage.DIMENSION__VARIANT, Dimension.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DivaPackage.VARIANT__TYPE:
				return getType();
			case DivaPackage.VARIANT__PROPERTY_VALUE:
				return getPropertyValue();
			case DivaPackage.VARIANT__DEPENDENCY:
				return getDependency();
			case DivaPackage.VARIANT__AVAILABLE:
				return getAvailable();
			case DivaPackage.VARIANT__REQUIRED:
				return getRequired();
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
			case DivaPackage.VARIANT__TYPE:
				setType((Dimension)newValue);
				return;
			case DivaPackage.VARIANT__PROPERTY_VALUE:
				getPropertyValue().clear();
				getPropertyValue().addAll((Collection<? extends PropertyValue>)newValue);
				return;
			case DivaPackage.VARIANT__DEPENDENCY:
				setDependency((VariantExpression)newValue);
				return;
			case DivaPackage.VARIANT__AVAILABLE:
				setAvailable((ContextExpression)newValue);
				return;
			case DivaPackage.VARIANT__REQUIRED:
				setRequired((ContextExpression)newValue);
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
			case DivaPackage.VARIANT__TYPE:
				setType((Dimension)null);
				return;
			case DivaPackage.VARIANT__PROPERTY_VALUE:
				getPropertyValue().clear();
				return;
			case DivaPackage.VARIANT__DEPENDENCY:
				setDependency((VariantExpression)null);
				return;
			case DivaPackage.VARIANT__AVAILABLE:
				setAvailable((ContextExpression)null);
				return;
			case DivaPackage.VARIANT__REQUIRED:
				setRequired((ContextExpression)null);
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
			case DivaPackage.VARIANT__TYPE:
				return getType() != null;
			case DivaPackage.VARIANT__PROPERTY_VALUE:
				return propertyValue != null && !propertyValue.isEmpty();
			case DivaPackage.VARIANT__DEPENDENCY:
				return dependency != null;
			case DivaPackage.VARIANT__AVAILABLE:
				return available != null;
			case DivaPackage.VARIANT__REQUIRED:
				return required != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @generated NOT
	 */
	public void toAlloy(StringBuilder builder) {
		builder.append("lone sig " + getId() + " extends " + ((Dimension)eContainer()).getId() + " {}\n");
		if (getDependency() != null && getDependency().getTerm() != null) {
			builder.append("fact { one " + getId() + " implies ");
			getDependency().toAlloy(builder);
			builder.append(" }\n");
		}
		if (getAvailable() != null && getAvailable().getTerm() != null) {
			builder.append("fact { not(");
			getAvailable().toAlloy(builder);
			builder.append(") implies no " + getId());			
			builder.append("}\n");
		}
		if (getRequired() != null && getRequired().getTerm() != null) {
			builder.append("fact { ");
			getRequired().toAlloy(builder);
			builder.append(" implies one " + getId());
			builder.append("}\n");
		}
	}

} //VariantImpl
