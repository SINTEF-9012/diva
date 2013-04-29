// $ANTLR : "expression.g" -> "DivaExpressionParser.java"$


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
import diva.editor.DiVATextProvider;
import diva.impl.*;

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;

public class DivaExpressionParser extends antlr.LLkParser       implements DivaExpressionParserTokenTypes
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


protected DivaExpressionParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public DivaExpressionParser(TokenBuffer tokenBuf) {
  this(tokenBuf,1);
}

protected DivaExpressionParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public DivaExpressionParser(TokenStream lexer) {
  this(lexer,1);
}

public DivaExpressionParser(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
}

	public final Term  expression() throws RecognitionException, TokenStreamException {
		Term t = null;
		
		
		try {      // for error handling
			t=disjonction();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		return t;
	}
	
	public final Term  disjonction() throws RecognitionException, TokenStreamException {
		Term t = null;
		
		
		try {      // for error handling
			
					Term t0, ti;
					ArrayList<Term> terms = new ArrayList<Term>();
				
			t0=conjunction();
			terms.add(t0);
			{
			_loop4:
			do {
				if ((LA(1)==OR)) {
					match(OR);
					ti=conjunction();
					terms.add(ti);
				}
				else {
					break _loop4;
				}
				
			} while (true);
			}
			
				if (terms.size()== 1) t = t0;
				else {
					OrTerm or = factory.createOrTerm();
					for(Term ot : terms) {
						or.getTerm().add(ot);	
					}
					t = or;
				}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		return t;
	}
	
	public final Term  conjunction() throws RecognitionException, TokenStreamException {
		Term t = null;
		
		
		try {      // for error handling
			
					Term t0, ti;
					ArrayList<Term> terms = new ArrayList<Term>();
				
			t0=boolean_atom();
			terms.add(t0);
			{
			_loop7:
			do {
				if ((LA(1)==AND)) {
					match(AND);
					ti=boolean_atom();
					terms.add(ti);
				}
				else {
					break _loop7;
				}
				
			} while (true);
			}
			
				if (terms.size()== 1) t = t0;
				else {
					AndTerm and = factory.createAndTerm();
					for(Term at : terms) {
						and.getTerm().add(at);	
					}
					t = and;
				}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
		return t;
	}
	
	public final Term  boolean_atom() throws RecognitionException, TokenStreamException {
		Term t = null ;
		
		
		try {      // for error handling
			
						Term t0;	
					
			{
			switch ( LA(1)) {
			case NOT:
			{
				match(NOT);
				t = factory.createNotTerm();
				break;
			}
			case OPEN_PAREN:
			case ID:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case OPEN_PAREN:
			{
				match(OPEN_PAREN);
				t0=disjonction();
				match(CLOSE_PAREN);
				break;
			}
			case ID:
			{
				t0=boolean_term();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			
						if (t == null) t = t0;
						else ((NotTerm)t).setTerm(t0);	
					
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
		return t;
	}
	
	public final Term  boolean_term() throws RecognitionException, TokenStreamException {
		Term t = null ;
		
		Token  id = null;
		Token  v = null;
		
		try {      // for error handling
			
						String name;
						String value = null;
					
			id = LT(1);
			match(ID);
			name = id.getText();
			{
			switch ( LA(1)) {
			case EQUALS:
			{
				match(EQUALS);
				v = LT(1);
				match(ID);
				value = v.getText();
				break;
			}
			case EOF:
			case OR:
			case AND:
			case CLOSE_PAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			
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
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
		return t;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"OR",
		"AND",
		"NOT",
		"OPEN_PAREN",
		"CLOSE_PAREN",
		"ID",
		"EQUALS",
		"DOT",
		"LCURLY",
		"RCURLY",
		"LBRAK",
		"RBRAK",
		"PLUS",
		"MINUS",
		"DOLLAR",
		"COL_COL",
		"SCOL",
		"AS",
		"CREATE",
		"TRUE",
		"FALSE",
		"ARROW",
		"COLON",
		"COMMA",
		"STRING_LITERAL",
		"CHAR_LITERAL",
		"ESC",
		"INT_LITERAL",
		"REAL_LITERAL",
		"EXPONENT",
		"DIGIT",
		"WS",
		"SINGLE_LINE_COMMENT",
		"CONTEXT_MULTI_LINE_COMMENT",
		"EMPTY_LINE_COMMENT",
		"MULTI_LINE_COMMENT"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 258L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 274L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 306L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());

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
