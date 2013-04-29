/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva.impl;

import org.eclipse.emf.ecore.EClass;

import diva.DivaPackage;
import diva.EnumLiteral;
import diva.EnumVariable;
import diva.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class EnumLiteralImpl extends NamedElementImpl implements EnumLiteral {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DivaPackage.Literals.ENUM_LITERAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(Visitor<C, R> visitor, C context) {
		return visitor.visitEnumLiteral(this, context);
	}

	/**
	 * @generated NOT
	 */
	public void toAlloy(StringBuilder builder) {
		builder.append("lone sig " + ((EnumVariable)eContainer()).getId() + "_" + getId() + " extends " + ((EnumVariable)eContainer()).getId() + " {}\n");
	}
} //EnumLiteralImpl
