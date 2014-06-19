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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scored Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link diva.ScoredElement#getTotalScore <em>Total Score</em>}</li>
 *   <li>{@link diva.ScoredElement#getScore <em>Score</em>}</li>
 * </ul>
 * </p>
 *
 * @see diva.DivaPackage#getScoredElement()
 * @model abstract="true"
 * @generated
 */
public interface ScoredElement extends DiVAModelElement {
	/**
	 * Returns the value of the '<em><b>Total Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Score</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Score</em>' attribute.
	 * @see #setTotalScore(int)
	 * @see diva.DivaPackage#getScoredElement_TotalScore()
	 * @model
	 * @generated
	 */
	int getTotalScore();

	/**
	 * Sets the value of the '{@link diva.ScoredElement#getTotalScore <em>Total Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Score</em>' attribute.
	 * @see #getTotalScore()
	 * @generated
	 */
	void setTotalScore(int value);

	/**
	 * Returns the value of the '<em><b>Score</b></em>' containment reference list.
	 * The list contents are of type {@link diva.Score}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Score</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Score</em>' containment reference list.
	 * @see diva.DivaPackage#getScoredElement_Score()
	 * @model containment="true"
	 * @generated
	 */
	EList<Score> getScore();

} // ScoredElement
