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

import diva.Configuration;
import diva.Context;
import diva.DivaPackage;
import diva.OrTerm;
import diva.Term;
import diva.visitors.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Or Term</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OrTermImpl extends NaryTermImpl implements OrTerm {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrTermImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DivaPackage.Literals.OR_TERM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C, R> R accept(final Visitor<C, R> visitor, final C context) {
		return visitor.visitOrTerm(this, context);
	}

	/**
	 * @generated NOT
	 */
	public void toAlloy(StringBuilder builder) {
		builder.append("(");
		int i = 0;
		for(Term t : getTerm()) {
			if (i > 0)
				builder.append(" or ");
			t.toAlloy(builder);
			i++;
		}
		builder.append(")");
	}
	
	/**
	 * @generated NOT
	 */
	public boolean eval(Context ctx, Configuration cfg) {
		boolean result = true;
		for(Term t : getTerm()){
			result |= t.eval(ctx, cfg);
		}
		return result;
	}
	
} //OrTermImpl
