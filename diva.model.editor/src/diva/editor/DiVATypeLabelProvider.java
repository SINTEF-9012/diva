package diva.editor;

import org.eclipse.emf.ecore.impl.EObjectImpl;

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
import diva.visitors.Visitor;

public class DiVATypeLabelProvider extends EObjectImpl implements Visitor<String, String> {
	
	private static DiVATypeLabelProvider instance = new DiVATypeLabelProvider();
	
	public static DiVATypeLabelProvider getInstance() {
		return instance;
	}

	
	public String visitAndTerm(AndTerm node, String context) {
		return "And";
	}

	
	public String visitAspectModel(AspectModel node, String context) {
		return "Aspect";
	}

	
	public String visitBaseModel(BaseModel node, String context) {
		return "Base";
	}

	
	public String visitBooleanTerm(BooleanTerm node, String context) {
		return "Boolean Term";
	}

	
	public String visitBooleanVariable(BooleanVariable node, String context) {
		return "Boolean";
	}

	
	public String visitContextExpression(ContextExpression node, String context) {
		return "Context Exp";
	}

	
	public String visitDimension(Dimension node, String context) {
		return "Dimension";
	}

	
	public String visitEnumLiteral(EnumLiteral node, String context) {
		return "Literal";
	}

	
	public String visitEnumTerm(EnumTerm node, String context) {
		return "Enum Term";
	}

	
	public String visitEnumVariable(EnumVariable node, String context) {
		return "Enum";
	}

	
	public String visitExpression(Expression node, String context) {
		return "Expression";
	}

	
	public String visitInvariant(Invariant node, String context) {
		return "Invariant";
	}

	
	public String visitNotTerm(NotTerm node, String context) {
		return "Not";
	}

	
	public String visitOrTerm(OrTerm node, String context) {
		return "Or";
	}

	
	public String visitPriorityRule(PriorityRule node, String context) {
		return "Rule";
	}

	
	public String visitProperty(Property node, String context) {
		return "Property";
	}

	
	public String visitPropertyPriority(PropertyPriority node, String context) {
		return "Priority";
	}

	
	public String visitPropertyValue(PropertyValue node, String context) {
		return "Value";
	}

	
	public String visitVariabilityModel(VariabilityModel node, String context) {
		return "DiVA Model";
	}

	
	public String visitVariant(Variant node, String context) {
		return "Variant";
	}

	
	public String visitVariantExpression(VariantExpression node, String context) {
		return "Variant Exp.";
	}

	
	public String visitVariantTerm(VariantTerm node, String context) {
		return "Variant Term";
	}

	
	public String visitMultiplicityConstraint(MultiplicityConstraint node,
			String context) {
		return "Multiplicity";
	}

	
	public String visitBoolVariableValue(BoolVariableValue node, String context) {
		return "BoolVariableValue";
	}

	
	public String visitConfigVariant(ConfigVariant node, String context) {
		return "ConfigVariant";
	}

	
	public String visitConfiguration(Configuration node, String context) {
		return "Configuration";
	}

	
	public String visitContext(Context node, String context) {
		return "Context";
	}

	
	public String visitEnumVariableValue(EnumVariableValue node, String context) {
		return "EnumVariableValue";
	}

	
	public String visitPriority(Priority node, String context) {
		return "Priority";
	}

	
	public String visitScenario(Scenario node, String context) {
		return "Scenario";
	}

	
	public String visitScore(Score node, String context) {
		return "Score";
	}

	
	public String visitSimulationModel(SimulationModel node, String context) {
		return "SimulationModel";
	}

	
	public String visitAnnotation(Annotation node, String context) {
		return node.getKey()  + " : " + node.getValue();
	}


	public String visitConfigurationModel(ConfigurationModel node,
			String context) {
		// TODO Auto-generated method stub
		return "ConfigurationModel";
	}


	public String visitContextModel(ContextModel node, String context) {
		// TODO Auto-generated method stub
		return "ContextModel";
	}


	public String visitSuitableConfiguration(SuitableConfiguration node,
			String context) {
		// TODO Auto-generated method stub
		return "SuitableConfiguration";
	}


	public String visitPropertyLiteral(PropertyLiteral node, String context) {
		// TODO Auto-generated method stub
		return "PropertyLiteral";
	}
	


}
