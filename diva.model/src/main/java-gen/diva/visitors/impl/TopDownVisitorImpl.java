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
package diva.visitors.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import diva.AndTerm;
import diva.Annotation;
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
import diva.visitors.TopDownVisitor;
import diva.visitors.VisitorsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Top Down Visitor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class TopDownVisitorImpl<ContextType, ResultType> extends EObjectImpl implements TopDownVisitor<ContextType, ResultType> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopDownVisitorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VisitorsPackage.Literals.TOP_DOWN_VISITOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitVariabilityModel(final VariabilityModel node, final ContextType context) {
		for (int i=0; i<node.getContext().size(); i++) { ((diva.Variable)node.getContext().get(i)).accept(this, context); }
		for (int i=0; i<node.getProperty().size(); i++) { ((diva.Property)node.getProperty().get(i)).accept(this, context); }
		for (int i=0; i<node.getDimension().size(); i++) { ((diva.Dimension)node.getDimension().get(i)).accept(this, context); }
		for (int i=0; i<node.getRule().size(); i++) { ((diva.Rule)node.getRule().get(i)).accept(this, context); }
		for (int i=0; i<node.getConstraint().size(); i++) { ((diva.Constraint)node.getConstraint().get(i)).accept(this, context); }
		if (node.getSimulation() != null) { node.getSimulation().accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitInvariant(final Invariant node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		if (node.getExpression() != null) { node.getExpression().accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitEnumVariable(final EnumVariable node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		for (int i=0; i<node.getLiteral().size(); i++) { ((diva.EnumLiteral)node.getLiteral().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitBooleanVariable(final BooleanVariable node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitAndTerm(final AndTerm node, final ContextType context) {
		for (int i=0; i<node.getTerm().size(); i++) { ((diva.Term)node.getTerm().get(i)).accept(this, context); }
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitOrTerm(final OrTerm node, final ContextType context) {
		for (int i=0; i<node.getTerm().size(); i++) { ((diva.Term)node.getTerm().get(i)).accept(this, context); }
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitNotTerm(final NotTerm node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		if (node.getTerm() != null) { node.getTerm().accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitVariantTerm(final VariantTerm node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitEnumTerm(final EnumTerm node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitBooleanTerm(final BooleanTerm node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitEnumLiteral(final EnumLiteral node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitVariant(final Variant node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		for (int i=0; i<node.getPropertyValue().size(); i++) { ((diva.PropertyValue)node.getPropertyValue().get(i)).accept(this, context); }
		if (node.getDependency() != null) { node.getDependency().accept(this, context); }
		if (node.getAvailable() != null) { node.getAvailable().accept(this, context); }
		if (node.getRequired() != null) { node.getRequired().accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitDimension(final Dimension node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		for (int i=0; i<node.getVariant().size(); i++) { ((diva.Variant)node.getVariant().get(i)).accept(this, context); }
		for (int i=0; i<node.getConstraints().size(); i++) { ((diva.MultiplicityConstraint)node.getConstraints().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitExpression(final Expression node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		if (node.getTerm() != null) { node.getTerm().accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitContextExpression(final ContextExpression node, final ContextType context) {
		if (node.getTerm() != null) { node.getTerm().accept(this, context); }
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitVariantExpression(final VariantExpression node, final ContextType context) {
		if (node.getTerm() != null) { node.getTerm().accept(this, context); }
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitPriorityRule(final PriorityRule node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		if (node.getContext() != null) { node.getContext().accept(this, context); }
		for (int i=0; i<node.getPriority().size(); i++) { ((diva.PropertyPriority)node.getPriority().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitProperty(final Property node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		for (int i=0; i<node.getLiteral().size(); i++) { ((diva.PropertyLiteral)node.getLiteral().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitPropertyLiteral(final PropertyLiteral node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitPropertyValue(final PropertyValue node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitPropertyPriority(final PropertyPriority node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitMultiplicityConstraint(final MultiplicityConstraint node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		if (node.getAvailable() != null) { node.getAvailable().accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitAnnotation(final Annotation node, final ContextType context) {
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitSimulationModel(final SimulationModel node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		for (int i=0; i<node.getScenario().size(); i++) { ((diva.Scenario)node.getScenario().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitContext(final Context node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		for (int i=0; i<node.getVariable().size(); i++) { ((diva.VariableValue)node.getVariable().get(i)).accept(this, context); }
		for (int i=0; i<node.getConfiguration().size(); i++) { ((diva.Configuration)node.getConfiguration().get(i)).accept(this, context); }
		if (node.getOracle() != null) { node.getOracle().accept(this, context); }
		for (int i=0; i<node.getPriority().size(); i++) { ((diva.Priority)node.getPriority().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitConfiguration(final Configuration node, final ContextType context) {
		for (int i=0; i<node.getScore().size(); i++) { ((diva.Score)node.getScore().get(i)).accept(this, context); }
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		for (int i=0; i<node.getVariant().size(); i++) { ((diva.ConfigVariant)node.getVariant().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitConfigVariant(final ConfigVariant node, final ContextType context) {
		for (int i=0; i<node.getScore().size(); i++) { ((diva.Score)node.getScore().get(i)).accept(this, context); }
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitScenario(final Scenario node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		for (int i=0; i<node.getContext().size(); i++) { ((diva.Context)node.getContext().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitScore(final Score node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitPriority(final Priority node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitBoolVariableValue(final BoolVariableValue node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitEnumVariableValue(final EnumVariableValue node, final ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitConfigurationModel(final ConfigurationModel node, final ContextType context) {
		for (int i=0; i<node.getConfigurations().size(); i++) { ((diva.SuitableConfiguration)node.getConfigurations().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitSuitableConfiguration(final SuitableConfiguration node, final ContextType context) {
		for (int i=0; i<node.getVariant().size(); i++) { ((diva.ConfigVariant)node.getVariant().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitContextModel(final ContextModel node, final ContextType context) {
		for (int i=0; i<node.getVariable().size(); i++) { ((diva.VariableValue)node.getVariable().get(i)).accept(this, context); }
		return null;
		
	}

} //TopDownVisitorImpl
