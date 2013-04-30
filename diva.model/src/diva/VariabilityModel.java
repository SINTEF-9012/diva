/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva;

import org.eclipse.emf.common.util.EList;

import diva.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variability Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link diva.VariabilityModel#getContext <em>Context</em>}</li>
 *   <li>{@link diva.VariabilityModel#getProperty <em>Property</em>}</li>
 *   <li>{@link diva.VariabilityModel#getDimension <em>Dimension</em>}</li>
 *   <li>{@link diva.VariabilityModel#getRule <em>Rule</em>}</li>
 *   <li>{@link diva.VariabilityModel#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link diva.VariabilityModel#getSimulation <em>Simulation</em>}</li>
 * </ul>
 * </p>
 *
 * @see diva.DivaPackage#getVariabilityModel()
 * @model
 * @generated
 */
public interface VariabilityModel extends ModelContainer {
	/**
	 * Returns the value of the '<em><b>Context</b></em>' containment reference list.
	 * The list contents are of type {@link diva.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' containment reference list.
	 * @see diva.DivaPackage#getVariabilityModel_Context()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getContext();

	/**
	 * Returns the value of the '<em><b>Property</b></em>' containment reference list.
	 * The list contents are of type {@link diva.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' containment reference list.
	 * @see diva.DivaPackage#getVariabilityModel_Property()
	 * @model containment="true"
	 * @generated
	 */
	EList<Property> getProperty();

	/**
	 * Returns the value of the '<em><b>Dimension</b></em>' containment reference list.
	 * The list contents are of type {@link diva.Dimension}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimension</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimension</em>' containment reference list.
	 * @see diva.DivaPackage#getVariabilityModel_Dimension()
	 * @model containment="true"
	 * @generated
	 */
	EList<Dimension> getDimension();

	/**
	 * Returns the value of the '<em><b>Rule</b></em>' containment reference list.
	 * The list contents are of type {@link diva.Rule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' containment reference list.
	 * @see diva.DivaPackage#getVariabilityModel_Rule()
	 * @model containment="true"
	 * @generated
	 */
	EList<Rule> getRule();

	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' containment reference list.
	 * The list contents are of type {@link diva.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint</em>' containment reference list.
	 * @see diva.DivaPackage#getVariabilityModel_Constraint()
	 * @model containment="true"
	 * @generated
	 */
	EList<Constraint> getConstraint();

	/**
	 * Returns the value of the '<em><b>Simulation</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link diva.SimulationModel#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simulation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simulation</em>' containment reference.
	 * @see #setSimulation(SimulationModel)
	 * @see diva.DivaPackage#getVariabilityModel_Simulation()
	 * @see diva.SimulationModel#getModel
	 * @model opposite="model" containment="true"
	 * @generated
	 */
	SimulationModel getSimulation();

	/**
	 * Sets the value of the '{@link diva.VariabilityModel#getSimulation <em>Simulation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simulation</em>' containment reference.
	 * @see #getSimulation()
	 * @generated
	 */
	void setSimulation(SimulationModel value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitVariabilityModel(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitVariabilityModel(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);
	
	/**
	 * @generated NOT
	 * @param builder
	 */
	void toAlloy(StringBuilder builder);
	
	/**
	 * @generated NOT
	 */
	void clean();
	
} // VariabilityModel
