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
 * A representation of the model object '<em><b>Priority Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link diva.PriorityRule#getContext <em>Context</em>}</li>
 *   <li>{@link diva.PriorityRule#getPriority <em>Priority</em>}</li>
 * </ul>
 * </p>
 *
 * @see diva.DivaPackage#getPriorityRule()
 * @model
 * @generated
 */
public interface PriorityRule extends Rule {
	/**
	 * Returns the value of the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' containment reference.
	 * @see #setContext(ContextExpression)
	 * @see diva.DivaPackage#getPriorityRule_Context()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ContextExpression getContext();

	/**
	 * Sets the value of the '{@link diva.PriorityRule#getContext <em>Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' containment reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(ContextExpression value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' containment reference list.
	 * The list contents are of type {@link diva.PropertyPriority}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' containment reference list.
	 * @see diva.DivaPackage#getPriorityRule_Priority()
	 * @model containment="true"
	 * @generated
	 */
	EList<PropertyPriority> getPriority();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitPriorityRule(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitPriorityRule(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // PriorityRule
