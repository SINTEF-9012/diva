/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nary Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link diva.NaryTerm#getTerm <em>Term</em>}</li>
 * </ul>
 * </p>
 *
 * @see diva.DivaPackage#getNaryTerm()
 * @model abstract="true"
 * @generated
 */
public interface NaryTerm extends Term {
	/**
	 * Returns the value of the '<em><b>Term</b></em>' containment reference list.
	 * The list contents are of type {@link diva.Term}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Term</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Term</em>' containment reference list.
	 * @see diva.DivaPackage#getNaryTerm_Term()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Term> getTerm();

} // NaryTerm
