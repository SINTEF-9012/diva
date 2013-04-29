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


class DivaExpressionParser extends Parser;
options
{
	k=1;
}
{
	private static DivaFactory factory = DivaPackageImpl.init().getDivaFactory();
	
	public VariabilityModel model;
	public Hashtable<String, Variable> variables = new Hashtable<String, Variable>();
	public Hashtable<String, Variant> variants = new Hashtable<String, Variant>();
		
	public ArrayList<String> errors = new ArrayList<String>();
	
	public boolean hasErrors() {
		return !errors.isEmpty();	
	}
	
	public void reportError(RecognitionException ex) {
		super.reportError(ex);
		errors.add(ex.toString());
	}
	
	@SuppressWarnings("deprecation")
	public static Term parse(VariabilityModel model, String exp) throws Exception {
		DivaExpressionParser p = new DivaExpressionParser(new DivaLexer(new StringBufferInputStream(exp)));
		p.model = model;
		for(Dimension d :model.getDimension()) {
			for (Variant v : d.getVariant()) {
				p.variants.put(v.getId(), v);
			}
		}
		for (Variable var : model.getContext()) {
			p.variables.put(var.getId(), var);
		}
		Term result = p.expression();
		if (p.hasErrors()) throw new Exception(p.errors.get(0));
		return result;
	}

	public static String print(Term term) {
		return term.accept(DiVATextProvider.getInstance(), null);
	}

}

expression returns [Term t = null] :
	t=disjonction
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
						if (es.getLiteral().get(i).getId().equals(value)) {
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
