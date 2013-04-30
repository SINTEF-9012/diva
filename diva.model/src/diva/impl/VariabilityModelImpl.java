/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import diva.Constraint;
import diva.Context;
import diva.Dimension;
import diva.DivaPackage;
import diva.PriorityRule;
import diva.Property;
import diva.PropertyPriority;
import diva.PropertyValue;
import diva.Rule;
import diva.Scenario;
import diva.SimulationModel;
import diva.VariabilityModel;
import diva.Variable;
import diva.VariableValue;
import diva.Variant;
import diva.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variability Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link diva.impl.VariabilityModelImpl#getContext <em>Context</em>}</li>
 *   <li>{@link diva.impl.VariabilityModelImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link diva.impl.VariabilityModelImpl#getDimension <em>Dimension</em>}</li>
 *   <li>{@link diva.impl.VariabilityModelImpl#getRule <em>Rule</em>}</li>
 *   <li>{@link diva.impl.VariabilityModelImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link diva.impl.VariabilityModelImpl#getSimulation <em>Simulation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariabilityModelImpl extends ModelContainerImpl implements VariabilityModel {
	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> context;

	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> property;

	/**
	 * The cached value of the '{@link #getDimension() <em>Dimension</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDimension()
	 * @generated
	 * @ordered
	 */
	protected EList<Dimension> dimension;

	/**
	 * The cached value of the '{@link #getRule() <em>Rule</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRule()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> rule;

	/**
	 * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> constraint;

	/**
	 * The cached value of the '{@link #getSimulation() <em>Simulation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimulation()
	 * @generated
	 * @ordered
	 */
	protected SimulationModel simulation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariabilityModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DivaPackage.Literals.VARIABILITY_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getContext() {
		if (context == null) {
			context = new EObjectContainmentEList<Variable>(Variable.class, this, DivaPackage.VARIABILITY_MODEL__CONTEXT);
		}
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getProperty() {
		if (property == null) {
			property = new EObjectContainmentEList<Property>(Property.class, this, DivaPackage.VARIABILITY_MODEL__PROPERTY);
		}
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Dimension> getDimension() {
		if (dimension == null) {
			dimension = new EObjectContainmentEList<Dimension>(Dimension.class, this, DivaPackage.VARIABILITY_MODEL__DIMENSION);
		}
		return dimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rule> getRule() {
		if (rule == null) {
			rule = new EObjectContainmentEList<Rule>(Rule.class, this, DivaPackage.VARIABILITY_MODEL__RULE);
		}
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getConstraint() {
		if (constraint == null) {
			constraint = new EObjectContainmentEList<Constraint>(Constraint.class, this, DivaPackage.VARIABILITY_MODEL__CONSTRAINT);
		}
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationModel getSimulation() {
		return simulation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimulation(SimulationModel newSimulation, NotificationChain msgs) {
		SimulationModel oldSimulation = simulation;
		simulation = newSimulation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DivaPackage.VARIABILITY_MODEL__SIMULATION, oldSimulation, newSimulation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimulation(SimulationModel newSimulation) {
		if (newSimulation != simulation) {
			NotificationChain msgs = null;
			if (simulation != null)
				msgs = ((InternalEObject)simulation).eInverseRemove(this, DivaPackage.SIMULATION_MODEL__MODEL, SimulationModel.class, msgs);
			if (newSimulation != null)
				msgs = ((InternalEObject)newSimulation).eInverseAdd(this, DivaPackage.SIMULATION_MODEL__MODEL, SimulationModel.class, msgs);
			msgs = basicSetSimulation(newSimulation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DivaPackage.VARIABILITY_MODEL__SIMULATION, newSimulation, newSimulation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(Visitor<C, R> visitor, C context) {
		return visitor.visitVariabilityModel(this, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DivaPackage.VARIABILITY_MODEL__SIMULATION:
				if (simulation != null)
					msgs = ((InternalEObject)simulation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DivaPackage.VARIABILITY_MODEL__SIMULATION, null, msgs);
				return basicSetSimulation((SimulationModel)otherEnd, msgs);
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
			case DivaPackage.VARIABILITY_MODEL__CONTEXT:
				return ((InternalEList<?>)getContext()).basicRemove(otherEnd, msgs);
			case DivaPackage.VARIABILITY_MODEL__PROPERTY:
				return ((InternalEList<?>)getProperty()).basicRemove(otherEnd, msgs);
			case DivaPackage.VARIABILITY_MODEL__DIMENSION:
				return ((InternalEList<?>)getDimension()).basicRemove(otherEnd, msgs);
			case DivaPackage.VARIABILITY_MODEL__RULE:
				return ((InternalEList<?>)getRule()).basicRemove(otherEnd, msgs);
			case DivaPackage.VARIABILITY_MODEL__CONSTRAINT:
				return ((InternalEList<?>)getConstraint()).basicRemove(otherEnd, msgs);
			case DivaPackage.VARIABILITY_MODEL__SIMULATION:
				return basicSetSimulation(null, msgs);
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
			case DivaPackage.VARIABILITY_MODEL__CONTEXT:
				return getContext();
			case DivaPackage.VARIABILITY_MODEL__PROPERTY:
				return getProperty();
			case DivaPackage.VARIABILITY_MODEL__DIMENSION:
				return getDimension();
			case DivaPackage.VARIABILITY_MODEL__RULE:
				return getRule();
			case DivaPackage.VARIABILITY_MODEL__CONSTRAINT:
				return getConstraint();
			case DivaPackage.VARIABILITY_MODEL__SIMULATION:
				return getSimulation();
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
			case DivaPackage.VARIABILITY_MODEL__CONTEXT:
				getContext().clear();
				getContext().addAll((Collection<? extends Variable>)newValue);
				return;
			case DivaPackage.VARIABILITY_MODEL__PROPERTY:
				getProperty().clear();
				getProperty().addAll((Collection<? extends Property>)newValue);
				return;
			case DivaPackage.VARIABILITY_MODEL__DIMENSION:
				getDimension().clear();
				getDimension().addAll((Collection<? extends Dimension>)newValue);
				return;
			case DivaPackage.VARIABILITY_MODEL__RULE:
				getRule().clear();
				getRule().addAll((Collection<? extends Rule>)newValue);
				return;
			case DivaPackage.VARIABILITY_MODEL__CONSTRAINT:
				getConstraint().clear();
				getConstraint().addAll((Collection<? extends Constraint>)newValue);
				return;
			case DivaPackage.VARIABILITY_MODEL__SIMULATION:
				setSimulation((SimulationModel)newValue);
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
			case DivaPackage.VARIABILITY_MODEL__CONTEXT:
				getContext().clear();
				return;
			case DivaPackage.VARIABILITY_MODEL__PROPERTY:
				getProperty().clear();
				return;
			case DivaPackage.VARIABILITY_MODEL__DIMENSION:
				getDimension().clear();
				return;
			case DivaPackage.VARIABILITY_MODEL__RULE:
				getRule().clear();
				return;
			case DivaPackage.VARIABILITY_MODEL__CONSTRAINT:
				getConstraint().clear();
				return;
			case DivaPackage.VARIABILITY_MODEL__SIMULATION:
				setSimulation((SimulationModel)null);
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
			case DivaPackage.VARIABILITY_MODEL__CONTEXT:
				return context != null && !context.isEmpty();
			case DivaPackage.VARIABILITY_MODEL__PROPERTY:
				return property != null && !property.isEmpty();
			case DivaPackage.VARIABILITY_MODEL__DIMENSION:
				return dimension != null && !dimension.isEmpty();
			case DivaPackage.VARIABILITY_MODEL__RULE:
				return rule != null && !rule.isEmpty();
			case DivaPackage.VARIABILITY_MODEL__CONSTRAINT:
				return constraint != null && !constraint.isEmpty();
			case DivaPackage.VARIABILITY_MODEL__SIMULATION:
				return simulation != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @generated NOT
	 */
	public void toAlloy(StringBuilder builder) {
		builder.append("/* ********************\n");
		builder.append("* Configuration description\n");
		builder.append("**********************/\n");
		builder.append("one sig Configuration {\n");
		builder.append("variants : set Variant,\n");
		builder.append("context : set Context\n");
		builder.append("}\n\n");
		
		builder.append("abstract sig Variant {}\n");
		builder.append("fact { one c: Configuration | all var: Variant | var in c.variants }\n\n");

		builder.append("abstract sig Context {}\n");
		builder.append("fact { one c: Configuration | all ctx: Context | ctx in c.context }\n\n");
		
		
		builder.append("/* ********************\n");
		builder.append("* Context description\n");
		builder.append("**********************/\n");
		
		for(Variable v : getContext()) {
			v.toAlloy(builder);
		}
		
		
		builder.append("/* ********************\n");
		builder.append("* Variability description\n");
		builder.append("**********************/\n");
		
		for(Dimension d : getDimension()) {
			d.toAlloy(builder);
		}
	}
	
	/**
	 * @generated NOT
	 */
	public void clean() {
		
		if (getSimulation() != null) {
			// remove simulation data
			for(Scenario scn : getSimulation().getScenario()) {
				for(Context ctx : scn.getContext()) {
					ctx.getPriority().clear();
					ctx.getConfiguration().clear();
					EList<VariableValue> vars = new BasicEList<VariableValue>();
					for(VariableValue vv : ctx.getVariable()) {
						if (vv.getVariable() == null)
							vars.add(vv);
					}
					ctx.getVariable().removeAll(vars);
				}
			}
		}
				
		// remove unused property values on variants
		for(Dimension dim : getDimension()) {
			for(Variant v : dim.getVariant()) {
				EList<PropertyValue> toRemove = new BasicEList<PropertyValue>();
				for(PropertyValue pv : v.getPropertyValue()) {
					if (pv.getProperty() == null)
						toRemove.add(pv);
				}
				v.getPropertyValue().removeAll(toRemove);
			}
		}
		
		// remove unused PropertyPriority on rules
		for(Rule r : getRule()) {
			if (r instanceof PriorityRule) {
				PriorityRule pr = (PriorityRule) r;
				EList<PropertyPriority> toRemove = new BasicEList<PropertyPriority>();
				for(PropertyPriority pp : pr.getPriority()) {
					if (pp.getProperty() == null)
						toRemove.add(pp);
				}
				pr.getPriority().removeAll(toRemove);
			}
		}
			
	}
	
	/**
	 * @generated NOT
	 */
	public void populatePriorities() { 
	    if (getSimulation() != null) {
	    	for(Scenario s : getSimulation().getScenario()) {
	    		for(Context ctx : s.getContext()) {
	    			System.out.println("Processing context " + ctx.getName()  + "...");
	    			ctx.computePriorities(this);
	    		}
	    	}
	    } else {
	    	System.out.println("No simulation model found.");
	    }
        
	}
	
} //VariabilityModelImpl
