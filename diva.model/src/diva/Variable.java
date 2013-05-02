/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva;

import java.util.List;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see diva.DivaPackage#getVariable()
 * @model abstract="true"
 * @generated
 */
public interface Variable extends NamedElement {

	/**
	 * @generated NOT
	 * @return
	 */
	List<VariableValue> allValue();
} // Variable
