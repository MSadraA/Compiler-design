// Generated from /home/sadra/Documents/Codes/Compiler-design/CA1/src/main/grammar/CPY.g4 by ANTLR 4.13.2
package main.grammar;

    import java.util.ArrayList;
    import java.util.List;
    import main.ast.nodes.*;
    import main.ast.nodes.declaration.*;
    import main.ast.nodes.declarator.pointer.*;
    import main.ast.nodes.expression.*;
    import main.ast.nodes.declarator.*;
    import main.ast.nodes.specifier.*;
    import main.ast.nodes.statement.*;
    import main.ast.nodes.type.*;
    import main.ast.nodes.expression.initializer.*;
    import main.ast.nodes.expression.operator.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CPYParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Break=1, Char=2, Const=3, Continue=4, Do=5, Double=6, Else=7, Float=8, 
		For=9, If=10, Int=11, Long=12, Return=13, Short=14, Signed=15, Sizeof=16, 
		Switch=17, Typedef=18, Unsigned=19, Void=20, While=21, Bool=22, LeftParen=23, 
		RightParen=24, LeftBracket=25, RightBracket=26, LeftBrace=27, RightBrace=28, 
		Less=29, LessEqual=30, Greater=31, GreaterEqual=32, LeftShift=33, RightShift=34, 
		Plus=35, PlusPlus=36, Minus=37, MinusMinus=38, Star=39, Div=40, Mod=41, 
		And=42, Or=43, AndAnd=44, OrOr=45, Xor=46, Not=47, Tilde=48, Question=49, 
		Colon=50, Semi=51, Comma=52, Assign=53, StarAssign=54, DivAssign=55, ModAssign=56, 
		PlusAssign=57, MinusAssign=58, LeftShiftAssign=59, RightShiftAssign=60, 
		AndAssign=61, XorAssign=62, OrAssign=63, Equal=64, NotEqual=65, Arrow=66, 
		Dot=67, Identifier=68, Constant=69, DigitSequence=70, StringLiteral=71, 
		MultiLineMacro=72, Directive=73, Whitespace=74, Newline=75, BlockComment=76, 
		LineComment=77;
	public static final int
		RULE_program = 0, RULE_translationUnit = 1, RULE_externalDeclaration = 2, 
		RULE_functionDefinition = 3, RULE_declarationList = 4, RULE_expression = 5, 
		RULE_prefixexpression = 6, RULE_prefixOperator = 7, RULE_postfixExpression = 8, 
		RULE_primaryExpression = 9, RULE_argumentExpressionList = 10, RULE_unaryOperator = 11, 
		RULE_castExpression = 12, RULE_castType = 13, RULE_assignmentOperator = 14, 
		RULE_declaration = 15, RULE_declarationSpecifiers = 16, RULE_declarationSpecifier = 17, 
		RULE_initDeclaratorList = 18, RULE_initDeclarator = 19, RULE_typeSpecifier = 20, 
		RULE_specifierQualifierList = 21, RULE_declarator = 22, RULE_directDeclarator = 23, 
		RULE_pointer = 24, RULE_parameterList = 25, RULE_parameterDeclaration = 26, 
		RULE_identifierList = 27, RULE_typeName = 28, RULE_abstractDeclarator = 29, 
		RULE_directAbstractDeclarator = 30, RULE_initializer = 31, RULE_initializerList = 32, 
		RULE_initializerEntry = 33, RULE_designation = 34, RULE_designator = 35, 
		RULE_statement = 36, RULE_compoundStatement = 37, RULE_blockItem = 38, 
		RULE_expressionStatement = 39, RULE_selectionStatement = 40, RULE_iterationStatement = 41, 
		RULE_forCondition = 42, RULE_forDeclaration = 43, RULE_jumpStatement = 44;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "translationUnit", "externalDeclaration", "functionDefinition", 
			"declarationList", "expression", "prefixexpression", "prefixOperator", 
			"postfixExpression", "primaryExpression", "argumentExpressionList", "unaryOperator", 
			"castExpression", "castType", "assignmentOperator", "declaration", "declarationSpecifiers", 
			"declarationSpecifier", "initDeclaratorList", "initDeclarator", "typeSpecifier", 
			"specifierQualifierList", "declarator", "directDeclarator", "pointer", 
			"parameterList", "parameterDeclaration", "identifierList", "typeName", 
			"abstractDeclarator", "directAbstractDeclarator", "initializer", "initializerList", 
			"initializerEntry", "designation", "designator", "statement", "compoundStatement", 
			"blockItem", "expressionStatement", "selectionStatement", "iterationStatement", 
			"forCondition", "forDeclaration", "jumpStatement"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'break'", "'char'", "'const'", "'continue'", "'do'", "'double'", 
			"'else'", "'float'", "'for'", "'if'", "'int'", "'long'", "'return'", 
			"'short'", "'signed'", "'sizeof'", "'switch'", "'typedef'", "'unsigned'", 
			"'void'", "'while'", "'bool'", "'('", "')'", "'['", "']'", "'{'", "'}'", 
			"'<'", "'<='", "'>'", "'>='", "'<< = new ReturnsSt'", "'>>'", "'+'", 
			"'++'", "'-'", "'--'", "'*'", "'/'", "'%'", "'&'", "'|'", "'&&'", "'||'", 
			"'^'", "'!'", "'~'", "'?'", "':'", "';'", "','", "'='", "'*='", "'/='", 
			"'%='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'=='", 
			"'!='", "'->'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Break", "Char", "Const", "Continue", "Do", "Double", "Else", "Float", 
			"For", "If", "Int", "Long", "Return", "Short", "Signed", "Sizeof", "Switch", 
			"Typedef", "Unsigned", "Void", "While", "Bool", "LeftParen", "RightParen", 
			"LeftBracket", "RightBracket", "LeftBrace", "RightBrace", "Less", "LessEqual", 
			"Greater", "GreaterEqual", "LeftShift", "RightShift", "Plus", "PlusPlus", 
			"Minus", "MinusMinus", "Star", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", 
			"Xor", "Not", "Tilde", "Question", "Colon", "Semi", "Comma", "Assign", 
			"StarAssign", "DivAssign", "ModAssign", "PlusAssign", "MinusAssign", 
			"LeftShiftAssign", "RightShiftAssign", "AndAssign", "XorAssign", "OrAssign", 
			"Equal", "NotEqual", "Arrow", "Dot", "Identifier", "Constant", "DigitSequence", 
			"StringLiteral", "MultiLineMacro", "Directive", "Whitespace", "Newline", 
			"BlockComment", "LineComment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CPY.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CPYParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program programRet;
		public TranslationUnitContext t;
		public TerminalNode EOF() { return getToken(CPYParser.EOF, 0); }
		public TranslationUnitContext translationUnit() {
			return getRuleContext(TranslationUnitContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2252349583972684L) != 0) || _la==Identifier) {
				{
				setState(90);
				((ProgramContext)_localctx).t = translationUnit();
				 ((ProgramContext)_localctx).programRet =  ((ProgramContext)_localctx).t.programRet; 
				}
			}

			setState(95);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TranslationUnitContext extends ParserRuleContext {
		public Program programRet;
		public ExternalDeclarationContext e;
		public List<ExternalDeclarationContext> externalDeclaration() {
			return getRuleContexts(ExternalDeclarationContext.class);
		}
		public ExternalDeclarationContext externalDeclaration(int i) {
			return getRuleContext(ExternalDeclarationContext.class,i);
		}
		public TranslationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterTranslationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitTranslationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitTranslationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TranslationUnitContext translationUnit() throws RecognitionException {
		TranslationUnitContext _localctx = new TranslationUnitContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_translationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((TranslationUnitContext)_localctx).programRet =  new Program(); 
			setState(101); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(98);
				((TranslationUnitContext)_localctx).e = externalDeclaration();
				 if (((TranslationUnitContext)_localctx).e.declarationRet != null) _localctx.programRet.addDeclaration(((TranslationUnitContext)_localctx).e.declarationRet); 
				}
				}
				setState(103); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2252349583972684L) != 0) || _la==Identifier );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExternalDeclarationContext extends ParserRuleContext {
		public Declaration declarationRet;
		public FunctionDefinitionContext f;
		public DeclarationContext d;
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode Semi() { return getToken(CPYParser.Semi, 0); }
		public ExternalDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_externalDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterExternalDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitExternalDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitExternalDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExternalDeclarationContext externalDeclaration() throws RecognitionException {
		ExternalDeclarationContext _localctx = new ExternalDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_externalDeclaration);
		try {
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				((ExternalDeclarationContext)_localctx).f = functionDefinition();
				 ((ExternalDeclarationContext)_localctx).declarationRet =  ((ExternalDeclarationContext)_localctx).f.functionDecRet; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				((ExternalDeclarationContext)_localctx).d = declaration();
				 ((ExternalDeclarationContext)_localctx).declarationRet =  ((ExternalDeclarationContext)_localctx).d.varDecRet; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				match(Semi);
				 ((ExternalDeclarationContext)_localctx).declarationRet =  null; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public FuncDec functionDecRet;
		public DeclarationSpecifiersContext a;
		public DeclaratorContext b;
		public DeclarationListContext c;
		public CompoundStatementContext d;
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public DeclarationListContext declarationList() {
			return getRuleContext(DeclarationListContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((FunctionDefinitionContext)_localctx).functionDecRet =  new FuncDec(); 
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(116);
				((FunctionDefinitionContext)_localctx).a = declarationSpecifiers();
				_localctx.functionDecRet.setSpecifiers(((FunctionDefinitionContext)_localctx).a.specifiersRet);
				}
				break;
			}
			setState(121);
			((FunctionDefinitionContext)_localctx).b = declarator();
			 _localctx.functionDecRet.setDeclarator(((FunctionDefinitionContext)_localctx).b.declaratorRet); 
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6084940L) != 0) || _la==Identifier) {
				{
				setState(123);
				((FunctionDefinitionContext)_localctx).c = declarationList();
				_localctx.functionDecRet.setVarDec(((FunctionDefinitionContext)_localctx).c.varDecsRet);
				}
			}

			setState(128);
			((FunctionDefinitionContext)_localctx).d = compoundStatement();
			 _localctx.functionDecRet.setStatement(((FunctionDefinitionContext)_localctx).d.compoundStatementRet); 
			_localctx.functionDecRet.setLine(((FunctionDefinitionContext)_localctx).d.compoundStatementRet.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationListContext extends ParserRuleContext {
		public List<VarDec> varDecsRet;
		public DeclarationContext d;
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public DeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitDeclarationList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitDeclarationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationListContext declarationList() throws RecognitionException {
		DeclarationListContext _localctx = new DeclarationListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declarationList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((DeclarationListContext)_localctx).varDecsRet =  new ArrayList<>(); 
			setState(136); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(133);
				((DeclarationListContext)_localctx).d = declaration();
				_localctx.varDecsRet.add(((DeclarationListContext)_localctx).d.varDecRet);
				}
				}
				setState(138); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 6084940L) != 0) || _la==Identifier );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expression expressionRet;
		public ExpressionContext e1;
		public ExpressionContext e;
		public PrimaryExpressionContext pri;
		public PrefixexpressionContext pre;
		public CastTypeContext c;
		public ExpressionContext e2;
		public Token And;
		public Token Xor;
		public Token Or;
		public Token AndAnd;
		public Token OrOr;
		public Token Question;
		public ExpressionContext e3;
		public AssignmentOperatorContext op;
		public Token LeftBracket;
		public ArgumentExpressionListContext a;
		public Token PlusPlus;
		public Token MinusMinus;
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public PrefixexpressionContext prefixexpression() {
			return getRuleContext(PrefixexpressionContext.class,0);
		}
		public CastTypeContext castType() {
			return getRuleContext(CastTypeContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Star() { return getToken(CPYParser.Star, 0); }
		public TerminalNode Div() { return getToken(CPYParser.Div, 0); }
		public TerminalNode Mod() { return getToken(CPYParser.Mod, 0); }
		public TerminalNode Plus() { return getToken(CPYParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(CPYParser.Minus, 0); }
		public TerminalNode LeftShift() { return getToken(CPYParser.LeftShift, 0); }
		public TerminalNode RightShift() { return getToken(CPYParser.RightShift, 0); }
		public TerminalNode Less() { return getToken(CPYParser.Less, 0); }
		public TerminalNode Greater() { return getToken(CPYParser.Greater, 0); }
		public TerminalNode LessEqual() { return getToken(CPYParser.LessEqual, 0); }
		public TerminalNode GreaterEqual() { return getToken(CPYParser.GreaterEqual, 0); }
		public TerminalNode Equal() { return getToken(CPYParser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(CPYParser.NotEqual, 0); }
		public TerminalNode And() { return getToken(CPYParser.And, 0); }
		public TerminalNode Xor() { return getToken(CPYParser.Xor, 0); }
		public TerminalNode Or() { return getToken(CPYParser.Or, 0); }
		public TerminalNode AndAnd() { return getToken(CPYParser.AndAnd, 0); }
		public TerminalNode OrOr() { return getToken(CPYParser.OrOr, 0); }
		public TerminalNode Question() { return getToken(CPYParser.Question, 0); }
		public TerminalNode Colon() { return getToken(CPYParser.Colon, 0); }
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(CPYParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPYParser.RightBracket, 0); }
		public TerminalNode LeftParen() { return getToken(CPYParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPYParser.RightParen, 0); }
		public ArgumentExpressionListContext argumentExpressionList() {
			return getRuleContext(ArgumentExpressionListContext.class,0);
		}
		public TerminalNode PlusPlus() { return getToken(CPYParser.PlusPlus, 0); }
		public TerminalNode MinusMinus() { return getToken(CPYParser.MinusMinus, 0); }
		public List<TerminalNode> Comma() { return getTokens(CPYParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPYParser.Comma, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(141);
				((ExpressionContext)_localctx).pri = primaryExpression();
				((ExpressionContext)_localctx).expressionRet =  ((ExpressionContext)_localctx).pri.expressionRet;
				}
				break;
			case 2:
				{
				setState(144);
				((ExpressionContext)_localctx).pre = prefixexpression();
				((ExpressionContext)_localctx).expressionRet =  ((ExpressionContext)_localctx).pre.expressionRet;
				}
				break;
			case 3:
				{
				setState(147);
				((ExpressionContext)_localctx).c = castType();
				((ExpressionContext)_localctx).expressionRet =  ((ExpressionContext)_localctx).c.expressionRet;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(288);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(286);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(152);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");

						                  ((ExpressionContext)_localctx).expressionRet =  new BinaryExpression();
						                  _localctx.expressionRet.setLeftOperand(((ExpressionContext)_localctx).e1.expressionRet);
						                  _localctx.expressionRet.setLine(((ExpressionContext)_localctx).e1.expressionRet.getLine());
						              
						setState(160);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case Star:
							{
							setState(154);
							match(Star);
							_localctx.expressionRet.setBinaryOperator(BinaryOperator.MUL);
							}
							break;
						case Div:
							{
							setState(156);
							match(Div);
							_localctx.expressionRet.setBinaryOperator(BinaryOperator.DIV);
							}
							break;
						case Mod:
							{
							setState(158);
							match(Mod);
							_localctx.expressionRet.setBinaryOperator(BinaryOperator.MOD);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(162);
						((ExpressionContext)_localctx).e2 = expression(15);
						_localctx.expressionRet.setRightOperand(((ExpressionContext)_localctx).e2.expressionRet);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(165);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");

						                  ((ExpressionContext)_localctx).expressionRet =  new BinaryExpression();
						                  _localctx.expressionRet.setLeftOperand(((ExpressionContext)_localctx).e1.expressionRet);
						                  _localctx.expressionRet.setLine(((ExpressionContext)_localctx).e1.expressionRet.getLine());
						              
						setState(171);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case Plus:
							{
							setState(167);
							match(Plus);
							 _localctx.expressionRet.setBinaryOperator(BinaryOperator.PLUS); 
							}
							break;
						case Minus:
							{
							setState(169);
							match(Minus);
							 _localctx.expressionRet.setBinaryOperator(BinaryOperator.MINUS); 
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(173);
						((ExpressionContext)_localctx).e2 = expression(14);
						 _localctx.expressionRet.setRightOperand(((ExpressionContext)_localctx).e2.expressionRet); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(176);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");

						                  ((ExpressionContext)_localctx).expressionRet =  new BinaryExpression();
						                  _localctx.expressionRet.setLeftOperand(((ExpressionContext)_localctx).e1.expressionRet);
						                  _localctx.expressionRet.setLine(((ExpressionContext)_localctx).e1.expressionRet.getLine());
						              
						setState(182);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case LeftShift:
							{
							setState(178);
							match(LeftShift);
							 _localctx.expressionRet.setBinaryOperator(BinaryOperator.LEFT_SHIFT); 
							}
							break;
						case RightShift:
							{
							setState(180);
							match(RightShift);
							 _localctx.expressionRet.setBinaryOperator(BinaryOperator.RIGHT_SHIFT); 
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(184);
						((ExpressionContext)_localctx).e2 = expression(13);
						 _localctx.expressionRet.setRightOperand(((ExpressionContext)_localctx).e2.expressionRet); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(187);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");

						                  ((ExpressionContext)_localctx).expressionRet =  new BinaryExpression();
						                  _localctx.expressionRet.setLeftOperand(((ExpressionContext)_localctx).e1.expressionRet);
						                  _localctx.expressionRet.setLine(((ExpressionContext)_localctx).e1.expressionRet.getLine());
						              
						setState(197);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case Less:
							{
							setState(189);
							match(Less);
							 _localctx.expressionRet.setBinaryOperator(BinaryOperator.LESS_THAN); 
							}
							break;
						case Greater:
							{
							setState(191);
							match(Greater);
							 _localctx.expressionRet.setBinaryOperator(BinaryOperator.GREATER_THAN); 
							}
							break;
						case LessEqual:
							{
							setState(193);
							match(LessEqual);
							 _localctx.expressionRet.setBinaryOperator(BinaryOperator.LESS_EQUAL); 
							}
							break;
						case GreaterEqual:
							{
							setState(195);
							match(GreaterEqual);
							 _localctx.expressionRet.setBinaryOperator(BinaryOperator.GREATER_EQUAL); 
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(199);
						((ExpressionContext)_localctx).e2 = expression(12);
						 _localctx.expressionRet.setRightOperand(((ExpressionContext)_localctx).e2.expressionRet); 
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(202);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");

						                  ((ExpressionContext)_localctx).expressionRet =  new BinaryExpression();
						                  _localctx.expressionRet.setLeftOperand(((ExpressionContext)_localctx).e1.expressionRet);
						                  _localctx.expressionRet.setLine(((ExpressionContext)_localctx).e1.expressionRet.getLine());
						              
						setState(208);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case Equal:
							{
							setState(204);
							match(Equal);
							 _localctx.expressionRet.setBinaryOperator(BinaryOperator.EQUAL); 
							}
							break;
						case NotEqual:
							{
							setState(206);
							match(NotEqual);
							 _localctx.expressionRet.setBinaryOperator(BinaryOperator.NOT_EQUAL); 
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(210);
						((ExpressionContext)_localctx).e2 = expression(11);
						 _localctx.expressionRet.setRightOperand(((ExpressionContext)_localctx).e2.expressionRet); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(213);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(214);
						((ExpressionContext)_localctx).And = match(And);
						setState(215);
						((ExpressionContext)_localctx).e2 = expression(10);
						 ((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet,((ExpressionContext)_localctx).e2.expressionRet,BinaryOperator.BITWISE_AND,((ExpressionContext)_localctx).And.getLine()); 
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(218);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(219);
						((ExpressionContext)_localctx).And = match(And);
						setState(220);
						((ExpressionContext)_localctx).e2 = expression(9);
						 ((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, ((ExpressionContext)_localctx).e2.expressionRet, BinaryOperator.BITWISE_AND, ((ExpressionContext)_localctx).And.getLine()); 
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(223);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(224);
						((ExpressionContext)_localctx).Xor = match(Xor);
						setState(225);
						((ExpressionContext)_localctx).e2 = expression(8);
						 ((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, ((ExpressionContext)_localctx).e2.expressionRet, BinaryOperator.BITWISE_XOR, ((ExpressionContext)_localctx).Xor.getLine()); 
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(228);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(229);
						((ExpressionContext)_localctx).Or = match(Or);
						setState(230);
						((ExpressionContext)_localctx).e2 = expression(7);
						 ((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, ((ExpressionContext)_localctx).e2.expressionRet, BinaryOperator.BITWISE_OR, ((ExpressionContext)_localctx).Or.getLine()); 
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(233);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(234);
						((ExpressionContext)_localctx).AndAnd = match(AndAnd);
						setState(235);
						((ExpressionContext)_localctx).e2 = expression(6);
						 ((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, ((ExpressionContext)_localctx).e2.expressionRet, BinaryOperator.AND, ((ExpressionContext)_localctx).AndAnd.getLine()); 
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(238);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(239);
						((ExpressionContext)_localctx).OrOr = match(OrOr);
						setState(240);
						((ExpressionContext)_localctx).e2 = expression(5);
						 ((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, ((ExpressionContext)_localctx).e2.expressionRet, BinaryOperator.OR, ((ExpressionContext)_localctx).OrOr.getLine()); 
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(243);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(244);
						((ExpressionContext)_localctx).Question = match(Question);
						setState(245);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(246);
						match(Colon);
						setState(247);
						((ExpressionContext)_localctx).e3 = expression(4);
						((ExpressionContext)_localctx).expressionRet =  new ConditionalExpression(((ExpressionContext)_localctx).e1.expressionRet , ((ExpressionContext)_localctx).e2.expressionRet , ((ExpressionContext)_localctx).e3.expressionRet,((ExpressionContext)_localctx).Question.getLine());
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(250);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(251);
						((ExpressionContext)_localctx).op = assignmentOperator();
						setState(252);
						((ExpressionContext)_localctx).e2 = expression(3);
						((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet,((ExpressionContext)_localctx).e2.expressionRet,((ExpressionContext)_localctx).op.binaryOperatorRet , ((ExpressionContext)_localctx).e1.expressionRet.getLine());
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(255);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(256);
						((ExpressionContext)_localctx).LeftBracket = match(LeftBracket);
						setState(257);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(258);
						match(RightBracket);
						((ExpressionContext)_localctx).expressionRet =  new ArrayExpression(((ExpressionContext)_localctx).e1.expressionRet , ((ExpressionContext)_localctx).e2.expressionRet , ((ExpressionContext)_localctx).LeftBracket.getLine());
						}
						break;
					case 15:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(261);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");

						                  ((ExpressionContext)_localctx).expressionRet =  new FunctionCallExpression();
						                  _localctx.expressionRet.setFunction(((ExpressionContext)_localctx).e.expressionRet);
						                  _localctx.expressionRet.setLine(((ExpressionContext)_localctx).e.expressionRet.getLine());
						              
						setState(263);
						match(LeftParen);
						setState(267);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
							{
							setState(264);
							((ExpressionContext)_localctx).a = argumentExpressionList();
							_localctx.expressionRet.setArguments(((ExpressionContext)_localctx).a.expressionsRet);
							}
						}

						setState(269);
						match(RightParen);
						}
						break;
					case 16:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(270);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(271);
						((ExpressionContext)_localctx).PlusPlus = match(PlusPlus);
						((ExpressionContext)_localctx).expressionRet =  new UnaryExpression(((ExpressionContext)_localctx).e.expressionRet, UnaryOperator.INCREMENT, true , ((ExpressionContext)_localctx).PlusPlus.getLine());
						}
						break;
					case 17:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(273);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(274);
						((ExpressionContext)_localctx).MinusMinus = match(MinusMinus);
						((ExpressionContext)_localctx).expressionRet =  new UnaryExpression(((ExpressionContext)_localctx).e.expressionRet, UnaryOperator.DECREMENT, true , ((ExpressionContext)_localctx).MinusMinus.getLine());
						}
						break;
					case 18:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(276);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");

						                  ((ExpressionContext)_localctx).expressionRet =  new CommaExpression();
						                  _localctx.expressionRet.addExpression(((ExpressionContext)_localctx).e1.expressionRet);
						                  _localctx.expressionRet.setLine(((ExpressionContext)_localctx).e1.expressionRet.getLine());
						              
						setState(282); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(278);
								match(Comma);
								setState(279);
								((ExpressionContext)_localctx).e2 = expression(0);
								_localctx.expressionRet.addExpression(((ExpressionContext)_localctx).e2.expressionRet);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(284); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					}
					} 
				}
				setState(290);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrefixexpressionContext extends ParserRuleContext {
		public Expression expressionRet;
		public List<UnaryOperator> ops = new ArrayList<>();
		public PrefixOperatorContext p;
		public PostfixExpressionContext base;
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public List<PrefixOperatorContext> prefixOperator() {
			return getRuleContexts(PrefixOperatorContext.class);
		}
		public PrefixOperatorContext prefixOperator(int i) {
			return getRuleContext(PrefixOperatorContext.class,i);
		}
		public PrefixexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterPrefixexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitPrefixexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitPrefixexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixexpressionContext prefixexpression() throws RecognitionException {
		PrefixexpressionContext _localctx = new PrefixexpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_prefixexpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(291);
					((PrefixexpressionContext)_localctx).p = prefixOperator();
					 _localctx.ops.add(((PrefixexpressionContext)_localctx).p.operatorRet); 
					}
					} 
				}
				setState(298);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			{
			setState(299);
			((PrefixexpressionContext)_localctx).base = postfixExpression();
			}

			          ((PrefixexpressionContext)_localctx).expressionRet =  ((PrefixexpressionContext)_localctx).base.expressionRet;
			          for (int i = _localctx.ops.size() - 1; i >= 0; i--) {
			              UnaryExpression ue = new UnaryExpression(_localctx.expressionRet , _localctx.ops.get(i) , false , _localctx.expressionRet.getLine());
			              ((PrefixexpressionContext)_localctx).expressionRet =  ue;
			          }
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrefixOperatorContext extends ParserRuleContext {
		public UnaryOperator operatorRet;
		public TerminalNode PlusPlus() { return getToken(CPYParser.PlusPlus, 0); }
		public TerminalNode MinusMinus() { return getToken(CPYParser.MinusMinus, 0); }
		public TerminalNode Sizeof() { return getToken(CPYParser.Sizeof, 0); }
		public PrefixOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterPrefixOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitPrefixOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitPrefixOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixOperatorContext prefixOperator() throws RecognitionException {
		PrefixOperatorContext _localctx = new PrefixOperatorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_prefixOperator);
		try {
			setState(308);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PlusPlus:
				enterOuterAlt(_localctx, 1);
				{
				setState(302);
				match(PlusPlus);
				 ((PrefixOperatorContext)_localctx).operatorRet =  UnaryOperator.INCREMENT; 
				}
				break;
			case MinusMinus:
				enterOuterAlt(_localctx, 2);
				{
				setState(304);
				match(MinusMinus);
				 ((PrefixOperatorContext)_localctx).operatorRet =  UnaryOperator.DECREMENT; 
				}
				break;
			case Sizeof:
				enterOuterAlt(_localctx, 3);
				{
				setState(306);
				match(Sizeof);
				 ((PrefixOperatorContext)_localctx).operatorRet =  UnaryOperator.SIZEOF; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixExpressionContext extends ParserRuleContext {
		public Expression expressionRet;
		public PrimaryExpressionContext p;
		public UnaryOperatorContext op;
		public CastExpressionContext c;
		public Token Sizeof;
		public TypeNameContext t;
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public TerminalNode Sizeof() { return getToken(CPYParser.Sizeof, 0); }
		public TerminalNode LeftParen() { return getToken(CPYParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPYParser.RightParen, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public PostfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterPostfixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitPostfixExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitPostfixExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixExpressionContext postfixExpression() throws RecognitionException {
		PostfixExpressionContext _localctx = new PostfixExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_postfixExpression);
		try {
			setState(323);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
			case Identifier:
			case Constant:
			case StringLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(310);
				((PostfixExpressionContext)_localctx).p = primaryExpression();
				((PostfixExpressionContext)_localctx).expressionRet =  ((PostfixExpressionContext)_localctx).p.expressionRet;
				}
				break;
			case Plus:
			case Minus:
			case Star:
			case And:
			case Not:
			case Tilde:
				enterOuterAlt(_localctx, 2);
				{
				setState(313);
				((PostfixExpressionContext)_localctx).op = unaryOperator();
				setState(314);
				((PostfixExpressionContext)_localctx).c = castExpression();
				((PostfixExpressionContext)_localctx).expressionRet =  new UnaryExpression(((PostfixExpressionContext)_localctx).c.expressionRet, ((PostfixExpressionContext)_localctx).op.operatorRet, false , ((PostfixExpressionContext)_localctx).c.expressionRet.getLine());
				}
				break;
			case Sizeof:
				enterOuterAlt(_localctx, 3);
				{
				setState(317);
				((PostfixExpressionContext)_localctx).Sizeof = match(Sizeof);
				setState(318);
				match(LeftParen);
				setState(319);
				((PostfixExpressionContext)_localctx).t = typeName();
				setState(320);
				match(RightParen);
				((PostfixExpressionContext)_localctx).expressionRet =  new SizeofExpression(((PostfixExpressionContext)_localctx).t.parameterRet , ((PostfixExpressionContext)_localctx).Sizeof.getLine());
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExpressionContext extends ParserRuleContext {
		public Expression expressionRet;
		public Token Identifier;
		public Token Constant;
		public Token StringLiteral;
		public ExpressionContext expression;
		public TypeNameContext t;
		public Token LeftBrace;
		public InitializerListContext i;
		public TerminalNode Identifier() { return getToken(CPYParser.Identifier, 0); }
		public TerminalNode Constant() { return getToken(CPYParser.Constant, 0); }
		public List<TerminalNode> StringLiteral() { return getTokens(CPYParser.StringLiteral); }
		public TerminalNode StringLiteral(int i) {
			return getToken(CPYParser.StringLiteral, i);
		}
		public TerminalNode LeftParen() { return getToken(CPYParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(CPYParser.RightParen, 0); }
		public TerminalNode LeftBrace() { return getToken(CPYParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(CPYParser.RightBrace, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPYParser.Comma, 0); }
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterPrimaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitPrimaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitPrimaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_primaryExpression);
		int _la;
		try {
			int _alt;
			setState(352);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(325);
				((PrimaryExpressionContext)_localctx).Identifier = match(Identifier);
				 ((PrimaryExpressionContext)_localctx).expressionRet =  new IdExpression(((PrimaryExpressionContext)_localctx).Identifier.getText() , ((PrimaryExpressionContext)_localctx).Identifier.getLine());
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(327);
				((PrimaryExpressionContext)_localctx).Constant = match(Constant);
				 ((PrimaryExpressionContext)_localctx).expressionRet =  new ConstExpression(((PrimaryExpressionContext)_localctx).Constant.getText() , ((PrimaryExpressionContext)_localctx).Constant.getLine());
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				((PrimaryExpressionContext)_localctx).expressionRet =  new StringExpression();
				setState(332); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(330);
						((PrimaryExpressionContext)_localctx).StringLiteral = match(StringLiteral);

						        _localctx.expressionRet.addStringLiteral(((PrimaryExpressionContext)_localctx).StringLiteral.getText());
						        _localctx.expressionRet.setLine(((PrimaryExpressionContext)_localctx).StringLiteral.getLine());
						    
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(334); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(336);
				match(LeftParen);
				setState(337);
				((PrimaryExpressionContext)_localctx).expression = expression(0);
				setState(338);
				match(RightParen);
				 ((PrimaryExpressionContext)_localctx).expressionRet =  ((PrimaryExpressionContext)_localctx).expression.expressionRet; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(341);
				match(LeftParen);
				setState(342);
				((PrimaryExpressionContext)_localctx).t = typeName();
				setState(343);
				match(RightParen);
				setState(344);
				((PrimaryExpressionContext)_localctx).LeftBrace = match(LeftBrace);
				setState(345);
				((PrimaryExpressionContext)_localctx).i = initializerList();
				setState(347);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(346);
					match(Comma);
					}
				}

				setState(349);
				match(RightBrace);
				 ((PrimaryExpressionContext)_localctx).expressionRet =  new CompoundLiteralExpression(((PrimaryExpressionContext)_localctx).t.parameterRet , ((PrimaryExpressionContext)_localctx).i.initializerListRet , ((PrimaryExpressionContext)_localctx).LeftBrace.getLine());
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentExpressionListContext extends ParserRuleContext {
		public List<Expression> expressionsRet;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPYParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPYParser.Comma, i);
		}
		public ArgumentExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentExpressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterArgumentExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitArgumentExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitArgumentExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentExpressionListContext argumentExpressionList() throws RecognitionException {
		ArgumentExpressionListContext _localctx = new ArgumentExpressionListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_argumentExpressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ArgumentExpressionListContext)_localctx).expressionsRet =  new ArrayList<>(); 
			setState(355);
			((ArgumentExpressionListContext)_localctx).e1 = expression(0);
			_localctx.expressionsRet.add(((ArgumentExpressionListContext)_localctx).e1.expressionRet);
			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(357);
				match(Comma);
				setState(358);
				((ArgumentExpressionListContext)_localctx).e2 = expression(0);
				_localctx.expressionsRet.add(((ArgumentExpressionListContext)_localctx).e2.expressionRet);
				}
				}
				setState(365);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryOperatorContext extends ParserRuleContext {
		public UnaryOperator operatorRet;
		public TerminalNode And() { return getToken(CPYParser.And, 0); }
		public TerminalNode Star() { return getToken(CPYParser.Star, 0); }
		public TerminalNode Plus() { return getToken(CPYParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(CPYParser.Minus, 0); }
		public TerminalNode Tilde() { return getToken(CPYParser.Tilde, 0); }
		public TerminalNode Not() { return getToken(CPYParser.Not, 0); }
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterUnaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitUnaryOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitUnaryOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_unaryOperator);
		try {
			setState(378);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case And:
				enterOuterAlt(_localctx, 1);
				{
				setState(366);
				match(And);
				 ((UnaryOperatorContext)_localctx).operatorRet =  UnaryOperator.AND;
				}
				break;
			case Star:
				enterOuterAlt(_localctx, 2);
				{
				setState(368);
				match(Star);
				 ((UnaryOperatorContext)_localctx).operatorRet =  UnaryOperator.STAR; 
				}
				break;
			case Plus:
				enterOuterAlt(_localctx, 3);
				{
				setState(370);
				match(Plus);
				 ((UnaryOperatorContext)_localctx).operatorRet =  UnaryOperator.PLUS; 
				}
				break;
			case Minus:
				enterOuterAlt(_localctx, 4);
				{
				setState(372);
				match(Minus);
				 ((UnaryOperatorContext)_localctx).operatorRet =  UnaryOperator.MINUS; 
				}
				break;
			case Tilde:
				enterOuterAlt(_localctx, 5);
				{
				setState(374);
				match(Tilde);
				 ((UnaryOperatorContext)_localctx).operatorRet =  UnaryOperator.TILDE; 
				}
				break;
			case Not:
				enterOuterAlt(_localctx, 6);
				{
				setState(376);
				match(Not);
				 ((UnaryOperatorContext)_localctx).operatorRet =  UnaryOperator.NOT; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CastExpressionContext extends ParserRuleContext {
		public Expression expressionRet;
		public CastTypeContext c;
		public ExpressionContext e;
		public Token DigitSequence;
		public CastTypeContext castType() {
			return getRuleContext(CastTypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DigitSequence() { return getToken(CPYParser.DigitSequence, 0); }
		public CastExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterCastExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitCastExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitCastExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastExpressionContext castExpression() throws RecognitionException {
		CastExpressionContext _localctx = new CastExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_castExpression);
		try {
			setState(388);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(380);
				((CastExpressionContext)_localctx).c = castType();
				 ((CastExpressionContext)_localctx).expressionRet =  ((CastExpressionContext)_localctx).c.expressionRet; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(383);
				((CastExpressionContext)_localctx).e = expression(0);
				 ((CastExpressionContext)_localctx).expressionRet =  ((CastExpressionContext)_localctx).e.expressionRet; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(386);
				((CastExpressionContext)_localctx).DigitSequence = match(DigitSequence);
				 ((CastExpressionContext)_localctx).expressionRet =  new DigitSequenceExpression(((CastExpressionContext)_localctx).DigitSequence.getText() , ((CastExpressionContext)_localctx).DigitSequence.getLine());
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CastTypeContext extends ParserRuleContext {
		public Expression expressionRet;
		public Token LeftParen;
		public TypeNameContext t;
		public CastExpressionContext c;
		public TerminalNode LeftParen() { return getToken(CPYParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPYParser.RightParen, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public CastTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterCastType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitCastType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitCastType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastTypeContext castType() throws RecognitionException {
		CastTypeContext _localctx = new CastTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_castType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			((CastTypeContext)_localctx).LeftParen = match(LeftParen);
			setState(391);
			((CastTypeContext)_localctx).t = typeName();
			setState(392);
			match(RightParen);
			setState(393);
			((CastTypeContext)_localctx).c = castExpression();
			 ((CastTypeContext)_localctx).expressionRet =  new CastExpression(((CastTypeContext)_localctx).t.parameterRet , ((CastTypeContext)_localctx).c.expressionRet , ((CastTypeContext)_localctx).LeftParen.getLine()); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentOperatorContext extends ParserRuleContext {
		public BinaryOperator binaryOperatorRet;
		public TerminalNode Assign() { return getToken(CPYParser.Assign, 0); }
		public TerminalNode StarAssign() { return getToken(CPYParser.StarAssign, 0); }
		public TerminalNode DivAssign() { return getToken(CPYParser.DivAssign, 0); }
		public TerminalNode ModAssign() { return getToken(CPYParser.ModAssign, 0); }
		public TerminalNode PlusAssign() { return getToken(CPYParser.PlusAssign, 0); }
		public TerminalNode MinusAssign() { return getToken(CPYParser.MinusAssign, 0); }
		public TerminalNode LeftShiftAssign() { return getToken(CPYParser.LeftShiftAssign, 0); }
		public TerminalNode RightShiftAssign() { return getToken(CPYParser.RightShiftAssign, 0); }
		public TerminalNode AndAssign() { return getToken(CPYParser.AndAssign, 0); }
		public TerminalNode XorAssign() { return getToken(CPYParser.XorAssign, 0); }
		public TerminalNode OrAssign() { return getToken(CPYParser.OrAssign, 0); }
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterAssignmentOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitAssignmentOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitAssignmentOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_assignmentOperator);
		try {
			setState(418);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Assign:
				enterOuterAlt(_localctx, 1);
				{
				setState(396);
				match(Assign);
				((AssignmentOperatorContext)_localctx).binaryOperatorRet =  BinaryOperator.ASSIGN;
				}
				break;
			case StarAssign:
				enterOuterAlt(_localctx, 2);
				{
				setState(398);
				match(StarAssign);
				((AssignmentOperatorContext)_localctx).binaryOperatorRet =  BinaryOperator.MUL_ASSIGN;
				}
				break;
			case DivAssign:
				enterOuterAlt(_localctx, 3);
				{
				setState(400);
				match(DivAssign);
				((AssignmentOperatorContext)_localctx).binaryOperatorRet =  BinaryOperator.DIV_ASSIGN;
				}
				break;
			case ModAssign:
				enterOuterAlt(_localctx, 4);
				{
				setState(402);
				match(ModAssign);
				((AssignmentOperatorContext)_localctx).binaryOperatorRet =  BinaryOperator.MOD_ASSIGN;
				}
				break;
			case PlusAssign:
				enterOuterAlt(_localctx, 5);
				{
				setState(404);
				match(PlusAssign);
				((AssignmentOperatorContext)_localctx).binaryOperatorRet =  BinaryOperator.PLUS_ASSIGN;
				}
				break;
			case MinusAssign:
				enterOuterAlt(_localctx, 6);
				{
				setState(406);
				match(MinusAssign);
				((AssignmentOperatorContext)_localctx).binaryOperatorRet =  BinaryOperator.MINUS_ASSIGN;
				}
				break;
			case LeftShiftAssign:
				enterOuterAlt(_localctx, 7);
				{
				setState(408);
				match(LeftShiftAssign);
				((AssignmentOperatorContext)_localctx).binaryOperatorRet =  BinaryOperator.LEFT_SHIFT_ASSIGN;
				}
				break;
			case RightShiftAssign:
				enterOuterAlt(_localctx, 8);
				{
				setState(410);
				match(RightShiftAssign);
				((AssignmentOperatorContext)_localctx).binaryOperatorRet =  BinaryOperator.RIGHT_SHIFT_ASSIGN;
				}
				break;
			case AndAssign:
				enterOuterAlt(_localctx, 9);
				{
				setState(412);
				match(AndAssign);
				((AssignmentOperatorContext)_localctx).binaryOperatorRet =  BinaryOperator.AND_ASSIGN;
				}
				break;
			case XorAssign:
				enterOuterAlt(_localctx, 10);
				{
				setState(414);
				match(XorAssign);
				((AssignmentOperatorContext)_localctx).binaryOperatorRet =  BinaryOperator.XOR_ASSIGN;
				}
				break;
			case OrAssign:
				enterOuterAlt(_localctx, 11);
				{
				setState(416);
				match(OrAssign);
				((AssignmentOperatorContext)_localctx).binaryOperatorRet =  BinaryOperator.OR_ASSIGN;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public VarDec varDecRet;
		public DeclarationSpecifiersContext d;
		public InitDeclaratorListContext i;
		public Token Semi;
		public TerminalNode Semi() { return getToken(CPYParser.Semi, 0); }
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((DeclarationContext)_localctx).varDecRet =  new VarDec(); 
			setState(421);
			((DeclarationContext)_localctx).d = declarationSpecifiers();
			 _localctx.varDecRet.setSpecifiers(((DeclarationContext)_localctx).d.specifiersRet); 
			setState(426);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & 35184372154369L) != 0)) {
				{
				setState(423);
				((DeclarationContext)_localctx).i = initDeclaratorList();
				 _localctx.varDecRet.setInitDeclarators(((DeclarationContext)_localctx).i.initDeclaratorsRet);
				}
			}

			setState(428);
			((DeclarationContext)_localctx).Semi = match(Semi);
			_localctx.varDecRet.setLine(((DeclarationContext)_localctx).Semi.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationSpecifiersContext extends ParserRuleContext {
		public List<Specifier> specifiersRet;
		public DeclarationSpecifierContext d;
		public List<DeclarationSpecifierContext> declarationSpecifier() {
			return getRuleContexts(DeclarationSpecifierContext.class);
		}
		public DeclarationSpecifierContext declarationSpecifier(int i) {
			return getRuleContext(DeclarationSpecifierContext.class,i);
		}
		public DeclarationSpecifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationSpecifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterDeclarationSpecifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitDeclarationSpecifiers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitDeclarationSpecifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationSpecifiersContext declarationSpecifiers() throws RecognitionException {
		DeclarationSpecifiersContext _localctx = new DeclarationSpecifiersContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_declarationSpecifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			 ((DeclarationSpecifiersContext)_localctx).specifiersRet =  new ArrayList<>(); 
			setState(435); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(432);
					((DeclarationSpecifiersContext)_localctx).d = declarationSpecifier();
					 _localctx.specifiersRet.add(((DeclarationSpecifiersContext)_localctx).d.specifierRet); 
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(437); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationSpecifierContext extends ParserRuleContext {
		public Specifier specifierRet;
		public Token Typedef;
		public TypeSpecifierContext t;
		public Token Const;
		public TerminalNode Typedef() { return getToken(CPYParser.Typedef, 0); }
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TerminalNode Const() { return getToken(CPYParser.Const, 0); }
		public DeclarationSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterDeclarationSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitDeclarationSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitDeclarationSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationSpecifierContext declarationSpecifier() throws RecognitionException {
		DeclarationSpecifierContext _localctx = new DeclarationSpecifierContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_declarationSpecifier);
		try {
			setState(446);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Typedef:
				enterOuterAlt(_localctx, 1);
				{
				setState(439);
				((DeclarationSpecifierContext)_localctx).Typedef = match(Typedef);
				((DeclarationSpecifierContext)_localctx).specifierRet =  new TypedefSpecifier(((DeclarationSpecifierContext)_localctx).Typedef.getLine());
				}
				break;
			case Char:
			case Double:
			case Float:
			case Int:
			case Long:
			case Short:
			case Signed:
			case Unsigned:
			case Void:
			case Bool:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(441);
				((DeclarationSpecifierContext)_localctx).t = typeSpecifier();
				((DeclarationSpecifierContext)_localctx).specifierRet =  ((DeclarationSpecifierContext)_localctx).t.typeRet;
				}
				break;
			case Const:
				enterOuterAlt(_localctx, 3);
				{
				setState(444);
				((DeclarationSpecifierContext)_localctx).Const = match(Const);
				((DeclarationSpecifierContext)_localctx).specifierRet =  new ConstSpecifier(((DeclarationSpecifierContext)_localctx).Const.getLine());
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitDeclaratorListContext extends ParserRuleContext {
		public List<InitDeclarator> initDeclaratorsRet;
		public InitDeclaratorContext i1;
		public InitDeclaratorContext i2;
		public List<InitDeclaratorContext> initDeclarator() {
			return getRuleContexts(InitDeclaratorContext.class);
		}
		public InitDeclaratorContext initDeclarator(int i) {
			return getRuleContext(InitDeclaratorContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPYParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPYParser.Comma, i);
		}
		public InitDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterInitDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitInitDeclaratorList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitInitDeclaratorList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitDeclaratorListContext initDeclaratorList() throws RecognitionException {
		InitDeclaratorListContext _localctx = new InitDeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_initDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((InitDeclaratorListContext)_localctx).initDeclaratorsRet =  new ArrayList<>(); 
			setState(449);
			((InitDeclaratorListContext)_localctx).i1 = initDeclarator();
			_localctx.initDeclaratorsRet.add(((InitDeclaratorListContext)_localctx).i1.initDeclaratorRet);
			setState(457);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(451);
				match(Comma);
				setState(452);
				((InitDeclaratorListContext)_localctx).i2 = initDeclarator();
				_localctx.initDeclaratorsRet.add(((InitDeclaratorListContext)_localctx).i2.initDeclaratorRet);
				}
				}
				setState(459);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitDeclaratorContext extends ParserRuleContext {
		public InitDeclarator initDeclaratorRet;
		public DeclaratorContext d;
		public InitializerContext i;
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode Assign() { return getToken(CPYParser.Assign, 0); }
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public InitDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterInitDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitInitDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitInitDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitDeclaratorContext initDeclarator() throws RecognitionException {
		InitDeclaratorContext _localctx = new InitDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_initDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((InitDeclaratorContext)_localctx).initDeclaratorRet =  new InitDeclarator();
			setState(461);
			((InitDeclaratorContext)_localctx).d = declarator();

			        _localctx.initDeclaratorRet.setDeclarator(((InitDeclaratorContext)_localctx).d.declaratorRet);
			        _localctx.initDeclaratorRet.setLine(((InitDeclaratorContext)_localctx).d.declaratorRet.getLine());
			    
			setState(467);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(463);
				match(Assign);
				setState(464);
				((InitDeclaratorContext)_localctx).i = initializer();
				_localctx.initDeclaratorRet.setInitializer(((InitDeclaratorContext)_localctx).i.initializerRet);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeSpecifierContext extends ParserRuleContext {
		public Type typeRet;
		public Token Void;
		public Token Char;
		public Token Short;
		public Token Int;
		public Token Long;
		public Token Float;
		public Token Double;
		public Token Signed;
		public Token Unsigned;
		public Token Bool;
		public Token id;
		public TerminalNode Void() { return getToken(CPYParser.Void, 0); }
		public TerminalNode Char() { return getToken(CPYParser.Char, 0); }
		public TerminalNode Short() { return getToken(CPYParser.Short, 0); }
		public TerminalNode Int() { return getToken(CPYParser.Int, 0); }
		public TerminalNode Long() { return getToken(CPYParser.Long, 0); }
		public TerminalNode Float() { return getToken(CPYParser.Float, 0); }
		public TerminalNode Double() { return getToken(CPYParser.Double, 0); }
		public TerminalNode Signed() { return getToken(CPYParser.Signed, 0); }
		public TerminalNode Unsigned() { return getToken(CPYParser.Unsigned, 0); }
		public TerminalNode Bool() { return getToken(CPYParser.Bool, 0); }
		public TerminalNode Identifier() { return getToken(CPYParser.Identifier, 0); }
		public TypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitTypeSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitTypeSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeSpecifierContext typeSpecifier() throws RecognitionException {
		TypeSpecifierContext _localctx = new TypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_typeSpecifier);
		try {
			setState(491);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Void:
				enterOuterAlt(_localctx, 1);
				{
				setState(469);
				((TypeSpecifierContext)_localctx).Void = match(Void);
				((TypeSpecifierContext)_localctx).typeRet =  new VoidType(((TypeSpecifierContext)_localctx).Void.getLine());
				}
				break;
			case Char:
				enterOuterAlt(_localctx, 2);
				{
				setState(471);
				((TypeSpecifierContext)_localctx).Char = match(Char);
				((TypeSpecifierContext)_localctx).typeRet =  new CharType(((TypeSpecifierContext)_localctx).Char.getLine());
				}
				break;
			case Short:
				enterOuterAlt(_localctx, 3);
				{
				setState(473);
				((TypeSpecifierContext)_localctx).Short = match(Short);
				((TypeSpecifierContext)_localctx).typeRet =  new ShortType(((TypeSpecifierContext)_localctx).Short.getLine());
				}
				break;
			case Int:
				enterOuterAlt(_localctx, 4);
				{
				setState(475);
				((TypeSpecifierContext)_localctx).Int = match(Int);
				((TypeSpecifierContext)_localctx).typeRet =  new IntType(((TypeSpecifierContext)_localctx).Int.getLine());
				}
				break;
			case Long:
				enterOuterAlt(_localctx, 5);
				{
				setState(477);
				((TypeSpecifierContext)_localctx).Long = match(Long);
				((TypeSpecifierContext)_localctx).typeRet =  new LongType(((TypeSpecifierContext)_localctx).Long.getLine());
				}
				break;
			case Float:
				enterOuterAlt(_localctx, 6);
				{
				setState(479);
				((TypeSpecifierContext)_localctx).Float = match(Float);
				((TypeSpecifierContext)_localctx).typeRet =  new FloatType(((TypeSpecifierContext)_localctx).Float.getLine());
				}
				break;
			case Double:
				enterOuterAlt(_localctx, 7);
				{
				setState(481);
				((TypeSpecifierContext)_localctx).Double = match(Double);
				((TypeSpecifierContext)_localctx).typeRet =  new DoubleType(((TypeSpecifierContext)_localctx).Double.getLine());
				}
				break;
			case Signed:
				enterOuterAlt(_localctx, 8);
				{
				setState(483);
				((TypeSpecifierContext)_localctx).Signed = match(Signed);
				((TypeSpecifierContext)_localctx).typeRet =  new SignedType(((TypeSpecifierContext)_localctx).Signed.getLine());
				}
				break;
			case Unsigned:
				enterOuterAlt(_localctx, 9);
				{
				setState(485);
				((TypeSpecifierContext)_localctx).Unsigned = match(Unsigned);
				((TypeSpecifierContext)_localctx).typeRet =  new UnsignedType(((TypeSpecifierContext)_localctx).Unsigned.getLine());
				}
				break;
			case Bool:
				enterOuterAlt(_localctx, 10);
				{
				setState(487);
				((TypeSpecifierContext)_localctx).Bool = match(Bool);
				((TypeSpecifierContext)_localctx).typeRet =  new BoolType(((TypeSpecifierContext)_localctx).Bool.getLine());
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 11);
				{
				setState(489);
				((TypeSpecifierContext)_localctx).id = match(Identifier);
				((TypeSpecifierContext)_localctx).typeRet =  new IdType(((TypeSpecifierContext)_localctx).id.getText() , ((TypeSpecifierContext)_localctx).id.getLine());
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SpecifierQualifierListContext extends ParserRuleContext {
		public List<Specifier> specifiersRet;
		public TypeSpecifierContext t;
		public Token Const;
		public SpecifierQualifierListContext s;
		public TerminalNode Const() { return getToken(CPYParser.Const, 0); }
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public SpecifierQualifierListContext specifierQualifierList() {
			return getRuleContext(SpecifierQualifierListContext.class,0);
		}
		public SpecifierQualifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specifierQualifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterSpecifierQualifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitSpecifierQualifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitSpecifierQualifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecifierQualifierListContext specifierQualifierList() throws RecognitionException {
		SpecifierQualifierListContext _localctx = new SpecifierQualifierListContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_specifierQualifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((SpecifierQualifierListContext)_localctx).specifiersRet =  new ArrayList<>(); 
			setState(499);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Char:
			case Double:
			case Float:
			case Int:
			case Long:
			case Short:
			case Signed:
			case Unsigned:
			case Void:
			case Bool:
			case Identifier:
				{
				setState(494);
				((SpecifierQualifierListContext)_localctx).t = typeSpecifier();
				 _localctx.specifiersRet.add(((SpecifierQualifierListContext)_localctx).t.typeRet);
				}
				break;
			case Const:
				{
				setState(497);
				((SpecifierQualifierListContext)_localctx).Const = match(Const);
				_localctx.specifiersRet.add(new ConstSpecifier(((SpecifierQualifierListContext)_localctx).Const.getLine()));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(504);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5822796L) != 0) || _la==Identifier) {
				{
				setState(501);
				((SpecifierQualifierListContext)_localctx).s = specifierQualifierList();
				_localctx.specifiersRet.addAll(((SpecifierQualifierListContext)_localctx).s.specifiersRet);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaratorContext extends ParserRuleContext {
		public PointerDeclarator declaratorRet;
		public PointerContext p;
		public DirectDeclaratorContext d;
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((DeclaratorContext)_localctx).declaratorRet =  new PointerDeclarator(); 
			setState(510);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Star) {
				{
				setState(507);
				((DeclaratorContext)_localctx).p = pointer();
				 _localctx.declaratorRet.setPointers(((DeclaratorContext)_localctx).p.pointersRet); 
				}
			}

			setState(512);
			((DeclaratorContext)_localctx).d = directDeclarator(0);

			        _localctx.declaratorRet.setDeclarator(((DeclaratorContext)_localctx).d.declaratorRet);
			        _localctx.declaratorRet.setLine(((DeclaratorContext)_localctx).d.declaratorRet.getLine());
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DirectDeclaratorContext extends ParserRuleContext {
		public Declarator declaratorRet;
		public DirectDeclaratorContext b;
		public DirectDeclaratorContext d;
		public Token Identifier;
		public DeclaratorContext a;
		public ExpressionContext c;
		public ParameterListContext f;
		public IdentifierListContext g;
		public TerminalNode Identifier() { return getToken(CPYParser.Identifier, 0); }
		public TerminalNode LeftParen() { return getToken(CPYParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPYParser.RightParen, 0); }
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(CPYParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPYParser.RightBracket, 0); }
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public DirectDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterDirectDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitDirectDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitDirectDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectDeclaratorContext directDeclarator() throws RecognitionException {
		return directDeclarator(0);
	}

	private DirectDeclaratorContext directDeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DirectDeclaratorContext _localctx = new DirectDeclaratorContext(_ctx, _parentState);
		DirectDeclaratorContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_directDeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(516);
				((DirectDeclaratorContext)_localctx).Identifier = match(Identifier);
				((DirectDeclaratorContext)_localctx).declaratorRet =  new IdentifierDeclarator(((DirectDeclaratorContext)_localctx).Identifier.getText(),((DirectDeclaratorContext)_localctx).Identifier.getLine());
				}
				break;
			case LeftParen:
				{
				setState(518);
				match(LeftParen);
				setState(519);
				((DirectDeclaratorContext)_localctx).a = declarator();
				setState(520);
				match(RightParen);
				 ((DirectDeclaratorContext)_localctx).declaratorRet =  ((DirectDeclaratorContext)_localctx).a.declaratorRet; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(550);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(548);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						_localctx = new DirectDeclaratorContext(_parentctx, _parentState);
						_localctx.b = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(525);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");

						                  ((DirectDeclaratorContext)_localctx).declaratorRet =  new ArrayDeclarator();
						                  _localctx.declaratorRet.setDeclarator(((DirectDeclaratorContext)_localctx).b.declaratorRet);
						                  _localctx.declaratorRet.setLine(((DirectDeclaratorContext)_localctx).b.declaratorRet.getLine());
						              
						setState(527);
						match(LeftBracket);
						setState(531);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
							{
							setState(528);
							((DirectDeclaratorContext)_localctx).c = expression(0);
							 _localctx.declaratorRet.setExpression(((DirectDeclaratorContext)_localctx).c.expressionRet); 
							}
						}

						setState(533);
						match(RightBracket);
						}
						break;
					case 2:
						{
						_localctx = new DirectDeclaratorContext(_parentctx, _parentState);
						_localctx.d = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(534);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");

						                  ((DirectDeclaratorContext)_localctx).declaratorRet =  new FunctionDeclarator();
						                  _localctx.declaratorRet.setDeclarator(((DirectDeclaratorContext)_localctx).d.declaratorRet);
						                  _localctx.declaratorRet.setLine(((DirectDeclaratorContext)_localctx).d.declaratorRet.getLine());
						              
						setState(536);
						match(LeftParen);
						setState(545);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
						case 1:
							{
							setState(537);
							((DirectDeclaratorContext)_localctx).f = parameterList();
							 _localctx.declaratorRet.setParameters(((DirectDeclaratorContext)_localctx).f.parametersRet); 
							}
							break;
						case 2:
							{
							setState(543);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==Identifier) {
								{
								setState(540);
								((DirectDeclaratorContext)_localctx).g = identifierList();
								 _localctx.declaratorRet.setIdentifiers(((DirectDeclaratorContext)_localctx).g.identifiersRet); 
								}
							}

							}
							break;
						}
						setState(547);
						match(RightParen);
						}
						break;
					}
					} 
				}
				setState(552);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PointerContext extends ParserRuleContext {
		public List<Pointer> pointersRet;
		public Token Star;
		public Token Const;
		public List<TerminalNode> Star() { return getTokens(CPYParser.Star); }
		public TerminalNode Star(int i) {
			return getToken(CPYParser.Star, i);
		}
		public List<TerminalNode> Const() { return getTokens(CPYParser.Const); }
		public TerminalNode Const(int i) {
			return getToken(CPYParser.Const, i);
		}
		public PointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterPointer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitPointer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitPointer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointerContext pointer() throws RecognitionException {
		PointerContext _localctx = new PointerContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_pointer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((PointerContext)_localctx).pointersRet =  new ArrayList<Pointer>(); 
			setState(561); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				{
				setState(554);
				((PointerContext)_localctx).Star = match(Star);
				 _localctx.pointersRet.add(new StarPointer(((PointerContext)_localctx).Star.getLine())); 
				}
				setState(559);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Const) {
					{
					setState(557);
					((PointerContext)_localctx).Const = match(Const);
					 _localctx.pointersRet.add(new ConstSpecifier(((PointerContext)_localctx).Const.getLine())); 
					}
				}

				}
				}
				setState(563); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Star );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListContext extends ParserRuleContext {
		public List<ParamDec> parametersRet;
		public ParameterDeclarationContext a;
		public ParameterDeclarationContext b;
		public List<ParameterDeclarationContext> parameterDeclaration() {
			return getRuleContexts(ParameterDeclarationContext.class);
		}
		public ParameterDeclarationContext parameterDeclaration(int i) {
			return getRuleContext(ParameterDeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPYParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPYParser.Comma, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ParameterListContext)_localctx).parametersRet =  new ArrayList<ParamDec>(); 
			setState(566);
			((ParameterListContext)_localctx).a = parameterDeclaration();
			 _localctx.parametersRet.add(((ParameterListContext)_localctx).a.parameterRet); 
			setState(574);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(568);
				match(Comma);
				setState(569);
				((ParameterListContext)_localctx).b = parameterDeclaration();
				 _localctx.parametersRet.add(((ParameterListContext)_localctx).b.parameterRet); 
				}
				}
				setState(576);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterDeclarationContext extends ParserRuleContext {
		public ParamDec parameterRet;
		public DeclarationSpecifiersContext a;
		public DeclaratorContext b;
		public AbstractDeclaratorContext c;
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public ParameterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterParameterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitParameterDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitParameterDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterDeclarationContext parameterDeclaration() throws RecognitionException {
		ParameterDeclarationContext _localctx = new ParameterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_parameterDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(577);
			((ParameterDeclarationContext)_localctx).a = declarationSpecifiers();

			        ((ParameterDeclarationContext)_localctx).parameterRet =  new ParamDec();
			        _localctx.parameterRet.setSpecifiers(((ParameterDeclarationContext)_localctx).a.specifiersRet);
			      
			setState(587);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				{
				setState(579);
				((ParameterDeclarationContext)_localctx).b = declarator();

				        _localctx.parameterRet.setDeclarator(((ParameterDeclarationContext)_localctx).b.declaratorRet);
				        _localctx.parameterRet.setLine(((ParameterDeclarationContext)_localctx).b.declaratorRet.getLine());
				      
				}
				}
				break;
			case 2:
				{
				setState(585);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 549797756928L) != 0)) {
					{
					setState(582);
					((ParameterDeclarationContext)_localctx).c = abstractDeclarator();
					 _localctx.parameterRet.setDeclarator(((ParameterDeclarationContext)_localctx).c.declaratorRet); 
					}
				}

				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierListContext extends ParserRuleContext {
		public List<String> identifiersRet;
		public Token Identifier;
		public List<TerminalNode> Identifier() { return getTokens(CPYParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(CPYParser.Identifier, i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPYParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPYParser.Comma, i);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterIdentifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitIdentifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitIdentifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_identifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((IdentifierListContext)_localctx).identifiersRet =  new ArrayList<String>(); 
			setState(590);
			((IdentifierListContext)_localctx).Identifier = match(Identifier);
			 _localctx.identifiersRet.add((((IdentifierListContext)_localctx).Identifier!=null?((IdentifierListContext)_localctx).Identifier.getText():null)); 
			setState(597);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(592);
				match(Comma);
				setState(593);
				((IdentifierListContext)_localctx).Identifier = match(Identifier);
				 _localctx.identifiersRet.add((((IdentifierListContext)_localctx).Identifier!=null?((IdentifierListContext)_localctx).Identifier.getText():null)); 
				}
				}
				setState(599);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeNameContext extends ParserRuleContext {
		public ParamDec parameterRet;
		public SpecifierQualifierListContext s;
		public AbstractDeclaratorContext a;
		public SpecifierQualifierListContext specifierQualifierList() {
			return getRuleContext(SpecifierQualifierListContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_typeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(600);
			((TypeNameContext)_localctx).s = specifierQualifierList();

			        ((TypeNameContext)_localctx).parameterRet =  new ParamDec();
			        _localctx.parameterRet.setSpecifiers(((TypeNameContext)_localctx).s.specifiersRet);
			    
			setState(605);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 549797756928L) != 0)) {
				{
				setState(602);
				((TypeNameContext)_localctx).a = abstractDeclarator();
				_localctx.parameterRet.setDeclarator(((TypeNameContext)_localctx).a.declaratorRet);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AbstractDeclaratorContext extends ParserRuleContext {
		public Declarator declaratorRet;
		public PointerContext p;
		public DirectAbstractDeclaratorContext d;
		public DirectAbstractDeclaratorContext directAbstractDeclarator() {
			return getRuleContext(DirectAbstractDeclaratorContext.class,0);
		}
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public AbstractDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterAbstractDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitAbstractDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitAbstractDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbstractDeclaratorContext abstractDeclarator() throws RecognitionException {
		AbstractDeclaratorContext _localctx = new AbstractDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_abstractDeclarator);
		int _la;
		try {
			setState(619);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				 ((AbstractDeclaratorContext)_localctx).declaratorRet =  new PointerDeclarator(); 
				setState(611);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Star) {
					{
					setState(608);
					((AbstractDeclaratorContext)_localctx).p = pointer();
					 _localctx.declaratorRet.setPointers(((AbstractDeclaratorContext)_localctx).p.pointersRet); 
					}
				}

				setState(613);
				((AbstractDeclaratorContext)_localctx).d = directAbstractDeclarator(0);

				        _localctx.declaratorRet.setDeclarator(((AbstractDeclaratorContext)_localctx).d.declaratorRet);
				        _localctx.declaratorRet.setLine(((AbstractDeclaratorContext)_localctx).d.declaratorRet.getLine());
				      
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(616);
				((AbstractDeclaratorContext)_localctx).p = pointer();

				         ((AbstractDeclaratorContext)_localctx).declaratorRet =  new PointerDeclarator();
				         _localctx.declaratorRet.setPointers(((AbstractDeclaratorContext)_localctx).p.pointersRet);
				         //set line if it's needed
				      
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DirectAbstractDeclaratorContext extends ParserRuleContext {
		public Declarator declaratorRet;
		public DirectAbstractDeclaratorContext d;
		public DirectAbstractDeclaratorContext f;
		public ExpressionContext a;
		public Token RightBracket;
		public AbstractDeclaratorContext b;
		public ParameterListContext c;
		public Token RightParen;
		public ExpressionContext e;
		public ParameterListContext g;
		public TerminalNode LeftBracket() { return getToken(CPYParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPYParser.RightBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(CPYParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPYParser.RightParen, 0); }
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public DirectAbstractDeclaratorContext directAbstractDeclarator() {
			return getRuleContext(DirectAbstractDeclaratorContext.class,0);
		}
		public DirectAbstractDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directAbstractDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterDirectAbstractDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitDirectAbstractDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitDirectAbstractDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectAbstractDeclaratorContext directAbstractDeclarator() throws RecognitionException {
		return directAbstractDeclarator(0);
	}

	private DirectAbstractDeclaratorContext directAbstractDeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DirectAbstractDeclaratorContext _localctx = new DirectAbstractDeclaratorContext(_ctx, _parentState);
		DirectAbstractDeclaratorContext _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_directAbstractDeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(644);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBracket:
				{
				 ((DirectAbstractDeclaratorContext)_localctx).declaratorRet =  new ArrayDeclarator(); 
				setState(623);
				match(LeftBracket);
				setState(627);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
					{
					setState(624);
					((DirectAbstractDeclaratorContext)_localctx).a = expression(0);
					_localctx.declaratorRet.setExpression(((DirectAbstractDeclaratorContext)_localctx).a.expressionRet); _localctx.declaratorRet.setLine(((DirectAbstractDeclaratorContext)_localctx).a.expressionRet.getLine());
					}
				}

				setState(629);
				((DirectAbstractDeclaratorContext)_localctx).RightBracket = match(RightBracket);
				}
				break;
			case LeftParen:
				{
				 ((DirectAbstractDeclaratorContext)_localctx).declaratorRet =  new FunctionDeclarator(); 
				setState(631);
				match(LeftParen);
				setState(640);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LeftParen:
				case LeftBracket:
				case Star:
					{
					{
					setState(632);
					((DirectAbstractDeclaratorContext)_localctx).b = abstractDeclarator();
					_localctx.declaratorRet.setDeclarator(((DirectAbstractDeclaratorContext)_localctx).b.declaratorRet) ;
					}
					}
					break;
				case Char:
				case Const:
				case Double:
				case Float:
				case Int:
				case Long:
				case Short:
				case Signed:
				case Typedef:
				case Unsigned:
				case Void:
				case Bool:
				case RightParen:
				case Identifier:
					{
					setState(638);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6084940L) != 0) || _la==Identifier) {
						{
						setState(635);
						((DirectAbstractDeclaratorContext)_localctx).c = parameterList();
						_localctx.declaratorRet.setParameters(((DirectAbstractDeclaratorContext)_localctx).c.parametersRet);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(642);
				((DirectAbstractDeclaratorContext)_localctx).RightParen = match(RightParen);
				_localctx.declaratorRet.setLine(((DirectAbstractDeclaratorContext)_localctx).RightParen.getLine());
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(668);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(666);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
					case 1:
						{
						_localctx = new DirectAbstractDeclaratorContext(_parentctx, _parentState);
						_localctx.d = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directAbstractDeclarator);
						setState(646);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");

						                  ((DirectAbstractDeclaratorContext)_localctx).declaratorRet =  new ArrayDeclarator();
						                  _localctx.declaratorRet.setDeclarator(((DirectAbstractDeclaratorContext)_localctx).d.declaratorRet);
						              
						setState(648);
						match(LeftBracket);
						setState(652);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
							{
							setState(649);
							((DirectAbstractDeclaratorContext)_localctx).e = expression(0);
							_localctx.declaratorRet.setExpression(((DirectAbstractDeclaratorContext)_localctx).e.expressionRet);
							}
						}

						setState(654);
						((DirectAbstractDeclaratorContext)_localctx).RightBracket = match(RightBracket);
						_localctx.declaratorRet.setLine(((DirectAbstractDeclaratorContext)_localctx).RightBracket.getLine());
						}
						break;
					case 2:
						{
						_localctx = new DirectAbstractDeclaratorContext(_parentctx, _parentState);
						_localctx.f = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directAbstractDeclarator);
						setState(656);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");

						                  ((DirectAbstractDeclaratorContext)_localctx).declaratorRet =  new FunctionDeclarator();
						                  _localctx.declaratorRet.setDeclarator(((DirectAbstractDeclaratorContext)_localctx).f.declaratorRet);
						              
						setState(658);
						match(LeftParen);
						setState(662);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6084940L) != 0) || _la==Identifier) {
							{
							setState(659);
							((DirectAbstractDeclaratorContext)_localctx).g = parameterList();
							_localctx.declaratorRet.setParameters(((DirectAbstractDeclaratorContext)_localctx).g.parametersRet);
							}
						}

						setState(664);
						((DirectAbstractDeclaratorContext)_localctx).RightParen = match(RightParen);
						_localctx.declaratorRet.setLine(((DirectAbstractDeclaratorContext)_localctx).RightParen.getLine());
						}
						break;
					}
					} 
				}
				setState(670);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitializerContext extends ParserRuleContext {
		public Initializer initializerRet;
		public ExpressionContext e;
		public InitializerListContext i;
		public Token RightBrace;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LeftBrace() { return getToken(CPYParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(CPYParser.RightBrace, 0); }
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(CPYParser.Comma, 0); }
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_initializer);
		int _la;
		try {
			setState(682);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Sizeof:
			case LeftParen:
			case Plus:
			case PlusPlus:
			case Minus:
			case MinusMinus:
			case Star:
			case And:
			case Not:
			case Tilde:
			case Identifier:
			case Constant:
			case StringLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(671);
				((InitializerContext)_localctx).e = expression(0);

				        ((InitializerContext)_localctx).initializerRet =  new Initializer();
				        _localctx.initializerRet.setExpression(((InitializerContext)_localctx).e.expressionRet);
				        _localctx.initializerRet.setLine(((InitializerContext)_localctx).e.expressionRet.getLine());
				    
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(674);
				match(LeftBrace);
				setState(675);
				((InitializerContext)_localctx).i = initializerList();
				setState(677);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(676);
					match(Comma);
					}
				}

				setState(679);
				((InitializerContext)_localctx).RightBrace = match(RightBrace);

				        ((InitializerContext)_localctx).initializerRet =  new Initializer();
				        _localctx.initializerRet.setInitializerList(((InitializerContext)_localctx).i.initializerListRet);
				        _localctx.initializerRet.setLine(((InitializerContext)_localctx).RightBrace.getLine());
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitializerListContext extends ParserRuleContext {
		public List<InitializerEntry> initializerListRet;
		public InitializerEntryContext first;
		public InitializerEntryContext next;
		public List<InitializerEntryContext> initializerEntry() {
			return getRuleContexts(InitializerEntryContext.class);
		}
		public InitializerEntryContext initializerEntry(int i) {
			return getRuleContext(InitializerEntryContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(CPYParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(CPYParser.Comma, i);
		}
		public InitializerListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializerList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterInitializerList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitInitializerList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitInitializerList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerListContext initializerList() throws RecognitionException {
		InitializerListContext _localctx = new InitializerListContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_initializerList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			 ((InitializerListContext)_localctx).initializerListRet =  new ArrayList<>(); 
			setState(685);
			((InitializerListContext)_localctx).first = initializerEntry();
			 _localctx.initializerListRet.add(((InitializerListContext)_localctx).first.entryRet); 
			setState(693);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(687);
					match(Comma);
					setState(688);
					((InitializerListContext)_localctx).next = initializerEntry();
					 _localctx.initializerListRet.add(((InitializerListContext)_localctx).next.entryRet); 
					}
					} 
				}
				setState(695);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitializerEntryContext extends ParserRuleContext {
		public InitializerEntry entryRet;
		public DesignationContext d;
		public InitializerContext i;
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public DesignationContext designation() {
			return getRuleContext(DesignationContext.class,0);
		}
		public InitializerEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializerEntry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterInitializerEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitInitializerEntry(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitInitializerEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerEntryContext initializerEntry() throws RecognitionException {
		InitializerEntryContext _localctx = new InitializerEntryContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_initializerEntry);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((InitializerEntryContext)_localctx).entryRet =  new InitializerEntry();
			setState(700);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftBracket || _la==Dot) {
				{
				setState(697);
				((InitializerEntryContext)_localctx).d = designation();
				_localctx.entryRet.setDesignators(((InitializerEntryContext)_localctx).d.designatorsRet);
				}
			}

			setState(702);
			((InitializerEntryContext)_localctx).i = initializer();
			_localctx.entryRet.setInitializer(((InitializerEntryContext)_localctx).i.initializerRet);
			_localctx.entryRet.setLine(((InitializerEntryContext)_localctx).i.initializerRet.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DesignationContext extends ParserRuleContext {
		public List<Designator> designatorsRet;
		public DesignatorContext d;
		public TerminalNode Assign() { return getToken(CPYParser.Assign, 0); }
		public List<DesignatorContext> designator() {
			return getRuleContexts(DesignatorContext.class);
		}
		public DesignatorContext designator(int i) {
			return getRuleContext(DesignatorContext.class,i);
		}
		public DesignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterDesignation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitDesignation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitDesignation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesignationContext designation() throws RecognitionException {
		DesignationContext _localctx = new DesignationContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_designation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((DesignationContext)_localctx).designatorsRet =  new ArrayList<>(); 
			setState(710); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(707);
				((DesignationContext)_localctx).d = designator();
				 _localctx.designatorsRet.add(((DesignationContext)_localctx).d.designatorRet); 
				}
				}
				setState(712); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LeftBracket || _la==Dot );
			setState(714);
			match(Assign);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DesignatorContext extends ParserRuleContext {
		public Designator designatorRet;
		public ExpressionContext e;
		public Token RightBracket;
		public Token Identifier;
		public TerminalNode LeftBracket() { return getToken(CPYParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(CPYParser.RightBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Dot() { return getToken(CPYParser.Dot, 0); }
		public TerminalNode Identifier() { return getToken(CPYParser.Identifier, 0); }
		public DesignatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterDesignator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitDesignator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitDesignator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesignatorContext designator() throws RecognitionException {
		DesignatorContext _localctx = new DesignatorContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_designator);
		try {
			setState(724);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBracket:
				enterOuterAlt(_localctx, 1);
				{
				setState(716);
				match(LeftBracket);
				setState(717);
				((DesignatorContext)_localctx).e = expression(0);
				setState(718);
				((DesignatorContext)_localctx).RightBracket = match(RightBracket);
				 ((DesignatorContext)_localctx).designatorRet =  new ArrayDesignator(((DesignatorContext)_localctx).e.expressionRet , ((DesignatorContext)_localctx).RightBracket.getLine());
				}
				break;
			case Dot:
				enterOuterAlt(_localctx, 2);
				{
				setState(721);
				match(Dot);
				setState(722);
				((DesignatorContext)_localctx).Identifier = match(Identifier);
				((DesignatorContext)_localctx).designatorRet =  new FieldDesignator(((DesignatorContext)_localctx).Identifier.getText() , ((DesignatorContext)_localctx).Identifier.getLine());
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Statement statementRet;
		public CompoundStatementContext c;
		public ExpressionStatementContext e;
		public SelectionStatementContext s;
		public IterationStatementContext i;
		public JumpStatementContext j;
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public SelectionStatementContext selectionStatement() {
			return getRuleContext(SelectionStatementContext.class,0);
		}
		public IterationStatementContext iterationStatement() {
			return getRuleContext(IterationStatementContext.class,0);
		}
		public JumpStatementContext jumpStatement() {
			return getRuleContext(JumpStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_statement);
		try {
			setState(741);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBrace:
				enterOuterAlt(_localctx, 1);
				{
				setState(726);
				((StatementContext)_localctx).c = compoundStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).c.compoundStatementRet; 
				}
				break;
			case Sizeof:
			case LeftParen:
			case Plus:
			case PlusPlus:
			case Minus:
			case MinusMinus:
			case Star:
			case And:
			case Not:
			case Tilde:
			case Semi:
			case Identifier:
			case Constant:
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(729);
				((StatementContext)_localctx).e = expressionStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).e.statementRet; 
				}
				break;
			case If:
				enterOuterAlt(_localctx, 3);
				{
				setState(732);
				((StatementContext)_localctx).s = selectionStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).s.statementRet; 
				}
				break;
			case Do:
			case For:
			case While:
				enterOuterAlt(_localctx, 4);
				{
				setState(735);
				((StatementContext)_localctx).i = iterationStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).i.statementRet; 
				}
				break;
			case Break:
			case Continue:
			case Return:
				enterOuterAlt(_localctx, 5);
				{
				setState(738);
				((StatementContext)_localctx).j = jumpStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).j.statementRet; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompoundStatementContext extends ParserRuleContext {
		public CompoundStatement compoundStatementRet;
		public Token LeftBrace;
		public BlockItemContext b;
		public TerminalNode LeftBrace() { return getToken(CPYParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(CPYParser.RightBrace, 0); }
		public List<BlockItemContext> blockItem() {
			return getRuleContexts(BlockItemContext.class);
		}
		public BlockItemContext blockItem(int i) {
			return getRuleContext(BlockItemContext.class,i);
		}
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterCompoundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitCompoundStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitCompoundStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((CompoundStatementContext)_localctx).compoundStatementRet =  new CompoundStatement(); 
			setState(744);
			((CompoundStatementContext)_localctx).LeftBrace = match(LeftBrace);
			setState(752);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2679475628015486L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 11L) != 0)) {
				{
				setState(748); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(745);
					((CompoundStatementContext)_localctx).b = blockItem();

					        if (((CompoundStatementContext)_localctx).b.varDecRet != null) {
					            _localctx.compoundStatementRet.addVarDec(((CompoundStatementContext)_localctx).b.varDecRet);
					        }
					        else if (((CompoundStatementContext)_localctx).b.statementRet != null) {
					            _localctx.compoundStatementRet.addStatement(((CompoundStatementContext)_localctx).b.statementRet);
					        }
					    
					}
					}
					setState(750); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2679475628015486L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 11L) != 0) );
				}
			}

			setState(754);
			match(RightBrace);
			  _localctx.compoundStatementRet.setLine(((CompoundStatementContext)_localctx).LeftBrace.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockItemContext extends ParserRuleContext {
		public Statement statementRet;
		public VarDec varDecRet;
		public StatementContext s;
		public DeclarationContext d;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public BlockItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterBlockItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitBlockItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitBlockItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockItemContext blockItem() throws RecognitionException {
		BlockItemContext _localctx = new BlockItemContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_blockItem);
		try {
			setState(763);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(757);
				((BlockItemContext)_localctx).s = statement();
				((BlockItemContext)_localctx).statementRet =  ((BlockItemContext)_localctx).s.statementRet;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(760);
				((BlockItemContext)_localctx).d = declaration();
				((BlockItemContext)_localctx).varDecRet =  ((BlockItemContext)_localctx).d.varDecRet;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionStatement statementRet;
		public ExpressionContext e;
		public Token Semi;
		public TerminalNode Semi() { return getToken(CPYParser.Semi, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_expressionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ExpressionStatementContext)_localctx).statementRet =  new ExpressionStatement();
			setState(769);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
				{
				setState(766);
				((ExpressionStatementContext)_localctx).e = expression(0);
				_localctx.statementRet.setExpression(((ExpressionStatementContext)_localctx).e.expressionRet);
				}
			}

			setState(771);
			((ExpressionStatementContext)_localctx).Semi = match(Semi);
			_localctx.statementRet.setLine(((ExpressionStatementContext)_localctx).Semi.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectionStatementContext extends ParserRuleContext {
		public IfStatement statementRet;
		public Token If;
		public ExpressionContext e;
		public StatementContext s1;
		public StatementContext s2;
		public TerminalNode If() { return getToken(CPYParser.If, 0); }
		public TerminalNode LeftParen() { return getToken(CPYParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPYParser.RightParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(CPYParser.Else, 0); }
		public SelectionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterSelectionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitSelectionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitSelectionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionStatementContext selectionStatement() throws RecognitionException {
		SelectionStatementContext _localctx = new SelectionStatementContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_selectionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((SelectionStatementContext)_localctx).statementRet =  new IfStatement();
			setState(775);
			((SelectionStatementContext)_localctx).If = match(If);
			setState(776);
			match(LeftParen);
			setState(777);
			((SelectionStatementContext)_localctx).e = expression(0);
			_localctx.statementRet.setCondition(((SelectionStatementContext)_localctx).e.expressionRet);
			setState(779);
			match(RightParen);
			setState(780);
			((SelectionStatementContext)_localctx).s1 = statement();
			_localctx.statementRet.setThenStatement(((SelectionStatementContext)_localctx).s1.statementRet);
			setState(786);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				{
				setState(782);
				match(Else);
				setState(783);
				((SelectionStatementContext)_localctx).s2 = statement();
				_localctx.statementRet.setElseStatement(((SelectionStatementContext)_localctx).s2.statementRet);
				}
				break;
			}
			_localctx.statementRet.setLine(((SelectionStatementContext)_localctx).If.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IterationStatementContext extends ParserRuleContext {
		public Statement statementRet;
		public Token While;
		public ExpressionContext e;
		public StatementContext s;
		public Token Do;
		public Token For;
		public ForConditionContext f;
		public TerminalNode While() { return getToken(CPYParser.While, 0); }
		public TerminalNode LeftParen() { return getToken(CPYParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(CPYParser.RightParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Do() { return getToken(CPYParser.Do, 0); }
		public TerminalNode Semi() { return getToken(CPYParser.Semi, 0); }
		public TerminalNode For() { return getToken(CPYParser.For, 0); }
		public ForConditionContext forCondition() {
			return getRuleContext(ForConditionContext.class,0);
		}
		public IterationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterIterationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitIterationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitIterationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterationStatementContext iterationStatement() throws RecognitionException {
		IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_iterationStatement);
		try {
			setState(813);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case While:
				enterOuterAlt(_localctx, 1);
				{
				setState(790);
				((IterationStatementContext)_localctx).While = match(While);
				setState(791);
				match(LeftParen);
				setState(792);
				((IterationStatementContext)_localctx).e = expression(0);
				setState(793);
				match(RightParen);
				setState(794);
				((IterationStatementContext)_localctx).s = statement();
				((IterationStatementContext)_localctx).statementRet =  new WhileStatement(((IterationStatementContext)_localctx).e.expressionRet , ((IterationStatementContext)_localctx).s.statementRet , ((IterationStatementContext)_localctx).While.getLine());
				}
				break;
			case Do:
				enterOuterAlt(_localctx, 2);
				{
				setState(797);
				((IterationStatementContext)_localctx).Do = match(Do);
				setState(798);
				((IterationStatementContext)_localctx).s = statement();
				setState(799);
				match(While);
				setState(800);
				match(LeftParen);
				setState(801);
				((IterationStatementContext)_localctx).e = expression(0);
				setState(802);
				match(RightParen);
				setState(803);
				match(Semi);
				((IterationStatementContext)_localctx).statementRet =  new DoWhileStatement(((IterationStatementContext)_localctx).e.expressionRet , ((IterationStatementContext)_localctx).s.statementRet , ((IterationStatementContext)_localctx).Do.getLine());
				}
				break;
			case For:
				enterOuterAlt(_localctx, 3);
				{
				setState(806);
				((IterationStatementContext)_localctx).For = match(For);
				setState(807);
				match(LeftParen);
				setState(808);
				((IterationStatementContext)_localctx).f = forCondition();
				setState(809);
				match(RightParen);
				setState(810);
				((IterationStatementContext)_localctx).s = statement();
				((IterationStatementContext)_localctx).statementRet =  new ForStatement(((IterationStatementContext)_localctx).f.forConditionRet , ((IterationStatementContext)_localctx).s.statementRet , ((IterationStatementContext)_localctx).For.getLine());
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForConditionContext extends ParserRuleContext {
		public ForCondStatement forConditionRet;
		public ForDeclarationContext f;
		public ExpressionContext e;
		public Token Semi;
		public ArgumentExpressionListContext a1;
		public ArgumentExpressionListContext a2;
		public List<TerminalNode> Semi() { return getTokens(CPYParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(CPYParser.Semi, i);
		}
		public ForDeclarationContext forDeclaration() {
			return getRuleContext(ForDeclarationContext.class,0);
		}
		public List<ArgumentExpressionListContext> argumentExpressionList() {
			return getRuleContexts(ArgumentExpressionListContext.class);
		}
		public ArgumentExpressionListContext argumentExpressionList(int i) {
			return getRuleContext(ArgumentExpressionListContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterForCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitForCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitForCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForConditionContext forCondition() throws RecognitionException {
		ForConditionContext _localctx = new ForConditionContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_forCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ForConditionContext)_localctx).forConditionRet =  new ForCondStatement();
			setState(824);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				{
				setState(816);
				((ForConditionContext)_localctx).f = forDeclaration();
				_localctx.forConditionRet.setInitDeclaration(((ForConditionContext)_localctx).f.varDecRet);
				}
				break;
			case 2:
				{
				setState(822);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
					{
					setState(819);
					((ForConditionContext)_localctx).e = expression(0);
					 _localctx.forConditionRet.setInitExpression(((ForConditionContext)_localctx).e.expressionRet);
					}
				}

				}
				break;
			}
			setState(826);
			((ForConditionContext)_localctx).Semi = match(Semi);
			setState(830);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
				{
				setState(827);
				((ForConditionContext)_localctx).a1 = argumentExpressionList();
				_localctx.forConditionRet.setConditions(((ForConditionContext)_localctx).a1.expressionsRet);
				}
			}

			setState(832);
			((ForConditionContext)_localctx).Semi = match(Semi);
			setState(836);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
				{
				setState(833);
				((ForConditionContext)_localctx).a2 = argumentExpressionList();
				_localctx.forConditionRet.setUpdateExpressions(((ForConditionContext)_localctx).a2.expressionsRet);
				}
			}

			_localctx.forConditionRet.setLine(((ForConditionContext)_localctx).Semi.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForDeclarationContext extends ParserRuleContext {
		public VarDec varDecRet;
		public DeclarationSpecifiersContext d;
		public InitDeclaratorListContext i;
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public ForDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterForDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitForDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitForDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForDeclarationContext forDeclaration() throws RecognitionException {
		ForDeclarationContext _localctx = new ForDeclarationContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_forDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ForDeclarationContext)_localctx).varDecRet =  new VarDec(); 
			setState(841);
			((ForDeclarationContext)_localctx).d = declarationSpecifiers();
			 _localctx.varDecRet.setSpecifiers(((ForDeclarationContext)_localctx).d.specifiersRet);
			setState(846);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & 35184372154369L) != 0)) {
				{
				setState(843);
				((ForDeclarationContext)_localctx).i = initDeclaratorList();
				 _localctx.varDecRet.setInitDeclarators(((ForDeclarationContext)_localctx).i.initDeclaratorsRet);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JumpStatementContext extends ParserRuleContext {
		public Statement statementRet;
		public ExpressionContext e;
		public Token Semi;
		public TerminalNode Semi() { return getToken(CPYParser.Semi, 0); }
		public TerminalNode Continue() { return getToken(CPYParser.Continue, 0); }
		public TerminalNode Break() { return getToken(CPYParser.Break, 0); }
		public TerminalNode Return() { return getToken(CPYParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public JumpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).enterJumpStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CPYListener ) ((CPYListener)listener).exitJumpStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CPYVisitor ) return ((CPYVisitor<? extends T>)visitor).visitJumpStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_jumpStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(859);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Continue:
				{
				setState(848);
				match(Continue);
				((JumpStatementContext)_localctx).statementRet =  new ContinueStatement();
				}
				break;
			case Break:
				{
				setState(850);
				match(Break);
				((JumpStatementContext)_localctx).statementRet =  new BreakStatement();
				}
				break;
			case Return:
				{
				setState(852);
				match(Return);
				((JumpStatementContext)_localctx).statementRet =  new ReturnStatement();
				setState(857);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
					{
					setState(854);
					((JumpStatementContext)_localctx).e = expression(0);
					((JumpStatementContext)_localctx).statementRet =  new ReturnStatement(((JumpStatementContext)_localctx).e.expressionRet);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(861);
			((JumpStatementContext)_localctx).Semi = match(Semi);
			_localctx.statementRet.setLine(((JumpStatementContext)_localctx).Semi.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 23:
			return directDeclarator_sempred((DirectDeclaratorContext)_localctx, predIndex);
		case 30:
			return directAbstractDeclarator_sempred((DirectAbstractDeclaratorContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 7);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 4);
		case 11:
			return precpred(_ctx, 3);
		case 12:
			return precpred(_ctx, 2);
		case 13:
			return precpred(_ctx, 20);
		case 14:
			return precpred(_ctx, 19);
		case 15:
			return precpred(_ctx, 18);
		case 16:
			return precpred(_ctx, 17);
		case 17:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean directDeclarator_sempred(DirectDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 18:
			return precpred(_ctx, 2);
		case 19:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean directAbstractDeclarator_sempred(DirectAbstractDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 20:
			return precpred(_ctx, 2);
		case 21:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001M\u0361\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0003\u0000^\b\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u0001f\b"+
		"\u0001\u000b\u0001\f\u0001g\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002r\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003x\b"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003\u007f\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004\u0089\b\u0004\u000b"+
		"\u0004\f\u0004\u008a\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005\u0097\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00a1\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00ac\b\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005\u00b7\b\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00c6"+
		"\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00d1\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u010c\b\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004"+
		"\u0005\u011b\b\u0005\u000b\u0005\f\u0005\u011c\u0005\u0005\u011f\b\u0005"+
		"\n\u0005\f\u0005\u0122\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006\u0127\b\u0006\n\u0006\f\u0006\u012a\t\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u0135\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\b\u0144\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0004\t\u014d\b\t\u000b\t\f\t\u014e\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u015c"+
		"\b\t\u0001\t\u0001\t\u0001\t\u0003\t\u0161\b\t\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u016a\b\n\n\n\f\n\u016d\t\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u017b\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u0185\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u01a3\b\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u01ab\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0004\u0010\u01b4\b\u0010\u000b\u0010"+
		"\f\u0010\u01b5\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0003\u0011\u01bf\b\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012"+
		"\u01c8\b\u0012\n\u0012\f\u0012\u01cb\t\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u01d4"+
		"\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u01ec"+
		"\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0003\u0015\u01f4\b\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003"+
		"\u0015\u01f9\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003"+
		"\u0016\u01ff\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0003\u0017\u020c\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0214\b\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0220\b\u0017\u0003\u0017\u0222"+
		"\b\u0017\u0001\u0017\u0005\u0017\u0225\b\u0017\n\u0017\f\u0017\u0228\t"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0003\u0018\u0230\b\u0018\u0004\u0018\u0232\b\u0018\u000b\u0018"+
		"\f\u0018\u0233\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0005\u0019\u023d\b\u0019\n\u0019\f\u0019\u0240"+
		"\t\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u024a\b\u001a\u0003\u001a\u024c"+
		"\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0005\u001b\u0254\b\u001b\n\u001b\f\u001b\u0257\t\u001b\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u025e\b\u001c"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u0264\b\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0003\u001d\u026c\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0003\u001e\u0274\b\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0003\u001e\u027f\b\u001e\u0003\u001e\u0281\b\u001e\u0001"+
		"\u001e\u0001\u001e\u0003\u001e\u0285\b\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u028d\b\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0003\u001e\u0297\b\u001e\u0001\u001e\u0001\u001e\u0005"+
		"\u001e\u029b\b\u001e\n\u001e\f\u001e\u029e\t\u001e\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u02a6\b\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u02ab\b\u001f\u0001 "+
		"\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0005 \u02b4\b \n \f \u02b7"+
		"\t \u0001!\u0001!\u0001!\u0001!\u0003!\u02bd\b!\u0001!\u0001!\u0001!\u0001"+
		"!\u0001\"\u0001\"\u0001\"\u0001\"\u0004\"\u02c7\b\"\u000b\"\f\"\u02c8"+
		"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001"+
		"#\u0003#\u02d5\b#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0003$\u02e6\b$\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0004%\u02ed\b%\u000b%\f%\u02ee\u0003%\u02f1"+
		"\b%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0003"+
		"&\u02fc\b&\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u0302\b\'\u0001\'\u0001"+
		"\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001"+
		"(\u0001(\u0001(\u0001(\u0003(\u0313\b(\u0001(\u0001(\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0003)\u032e\b)\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0003"+
		"*\u0337\b*\u0003*\u0339\b*\u0001*\u0001*\u0001*\u0001*\u0003*\u033f\b"+
		"*\u0001*\u0001*\u0001*\u0001*\u0003*\u0345\b*\u0001*\u0001*\u0001+\u0001"+
		"+\u0001+\u0001+\u0001+\u0001+\u0003+\u034f\b+\u0001,\u0001,\u0001,\u0001"+
		",\u0001,\u0001,\u0001,\u0001,\u0001,\u0003,\u035a\b,\u0003,\u035c\b,\u0001"+
		",\u0001,\u0001,\u0001,\u0000\u0003\n.<-\u0000\u0002\u0004\u0006\b\n\f"+
		"\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:"+
		"<>@BDFHJLNPRTVX\u0000\u0000\u03b8\u0000]\u0001\u0000\u0000\u0000\u0002"+
		"a\u0001\u0000\u0000\u0000\u0004q\u0001\u0000\u0000\u0000\u0006s\u0001"+
		"\u0000\u0000\u0000\b\u0084\u0001\u0000\u0000\u0000\n\u0096\u0001\u0000"+
		"\u0000\u0000\f\u0128\u0001\u0000\u0000\u0000\u000e\u0134\u0001\u0000\u0000"+
		"\u0000\u0010\u0143\u0001\u0000\u0000\u0000\u0012\u0160\u0001\u0000\u0000"+
		"\u0000\u0014\u0162\u0001\u0000\u0000\u0000\u0016\u017a\u0001\u0000\u0000"+
		"\u0000\u0018\u0184\u0001\u0000\u0000\u0000\u001a\u0186\u0001\u0000\u0000"+
		"\u0000\u001c\u01a2\u0001\u0000\u0000\u0000\u001e\u01a4\u0001\u0000\u0000"+
		"\u0000 \u01af\u0001\u0000\u0000\u0000\"\u01be\u0001\u0000\u0000\u0000"+
		"$\u01c0\u0001\u0000\u0000\u0000&\u01cc\u0001\u0000\u0000\u0000(\u01eb"+
		"\u0001\u0000\u0000\u0000*\u01ed\u0001\u0000\u0000\u0000,\u01fa\u0001\u0000"+
		"\u0000\u0000.\u020b\u0001\u0000\u0000\u00000\u0229\u0001\u0000\u0000\u0000"+
		"2\u0235\u0001\u0000\u0000\u00004\u0241\u0001\u0000\u0000\u00006\u024d"+
		"\u0001\u0000\u0000\u00008\u0258\u0001\u0000\u0000\u0000:\u026b\u0001\u0000"+
		"\u0000\u0000<\u0284\u0001\u0000\u0000\u0000>\u02aa\u0001\u0000\u0000\u0000"+
		"@\u02ac\u0001\u0000\u0000\u0000B\u02b8\u0001\u0000\u0000\u0000D\u02c2"+
		"\u0001\u0000\u0000\u0000F\u02d4\u0001\u0000\u0000\u0000H\u02e5\u0001\u0000"+
		"\u0000\u0000J\u02e7\u0001\u0000\u0000\u0000L\u02fb\u0001\u0000\u0000\u0000"+
		"N\u02fd\u0001\u0000\u0000\u0000P\u0306\u0001\u0000\u0000\u0000R\u032d"+
		"\u0001\u0000\u0000\u0000T\u032f\u0001\u0000\u0000\u0000V\u0348\u0001\u0000"+
		"\u0000\u0000X\u035b\u0001\u0000\u0000\u0000Z[\u0003\u0002\u0001\u0000"+
		"[\\\u0006\u0000\uffff\uffff\u0000\\^\u0001\u0000\u0000\u0000]Z\u0001\u0000"+
		"\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_`\u0005"+
		"\u0000\u0000\u0001`\u0001\u0001\u0000\u0000\u0000ae\u0006\u0001\uffff"+
		"\uffff\u0000bc\u0003\u0004\u0002\u0000cd\u0006\u0001\uffff\uffff\u0000"+
		"df\u0001\u0000\u0000\u0000eb\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000"+
		"\u0000ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000h\u0003\u0001"+
		"\u0000\u0000\u0000ij\u0003\u0006\u0003\u0000jk\u0006\u0002\uffff\uffff"+
		"\u0000kr\u0001\u0000\u0000\u0000lm\u0003\u001e\u000f\u0000mn\u0006\u0002"+
		"\uffff\uffff\u0000nr\u0001\u0000\u0000\u0000op\u00053\u0000\u0000pr\u0006"+
		"\u0002\uffff\uffff\u0000qi\u0001\u0000\u0000\u0000ql\u0001\u0000\u0000"+
		"\u0000qo\u0001\u0000\u0000\u0000r\u0005\u0001\u0000\u0000\u0000sw\u0006"+
		"\u0003\uffff\uffff\u0000tu\u0003 \u0010\u0000uv\u0006\u0003\uffff\uffff"+
		"\u0000vx\u0001\u0000\u0000\u0000wt\u0001\u0000\u0000\u0000wx\u0001\u0000"+
		"\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0003,\u0016\u0000z~\u0006\u0003"+
		"\uffff\uffff\u0000{|\u0003\b\u0004\u0000|}\u0006\u0003\uffff\uffff\u0000"+
		"}\u007f\u0001\u0000\u0000\u0000~{\u0001\u0000\u0000\u0000~\u007f\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0081\u0003"+
		"J%\u0000\u0081\u0082\u0006\u0003\uffff\uffff\u0000\u0082\u0083\u0006\u0003"+
		"\uffff\uffff\u0000\u0083\u0007\u0001\u0000\u0000\u0000\u0084\u0088\u0006"+
		"\u0004\uffff\uffff\u0000\u0085\u0086\u0003\u001e\u000f\u0000\u0086\u0087"+
		"\u0006\u0004\uffff\uffff\u0000\u0087\u0089\u0001\u0000\u0000\u0000\u0088"+
		"\u0085\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a"+
		"\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b"+
		"\t\u0001\u0000\u0000\u0000\u008c\u008d\u0006\u0005\uffff\uffff\u0000\u008d"+
		"\u008e\u0003\u0012\t\u0000\u008e\u008f\u0006\u0005\uffff\uffff\u0000\u008f"+
		"\u0097\u0001\u0000\u0000\u0000\u0090\u0091\u0003\f\u0006\u0000\u0091\u0092"+
		"\u0006\u0005\uffff\uffff\u0000\u0092\u0097\u0001\u0000\u0000\u0000\u0093"+
		"\u0094\u0003\u001a\r\u0000\u0094\u0095\u0006\u0005\uffff\uffff\u0000\u0095"+
		"\u0097\u0001\u0000\u0000\u0000\u0096\u008c\u0001\u0000\u0000\u0000\u0096"+
		"\u0090\u0001\u0000\u0000\u0000\u0096\u0093\u0001\u0000\u0000\u0000\u0097"+
		"\u0120\u0001\u0000\u0000\u0000\u0098\u0099\n\u000e\u0000\u0000\u0099\u00a0"+
		"\u0006\u0005\uffff\uffff\u0000\u009a\u009b\u0005\'\u0000\u0000\u009b\u00a1"+
		"\u0006\u0005\uffff\uffff\u0000\u009c\u009d\u0005(\u0000\u0000\u009d\u00a1"+
		"\u0006\u0005\uffff\uffff\u0000\u009e\u009f\u0005)\u0000\u0000\u009f\u00a1"+
		"\u0006\u0005\uffff\uffff\u0000\u00a0\u009a\u0001\u0000\u0000\u0000\u00a0"+
		"\u009c\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a3\u0003\n\u0005\u000f\u00a3\u00a4"+
		"\u0006\u0005\uffff\uffff\u0000\u00a4\u011f\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\n\r\u0000\u0000\u00a6\u00ab\u0006\u0005\uffff\uffff\u0000\u00a7"+
		"\u00a8\u0005#\u0000\u0000\u00a8\u00ac\u0006\u0005\uffff\uffff\u0000\u00a9"+
		"\u00aa\u0005%\u0000\u0000\u00aa\u00ac\u0006\u0005\uffff\uffff\u0000\u00ab"+
		"\u00a7\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ac"+
		"\u00ad\u0001\u0000\u0000\u0000\u00ad\u00ae\u0003\n\u0005\u000e\u00ae\u00af"+
		"\u0006\u0005\uffff\uffff\u0000\u00af\u011f\u0001\u0000\u0000\u0000\u00b0"+
		"\u00b1\n\f\u0000\u0000\u00b1\u00b6\u0006\u0005\uffff\uffff\u0000\u00b2"+
		"\u00b3\u0005!\u0000\u0000\u00b3\u00b7\u0006\u0005\uffff\uffff\u0000\u00b4"+
		"\u00b5\u0005\"\u0000\u0000\u00b5\u00b7\u0006\u0005\uffff\uffff\u0000\u00b6"+
		"\u00b2\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b8\u0001\u0000\u0000\u0000\u00b8\u00b9\u0003\n\u0005\r\u00b9\u00ba"+
		"\u0006\u0005\uffff\uffff\u0000\u00ba\u011f\u0001\u0000\u0000\u0000\u00bb"+
		"\u00bc\n\u000b\u0000\u0000\u00bc\u00c5\u0006\u0005\uffff\uffff\u0000\u00bd"+
		"\u00be\u0005\u001d\u0000\u0000\u00be\u00c6\u0006\u0005\uffff\uffff\u0000"+
		"\u00bf\u00c0\u0005\u001f\u0000\u0000\u00c0\u00c6\u0006\u0005\uffff\uffff"+
		"\u0000\u00c1\u00c2\u0005\u001e\u0000\u0000\u00c2\u00c6\u0006\u0005\uffff"+
		"\uffff\u0000\u00c3\u00c4\u0005 \u0000\u0000\u00c4\u00c6\u0006\u0005\uffff"+
		"\uffff\u0000\u00c5\u00bd\u0001\u0000\u0000\u0000\u00c5\u00bf\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c1\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u00c8\u0003\n\u0005"+
		"\f\u00c8\u00c9\u0006\u0005\uffff\uffff\u0000\u00c9\u011f\u0001\u0000\u0000"+
		"\u0000\u00ca\u00cb\n\n\u0000\u0000\u00cb\u00d0\u0006\u0005\uffff\uffff"+
		"\u0000\u00cc\u00cd\u0005@\u0000\u0000\u00cd\u00d1\u0006\u0005\uffff\uffff"+
		"\u0000\u00ce\u00cf\u0005A\u0000\u0000\u00cf\u00d1\u0006\u0005\uffff\uffff"+
		"\u0000\u00d0\u00cc\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d3\u0003\n\u0005\u000b"+
		"\u00d3\u00d4\u0006\u0005\uffff\uffff\u0000\u00d4\u011f\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d6\n\t\u0000\u0000\u00d6\u00d7\u0005*\u0000\u0000\u00d7"+
		"\u00d8\u0003\n\u0005\n\u00d8\u00d9\u0006\u0005\uffff\uffff\u0000\u00d9"+
		"\u011f\u0001\u0000\u0000\u0000\u00da\u00db\n\b\u0000\u0000\u00db\u00dc"+
		"\u0005*\u0000\u0000\u00dc\u00dd\u0003\n\u0005\t\u00dd\u00de\u0006\u0005"+
		"\uffff\uffff\u0000\u00de\u011f\u0001\u0000\u0000\u0000\u00df\u00e0\n\u0007"+
		"\u0000\u0000\u00e0\u00e1\u0005.\u0000\u0000\u00e1\u00e2\u0003\n\u0005"+
		"\b\u00e2\u00e3\u0006\u0005\uffff\uffff\u0000\u00e3\u011f\u0001\u0000\u0000"+
		"\u0000\u00e4\u00e5\n\u0006\u0000\u0000\u00e5\u00e6\u0005+\u0000\u0000"+
		"\u00e6\u00e7\u0003\n\u0005\u0007\u00e7\u00e8\u0006\u0005\uffff\uffff\u0000"+
		"\u00e8\u011f\u0001\u0000\u0000\u0000\u00e9\u00ea\n\u0005\u0000\u0000\u00ea"+
		"\u00eb\u0005,\u0000\u0000\u00eb\u00ec\u0003\n\u0005\u0006\u00ec\u00ed"+
		"\u0006\u0005\uffff\uffff\u0000\u00ed\u011f\u0001\u0000\u0000\u0000\u00ee"+
		"\u00ef\n\u0004\u0000\u0000\u00ef\u00f0\u0005-\u0000\u0000\u00f0\u00f1"+
		"\u0003\n\u0005\u0005\u00f1\u00f2\u0006\u0005\uffff\uffff\u0000\u00f2\u011f"+
		"\u0001\u0000\u0000\u0000\u00f3\u00f4\n\u0003\u0000\u0000\u00f4\u00f5\u0005"+
		"1\u0000\u0000\u00f5\u00f6\u0003\n\u0005\u0000\u00f6\u00f7\u00052\u0000"+
		"\u0000\u00f7\u00f8\u0003\n\u0005\u0004\u00f8\u00f9\u0006\u0005\uffff\uffff"+
		"\u0000\u00f9\u011f\u0001\u0000\u0000\u0000\u00fa\u00fb\n\u0002\u0000\u0000"+
		"\u00fb\u00fc\u0003\u001c\u000e\u0000\u00fc\u00fd\u0003\n\u0005\u0003\u00fd"+
		"\u00fe\u0006\u0005\uffff\uffff\u0000\u00fe\u011f\u0001\u0000\u0000\u0000"+
		"\u00ff\u0100\n\u0014\u0000\u0000\u0100\u0101\u0005\u0019\u0000\u0000\u0101"+
		"\u0102\u0003\n\u0005\u0000\u0102\u0103\u0005\u001a\u0000\u0000\u0103\u0104"+
		"\u0006\u0005\uffff\uffff\u0000\u0104\u011f\u0001\u0000\u0000\u0000\u0105"+
		"\u0106\n\u0013\u0000\u0000\u0106\u0107\u0006\u0005\uffff\uffff\u0000\u0107"+
		"\u010b\u0005\u0017\u0000\u0000\u0108\u0109\u0003\u0014\n\u0000\u0109\u010a"+
		"\u0006\u0005\uffff\uffff\u0000\u010a\u010c\u0001\u0000\u0000\u0000\u010b"+
		"\u0108\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c"+
		"\u010d\u0001\u0000\u0000\u0000\u010d\u011f\u0005\u0018\u0000\u0000\u010e"+
		"\u010f\n\u0012\u0000\u0000\u010f\u0110\u0005$\u0000\u0000\u0110\u011f"+
		"\u0006\u0005\uffff\uffff\u0000\u0111\u0112\n\u0011\u0000\u0000\u0112\u0113"+
		"\u0005&\u0000\u0000\u0113\u011f\u0006\u0005\uffff\uffff\u0000\u0114\u0115"+
		"\n\u0001\u0000\u0000\u0115\u011a\u0006\u0005\uffff\uffff\u0000\u0116\u0117"+
		"\u00054\u0000\u0000\u0117\u0118\u0003\n\u0005\u0000\u0118\u0119\u0006"+
		"\u0005\uffff\uffff\u0000\u0119\u011b\u0001\u0000\u0000\u0000\u011a\u0116"+
		"\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000\u0000\u011c\u011a"+
		"\u0001\u0000\u0000\u0000\u011c\u011d\u0001\u0000\u0000\u0000\u011d\u011f"+
		"\u0001\u0000\u0000\u0000\u011e\u0098\u0001\u0000\u0000\u0000\u011e\u00a5"+
		"\u0001\u0000\u0000\u0000\u011e\u00b0\u0001\u0000\u0000\u0000\u011e\u00bb"+
		"\u0001\u0000\u0000\u0000\u011e\u00ca\u0001\u0000\u0000\u0000\u011e\u00d5"+
		"\u0001\u0000\u0000\u0000\u011e\u00da\u0001\u0000\u0000\u0000\u011e\u00df"+
		"\u0001\u0000\u0000\u0000\u011e\u00e4\u0001\u0000\u0000\u0000\u011e\u00e9"+
		"\u0001\u0000\u0000\u0000\u011e\u00ee\u0001\u0000\u0000\u0000\u011e\u00f3"+
		"\u0001\u0000\u0000\u0000\u011e\u00fa\u0001\u0000\u0000\u0000\u011e\u00ff"+
		"\u0001\u0000\u0000\u0000\u011e\u0105\u0001\u0000\u0000\u0000\u011e\u010e"+
		"\u0001\u0000\u0000\u0000\u011e\u0111\u0001\u0000\u0000\u0000\u011e\u0114"+
		"\u0001\u0000\u0000\u0000\u011f\u0122\u0001\u0000\u0000\u0000\u0120\u011e"+
		"\u0001\u0000\u0000\u0000\u0120\u0121\u0001\u0000\u0000\u0000\u0121\u000b"+
		"\u0001\u0000\u0000\u0000\u0122\u0120\u0001\u0000\u0000\u0000\u0123\u0124"+
		"\u0003\u000e\u0007\u0000\u0124\u0125\u0006\u0006\uffff\uffff\u0000\u0125"+
		"\u0127\u0001\u0000\u0000\u0000\u0126\u0123\u0001\u0000\u0000\u0000\u0127"+
		"\u012a\u0001\u0000\u0000\u0000\u0128\u0126\u0001\u0000\u0000\u0000\u0128"+
		"\u0129\u0001\u0000\u0000\u0000\u0129\u012b\u0001\u0000\u0000\u0000\u012a"+
		"\u0128\u0001\u0000\u0000\u0000\u012b\u012c\u0003\u0010\b\u0000\u012c\u012d"+
		"\u0006\u0006\uffff\uffff\u0000\u012d\r\u0001\u0000\u0000\u0000\u012e\u012f"+
		"\u0005$\u0000\u0000\u012f\u0135\u0006\u0007\uffff\uffff\u0000\u0130\u0131"+
		"\u0005&\u0000\u0000\u0131\u0135\u0006\u0007\uffff\uffff\u0000\u0132\u0133"+
		"\u0005\u0010\u0000\u0000\u0133\u0135\u0006\u0007\uffff\uffff\u0000\u0134"+
		"\u012e\u0001\u0000\u0000\u0000\u0134\u0130\u0001\u0000\u0000\u0000\u0134"+
		"\u0132\u0001\u0000\u0000\u0000\u0135\u000f\u0001\u0000\u0000\u0000\u0136"+
		"\u0137\u0003\u0012\t\u0000\u0137\u0138\u0006\b\uffff\uffff\u0000\u0138"+
		"\u0144\u0001\u0000\u0000\u0000\u0139\u013a\u0003\u0016\u000b\u0000\u013a"+
		"\u013b\u0003\u0018\f\u0000\u013b\u013c\u0006\b\uffff\uffff\u0000\u013c"+
		"\u0144\u0001\u0000\u0000\u0000\u013d\u013e\u0005\u0010\u0000\u0000\u013e"+
		"\u013f\u0005\u0017\u0000\u0000\u013f\u0140\u00038\u001c\u0000\u0140\u0141"+
		"\u0005\u0018\u0000\u0000\u0141\u0142\u0006\b\uffff\uffff\u0000\u0142\u0144"+
		"\u0001\u0000\u0000\u0000\u0143\u0136\u0001\u0000\u0000\u0000\u0143\u0139"+
		"\u0001\u0000\u0000\u0000\u0143\u013d\u0001\u0000\u0000\u0000\u0144\u0011"+
		"\u0001\u0000\u0000\u0000\u0145\u0146\u0005D\u0000\u0000\u0146\u0161\u0006"+
		"\t\uffff\uffff\u0000\u0147\u0148\u0005E\u0000\u0000\u0148\u0161\u0006"+
		"\t\uffff\uffff\u0000\u0149\u014c\u0006\t\uffff\uffff\u0000\u014a\u014b"+
		"\u0005G\u0000\u0000\u014b\u014d\u0006\t\uffff\uffff\u0000\u014c\u014a"+
		"\u0001\u0000\u0000\u0000\u014d\u014e\u0001\u0000\u0000\u0000\u014e\u014c"+
		"\u0001\u0000\u0000\u0000\u014e\u014f\u0001\u0000\u0000\u0000\u014f\u0161"+
		"\u0001\u0000\u0000\u0000\u0150\u0151\u0005\u0017\u0000\u0000\u0151\u0152"+
		"\u0003\n\u0005\u0000\u0152\u0153\u0005\u0018\u0000\u0000\u0153\u0154\u0006"+
		"\t\uffff\uffff\u0000\u0154\u0161\u0001\u0000\u0000\u0000\u0155\u0156\u0005"+
		"\u0017\u0000\u0000\u0156\u0157\u00038\u001c\u0000\u0157\u0158\u0005\u0018"+
		"\u0000\u0000\u0158\u0159\u0005\u001b\u0000\u0000\u0159\u015b\u0003@ \u0000"+
		"\u015a\u015c\u00054\u0000\u0000\u015b\u015a\u0001\u0000\u0000\u0000\u015b"+
		"\u015c\u0001\u0000\u0000\u0000\u015c\u015d\u0001\u0000\u0000\u0000\u015d"+
		"\u015e\u0005\u001c\u0000\u0000\u015e\u015f\u0006\t\uffff\uffff\u0000\u015f"+
		"\u0161\u0001\u0000\u0000\u0000\u0160\u0145\u0001\u0000\u0000\u0000\u0160"+
		"\u0147\u0001\u0000\u0000\u0000\u0160\u0149\u0001\u0000\u0000\u0000\u0160"+
		"\u0150\u0001\u0000\u0000\u0000\u0160\u0155\u0001\u0000\u0000\u0000\u0161"+
		"\u0013\u0001\u0000\u0000\u0000\u0162\u0163\u0006\n\uffff\uffff\u0000\u0163"+
		"\u0164\u0003\n\u0005\u0000\u0164\u016b\u0006\n\uffff\uffff\u0000\u0165"+
		"\u0166\u00054\u0000\u0000\u0166\u0167\u0003\n\u0005\u0000\u0167\u0168"+
		"\u0006\n\uffff\uffff\u0000\u0168\u016a\u0001\u0000\u0000\u0000\u0169\u0165"+
		"\u0001\u0000\u0000\u0000\u016a\u016d\u0001\u0000\u0000\u0000\u016b\u0169"+
		"\u0001\u0000\u0000\u0000\u016b\u016c\u0001\u0000\u0000\u0000\u016c\u0015"+
		"\u0001\u0000\u0000\u0000\u016d\u016b\u0001\u0000\u0000\u0000\u016e\u016f"+
		"\u0005*\u0000\u0000\u016f\u017b\u0006\u000b\uffff\uffff\u0000\u0170\u0171"+
		"\u0005\'\u0000\u0000\u0171\u017b\u0006\u000b\uffff\uffff\u0000\u0172\u0173"+
		"\u0005#\u0000\u0000\u0173\u017b\u0006\u000b\uffff\uffff\u0000\u0174\u0175"+
		"\u0005%\u0000\u0000\u0175\u017b\u0006\u000b\uffff\uffff\u0000\u0176\u0177"+
		"\u00050\u0000\u0000\u0177\u017b\u0006\u000b\uffff\uffff\u0000\u0178\u0179"+
		"\u0005/\u0000\u0000\u0179\u017b\u0006\u000b\uffff\uffff\u0000\u017a\u016e"+
		"\u0001\u0000\u0000\u0000\u017a\u0170\u0001\u0000\u0000\u0000\u017a\u0172"+
		"\u0001\u0000\u0000\u0000\u017a\u0174\u0001\u0000\u0000\u0000\u017a\u0176"+
		"\u0001\u0000\u0000\u0000\u017a\u0178\u0001\u0000\u0000\u0000\u017b\u0017"+
		"\u0001\u0000\u0000\u0000\u017c\u017d\u0003\u001a\r\u0000\u017d\u017e\u0006"+
		"\f\uffff\uffff\u0000\u017e\u0185\u0001\u0000\u0000\u0000\u017f\u0180\u0003"+
		"\n\u0005\u0000\u0180\u0181\u0006\f\uffff\uffff\u0000\u0181\u0185\u0001"+
		"\u0000\u0000\u0000\u0182\u0183\u0005F\u0000\u0000\u0183\u0185\u0006\f"+
		"\uffff\uffff\u0000\u0184\u017c\u0001\u0000\u0000\u0000\u0184\u017f\u0001"+
		"\u0000\u0000\u0000\u0184\u0182\u0001\u0000\u0000\u0000\u0185\u0019\u0001"+
		"\u0000\u0000\u0000\u0186\u0187\u0005\u0017\u0000\u0000\u0187\u0188\u0003"+
		"8\u001c\u0000\u0188\u0189\u0005\u0018\u0000\u0000\u0189\u018a\u0003\u0018"+
		"\f\u0000\u018a\u018b\u0006\r\uffff\uffff\u0000\u018b\u001b\u0001\u0000"+
		"\u0000\u0000\u018c\u018d\u00055\u0000\u0000\u018d\u01a3\u0006\u000e\uffff"+
		"\uffff\u0000\u018e\u018f\u00056\u0000\u0000\u018f\u01a3\u0006\u000e\uffff"+
		"\uffff\u0000\u0190\u0191\u00057\u0000\u0000\u0191\u01a3\u0006\u000e\uffff"+
		"\uffff\u0000\u0192\u0193\u00058\u0000\u0000\u0193\u01a3\u0006\u000e\uffff"+
		"\uffff\u0000\u0194\u0195\u00059\u0000\u0000\u0195\u01a3\u0006\u000e\uffff"+
		"\uffff\u0000\u0196\u0197\u0005:\u0000\u0000\u0197\u01a3\u0006\u000e\uffff"+
		"\uffff\u0000\u0198\u0199\u0005;\u0000\u0000\u0199\u01a3\u0006\u000e\uffff"+
		"\uffff\u0000\u019a\u019b\u0005<\u0000\u0000\u019b\u01a3\u0006\u000e\uffff"+
		"\uffff\u0000\u019c\u019d\u0005=\u0000\u0000\u019d\u01a3\u0006\u000e\uffff"+
		"\uffff\u0000\u019e\u019f\u0005>\u0000\u0000\u019f\u01a3\u0006\u000e\uffff"+
		"\uffff\u0000\u01a0\u01a1\u0005?\u0000\u0000\u01a1\u01a3\u0006\u000e\uffff"+
		"\uffff\u0000\u01a2\u018c\u0001\u0000\u0000\u0000\u01a2\u018e\u0001\u0000"+
		"\u0000\u0000\u01a2\u0190\u0001\u0000\u0000\u0000\u01a2\u0192\u0001\u0000"+
		"\u0000\u0000\u01a2\u0194\u0001\u0000\u0000\u0000\u01a2\u0196\u0001\u0000"+
		"\u0000\u0000\u01a2\u0198\u0001\u0000\u0000\u0000\u01a2\u019a\u0001\u0000"+
		"\u0000\u0000\u01a2\u019c\u0001\u0000\u0000\u0000\u01a2\u019e\u0001\u0000"+
		"\u0000\u0000\u01a2\u01a0\u0001\u0000\u0000\u0000\u01a3\u001d\u0001\u0000"+
		"\u0000\u0000\u01a4\u01a5\u0006\u000f\uffff\uffff\u0000\u01a5\u01a6\u0003"+
		" \u0010\u0000\u01a6\u01aa\u0006\u000f\uffff\uffff\u0000\u01a7\u01a8\u0003"+
		"$\u0012\u0000\u01a8\u01a9\u0006\u000f\uffff\uffff\u0000\u01a9\u01ab\u0001"+
		"\u0000\u0000\u0000\u01aa\u01a7\u0001\u0000\u0000\u0000\u01aa\u01ab\u0001"+
		"\u0000\u0000\u0000\u01ab\u01ac\u0001\u0000\u0000\u0000\u01ac\u01ad\u0005"+
		"3\u0000\u0000\u01ad\u01ae\u0006\u000f\uffff\uffff\u0000\u01ae\u001f\u0001"+
		"\u0000\u0000\u0000\u01af\u01b3\u0006\u0010\uffff\uffff\u0000\u01b0\u01b1"+
		"\u0003\"\u0011\u0000\u01b1\u01b2\u0006\u0010\uffff\uffff\u0000\u01b2\u01b4"+
		"\u0001\u0000\u0000\u0000\u01b3\u01b0\u0001\u0000\u0000\u0000\u01b4\u01b5"+
		"\u0001\u0000\u0000\u0000\u01b5\u01b3\u0001\u0000\u0000\u0000\u01b5\u01b6"+
		"\u0001\u0000\u0000\u0000\u01b6!\u0001\u0000\u0000\u0000\u01b7\u01b8\u0005"+
		"\u0012\u0000\u0000\u01b8\u01bf\u0006\u0011\uffff\uffff\u0000\u01b9\u01ba"+
		"\u0003(\u0014\u0000\u01ba\u01bb\u0006\u0011\uffff\uffff\u0000\u01bb\u01bf"+
		"\u0001\u0000\u0000\u0000\u01bc\u01bd\u0005\u0003\u0000\u0000\u01bd\u01bf"+
		"\u0006\u0011\uffff\uffff\u0000\u01be\u01b7\u0001\u0000\u0000\u0000\u01be"+
		"\u01b9\u0001\u0000\u0000\u0000\u01be\u01bc\u0001\u0000\u0000\u0000\u01bf"+
		"#\u0001\u0000\u0000\u0000\u01c0\u01c1\u0006\u0012\uffff\uffff\u0000\u01c1"+
		"\u01c2\u0003&\u0013\u0000\u01c2\u01c9\u0006\u0012\uffff\uffff\u0000\u01c3"+
		"\u01c4\u00054\u0000\u0000\u01c4\u01c5\u0003&\u0013\u0000\u01c5\u01c6\u0006"+
		"\u0012\uffff\uffff\u0000\u01c6\u01c8\u0001\u0000\u0000\u0000\u01c7\u01c3"+
		"\u0001\u0000\u0000\u0000\u01c8\u01cb\u0001\u0000\u0000\u0000\u01c9\u01c7"+
		"\u0001\u0000\u0000\u0000\u01c9\u01ca\u0001\u0000\u0000\u0000\u01ca%\u0001"+
		"\u0000\u0000\u0000\u01cb\u01c9\u0001\u0000\u0000\u0000\u01cc\u01cd\u0006"+
		"\u0013\uffff\uffff\u0000\u01cd\u01ce\u0003,\u0016\u0000\u01ce\u01d3\u0006"+
		"\u0013\uffff\uffff\u0000\u01cf\u01d0\u00055\u0000\u0000\u01d0\u01d1\u0003"+
		">\u001f\u0000\u01d1\u01d2\u0006\u0013\uffff\uffff\u0000\u01d2\u01d4\u0001"+
		"\u0000\u0000\u0000\u01d3\u01cf\u0001\u0000\u0000\u0000\u01d3\u01d4\u0001"+
		"\u0000\u0000\u0000\u01d4\'\u0001\u0000\u0000\u0000\u01d5\u01d6\u0005\u0014"+
		"\u0000\u0000\u01d6\u01ec\u0006\u0014\uffff\uffff\u0000\u01d7\u01d8\u0005"+
		"\u0002\u0000\u0000\u01d8\u01ec\u0006\u0014\uffff\uffff\u0000\u01d9\u01da"+
		"\u0005\u000e\u0000\u0000\u01da\u01ec\u0006\u0014\uffff\uffff\u0000\u01db"+
		"\u01dc\u0005\u000b\u0000\u0000\u01dc\u01ec\u0006\u0014\uffff\uffff\u0000"+
		"\u01dd\u01de\u0005\f\u0000\u0000\u01de\u01ec\u0006\u0014\uffff\uffff\u0000"+
		"\u01df\u01e0\u0005\b\u0000\u0000\u01e0\u01ec\u0006\u0014\uffff\uffff\u0000"+
		"\u01e1\u01e2\u0005\u0006\u0000\u0000\u01e2\u01ec\u0006\u0014\uffff\uffff"+
		"\u0000\u01e3\u01e4\u0005\u000f\u0000\u0000\u01e4\u01ec\u0006\u0014\uffff"+
		"\uffff\u0000\u01e5\u01e6\u0005\u0013\u0000\u0000\u01e6\u01ec\u0006\u0014"+
		"\uffff\uffff\u0000\u01e7\u01e8\u0005\u0016\u0000\u0000\u01e8\u01ec\u0006"+
		"\u0014\uffff\uffff\u0000\u01e9\u01ea\u0005D\u0000\u0000\u01ea\u01ec\u0006"+
		"\u0014\uffff\uffff\u0000\u01eb\u01d5\u0001\u0000\u0000\u0000\u01eb\u01d7"+
		"\u0001\u0000\u0000\u0000\u01eb\u01d9\u0001\u0000\u0000\u0000\u01eb\u01db"+
		"\u0001\u0000\u0000\u0000\u01eb\u01dd\u0001\u0000\u0000\u0000\u01eb\u01df"+
		"\u0001\u0000\u0000\u0000\u01eb\u01e1\u0001\u0000\u0000\u0000\u01eb\u01e3"+
		"\u0001\u0000\u0000\u0000\u01eb\u01e5\u0001\u0000\u0000\u0000\u01eb\u01e7"+
		"\u0001\u0000\u0000\u0000\u01eb\u01e9\u0001\u0000\u0000\u0000\u01ec)\u0001"+
		"\u0000\u0000\u0000\u01ed\u01f3\u0006\u0015\uffff\uffff\u0000\u01ee\u01ef"+
		"\u0003(\u0014\u0000\u01ef\u01f0\u0006\u0015\uffff\uffff\u0000\u01f0\u01f4"+
		"\u0001\u0000\u0000\u0000\u01f1\u01f2\u0005\u0003\u0000\u0000\u01f2\u01f4"+
		"\u0006\u0015\uffff\uffff\u0000\u01f3\u01ee\u0001\u0000\u0000\u0000\u01f3"+
		"\u01f1\u0001\u0000\u0000\u0000\u01f4\u01f8\u0001\u0000\u0000\u0000\u01f5"+
		"\u01f6\u0003*\u0015\u0000\u01f6\u01f7\u0006\u0015\uffff\uffff\u0000\u01f7"+
		"\u01f9\u0001\u0000\u0000\u0000\u01f8\u01f5\u0001\u0000\u0000\u0000\u01f8"+
		"\u01f9\u0001\u0000\u0000\u0000\u01f9+\u0001\u0000\u0000\u0000\u01fa\u01fe"+
		"\u0006\u0016\uffff\uffff\u0000\u01fb\u01fc\u00030\u0018\u0000\u01fc\u01fd"+
		"\u0006\u0016\uffff\uffff\u0000\u01fd\u01ff\u0001\u0000\u0000\u0000\u01fe"+
		"\u01fb\u0001\u0000\u0000\u0000\u01fe\u01ff\u0001\u0000\u0000\u0000\u01ff"+
		"\u0200\u0001\u0000\u0000\u0000\u0200\u0201\u0003.\u0017\u0000\u0201\u0202"+
		"\u0006\u0016\uffff\uffff\u0000\u0202-\u0001\u0000\u0000\u0000\u0203\u0204"+
		"\u0006\u0017\uffff\uffff\u0000\u0204\u0205\u0005D\u0000\u0000\u0205\u020c"+
		"\u0006\u0017\uffff\uffff\u0000\u0206\u0207\u0005\u0017\u0000\u0000\u0207"+
		"\u0208\u0003,\u0016\u0000\u0208\u0209\u0005\u0018\u0000\u0000\u0209\u020a"+
		"\u0006\u0017\uffff\uffff\u0000\u020a\u020c\u0001\u0000\u0000\u0000\u020b"+
		"\u0203\u0001\u0000\u0000\u0000\u020b\u0206\u0001\u0000\u0000\u0000\u020c"+
		"\u0226\u0001\u0000\u0000\u0000\u020d\u020e\n\u0002\u0000\u0000\u020e\u020f"+
		"\u0006\u0017\uffff\uffff\u0000\u020f\u0213\u0005\u0019\u0000\u0000\u0210"+
		"\u0211\u0003\n\u0005\u0000\u0211\u0212\u0006\u0017\uffff\uffff\u0000\u0212"+
		"\u0214\u0001\u0000\u0000\u0000\u0213\u0210\u0001\u0000\u0000\u0000\u0213"+
		"\u0214\u0001\u0000\u0000\u0000\u0214\u0215\u0001\u0000\u0000\u0000\u0215"+
		"\u0225\u0005\u001a\u0000\u0000\u0216\u0217\n\u0001\u0000\u0000\u0217\u0218"+
		"\u0006\u0017\uffff\uffff\u0000\u0218\u0221\u0005\u0017\u0000\u0000\u0219"+
		"\u021a\u00032\u0019\u0000\u021a\u021b\u0006\u0017\uffff\uffff\u0000\u021b"+
		"\u0222\u0001\u0000\u0000\u0000\u021c\u021d\u00036\u001b\u0000\u021d\u021e"+
		"\u0006\u0017\uffff\uffff\u0000\u021e\u0220\u0001\u0000\u0000\u0000\u021f"+
		"\u021c\u0001\u0000\u0000\u0000\u021f\u0220\u0001\u0000\u0000\u0000\u0220"+
		"\u0222\u0001\u0000\u0000\u0000\u0221\u0219\u0001\u0000\u0000\u0000\u0221"+
		"\u021f\u0001\u0000\u0000\u0000\u0222\u0223\u0001\u0000\u0000\u0000\u0223"+
		"\u0225\u0005\u0018\u0000\u0000\u0224\u020d\u0001\u0000\u0000\u0000\u0224"+
		"\u0216\u0001\u0000\u0000\u0000\u0225\u0228\u0001\u0000\u0000\u0000\u0226"+
		"\u0224\u0001\u0000\u0000\u0000\u0226\u0227\u0001\u0000\u0000\u0000\u0227"+
		"/\u0001\u0000\u0000\u0000\u0228\u0226\u0001\u0000\u0000\u0000\u0229\u0231"+
		"\u0006\u0018\uffff\uffff\u0000\u022a\u022b\u0005\'\u0000\u0000\u022b\u022c"+
		"\u0006\u0018\uffff\uffff\u0000\u022c\u022f\u0001\u0000\u0000\u0000\u022d"+
		"\u022e\u0005\u0003\u0000\u0000\u022e\u0230\u0006\u0018\uffff\uffff\u0000"+
		"\u022f\u022d\u0001\u0000\u0000\u0000\u022f\u0230\u0001\u0000\u0000\u0000"+
		"\u0230\u0232\u0001\u0000\u0000\u0000\u0231\u022a\u0001\u0000\u0000\u0000"+
		"\u0232\u0233\u0001\u0000\u0000\u0000\u0233\u0231\u0001\u0000\u0000\u0000"+
		"\u0233\u0234\u0001\u0000\u0000\u0000\u02341\u0001\u0000\u0000\u0000\u0235"+
		"\u0236\u0006\u0019\uffff\uffff\u0000\u0236\u0237\u00034\u001a\u0000\u0237"+
		"\u023e\u0006\u0019\uffff\uffff\u0000\u0238\u0239\u00054\u0000\u0000\u0239"+
		"\u023a\u00034\u001a\u0000\u023a\u023b\u0006\u0019\uffff\uffff\u0000\u023b"+
		"\u023d\u0001\u0000\u0000\u0000\u023c\u0238\u0001\u0000\u0000\u0000\u023d"+
		"\u0240\u0001\u0000\u0000\u0000\u023e\u023c\u0001\u0000\u0000\u0000\u023e"+
		"\u023f\u0001\u0000\u0000\u0000\u023f3\u0001\u0000\u0000\u0000\u0240\u023e"+
		"\u0001\u0000\u0000\u0000\u0241\u0242\u0003 \u0010\u0000\u0242\u024b\u0006"+
		"\u001a\uffff\uffff\u0000\u0243\u0244\u0003,\u0016\u0000\u0244\u0245\u0006"+
		"\u001a\uffff\uffff\u0000\u0245\u024c\u0001\u0000\u0000\u0000\u0246\u0247"+
		"\u0003:\u001d\u0000\u0247\u0248\u0006\u001a\uffff\uffff\u0000\u0248\u024a"+
		"\u0001\u0000\u0000\u0000\u0249\u0246\u0001\u0000\u0000\u0000\u0249\u024a"+
		"\u0001\u0000\u0000\u0000\u024a\u024c\u0001\u0000\u0000\u0000\u024b\u0243"+
		"\u0001\u0000\u0000\u0000\u024b\u0249\u0001\u0000\u0000\u0000\u024c5\u0001"+
		"\u0000\u0000\u0000\u024d\u024e\u0006\u001b\uffff\uffff\u0000\u024e\u024f"+
		"\u0005D\u0000\u0000\u024f\u0255\u0006\u001b\uffff\uffff\u0000\u0250\u0251"+
		"\u00054\u0000\u0000\u0251\u0252\u0005D\u0000\u0000\u0252\u0254\u0006\u001b"+
		"\uffff\uffff\u0000\u0253\u0250\u0001\u0000\u0000\u0000\u0254\u0257\u0001"+
		"\u0000\u0000\u0000\u0255\u0253\u0001\u0000\u0000\u0000\u0255\u0256\u0001"+
		"\u0000\u0000\u0000\u02567\u0001\u0000\u0000\u0000\u0257\u0255\u0001\u0000"+
		"\u0000\u0000\u0258\u0259\u0003*\u0015\u0000\u0259\u025d\u0006\u001c\uffff"+
		"\uffff\u0000\u025a\u025b\u0003:\u001d\u0000\u025b\u025c\u0006\u001c\uffff"+
		"\uffff\u0000\u025c\u025e\u0001\u0000\u0000\u0000\u025d\u025a\u0001\u0000"+
		"\u0000\u0000\u025d\u025e\u0001\u0000\u0000\u0000\u025e9\u0001\u0000\u0000"+
		"\u0000\u025f\u0263\u0006\u001d\uffff\uffff\u0000\u0260\u0261\u00030\u0018"+
		"\u0000\u0261\u0262\u0006\u001d\uffff\uffff\u0000\u0262\u0264\u0001\u0000"+
		"\u0000\u0000\u0263\u0260\u0001\u0000\u0000\u0000\u0263\u0264\u0001\u0000"+
		"\u0000\u0000\u0264\u0265\u0001\u0000\u0000\u0000\u0265\u0266\u0003<\u001e"+
		"\u0000\u0266\u0267\u0006\u001d\uffff\uffff\u0000\u0267\u026c\u0001\u0000"+
		"\u0000\u0000\u0268\u0269\u00030\u0018\u0000\u0269\u026a\u0006\u001d\uffff"+
		"\uffff\u0000\u026a\u026c\u0001\u0000\u0000\u0000\u026b\u025f\u0001\u0000"+
		"\u0000\u0000\u026b\u0268\u0001\u0000\u0000\u0000\u026c;\u0001\u0000\u0000"+
		"\u0000\u026d\u026e\u0006\u001e\uffff\uffff\u0000\u026e\u026f\u0006\u001e"+
		"\uffff\uffff\u0000\u026f\u0273\u0005\u0019\u0000\u0000\u0270\u0271\u0003"+
		"\n\u0005\u0000\u0271\u0272\u0006\u001e\uffff\uffff\u0000\u0272\u0274\u0001"+
		"\u0000\u0000\u0000\u0273\u0270\u0001\u0000\u0000\u0000\u0273\u0274\u0001"+
		"\u0000\u0000\u0000\u0274\u0275\u0001\u0000\u0000\u0000\u0275\u0285\u0005"+
		"\u001a\u0000\u0000\u0276\u0277\u0006\u001e\uffff\uffff\u0000\u0277\u0280"+
		"\u0005\u0017\u0000\u0000\u0278\u0279\u0003:\u001d\u0000\u0279\u027a\u0006"+
		"\u001e\uffff\uffff\u0000\u027a\u0281\u0001\u0000\u0000\u0000\u027b\u027c"+
		"\u00032\u0019\u0000\u027c\u027d\u0006\u001e\uffff\uffff\u0000\u027d\u027f"+
		"\u0001\u0000\u0000\u0000\u027e\u027b\u0001\u0000\u0000\u0000\u027e\u027f"+
		"\u0001\u0000\u0000\u0000\u027f\u0281\u0001\u0000\u0000\u0000\u0280\u0278"+
		"\u0001\u0000\u0000\u0000\u0280\u027e\u0001\u0000\u0000\u0000\u0281\u0282"+
		"\u0001\u0000\u0000\u0000\u0282\u0283\u0005\u0018\u0000\u0000\u0283\u0285"+
		"\u0006\u001e\uffff\uffff\u0000\u0284\u026d\u0001\u0000\u0000\u0000\u0284"+
		"\u0276\u0001\u0000\u0000\u0000\u0285\u029c\u0001\u0000\u0000\u0000\u0286"+
		"\u0287\n\u0002\u0000\u0000\u0287\u0288\u0006\u001e\uffff\uffff\u0000\u0288"+
		"\u028c\u0005\u0019\u0000\u0000\u0289\u028a\u0003\n\u0005\u0000\u028a\u028b"+
		"\u0006\u001e\uffff\uffff\u0000\u028b\u028d\u0001\u0000\u0000\u0000\u028c"+
		"\u0289\u0001\u0000\u0000\u0000\u028c\u028d\u0001\u0000\u0000\u0000\u028d"+
		"\u028e\u0001\u0000\u0000\u0000\u028e\u028f\u0005\u001a\u0000\u0000\u028f"+
		"\u029b\u0006\u001e\uffff\uffff\u0000\u0290\u0291\n\u0001\u0000\u0000\u0291"+
		"\u0292\u0006\u001e\uffff\uffff\u0000\u0292\u0296\u0005\u0017\u0000\u0000"+
		"\u0293\u0294\u00032\u0019\u0000\u0294\u0295\u0006\u001e\uffff\uffff\u0000"+
		"\u0295\u0297\u0001\u0000\u0000\u0000\u0296\u0293\u0001\u0000\u0000\u0000"+
		"\u0296\u0297\u0001\u0000\u0000\u0000\u0297\u0298\u0001\u0000\u0000\u0000"+
		"\u0298\u0299\u0005\u0018\u0000\u0000\u0299\u029b\u0006\u001e\uffff\uffff"+
		"\u0000\u029a\u0286\u0001\u0000\u0000\u0000\u029a\u0290\u0001\u0000\u0000"+
		"\u0000\u029b\u029e\u0001\u0000\u0000\u0000\u029c\u029a\u0001\u0000\u0000"+
		"\u0000\u029c\u029d\u0001\u0000\u0000\u0000\u029d=\u0001\u0000\u0000\u0000"+
		"\u029e\u029c\u0001\u0000\u0000\u0000\u029f\u02a0\u0003\n\u0005\u0000\u02a0"+
		"\u02a1\u0006\u001f\uffff\uffff\u0000\u02a1\u02ab\u0001\u0000\u0000\u0000"+
		"\u02a2\u02a3\u0005\u001b\u0000\u0000\u02a3\u02a5\u0003@ \u0000\u02a4\u02a6"+
		"\u00054\u0000\u0000\u02a5\u02a4\u0001\u0000\u0000\u0000\u02a5\u02a6\u0001"+
		"\u0000\u0000\u0000\u02a6\u02a7\u0001\u0000\u0000\u0000\u02a7\u02a8\u0005"+
		"\u001c\u0000\u0000\u02a8\u02a9\u0006\u001f\uffff\uffff\u0000\u02a9\u02ab"+
		"\u0001\u0000\u0000\u0000\u02aa\u029f\u0001\u0000\u0000\u0000\u02aa\u02a2"+
		"\u0001\u0000\u0000\u0000\u02ab?\u0001\u0000\u0000\u0000\u02ac\u02ad\u0006"+
		" \uffff\uffff\u0000\u02ad\u02ae\u0003B!\u0000\u02ae\u02b5\u0006 \uffff"+
		"\uffff\u0000\u02af\u02b0\u00054\u0000\u0000\u02b0\u02b1\u0003B!\u0000"+
		"\u02b1\u02b2\u0006 \uffff\uffff\u0000\u02b2\u02b4\u0001\u0000\u0000\u0000"+
		"\u02b3\u02af\u0001\u0000\u0000\u0000\u02b4\u02b7\u0001\u0000\u0000\u0000"+
		"\u02b5\u02b3\u0001\u0000\u0000\u0000\u02b5\u02b6\u0001\u0000\u0000\u0000"+
		"\u02b6A\u0001\u0000\u0000\u0000\u02b7\u02b5\u0001\u0000\u0000\u0000\u02b8"+
		"\u02bc\u0006!\uffff\uffff\u0000\u02b9\u02ba\u0003D\"\u0000\u02ba\u02bb"+
		"\u0006!\uffff\uffff\u0000\u02bb\u02bd\u0001\u0000\u0000\u0000\u02bc\u02b9"+
		"\u0001\u0000\u0000\u0000\u02bc\u02bd\u0001\u0000\u0000\u0000\u02bd\u02be"+
		"\u0001\u0000\u0000\u0000\u02be\u02bf\u0003>\u001f\u0000\u02bf\u02c0\u0006"+
		"!\uffff\uffff\u0000\u02c0\u02c1\u0006!\uffff\uffff\u0000\u02c1C\u0001"+
		"\u0000\u0000\u0000\u02c2\u02c6\u0006\"\uffff\uffff\u0000\u02c3\u02c4\u0003"+
		"F#\u0000\u02c4\u02c5\u0006\"\uffff\uffff\u0000\u02c5\u02c7\u0001\u0000"+
		"\u0000\u0000\u02c6\u02c3\u0001\u0000\u0000\u0000\u02c7\u02c8\u0001\u0000"+
		"\u0000\u0000\u02c8\u02c6\u0001\u0000\u0000\u0000\u02c8\u02c9\u0001\u0000"+
		"\u0000\u0000\u02c9\u02ca\u0001\u0000\u0000\u0000\u02ca\u02cb\u00055\u0000"+
		"\u0000\u02cbE\u0001\u0000\u0000\u0000\u02cc\u02cd\u0005\u0019\u0000\u0000"+
		"\u02cd\u02ce\u0003\n\u0005\u0000\u02ce\u02cf\u0005\u001a\u0000\u0000\u02cf"+
		"\u02d0\u0006#\uffff\uffff\u0000\u02d0\u02d5\u0001\u0000\u0000\u0000\u02d1"+
		"\u02d2\u0005C\u0000\u0000\u02d2\u02d3\u0005D\u0000\u0000\u02d3\u02d5\u0006"+
		"#\uffff\uffff\u0000\u02d4\u02cc\u0001\u0000\u0000\u0000\u02d4\u02d1\u0001"+
		"\u0000\u0000\u0000\u02d5G\u0001\u0000\u0000\u0000\u02d6\u02d7\u0003J%"+
		"\u0000\u02d7\u02d8\u0006$\uffff\uffff\u0000\u02d8\u02e6\u0001\u0000\u0000"+
		"\u0000\u02d9\u02da\u0003N\'\u0000\u02da\u02db\u0006$\uffff\uffff\u0000"+
		"\u02db\u02e6\u0001\u0000\u0000\u0000\u02dc\u02dd\u0003P(\u0000\u02dd\u02de"+
		"\u0006$\uffff\uffff\u0000\u02de\u02e6\u0001\u0000\u0000\u0000\u02df\u02e0"+
		"\u0003R)\u0000\u02e0\u02e1\u0006$\uffff\uffff\u0000\u02e1\u02e6\u0001"+
		"\u0000\u0000\u0000\u02e2\u02e3\u0003X,\u0000\u02e3\u02e4\u0006$\uffff"+
		"\uffff\u0000\u02e4\u02e6\u0001\u0000\u0000\u0000\u02e5\u02d6\u0001\u0000"+
		"\u0000\u0000\u02e5\u02d9\u0001\u0000\u0000\u0000\u02e5\u02dc\u0001\u0000"+
		"\u0000\u0000\u02e5\u02df\u0001\u0000\u0000\u0000\u02e5\u02e2\u0001\u0000"+
		"\u0000\u0000\u02e6I\u0001\u0000\u0000\u0000\u02e7\u02e8\u0006%\uffff\uffff"+
		"\u0000\u02e8\u02f0\u0005\u001b\u0000\u0000\u02e9\u02ea\u0003L&\u0000\u02ea"+
		"\u02eb\u0006%\uffff\uffff\u0000\u02eb\u02ed\u0001\u0000\u0000\u0000\u02ec"+
		"\u02e9\u0001\u0000\u0000\u0000\u02ed\u02ee\u0001\u0000\u0000\u0000\u02ee"+
		"\u02ec\u0001\u0000\u0000\u0000\u02ee\u02ef\u0001\u0000\u0000\u0000\u02ef"+
		"\u02f1\u0001\u0000\u0000\u0000\u02f0\u02ec\u0001\u0000\u0000\u0000\u02f0"+
		"\u02f1\u0001\u0000\u0000\u0000\u02f1\u02f2\u0001\u0000\u0000\u0000\u02f2"+
		"\u02f3\u0005\u001c\u0000\u0000\u02f3\u02f4\u0006%\uffff\uffff\u0000\u02f4"+
		"K\u0001\u0000\u0000\u0000\u02f5\u02f6\u0003H$\u0000\u02f6\u02f7\u0006"+
		"&\uffff\uffff\u0000\u02f7\u02fc\u0001\u0000\u0000\u0000\u02f8\u02f9\u0003"+
		"\u001e\u000f\u0000\u02f9\u02fa\u0006&\uffff\uffff\u0000\u02fa\u02fc\u0001"+
		"\u0000\u0000\u0000\u02fb\u02f5\u0001\u0000\u0000\u0000\u02fb\u02f8\u0001"+
		"\u0000\u0000\u0000\u02fcM\u0001\u0000\u0000\u0000\u02fd\u0301\u0006\'"+
		"\uffff\uffff\u0000\u02fe\u02ff\u0003\n\u0005\u0000\u02ff\u0300\u0006\'"+
		"\uffff\uffff\u0000\u0300\u0302\u0001\u0000\u0000\u0000\u0301\u02fe\u0001"+
		"\u0000\u0000\u0000\u0301\u0302\u0001\u0000\u0000\u0000\u0302\u0303\u0001"+
		"\u0000\u0000\u0000\u0303\u0304\u00053\u0000\u0000\u0304\u0305\u0006\'"+
		"\uffff\uffff\u0000\u0305O\u0001\u0000\u0000\u0000\u0306\u0307\u0006(\uffff"+
		"\uffff\u0000\u0307\u0308\u0005\n\u0000\u0000\u0308\u0309\u0005\u0017\u0000"+
		"\u0000\u0309\u030a\u0003\n\u0005\u0000\u030a\u030b\u0006(\uffff\uffff"+
		"\u0000\u030b\u030c\u0005\u0018\u0000\u0000\u030c\u030d\u0003H$\u0000\u030d"+
		"\u0312\u0006(\uffff\uffff\u0000\u030e\u030f\u0005\u0007\u0000\u0000\u030f"+
		"\u0310\u0003H$\u0000\u0310\u0311\u0006(\uffff\uffff\u0000\u0311\u0313"+
		"\u0001\u0000\u0000\u0000\u0312\u030e\u0001\u0000\u0000\u0000\u0312\u0313"+
		"\u0001\u0000\u0000\u0000\u0313\u0314\u0001\u0000\u0000\u0000\u0314\u0315"+
		"\u0006(\uffff\uffff\u0000\u0315Q\u0001\u0000\u0000\u0000\u0316\u0317\u0005"+
		"\u0015\u0000\u0000\u0317\u0318\u0005\u0017\u0000\u0000\u0318\u0319\u0003"+
		"\n\u0005\u0000\u0319\u031a\u0005\u0018\u0000\u0000\u031a\u031b\u0003H"+
		"$\u0000\u031b\u031c\u0006)\uffff\uffff\u0000\u031c\u032e\u0001\u0000\u0000"+
		"\u0000\u031d\u031e\u0005\u0005\u0000\u0000\u031e\u031f\u0003H$\u0000\u031f"+
		"\u0320\u0005\u0015\u0000\u0000\u0320\u0321\u0005\u0017\u0000\u0000\u0321"+
		"\u0322\u0003\n\u0005\u0000\u0322\u0323\u0005\u0018\u0000\u0000\u0323\u0324"+
		"\u00053\u0000\u0000\u0324\u0325\u0006)\uffff\uffff\u0000\u0325\u032e\u0001"+
		"\u0000\u0000\u0000\u0326\u0327\u0005\t\u0000\u0000\u0327\u0328\u0005\u0017"+
		"\u0000\u0000\u0328\u0329\u0003T*\u0000\u0329\u032a\u0005\u0018\u0000\u0000"+
		"\u032a\u032b\u0003H$\u0000\u032b\u032c\u0006)\uffff\uffff\u0000\u032c"+
		"\u032e\u0001\u0000\u0000\u0000\u032d\u0316\u0001\u0000\u0000\u0000\u032d"+
		"\u031d\u0001\u0000\u0000\u0000\u032d\u0326\u0001\u0000\u0000\u0000\u032e"+
		"S\u0001\u0000\u0000\u0000\u032f\u0338\u0006*\uffff\uffff\u0000\u0330\u0331"+
		"\u0003V+\u0000\u0331\u0332\u0006*\uffff\uffff\u0000\u0332\u0339\u0001"+
		"\u0000\u0000\u0000\u0333\u0334\u0003\n\u0005\u0000\u0334\u0335\u0006*"+
		"\uffff\uffff\u0000\u0335\u0337\u0001\u0000\u0000\u0000\u0336\u0333\u0001"+
		"\u0000\u0000\u0000\u0336\u0337\u0001\u0000\u0000\u0000\u0337\u0339\u0001"+
		"\u0000\u0000\u0000\u0338\u0330\u0001\u0000\u0000\u0000\u0338\u0336\u0001"+
		"\u0000\u0000\u0000\u0339\u033a\u0001\u0000\u0000\u0000\u033a\u033e\u0005"+
		"3\u0000\u0000\u033b\u033c\u0003\u0014\n\u0000\u033c\u033d\u0006*\uffff"+
		"\uffff\u0000\u033d\u033f\u0001\u0000\u0000\u0000\u033e\u033b\u0001\u0000"+
		"\u0000\u0000\u033e\u033f\u0001\u0000\u0000\u0000\u033f\u0340\u0001\u0000"+
		"\u0000\u0000\u0340\u0344\u00053\u0000\u0000\u0341\u0342\u0003\u0014\n"+
		"\u0000\u0342\u0343\u0006*\uffff\uffff\u0000\u0343\u0345\u0001\u0000\u0000"+
		"\u0000\u0344\u0341\u0001\u0000\u0000\u0000\u0344\u0345\u0001\u0000\u0000"+
		"\u0000\u0345\u0346\u0001\u0000\u0000\u0000\u0346\u0347\u0006*\uffff\uffff"+
		"\u0000\u0347U\u0001\u0000\u0000\u0000\u0348\u0349\u0006+\uffff\uffff\u0000"+
		"\u0349\u034a\u0003 \u0010\u0000\u034a\u034e\u0006+\uffff\uffff\u0000\u034b"+
		"\u034c\u0003$\u0012\u0000\u034c\u034d\u0006+\uffff\uffff\u0000\u034d\u034f"+
		"\u0001\u0000\u0000\u0000\u034e\u034b\u0001\u0000\u0000\u0000\u034e\u034f"+
		"\u0001\u0000\u0000\u0000\u034fW\u0001\u0000\u0000\u0000\u0350\u0351\u0005"+
		"\u0004\u0000\u0000\u0351\u035c\u0006,\uffff\uffff\u0000\u0352\u0353\u0005"+
		"\u0001\u0000\u0000\u0353\u035c\u0006,\uffff\uffff\u0000\u0354\u0355\u0005"+
		"\r\u0000\u0000\u0355\u0359\u0006,\uffff\uffff\u0000\u0356\u0357\u0003"+
		"\n\u0005\u0000\u0357\u0358\u0006,\uffff\uffff\u0000\u0358\u035a\u0001"+
		"\u0000\u0000\u0000\u0359\u0356\u0001\u0000\u0000\u0000\u0359\u035a\u0001"+
		"\u0000\u0000\u0000\u035a\u035c\u0001\u0000\u0000\u0000\u035b\u0350\u0001"+
		"\u0000\u0000\u0000\u035b\u0352\u0001\u0000\u0000\u0000\u035b\u0354\u0001"+
		"\u0000\u0000\u0000\u035c\u035d\u0001\u0000\u0000\u0000\u035d\u035e\u0005"+
		"3\u0000\u0000\u035e\u035f\u0006,\uffff\uffff\u0000\u035fY\u0001\u0000"+
		"\u0000\u0000N]gqw~\u008a\u0096\u00a0\u00ab\u00b6\u00c5\u00d0\u010b\u011c"+
		"\u011e\u0120\u0128\u0134\u0143\u014e\u015b\u0160\u016b\u017a\u0184\u01a2"+
		"\u01aa\u01b5\u01be\u01c9\u01d3\u01eb\u01f3\u01f8\u01fe\u020b\u0213\u021f"+
		"\u0221\u0224\u0226\u022f\u0233\u023e\u0249\u024b\u0255\u025d\u0263\u026b"+
		"\u0273\u027e\u0280\u0284\u028c\u0296\u029a\u029c\u02a5\u02aa\u02b5\u02bc"+
		"\u02c8\u02d4\u02e5\u02ee\u02f0\u02fb\u0301\u0312\u032d\u0336\u0338\u033e"+
		"\u0344\u034e\u0359\u035b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}