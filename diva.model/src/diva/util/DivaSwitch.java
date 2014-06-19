/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva.util;

import diva.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

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
import diva.Constraint;
import diva.Context;
import diva.ContextExpression;
import diva.ContextModel;
import diva.DiVAModelElement;
import diva.Dimension;
import diva.DivaPackage;
import diva.EnumLiteral;
import diva.EnumTerm;
import diva.EnumVariable;
import diva.EnumVariableValue;
import diva.Expression;
import diva.Invariant;
import diva.Model;
import diva.ModelContainer;
import diva.MultiplicityConstraint;
import diva.NamedElement;
import diva.NaryTerm;
import diva.NotTerm;
import diva.OrTerm;
import diva.Priority;
import diva.PriorityRule;
import diva.Property;
import diva.PropertyLiteral;
import diva.PropertyPriority;
import diva.PropertyValue;
import diva.Rule;
import diva.Scenario;
import diva.Score;
import diva.ScoredElement;
import diva.SimulationModel;
import diva.SuitableConfiguration;
import diva.Term;
import diva.VariabilityModel;
import diva.Variable;
import diva.VariableTerm;
import diva.VariableValue;
import diva.Variant;
import diva.VariantExpression;
import diva.VariantTerm;
import diva.visitors.Visitable;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see diva.DivaPackage
 * @generated
 */
