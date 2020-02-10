// Generated from /home/edward/Documents/scifair/src/main/antlr/parser/Lang2.g4 by ANTLR 4.7.1

  package parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Lang2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, BOOL=48, NULL=49, NUM=50, FLOAT=51, ID=52, STR=53, 
		CHR=54, WS=55, LINE_COMMENT=56, BLANK_LINE=57;
	public static final int
		RULE_program = 0, RULE_expr = 1, RULE_structExpr = 2, RULE_arrayExpr = 3, 
		RULE_literalExpr = 4, RULE_varDecl = 5, RULE_structDeclExpr = 6, RULE_varDeclExpr = 7, 
		RULE_lambdaExpr = 8, RULE_funcDeclExpr = 9, RULE_forExpr = 10, RULE_typeExpr = 11, 
		RULE_ifStatementBody = 12, RULE_ifStatement = 13, RULE_returnStatement = 14, 
		RULE_statement = 15, RULE_lineComment = 16, RULE_blankLine = 17;
	public static final String[] ruleNames = {
		"program", "expr", "structExpr", "arrayExpr", "literalExpr", "varDecl", 
		"structDeclExpr", "varDeclExpr", "lambdaExpr", "funcDeclExpr", "forExpr", 
		"typeExpr", "ifStatementBody", "ifStatement", "returnStatement", "statement", 
		"lineComment", "blankLine"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'.'", "'['", "']'", "'++'", "'--'", "','", "'!'", 
		"'~'", "'*'", "'/'", "'%'", "'+'", "'-'", "'<<'", "'>>'", "'<'", "'<='", 
		"'>'", "'>='", "'=='", "'!='", "'&'", "'|'", "'^'", "'&&'", "'||'", "'='", 
		"'+='", "'-='", "'*='", "'/='", "'%='", "'<<='", "'>>='", "'&='", "'^='", 
		"'|='", "'struct'", "'{'", "'}'", "';'", "'for'", "'if'", "'else'", "'return'", 
		null, "'null'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"BOOL", "NULL", "NUM", "FLOAT", "ID", "STR", "CHR", "WS", "LINE_COMMENT", 
		"BLANK_LINE"
	};
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
	public String getGrammarFileName() { return "Lang2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Lang2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Lang2Parser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << T__9) | (1L << T__39) | (1L << T__43) | (1L << T__44) | (1L << T__46) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR) | (1L << LINE_COMMENT) | (1L << BLANK_LINE))) != 0)) {
				{
				{
				setState(36);
				statement();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignmentExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AssignmentExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class PrefixExprContext extends ExprContext {
		public Token op;
		public ExprContext varName;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrefixExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class VarExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(Lang2Parser.ID, 0); }
		public VarExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ClosureExprContext extends ExprContext {
		public LambdaExprContext lambdaExpr() {
			return getRuleContext(LambdaExprContext.class,0);
		}
		public ClosureExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class DotExprContext extends ExprContext {
		public ExprContext varName;
		public ExprContext sub;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DotExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class InfixExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public InfixExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class FuncExprContext extends ExprContext {
		public ExprContext func;
		public ExprContext args;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FuncExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ArraySubExprContext extends ExprContext {
		public ExprContext varName;
		public ExprContext sub;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArraySubExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class PostfixExprContext extends ExprContext {
		public ExprContext varName;
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PostfixExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class LitExprContext extends ExprContext {
		public LiteralExprContext literalExpr() {
			return getRuleContext(LiteralExprContext.class,0);
		}
		public LitExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ParenExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(45);
				match(T__0);
				setState(46);
				expr(0);
				setState(47);
				match(T__1);
				}
				break;
			case 2:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(49);
				((PrefixExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__8 || _la==T__9) ) {
					((PrefixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(50);
				((PrefixExprContext)_localctx).varName = expr(15);
				}
				break;
			case 3:
				{
				_localctx = new LitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(51);
				literalExpr();
				}
				break;
			case 4:
				{
				_localctx = new ClosureExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(52);
				lambdaExpr();
				}
				break;
			case 5:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(53);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(115);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(113);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new DotExprContext(new ExprContext(_parentctx, _parentState));
						((DotExprContext)_localctx).varName = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(56);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(57);
						match(T__2);
						setState(58);
						((DotExprContext)_localctx).sub = expr(20);
						}
						break;
					case 2:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(59);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(60);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(61);
						((InfixExprContext)_localctx).right = expr(15);
						}
						break;
					case 3:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(62);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(63);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__13 || _la==T__14) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(64);
						((InfixExprContext)_localctx).right = expr(14);
						}
						break;
					case 4:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(65);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(66);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__15 || _la==T__16) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(67);
						((InfixExprContext)_localctx).right = expr(13);
						}
						break;
					case 5:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(68);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(69);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20))) != 0)) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(70);
						((InfixExprContext)_localctx).right = expr(12);
						}
						break;
					case 6:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(71);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(72);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__21 || _la==T__22) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(73);
						((InfixExprContext)_localctx).right = expr(11);
						}
						break;
					case 7:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(74);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(75);
						((InfixExprContext)_localctx).op = match(T__23);
						setState(76);
						((InfixExprContext)_localctx).right = expr(10);
						}
						break;
					case 8:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(77);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(78);
						((InfixExprContext)_localctx).op = match(T__24);
						setState(79);
						((InfixExprContext)_localctx).right = expr(9);
						}
						break;
					case 9:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(80);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(81);
						((InfixExprContext)_localctx).op = match(T__25);
						setState(82);
						((InfixExprContext)_localctx).right = expr(8);
						}
						break;
					case 10:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(83);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(84);
						((InfixExprContext)_localctx).op = match(T__26);
						setState(85);
						((InfixExprContext)_localctx).right = expr(7);
						}
						break;
					case 11:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(86);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(87);
						((InfixExprContext)_localctx).op = match(T__27);
						setState(88);
						((InfixExprContext)_localctx).right = expr(6);
						}
						break;
					case 12:
						{
						_localctx = new AssignmentExprContext(new ExprContext(_parentctx, _parentState));
						((AssignmentExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(89);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(90);
						((AssignmentExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) ) {
							((AssignmentExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(91);
						((AssignmentExprContext)_localctx).right = expr(5);
						}
						break;
					case 13:
						{
						_localctx = new ArraySubExprContext(new ExprContext(_parentctx, _parentState));
						((ArraySubExprContext)_localctx).varName = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(92);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(93);
						match(T__3);
						setState(94);
						((ArraySubExprContext)_localctx).sub = expr(0);
						setState(95);
						match(T__4);
						}
						break;
					case 14:
						{
						_localctx = new PostfixExprContext(new ExprContext(_parentctx, _parentState));
						((PostfixExprContext)_localctx).varName = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(97);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(98);
						((PostfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__5 || _la==T__6) ) {
							((PostfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					case 15:
						{
						_localctx = new FuncExprContext(new ExprContext(_parentctx, _parentState));
						((FuncExprContext)_localctx).func = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(99);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(100);
						match(T__0);
						setState(106);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(101);
								((FuncExprContext)_localctx).args = expr(0);
								setState(102);
								match(T__7);
								}
								} 
							}
							setState(108);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
						}
						setState(110);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << T__9) | (1L << T__39) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
							{
							setState(109);
							((FuncExprContext)_localctx).args = expr(0);
							}
						}

						setState(112);
						match(T__1);
						}
						break;
					}
					} 
				}
				setState(117);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class StructExprContext extends ParserRuleContext {
		public Token name;
		public Token field;
		public ExprContext value;
		public List<TerminalNode> ID() { return getTokens(Lang2Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Lang2Parser.ID, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public StructExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structExpr; }
	}

	public final StructExprContext structExpr() throws RecognitionException {
		StructExprContext _localctx = new StructExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_structExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(T__0);
			setState(119);
			match(T__39);
			setState(120);
			((StructExprContext)_localctx).name = match(ID);
			setState(121);
			match(T__1);
			setState(122);
			match(T__40);
			setState(131);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(123);
					match(T__2);
					setState(124);
					((StructExprContext)_localctx).field = match(ID);
					setState(125);
					match(T__28);
					setState(126);
					((StructExprContext)_localctx).value = expr(0);
					setState(127);
					match(T__7);
					}
					} 
				}
				setState(133);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(134);
				match(T__2);
				setState(135);
				((StructExprContext)_localctx).field = match(ID);
				setState(136);
				match(T__28);
				setState(137);
				((StructExprContext)_localctx).value = expr(0);
				}
			}

			setState(140);
			match(T__41);
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

	public static class ArrayExprContext extends ParserRuleContext {
		public TypeExprContext type;
		public ExprContext value;
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArrayExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayExpr; }
	}

	public final ArrayExprContext arrayExpr() throws RecognitionException {
		ArrayExprContext _localctx = new ArrayExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_arrayExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(T__0);
			setState(143);
			((ArrayExprContext)_localctx).type = typeExpr(0);
			setState(144);
			match(T__3);
			setState(145);
			match(T__4);
			setState(146);
			match(T__1);
			setState(147);
			match(T__40);
			setState(153);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(148);
					((ArrayExprContext)_localctx).value = expr(0);
					setState(149);
					match(T__7);
					}
					} 
				}
				setState(155);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << T__9) | (1L << T__39) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
				{
				setState(156);
				((ArrayExprContext)_localctx).value = expr(0);
				}
			}

			setState(159);
			match(T__41);
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

	public static class LiteralExprContext extends ParserRuleContext {
		public LiteralExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalExpr; }
	 
		public LiteralExprContext() { }
		public void copyFrom(LiteralExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StrLiteralContext extends LiteralExprContext {
		public Token value;
		public TerminalNode STR() { return getToken(Lang2Parser.STR, 0); }
		public StrLiteralContext(LiteralExprContext ctx) { copyFrom(ctx); }
	}
	public static class StructLiteralContext extends LiteralExprContext {
		public StructExprContext structExpr() {
			return getRuleContext(StructExprContext.class,0);
		}
		public StructLiteralContext(LiteralExprContext ctx) { copyFrom(ctx); }
	}
	public static class NullLiteralContext extends LiteralExprContext {
		public Token value;
		public TerminalNode NULL() { return getToken(Lang2Parser.NULL, 0); }
		public NullLiteralContext(LiteralExprContext ctx) { copyFrom(ctx); }
	}
	public static class ArrayLiteralContext extends LiteralExprContext {
		public ArrayExprContext arrayExpr() {
			return getRuleContext(ArrayExprContext.class,0);
		}
		public ArrayLiteralContext(LiteralExprContext ctx) { copyFrom(ctx); }
	}
	public static class NumLiteralContext extends LiteralExprContext {
		public Token value;
		public TerminalNode NUM() { return getToken(Lang2Parser.NUM, 0); }
		public NumLiteralContext(LiteralExprContext ctx) { copyFrom(ctx); }
	}
	public static class FloatLiteralContext extends LiteralExprContext {
		public Token value;
		public TerminalNode FLOAT() { return getToken(Lang2Parser.FLOAT, 0); }
		public FloatLiteralContext(LiteralExprContext ctx) { copyFrom(ctx); }
	}
	public static class BooleanLiteralContext extends LiteralExprContext {
		public Token value;
		public TerminalNode BOOL() { return getToken(Lang2Parser.BOOL, 0); }
		public BooleanLiteralContext(LiteralExprContext ctx) { copyFrom(ctx); }
	}

	public final LiteralExprContext literalExpr() throws RecognitionException {
		LiteralExprContext _localctx = new LiteralExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_literalExpr);
		try {
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new StructLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				structExpr();
				}
				break;
			case 2:
				_localctx = new ArrayLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				arrayExpr();
				}
				break;
			case 3:
				_localctx = new StrLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(163);
				((StrLiteralContext)_localctx).value = match(STR);
				}
				break;
			case 4:
				_localctx = new NumLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(164);
				((NumLiteralContext)_localctx).value = match(NUM);
				}
				break;
			case 5:
				_localctx = new NullLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(165);
				((NullLiteralContext)_localctx).value = match(NULL);
				}
				break;
			case 6:
				_localctx = new FloatLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(166);
				((FloatLiteralContext)_localctx).value = match(FLOAT);
				}
				break;
			case 7:
				_localctx = new BooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(167);
				((BooleanLiteralContext)_localctx).value = match(BOOL);
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

	public static class VarDeclContext extends ParserRuleContext {
		public TypeExprContext type;
		public Token name;
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(Lang2Parser.ID, 0); }
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			((VarDeclContext)_localctx).type = typeExpr(0);
			setState(171);
			((VarDeclContext)_localctx).name = match(ID);
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

	public static class StructDeclExprContext extends ParserRuleContext {
		public Token name;
		public VarDeclContext fields;
		public TerminalNode ID() { return getToken(Lang2Parser.ID, 0); }
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public StructDeclExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclExpr; }
	}

	public final StructDeclExprContext structDeclExpr() throws RecognitionException {
		StructDeclExprContext _localctx = new StructDeclExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_structDeclExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(T__39);
			setState(174);
			((StructDeclExprContext)_localctx).name = match(ID);
			setState(175);
			match(T__40);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__39 || _la==ID) {
				{
				{
				setState(176);
				((StructDeclExprContext)_localctx).fields = varDecl();
				setState(177);
				match(T__42);
				}
				}
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(184);
			match(T__41);
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

	public static class VarDeclExprContext extends ParserRuleContext {
		public VarDeclContext var;
		public ExprContext value;
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarDeclExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclExpr; }
	}

	public final VarDeclExprContext varDeclExpr() throws RecognitionException {
		VarDeclExprContext _localctx = new VarDeclExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_varDeclExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			((VarDeclExprContext)_localctx).var = varDecl();
			setState(187);
			match(T__28);
			setState(188);
			((VarDeclExprContext)_localctx).value = expr(0);
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

	public static class LambdaExprContext extends ParserRuleContext {
		public TypeExprContext ret_type;
		public VarDeclContext args;
		public StatementContext body;
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public LambdaExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaExpr; }
	}

	public final LambdaExprContext lambdaExpr() throws RecognitionException {
		LambdaExprContext _localctx = new LambdaExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_lambdaExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			((LambdaExprContext)_localctx).ret_type = typeExpr(0);
			setState(191);
			match(T__0);
			setState(197);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(192);
					((LambdaExprContext)_localctx).args = varDecl();
					setState(193);
					match(T__7);
					}
					} 
				}
				setState(199);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__39 || _la==ID) {
				{
				setState(200);
				((LambdaExprContext)_localctx).args = varDecl();
				}
			}

			setState(203);
			match(T__1);
			setState(204);
			match(T__40);
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << T__9) | (1L << T__39) | (1L << T__43) | (1L << T__44) | (1L << T__46) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR) | (1L << LINE_COMMENT) | (1L << BLANK_LINE))) != 0)) {
				{
				{
				setState(205);
				((LambdaExprContext)_localctx).body = statement();
				}
				}
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(211);
			match(T__41);
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

	public static class FuncDeclExprContext extends ParserRuleContext {
		public TypeExprContext ret_type;
		public Token name;
		public VarDeclContext args;
		public StatementContext body;
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(Lang2Parser.ID, 0); }
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FuncDeclExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDeclExpr; }
	}

	public final FuncDeclExprContext funcDeclExpr() throws RecognitionException {
		FuncDeclExprContext _localctx = new FuncDeclExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funcDeclExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			((FuncDeclExprContext)_localctx).ret_type = typeExpr(0);
			setState(214);
			((FuncDeclExprContext)_localctx).name = match(ID);
			setState(215);
			match(T__0);
			setState(221);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(216);
					((FuncDeclExprContext)_localctx).args = varDecl();
					setState(217);
					match(T__7);
					}
					} 
				}
				setState(223);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__39 || _la==ID) {
				{
				setState(224);
				((FuncDeclExprContext)_localctx).args = varDecl();
				}
			}

			setState(227);
			match(T__1);
			setState(228);
			match(T__40);
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << T__9) | (1L << T__39) | (1L << T__43) | (1L << T__44) | (1L << T__46) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR) | (1L << LINE_COMMENT) | (1L << BLANK_LINE))) != 0)) {
				{
				{
				setState(229);
				((FuncDeclExprContext)_localctx).body = statement();
				}
				}
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(235);
			match(T__41);
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

	public static class ForExprContext extends ParserRuleContext {
		public StatementContext initial;
		public ExprContext cond;
		public ExprContext end;
		public StatementContext body;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ForExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forExpr; }
	}

	public final ForExprContext forExpr() throws RecognitionException {
		ForExprContext _localctx = new ForExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_forExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(T__43);
			setState(238);
			match(T__0);
			setState(239);
			((ForExprContext)_localctx).initial = statement();
			setState(240);
			((ForExprContext)_localctx).cond = expr(0);
			setState(241);
			match(T__42);
			setState(242);
			((ForExprContext)_localctx).end = expr(0);
			setState(243);
			match(T__1);
			setState(244);
			match(T__40);
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << T__9) | (1L << T__39) | (1L << T__43) | (1L << T__44) | (1L << T__46) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR) | (1L << LINE_COMMENT) | (1L << BLANK_LINE))) != 0)) {
				{
				{
				setState(245);
				((ForExprContext)_localctx).body = statement();
				}
				}
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(251);
			match(T__41);
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

	public static class TypeExprContext extends ParserRuleContext {
		public TypeExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeExpr; }
	 
		public TypeExprContext() { }
		public void copyFrom(TypeExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayTypeExprContext extends TypeExprContext {
		public TypeExprContext type;
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public ArrayTypeExprContext(TypeExprContext ctx) { copyFrom(ctx); }
	}
	public static class StructTypeExprContext extends TypeExprContext {
		public Token name;
		public TerminalNode ID() { return getToken(Lang2Parser.ID, 0); }
		public StructTypeExprContext(TypeExprContext ctx) { copyFrom(ctx); }
	}
	public static class PlainTypeContext extends TypeExprContext {
		public Token type;
		public TerminalNode ID() { return getToken(Lang2Parser.ID, 0); }
		public PlainTypeContext(TypeExprContext ctx) { copyFrom(ctx); }
	}

	public final TypeExprContext typeExpr() throws RecognitionException {
		return typeExpr(0);
	}

	private TypeExprContext typeExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeExprContext _localctx = new TypeExprContext(_ctx, _parentState);
		TypeExprContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_typeExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__39:
				{
				_localctx = new StructTypeExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(254);
				match(T__39);
				setState(255);
				((StructTypeExprContext)_localctx).name = match(ID);
				}
				break;
			case ID:
				{
				_localctx = new PlainTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(256);
				((PlainTypeContext)_localctx).type = match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(264);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayTypeExprContext(new TypeExprContext(_parentctx, _parentState));
					((ArrayTypeExprContext)_localctx).type = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_typeExpr);
					setState(259);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(260);
					match(T__3);
					setState(261);
					match(T__4);
					}
					} 
				}
				setState(266);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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

	public static class IfStatementBodyContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfStatementBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatementBody; }
	}

	public final IfStatementBodyContext ifStatementBody() throws RecognitionException {
		IfStatementBodyContext _localctx = new IfStatementBodyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifStatementBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(267);
				statement();
				}
				}
				setState(270); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << T__9) | (1L << T__39) | (1L << T__43) | (1L << T__44) | (1L << T__46) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR) | (1L << LINE_COMMENT) | (1L << BLANK_LINE))) != 0) );
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

	public static class IfStatementContext extends ParserRuleContext {
		public ExprContext cond;
		public IfStatementBodyContext body;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<IfStatementBodyContext> ifStatementBody() {
			return getRuleContexts(IfStatementBodyContext.class);
		}
		public IfStatementBodyContext ifStatementBody(int i) {
			return getRuleContext(IfStatementBodyContext.class,i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ifStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(T__44);
			setState(273);
			match(T__0);
			setState(274);
			((IfStatementContext)_localctx).cond = expr(0);
			setState(275);
			match(T__1);
			setState(276);
			match(T__40);
			{
			setState(277);
			((IfStatementContext)_localctx).body = ifStatementBody();
			}
			setState(278);
			match(T__41);
			setState(290);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(279);
					match(T__45);
					setState(280);
					match(T__44);
					setState(281);
					match(T__0);
					setState(282);
					((IfStatementContext)_localctx).cond = expr(0);
					setState(283);
					match(T__1);
					setState(284);
					match(T__40);
					{
					setState(285);
					((IfStatementContext)_localctx).body = ifStatementBody();
					}
					setState(286);
					match(T__41);
					}
					} 
				}
				setState(292);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__45) {
				{
				setState(293);
				match(T__45);
				setState(294);
				match(T__40);
				{
				setState(295);
				((IfStatementContext)_localctx).body = ifStatementBody();
				}
				setState(296);
				match(T__41);
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public ExprContext value;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(T__46);
			setState(301);
			((ReturnStatementContext)_localctx).value = expr(0);
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

	public static class StatementContext extends ParserRuleContext {
		public FuncDeclExprContext funcDeclExpr() {
			return getRuleContext(FuncDeclExprContext.class,0);
		}
		public VarDeclExprContext varDeclExpr() {
			return getRuleContext(VarDeclExprContext.class,0);
		}
		public ForExprContext forExpr() {
			return getRuleContext(ForExprContext.class,0);
		}
		public StructDeclExprContext structDeclExpr() {
			return getRuleContext(StructDeclExprContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LineCommentContext lineComment() {
			return getRuleContext(LineCommentContext.class,0);
		}
		public BlankLineContext blankLine() {
			return getRuleContext(BlankLineContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_statement);
		try {
			setState(320);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(303);
				funcDeclExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(304);
				varDeclExpr();
				setState(305);
				match(T__42);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(307);
				forExpr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(308);
				structDeclExpr();
				setState(309);
				match(T__42);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(311);
				ifStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(312);
				returnStatement();
				setState(313);
				match(T__42);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(315);
				expr(0);
				setState(316);
				match(T__42);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(318);
				lineComment();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(319);
				blankLine();
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

	public static class LineCommentContext extends ParserRuleContext {
		public TerminalNode LINE_COMMENT() { return getToken(Lang2Parser.LINE_COMMENT, 0); }
		public LineCommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lineComment; }
	}

	public final LineCommentContext lineComment() throws RecognitionException {
		LineCommentContext _localctx = new LineCommentContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_lineComment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			match(LINE_COMMENT);
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

	public static class BlankLineContext extends ParserRuleContext {
		public TerminalNode BLANK_LINE() { return getToken(Lang2Parser.BLANK_LINE, 0); }
		public BlankLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blankLine; }
	}

	public final BlankLineContext blankLine() throws RecognitionException {
		BlankLineContext _localctx = new BlankLineContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_blankLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			match(BLANK_LINE);
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
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 11:
			return typeExpr_sempred((TypeExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 19);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 8);
		case 8:
			return precpred(_ctx, 7);
		case 9:
			return precpred(_ctx, 6);
		case 10:
			return precpred(_ctx, 5);
		case 11:
			return precpred(_ctx, 4);
		case 12:
			return precpred(_ctx, 18);
		case 13:
			return precpred(_ctx, 17);
		case 14:
			return precpred(_ctx, 16);
		}
		return true;
	}
	private boolean typeExpr_sempred(TypeExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 15:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3;\u0149\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\7\2(\n\2\f\2\16\2+\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\39\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\7\3k\n\3\f\3\16\3n\13\3\3\3\5\3q\n\3\3\3\7\3t\n\3\f\3\16\3w\13"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u0084\n\4\f\4\16\4"+
		"\u0087\13\4\3\4\3\4\3\4\3\4\5\4\u008d\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\7\5\u009a\n\5\f\5\16\5\u009d\13\5\3\5\5\5\u00a0\n\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00ab\n\6\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\7\b\u00b6\n\b\f\b\16\b\u00b9\13\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\7\n\u00c6\n\n\f\n\16\n\u00c9\13\n\3\n\5\n\u00cc"+
		"\n\n\3\n\3\n\3\n\7\n\u00d1\n\n\f\n\16\n\u00d4\13\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\7\13\u00de\n\13\f\13\16\13\u00e1\13\13\3\13\5\13\u00e4"+
		"\n\13\3\13\3\13\3\13\7\13\u00e9\n\13\f\13\16\13\u00ec\13\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00f9\n\f\f\f\16\f\u00fc\13\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\5\r\u0104\n\r\3\r\3\r\3\r\7\r\u0109\n\r\f\r\16"+
		"\r\u010c\13\r\3\16\6\16\u010f\n\16\r\16\16\16\u0110\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0123"+
		"\n\17\f\17\16\17\u0126\13\17\3\17\3\17\3\17\3\17\3\17\5\17\u012d\n\17"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0143\n\21\3\22\3\22\3\23\3\23\3\23"+
		"\2\4\4\30\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\n\3\2\13\f\3"+
		"\2\r\17\3\2\20\21\3\2\22\23\3\2\24\27\3\2\30\31\3\2\37)\3\2\b\t\2\u016b"+
		"\2)\3\2\2\2\48\3\2\2\2\6x\3\2\2\2\b\u0090\3\2\2\2\n\u00aa\3\2\2\2\f\u00ac"+
		"\3\2\2\2\16\u00af\3\2\2\2\20\u00bc\3\2\2\2\22\u00c0\3\2\2\2\24\u00d7\3"+
		"\2\2\2\26\u00ef\3\2\2\2\30\u0103\3\2\2\2\32\u010e\3\2\2\2\34\u0112\3\2"+
		"\2\2\36\u012e\3\2\2\2 \u0142\3\2\2\2\"\u0144\3\2\2\2$\u0146\3\2\2\2&("+
		"\5 \21\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2"+
		",-\7\2\2\3-\3\3\2\2\2./\b\3\1\2/\60\7\3\2\2\60\61\5\4\3\2\61\62\7\4\2"+
		"\2\629\3\2\2\2\63\64\t\2\2\2\649\5\4\3\21\659\5\n\6\2\669\5\22\n\2\67"+
		"9\7\66\2\28.\3\2\2\28\63\3\2\2\28\65\3\2\2\28\66\3\2\2\28\67\3\2\2\29"+
		"u\3\2\2\2:;\f\25\2\2;<\7\5\2\2<t\5\4\3\26=>\f\20\2\2>?\t\3\2\2?t\5\4\3"+
		"\21@A\f\17\2\2AB\t\4\2\2Bt\5\4\3\20CD\f\16\2\2DE\t\5\2\2Et\5\4\3\17FG"+
		"\f\r\2\2GH\t\6\2\2Ht\5\4\3\16IJ\f\f\2\2JK\t\7\2\2Kt\5\4\3\rLM\f\13\2\2"+
		"MN\7\32\2\2Nt\5\4\3\fOP\f\n\2\2PQ\7\33\2\2Qt\5\4\3\13RS\f\t\2\2ST\7\34"+
		"\2\2Tt\5\4\3\nUV\f\b\2\2VW\7\35\2\2Wt\5\4\3\tXY\f\7\2\2YZ\7\36\2\2Zt\5"+
		"\4\3\b[\\\f\6\2\2\\]\t\b\2\2]t\5\4\3\7^_\f\24\2\2_`\7\6\2\2`a\5\4\3\2"+
		"ab\7\7\2\2bt\3\2\2\2cd\f\23\2\2dt\t\t\2\2ef\f\22\2\2fl\7\3\2\2gh\5\4\3"+
		"\2hi\7\n\2\2ik\3\2\2\2jg\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mp\3\2\2"+
		"\2nl\3\2\2\2oq\5\4\3\2po\3\2\2\2pq\3\2\2\2qr\3\2\2\2rt\7\4\2\2s:\3\2\2"+
		"\2s=\3\2\2\2s@\3\2\2\2sC\3\2\2\2sF\3\2\2\2sI\3\2\2\2sL\3\2\2\2sO\3\2\2"+
		"\2sR\3\2\2\2sU\3\2\2\2sX\3\2\2\2s[\3\2\2\2s^\3\2\2\2sc\3\2\2\2se\3\2\2"+
		"\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2v\5\3\2\2\2wu\3\2\2\2xy\7\3\2\2yz\7*\2"+
		"\2z{\7\66\2\2{|\7\4\2\2|\u0085\7+\2\2}~\7\5\2\2~\177\7\66\2\2\177\u0080"+
		"\7\37\2\2\u0080\u0081\5\4\3\2\u0081\u0082\7\n\2\2\u0082\u0084\3\2\2\2"+
		"\u0083}\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3"+
		"\2\2\2\u0086\u008c\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u0089\7\5\2\2\u0089"+
		"\u008a\7\66\2\2\u008a\u008b\7\37\2\2\u008b\u008d\5\4\3\2\u008c\u0088\3"+
		"\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\7,\2\2\u008f"+
		"\7\3\2\2\2\u0090\u0091\7\3\2\2\u0091\u0092\5\30\r\2\u0092\u0093\7\6\2"+
		"\2\u0093\u0094\7\7\2\2\u0094\u0095\7\4\2\2\u0095\u009b\7+\2\2\u0096\u0097"+
		"\5\4\3\2\u0097\u0098\7\n\2\2\u0098\u009a\3\2\2\2\u0099\u0096\3\2\2\2\u009a"+
		"\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009f\3\2"+
		"\2\2\u009d\u009b\3\2\2\2\u009e\u00a0\5\4\3\2\u009f\u009e\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\7,\2\2\u00a2\t\3\2\2\2"+
		"\u00a3\u00ab\5\6\4\2\u00a4\u00ab\5\b\5\2\u00a5\u00ab\7\67\2\2\u00a6\u00ab"+
		"\7\64\2\2\u00a7\u00ab\7\63\2\2\u00a8\u00ab\7\65\2\2\u00a9\u00ab\7\62\2"+
		"\2\u00aa\u00a3\3\2\2\2\u00aa\u00a4\3\2\2\2\u00aa\u00a5\3\2\2\2\u00aa\u00a6"+
		"\3\2\2\2\u00aa\u00a7\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab"+
		"\13\3\2\2\2\u00ac\u00ad\5\30\r\2\u00ad\u00ae\7\66\2\2\u00ae\r\3\2\2\2"+
		"\u00af\u00b0\7*\2\2\u00b0\u00b1\7\66\2\2\u00b1\u00b7\7+\2\2\u00b2\u00b3"+
		"\5\f\7\2\u00b3\u00b4\7-\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00b2\3\2\2\2\u00b6"+
		"\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba\3\2"+
		"\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bb\7,\2\2\u00bb\17\3\2\2\2\u00bc\u00bd"+
		"\5\f\7\2\u00bd\u00be\7\37\2\2\u00be\u00bf\5\4\3\2\u00bf\21\3\2\2\2\u00c0"+
		"\u00c1\5\30\r\2\u00c1\u00c7\7\3\2\2\u00c2\u00c3\5\f\7\2\u00c3\u00c4\7"+
		"\n\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00c2\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2"+
		"\2\2\u00ca\u00cc\5\f\7\2\u00cb\u00ca\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd\u00ce\7\4\2\2\u00ce\u00d2\7+\2\2\u00cf\u00d1\5 \21"+
		"\2\u00d0\u00cf\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3"+
		"\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d6\7,\2\2\u00d6"+
		"\23\3\2\2\2\u00d7\u00d8\5\30\r\2\u00d8\u00d9\7\66\2\2\u00d9\u00df\7\3"+
		"\2\2\u00da\u00db\5\f\7\2\u00db\u00dc\7\n\2\2\u00dc\u00de\3\2\2\2\u00dd"+
		"\u00da\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2"+
		"\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e4\5\f\7\2\u00e3"+
		"\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\7\4"+
		"\2\2\u00e6\u00ea\7+\2\2\u00e7\u00e9\5 \21\2\u00e8\u00e7\3\2\2\2\u00e9"+
		"\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ed\3\2"+
		"\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00ee\7,\2\2\u00ee\25\3\2\2\2\u00ef\u00f0"+
		"\7.\2\2\u00f0\u00f1\7\3\2\2\u00f1\u00f2\5 \21\2\u00f2\u00f3\5\4\3\2\u00f3"+
		"\u00f4\7-\2\2\u00f4\u00f5\5\4\3\2\u00f5\u00f6\7\4\2\2\u00f6\u00fa\7+\2"+
		"\2\u00f7\u00f9\5 \21\2\u00f8\u00f7\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8"+
		"\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd"+
		"\u00fe\7,\2\2\u00fe\27\3\2\2\2\u00ff\u0100\b\r\1\2\u0100\u0101\7*\2\2"+
		"\u0101\u0104\7\66\2\2\u0102\u0104\7\66\2\2\u0103\u00ff\3\2\2\2\u0103\u0102"+
		"\3\2\2\2\u0104\u010a\3\2\2\2\u0105\u0106\f\4\2\2\u0106\u0107\7\6\2\2\u0107"+
		"\u0109\7\7\2\2\u0108\u0105\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2"+
		"\2\2\u010a\u010b\3\2\2\2\u010b\31\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u010f"+
		"\5 \21\2\u010e\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u010e\3\2\2\2\u0110"+
		"\u0111\3\2\2\2\u0111\33\3\2\2\2\u0112\u0113\7/\2\2\u0113\u0114\7\3\2\2"+
		"\u0114\u0115\5\4\3\2\u0115\u0116\7\4\2\2\u0116\u0117\7+\2\2\u0117\u0118"+
		"\5\32\16\2\u0118\u0124\7,\2\2\u0119\u011a\7\60\2\2\u011a\u011b\7/\2\2"+
		"\u011b\u011c\7\3\2\2\u011c\u011d\5\4\3\2\u011d\u011e\7\4\2\2\u011e\u011f"+
		"\7+\2\2\u011f\u0120\5\32\16\2\u0120\u0121\7,\2\2\u0121\u0123\3\2\2\2\u0122"+
		"\u0119\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2"+
		"\2\2\u0125\u012c\3\2\2\2\u0126\u0124\3\2\2\2\u0127\u0128\7\60\2\2\u0128"+
		"\u0129\7+\2\2\u0129\u012a\5\32\16\2\u012a\u012b\7,\2\2\u012b\u012d\3\2"+
		"\2\2\u012c\u0127\3\2\2\2\u012c\u012d\3\2\2\2\u012d\35\3\2\2\2\u012e\u012f"+
		"\7\61\2\2\u012f\u0130\5\4\3\2\u0130\37\3\2\2\2\u0131\u0143\5\24\13\2\u0132"+
		"\u0133\5\20\t\2\u0133\u0134\7-\2\2\u0134\u0143\3\2\2\2\u0135\u0143\5\26"+
		"\f\2\u0136\u0137\5\16\b\2\u0137\u0138\7-\2\2\u0138\u0143\3\2\2\2\u0139"+
		"\u0143\5\34\17\2\u013a\u013b\5\36\20\2\u013b\u013c\7-\2\2\u013c\u0143"+
		"\3\2\2\2\u013d\u013e\5\4\3\2\u013e\u013f\7-\2\2\u013f\u0143\3\2\2\2\u0140"+
		"\u0143\5\"\22\2\u0141\u0143\5$\23\2\u0142\u0131\3\2\2\2\u0142\u0132\3"+
		"\2\2\2\u0142\u0135\3\2\2\2\u0142\u0136\3\2\2\2\u0142\u0139\3\2\2\2\u0142"+
		"\u013a\3\2\2\2\u0142\u013d\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0141\3\2"+
		"\2\2\u0143!\3\2\2\2\u0144\u0145\7:\2\2\u0145#\3\2\2\2\u0146\u0147\7;\2"+
		"\2\u0147%\3\2\2\2\33)8lpsu\u0085\u008c\u009b\u009f\u00aa\u00b7\u00c7\u00cb"+
		"\u00d2\u00df\u00e3\u00ea\u00fa\u0103\u010a\u0110\u0124\u012c\u0142";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}