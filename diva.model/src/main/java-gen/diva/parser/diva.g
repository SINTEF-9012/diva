header {

package diva.parser; 

import java.io.*;
import java.util.*;

import org.eclipse.emf.ecore.*;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import antlr.*;
import antlr.collections.*;

import diva.*;
import diva.impl.*;
}


class DivaParser extends Parser;
options
{
	k=1;
}
{
	private static DivaFactory factory = DivaPackageImpl.init().getDivaFactory();
	
	public static String input = "examples/simpleSDA/simpleSDA.diva";
	public static String output = "examples/simpleSDA/model/simpleSDA.xmi";
	
	public VariabilityModel model;
	public Hashtable<String, Variable> variables = new Hashtable<String, Variable>();
	public Hashtable<String, Variant> variants = new Hashtable<String, Variant>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		 DivaLexer lexer = new DivaLexer(new FileInputStream(input));
	     DivaParser parser = new DivaParser(lexer);
	     try {
	    	 System.out.print("Parsing text file file...");
			parser.varmodel();
			System.out.println("OK");
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TokenStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("Saving model...");
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi",new XMIResourceFactoryImpl()); 
		ResourceSet resource_set = new ResourceSetImpl();
		
		Resource res = resource_set.createResource(URI.createFileURI(output));
		res.getContents().add(parser.model);
		res.save(null);
		System.out.println("OK");
	}
	
	public ArrayList<String> errors = new ArrayList<String>();
	
	public boolean hasErrors() {
		return !errors.isEmpty();	
	}
	
	public void reportError(RecognitionException ex) {
		super.reportError(ex);
		errors.add(ex.toString());
	}

}

varmodel :
{
	model = factory.createVariabilityModel();
	model.setVariability(factory.createVariability());
}
	VARIABILITY ( dimension | complexvariant )*
	CONTEXT	( sensor )*
	ADAPTATION	( adaptation )*
	EOF
	;
	
dimension returns [Dimension d = factory.createDimension()] :
	"dimension" name:ID COLON v0:ID 
	{
		d.setName(name.getText());
		model.getVariability().getDimension().add(d);
		AtomicVariant v = factory.createAtomicVariant();
		v.setName(v0.getText());
		model.getVariability().getVariant().add(v);
		v.getType().add(d);
		variants.put(v.getName(), v);
	}
	(
		COMMA vi:ID
		{
			v = factory.createAtomicVariant();
			v.setName(vi.getText());
			model.getVariability().getVariant().add(v);
			v.getType().add(d);
			variants.put(v.getName(), v);
		}
	)*
	;
	
complexvariant returns [ComplexVariant cv = factory.createComplexVariant()] :
	"variant" name:ID COLON v0:ID 
	{
		cv.setName(name.getText());
		model.getVariability().getVariant().add(cv);
		Variant v = variants.get(v0.getText());
		if (v == null) throw new RecognitionException("Unable to resolve variant " + v0.getText() + " in definition of complex variant " + name.getText());
		cv.getVariant().add(v);
		variants.put(cv.getName(), cv);
	}
	(
		COMMA vi:ID
		{
			cv.setName(name.getText());
			model.getVariability().getVariant().add(cv);
			v = variants.get(vi.getText());
			if (v == null) throw new RecognitionException("Unable to resolve variant " + v0.getText() + " in definition of complex variant " + name.getText());
			cv.getVariant().add(v);
			variants.put(cv.getName(), cv);
		}
	)*
	;

sensor : boolsensor | enumsensor ;

boolsensor returns [BooleanVariable s = factory.createBooleanVariable()] :
	{
		model.getContext().add(s);
	}
	"boolean" name:ID
	{
		s.setName(name.getText());
		variables.put(s.getName(), s);
	}
	;

enumsensor returns [EnumVariable s = factory.createEnumVariable()] :
	{
		model.getContext().add(s);
	}
	"enum" name:ID COLON v0:ID 
	{
		s.setName(name.getText());
		EnumLiteral v = factory.createEnumLiteral();
		v.setName(v0.getText());
		s.getLiteral().add(v);
		variables.put(s.getName(), s);
	}
	(
		COMMA vi:ID
		{
			v = factory.createEnumLiteral();
			v.setName(vi.getText());
			s.getLiteral().add(v);
		}
	)*
	;

adaptation : invariant | rule;

invariant :
		{
			Term exp;	
		}
		"invariant" name:ID COLON exp=disjonction
		{
			Invariant inv = factory.createInvariant();
			inv.setName(name.getText());
			inv.setExpression(exp);
			model.getConstraint().add(inv);
		}
	;
	
rule :
	{
		Term left, right;	
	}
	"rule" name:ID COLON "condition" left=disjonction "effect" right=disjonction
	{
		BasicRule r = factory.createBasicRule();
		r.setName(name.getText());
		r.setEffect(right);
		r.setCondition(left);
		model.getRule().add(r);
	}
	;
	
disjonction returns [Term t = null] :
	{
		Term t0, ti;
		ArrayList<Term> terms = new ArrayList<Term>();
	}
    t0=conjunction {terms.add(t0);} 
    ( OR ti=conjunction {terms.add(ti);} )*
    {
    	if (terms.size()== 1) t = t0;
    	else {
    		OrTerm or = factory.createOrTerm();
    		for(Term ot : terms) {
    			or.getTerm().add(ot);	
    		}
    		t = or;
    	}
    }
    ;
   
