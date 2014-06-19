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
package diva.visitors;

import org.eclipse.emf.ecore.EObject;

import diva.AndTerm;
import diva.Annotation;
import diva.AspectModel;
import diva.BaseModel;
import diva.BoolVariableValue;
import diva.BooleanTerm;
import diva.BooleanVariable;
import diva.ConfigVariant;
import diva.Configuration;
import diva.ConfigurationModel;
import diva.Context;
import diva.ContextExpression;
import diva.ContextModel;
import diva.Dimension;
import diva.EnumLiteral;
import diva.EnumTerm;
import diva.EnumVariable;
import diva.EnumVariableValue;
import diva.Expression;
import diva.Invariant;
import diva.MultiplicityConstraint;
import diva.NotTerm;
import diva.OrTerm;
import diva.Priority;
import diva.PriorityRule;
import diva.Property;
import diva.PropertyLiteral;
import diva.PropertyPriority;
import diva.PropertyValue;
import diva.Scenario;
import diva.Score;
import diva.SimulationModel;
import diva.SuitableConfiguration;
import diva.VariabilityModel;
import diva.Variant;
import diva.VariantExpression;
import diva.VariantTerm;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visitor</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see diva.visitors.VisitorsPackage#getVisitor()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Visitor<ContextType, ResultType> extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitVariabilityModel(VariabilityModel node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitInvariant(Invariant node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitEnumVariable(EnumVariable node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitBooleanVariable(BooleanVariable node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitAndTerm(AndTerm node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitOrTerm(OrTerm node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitNotTerm(NotTerm node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitVariantTerm(VariantTerm node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitEnumTerm(EnumTerm node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitBooleanTerm(BooleanTerm node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitEnumLiteral(EnumLiteral node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitVariant(Variant node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitDimension(Dimension node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitExpression(Expression node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitContextExpression(ContextExpression node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitVariantExpression(VariantExpression node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitPriorityRule(PriorityRule node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitProperty(Property node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitPropertyLiteral(PropertyLiteral node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitPropertyValue(PropertyValue node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitPropertyPriority(PropertyPriority node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitMultiplicityConstraint(MultiplicityConstraint node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitAnnotation(Annotation node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitSimulationModel(SimulationModel node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitContext(Context node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitConfiguration(Configuration node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitConfigVariant(ConfigVariant node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitScenario(Scenario node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitScore(Score node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitPriority(Priority node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitBoolVariableValue(BoolVariableValue node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitEnumVariableValue(EnumVariableValue node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitConfigurationModel(ConfigurationModel node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitSuitableConfiguration(SuitableConfiguration node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ResultType visitContextModel(ContextModel node, ContextType context);

} // Visitor
