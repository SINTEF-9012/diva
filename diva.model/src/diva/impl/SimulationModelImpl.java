/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import diva.Context;
import diva.DivaFactory;
import diva.DivaPackage;
import diva.Scenario;
import diva.SimulationModel;
import diva.VariabilityModel;
import diva.Variable;
import diva.VariableValue;
import diva.helpers.ListCombinationGenerator;
import diva.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simulation Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link diva.impl.SimulationModelImpl#getScenario <em>Scenario</em>}</li>
 *   <li>{@link diva.impl.SimulationModelImpl#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimulationModelImpl extends DiVAModelElementImpl implements SimulationModel {
	/**
	 * The cached value of the '{@link #getScenario() <em>Scenario</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenario()
	 * @generated
	 * @ordered
	 */
	protected EList<Scenario> scenario;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimulationModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DivaPackage.Literals.SIMULATION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Scenario> getScenario() {
		if (scenario == null) {
			scenario = new EObjectContainmentEList<Scenario>(Scenario.class, this, DivaPackage.SIMULATION_MODEL__SCENARIO);
		}
		return scenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariabilityModel getModel() {
		if (eContainerFeatureID() != DivaPackage.SIMULATION_MODEL__MODEL) return null;
		return (VariabilityModel)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModel(VariabilityModel newModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newModel, DivaPackage.SIMULATION_MODEL__MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(VariabilityModel newModel) {
		if (newModel != eInternalContainer() || (eContainerFeatureID() != DivaPackage.SIMULATION_MODEL__MODEL && newModel != null)) {
			if (EcoreUtil.isAncestor(this, newModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newModel != null)
				msgs = ((InternalEObject)newModel).eInverseAdd(this, DivaPackage.VARIABILITY_MODEL__SIMULATION, VariabilityModel.class, msgs);
			msgs = basicSetModel(newModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DivaPackage.SIMULATION_MODEL__MODEL, newModel, newModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(final Visitor<C, R> visitor, final C context) {
		return visitor.visitSimulationModel(this, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DivaPackage.SIMULATION_MODEL__MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetModel((VariabilityModel)otherEnd, msgs);
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
			case DivaPackage.SIMULATION_MODEL__SCENARIO:
				return ((InternalEList<?>)getScenario()).basicRemove(otherEnd, msgs);
			case DivaPackage.SIMULATION_MODEL__MODEL:
				return basicSetModel(null, msgs);
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
			case DivaPackage.SIMULATION_MODEL__MODEL:
				return eInternalContainer().eInverseRemove(this, DivaPackage.VARIABILITY_MODEL__SIMULATION, VariabilityModel.class, msgs);
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
			case DivaPackage.SIMULATION_MODEL__SCENARIO:
				return getScenario();
			case DivaPackage.SIMULATION_MODEL__MODEL:
				return getModel();
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
			case DivaPackage.SIMULATION_MODEL__SCENARIO:
				getScenario().clear();
				getScenario().addAll((Collection<? extends Scenario>)newValue);
				return;
			case DivaPackage.SIMULATION_MODEL__MODEL:
				setModel((VariabilityModel)newValue);
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
			case DivaPackage.SIMULATION_MODEL__SCENARIO:
				getScenario().clear();
				return;
			case DivaPackage.SIMULATION_MODEL__MODEL:
				setModel((VariabilityModel)null);
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
			case DivaPackage.SIMULATION_MODEL__SCENARIO:
				return scenario != null && !scenario.isEmpty();
			case DivaPackage.SIMULATION_MODEL__MODEL:
				return getModel() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @generated NOT
	 */
	public void populatePriorities() { 
		for(Scenario s : getScenario()) {
			for(Context ctx : s.getContext()) {
				//System.out.println("Processing context " + ctx.getName()  + "...");
				ctx.computePriorities(this);
			}
		}
	}
	
	/**
	 * @generated NOT
	 */	
	public void populateScores() {
		for(Scenario s : getScenario()) {
			for(Context ctx : s.getContext()) {
				//System.out.println("Processing context " + ctx.getName()  + "...");
				ctx.computeScores(this);
			}
		}
	}
	
	/**
	 * @generated NOT
	 */
	public void populateVerdicts() {
		for(Scenario s : getScenario()) {
			for(Context ctx : s.getContext()) {
				//System.out.println("Processing context " + ctx.getName()  + "...");
				ctx.computeVerdicts();
			}
		}
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void createExhaustiveSimulation() {
		Scenario s = null;
		for(Scenario scn : getScenario())
			if(scn.getName().equals("EXHAUSTIVE"))
				s = scn;
		
		if (s == null) {	
			s = DivaFactory.eINSTANCE.createScenario();
			s.setName("EXHAUSTIVE");
			getScenario().add(s);
		}
		else {
			s.getContext().clear();
		}
			
		int i = 0;
		for(List<VariableValue> vvs : allCombinations(getModel().getContext())) {
			Context c = DivaFactory.eINSTANCE.createContext();
			c.setName("Context " + i);
			c.setId("CTX_"+ (i++));
			for(VariableValue vv : vvs) {
				c.getVariable().add(EcoreUtil.copy(vv));
			}
			s.getContext().add(c);
		}
	}
	
	
	/**
	 * @generated NOT
	 */
	private List<List<VariableValue>> allCombinations(List<Variable> vars) {
		
		
		List<List<VariableValue>> result = new ArrayList<List<VariableValue>>();
		List<List<VariableValue>> ll = new ArrayList<List<VariableValue>>();
		for(Variable v : vars) {
			ll.add(v.allValue());
		}
		
		ListCombinationGenerator<VariableValue> lcg = new ListCombinationGenerator<VariableValue>(ll);
		//long before = System.nanoTime();
		while(lcg.hasMoreCombinations()){  
			List<VariableValue> currentTupel = lcg.getNextCombination();
			//System.out.println("currentTupel: " + currentTupel+ "hasMoreCombinations: "  + lcg.hasMoreCombinations());
			result.add(currentTupel);
		}
		//long after = System.nanoTime();
		//System.out.println("Nanosconds: " + (after-before) );
		
		return result;
	}
	
} //SimulationModelImpl
