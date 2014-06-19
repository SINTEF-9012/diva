/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva.visitors;

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
 * A representation of the model object '<em><b>Top Down Visitor</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see diva.visitors.VisitorsPackage#getTopDownVisitor()
 * @model abstract="true"
 * @generated
 */
public interface TopDownVisitor<ContextType, ResultType> extends Visitor<ContextType, ResultType> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nif node.model != void then node.model.accept(self, context) end\nnode.context.each{ e | e.accept(self, context) }\nnode.~property.each{ e | e.accept(self, context) }\nnode.dimension.each{ e | e.accept(self, context) }\nnode.rule.each{ e | e.accept(self, context) }\nnode.constraint.each{ e | e.accept(self, context) }\nif node.simulation != void then node.simulation.accept(self, context) end\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (node.getModel() != null) { node.getModel().accept(this, context); }\nfor (int i=0; i<node.getContext().size(); i++) { ((diva.Variable)node.getContext().get(i)).accept(this, context); }\nfor (int i=0; i<node.getProperty().size(); i++) { ((diva.Property)node.getProperty().get(i)).accept(this, context); }\nfor (int i=0; i<node.getDimension().size(); i++) { ((diva.Dimension)node.getDimension().get(i)).accept(this, context); }\nfor (int i=0; i<node.getRule().size(); i++) { ((diva.Rule)node.getRule().get(i)).accept(this, context); }\nfor (int i=0; i<node.getConstraint().size(); i++) { ((diva.Constraint)node.getConstraint().get(i)).accept(this, context); }\nif (node.getSimulation() != null) { node.getSimulation().accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitVariabilityModel(VariabilityModel node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.annotation.each{ e | e.accept(self, context) }\nif node.expression != void then node.expression.accept(self, context) end\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nif (node.getExpression() != null) { node.getExpression().accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitInvariant(Invariant node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.annotation.each{ e | e.accept(self, context) }\nnode.literal.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nfor (int i=0; i<node.getLiteral().size(); i++) { ((diva.EnumLiteral)node.getLiteral().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitEnumVariable(EnumVariable node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.annotation.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitBooleanVariable(BooleanVariable node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.term.each{ e | e.accept(self, context) }\nnode.annotation.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getTerm().size(); i++) { ((diva.Term)node.getTerm().get(i)).accept(this, context); }\nfor (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitAndTerm(AndTerm node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.term.each{ e | e.accept(self, context) }\nnode.annotation.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getTerm().size(); i++) { ((diva.Term)node.getTerm().get(i)).accept(this, context); }\nfor (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitOrTerm(OrTerm node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.annotation.each{ e | e.accept(self, context) }\nif node.term != void then node.term.accept(self, context) end\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nif (node.getTerm() != null) { node.getTerm().accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitNotTerm(NotTerm node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.annotation.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitVariantTerm(VariantTerm node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.annotation.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitEnumTerm(EnumTerm node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.annotation.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitBooleanTerm(BooleanTerm node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.annotation.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitEnumLiteral(EnumLiteral node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nif node.model != void then node.model.accept(self, context) end\nnode.annotation.each{ e | e.accept(self, context) }\nnode.propertyValue.each{ e | e.accept(self, context) }\nif node.dependency != void then node.dependency.accept(self, context) end\nif node.available != void then node.available.accept(self, context) end\nif node.required != void then node.required.accept(self, context) end\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (node.getModel() != null) { node.getModel().accept(this, context); }\nfor (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nfor (int i=0; i<node.getPropertyValue().size(); i++) { ((diva.PropertyValue)node.getPropertyValue().get(i)).accept(this, context); }\nif (node.getDependency() != null) { node.getDependency().accept(this, context); }\nif (node.getAvailable() != null) { node.getAvailable().accept(this, context); }\nif (node.getRequired() != null) { node.getRequired().accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitVariant(Variant node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.annotation.each{ e | e.accept(self, context) }\nnode.variant.each{ e | e.accept(self, context) }\nnode.constraints.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nfor (int i=0; i<node.getVariant().size(); i++) { ((diva.Variant)node.getVariant().get(i)).accept(this, context); }\nfor (int i=0; i<node.getConstraints().size(); i++) { ((diva.MultiplicityConstraint)node.getConstraints().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitDimension(Dimension node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.annotation.each{ e | e.accept(self, context) }\nif node.term != void then node.term.accept(self, context) end\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nif (node.getTerm() != null) { node.getTerm().accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitExpression(Expression node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nif node.term != void then node.term.accept(self, context) end\nnode.annotation.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (node.getTerm() != null) { node.getTerm().accept(this, context); }\nfor (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitContextExpression(ContextExpression node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nif node.term != void then node.term.accept(self, context) end\nnode.annotation.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (node.getTerm() != null) { node.getTerm().accept(this, context); }\nfor (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitVariantExpression(VariantExpression node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.annotation.each{ e | e.accept(self, context) }\nif node.context != void then node.context.accept(self, context) end\nnode.priority.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nif (node.getContext() != null) { node.getContext().accept(this, context); }\nfor (int i=0; i<node.getPriority().size(); i++) { ((diva.PropertyPriority)node.getPriority().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitPriorityRule(PriorityRule node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.annotation.each{ e | e.accept(self, context) }\nnode.literal.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nfor (int i=0; i<node.getLiteral().size(); i++) { ((diva.PropertyLiteral)node.getLiteral().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitProperty(Property node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.annotation.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitPropertyLiteral(PropertyLiteral node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.annotation.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitPropertyValue(PropertyValue node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.annotation.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitPropertyPriority(PropertyPriority node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.annotation.each{ e | e.accept(self, context) }\nif node.available != void then node.available.accept(self, context) end\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nif (node.getAvailable() != null) { node.getAvailable().accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitMultiplicityConstraint(MultiplicityConstraint node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return null;\n'"
	 * @generated
	 */
	ResultType visitAnnotation(Annotation node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.annotation.each{ e | e.accept(self, context) }\nnode.scenario.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nfor (int i=0; i<node.getScenario().size(); i++) { ((diva.Scenario)node.getScenario().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitSimulationModel(SimulationModel node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.annotation.each{ e | e.accept(self, context) }\nnode.variable.each{ e | e.accept(self, context) }\nnode.configuration.each{ e | e.accept(self, context) }\nif node.oracle != void then node.oracle.accept(self, context) end\nnode.priority.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nfor (int i=0; i<node.getVariable().size(); i++) { ((diva.VariableValue)node.getVariable().get(i)).accept(this, context); }\nfor (int i=0; i<node.getConfiguration().size(); i++) { ((diva.Configuration)node.getConfiguration().get(i)).accept(this, context); }\nif (node.getOracle() != null) { node.getOracle().accept(this, context); }\nfor (int i=0; i<node.getPriority().size(); i++) { ((diva.Priority)node.getPriority().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitContext(Context node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.score.each{ e | e.accept(self, context) }\nnode.annotation.each{ e | e.accept(self, context) }\nnode.variant.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getScore().size(); i++) { ((diva.Score)node.getScore().get(i)).accept(this, context); }\nfor (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nfor (int i=0; i<node.getVariant().size(); i++) { ((diva.ConfigVariant)node.getVariant().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitConfiguration(Configuration node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.score.each{ e | e.accept(self, context) }\nnode.annotation.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getScore().size(); i++) { ((diva.Score)node.getScore().get(i)).accept(this, context); }\nfor (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitConfigVariant(ConfigVariant node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.annotation.each{ e | e.accept(self, context) }\nnode.context.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nfor (int i=0; i<node.getContext().size(); i++) { ((diva.Context)node.getContext().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitScenario(Scenario node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.annotation.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitScore(Score node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.annotation.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitPriority(Priority node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.annotation.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitBoolVariableValue(BoolVariableValue node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.annotation.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getAnnotation().size(); i++) { ((diva.Annotation)node.getAnnotation().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitEnumVariableValue(EnumVariableValue node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.configurations.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getConfigurations().size(); i++) { ((diva.SuitableConfiguration)node.getConfigurations().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitConfigurationModel(ConfigurationModel node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.variant.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getVariant().size(); i++) { ((diva.ConfigVariant)node.getVariant().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitSuitableConfiguration(SuitableConfiguration node, ContextType context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="kermeta body='do\nnode.variable.each{ e | e.accept(self, context) }\nend' isAbstract='false'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (int i=0; i<node.getVariable().size(); i++) { ((diva.VariableValue)node.getVariable().get(i)).accept(this, context); }\nreturn null;\n'"
	 * @generated
	 */
	ResultType visitContextModel(ContextModel node, ContextType context);

} // TopDownVisitor
