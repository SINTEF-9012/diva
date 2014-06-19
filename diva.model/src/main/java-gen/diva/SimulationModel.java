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
package diva;

import org.eclipse.emf.common.util.EList;

import diva.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simulation Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link diva.SimulationModel#getScenario <em>Scenario</em>}</li>
 *   <li>{@link diva.SimulationModel#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see diva.DivaPackage#getSimulationModel()
 * @model
 * @generated
 */
public interface SimulationModel extends DiVAModelElement {
	/**
	 * Returns the value of the '<em><b>Scenario</b></em>' containment reference list.
	 * The list contents are of type {@link diva.Scenario}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scenario</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scenario</em>' containment reference list.
	 * @see diva.DivaPackage#getSimulationModel_Scenario()
	 * @model containment="true"
	 * @generated
	 */
	EList<Scenario> getScenario();

	/**
	 * Returns the value of the '<em><b>Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link diva.VariabilityModel#getSimulation <em>Simulation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' container reference.
	 * @see #setModel(VariabilityModel)
	 * @see diva.DivaPackage#getSimulationModel_Model()
	 * @see diva.VariabilityModel#getSimulation
	 * @model opposite="simulation" required="true" transient="false"
	 * @generated
	 */
	VariabilityModel getModel();

	/**
	 * Sets the value of the '{@link diva.SimulationModel#getModel <em>Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' container reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(VariabilityModel value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitSimulationModel(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitSimulationModel(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);
	
	/**
	 * @generated NOT
	 */
	void populatePriorities();
	
	/**
	 * @generated NOT
	 */	
	public void populateScores();
	
	/**
	 * @generated NOT
	 */
	public void populateVerdicts();

	/**
	 * @generated NOT
	 */
	void createExhaustiveSimulation();

} // SimulationModel
