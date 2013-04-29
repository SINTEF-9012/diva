/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva.impl;

import diva.DivaPackage;
import diva.Score;
import diva.ScoredElement;

import diva.visitors.Visitor;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scored Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link diva.impl.ScoredElementImpl#getTotalScore <em>Total Score</em>}</li>
 *   <li>{@link diva.impl.ScoredElementImpl#getScore <em>Score</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ScoredElementImpl extends DiVAModelElementImpl implements ScoredElement {
	/**
	 * The default value of the '{@link #getTotalScore() <em>Total Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalScore()
	 * @generated
	 * @ordered
	 */
	protected static final int TOTAL_SCORE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTotalScore() <em>Total Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalScore()
	 * @generated
	 * @ordered
	 */
	protected int totalScore = TOTAL_SCORE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getScore() <em>Score</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScore()
	 * @generated
	 * @ordered
	 */
	protected EList<Score> score;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScoredElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DivaPackage.Literals.SCORED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTotalScore() {
		return totalScore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalScore(int newTotalScore) {
		int oldTotalScore = totalScore;
		totalScore = newTotalScore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DivaPackage.SCORED_ELEMENT__TOTAL_SCORE, oldTotalScore, totalScore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Score> getScore() {
		if (score == null) {
			score = new EObjectContainmentEList<Score>(Score.class, this, DivaPackage.SCORED_ELEMENT__SCORE);
		}
		return score;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DivaPackage.SCORED_ELEMENT__SCORE:
				return ((InternalEList<?>)getScore()).basicRemove(otherEnd, msgs);
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
			case DivaPackage.SCORED_ELEMENT__TOTAL_SCORE:
				return getTotalScore();
			case DivaPackage.SCORED_ELEMENT__SCORE:
				return getScore();
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
			case DivaPackage.SCORED_ELEMENT__TOTAL_SCORE:
				setTotalScore((Integer)newValue);
				return;
			case DivaPackage.SCORED_ELEMENT__SCORE:
				getScore().clear();
				getScore().addAll((Collection<? extends Score>)newValue);
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
			case DivaPackage.SCORED_ELEMENT__TOTAL_SCORE:
				setTotalScore(TOTAL_SCORE_EDEFAULT);
				return;
			case DivaPackage.SCORED_ELEMENT__SCORE:
				getScore().clear();
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
			case DivaPackage.SCORED_ELEMENT__TOTAL_SCORE:
				return totalScore != TOTAL_SCORE_EDEFAULT;
			case DivaPackage.SCORED_ELEMENT__SCORE:
				return score != null && !score.isEmpty();
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
		result.append(" (totalScore: ");
		result.append(totalScore);
		result.append(')');
		return result.toString();
	}

} //ScoredElementImpl
