/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva;

import diva.visitors.Visitable;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scored Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link diva.ScoredElement#getTotalScore <em>Total Score</em>}</li>
 *   <li>{@link diva.ScoredElement#getScore <em>Score</em>}</li>
 * </ul>
 * </p>
 *
 * @see diva.DivaPackage#getScoredElement()
 * @model abstract="true"
 * @generated
 */
public interface ScoredElement extends DiVAModelElement {
	/**
	 * Returns the value of the '<em><b>Total Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Score</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Score</em>' attribute.
	 * @see #setTotalScore(int)
	 * @see diva.DivaPackage#getScoredElement_TotalScore()
	 * @model
	 * @generated
	 */
	int getTotalScore();

	/**
	 * Sets the value of the '{@link diva.ScoredElement#getTotalScore <em>Total Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Score</em>' attribute.
	 * @see #getTotalScore()
	 * @generated
	 */
	void setTotalScore(int value);

	/**
	 * Returns the value of the '<em><b>Score</b></em>' containment reference list.
	 * The list contents are of type {@link diva.Score}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Score</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Score</em>' containment reference list.
	 * @see diva.DivaPackage#getScoredElement_Score()
	 * @model containment="true"
	 * @generated
	 */
	EList<Score> getScore();

} // ScoredElement
