// $ANTLR 2.7.2: "XPathParser2.g" -> "XPathParser2.java"$

	package org.exist.parser;

	import antlr.debug.misc.*;
	import java.io.StringReader;
	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.util.Vector;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Iterator;
	import org.exist.storage.BrokerPool;
	import org.exist.storage.DBBroker;
	import org.exist.storage.analysis.Tokenizer;
	import org.exist.EXistException;
	import org.exist.dom.DocumentSet;
	import org.exist.dom.DocumentImpl;
	import org.exist.dom.QName;
	import org.exist.security.PermissionDeniedException;
	import org.exist.security.User;
	import org.exist.xpath.*;
	import org.exist.xpath.value.Type;
	import org.exist.xpath.functions.*;

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
import antlr.collections.AST;
import java.util.Hashtable;
import antlr.ASTFactory;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;

public class XPathParser2 extends antlr.LLkParser       implements XPathParser2TokenTypes
 {

	protected ArrayList exceptions= new ArrayList(2);
	protected boolean foundError= false;
	protected XPathLexer2 lexer;

	public XPathParser2(XPathLexer2 lexer, boolean dummy) {
		this((TokenStream) lexer);
		this.lexer= lexer;
	}

	public boolean foundErrors() {
		return foundError;
	}

	public String getErrorMessage() {
		StringBuffer buf= new StringBuffer();
		for (Iterator i= exceptions.iterator(); i.hasNext();) {
			buf.append(((Exception) i.next()).toString());
			buf.append('\n');
		}
		return buf.toString();
	}

	protected void handleException(Exception e) {
		foundError= true;
		exceptions.add(e);
	}

protected XPathParser2(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public XPathParser2(TokenBuffer tokenBuf) {
  this(tokenBuf,1);
}

protected XPathParser2(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public XPathParser2(TokenStream lexer) {
  this(lexer,1);
}

public XPathParser2(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

	public final void imaginaryTokenDefinitions() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST imaginaryTokenDefinitions_AST = null;
		
		AST tmp53_AST = null;
		tmp53_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp53_AST);
		match(QNAME);
		AST tmp54_AST = null;
		tmp54_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp54_AST);
		match(PREDICATE);
		AST tmp55_AST = null;
		tmp55_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp55_AST);
		match(FLWOR);
		AST tmp56_AST = null;
		tmp56_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp56_AST);
		match(PARENTHESIZED);
		AST tmp57_AST = null;
		tmp57_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp57_AST);
		match(ABSOLUTE_SLASH);
		AST tmp58_AST = null;
		tmp58_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp58_AST);
		match(ABSOLUTE_DSLASH);
		AST tmp59_AST = null;
		tmp59_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp59_AST);
		match(WILDCARD);
		AST tmp60_AST = null;
		tmp60_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp60_AST);
		match(PREFIX_WILDCARD);
		AST tmp61_AST = null;
		tmp61_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp61_AST);
		match(FUNCTION);
		AST tmp62_AST = null;
		tmp62_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp62_AST);
		match(UNARY_MINUS);
		AST tmp63_AST = null;
		tmp63_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp63_AST);
		match(UNARY_PLUS);
		AST tmp64_AST = null;
		tmp64_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp64_AST);
		match(XPOINTER);
		AST tmp65_AST = null;
		tmp65_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp65_AST);
		match(XPOINTER_ID);
		AST tmp66_AST = null;
		tmp66_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp66_AST);
		match(VARIABLE_REF);
		AST tmp67_AST = null;
		tmp67_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp67_AST);
		match(VARIABLE_BINDING);
		AST tmp68_AST = null;
		tmp68_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp68_AST);
		match(ELEMENT);
		AST tmp69_AST = null;
		tmp69_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp69_AST);
		match(ATTRIBUTE);
		AST tmp70_AST = null;
		tmp70_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp70_AST);
		match(TEXT);
		imaginaryTokenDefinitions_AST = (AST)currentAST.root;
		returnAST = imaginaryTokenDefinitions_AST;
	}
	
	public final void xpointer() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST xpointer_AST = null;
		AST ex_AST = null;
		Token  nc = null;
		AST nc_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_xpointer:
		{
			AST tmp71_AST = null;
			tmp71_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp71_AST);
			match(LITERAL_xpointer);
			match(LPAREN);
			expr();
			ex_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			if ( inputState.guessing==0 ) {
				xpointer_AST = (AST)currentAST.root;
				xpointer_AST= (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(XPOINTER,"xpointer")).add(ex_AST));
				currentAST.root = xpointer_AST;
				currentAST.child = xpointer_AST!=null &&xpointer_AST.getFirstChild()!=null ?
					xpointer_AST.getFirstChild() : xpointer_AST;
				currentAST.advanceChildToEnd();
			}
			xpointer_AST = (AST)currentAST.root;
			break;
		}
		case NCNAME:
		{
			nc = LT(1);
			nc_AST = astFactory.create(nc);
			astFactory.addASTChild(currentAST, nc_AST);
			match(NCNAME);
			if ( inputState.guessing==0 ) {
				xpointer_AST = (AST)currentAST.root;
				xpointer_AST= (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(XPOINTER_ID,"id")).add(nc_AST));
				currentAST.root = xpointer_AST;
				currentAST.child = xpointer_AST!=null &&xpointer_AST.getFirstChild()!=null ?
					xpointer_AST.getFirstChild() : xpointer_AST;
				currentAST.advanceChildToEnd();
			}
			xpointer_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = xpointer_AST;
	}
	
	public final void expr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expr_AST = null;
		
		exprSingle();
		astFactory.addASTChild(currentAST, returnAST);
		expr_AST = (AST)currentAST.root;
		returnAST = expr_AST;
	}
	
	public final void xpath() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST xpath_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LPAREN:
			case NCNAME:
			case LITERAL_for:
			case LITERAL_let:
			case DOLLAR:
			case LITERAL_or:
			case LITERAL_and:
			case LT:
			case PLUS:
			case MINUS:
			case STAR:
			case LITERAL_div:
			case LITERAL_mod:
			case SLASH:
			case DSLASH:
			case LITERAL_text:
			case LITERAL_node:
			case SELF:
			case XML_COMMENT:
			case AT:
			case PARENT:
			case LITERAL_child:
			case LITERAL_self:
			case LITERAL_attribute:
			case LITERAL_descendant:
			case 64:
			case 65:
			case LITERAL_parent:
			case LITERAL_ancestor:
			case 68:
			case 69:
			case STRING_LITERAL:
			case DOUBLE_LITERAL:
			case DECIMAL_LITERAL:
			case INTEGER_LITERAL:
			case XML_PI:
			{
				expr();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EOF:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			AST tmp74_AST = null;
			tmp74_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp74_AST);
			match(Token.EOF_TYPE);
			xpath_AST = (AST)currentAST.root;
		}
		catch (RecognitionException e) {
			if (inputState.guessing==0) {
				handleException(e);
			} else {
				throw e;
			}
		}
		returnAST = xpath_AST;
	}
	
	public final void exprSingle() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exprSingle_AST = null;
		
		switch ( LA(1)) {
		case LPAREN:
		case NCNAME:
		case DOLLAR:
		case LITERAL_or:
		case LITERAL_and:
		case LT:
		case PLUS:
		case MINUS:
		case STAR:
		case LITERAL_div:
		case LITERAL_mod:
		case SLASH:
		case DSLASH:
		case LITERAL_text:
		case LITERAL_node:
		case SELF:
		case XML_COMMENT:
		case AT:
		case PARENT:
		case LITERAL_child:
		case LITERAL_self:
		case LITERAL_attribute:
		case LITERAL_descendant:
		case 64:
		case 65:
		case LITERAL_parent:
		case LITERAL_ancestor:
		case 68:
		case 69:
		case STRING_LITERAL:
		case DOUBLE_LITERAL:
		case DECIMAL_LITERAL:
		case INTEGER_LITERAL:
		case XML_PI:
		{
			orExpr();
			astFactory.addASTChild(currentAST, returnAST);
			exprSingle_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_for:
		case LITERAL_let:
		{
			flworExpr();
			astFactory.addASTChild(currentAST, returnAST);
			exprSingle_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = exprSingle_AST;
	}
	
	public final void orExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST orExpr_AST = null;
		
		andExpr();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop21:
		do {
			if ((LA(1)==LITERAL_or)) {
				AST tmp75_AST = null;
				tmp75_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp75_AST);
				match(LITERAL_or);
				andExpr();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop21;
			}
			
		} while (true);
		}
		orExpr_AST = (AST)currentAST.root;
		returnAST = orExpr_AST;
	}
	
	public final void flworExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST flworExpr_AST = null;
		
		{
		int _cnt9=0;
		_loop9:
		do {
			switch ( LA(1)) {
			case LITERAL_for:
			{
				forClause();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_let:
			{
				letClause();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				if ( _cnt9>=1 ) { break _loop9; } else {throw new NoViableAltException(LT(1), getFilename());}
			}
			}
			_cnt9++;
		} while (true);
		}
		{
		switch ( LA(1)) {
		case LITERAL_where:
		{
			AST tmp76_AST = null;
			tmp76_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp76_AST);
			match(LITERAL_where);
			expr();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case LITERAL_return:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		AST tmp77_AST = null;
		tmp77_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp77_AST);
		match(LITERAL_return);
		exprSingle();
		astFactory.addASTChild(currentAST, returnAST);
		flworExpr_AST = (AST)currentAST.root;
		returnAST = flworExpr_AST;
	}
	
	public final void forClause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST forClause_AST = null;
		
		AST tmp78_AST = null;
		tmp78_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp78_AST);
		match(LITERAL_for);
		inVarBinding();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop13:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				inVarBinding();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop13;
			}
			
		} while (true);
		}
		forClause_AST = (AST)currentAST.root;
		returnAST = forClause_AST;
	}
	
	public final void letClause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST letClause_AST = null;
		
		AST tmp80_AST = null;
		tmp80_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp80_AST);
		match(LITERAL_let);
		letVarBinding();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop16:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				letVarBinding();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop16;
			}
			
		} while (true);
		}
		letClause_AST = (AST)currentAST.root;
		returnAST = letClause_AST;
	}
	
	public final void inVarBinding() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST inVarBinding_AST = null;
		AST expr_AST = null;
		String varName;
		
		match(DOLLAR);
		varName=qName();
		astFactory.addASTChild(currentAST, returnAST);
		AST tmp83_AST = null;
		tmp83_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp83_AST);
		match(LITERAL_in);
		exprSingle();
		expr_AST = (AST)returnAST;
		astFactory.addASTChild(currentAST, returnAST);
		if ( inputState.guessing==0 ) {
			inVarBinding_AST = (AST)currentAST.root;
			inVarBinding_AST= (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(VARIABLE_BINDING,varName)).add(expr_AST));
			currentAST.root = inVarBinding_AST;
			currentAST.child = inVarBinding_AST!=null &&inVarBinding_AST.getFirstChild()!=null ?
				inVarBinding_AST.getFirstChild() : inVarBinding_AST;
			currentAST.advanceChildToEnd();
		}
		inVarBinding_AST = (AST)currentAST.root;
		returnAST = inVarBinding_AST;
	}
	
	public final void letVarBinding() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST letVarBinding_AST = null;
		AST expr_AST = null;
		String varName;
		
		match(DOLLAR);
		varName=qName();
		astFactory.addASTChild(currentAST, returnAST);
		match(COLON);
		match(EQ);
		exprSingle();
		expr_AST = (AST)returnAST;
		astFactory.addASTChild(currentAST, returnAST);
		if ( inputState.guessing==0 ) {
			letVarBinding_AST = (AST)currentAST.root;
			letVarBinding_AST= (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(VARIABLE_BINDING,varName)).add(expr_AST));
			currentAST.root = letVarBinding_AST;
			currentAST.child = letVarBinding_AST!=null &&letVarBinding_AST.getFirstChild()!=null ?
				letVarBinding_AST.getFirstChild() : letVarBinding_AST;
			currentAST.advanceChildToEnd();
		}
		letVarBinding_AST = (AST)currentAST.root;
		returnAST = letVarBinding_AST;
	}
	
	public final String  qName() throws RecognitionException, TokenStreamException {
		String name;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST qName_AST = null;
		
			name= null;
			String name2;
		
		
		boolean synPredMatched100 = false;
		if (((_tokenSet_0.member(LA(1))))) {
			int _m100 = mark();
			synPredMatched100 = true;
			inputState.guessing++;
			try {
				{
				ncnameOrKeyword();
				match(COLON);
				ncnameOrKeyword();
				}
			}
			catch (RecognitionException pe) {
				synPredMatched100 = false;
			}
			rewind(_m100);
			inputState.guessing--;
		}
		if ( synPredMatched100 ) {
			name=ncnameOrKeyword();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp87_AST = null;
			tmp87_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp87_AST);
			match(COLON);
			name2=ncnameOrKeyword();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				name= name + ':' + name2;
			}
			qName_AST = (AST)currentAST.root;
		}
		else if ((_tokenSet_0.member(LA(1)))) {
			name=ncnameOrKeyword();
			astFactory.addASTChild(currentAST, returnAST);
			qName_AST = (AST)currentAST.root;
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = qName_AST;
		return name;
	}
	
	public final void andExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST andExpr_AST = null;
		
		comparisonExpr();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop24:
		do {
			if ((LA(1)==LITERAL_and)) {
				AST tmp88_AST = null;
				tmp88_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp88_AST);
				match(LITERAL_and);
				comparisonExpr();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop24;
			}
			
		} while (true);
		}
		andExpr_AST = (AST)currentAST.root;
		returnAST = andExpr_AST;
	}
	
	public final void comparisonExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST comparisonExpr_AST = null;
		
		additiveExpr();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case EQ:
		case NEQ:
		case GT:
		case GTEQ:
		case LT:
		case LTEQ:
		{
			{
			{
			switch ( LA(1)) {
			case EQ:
			{
				AST tmp89_AST = null;
				tmp89_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp89_AST);
				match(EQ);
				break;
			}
			case NEQ:
			{
				AST tmp90_AST = null;
				tmp90_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp90_AST);
				match(NEQ);
				break;
			}
			case GT:
			{
				AST tmp91_AST = null;
				tmp91_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp91_AST);
				match(GT);
				break;
			}
			case GTEQ:
			{
				AST tmp92_AST = null;
				tmp92_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp92_AST);
				match(GTEQ);
				break;
			}
			case LT:
			{
				AST tmp93_AST = null;
				tmp93_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp93_AST);
				match(LT);
				break;
			}
			case LTEQ:
			{
				AST tmp94_AST = null;
				tmp94_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp94_AST);
				match(LTEQ);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			additiveExpr();
			astFactory.addASTChild(currentAST, returnAST);
			}
			break;
		}
		case ANDEQ:
		case OREQ:
		{
			{
			{
			switch ( LA(1)) {
			case ANDEQ:
			{
				AST tmp95_AST = null;
				tmp95_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp95_AST);
				match(ANDEQ);
				break;
			}
			case OREQ:
			{
				AST tmp96_AST = null;
				tmp96_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp96_AST);
				match(OREQ);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			additiveExpr();
			astFactory.addASTChild(currentAST, returnAST);
			}
			break;
		}
		case EOF:
		case RPAREN:
		case LITERAL_where:
		case LITERAL_return:
		case LITERAL_for:
		case COMMA:
		case LITERAL_let:
		case LITERAL_or:
		case LITERAL_and:
		case RPPAREN:
		case RCURLY:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		comparisonExpr_AST = (AST)currentAST.root;
		returnAST = comparisonExpr_AST;
	}
	
	public final void additiveExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST additiveExpr_AST = null;
		
		multiplicativeExpr();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop34:
		do {
			if ((LA(1)==PLUS||LA(1)==MINUS)) {
				{
				switch ( LA(1)) {
				case PLUS:
				{
					AST tmp97_AST = null;
					tmp97_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp97_AST);
					match(PLUS);
					break;
				}
				case MINUS:
				{
					AST tmp98_AST = null;
					tmp98_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp98_AST);
					match(MINUS);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				multiplicativeExpr();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop34;
			}
			
		} while (true);
		}
		additiveExpr_AST = (AST)currentAST.root;
		returnAST = additiveExpr_AST;
	}
	
	public final void multiplicativeExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST multiplicativeExpr_AST = null;
		
		unaryExpr();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop38:
		do {
			if (((LA(1) >= STAR && LA(1) <= LITERAL_mod))) {
				{
				switch ( LA(1)) {
				case STAR:
				{
					AST tmp99_AST = null;
					tmp99_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp99_AST);
					match(STAR);
					break;
				}
				case LITERAL_div:
				{
					AST tmp100_AST = null;
					tmp100_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp100_AST);
					match(LITERAL_div);
					break;
				}
				case LITERAL_mod:
				{
					AST tmp101_AST = null;
					tmp101_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp101_AST);
					match(LITERAL_mod);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				unaryExpr();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop38;
			}
			
		} while (true);
		}
		multiplicativeExpr_AST = (AST)currentAST.root;
		returnAST = multiplicativeExpr_AST;
	}
	
	public final void unaryExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST unaryExpr_AST = null;
		AST expr_AST = null;
		AST expr2_AST = null;
		
		switch ( LA(1)) {
		case MINUS:
		{
			AST tmp102_AST = null;
			tmp102_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp102_AST);
			match(MINUS);
			unionExpr();
			expr_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				unaryExpr_AST = (AST)currentAST.root;
				unaryExpr_AST= (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(UNARY_MINUS,"-")).add(expr_AST));
				currentAST.root = unaryExpr_AST;
				currentAST.child = unaryExpr_AST!=null &&unaryExpr_AST.getFirstChild()!=null ?
					unaryExpr_AST.getFirstChild() : unaryExpr_AST;
				currentAST.advanceChildToEnd();
			}
			unaryExpr_AST = (AST)currentAST.root;
			break;
		}
		case PLUS:
		{
			AST tmp103_AST = null;
			tmp103_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp103_AST);
			match(PLUS);
			unionExpr();
			expr2_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				unaryExpr_AST = (AST)currentAST.root;
				unaryExpr_AST= (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(UNARY_PLUS,"+")).add(expr2_AST));
				currentAST.root = unaryExpr_AST;
				currentAST.child = unaryExpr_AST!=null &&unaryExpr_AST.getFirstChild()!=null ?
					unaryExpr_AST.getFirstChild() : unaryExpr_AST;
				currentAST.advanceChildToEnd();
			}
			unaryExpr_AST = (AST)currentAST.root;
			break;
		}
		case LPAREN:
		case NCNAME:
		case DOLLAR:
		case LITERAL_or:
		case LITERAL_and:
		case LT:
		case STAR:
		case LITERAL_div:
		case LITERAL_mod:
		case SLASH:
		case DSLASH:
		case LITERAL_text:
		case LITERAL_node:
		case SELF:
		case XML_COMMENT:
		case AT:
		case PARENT:
		case LITERAL_child:
		case LITERAL_self:
		case LITERAL_attribute:
		case LITERAL_descendant:
		case 64:
		case 65:
		case LITERAL_parent:
		case LITERAL_ancestor:
		case 68:
		case 69:
		case STRING_LITERAL:
		case DOUBLE_LITERAL:
		case DECIMAL_LITERAL:
		case INTEGER_LITERAL:
		case XML_PI:
		{
			unionExpr();
			astFactory.addASTChild(currentAST, returnAST);
			unaryExpr_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = unaryExpr_AST;
	}
	
	public final void unionExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST unionExpr_AST = null;
		
		pathExpr();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case UNION:
		{
			AST tmp104_AST = null;
			tmp104_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp104_AST);
			match(UNION);
			pathExpr();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case EOF:
		case RPAREN:
		case LITERAL_where:
		case LITERAL_return:
		case LITERAL_for:
		case COMMA:
		case LITERAL_let:
		case EQ:
		case LITERAL_or:
		case LITERAL_and:
		case NEQ:
		case GT:
		case GTEQ:
		case LT:
		case LTEQ:
		case ANDEQ:
		case OREQ:
		case PLUS:
		case MINUS:
		case STAR:
		case LITERAL_div:
		case LITERAL_mod:
		case RPPAREN:
		case RCURLY:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		unionExpr_AST = (AST)currentAST.root;
		returnAST = unionExpr_AST;
	}
	
	public final void pathExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST pathExpr_AST = null;
		AST relPath_AST = null;
		AST relPath2_AST = null;
		
		switch ( LA(1)) {
		case LPAREN:
		case NCNAME:
		case DOLLAR:
		case LITERAL_or:
		case LITERAL_and:
		case LT:
		case STAR:
		case LITERAL_div:
		case LITERAL_mod:
		case LITERAL_text:
		case LITERAL_node:
		case SELF:
		case XML_COMMENT:
		case AT:
		case PARENT:
		case LITERAL_child:
		case LITERAL_self:
		case LITERAL_attribute:
		case LITERAL_descendant:
		case 64:
		case 65:
		case LITERAL_parent:
		case LITERAL_ancestor:
		case 68:
		case 69:
		case STRING_LITERAL:
		case DOUBLE_LITERAL:
		case DECIMAL_LITERAL:
		case INTEGER_LITERAL:
		case XML_PI:
		{
			relativePathExpr();
			astFactory.addASTChild(currentAST, returnAST);
			pathExpr_AST = (AST)currentAST.root;
			break;
		}
		case DSLASH:
		{
			AST tmp105_AST = null;
			tmp105_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp105_AST);
			match(DSLASH);
			relativePathExpr();
			relPath2_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				pathExpr_AST = (AST)currentAST.root;
				pathExpr_AST= (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ABSOLUTE_DSLASH,"AbsoluteSlashSlash")).add(relPath2_AST));
				currentAST.root = pathExpr_AST;
				currentAST.child = pathExpr_AST!=null &&pathExpr_AST.getFirstChild()!=null ?
					pathExpr_AST.getFirstChild() : pathExpr_AST;
				currentAST.advanceChildToEnd();
			}
			pathExpr_AST = (AST)currentAST.root;
			break;
		}
		default:
			boolean synPredMatched44 = false;
			if (((LA(1)==SLASH))) {
				int _m44 = mark();
				synPredMatched44 = true;
				inputState.guessing++;
				try {
					{
					match(SLASH);
					relativePathExpr();
					}
				}
				catch (RecognitionException pe) {
					synPredMatched44 = false;
				}
				rewind(_m44);
				inputState.guessing--;
			}
			if ( synPredMatched44 ) {
				AST tmp106_AST = null;
				tmp106_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp106_AST);
				match(SLASH);
				relativePathExpr();
				relPath_AST = (AST)returnAST;
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					pathExpr_AST = (AST)currentAST.root;
					pathExpr_AST= (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ABSOLUTE_SLASH,"AbsoluteSlash")).add(relPath_AST));
					currentAST.root = pathExpr_AST;
					currentAST.child = pathExpr_AST!=null &&pathExpr_AST.getFirstChild()!=null ?
						pathExpr_AST.getFirstChild() : pathExpr_AST;
					currentAST.advanceChildToEnd();
				}
				pathExpr_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==SLASH)) {
				AST tmp107_AST = null;
				tmp107_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp107_AST);
				match(SLASH);
				if ( inputState.guessing==0 ) {
					pathExpr_AST = (AST)currentAST.root;
					pathExpr_AST= astFactory.create(ABSOLUTE_SLASH,"AbsoluteSlash");
					currentAST.root = pathExpr_AST;
					currentAST.child = pathExpr_AST!=null &&pathExpr_AST.getFirstChild()!=null ?
						pathExpr_AST.getFirstChild() : pathExpr_AST;
					currentAST.advanceChildToEnd();
				}
				pathExpr_AST = (AST)currentAST.root;
			}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = pathExpr_AST;
	}
	
	public final void relativePathExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST relativePathExpr_AST = null;
		
		stepExpr();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop48:
		do {
			if ((LA(1)==SLASH||LA(1)==DSLASH)) {
				{
				switch ( LA(1)) {
				case SLASH:
				{
					AST tmp108_AST = null;
					tmp108_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp108_AST);
					match(SLASH);
					break;
				}
				case DSLASH:
				{
					AST tmp109_AST = null;
					tmp109_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp109_AST);
					match(DSLASH);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				stepExpr();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop48;
			}
			
		} while (true);
		}
		relativePathExpr_AST = (AST)currentAST.root;
		returnAST = relativePathExpr_AST;
	}
	
	public final void stepExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST stepExpr_AST = null;
		
		boolean synPredMatched52 = false;
		if (((_tokenSet_1.member(LA(1))))) {
			int _m52 = mark();
			synPredMatched52 = true;
			inputState.guessing++;
			try {
				{
				{
				switch ( LA(1)) {
				case LITERAL_text:
				{
					match(LITERAL_text);
					break;
				}
				case LITERAL_node:
				{
					match(LITERAL_node);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				match(LPAREN);
				}
			}
			catch (RecognitionException pe) {
				synPredMatched52 = false;
			}
			rewind(_m52);
			inputState.guessing--;
		}
		if ( synPredMatched52 ) {
			axisStep();
			astFactory.addASTChild(currentAST, returnAST);
			stepExpr_AST = (AST)currentAST.root;
		}
		else {
			boolean synPredMatched55 = false;
			if (((_tokenSet_2.member(LA(1))))) {
				int _m55 = mark();
				synPredMatched55 = true;
				inputState.guessing++;
				try {
					{
					switch ( LA(1)) {
					case DOLLAR:
					{
						match(DOLLAR);
						break;
					}
					case NCNAME:
					case LITERAL_or:
					case LITERAL_and:
					case LITERAL_div:
					case LITERAL_mod:
					case LITERAL_text:
					case LITERAL_node:
					case LITERAL_child:
					case LITERAL_self:
					case LITERAL_attribute:
					case LITERAL_descendant:
					case 64:
					case 65:
					case LITERAL_parent:
					case LITERAL_ancestor:
					case 68:
					case 69:
					{
						{
						qName();
						match(LPAREN);
						}
						break;
					}
					case SELF:
					{
						match(SELF);
						break;
					}
					case LPAREN:
					{
						match(LPAREN);
						break;
					}
					case STRING_LITERAL:
					case DOUBLE_LITERAL:
					case DECIMAL_LITERAL:
					case INTEGER_LITERAL:
					{
						literal();
						break;
					}
					case LT:
					{
						match(LT);
						break;
					}
					case XML_COMMENT:
					{
						match(XML_COMMENT);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
				}
				catch (RecognitionException pe) {
					synPredMatched55 = false;
				}
				rewind(_m55);
				inputState.guessing--;
			}
			if ( synPredMatched55 ) {
				filterStep();
				astFactory.addASTChild(currentAST, returnAST);
				stepExpr_AST = (AST)currentAST.root;
			}
			else if ((_tokenSet_1.member(LA(1)))) {
				axisStep();
				astFactory.addASTChild(currentAST, returnAST);
				stepExpr_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			returnAST = stepExpr_AST;
		}
		
	public final void axisStep() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST axisStep_AST = null;
		
		{
		forwardOrReverseStep();
		astFactory.addASTChild(currentAST, returnAST);
		}
		predicates();
		astFactory.addASTChild(currentAST, returnAST);
		axisStep_AST = (AST)currentAST.root;
		returnAST = axisStep_AST;
	}
	
	public final void literal() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST literal_AST = null;
		
		switch ( LA(1)) {
		case STRING_LITERAL:
		{
			AST tmp110_AST = null;
			tmp110_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp110_AST);
			match(STRING_LITERAL);
			literal_AST = (AST)currentAST.root;
			break;
		}
		case DOUBLE_LITERAL:
		case DECIMAL_LITERAL:
		case INTEGER_LITERAL:
		{
			numericLiteral();
			astFactory.addASTChild(currentAST, returnAST);
			literal_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = literal_AST;
	}
	
	public final void filterStep() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST filterStep_AST = null;
		
		primaryExpr();
		astFactory.addASTChild(currentAST, returnAST);
		predicates();
		astFactory.addASTChild(currentAST, returnAST);
		filterStep_AST = (AST)currentAST.root;
		returnAST = filterStep_AST;
	}
	
	public final void forwardOrReverseStep() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST forwardOrReverseStep_AST = null;
		
		boolean synPredMatched64 = false;
		if ((((LA(1) >= LITERAL_child && LA(1) <= 65)))) {
			int _m64 = mark();
			synPredMatched64 = true;
			inputState.guessing++;
			try {
				{
				forwardAxisSpecifier();
				match(COLON);
				}
			}
			catch (RecognitionException pe) {
				synPredMatched64 = false;
			}
			rewind(_m64);
			inputState.guessing--;
		}
		if ( synPredMatched64 ) {
			forwardAxis();
			astFactory.addASTChild(currentAST, returnAST);
			nodeTest();
			astFactory.addASTChild(currentAST, returnAST);
			forwardOrReverseStep_AST = (AST)currentAST.root;
		}
		else {
			boolean synPredMatched66 = false;
			if ((((LA(1) >= LITERAL_parent && LA(1) <= 69)))) {
				int _m66 = mark();
				synPredMatched66 = true;
				inputState.guessing++;
				try {
					{
					reverseAxisSpecifier();
					match(COLON);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched66 = false;
				}
				rewind(_m66);
				inputState.guessing--;
			}
			if ( synPredMatched66 ) {
				reverseAxis();
				astFactory.addASTChild(currentAST, returnAST);
				nodeTest();
				astFactory.addASTChild(currentAST, returnAST);
				forwardOrReverseStep_AST = (AST)currentAST.root;
			}
			else if ((_tokenSet_1.member(LA(1)))) {
				abbrevStep();
				astFactory.addASTChild(currentAST, returnAST);
				forwardOrReverseStep_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			returnAST = forwardOrReverseStep_AST;
		}
		
	public final void predicates() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST predicates_AST = null;
		
		{
		_loop60:
		do {
			if ((LA(1)==LPPAREN)) {
				predicate();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop60;
			}
			
		} while (true);
		}
		predicates_AST = (AST)currentAST.root;
		returnAST = predicates_AST;
	}
	
	public final void predicate() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST predicate_AST = null;
		AST predExpr_AST = null;
		
		match(LPPAREN);
		expr();
		predExpr_AST = (AST)returnAST;
		astFactory.addASTChild(currentAST, returnAST);
		match(RPPAREN);
		if ( inputState.guessing==0 ) {
			predicate_AST = (AST)currentAST.root;
			predicate_AST= (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PREDICATE,"Pred")).add(predExpr_AST));
			currentAST.root = predicate_AST;
			currentAST.child = predicate_AST!=null &&predicate_AST.getFirstChild()!=null ?
				predicate_AST.getFirstChild() : predicate_AST;
			currentAST.advanceChildToEnd();
		}
		predicate_AST = (AST)currentAST.root;
		returnAST = predicate_AST;
	}
	
	public final void forwardAxisSpecifier() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST forwardAxisSpecifier_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_child:
		{
			AST tmp113_AST = null;
			tmp113_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp113_AST);
			match(LITERAL_child);
			forwardAxisSpecifier_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_self:
		{
			AST tmp114_AST = null;
			tmp114_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp114_AST);
			match(LITERAL_self);
			forwardAxisSpecifier_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_attribute:
		{
			AST tmp115_AST = null;
			tmp115_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp115_AST);
			match(LITERAL_attribute);
			forwardAxisSpecifier_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_descendant:
		{
			AST tmp116_AST = null;
			tmp116_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp116_AST);
			match(LITERAL_descendant);
			forwardAxisSpecifier_AST = (AST)currentAST.root;
			break;
		}
		case 64:
		{
			AST tmp117_AST = null;
			tmp117_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp117_AST);
			match(64);
			forwardAxisSpecifier_AST = (AST)currentAST.root;
			break;
		}
		case 65:
		{
			AST tmp118_AST = null;
			tmp118_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp118_AST);
			match(65);
			forwardAxisSpecifier_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = forwardAxisSpecifier_AST;
	}
	
	public final void forwardAxis() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST forwardAxis_AST = null;
		
		forwardAxisSpecifier();
		astFactory.addASTChild(currentAST, returnAST);
		match(COLON);
		match(COLON);
		forwardAxis_AST = (AST)currentAST.root;
		returnAST = forwardAxis_AST;
	}
	
	public final void nodeTest() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST nodeTest_AST = null;
		
		boolean synPredMatched76 = false;
		if (((LA(1)==LITERAL_text||LA(1)==LITERAL_node))) {
			int _m76 = mark();
			synPredMatched76 = true;
			inputState.guessing++;
			try {
				{
				{
				switch ( LA(1)) {
				case LITERAL_text:
				{
					match(LITERAL_text);
					break;
				}
				case LITERAL_node:
				{
					match(LITERAL_node);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				match(LPAREN);
				}
			}
			catch (RecognitionException pe) {
				synPredMatched76 = false;
			}
			rewind(_m76);
			inputState.guessing--;
		}
		if ( synPredMatched76 ) {
			kindTest();
			astFactory.addASTChild(currentAST, returnAST);
			nodeTest_AST = (AST)currentAST.root;
		}
		else if ((_tokenSet_3.member(LA(1)))) {
			nameTest();
			astFactory.addASTChild(currentAST, returnAST);
			nodeTest_AST = (AST)currentAST.root;
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = nodeTest_AST;
	}
	
	public final void reverseAxisSpecifier() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST reverseAxisSpecifier_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_parent:
		{
			AST tmp121_AST = null;
			tmp121_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp121_AST);
			match(LITERAL_parent);
			reverseAxisSpecifier_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ancestor:
		{
			AST tmp122_AST = null;
			tmp122_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp122_AST);
			match(LITERAL_ancestor);
			reverseAxisSpecifier_AST = (AST)currentAST.root;
			break;
		}
		case 68:
		{
			AST tmp123_AST = null;
			tmp123_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp123_AST);
			match(68);
			reverseAxisSpecifier_AST = (AST)currentAST.root;
			break;
		}
		case 69:
		{
			AST tmp124_AST = null;
			tmp124_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp124_AST);
			match(69);
			reverseAxisSpecifier_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = reverseAxisSpecifier_AST;
	}
	
	public final void reverseAxis() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST reverseAxis_AST = null;
		
		reverseAxisSpecifier();
		astFactory.addASTChild(currentAST, returnAST);
		match(COLON);
		match(COLON);
		reverseAxis_AST = (AST)currentAST.root;
		returnAST = reverseAxis_AST;
	}
	
	public final void abbrevStep() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST abbrevStep_AST = null;
		
		switch ( LA(1)) {
		case NCNAME:
		case LITERAL_or:
		case LITERAL_and:
		case STAR:
		case LITERAL_div:
		case LITERAL_mod:
		case LITERAL_text:
		case LITERAL_node:
		case AT:
		case LITERAL_child:
		case LITERAL_self:
		case LITERAL_attribute:
		case LITERAL_descendant:
		case 64:
		case 65:
		case LITERAL_parent:
		case LITERAL_ancestor:
		case 68:
		case 69:
		{
			{
			switch ( LA(1)) {
			case AT:
			{
				AST tmp127_AST = null;
				tmp127_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp127_AST);
				match(AT);
				break;
			}
			case NCNAME:
			case LITERAL_or:
			case LITERAL_and:
			case STAR:
			case LITERAL_div:
			case LITERAL_mod:
			case LITERAL_text:
			case LITERAL_node:
			case LITERAL_child:
			case LITERAL_self:
			case LITERAL_attribute:
			case LITERAL_descendant:
			case 64:
			case 65:
			case LITERAL_parent:
			case LITERAL_ancestor:
			case 68:
			case 69:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			nodeTest();
			astFactory.addASTChild(currentAST, returnAST);
			abbrevStep_AST = (AST)currentAST.root;
			break;
		}
		case PARENT:
		{
			AST tmp128_AST = null;
			tmp128_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp128_AST);
			match(PARENT);
			abbrevStep_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = abbrevStep_AST;
	}
	
	public final void kindTest() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST kindTest_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_text:
		{
			textTest();
			astFactory.addASTChild(currentAST, returnAST);
			kindTest_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_node:
		{
			anyKindTest();
			astFactory.addASTChild(currentAST, returnAST);
			kindTest_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = kindTest_AST;
	}
	
	public final void nameTest() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST nameTest_AST = null;
		String name= null;
		
		boolean synPredMatched80 = false;
		if (((LA(1)==NCNAME||LA(1)==STAR))) {
			int _m80 = mark();
			synPredMatched80 = true;
			inputState.guessing++;
			try {
				{
				switch ( LA(1)) {
				case NCNAME:
				{
					{
					match(NCNAME);
					match(COLON);
					match(STAR);
					}
					break;
				}
				case STAR:
				{
					match(STAR);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
			}
			catch (RecognitionException pe) {
				synPredMatched80 = false;
			}
			rewind(_m80);
			inputState.guessing--;
		}
		if ( synPredMatched80 ) {
			wildcard();
			astFactory.addASTChild(currentAST, returnAST);
			nameTest_AST = (AST)currentAST.root;
		}
		else if ((_tokenSet_0.member(LA(1)))) {
			name=qName();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				nameTest_AST = (AST)currentAST.root;
				nameTest_AST= astFactory.create(QNAME,name);
				currentAST.root = nameTest_AST;
				currentAST.child = nameTest_AST!=null &&nameTest_AST.getFirstChild()!=null ?
					nameTest_AST.getFirstChild() : nameTest_AST;
				currentAST.advanceChildToEnd();
			}
			nameTest_AST = (AST)currentAST.root;
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = nameTest_AST;
	}
	
	public final void wildcard() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST wildcard_AST = null;
		Token  nc1 = null;
		AST nc1_AST = null;
		Token  nc2 = null;
		AST nc2_AST = null;
		
		boolean synPredMatched83 = false;
		if (((LA(1)==STAR))) {
			int _m83 = mark();
			synPredMatched83 = true;
			inputState.guessing++;
			try {
				{
				match(STAR);
				match(COLON);
				}
			}
			catch (RecognitionException pe) {
				synPredMatched83 = false;
			}
			rewind(_m83);
			inputState.guessing--;
		}
		if ( synPredMatched83 ) {
			match(STAR);
			match(COLON);
			nc1 = LT(1);
			nc1_AST = astFactory.create(nc1);
			astFactory.addASTChild(currentAST, nc1_AST);
			match(NCNAME);
			if ( inputState.guessing==0 ) {
				wildcard_AST = (AST)currentAST.root;
				wildcard_AST= (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PREFIX_WILDCARD,"*")).add(nc1_AST));
				currentAST.root = wildcard_AST;
				currentAST.child = wildcard_AST!=null &&wildcard_AST.getFirstChild()!=null ?
					wildcard_AST.getFirstChild() : wildcard_AST;
				currentAST.advanceChildToEnd();
			}
			wildcard_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==NCNAME)) {
			nc2 = LT(1);
			nc2_AST = astFactory.create(nc2);
			astFactory.addASTChild(currentAST, nc2_AST);
			match(NCNAME);
			match(COLON);
			match(STAR);
			if ( inputState.guessing==0 ) {
				wildcard_AST = (AST)currentAST.root;
				wildcard_AST= (AST)astFactory.make( (new ASTArray(2)).add(nc2_AST).add(astFactory.create(WILDCARD,"*")));
				currentAST.root = wildcard_AST;
				currentAST.child = wildcard_AST!=null &&wildcard_AST.getFirstChild()!=null ?
					wildcard_AST.getFirstChild() : wildcard_AST;
				currentAST.advanceChildToEnd();
			}
			wildcard_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==STAR)) {
			AST tmp133_AST = null;
			tmp133_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp133_AST);
			match(STAR);
			if ( inputState.guessing==0 ) {
				wildcard_AST = (AST)currentAST.root;
				
						// make this distinct from multiplication
						wildcard_AST= astFactory.create(WILDCARD,"*");
					
				currentAST.root = wildcard_AST;
				currentAST.child = wildcard_AST!=null &&wildcard_AST.getFirstChild()!=null ?
					wildcard_AST.getFirstChild() : wildcard_AST;
				currentAST.advanceChildToEnd();
			}
			wildcard_AST = (AST)currentAST.root;
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = wildcard_AST;
	}
	
	public final void primaryExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST primaryExpr_AST = null;
		String varName= null;
		
		switch ( LA(1)) {
		case NCNAME:
		case LITERAL_or:
		case LITERAL_and:
		case LITERAL_div:
		case LITERAL_mod:
		case LITERAL_text:
		case LITERAL_node:
		case LITERAL_child:
		case LITERAL_self:
		case LITERAL_attribute:
		case LITERAL_descendant:
		case 64:
		case 65:
		case LITERAL_parent:
		case LITERAL_ancestor:
		case 68:
		case 69:
		{
			functionCall();
			astFactory.addASTChild(currentAST, returnAST);
			primaryExpr_AST = (AST)currentAST.root;
			break;
		}
		case SELF:
		{
			contextItemExpr();
			astFactory.addASTChild(currentAST, returnAST);
			primaryExpr_AST = (AST)currentAST.root;
			break;
		}
		case LPAREN:
		{
			parenthesizedExpr();
			astFactory.addASTChild(currentAST, returnAST);
			primaryExpr_AST = (AST)currentAST.root;
			break;
		}
		case DOLLAR:
		{
			match(DOLLAR);
			varName=qName();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				primaryExpr_AST = (AST)currentAST.root;
				primaryExpr_AST= astFactory.create(VARIABLE_REF,varName);
				currentAST.root = primaryExpr_AST;
				currentAST.child = primaryExpr_AST!=null &&primaryExpr_AST.getFirstChild()!=null ?
					primaryExpr_AST.getFirstChild() : primaryExpr_AST;
				currentAST.advanceChildToEnd();
			}
			primaryExpr_AST = (AST)currentAST.root;
			break;
		}
		case LT:
		case XML_COMMENT:
		case XML_PI:
		{
			constructor();
			astFactory.addASTChild(currentAST, returnAST);
			primaryExpr_AST = (AST)currentAST.root;
			break;
		}
		case STRING_LITERAL:
		case DOUBLE_LITERAL:
		case DECIMAL_LITERAL:
		case INTEGER_LITERAL:
		{
			literal();
			astFactory.addASTChild(currentAST, returnAST);
			primaryExpr_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = primaryExpr_AST;
	}
	
	public final void functionCall() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST functionCall_AST = null;
		AST params_AST = null;
		String fnName= null;
		
		fnName=qName();
		astFactory.addASTChild(currentAST, returnAST);
		match(LPAREN);
		if ( inputState.guessing==0 ) {
			functionCall_AST = (AST)currentAST.root;
			functionCall_AST= astFactory.create(FUNCTION,fnName);
			currentAST.root = functionCall_AST;
			currentAST.child = functionCall_AST!=null &&functionCall_AST.getFirstChild()!=null ?
				functionCall_AST.getFirstChild() : functionCall_AST;
			currentAST.advanceChildToEnd();
		}
		{
		switch ( LA(1)) {
		case LPAREN:
		case NCNAME:
		case LITERAL_for:
		case LITERAL_let:
		case DOLLAR:
		case LITERAL_or:
		case LITERAL_and:
		case LT:
		case PLUS:
		case MINUS:
		case STAR:
		case LITERAL_div:
		case LITERAL_mod:
		case SLASH:
		case DSLASH:
		case LITERAL_text:
		case LITERAL_node:
		case SELF:
		case XML_COMMENT:
		case AT:
		case PARENT:
		case LITERAL_child:
		case LITERAL_self:
		case LITERAL_attribute:
		case LITERAL_descendant:
		case 64:
		case 65:
		case LITERAL_parent:
		case LITERAL_ancestor:
		case 68:
		case 69:
		case STRING_LITERAL:
		case DOUBLE_LITERAL:
		case DECIMAL_LITERAL:
		case INTEGER_LITERAL:
		case XML_PI:
		{
			functionParameters();
			params_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				functionCall_AST = (AST)currentAST.root;
				functionCall_AST= (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FUNCTION,fnName)).add(params_AST));
				currentAST.root = functionCall_AST;
				currentAST.child = functionCall_AST!=null &&functionCall_AST.getFirstChild()!=null ?
					functionCall_AST.getFirstChild() : functionCall_AST;
				currentAST.advanceChildToEnd();
			}
			break;
		}
		case RPAREN:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(RPAREN);
		functionCall_AST = (AST)currentAST.root;
		returnAST = functionCall_AST;
	}
	
	public final void contextItemExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST contextItemExpr_AST = null;
		
		AST tmp137_AST = null;
		tmp137_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp137_AST);
		match(SELF);
		contextItemExpr_AST = (AST)currentAST.root;
		returnAST = contextItemExpr_AST;
	}
	
	public final void parenthesizedExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parenthesizedExpr_AST = null;
		AST e_AST = null;
		
		match(LPAREN);
		expr();
		e_AST = (AST)returnAST;
		astFactory.addASTChild(currentAST, returnAST);
		match(RPAREN);
		if ( inputState.guessing==0 ) {
			parenthesizedExpr_AST = (AST)currentAST.root;
			parenthesizedExpr_AST= (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PARENTHESIZED,"Parenthesized")).add(e_AST));
			currentAST.root = parenthesizedExpr_AST;
			currentAST.child = parenthesizedExpr_AST!=null &&parenthesizedExpr_AST.getFirstChild()!=null ?
				parenthesizedExpr_AST.getFirstChild() : parenthesizedExpr_AST;
			currentAST.advanceChildToEnd();
		}
		parenthesizedExpr_AST = (AST)currentAST.root;
		returnAST = parenthesizedExpr_AST;
	}
	
	public final void constructor() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constructor_AST = null;
		
		switch ( LA(1)) {
		case LT:
		{
			elementConstructor();
			astFactory.addASTChild(currentAST, returnAST);
			constructor_AST = (AST)currentAST.root;
			break;
		}
		case XML_COMMENT:
		{
			xmlComment();
			astFactory.addASTChild(currentAST, returnAST);
			constructor_AST = (AST)currentAST.root;
			break;
		}
		case XML_PI:
		{
			xmlPI();
			astFactory.addASTChild(currentAST, returnAST);
			constructor_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = constructor_AST;
	}
	
	public final void numericLiteral() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST numericLiteral_AST = null;
		
		switch ( LA(1)) {
		case DOUBLE_LITERAL:
		{
			AST tmp140_AST = null;
			tmp140_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp140_AST);
			match(DOUBLE_LITERAL);
			numericLiteral_AST = (AST)currentAST.root;
			break;
		}
		case DECIMAL_LITERAL:
		{
			AST tmp141_AST = null;
			tmp141_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp141_AST);
			match(DECIMAL_LITERAL);
			numericLiteral_AST = (AST)currentAST.root;
			break;
		}
		case INTEGER_LITERAL:
		{
			AST tmp142_AST = null;
			tmp142_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp142_AST);
			match(INTEGER_LITERAL);
			numericLiteral_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = numericLiteral_AST;
	}
	
	public final void functionParameters() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST functionParameters_AST = null;
		
		expr();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop93:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				expr();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop93;
			}
			
		} while (true);
		}
		functionParameters_AST = (AST)currentAST.root;
		returnAST = functionParameters_AST;
	}
	
	public final void textTest() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST textTest_AST = null;
		
		AST tmp144_AST = null;
		tmp144_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp144_AST);
		match(LITERAL_text);
		match(LPAREN);
		match(RPAREN);
		textTest_AST = (AST)currentAST.root;
		returnAST = textTest_AST;
	}
	
	public final void anyKindTest() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST anyKindTest_AST = null;
		
		AST tmp147_AST = null;
		tmp147_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp147_AST);
		match(LITERAL_node);
		match(LPAREN);
		match(RPAREN);
		anyKindTest_AST = (AST)currentAST.root;
		returnAST = anyKindTest_AST;
	}
	
	public final String  ncnameOrKeyword() throws RecognitionException, TokenStreamException {
		String name;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST ncnameOrKeyword_AST = null;
		Token  n1 = null;
		AST n1_AST = null;
		name= null;
		
		switch ( LA(1)) {
		case NCNAME:
		{
			n1 = LT(1);
			n1_AST = astFactory.create(n1);
			astFactory.addASTChild(currentAST, n1_AST);
			match(NCNAME);
			if ( inputState.guessing==0 ) {
				name= n1.getText();
			}
			ncnameOrKeyword_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_or:
		case LITERAL_and:
		case LITERAL_div:
		case LITERAL_mod:
		case LITERAL_text:
		case LITERAL_node:
		case LITERAL_child:
		case LITERAL_self:
		case LITERAL_attribute:
		case LITERAL_descendant:
		case 64:
		case 65:
		case LITERAL_parent:
		case LITERAL_ancestor:
		case 68:
		case 69:
		{
			name=reservedKeywords();
			astFactory.addASTChild(currentAST, returnAST);
			ncnameOrKeyword_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = ncnameOrKeyword_AST;
		return name;
	}
	
	public final void elementConstructor() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST elementConstructor_AST = null;
		
			String name= null;
			lexer.wsExplicit= true;
		
		
		boolean synPredMatched105 = false;
		if (((LA(1)==LT))) {
			int _m105 = mark();
			synPredMatched105 = true;
			inputState.guessing++;
			try {
				{
				match(LT);
				match(NCNAME);
				{
				switch ( LA(1)) {
				case COLON:
				{
					match(COLON);
					match(NCNAME);
					break;
				}
				case WS:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				match(WS);
				}
			}
			catch (RecognitionException pe) {
				synPredMatched105 = false;
			}
			rewind(_m105);
			inputState.guessing--;
		}
		if ( synPredMatched105 ) {
			elementWithAttributes();
			astFactory.addASTChild(currentAST, returnAST);
			elementConstructor_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==LT)) {
			elementWithoutAttributes();
			astFactory.addASTChild(currentAST, returnAST);
			elementConstructor_AST = (AST)currentAST.root;
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = elementConstructor_AST;
	}
	
	public final void xmlComment() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST xmlComment_AST = null;
		
		AST tmp150_AST = null;
		tmp150_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp150_AST);
		match(XML_COMMENT);
		match(XML_COMMENT_END);
		xmlComment_AST = (AST)currentAST.root;
		returnAST = xmlComment_AST;
	}
	
	public final void xmlPI() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST xmlPI_AST = null;
		
		AST tmp152_AST = null;
		tmp152_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp152_AST);
		match(XML_PI);
		match(XML_PI_END);
		xmlPI_AST = (AST)currentAST.root;
		returnAST = xmlPI_AST;
	}
	
	public final void elementWithAttributes() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST elementWithAttributes_AST = null;
		AST attrs_AST = null;
		AST content_AST = null;
		String name= null;
		
		match(LT);
		name=qName();
		astFactory.addASTChild(currentAST, returnAST);
		attributeList();
		attrs_AST = (AST)returnAST;
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case SLASH:
		{
			{
			match(SLASH);
			match(GT);
			if ( inputState.guessing==0 ) {
				elementWithAttributes_AST = (AST)currentAST.root;
				elementWithAttributes_AST= (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ELEMENT,name)).add(attrs_AST));
				currentAST.root = elementWithAttributes_AST;
				currentAST.child = elementWithAttributes_AST!=null &&elementWithAttributes_AST.getFirstChild()!=null ?
					elementWithAttributes_AST.getFirstChild() : elementWithAttributes_AST;
				currentAST.advanceChildToEnd();
			}
			}
			break;
		}
		case GT:
		{
			{
			match(GT);
			if ( inputState.guessing==0 ) {
				lexer.inElementContent= true;
			}
			mixedElementContent();
			content_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			match(END_TAG_START);
			name=qName();
			match(GT);
			if ( inputState.guessing==0 ) {
				elementWithAttributes_AST = (AST)currentAST.root;
				elementWithAttributes_AST= (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ELEMENT,name)).add(attrs_AST));
				currentAST.root = elementWithAttributes_AST;
				currentAST.child = elementWithAttributes_AST!=null &&elementWithAttributes_AST.getFirstChild()!=null ?
					elementWithAttributes_AST.getFirstChild() : elementWithAttributes_AST;
				currentAST.advanceChildToEnd();
			}
			}
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		elementWithAttributes_AST = (AST)currentAST.root;
		returnAST = elementWithAttributes_AST;
	}
	
	public final void elementWithoutAttributes() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST elementWithoutAttributes_AST = null;
		AST content_AST = null;
		String name= null;
		
		AST tmp160_AST = null;
		tmp160_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp160_AST);
		match(LT);
		name=qName();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case SLASH:
		{
			{
			match(SLASH);
			match(GT);
			if ( inputState.guessing==0 ) {
				elementWithoutAttributes_AST = (AST)currentAST.root;
				elementWithoutAttributes_AST= astFactory.create(ELEMENT,name);
				currentAST.root = elementWithoutAttributes_AST;
				currentAST.child = elementWithoutAttributes_AST!=null &&elementWithoutAttributes_AST.getFirstChild()!=null ?
					elementWithoutAttributes_AST.getFirstChild() : elementWithoutAttributes_AST;
				currentAST.advanceChildToEnd();
			}
			}
			break;
		}
		case GT:
		{
			{
			match(GT);
			if ( inputState.guessing==0 ) {
				lexer.inElementContent= true;
			}
			mixedElementContent();
			content_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			match(END_TAG_START);
			name=qName();
			match(GT);
			if ( inputState.guessing==0 ) {
				elementWithoutAttributes_AST = (AST)currentAST.root;
				elementWithoutAttributes_AST= (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ELEMENT,name)).add(content_AST));
				currentAST.root = elementWithoutAttributes_AST;
				currentAST.child = elementWithoutAttributes_AST!=null &&elementWithoutAttributes_AST.getFirstChild()!=null ?
					elementWithoutAttributes_AST.getFirstChild() : elementWithoutAttributes_AST;
				currentAST.advanceChildToEnd();
			}
			}
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		elementWithoutAttributes_AST = (AST)currentAST.root;
		returnAST = elementWithoutAttributes_AST;
	}
	
	public final void mixedElementContent() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST mixedElementContent_AST = null;
		
		{
		_loop123:
		do {
			if ((_tokenSet_4.member(LA(1)))) {
				elementContent();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop123;
			}
			
		} while (true);
		}
		mixedElementContent_AST = (AST)currentAST.root;
		returnAST = mixedElementContent_AST;
	}
	
	public final void attributeList() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST attributeList_AST = null;
		
		{
		int _cnt116=0;
		_loop116:
		do {
			if ((LA(1)==WS)) {
				attributeDef();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				if ( _cnt116>=1 ) { break _loop116; } else {throw new NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt116++;
		} while (true);
		}
		attributeList_AST = (AST)currentAST.root;
		returnAST = attributeList_AST;
	}
	
	public final void attributeDef() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST attributeDef_AST = null;
		AST value_AST = null;
		
			String name= null;
			lexer.parseStringLiterals= false;
		
		
		match(WS);
		name=qName();
		match(EQ);
		match(QUOT);
		if ( inputState.guessing==0 ) {
			lexer.inAttributeContent= true;
		}
		attributeValue();
		value_AST = (AST)returnAST;
		astFactory.addASTChild(currentAST, returnAST);
		if ( inputState.guessing==0 ) {
			lexer.inAttributeContent= false;
		}
		match(QUOT);
		if ( inputState.guessing==0 ) {
			lexer.parseStringLiterals= true;
		}
		if ( inputState.guessing==0 ) {
			attributeDef_AST = (AST)currentAST.root;
			attributeDef_AST= (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ATTRIBUTE,name)).add(value_AST));
			currentAST.root = attributeDef_AST;
			currentAST.child = attributeDef_AST!=null &&attributeDef_AST.getFirstChild()!=null ?
				attributeDef_AST.getFirstChild() : attributeDef_AST;
			currentAST.advanceChildToEnd();
		}
		attributeDef_AST = (AST)currentAST.root;
		returnAST = attributeDef_AST;
	}
	
	public final void attributeValue() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST attributeValue_AST = null;
		
		{
		int _cnt120=0;
		_loop120:
		do {
			switch ( LA(1)) {
			case ATTRIBUTE_CONTENT:
			{
				AST tmp170_AST = null;
				tmp170_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp170_AST);
				match(ATTRIBUTE_CONTENT);
				break;
			}
			case LCURLY:
			{
				attributeEnclosedExpr();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				if ( _cnt120>=1 ) { break _loop120; } else {throw new NoViableAltException(LT(1), getFilename());}
			}
			}
			_cnt120++;
		} while (true);
		}
		attributeValue_AST = (AST)currentAST.root;
		returnAST = attributeValue_AST;
	}
	
	public final void attributeEnclosedExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST attributeEnclosedExpr_AST = null;
		
		AST tmp171_AST = null;
		tmp171_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp171_AST);
		match(LCURLY);
		if ( inputState.guessing==0 ) {
			
					lexer.inAttributeContent= false;
					lexer.wsExplicit= false;
				
		}
		expr();
		astFactory.addASTChild(currentAST, returnAST);
		match(RCURLY);
		if ( inputState.guessing==0 ) {
			
					lexer.inAttributeContent= true;
					lexer.wsExplicit= true;
				
		}
		attributeEnclosedExpr_AST = (AST)currentAST.root;
		returnAST = attributeEnclosedExpr_AST;
	}
	
	public final void elementContent() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST elementContent_AST = null;
		Token  content = null;
		AST content_AST = null;
		
		switch ( LA(1)) {
		case LT:
		{
			elementConstructor();
			astFactory.addASTChild(currentAST, returnAST);
			elementContent_AST = (AST)currentAST.root;
			break;
		}
		case ELEMENT_CONTENT:
		{
			content = LT(1);
			content_AST = astFactory.create(content);
			astFactory.addASTChild(currentAST, content_AST);
			match(ELEMENT_CONTENT);
			if ( inputState.guessing==0 ) {
				elementContent_AST = (AST)currentAST.root;
				elementContent_AST= astFactory.create(TEXT,content.getText());
				currentAST.root = elementContent_AST;
				currentAST.child = elementContent_AST!=null &&elementContent_AST.getFirstChild()!=null ?
					elementContent_AST.getFirstChild() : elementContent_AST;
				currentAST.advanceChildToEnd();
			}
			elementContent_AST = (AST)currentAST.root;
			break;
		}
		case XML_COMMENT:
		{
			xmlComment();
			astFactory.addASTChild(currentAST, returnAST);
			elementContent_AST = (AST)currentAST.root;
			break;
		}
		case XML_PI:
		{
			xmlPI();
			astFactory.addASTChild(currentAST, returnAST);
			elementContent_AST = (AST)currentAST.root;
			break;
		}
		case LCURLY:
		{
			enclosedExpr();
			astFactory.addASTChild(currentAST, returnAST);
			elementContent_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = elementContent_AST;
	}
	
	public final void enclosedExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enclosedExpr_AST = null;
		
		AST tmp173_AST = null;
		tmp173_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp173_AST);
		match(LCURLY);
		if ( inputState.guessing==0 ) {
			
					lexer.inElementContent= false;
					lexer.wsExplicit= false;
				
		}
		expr();
		astFactory.addASTChild(currentAST, returnAST);
		match(RCURLY);
		if ( inputState.guessing==0 ) {
			
					lexer.inElementContent= true;
					lexer.wsExplicit= true;
				
		}
		enclosedExpr_AST = (AST)currentAST.root;
		returnAST = enclosedExpr_AST;
	}
	
	public final String  reservedKeywords() throws RecognitionException, TokenStreamException {
		String name;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST reservedKeywords_AST = null;
		name= null;
		
		switch ( LA(1)) {
		case LITERAL_div:
		{
			AST tmp175_AST = null;
			tmp175_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp175_AST);
			match(LITERAL_div);
			if ( inputState.guessing==0 ) {
				name= "div";
			}
			reservedKeywords_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_mod:
		{
			AST tmp176_AST = null;
			tmp176_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp176_AST);
			match(LITERAL_mod);
			if ( inputState.guessing==0 ) {
				name= "mod";
			}
			reservedKeywords_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_text:
		{
			AST tmp177_AST = null;
			tmp177_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp177_AST);
			match(LITERAL_text);
			if ( inputState.guessing==0 ) {
				name= "text";
			}
			reservedKeywords_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_node:
		{
			AST tmp178_AST = null;
			tmp178_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp178_AST);
			match(LITERAL_node);
			if ( inputState.guessing==0 ) {
				name= "node";
			}
			reservedKeywords_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_or:
		{
			AST tmp179_AST = null;
			tmp179_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp179_AST);
			match(LITERAL_or);
			if ( inputState.guessing==0 ) {
				name= "or";
			}
			reservedKeywords_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_and:
		{
			AST tmp180_AST = null;
			tmp180_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp180_AST);
			match(LITERAL_and);
			if ( inputState.guessing==0 ) {
				name= "and";
			}
			reservedKeywords_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_child:
		{
			AST tmp181_AST = null;
			tmp181_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp181_AST);
			match(LITERAL_child);
			if ( inputState.guessing==0 ) {
				name= "child";
			}
			reservedKeywords_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_parent:
		{
			AST tmp182_AST = null;
			tmp182_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp182_AST);
			match(LITERAL_parent);
			if ( inputState.guessing==0 ) {
				name= "parent";
			}
			reservedKeywords_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_self:
		{
			AST tmp183_AST = null;
			tmp183_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp183_AST);
			match(LITERAL_self);
			if ( inputState.guessing==0 ) {
				name= "self";
			}
			reservedKeywords_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_attribute:
		{
			AST tmp184_AST = null;
			tmp184_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp184_AST);
			match(LITERAL_attribute);
			if ( inputState.guessing==0 ) {
				name= "attribute";
			}
			reservedKeywords_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ancestor:
		{
			AST tmp185_AST = null;
			tmp185_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp185_AST);
			match(LITERAL_ancestor);
			if ( inputState.guessing==0 ) {
				name= "ancestor";
			}
			reservedKeywords_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_descendant:
		{
			AST tmp186_AST = null;
			tmp186_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp186_AST);
			match(LITERAL_descendant);
			if ( inputState.guessing==0 ) {
				name= "descendant";
			}
			reservedKeywords_AST = (AST)currentAST.root;
			break;
		}
		case 64:
		{
			AST tmp187_AST = null;
			tmp187_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp187_AST);
			match(64);
			if ( inputState.guessing==0 ) {
				name= "descendant-or-self";
			}
			reservedKeywords_AST = (AST)currentAST.root;
			break;
		}
		case 68:
		{
			AST tmp188_AST = null;
			tmp188_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp188_AST);
			match(68);
			if ( inputState.guessing==0 ) {
				name= "ancestor-or-self";
			}
			reservedKeywords_AST = (AST)currentAST.root;
			break;
		}
		case 69:
		{
			AST tmp189_AST = null;
			tmp189_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp189_AST);
			match(69);
			if ( inputState.guessing==0 ) {
				name= "preceding-sibling";
			}
			reservedKeywords_AST = (AST)currentAST.root;
			break;
		}
		case 65:
		{
			AST tmp190_AST = null;
			tmp190_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp190_AST);
			match(65);
			if ( inputState.guessing==0 ) {
				name= "following-sibling";
			}
			reservedKeywords_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = reservedKeywords_AST;
		return name;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"QNAME",
		"PREDICATE",
		"FLWOR",
		"PARENTHESIZED",
		"ABSOLUTE_SLASH",
		"ABSOLUTE_DSLASH",
		"WILDCARD",
		"PREFIX_WILDCARD",
		"FUNCTION",
		"UNARY_MINUS",
		"UNARY_PLUS",
		"XPOINTER",
		"XPOINTER_ID",
		"VARIABLE_REF",
		"VARIABLE_BINDING",
		"ELEMENT",
		"ATTRIBUTE",
		"TEXT",
		"\"xpointer\"",
		"LPAREN",
		"RPAREN",
		"NCNAME",
		"\"where\"",
		"\"return\"",
		"\"for\"",
		"COMMA",
		"\"let\"",
		"DOLLAR",
		"\"in\"",
		"COLON",
		"EQ",
		"\"or\"",
		"\"and\"",
		"NEQ",
		"GT",
		"GTEQ",
		"LT",
		"LTEQ",
		"ANDEQ",
		"OREQ",
		"PLUS",
		"MINUS",
		"STAR",
		"\"div\"",
		"\"mod\"",
		"UNION",
		"SLASH",
		"DSLASH",
		"\"text\"",
		"\"node\"",
		"SELF",
		"XML_COMMENT",
		"LPPAREN",
		"RPPAREN",
		"AT",
		"PARENT",
		"\"child\"",
		"\"self\"",
		"\"attribute\"",
		"\"descendant\"",
		"\"descendant-or-self\"",
		"\"following-sibling\"",
		"\"parent\"",
		"\"ancestor\"",
		"\"ancestor-or-self\"",
		"\"preceding-sibling\"",
		"STRING_LITERAL",
		"DOUBLE_LITERAL",
		"DECIMAL_LITERAL",
		"INTEGER_LITERAL",
		"WS",
		"END_TAG_START",
		"QUOT",
		"ATTRIBUTE_CONTENT",
		"ELEMENT_CONTENT",
		"XML_COMMENT_END",
		"XML_PI",
		"XML_PI_END",
		"LCURLY",
		"RCURLY",
		"XML_PI_START",
		"BASECHAR",
		"IDEOGRAPHIC",
		"COMBINING_CHAR",
		"DIGIT",
		"EXTENDER",
		"LETTER",
		"DIGITS",
		"HEX_DIGITS",
		"NMSTART",
		"NMCHAR",
		"PREDEFINED_ENTITY_REF",
		"CHAR_REF",
		"NEXT_TOKEN"
	};
	
	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { -1138988390146899968L, 63L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { -274226892947587072L, 63L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { -1084944092950953984L, 66559L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { -1138918021402722304L, 63L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 36029896530591744L, 344064L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	
	}