conjunction returns [Term t = null] :
	{
		Term t0, ti;
		ArrayList<Term> terms = new ArrayList<Term>();
	}
    t0=boolean_atom {terms.add(t0);} 
    ( AND ti=boolean_atom {terms.add(ti);} )*
    {
    	if (terms.size()== 1) t = t0;
    	else {
    		AndTerm and = factory.createAndTerm();
    		for(Term at : terms) {
    			and.getTerm().add(at);	
    		}
    		t = and;
    	}
    }
    ;
 
boolean_atom returns [Term t = null ] :
		{
			Term t0;	
		}
		( NOT {t = factory.createNotTerm();})? 
		( OPEN_PAREN t0=disjonction CLOSE_PAREN | t0=boolean_term )
		{
			if (t == null) t = t0;
			else ((NotTerm)t).setTerm(t0);	
		}
    ;

boolean_term returns [Term t = null ] :
		{
			String name;
			String value = null;
		}
		id:ID { name = id.getText(); }
		( EQUALS v:ID { value = v.getText(); } )?
		{
			if (variables.get(name) != null) {
				Variable s = variables.get(name);
				if (s instanceof BooleanVariable) {
					BooleanTerm bst = factory.createBooleanTerm();
					bst.setVariable(s);
					t = bst;
					if (value != null) throw new RecognitionException("Sensor " + name + " is not an enumeration, cannot compare it to " + value);
				}
				else if (s instanceof EnumVariable) {
					if (value == null) throw new RecognitionException("Sensor " + name + " is an enumeration, it should be compared with a literal");
					EnumTerm est = factory.createEnumTerm();
					est.setVariable(s);
					EnumVariable es = (EnumVariable)s;
					for (int i=0; i<es.getLiteral().size(); i++) {
						if (es.getLiteral().get(i).getName().equals(value)) {
							est.setValue(es.getLiteral().get(i));
							break;
						}	
					}
					if (est.getValue() == null) throw new RecognitionException("Sensor " + name + " does not contains value " + value);
					t = est;
				}
			}
			else if (variants.get(name) != null) {
				if (value != null) throw new RecognitionException("Variant " + name + " is not an enumeration, cannot compare it to " + value);
				Variant var = variants.get(name);
				VariantTerm vt = factory.createVariantTerm();
				vt.setVariant(var);
				t = vt;
			}
			else {
				throw new RecognitionException("Invalid sensor or variant : " + name);
			}
		}
	;

class DivaLexer extends Lexer;

options
{
	testLiterals=true;
	k=8;
}

NOT		: "not";
AND		: "and";
OR		: "or";
OPEN_PAREN	: '(';
CLOSE_PAREN	: ')';
VARIABILITY	: "#variability";
CONTEXT	: "#context";
ADAPTATION	: "#adaptation";
PRE		: "pre";
POST	: "post";
DOT  : '.';
LCURLY  : '{';
RCURLY  : '}';
LBRAK  : '[';
RBRAK  : ']';
PLUS    : '+';
MINUS   : '-';
EQUALS  : '=';
DOLLAR  : '$';
COL_COL  : "::";
SCOL	: ";";
AS		: "as" ;
CREATE	: "create";
TRUE	: "true";
FALSE	: "false";
ARROW	: "->";
COLON	: ":";
COMMA	: ",";

STRING_LITERAL : '"' (ESC | ~('"'|'\\'))* '"' ;
CHAR_LITERAL   : '\'' (ESC | ~'\'') '\'';

// TODO: The (DIGIT DIGIT DIGIT) is cheesy it should be something like
//       ( options { warnWhenFollowAmbig = false; } : (DIGIT)+ )
//       but I don't want to deal with parsing that yet.
protected ESC :
'\\' ('t' | 'f' | 'r' | 'n' | '"' | '\'' | '\\' | (DIGIT DIGIT DIGIT) )
;

ID options { testLiterals=true; }
: ('~')? ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | DIGIT)* ;

// INT_LITERAL completed on 08/04/2005
// INT_LITERAL : (DIGIT)+ ;
INT_LITERAL	:	('-')?(DIGIT)+	;

protected
REAL_LITERAL  : INT_LITERAL '.' INT_LITERAL (EXPONENT)? ;



// need to add floating point
// a couple protected methods to assist in matching floating point numbers
protected
EXPONENT
 : ('e') ('+'|'-')? (DIGIT)+
 ;

protected DIGIT : '0'..'9';


WS : (' ' | '\t' | '\f' | ('\r' | '\n' { newline(); } ))+ 
{ $setType(Token.SKIP); }
;

SINGLE_LINE_COMMENT : "//" (~('\n'|'\r'))* ('\n'|'\r'('\n')?) 		{ $setType(Token.SKIP); }
;

CONTEXT_MULTI_LINE_COMMENT : 
	"/**"
	(
		{ LA(2)!='/' }? '*'
		|	'\r' '\n'
		|	'\r'	
		|	'\n'	
		|	~('*'|'\n'|'\r')
		)*
		"*/"
;

EMPTY_LINE_COMMENT : "/**/"
;
MULTI_LINE_COMMENT : 
	EMPTY_LINE_COMMENT 
	|
	(
		"/*" 
		~('*')
		(
			{ LA(2)!='/' }? '*'
			|	'\r' '\n'  
			|	'\r'	   
			|	'\n'	  
			|	~('*'|'\n'|'\r')
			)*
			"*/"
		{$setType(Token.SKIP);}
	)
;