public class DivaSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DivaPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DivaSwitch() {
		if (modelPackage == null) {
			modelPackage = DivaPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DivaPackage.VARIABILITY_MODEL: {
				VariabilityModel variabilityModel = (VariabilityModel)theEObject;
				T result = caseVariabilityModel(variabilityModel);
				if (result == null) result = caseModelContainer(variabilityModel);
				if (result == null) result = caseVisitable(variabilityModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.INVARIANT: {
				Invariant invariant = (Invariant)theEObject;
				T result = caseInvariant(invariant);
				if (result == null) result = caseConstraint(invariant);
				if (result == null) result = caseNamedElement(invariant);
				if (result == null) result = caseDiVAModelElement(invariant);
				if (result == null) result = caseVisitable(invariant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.VARIABLE: {
				Variable variable = (Variable)theEObject;
				T result = caseVariable(variable);
				if (result == null) result = caseNamedElement(variable);
				if (result == null) result = caseDiVAModelElement(variable);
				if (result == null) result = caseVisitable(variable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.MODEL: {
				Model model = (Model)theEObject;
				T result = caseModel(model);
				if (result == null) result = caseDiVAModelElement(model);
				if (result == null) result = caseVisitable(model);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.ENUM_VARIABLE: {
				EnumVariable enumVariable = (EnumVariable)theEObject;
				T result = caseEnumVariable(enumVariable);
				if (result == null) result = caseVariable(enumVariable);
				if (result == null) result = caseNamedElement(enumVariable);
				if (result == null) result = caseDiVAModelElement(enumVariable);
				if (result == null) result = caseVisitable(enumVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.BOOLEAN_VARIABLE: {
				BooleanVariable booleanVariable = (BooleanVariable)theEObject;
				T result = caseBooleanVariable(booleanVariable);
				if (result == null) result = caseVariable(booleanVariable);
				if (result == null) result = caseCEPable(booleanVariable);
				if (result == null) result = caseNamedElement(booleanVariable);
				if (result == null) result = caseDiVAModelElement(booleanVariable);
				if (result == null) result = caseVisitable(booleanVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.TERM: {
				Term term = (Term)theEObject;
				T result = caseTerm(term);
				if (result == null) result = caseDiVAModelElement(term);
				if (result == null) result = caseVisitable(term);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.AND_TERM: {
				AndTerm andTerm = (AndTerm)theEObject;
				T result = caseAndTerm(andTerm);
				if (result == null) result = caseNaryTerm(andTerm);
				if (result == null) result = caseTerm(andTerm);
				if (result == null) result = caseDiVAModelElement(andTerm);
				if (result == null) result = caseVisitable(andTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.OR_TERM: {
				OrTerm orTerm = (OrTerm)theEObject;
				T result = caseOrTerm(orTerm);
				if (result == null) result = caseNaryTerm(orTerm);
				if (result == null) result = caseTerm(orTerm);
				if (result == null) result = caseDiVAModelElement(orTerm);
				if (result == null) result = caseVisitable(orTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.NOT_TERM: {
				NotTerm notTerm = (NotTerm)theEObject;
				T result = caseNotTerm(notTerm);
				if (result == null) result = caseTerm(notTerm);
				if (result == null) result = caseDiVAModelElement(notTerm);
				if (result == null) result = caseVisitable(notTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.NARY_TERM: {
				NaryTerm naryTerm = (NaryTerm)theEObject;
				T result = caseNaryTerm(naryTerm);
				if (result == null) result = caseTerm(naryTerm);
				if (result == null) result = caseDiVAModelElement(naryTerm);
				if (result == null) result = caseVisitable(naryTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.VARIANT_TERM: {
				VariantTerm variantTerm = (VariantTerm)theEObject;
				T result = caseVariantTerm(variantTerm);
				if (result == null) result = caseTerm(variantTerm);
				if (result == null) result = caseDiVAModelElement(variantTerm);
				if (result == null) result = caseVisitable(variantTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.VARIABLE_TERM: {
				VariableTerm variableTerm = (VariableTerm)theEObject;
				T result = caseVariableTerm(variableTerm);
				if (result == null) result = caseTerm(variableTerm);
				if (result == null) result = caseDiVAModelElement(variableTerm);
				if (result == null) result = caseVisitable(variableTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.ENUM_TERM: {
				EnumTerm enumTerm = (EnumTerm)theEObject;
				T result = caseEnumTerm(enumTerm);
				if (result == null) result = caseVariableTerm(enumTerm);
				if (result == null) result = caseTerm(enumTerm);
				if (result == null) result = caseDiVAModelElement(enumTerm);
				if (result == null) result = caseVisitable(enumTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.BOOLEAN_TERM: {
				BooleanTerm booleanTerm = (BooleanTerm)theEObject;
				T result = caseBooleanTerm(booleanTerm);
				if (result == null) result = caseVariableTerm(booleanTerm);
				if (result == null) result = caseTerm(booleanTerm);
				if (result == null) result = caseDiVAModelElement(booleanTerm);
				if (result == null) result = caseVisitable(booleanTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.RULE: {
				Rule rule = (Rule)theEObject;
				T result = caseRule(rule);
				if (result == null) result = caseNamedElement(rule);
				if (result == null) result = caseDiVAModelElement(rule);
				if (result == null) result = caseVisitable(rule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.ENUM_LITERAL: {
				EnumLiteral enumLiteral = (EnumLiteral)theEObject;
				T result = caseEnumLiteral(enumLiteral);
				if (result == null) result = caseNamedElement(enumLiteral);
				if (result == null) result = caseCEPable(enumLiteral);
				if (result == null) result = caseDiVAModelElement(enumLiteral);
				if (result == null) result = caseVisitable(enumLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = caseDiVAModelElement(namedElement);
				if (result == null) result = caseVisitable(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.CONSTRAINT: {
				Constraint constraint = (Constraint)theEObject;
				T result = caseConstraint(constraint);
				if (result == null) result = caseNamedElement(constraint);
				if (result == null) result = caseDiVAModelElement(constraint);
				if (result == null) result = caseVisitable(constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.VARIANT: {
				Variant variant = (Variant)theEObject;
				T result = caseVariant(variant);
				if (result == null) result = caseNamedElement(variant);
				if (result == null) result = caseModelContainer(variant);
				if (result == null) result = caseDiVAModelElement(variant);
				if (result == null) result = caseVisitable(variant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.DIMENSION: {
				Dimension dimension = (Dimension)theEObject;
				T result = caseDimension(dimension);
				if (result == null) result = caseNamedElement(dimension);
				if (result == null) result = caseDiVAModelElement(dimension);
				if (result == null) result = caseVisitable(dimension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = caseDiVAModelElement(expression);
				if (result == null) result = caseVisitable(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.CONTEXT_EXPRESSION: {
				ContextExpression contextExpression = (ContextExpression)theEObject;
				T result = caseContextExpression(contextExpression);
				if (result == null) result = caseExpression(contextExpression);
				if (result == null) result = caseDiVAModelElement(contextExpression);
				if (result == null) result = caseVisitable(contextExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.VARIANT_EXPRESSION: {
				VariantExpression variantExpression = (VariantExpression)theEObject;
				T result = caseVariantExpression(variantExpression);
				if (result == null) result = caseExpression(variantExpression);
				if (result == null) result = caseDiVAModelElement(variantExpression);
				if (result == null) result = caseVisitable(variantExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.PRIORITY_RULE: {
				PriorityRule priorityRule = (PriorityRule)theEObject;
				T result = casePriorityRule(priorityRule);
				if (result == null) result = caseRule(priorityRule);
				if (result == null) result = caseNamedElement(priorityRule);
				if (result == null) result = caseDiVAModelElement(priorityRule);
				if (result == null) result = caseVisitable(priorityRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.PROPERTY: {
				Property property = (Property)theEObject;
				T result = caseProperty(property);
				if (result == null) result = caseNamedElement(property);
				if (result == null) result = caseDiVAModelElement(property);
				if (result == null) result = caseVisitable(property);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.PROPERTY_LITERAL: {
				PropertyLiteral propertyLiteral = (PropertyLiteral)theEObject;
				T result = casePropertyLiteral(propertyLiteral);
				if (result == null) result = caseNamedElement(propertyLiteral);
				if (result == null) result = caseDiVAModelElement(propertyLiteral);
				if (result == null) result = caseVisitable(propertyLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.PROPERTY_VALUE: {
				PropertyValue propertyValue = (PropertyValue)theEObject;
				T result = casePropertyValue(propertyValue);
				if (result == null) result = caseDiVAModelElement(propertyValue);
				if (result == null) result = caseVisitable(propertyValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.PROPERTY_PRIORITY: {
				PropertyPriority propertyPriority = (PropertyPriority)theEObject;
				T result = casePropertyPriority(propertyPriority);
				if (result == null) result = caseDiVAModelElement(propertyPriority);
				if (result == null) result = caseVisitable(propertyPriority);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.MULTIPLICITY_CONSTRAINT: {
				MultiplicityConstraint multiplicityConstraint = (MultiplicityConstraint)theEObject;
				T result = caseMultiplicityConstraint(multiplicityConstraint);
				if (result == null) result = caseConstraint(multiplicityConstraint);
				if (result == null) result = caseNamedElement(multiplicityConstraint);
				if (result == null) result = caseDiVAModelElement(multiplicityConstraint);
				if (result == null) result = caseVisitable(multiplicityConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.ANNOTATION: {
				Annotation annotation = (Annotation)theEObject;
				T result = caseAnnotation(annotation);
				if (result == null) result = caseVisitable(annotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.DI_VA_MODEL_ELEMENT: {
				DiVAModelElement diVAModelElement = (DiVAModelElement)theEObject;
				T result = caseDiVAModelElement(diVAModelElement);
				if (result == null) result = caseVisitable(diVAModelElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.SIMULATION_MODEL: {
				SimulationModel simulationModel = (SimulationModel)theEObject;
				T result = caseSimulationModel(simulationModel);
				if (result == null) result = caseDiVAModelElement(simulationModel);
				if (result == null) result = caseVisitable(simulationModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.CONTEXT: {
				Context context = (Context)theEObject;
				T result = caseContext(context);
				if (result == null) result = caseNamedElement(context);
				if (result == null) result = caseDiVAModelElement(context);
				if (result == null) result = caseVisitable(context);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.CONFIGURATION: {
				Configuration configuration = (Configuration)theEObject;
				T result = caseConfiguration(configuration);
				if (result == null) result = caseScoredElement(configuration);
				if (result == null) result = caseDiVAModelElement(configuration);
				if (result == null) result = caseVisitable(configuration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.CONFIG_VARIANT: {
				ConfigVariant configVariant = (ConfigVariant)theEObject;
				T result = caseConfigVariant(configVariant);
				if (result == null) result = caseScoredElement(configVariant);
				if (result == null) result = caseDiVAModelElement(configVariant);
				if (result == null) result = caseVisitable(configVariant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.SCENARIO: {
				Scenario scenario = (Scenario)theEObject;
				T result = caseScenario(scenario);
				if (result == null) result = caseNamedElement(scenario);
				if (result == null) result = caseDiVAModelElement(scenario);
				if (result == null) result = caseVisitable(scenario);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.SCORED_ELEMENT: {
				ScoredElement scoredElement = (ScoredElement)theEObject;
				T result = caseScoredElement(scoredElement);
				if (result == null) result = caseDiVAModelElement(scoredElement);
				if (result == null) result = caseVisitable(scoredElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.SCORE: {
				Score score = (Score)theEObject;
				T result = caseScore(score);
				if (result == null) result = caseDiVAModelElement(score);
				if (result == null) result = caseVisitable(score);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.PRIORITY: {
				Priority priority = (Priority)theEObject;
				T result = casePriority(priority);
				if (result == null) result = caseDiVAModelElement(priority);
				if (result == null) result = caseVisitable(priority);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.VARIABLE_VALUE: {
				VariableValue variableValue = (VariableValue)theEObject;
				T result = caseVariableValue(variableValue);
				if (result == null) result = caseDiVAModelElement(variableValue);
				if (result == null) result = caseVisitable(variableValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.BOOL_VARIABLE_VALUE: {
				BoolVariableValue boolVariableValue = (BoolVariableValue)theEObject;
				T result = caseBoolVariableValue(boolVariableValue);
				if (result == null) result = caseVariableValue(boolVariableValue);
				if (result == null) result = caseDiVAModelElement(boolVariableValue);
				if (result == null) result = caseVisitable(boolVariableValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.ENUM_VARIABLE_VALUE: {
				EnumVariableValue enumVariableValue = (EnumVariableValue)theEObject;
				T result = caseEnumVariableValue(enumVariableValue);
				if (result == null) result = caseVariableValue(enumVariableValue);
				if (result == null) result = caseDiVAModelElement(enumVariableValue);
				if (result == null) result = caseVisitable(enumVariableValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.CONFIGURATION_MODEL: {
				ConfigurationModel configurationModel = (ConfigurationModel)theEObject;
				T result = caseConfigurationModel(configurationModel);
				if (result == null) result = caseVisitable(configurationModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.SUITABLE_CONFIGURATION: {
				SuitableConfiguration suitableConfiguration = (SuitableConfiguration)theEObject;
				T result = caseSuitableConfiguration(suitableConfiguration);
				if (result == null) result = caseVisitable(suitableConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.CONTEXT_MODEL: {
				ContextModel contextModel = (ContextModel)theEObject;
				T result = caseContextModel(contextModel);
				if (result == null) result = caseVisitable(contextModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.MODEL_CONTAINER: {
				ModelContainer modelContainer = (ModelContainer)theEObject;
				T result = caseModelContainer(modelContainer);
				if (result == null) result = caseVisitable(modelContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DivaPackage.CE_PABLE: {
				CEPable cePable = (CEPable)theEObject;
				T result = caseCEPable(cePable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variability Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variability Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariabilityModel(VariabilityModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invariant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invariant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvariant(Invariant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariable(Variable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModel(Model object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumVariable(EnumVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanVariable(BooleanVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerm(Term object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAndTerm(AndTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrTerm(OrTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotTerm(NotTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nary Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nary Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNaryTerm(NaryTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variant Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variant Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariantTerm(VariantTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableTerm(VariableTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumTerm(EnumTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanTerm(BooleanTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRule(Rule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumLiteral(EnumLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraint(Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariant(Variant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dimension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDimension(Dimension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContextExpression(ContextExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variant Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variant Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariantExpression(VariantExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Priority Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Priority Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePriorityRule(PriorityRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyLiteral(PropertyLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyValue(PropertyValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Priority</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Priority</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyPriority(PropertyPriority object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiplicity Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiplicity Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiplicityConstraint(MultiplicityConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotation(Annotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Di VA Model Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Di VA Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiVAModelElement(DiVAModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simulation Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simulation Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimulationModel(SimulationModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContext(Context object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfiguration(Configuration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Config Variant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Config Variant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfigVariant(ConfigVariant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scenario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScenario(Scenario object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scored Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scored Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScoredElement(ScoredElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Score</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Score</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScore(Score object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Priority</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Priority</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePriority(Priority object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableValue(VariableValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bool Variable Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bool Variable Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoolVariableValue(BoolVariableValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Variable Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Variable Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumVariableValue(EnumVariableValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfigurationModel(ConfigurationModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Suitable Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Suitable Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSuitableConfiguration(SuitableConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContextModel(ContextModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelContainer(ModelContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CE Pable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CE Pable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCEPable(CEPable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitable(Visitable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DivaSwitch
