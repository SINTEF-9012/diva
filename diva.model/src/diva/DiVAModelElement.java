/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva;

import org.eclipse.emf.common.util.EList;

import diva.visitors.Visitable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Di VA Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link diva.DiVAModelElement#getAnnotation <em>Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @see diva.DivaPackage#getDiVAModelElement()
 * @model abstract="true"
 * @generated
 */
public interface DiVAModelElement extends Visitable {
	/**
	 * Returns the value of the '<em><b>Annotation</b></em>' containment reference list.
	 * The list contents are of type {@link diva.Annotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation</em>' containment reference list.
	 * @see diva.DivaPackage#getDiVAModelElement_Annotation()
	 * @model containment="true"
	 * @generated
	 */
	EList<Annotation> getAnnotation();
	
	/**
	 * @generated NOT
	 * @return
	 */
	void toAlloy(StringBuilder builder);

} // DiVAModelElement
