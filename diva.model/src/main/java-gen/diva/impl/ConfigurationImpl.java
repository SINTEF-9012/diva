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
import org.eclipse.emf.ecore.util.InternalEList;

import diva.ConfigVariant;
import diva.Configuration;
import diva.Context;
import diva.Dimension;
import diva.DivaFactory;
import diva.DivaPackage;
import diva.Priority;
import diva.Score;
import diva.VariabilityModel;
import diva.Variant;
import diva.VariantExpression;
import diva.Verdict;
import diva.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link diva.impl.ConfigurationImpl#getVariant <em>Variant</em>}</li>
 *   <li>{@link diva.impl.ConfigurationImpl#getVerdict <em>Verdict</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationImpl extends ScoredElementImpl implements Configuration {
	/**
	 * The cached value of the '{@link #getVariant() <em>Variant</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariant()
	 * @generated
	 * @ordered
	 */
	protected EList<ConfigVariant> variant;

	/**
	 * The default value of the '{@link #getVerdict() <em>Verdict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerdict()
	 * @generated
	 * @ordered
	 */
	protected static final Verdict VERDICT_EDEFAULT = Verdict.NONE;
	/**
	 * The cached value of the '{@link #getVerdict() <em>Verdict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerdict()
	 * @generated
	 * @ordered
	 */
	protected Verdict verdict = VERDICT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DivaPackage.Literals.CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConfigVariant> getVariant() {
		if (variant == null) {
			variant = new EObjectContainmentEList<ConfigVariant>(ConfigVariant.class, this, DivaPackage.CONFIGURATION__VARIANT);
		}
		return variant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Verdict getVerdict() {
		return verdict;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVerdict(Verdict newVerdict) {
		Verdict oldVerdict = verdict;
		verdict = newVerdict == null ? VERDICT_EDEFAULT : newVerdict;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DivaPackage.CONFIGURATION__VERDICT, oldVerdict, verdict));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(final Visitor<C, R> visitor, final C context) {
		return visitor.visitConfiguration(this, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DivaPackage.CONFIGURATION__VARIANT:
				return ((InternalEList<?>)getVariant()).basicRemove(otherEnd, msgs);
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
			case DivaPackage.CONFIGURATION__VARIANT:
				return getVariant();
			case DivaPackage.CONFIGURATION__VERDICT:
				return getVerdict();
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
			case DivaPackage.CONFIGURATION__VARIANT:
				getVariant().clear();
				getVariant().addAll((Collection<? extends ConfigVariant>)newValue);
				return;
			case DivaPackage.CONFIGURATION__VERDICT:
				setVerdict((Verdict)newValue);
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
			case DivaPackage.CONFIGURATION__VARIANT:
				getVariant().clear();
				return;
			case DivaPackage.CONFIGURATION__VERDICT:
				setVerdict(VERDICT_EDEFAULT);
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
			case DivaPackage.CONFIGURATION__VARIANT:
				return variant != null && !variant.isEmpty();
			case DivaPackage.CONFIGURATION__VERDICT:
				return verdict != VERDICT_EDEFAULT;
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
		result.append(" (verdict: ");
		result.append(verdict);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * @generated NOT
	 */
	public void addVariant(Variant v) {
		ConfigVariant cv = DivaFactory.eINSTANCE.createConfigVariant();
		cv.setVariant(v);
		getVariant().add(cv);
	}

	/**
	 * @generated NOT
	 */
	public void computeScore(Context ctx) {
		final int k = 2;
		int totalScore = 0;
		getScore().clear();
		for(ConfigVariant variant : getVariant()){
			variant.getScore().clear();
		}
		for(Priority priority : ctx.getPriority()) {
			Score cfgScore = DivaFactory.eINSTANCE.createScore();
			cfgScore.setProperty(priority.getProperty());
			cfgScore.setScore(0);
			for(ConfigVariant variant : getVariant()){
				Score varScore = DivaFactory.eINSTANCE.createScore();
				varScore.setProperty(priority.getProperty());
				varScore.setScore(new Double(Math.pow(priority.getPriority(), k) * variant.getContribution(priority.getProperty())).intValue());
				if(priority.getProperty().getDirection() == 0) {
					varScore.setScore(-varScore.getScore());
				}
				variant.getScore().add(varScore);
				variant.setTotalScore(variant.getTotalScore() + varScore.getScore());
				cfgScore.setScore(cfgScore.getScore() + varScore.getScore());
			}
			totalScore += cfgScore.getScore();
		}
		setTotalScore(totalScore);
		for(ConfigVariant variant : getVariant()){
			variant.computeTotalScore();
		}
	}

	/**
	 * @generated NOT;
	 */
	public void computeVerdicts(VariantExpression oracle) {
		if (oracle != null)
			if (oracle.eval(null, this))
				setVerdict(Verdict.PASS);
			else
				setVerdict(Verdict.FAIL);
	}

	@Override
	/**
	 * @generated NOT
	 */
	public String id(VariabilityModel m) {
		String result = "CFG";
		for(Dimension d : m.getDimension()) {
			for(Variant v : d.getVariant()) {
				for(ConfigVariant cv : getVariant()) {
					if (cv.getVariant().equals(v)) {
						result += "_" + v.getId();
						break;
					}
				}
			}
		}
		return result;
	}

} //ConfigurationImpl
