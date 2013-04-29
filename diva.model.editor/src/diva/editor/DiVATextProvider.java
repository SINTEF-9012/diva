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


public class DiVATextProvider extends EObjectImpl implements Visitor<String, String> {

	private static DiVATextProvider instance = new DiVATextProvider();
	
	public static DiVATextProvider getInstance() {
		return instance;
	}
	
	
	public String visitAndTerm(AndTerm node, String context) {
		String result = "(";
		for (int i=0; i<node.getTerm().size(); i++) {
			result += node.getTerm().get(i).accept(this, null);
			if (i != node.getTerm().size()-1) result += " and ";
		}
		result += ")";
		return result;
	}

	
	public String visitAspectModel(AspectModel node, String context) {
		return "AspectModel";
	}

	
	public String visitBaseModel(BaseModel node, String context) {
		return "BaseModel";
	}

	
	public String visitBooleanTerm(BooleanTerm node, String context) {
		return node.getVariable().getId();
	}

	
	public String visitBooleanVariable(BooleanVariable node, String context) {
		return node.getName() + " (" + node.getId() + ") : Boolean";
	}

	
	public String visitContextExpression(ContextExpression node, String context) {
		if (node.getTerm() == null) return "";
		return node.getTerm().accept(this, null);
	}

	
	public String visitDimension(Dimension node, String context) {
		return node.getName() + " (" + node.getId() + ")";
	}

	
	public String visitEnumLiteral(EnumLiteral node, String context) {
		return node.getName() + " (" + node.getId() + ")"; 
	}

	
	public String visitEnumTerm(EnumTerm node, String context) {
		return node.getVariable().getId() + " = " + node.getValue().getId();
	}

	
	public String visitEnumVariable(EnumVariable node, String context) {
		String result = node.getName()+ " (" + node.getId() + ") = {";
		for (int i=0; i<node.getLiteral().size(); i++) {
			result += node.getLiteral().get(i).getId();
			if (i != node.getLiteral().size()-1) result += ", ";
		}
		result += "}";
		return result;
	}

	
	public String visitExpression(Expression node, String context) {
		return node.getTerm().accept(this, null);
	}

	
	public String visitInvariant(Invariant node, String context) {
		return node.getName() + " (" + node.getId() + ")";
	}

	
	public String visitNotTerm(NotTerm node, String context) {
		return "not (" + node.getTerm().accept(this, null) + ")";
	}

	
	public String visitOrTerm(OrTerm node, String context) {
		String result = "(";
		for (int i=0; i<node.getTerm().size(); i++) {
			result += node.getTerm().get(i).accept(this, null);
			if (i != node.getTerm().size()-1) result += " or ";
		}
		result += ")";
		return result;
	}

	
	public String visitPriorityRule(PriorityRule node, String context) {
		return node.getName() + " (" + node.getId() + ")";
	}

	
	public String visitProperty(Property node, String context) {
		return node.getName() + " (" + node.getId() + ")";
	}

	
	public String visitPropertyPriority(PropertyPriority node, String context) {
		return node.getProperty().getId() + " Priority = " + node.getPriority();
	}

	
	public String visitPropertyValue(PropertyValue node, String context) {
		return node.getProperty().getId() + " = " + node.getValue();
	}

	
	public String visitVariabilityModel(VariabilityModel node, String context) {
		return "DiVA Model ";
	}

	
	public String visitVariant(Variant node, String context) {
		return node.getName() + " (" + node.getId() + ")";
	}

	
	public String visitVariantExpression(VariantExpression node, String context) {
		return node.getTerm().accept(this, null);
	}

	
	public String visitVariantTerm(VariantTerm node, String context) {
		return node.getVariant().getId();
	}

	
	public String visitMultiplicityConstraint(MultiplicityConstraint node,
			String context) {
		return node.getAvailable().accept(this, null) + " => [" + node.getLower() + " " + node.getUpper() + "]";
	}
	
	
	public String visitBoolVariableValue(BoolVariableValue node, String context) {
		return node.getVariable().getName() + " = " + node.isBool();
	}

	
	public String visitConfiguration(Configuration node, String context) {
		return "Configuration" + " (" + node.getTotalScore() + ")";
	}

	
	public String visitConfigVariant(ConfigVariant node, String context) {
		return node.getVariant().getName() + " (" + node.getTotalScore() + ")";
	}

	
	public String visitContext(Context node, String context) {
		if (node.getName() != null) return "Context " + node.getName();
		else return "Context";
	}

	
	public String visitEnumVariableValue(EnumVariableValue node, String context) {
		return node.getVariable().getName() + " = " + node.getLiteral().getName();
	}

	
	public String visitPriority(Priority node, String context) {
		return node.getProperty().getName() + " = " + node.getPriority();
	}

	
	public String visitScenario(Scenario node, String context) {
		if (node.getName() != null) return "Scenario " + node.getName();
		else return "Scenario";
	}

	
	public String visitScore(Score node, String context) {
		return node.getProperty().getName() + " = " + node.getScore();
	}

	
	public String visitSimulationModel(SimulationModel node, String context) {
		return "SimulationModel";
	}

	
	public String visitAnnotation(Annotation node, String context) {
		return node.getKey() + " : " + node.getValue();
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
