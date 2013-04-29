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
import diva.impl.*;

public interface DivaExpressionParserTokenTypes {
	int EOF = 1;
	int NULL_TREE_LOOKAHEAD = 3;
	int OR = 4;
	int AND = 5;
	int NOT = 6;
	int OPEN_PAREN = 7;
	int CLOSE_PAREN = 8;
	int ID = 9;
	int EQUALS = 10;
	int DOT = 11;
	int LCURLY = 12;
	int RCURLY = 13;
	int LBRAK = 14;
	int RBRAK = 15;
	int PLUS = 16;
	int MINUS = 17;
	int DOLLAR = 18;
	int COL_COL = 19;
	int SCOL = 20;
	int AS = 21;
	int CREATE = 22;
	int TRUE = 23;
	int FALSE = 24;
	int ARROW = 25;
	int COLON = 26;
	int COMMA = 27;
	int STRING_LITERAL = 28;
	int CHAR_LITERAL = 29;
	int ESC = 30;
	int INT_LITERAL = 31;
	int REAL_LITERAL = 32;
	int EXPONENT = 33;
	int DIGIT = 34;
	int WS = 35;
	int SINGLE_LINE_COMMENT = 36;
	int CONTEXT_MULTI_LINE_COMMENT = 37;
	int EMPTY_LINE_COMMENT = 38;
	int MULTI_LINE_COMMENT = 39;
}
