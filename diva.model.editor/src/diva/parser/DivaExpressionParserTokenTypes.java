/**
 * Copyright 2014 SINTEF <brice.morin@sintef.no>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// $ANTLR : "expression.g" -> "DivaExpressionParser.java"$


package diva.parser; 


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
