/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva;

import diva.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Model</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see diva.DivaPackage#getBaseModel()
 * @model
 * @generated
 */
public interface BaseModel extends Model {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void weave();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitBaseModel(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitBaseModel(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // BaseModel
