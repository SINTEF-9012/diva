/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva_context;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link diva_context.Context#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see diva_context.Diva_contextPackage#getContext()
 * @model
 * @generated
 */
public interface Context extends EObject {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' containment reference list.
	 * The list contents are of type {@link diva_context.ContextElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' containment reference list.
	 * @see diva_context.Diva_contextPackage#getContext_Element()
	 * @model containment="true"
	 * @generated
	 */
	EList<ContextElement> getElement();

} // Context
