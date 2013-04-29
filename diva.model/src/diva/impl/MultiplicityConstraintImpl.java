/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva.impl;

import diva.ContextExpression;
import diva.DivaPackage;
import diva.MultiplicityConstraint;

import diva.visitors.Visitor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiplicity Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link diva.impl.MultiplicityConstraintImpl#getAvailable <em>Available</em>}</li>
 *   <li>{@link diva.impl.MultiplicityConstraintImpl#getUpper <em>Upper</em>}</li>
 *   <li>{@link diva.impl.MultiplicityConstraintImpl#getLower <em>Lower</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiplicityConstraintImpl extends ConstraintImpl implements MultiplicityConstraint {
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
	 * The default value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected static final int UPPER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected int upper = UPPER_EDEFAULT;

	/**
	 * The default value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected static final int LOWER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected int lower = LOWER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiplicityConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DivaPackage.Literals.MULTIPLICITY_CONSTRAINT;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DivaPackage.MULTIPLICITY_CONSTRAINT__AVAILABLE, oldAvailable, newAvailable);
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
				msgs = ((InternalEObject)available).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DivaPackage.MULTIPLICITY_CONSTRAINT__AVAILABLE, null, msgs);
			if (newAvailable != null)
				msgs = ((InternalEObject)newAvailable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DivaPackage.MULTIPLICITY_CONSTRAINT__AVAILABLE, null, msgs);
			msgs = basicSetAvailable(newAvailable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DivaPackage.MULTIPLICITY_CONSTRAINT__AVAILABLE, newAvailable, newAvailable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getUpper() {
		return upper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpper(int newUpper) {
		int oldUpper = upper;
		upper = newUpper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DivaPackage.MULTIPLICITY_CONSTRAINT__UPPER, oldUpper, upper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLower() {
		return lower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLower(int newLower) {
		int oldLower = lower;
		lower = newLower;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DivaPackage.MULTIPLICITY_CONSTRAINT__LOWER, oldLower, lower));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(Visitor<C, R> visitor, C context) {
		return visitor.visitMultiplicityConstraint(this, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DivaPackage.MULTIPLICITY_CONSTRAINT__AVAILABLE:
				return basicSetAvailable(null, msgs);
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
			case DivaPackage.MULTIPLICITY_CONSTRAINT__AVAILABLE:
				return getAvailable();
			case DivaPackage.MULTIPLICITY_CONSTRAINT__UPPER:
				return getUpper();
			case DivaPackage.MULTIPLICITY_CONSTRAINT__LOWER:
				return getLower();
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
			case DivaPackage.MULTIPLICITY_CONSTRAINT__AVAILABLE:
				setAvailable((ContextExpression)newValue);
				return;
			case DivaPackage.MULTIPLICITY_CONSTRAINT__UPPER:
				setUpper((Integer)newValue);
				return;
			case DivaPackage.MULTIPLICITY_CONSTRAINT__LOWER:
				setLower((Integer)newValue);
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
			case DivaPackage.MULTIPLICITY_CONSTRAINT__AVAILABLE:
				setAvailable((ContextExpression)null);
				return;
			case DivaPackage.MULTIPLICITY_CONSTRAINT__UPPER:
				setUpper(UPPER_EDEFAULT);
				return;
			case DivaPackage.MULTIPLICITY_CONSTRAINT__LOWER:
				setLower(LOWER_EDEFAULT);
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
			case DivaPackage.MULTIPLICITY_CONSTRAINT__AVAILABLE:
				return available != null;
			case DivaPackage.MULTIPLICITY_CONSTRAINT__UPPER:
				return upper != UPPER_EDEFAULT;
			case DivaPackage.MULTIPLICITY_CONSTRAINT__LOWER:
				return lower != LOWER_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (upper: ");
		result.append(upper);
		result.append(", lower: ");
		result.append(lower);
		result.append(')');
		return result.toString();
	}

} //MultiplicityConstraintImpl
