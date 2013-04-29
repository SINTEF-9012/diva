package diva.editor;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import diva.AndTerm;
import diva.Annotation;
import diva.AspectModel;
import diva.BaseModel;
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

public class DiVABackgroundProvider extends EObjectImpl implements Visitor<String, Color> {

	protected static Color ctxColor = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 255, 255, 200);
	protected static Color varColor = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 255, 240, 215);
	protected static Color dvarColor = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 240, 225, 200);
	protected static Color expColor = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 225, 255, 230);
	protected static Color ruleColor = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 225, 230, 255);
	protected static Color propColor = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 255, 225, 230);
	protected static Color invColor = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 255, 200, 255);
	protected static Color grey = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 230, 230, 230);
	protected static Color white = new org.eclipse.swt.graphics.Color(Display.getCurrent(), 255, 255, 255);
	
	private static DiVABackgroundProvider instance = new DiVABackgroundProvider();
	
	public static DiVABackgroundProvider getInstance() {
		return instance;
	}
	
	public Color visitAndTerm(AndTerm node, String context) {
		return expColor;
	}

	public Color visitAspectModel(AspectModel node, String context) {
		return grey;
	}

	public Color visitBaseModel(BaseModel node, String context) {
		return grey;
	}

	public Color visitBooleanTerm(BooleanTerm node, String context) {
		return expColor;
	}

	public Color visitBooleanVariable(BooleanVariable node, String context) {
		return ctxColor;
	}

	public Color visitContextExpression(ContextExpression node, String context) {
		return expColor;
	}

	public Color visitDimension(Dimension node, String context) {
		return dvarColor;
	}

	public Color visitEnumLiteral(EnumLiteral node, String context) {
		return ctxColor;
	}

	public Color visitEnumTerm(EnumTerm node, String context) {
		return expColor;
	}

	public Color visitEnumVariable(EnumVariable node, String context) {
		return ctxColor;
	}

	public Color visitExpression(Expression node, String context) {
		return expColor;
	}

	public Color visitInvariant(Invariant node, String context) {
		return invColor;
	}

	public Color visitNotTerm(NotTerm node, String context) {
		return expColor;
	}

	public Color visitOrTerm(OrTerm node, String context) {
		return expColor;
	}

	public Color visitPriorityRule(PriorityRule node, String context) {
		return ruleColor;
	}

	
	public Color visitProperty(Property node, String context) {
		return propColor;
	}

	
	public Color visitPropertyPriority(PropertyPriority node, String context) {
		return ruleColor;
	}

	
	public Color visitPropertyValue(PropertyValue node, String context) {
		return propColor;
	}

	
	public Color visitVariabilityModel(VariabilityModel node, String context) {
		return white;
	}

	
	public Color visitVariant(Variant node, String context) {
		return varColor;
	}

	
	public Color visitVariantExpression(VariantExpression node, String context) {
		return expColor;
	}

	
	public Color visitVariantTerm(VariantTerm node, String context) {
		return expColor;
	}

	
	public Color visitMultiplicityConstraint(MultiplicityConstraint node,
			String context) {
		return dvarColor;
	}
	
	
	public Color visitBoolVariableValue(diva.BoolVariableValue node, String context) {
		return ctxColor;
	}

	
	public Color visitConfiguration(Configuration node, String context) {
		return dvarColor;
	}

	
	public Color visitConfigVariant(ConfigVariant node, String context) {
		return varColor;
	}

	
	public Color visitContext(Context node, String context) {
		return ctxColor;
	}

	
	public Color visitEnumVariableValue(EnumVariableValue node, String context) {
		return ctxColor;
	}

	
	public Color visitPriority(Priority node, String context) {
		return ruleColor;
	}

	
	public Color visitScenario(Scenario node, String context) {
		return ctxColor;
	}

	
	public Color visitScore(Score node, String context) {
		return propColor;
	}

	
	public Color visitSimulationModel(SimulationModel node, String context) {
		return white;
	}

	
	public Color visitAnnotation(Annotation node, String context) {
		return grey;
	}

	public Color visitConfigurationModel(ConfigurationModel node, String context) {
		// TODO Auto-generated method stub
		return grey;
	}

	public Color visitContextModel(ContextModel node, String context) {
		// TODO Auto-generated method stub
		return grey;
	}

	public Color visitSuitableConfiguration(SuitableConfiguration node,
			String context) {
		// TODO Auto-generated method stub
		return grey;
	}

	public Color visitPropertyLiteral(PropertyLiteral node, String context) {
		// TODO Auto-generated method stub
		return propColor;
	}

}
