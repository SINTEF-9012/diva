/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva;

import org.eclipse.emf.common.util.EList;

import diva.visitors.Visitable;
import diva.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link diva.ContextModel#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see diva.DivaPackage#getContextModel()
 * @model
 * @generated
 */
public interface ContextModel extends Visitable {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference list.
	 * The list contents are of type {@link diva.VariableValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference list.
	 * @see diva.DivaPackage#getContextModel_Variable()
	 * @model containment="true"
	 * @generated
	 */
	EList<VariableValue> getVariable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitContextModel(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitContextModel(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // ContextModel
