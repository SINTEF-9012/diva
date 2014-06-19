/**
 * Copyright 2014 SINTEF <brice.morin@sintef.no>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package diva.impl;

import org.eclipse.emf.ecore.EClass;

import diva.BoolVariableValue;
import diva.BooleanTerm;
import diva.Configuration;
import diva.Context;
import diva.DivaPackage;
import diva.VariableValue;
import diva.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Term</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class BooleanTermImpl extends VariableTermImpl implements BooleanTerm {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanTermImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DivaPackage.Literals.BOOLEAN_TERM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(final Visitor<C, R> visitor, final C context) {
		return visitor.visitBooleanTerm(this, context);
	}
	
	/**
	 * @generated NOT
	 */
	public void toAlloy(StringBuilder builder) {
		builder.append("one " + getVariable().getId());
	}

	/**
	 * @generated NOT
	 */
	public boolean eval(Context ctx, Configuration cfg) {
		for(VariableValue vv : ctx.getVariable()) {
			if (vv.getVariable() == getVariable()) {
				return ((BoolVariableValue)vv).isBool();
			}
		}
		return false;
	}

} //BooleanTermImpl
