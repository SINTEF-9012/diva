/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva;

import java.util.Set;

import org.eclipse.emf.common.util.EList;

import diva.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link diva.Context#getVariable <em>Variable</em>}</li>
 *   <li>{@link diva.Context#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link diva.Context#getOracle <em>Oracle</em>}</li>
 *   <li>{@link diva.Context#getVerdict <em>Verdict</em>}</li>
 *   <li>{@link diva.Context#getPriority <em>Priority</em>}</li>
 * </ul>
 * </p>
 *
 * @see diva.DivaPackage#getContext()
 * @model
 * @generated
 */
public interface Context extends NamedElement {
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
	 * @see diva.DivaPackage#getContext_Variable()
	 * @model containment="true"
	 * @generated
	 */
	EList<VariableValue> getVariable();

	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' containment reference list.
	 * The list contents are of type {@link diva.Configuration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' containment reference list.
	 * @see diva.DivaPackage#getContext_Configuration()
	 * @model containment="true"
	 * @generated
	 */
	EList<Configuration> getConfiguration();

	/**
	 * Returns the value of the '<em><b>Oracle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Oracle</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Oracle</em>' containment reference.
	 * @see #setOracle(VariantExpression)
	 * @see diva.DivaPackage#getContext_Oracle()
	 * @model containment="true"
	 * @generated
	 */
	VariantExpression getOracle();

	/**
	 * Sets the value of the '{@link diva.Context#getOracle <em>Oracle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Oracle</em>' containment reference.
	 * @see #getOracle()
	 * @generated
	 */
	void setOracle(VariantExpression value);

	/**
	 * Returns the value of the '<em><b>Verdict</b></em>' attribute.
	 * The literals are from the enumeration {@link diva.Verdict}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Verdict</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Verdict</em>' attribute.
	 * @see diva.Verdict
	 * @see #setVerdict(Verdict)
	 * @see diva.DivaPackage#getContext_Verdict()
	 * @model
	 * @generated
	 */
	Verdict getVerdict();

	/**
	 * Sets the value of the '{@link diva.Context#getVerdict <em>Verdict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verdict</em>' attribute.
	 * @see diva.Verdict
	 * @see #getVerdict()
	 * @generated
	 */
	void setVerdict(Verdict value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' containment reference list.
	 * The list contents are of type {@link diva.Priority}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' containment reference list.
	 * @see diva.DivaPackage#getContext_Priority()
	 * @model containment="true"
	 * @generated
	 */
	EList<Priority> getPriority();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return visitor.visitContext(this, context);'"
	 *        annotation="kermeta body='do\nresult := visitor.visitContext(self, context)\nend' isAbstract='false'"
	 * @generated
	 */
	<C, R> R accept(Visitor<C, R> visitor, C context);

	/**
	 * @generated NOT
	 * @param simuModel
	 */
	void computePriorities(SimulationModel simuModel);

	/**
	 * @generated NOT
	 * @param simuModel
	 */
	void computeScores(SimulationModel simuModel);

	/**
	 * @generated NOT
	 */
	void computeVerdicts();
	
	/**
	 * @generated NOT
	 */
	Configuration bestConfiguration();

	/**
	 * @generated NOT
	 */
	Set<VariableValue> changes_from(Context other);
	
} // Context
