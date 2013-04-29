/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva.visitors.impl;

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
import diva.DiVAModelElement;
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
import diva.Priorities;
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

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

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
	public ResultType visitVariabilityModel(VariabilityModel node, ContextType context) {
		if (node.getModel() != null) { node.getModel().accept(this, context); }
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
	public ResultType visitInvariant(Invariant node, ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		if (node.getExpression() != null) { node.getExpression().accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitBaseModel(BaseModel node, ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitAspectModel(AspectModel node, ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitEnumVariable(EnumVariable node, ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		for (int i=0; i<node.getLiteral().size(); i++) { ((diva.EnumLiteral)node.getLiteral().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitBooleanVariable(BooleanVariable node, ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitAndTerm(AndTerm node, ContextType context) {
		for (int i=0; i<node.getTerm().size(); i++) { ((diva.Term)node.getTerm().get(i)).accept(this, context); }
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitOrTerm(OrTerm node, ContextType context) {
		for (int i=0; i<node.getTerm().size(); i++) { ((diva.Term)node.getTerm().get(i)).accept(this, context); }
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitNotTerm(NotTerm node, ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		if (node.getTerm() != null) { node.getTerm().accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitVariantTerm(VariantTerm node, ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitEnumTerm(EnumTerm node, ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitBooleanTerm(BooleanTerm node, ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitEnumLiteral(EnumLiteral node, ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitVariant(Variant node, ContextType context) {
		if (node.getModel() != null) { node.getModel().accept(this, context); }
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
	public ResultType visitDimension(Dimension node, ContextType context) {
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
	public ResultType visitExpression(Expression node, ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		if (node.getTerm() != null) { node.getTerm().accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitContextExpression(ContextExpression node, ContextType context) {
		if (node.getTerm() != null) { node.getTerm().accept(this, context); }
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitVariantExpression(VariantExpression node, ContextType context) {
		if (node.getTerm() != null) { node.getTerm().accept(this, context); }
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitPriorityRule(PriorityRule node, ContextType context) {
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
	public ResultType visitProperty(Property node, ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		for (int i=0; i<node.getLiteral().size(); i++) { ((diva.PropertyLiteral)node.getLiteral().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitPropertyLiteral(PropertyLiteral node, ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitPropertyValue(PropertyValue node, ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitPropertyPriority(PropertyPriority node, ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitMultiplicityConstraint(MultiplicityConstraint node, ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		if (node.getAvailable() != null) { node.getAvailable().accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitAnnotation(Annotation node, ContextType context) {
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitSimulationModel(SimulationModel node, ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		for (int i=0; i<node.getScenario().size(); i++) { ((diva.Scenario)node.getScenario().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitContext(Context node, ContextType context) {
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
	public ResultType visitConfiguration(Configuration node, ContextType context) {
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
	public ResultType visitConfigVariant(ConfigVariant node, ContextType context) {
		for (int i=0; i<node.getScore().size(); i++) { ((diva.Score)node.getScore().get(i)).accept(this, context); }
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitScenario(Scenario node, ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		for (int i=0; i<node.getContext().size(); i++) { ((diva.Context)node.getContext().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitScore(Score node, ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitPriority(Priority node, ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitBoolVariableValue(BoolVariableValue node, ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitEnumVariableValue(EnumVariableValue node, ContextType context) {
		for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitConfigurationModel(ConfigurationModel node, ContextType context) {
		for (int i=0; i<node.getConfigurations().size(); i++) { ((diva.SuitableConfiguration)node.getConfigurations().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitSuitableConfiguration(SuitableConfiguration node, ContextType context) {
		for (int i=0; i<node.getVariant().size(); i++) { ((diva.ConfigVariant)node.getVariant().get(i)).accept(this, context); }
		return null;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultType visitContextModel(ContextModel node, ContextType context) {
		for (int i=0; i<node.getVariable().size(); i++) { ((diva.VariableValue)node.getVariable().get(i)).accept(this, context); }
		return null;
		
	}

} //TopDownVisitorImpl
