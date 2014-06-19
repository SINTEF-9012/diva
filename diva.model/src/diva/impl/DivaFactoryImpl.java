/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package diva.impl;

import diva.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
import diva.DivaFactory;
import diva.DivaPackage;
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
import diva.Verdict;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DivaFactoryImpl extends EFactoryImpl implements DivaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DivaFactory init() {
		try {
			DivaFactory theDivaFactory = (DivaFactory)EPackage.Registry.INSTANCE.getEFactory(DivaPackage.eNS_URI);
			if (theDivaFactory != null) {
				return theDivaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DivaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DivaFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DivaPackage.VARIABILITY_MODEL: return createVariabilityModel();
			case DivaPackage.INVARIANT: return createInvariant();
			case DivaPackage.ENUM_VARIABLE: return createEnumVariable();
			case DivaPackage.BOOLEAN_VARIABLE: return createBooleanVariable();
			case DivaPackage.AND_TERM: return createAndTerm();
			case DivaPackage.OR_TERM: return createOrTerm();
			case DivaPackage.NOT_TERM: return createNotTerm();
			case DivaPackage.VARIANT_TERM: return createVariantTerm();
			case DivaPackage.ENUM_TERM: return createEnumTerm();
			case DivaPackage.BOOLEAN_TERM: return createBooleanTerm();
			case DivaPackage.ENUM_LITERAL: return createEnumLiteral();
			case DivaPackage.VARIANT: return createVariant();
			case DivaPackage.DIMENSION: return createDimension();
			case DivaPackage.EXPRESSION: return createExpression();
			case DivaPackage.CONTEXT_EXPRESSION: return createContextExpression();
			case DivaPackage.VARIANT_EXPRESSION: return createVariantExpression();
			case DivaPackage.PRIORITY_RULE: return createPriorityRule();
			case DivaPackage.PROPERTY: return createProperty();
			case DivaPackage.PROPERTY_LITERAL: return createPropertyLiteral();
			case DivaPackage.PROPERTY_VALUE: return createPropertyValue();
			case DivaPackage.PROPERTY_PRIORITY: return createPropertyPriority();
			case DivaPackage.MULTIPLICITY_CONSTRAINT: return createMultiplicityConstraint();
			case DivaPackage.ANNOTATION: return createAnnotation();
			case DivaPackage.SIMULATION_MODEL: return createSimulationModel();
			case DivaPackage.CONTEXT: return createContext();
			case DivaPackage.CONFIGURATION: return createConfiguration();
			case DivaPackage.CONFIG_VARIANT: return createConfigVariant();
			case DivaPackage.SCENARIO: return createScenario();
			case DivaPackage.SCORE: return createScore();
			case DivaPackage.PRIORITY: return createPriority();
			case DivaPackage.BOOL_VARIABLE_VALUE: return createBoolVariableValue();
			case DivaPackage.ENUM_VARIABLE_VALUE: return createEnumVariableValue();
			case DivaPackage.CONFIGURATION_MODEL: return createConfigurationModel();
			case DivaPackage.SUITABLE_CONFIGURATION: return createSuitableConfiguration();
			case DivaPackage.CONTEXT_MODEL: return createContextModel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DivaPackage.VERDICT:
				return createVerdictFromString(eDataType, initialValue);
			case DivaPackage.STRING:
				return createStringFromString(eDataType, initialValue);
			case DivaPackage.INTEGER:
				return createIntegerFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DivaPackage.VERDICT:
				return convertVerdictToString(eDataType, instanceValue);
			case DivaPackage.STRING:
				return convertStringToString(eDataType, instanceValue);
			case DivaPackage.INTEGER:
				return convertIntegerToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariabilityModel createVariabilityModel() {
		VariabilityModelImpl variabilityModel = new VariabilityModelImpl();
		return variabilityModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Invariant createInvariant() {
		InvariantImpl invariant = new InvariantImpl();
		return invariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumVariable createEnumVariable() {
		EnumVariableImpl enumVariable = new EnumVariableImpl();
		return enumVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanVariable createBooleanVariable() {
		BooleanVariableImpl booleanVariable = new BooleanVariableImpl();
		return booleanVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AndTerm createAndTerm() {
		AndTermImpl andTerm = new AndTermImpl();
		return andTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrTerm createOrTerm() {
		OrTermImpl orTerm = new OrTermImpl();
		return orTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotTerm createNotTerm() {
		NotTermImpl notTerm = new NotTermImpl();
		return notTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariantTerm createVariantTerm() {
		VariantTermImpl variantTerm = new VariantTermImpl();
		return variantTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumTerm createEnumTerm() {
		EnumTermImpl enumTerm = new EnumTermImpl();
		return enumTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanTerm createBooleanTerm() {
		BooleanTermImpl booleanTerm = new BooleanTermImpl();
		return booleanTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumLiteral createEnumLiteral() {
		EnumLiteralImpl enumLiteral = new EnumLiteralImpl();
		return enumLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variant createVariant() {
		VariantImpl variant = new VariantImpl();
		return variant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dimension createDimension() {
		DimensionImpl dimension = new DimensionImpl();
		return dimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression createExpression() {
		ExpressionImpl expression = new ExpressionImpl();
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextExpression createContextExpression() {
		ContextExpressionImpl contextExpression = new ContextExpressionImpl();
		return contextExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariantExpression createVariantExpression() {
		VariantExpressionImpl variantExpression = new VariantExpressionImpl();
		return variantExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PriorityRule createPriorityRule() {
		PriorityRuleImpl priorityRule = new PriorityRuleImpl();
		return priorityRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyLiteral createPropertyLiteral() {
		PropertyLiteralImpl propertyLiteral = new PropertyLiteralImpl();
		return propertyLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyValue createPropertyValue() {
		PropertyValueImpl propertyValue = new PropertyValueImpl();
		return propertyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyPriority createPropertyPriority() {
		PropertyPriorityImpl propertyPriority = new PropertyPriorityImpl();
		return propertyPriority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityConstraint createMultiplicityConstraint() {
		MultiplicityConstraintImpl multiplicityConstraint = new MultiplicityConstraintImpl();
		return multiplicityConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Annotation createAnnotation() {
		AnnotationImpl annotation = new AnnotationImpl();
		return annotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationModel createSimulationModel() {
		SimulationModelImpl simulationModel = new SimulationModelImpl();
		return simulationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context createContext() {
		ContextImpl context = new ContextImpl();
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration createConfiguration() {
		ConfigurationImpl configuration = new ConfigurationImpl();
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigVariant createConfigVariant() {
		ConfigVariantImpl configVariant = new ConfigVariantImpl();
		return configVariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scenario createScenario() {
		ScenarioImpl scenario = new ScenarioImpl();
		return scenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Score createScore() {
		ScoreImpl score = new ScoreImpl();
		return score;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Priority createPriority() {
		PriorityImpl priority = new PriorityImpl();
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoolVariableValue createBoolVariableValue() {
		BoolVariableValueImpl boolVariableValue = new BoolVariableValueImpl();
		return boolVariableValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumVariableValue createEnumVariableValue() {
		EnumVariableValueImpl enumVariableValue = new EnumVariableValueImpl();
		return enumVariableValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationModel createConfigurationModel() {
		ConfigurationModelImpl configurationModel = new ConfigurationModelImpl();
		return configurationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SuitableConfiguration createSuitableConfiguration() {
		SuitableConfigurationImpl suitableConfiguration = new SuitableConfigurationImpl();
		return suitableConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextModel createContextModel() {
		ContextModelImpl contextModel = new ContextModelImpl();
		return contextModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Verdict createVerdictFromString(EDataType eDataType, String initialValue) {
		Verdict result = Verdict.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVerdictToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createStringFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStringToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer createIntegerFromString(EDataType eDataType, String initialValue) {
		return (Integer)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIntegerToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DivaPackage getDivaPackage() {
		return (DivaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DivaPackage getPackage() {
		return DivaPackage.eINSTANCE;
	}

} //DivaFactoryImpl
