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

import diva.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicity Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link diva.MultiplicityConstraint#getAvailable <em>Available</em>}</li>
 *   <li>{@link diva.MultiplicityConstraint#getUpper <em>Upper</em>}</li>
 *   <li>{@link diva.MultiplicityConstraint#getLower <em>Lower</em>}</li>
 * </ul>
 * </p>
 *
 * @see diva.DivaPackage#getMultiplicityConstraint()
 * @model
 * @generated
 */
public interface MultiplicityConstraint extends Constraint {
	/**
	 * Returns the value of the '<em><b>Available</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available</em>' containment reference.
	 * @see #setAvailable(ContextExpression)
	 * @see diva.DivaPackage#getMultiplicityConstraint_Available()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ContextExpression getAvailable();

	/**
	 * Sets the value of the '{@link diva.MultiplicityConstraint#getAvailable <em>Available</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Available</em>' containment reference.
	 * @see #getAvailable()
	 * @generated
	 */
	void setAvailable(ContextExpression value);

	/**
	 * Returns the value of the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper</em>' attribute.
	 * @see #setUpper(int)
	 * @see diva.DivaPackage#getMultiplicityConstraint_Upper()
	 * @model dataType="diva.Integer"
	 * @generated
	 */
	int getUpper();

	/**
	 * Sets the value of the '{@link diva.MultiplicityConstraint#getUpper <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper</em>' attribute.
	 * @see #getUpper()
	 * @generated
	 */
	void setUpper(int value);

	/**
	 * Returns the value of the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower</em>' attribute.
	 * @see #setLower(int)
	 * @see diva.DivaPackage#getMultiplicityConstraint_Lower()
	 * @model dataType="diva.Integer"
	 * @generated
	 */
	int getLower();

	/**
	 * Sets the value of the '{@link diva.MultiplicityConstraint#getLower <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower</em>' attribute.
	 * @see #getLower()
	 * @generated
	 */
	void setLower(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitMultiplicityConstraint(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitMultiplicityConstraint(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // MultiplicityConstraint
