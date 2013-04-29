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
 * A representation of the model object '<em><b>Configuration Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link diva.ConfigurationModel#getConfigurations <em>Configurations</em>}</li>
 * </ul>
 * </p>
 *
 * @see diva.DivaPackage#getConfigurationModel()
 * @model
 * @generated
 */
public interface ConfigurationModel extends Visitable {
	/**
	 * Returns the value of the '<em><b>Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link diva.SuitableConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configurations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configurations</em>' containment reference list.
	 * @see diva.DivaPackage#getConfigurationModel_Configurations()
	 * @model containment="true"
	 * @generated
	 */
	EList<SuitableConfiguration> getConfigurations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitConfigurationModel(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitConfigurationModel(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

} // ConfigurationModel
