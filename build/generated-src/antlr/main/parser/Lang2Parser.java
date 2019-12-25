// Generated from parser/Lang2.g4 by ANTLR 4.7.2
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
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

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
		CHR=54, WS=55, LINE_COMMENT=56;
	public static final int
		RULE_program = 0, RULE_expr = 1, RULE_structExpr = 2, RULE_arrayExpr = 3, 
		RULE_literalExpr = 4, RULE_varDecl = 5, RULE_structDeclExpr = 6, RULE_varDeclExpr = 7, 
		RULE_lambdaExpr = 8, RULE_funcDeclExpr = 9, RULE_forExpr = 10, RULE_typeExpr = 11, 
		RULE_ifStatment = 12, RULE_returnStatment = 13, RULE_statment = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expr", "structExpr", "arrayExpr", "literalExpr", "varDecl", 
			"structDeclExpr", "varDeclExpr", "lambdaExpr", "funcDeclExpr", "forExpr", 
			"typeExpr", "ifStatment", "returnStatment", "statment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'.'", "'['", "']'", "'++'", "'--'", "','", "'+'", 
			"'-'", "'!'", "'~'", "'*'", "'/'", "'%'", "'<<'", "'>>'", "'<'", "'<='", 
			"'>'", "'>='", "'=='", "'!='", "'&'", "'|'", "'^'", "'&&'", "'||'", "'='", 
			"'+='", "'-='", "'*='", "'/='", "'%='", "'<<='", "'>>='", "'&='", "'^='", 
			"'|='", "'struct'", "'{'", "'}'", "';'", "'for'", "'if'", "'else'", "'return'", 
			null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"BOOL", "NULL", "NUM", "FLOAT", "ID", "STR", "CHR", "WS", "LINE_COMMENT"
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
		public List<StatmentContext> statment() {
			return getRuleContexts(StatmentContext.class);
		}
		public StatmentContext statment(int i) {
			return getRuleContext(StatmentContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitProgram(this);
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
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__39) | (1L << T__43) | (1L << T__44) | (1L << T__46) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
				{
				{
				setState(30);
				statment();
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitAssignmentExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixExprContext extends ExprContext {
		public Token op;
		public ExprContext varName;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrefixExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitPrefixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(Lang2Parser.ID, 0); }
		public VarExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitVarExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClosureExprContext extends ExprContext {
		public LambdaExprContext lambdaExpr() {
			return getRuleContext(LambdaExprContext.class,0);
		}
		public ClosureExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitClosureExpr(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitDotExpr(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitInfixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncExprContext extends ExprContext {
		public Token func;
		public ExprContext args;
		public TerminalNode ID() { return getToken(Lang2Parser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FuncExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitFuncExpr(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitArraySubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PostfixExprContext extends ExprContext {
		public ExprContext varName;
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PostfixExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitPostfixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LitExprContext extends ExprContext {
		public LiteralExprContext literalExpr() {
			return getRuleContext(LiteralExprContext.class,0);
		}
		public LitExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitLitExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
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
			setState(66);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(39);
				match(T__0);
				setState(40);
				expr(0);
				setState(41);
				match(T__1);
				}
				break;
			case 2:
				{
				_localctx = new FuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(43);
				((FuncExprContext)_localctx).func = match(ID);
				setState(44);
				match(T__0);
				setState(50);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(45);
						((FuncExprContext)_localctx).args = expr(0);
						setState(46);
						match(T__7);
						}
						} 
					}
					setState(52);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__39) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
					{
					setState(53);
					((FuncExprContext)_localctx).args = expr(0);
					}
				}

				setState(56);
				match(T__1);
				}
				break;
			case 3:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(57);
				((PrefixExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__5 || _la==T__6) ) {
					((PrefixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(58);
				((PrefixExprContext)_localctx).varName = expr(17);
				}
				break;
			case 4:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(59);
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
				setState(60);
				((PrefixExprContext)_localctx).varName = expr(16);
				}
				break;
			case 5:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(61);
				((PrefixExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__10 || _la==T__11) ) {
					((PrefixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(62);
				((PrefixExprContext)_localctx).varName = expr(15);
				}
				break;
			case 6:
				{
				_localctx = new LitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(63);
				literalExpr();
				}
				break;
			case 7:
				{
				_localctx = new ClosureExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(64);
				lambdaExpr();
				}
				break;
			case 8:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(113);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(111);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new DotExprContext(new ExprContext(_parentctx, _parentState));
						((DotExprContext)_localctx).varName = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(68);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(69);
						match(T__2);
						setState(70);
						((DotExprContext)_localctx).sub = expr(22);
						}
						break;
					case 2:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(71);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(72);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(73);
						((InfixExprContext)_localctx).right = expr(15);
						}
						break;
					case 3:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(74);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(75);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__8 || _la==T__9) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(76);
						((InfixExprContext)_localctx).right = expr(14);
						}
						break;
					case 4:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(77);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(78);
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
						setState(79);
						((InfixExprContext)_localctx).right = expr(13);
						}
						break;
					case 5:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(80);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(81);
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
						setState(82);
						((InfixExprContext)_localctx).right = expr(12);
						}
						break;
					case 6:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(83);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(84);
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
						setState(85);
						((InfixExprContext)_localctx).right = expr(11);
						}
						break;
					case 7:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(86);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(87);
						((InfixExprContext)_localctx).op = match(T__23);
						setState(88);
						((InfixExprContext)_localctx).right = expr(10);
						}
						break;
					case 8:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(89);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(90);
						((InfixExprContext)_localctx).op = match(T__24);
						setState(91);
						((InfixExprContext)_localctx).right = expr(9);
						}
						break;
					case 9:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(92);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(93);
						((InfixExprContext)_localctx).op = match(T__25);
						setState(94);
						((InfixExprContext)_localctx).right = expr(8);
						}
						break;
					case 10:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(95);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(96);
						((InfixExprContext)_localctx).op = match(T__26);
						setState(97);
						((InfixExprContext)_localctx).right = expr(7);
						}
						break;
					case 11:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(98);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(99);
						((InfixExprContext)_localctx).op = match(T__27);
						setState(100);
						((InfixExprContext)_localctx).right = expr(6);
						}
						break;
					case 12:
						{
						_localctx = new AssignmentExprContext(new ExprContext(_parentctx, _parentState));
						((AssignmentExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(101);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(102);
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
						setState(103);
						((AssignmentExprContext)_localctx).right = expr(5);
						}
						break;
					case 13:
						{
						_localctx = new ArraySubExprContext(new ExprContext(_parentctx, _parentState));
						((ArraySubExprContext)_localctx).varName = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(104);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(105);
						match(T__3);
						setState(106);
						((ArraySubExprContext)_localctx).sub = expr(0);
						setState(107);
						match(T__4);
						}
						break;
					case 14:
						{
						_localctx = new PostfixExprContext(new ExprContext(_parentctx, _parentState));
						((PostfixExprContext)_localctx).varName = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(109);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(110);
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
					}
					} 
				}
				setState(115);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitStructExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructExprContext structExpr() throws RecognitionException {
		StructExprContext _localctx = new StructExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_structExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(T__0);
			setState(117);
			match(T__39);
			setState(118);
			((StructExprContext)_localctx).name = match(ID);
			setState(119);
			match(T__1);
			setState(120);
			match(T__40);
			setState(129);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(121);
					match(T__2);
					setState(122);
					((StructExprContext)_localctx).field = match(ID);
					setState(123);
					match(T__28);
					setState(124);
					((StructExprContext)_localctx).value = expr(0);
					setState(125);
					match(T__7);
					}
					} 
				}
				setState(131);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(132);
				match(T__2);
				setState(133);
				((StructExprContext)_localctx).field = match(ID);
				setState(134);
				match(T__28);
				setState(135);
				((StructExprContext)_localctx).value = expr(0);
				}
			}

			setState(138);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayExprContext arrayExpr() throws RecognitionException {
		ArrayExprContext _localctx = new ArrayExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_arrayExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(T__0);
			setState(141);
			((ArrayExprContext)_localctx).type = typeExpr(0);
			setState(142);
			match(T__3);
			setState(143);
			match(T__4);
			setState(144);
			match(T__1);
			setState(145);
			match(T__40);
			setState(151);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(146);
					((ArrayExprContext)_localctx).value = expr(0);
					setState(147);
					match(T__7);
					}
					} 
				}
				setState(153);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__39) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
				{
				setState(154);
				((ArrayExprContext)_localctx).value = expr(0);
				}
			}

			setState(157);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitStrLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StructLiteralContext extends LiteralExprContext {
		public StructExprContext structExpr() {
			return getRuleContext(StructExprContext.class,0);
		}
		public StructLiteralContext(LiteralExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitStructLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullLiteralContext extends LiteralExprContext {
		public Token value;
		public TerminalNode NULL() { return getToken(Lang2Parser.NULL, 0); }
		public NullLiteralContext(LiteralExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitNullLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayLiteralContext extends LiteralExprContext {
		public ArrayExprContext arrayExpr() {
			return getRuleContext(ArrayExprContext.class,0);
		}
		public ArrayLiteralContext(LiteralExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitArrayLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumLiteralContext extends LiteralExprContext {
		public Token value;
		public TerminalNode NUM() { return getToken(Lang2Parser.NUM, 0); }
		public NumLiteralContext(LiteralExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitNumLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatLiteralContext extends LiteralExprContext {
		public Token value;
		public TerminalNode FLOAT() { return getToken(Lang2Parser.FLOAT, 0); }
		public FloatLiteralContext(LiteralExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitFloatLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanLiteralContext extends LiteralExprContext {
		public Token value;
		public TerminalNode BOOL() { return getToken(Lang2Parser.BOOL, 0); }
		public BooleanLiteralContext(LiteralExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralExprContext literalExpr() throws RecognitionException {
		LiteralExprContext _localctx = new LiteralExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_literalExpr);
		try {
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new StructLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				structExpr();
				}
				break;
			case 2:
				_localctx = new ArrayLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				arrayExpr();
				}
				break;
			case 3:
				_localctx = new StrLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(161);
				((StrLiteralContext)_localctx).value = match(STR);
				}
				break;
			case 4:
				_localctx = new NumLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(162);
				((NumLiteralContext)_localctx).value = match(NUM);
				}
				break;
			case 5:
				_localctx = new NullLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(163);
				((NullLiteralContext)_localctx).value = match(NULL);
				}
				break;
			case 6:
				_localctx = new FloatLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(164);
				((FloatLiteralContext)_localctx).value = match(FLOAT);
				}
				break;
			case 7:
				_localctx = new BooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(165);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			((VarDeclContext)_localctx).type = typeExpr(0);
			setState(169);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitStructDeclExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDeclExprContext structDeclExpr() throws RecognitionException {
		StructDeclExprContext _localctx = new StructDeclExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_structDeclExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(T__39);
			setState(172);
			((StructDeclExprContext)_localctx).name = match(ID);
			setState(173);
			match(T__40);
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__39 || _la==ID) {
				{
				{
				setState(174);
				((StructDeclExprContext)_localctx).fields = varDecl();
				setState(175);
				match(T__42);
				}
				}
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(182);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitVarDeclExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclExprContext varDeclExpr() throws RecognitionException {
		VarDeclExprContext _localctx = new VarDeclExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_varDeclExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			((VarDeclExprContext)_localctx).var = varDecl();
			setState(185);
			match(T__28);
			setState(186);
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
		public StatmentContext body;
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<StatmentContext> statment() {
			return getRuleContexts(StatmentContext.class);
		}
		public StatmentContext statment(int i) {
			return getRuleContext(StatmentContext.class,i);
		}
		public LambdaExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitLambdaExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaExprContext lambdaExpr() throws RecognitionException {
		LambdaExprContext _localctx = new LambdaExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_lambdaExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			((LambdaExprContext)_localctx).ret_type = typeExpr(0);
			setState(189);
			match(T__0);
			setState(195);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(190);
					((LambdaExprContext)_localctx).args = varDecl();
					setState(191);
					match(T__7);
					}
					} 
				}
				setState(197);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__39 || _la==ID) {
				{
				setState(198);
				((LambdaExprContext)_localctx).args = varDecl();
				}
			}

			setState(201);
			match(T__1);
			setState(202);
			match(T__40);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__39) | (1L << T__43) | (1L << T__44) | (1L << T__46) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
				{
				{
				setState(203);
				((LambdaExprContext)_localctx).body = statment();
				}
				}
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(209);
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
		public StatmentContext body;
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
		public List<StatmentContext> statment() {
			return getRuleContexts(StatmentContext.class);
		}
		public StatmentContext statment(int i) {
			return getRuleContext(StatmentContext.class,i);
		}
		public FuncDeclExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDeclExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitFuncDeclExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDeclExprContext funcDeclExpr() throws RecognitionException {
		FuncDeclExprContext _localctx = new FuncDeclExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funcDeclExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			((FuncDeclExprContext)_localctx).ret_type = typeExpr(0);
			setState(212);
			((FuncDeclExprContext)_localctx).name = match(ID);
			setState(213);
			match(T__0);
			setState(219);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(214);
					((FuncDeclExprContext)_localctx).args = varDecl();
					setState(215);
					match(T__7);
					}
					} 
				}
				setState(221);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__39 || _la==ID) {
				{
				setState(222);
				((FuncDeclExprContext)_localctx).args = varDecl();
				}
			}

			setState(225);
			match(T__1);
			setState(226);
			match(T__40);
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__39) | (1L << T__43) | (1L << T__44) | (1L << T__46) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
				{
				{
				setState(227);
				((FuncDeclExprContext)_localctx).body = statment();
				}
				}
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(233);
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
		public StatmentContext initial;
		public ExprContext cond;
		public ExprContext end;
		public StatmentContext body;
		public List<StatmentContext> statment() {
			return getRuleContexts(StatmentContext.class);
		}
		public StatmentContext statment(int i) {
			return getRuleContext(StatmentContext.class,i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitForExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForExprContext forExpr() throws RecognitionException {
		ForExprContext _localctx = new ForExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_forExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(T__43);
			setState(236);
			match(T__0);
			setState(237);
			((ForExprContext)_localctx).initial = statment();
			setState(238);
			((ForExprContext)_localctx).cond = expr(0);
			setState(239);
			match(T__42);
			setState(240);
			((ForExprContext)_localctx).end = expr(0);
			setState(241);
			match(T__1);
			setState(242);
			match(T__40);
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__39) | (1L << T__43) | (1L << T__44) | (1L << T__46) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
				{
				{
				setState(243);
				((ForExprContext)_localctx).body = statment();
				}
				}
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(249);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitArrayTypeExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StructTypeExprContext extends TypeExprContext {
		public Token name;
		public TerminalNode ID() { return getToken(Lang2Parser.ID, 0); }
		public StructTypeExprContext(TypeExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitStructTypeExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlainTypeContext extends TypeExprContext {
		public Token type;
		public TerminalNode ID() { return getToken(Lang2Parser.ID, 0); }
		public PlainTypeContext(TypeExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitPlainType(this);
			else return visitor.visitChildren(this);
		}
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
			setState(255);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__39:
				{
				_localctx = new StructTypeExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(252);
				match(T__39);
				setState(253);
				((StructTypeExprContext)_localctx).name = match(ID);
				}
				break;
			case ID:
				{
				_localctx = new PlainTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(254);
				((PlainTypeContext)_localctx).type = match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(262);
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
					setState(257);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(258);
					match(T__3);
					setState(259);
					match(T__4);
					}
					} 
				}
				setState(264);
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

	public static class IfStatmentContext extends ParserRuleContext {
		public ExprContext cond;
		public StatmentContext body;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<StatmentContext> statment() {
			return getRuleContexts(StatmentContext.class);
		}
		public StatmentContext statment(int i) {
			return getRuleContext(StatmentContext.class,i);
		}
		public IfStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitIfStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatmentContext ifStatment() throws RecognitionException {
		IfStatmentContext _localctx = new IfStatmentContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifStatment);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(T__44);
			setState(266);
			match(T__0);
			setState(267);
			((IfStatmentContext)_localctx).cond = expr(0);
			setState(268);
			match(T__1);
			setState(269);
			match(T__40);
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__39) | (1L << T__43) | (1L << T__44) | (1L << T__46) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
				{
				{
				setState(270);
				((IfStatmentContext)_localctx).body = statment();
				}
				}
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(276);
			match(T__41);
			setState(293);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(277);
					match(T__45);
					setState(278);
					match(T__44);
					setState(279);
					match(T__0);
					setState(280);
					((IfStatmentContext)_localctx).cond = expr(0);
					setState(281);
					match(T__1);
					setState(282);
					match(T__40);
					setState(286);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__39) | (1L << T__43) | (1L << T__44) | (1L << T__46) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
						{
						{
						setState(283);
						((IfStatmentContext)_localctx).body = statment();
						}
						}
						setState(288);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(289);
					match(T__41);
					}
					} 
				}
				setState(295);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__45) {
				{
				setState(296);
				match(T__45);
				setState(297);
				match(T__40);
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__39) | (1L << T__43) | (1L << T__44) | (1L << T__46) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
					{
					{
					setState(298);
					((IfStatmentContext)_localctx).body = statment();
					}
					}
					setState(303);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(304);
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

	public static class ReturnStatmentContext extends ParserRuleContext {
		public ExprContext value;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitReturnStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatmentContext returnStatment() throws RecognitionException {
		ReturnStatmentContext _localctx = new ReturnStatmentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_returnStatment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			match(T__46);
			setState(308);
			((ReturnStatmentContext)_localctx).value = expr(0);
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

	public static class StatmentContext extends ParserRuleContext {
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
		public IfStatmentContext ifStatment() {
			return getRuleContext(IfStatmentContext.class,0);
		}
		public ReturnStatmentContext returnStatment() {
			return getRuleContext(ReturnStatmentContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang2Visitor ) return ((Lang2Visitor<? extends T>)visitor).visitStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatmentContext statment() throws RecognitionException {
		StatmentContext _localctx = new StatmentContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_statment);
		try {
			setState(325);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(310);
				funcDeclExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(311);
				varDeclExpr();
				setState(312);
				match(T__42);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(314);
				forExpr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(315);
				structDeclExpr();
				setState(316);
				match(T__42);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(318);
				ifStatment();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(319);
				returnStatment();
				setState(320);
				match(T__42);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(322);
				expr(0);
				setState(323);
				match(T__42);
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
			return precpred(_ctx, 21);
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
			return precpred(_ctx, 20);
		case 13:
			return precpred(_ctx, 19);
		}
		return true;
	}
	private boolean typeExpr_sempred(TypeExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 14:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3:\u014a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\7\2\"\n\2\f\2\16"+
		"\2%\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\63\n\3\f"+
		"\3\16\3\66\13\3\3\3\5\39\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5"+
		"\3E\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3r\n\3\f\3\16\3u\13\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u0082\n\4\f\4\16\4\u0085\13"+
		"\4\3\4\3\4\3\4\3\4\5\4\u008b\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\7\5\u0098\n\5\f\5\16\5\u009b\13\5\3\5\5\5\u009e\n\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00a9\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\7\b\u00b4\n\b\f\b\16\b\u00b7\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\7\n\u00c4\n\n\f\n\16\n\u00c7\13\n\3\n\5\n\u00ca\n\n\3\n\3"+
		"\n\3\n\7\n\u00cf\n\n\f\n\16\n\u00d2\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\7\13\u00dc\n\13\f\13\16\13\u00df\13\13\3\13\5\13\u00e2\n\13\3"+
		"\13\3\13\3\13\7\13\u00e7\n\13\f\13\16\13\u00ea\13\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00f7\n\f\f\f\16\f\u00fa\13\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\5\r\u0102\n\r\3\r\3\r\3\r\7\r\u0107\n\r\f\r\16\r\u010a"+
		"\13\r\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0112\n\16\f\16\16\16\u0115\13"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u011f\n\16\f\16\16\16"+
		"\u0122\13\16\3\16\3\16\7\16\u0126\n\16\f\16\16\16\u0129\13\16\3\16\3\16"+
		"\3\16\7\16\u012e\n\16\f\16\16\16\u0131\13\16\3\16\5\16\u0134\n\16\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u0148\n\20\3\20\2\4\4\30\21\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36\2\n\3\2\b\t\3\2\13\f\3\2\r\16\3\2\17\21\3\2\22\23\3"+
		"\2\24\27\3\2\30\31\3\2\37)\2\u0171\2#\3\2\2\2\4D\3\2\2\2\6v\3\2\2\2\b"+
		"\u008e\3\2\2\2\n\u00a8\3\2\2\2\f\u00aa\3\2\2\2\16\u00ad\3\2\2\2\20\u00ba"+
		"\3\2\2\2\22\u00be\3\2\2\2\24\u00d5\3\2\2\2\26\u00ed\3\2\2\2\30\u0101\3"+
		"\2\2\2\32\u010b\3\2\2\2\34\u0135\3\2\2\2\36\u0147\3\2\2\2 \"\5\36\20\2"+
		"! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$&\3\2\2\2%#\3\2\2\2&\'\7\2\2"+
		"\3\'\3\3\2\2\2()\b\3\1\2)*\7\3\2\2*+\5\4\3\2+,\7\4\2\2,E\3\2\2\2-.\7\66"+
		"\2\2.\64\7\3\2\2/\60\5\4\3\2\60\61\7\n\2\2\61\63\3\2\2\2\62/\3\2\2\2\63"+
		"\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\679"+
		"\5\4\3\28\67\3\2\2\289\3\2\2\29:\3\2\2\2:E\7\4\2\2;<\t\2\2\2<E\5\4\3\23"+
		"=>\t\3\2\2>E\5\4\3\22?@\t\4\2\2@E\5\4\3\21AE\5\n\6\2BE\5\22\n\2CE\7\66"+
		"\2\2D(\3\2\2\2D-\3\2\2\2D;\3\2\2\2D=\3\2\2\2D?\3\2\2\2DA\3\2\2\2DB\3\2"+
		"\2\2DC\3\2\2\2Es\3\2\2\2FG\f\27\2\2GH\7\5\2\2Hr\5\4\3\30IJ\f\20\2\2JK"+
		"\t\5\2\2Kr\5\4\3\21LM\f\17\2\2MN\t\3\2\2Nr\5\4\3\20OP\f\16\2\2PQ\t\6\2"+
		"\2Qr\5\4\3\17RS\f\r\2\2ST\t\7\2\2Tr\5\4\3\16UV\f\f\2\2VW\t\b\2\2Wr\5\4"+
		"\3\rXY\f\13\2\2YZ\7\32\2\2Zr\5\4\3\f[\\\f\n\2\2\\]\7\33\2\2]r\5\4\3\13"+
		"^_\f\t\2\2_`\7\34\2\2`r\5\4\3\nab\f\b\2\2bc\7\35\2\2cr\5\4\3\tde\f\7\2"+
		"\2ef\7\36\2\2fr\5\4\3\bgh\f\6\2\2hi\t\t\2\2ir\5\4\3\7jk\f\26\2\2kl\7\6"+
		"\2\2lm\5\4\3\2mn\7\7\2\2nr\3\2\2\2op\f\25\2\2pr\t\2\2\2qF\3\2\2\2qI\3"+
		"\2\2\2qL\3\2\2\2qO\3\2\2\2qR\3\2\2\2qU\3\2\2\2qX\3\2\2\2q[\3\2\2\2q^\3"+
		"\2\2\2qa\3\2\2\2qd\3\2\2\2qg\3\2\2\2qj\3\2\2\2qo\3\2\2\2ru\3\2\2\2sq\3"+
		"\2\2\2st\3\2\2\2t\5\3\2\2\2us\3\2\2\2vw\7\3\2\2wx\7*\2\2xy\7\66\2\2yz"+
		"\7\4\2\2z\u0083\7+\2\2{|\7\5\2\2|}\7\66\2\2}~\7\37\2\2~\177\5\4\3\2\177"+
		"\u0080\7\n\2\2\u0080\u0082\3\2\2\2\u0081{\3\2\2\2\u0082\u0085\3\2\2\2"+
		"\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u008a\3\2\2\2\u0085\u0083"+
		"\3\2\2\2\u0086\u0087\7\5\2\2\u0087\u0088\7\66\2\2\u0088\u0089\7\37\2\2"+
		"\u0089\u008b\5\4\3\2\u008a\u0086\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c"+
		"\3\2\2\2\u008c\u008d\7,\2\2\u008d\7\3\2\2\2\u008e\u008f\7\3\2\2\u008f"+
		"\u0090\5\30\r\2\u0090\u0091\7\6\2\2\u0091\u0092\7\7\2\2\u0092\u0093\7"+
		"\4\2\2\u0093\u0099\7+\2\2\u0094\u0095\5\4\3\2\u0095\u0096\7\n\2\2\u0096"+
		"\u0098\3\2\2\2\u0097\u0094\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2"+
		"\2\2\u0099\u009a\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009c"+
		"\u009e\5\4\3\2\u009d\u009c\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2"+
		"\2\2\u009f\u00a0\7,\2\2\u00a0\t\3\2\2\2\u00a1\u00a9\5\6\4\2\u00a2\u00a9"+
		"\5\b\5\2\u00a3\u00a9\7\67\2\2\u00a4\u00a9\7\64\2\2\u00a5\u00a9\7\63\2"+
		"\2\u00a6\u00a9\7\65\2\2\u00a7\u00a9\7\62\2\2\u00a8\u00a1\3\2\2\2\u00a8"+
		"\u00a2\3\2\2\2\u00a8\u00a3\3\2\2\2\u00a8\u00a4\3\2\2\2\u00a8\u00a5\3\2"+
		"\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9\13\3\2\2\2\u00aa\u00ab"+
		"\5\30\r\2\u00ab\u00ac\7\66\2\2\u00ac\r\3\2\2\2\u00ad\u00ae\7*\2\2\u00ae"+
		"\u00af\7\66\2\2\u00af\u00b5\7+\2\2\u00b0\u00b1\5\f\7\2\u00b1\u00b2\7-"+
		"\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b0\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00b5\3\2"+
		"\2\2\u00b8\u00b9\7,\2\2\u00b9\17\3\2\2\2\u00ba\u00bb\5\f\7\2\u00bb\u00bc"+
		"\7\37\2\2\u00bc\u00bd\5\4\3\2\u00bd\21\3\2\2\2\u00be\u00bf\5\30\r\2\u00bf"+
		"\u00c5\7\3\2\2\u00c0\u00c1\5\f\7\2\u00c1\u00c2\7\n\2\2\u00c2\u00c4\3\2"+
		"\2\2\u00c3\u00c0\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00ca\5\f"+
		"\7\2\u00c9\u00c8\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00cc\7\4\2\2\u00cc\u00d0\7+\2\2\u00cd\u00cf\5\36\20\2\u00ce\u00cd\3"+
		"\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00d3\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d4\7,\2\2\u00d4\23\3\2\2\2"+
		"\u00d5\u00d6\5\30\r\2\u00d6\u00d7\7\66\2\2\u00d7\u00dd\7\3\2\2\u00d8\u00d9"+
		"\5\f\7\2\u00d9\u00da\7\n\2\2\u00da\u00dc\3\2\2\2\u00db\u00d8\3\2\2\2\u00dc"+
		"\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e1\3\2"+
		"\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e2\5\f\7\2\u00e1\u00e0\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\7\4\2\2\u00e4\u00e8\7+"+
		"\2\2\u00e5\u00e7\5\36\20\2\u00e6\u00e5\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8"+
		"\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e8\3\2"+
		"\2\2\u00eb\u00ec\7,\2\2\u00ec\25\3\2\2\2\u00ed\u00ee\7.\2\2\u00ee\u00ef"+
		"\7\3\2\2\u00ef\u00f0\5\36\20\2\u00f0\u00f1\5\4\3\2\u00f1\u00f2\7-\2\2"+
		"\u00f2\u00f3\5\4\3\2\u00f3\u00f4\7\4\2\2\u00f4\u00f8\7+\2\2\u00f5\u00f7"+
		"\5\36\20\2\u00f6\u00f5\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2"+
		"\u00f8\u00f9\3\2\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fc"+
		"\7,\2\2\u00fc\27\3\2\2\2\u00fd\u00fe\b\r\1\2\u00fe\u00ff\7*\2\2\u00ff"+
		"\u0102\7\66\2\2\u0100\u0102\7\66\2\2\u0101\u00fd\3\2\2\2\u0101\u0100\3"+
		"\2\2\2\u0102\u0108\3\2\2\2\u0103\u0104\f\4\2\2\u0104\u0105\7\6\2\2\u0105"+
		"\u0107\7\7\2\2\u0106\u0103\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2"+
		"\2\2\u0108\u0109\3\2\2\2\u0109\31\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u010c"+
		"\7/\2\2\u010c\u010d\7\3\2\2\u010d\u010e\5\4\3\2\u010e\u010f\7\4\2\2\u010f"+
		"\u0113\7+\2\2\u0110\u0112\5\36\20\2\u0111\u0110\3\2\2\2\u0112\u0115\3"+
		"\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0116\3\2\2\2\u0115"+
		"\u0113\3\2\2\2\u0116\u0127\7,\2\2\u0117\u0118\7\60\2\2\u0118\u0119\7/"+
		"\2\2\u0119\u011a\7\3\2\2\u011a\u011b\5\4\3\2\u011b\u011c\7\4\2\2\u011c"+
		"\u0120\7+\2\2\u011d\u011f\5\36\20\2\u011e\u011d\3\2\2\2\u011f\u0122\3"+
		"\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0123\3\2\2\2\u0122"+
		"\u0120\3\2\2\2\u0123\u0124\7,\2\2\u0124\u0126\3\2\2\2\u0125\u0117\3\2"+
		"\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128"+
		"\u0133\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012b\7\60\2\2\u012b\u012f\7"+
		"+\2\2\u012c\u012e\5\36\20\2\u012d\u012c\3\2\2\2\u012e\u0131\3\2\2\2\u012f"+
		"\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0132\3\2\2\2\u0131\u012f\3\2"+
		"\2\2\u0132\u0134\7,\2\2\u0133\u012a\3\2\2\2\u0133\u0134\3\2\2\2\u0134"+
		"\33\3\2\2\2\u0135\u0136\7\61\2\2\u0136\u0137\5\4\3\2\u0137\35\3\2\2\2"+
		"\u0138\u0148\5\24\13\2\u0139\u013a\5\20\t\2\u013a\u013b\7-\2\2\u013b\u0148"+
		"\3\2\2\2\u013c\u0148\5\26\f\2\u013d\u013e\5\16\b\2\u013e\u013f\7-\2\2"+
		"\u013f\u0148\3\2\2\2\u0140\u0148\5\32\16\2\u0141\u0142\5\34\17\2\u0142"+
		"\u0143\7-\2\2\u0143\u0148\3\2\2\2\u0144\u0145\5\4\3\2\u0145\u0146\7-\2"+
		"\2\u0146\u0148\3\2\2\2\u0147\u0138\3\2\2\2\u0147\u0139\3\2\2\2\u0147\u013c"+
		"\3\2\2\2\u0147\u013d\3\2\2\2\u0147\u0140\3\2\2\2\u0147\u0141\3\2\2\2\u0147"+
		"\u0144\3\2\2\2\u0148\37\3\2\2\2\35#\648Dqs\u0083\u008a\u0099\u009d\u00a8"+
		"\u00b5\u00c5\u00c9\u00d0\u00dd\u00e1\u00e8\u00f8\u0101\u0108\u0113\u0120"+
		"\u0127\u012f\u0133\u0147";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}