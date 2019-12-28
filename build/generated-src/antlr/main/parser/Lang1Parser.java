// Generated from parser/Lang1.g4 by ANTLR 4.7.2

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
public class Lang1Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, BOOL=36, NULL=37, NUM=38, FLOAT=39, 
		ID=40, STR=41, CHR=42, WS=43, LINE_COMMENT=44;
	public static final int
		RULE_program = 0, RULE_funcName = 1, RULE_funcCallExpr = 2, RULE_structExpr = 3, 
		RULE_arrayExpr = 4, RULE_literalExpr = 5, RULE_varDecl = 6, RULE_structDeclExpr = 7, 
		RULE_varDeclExpr = 8, RULE_lambdaExpr = 9, RULE_funcDeclExpr = 10, RULE_forExpr = 11, 
		RULE_typeExpr = 12, RULE_varExpr = 13, RULE_condEntry = 14, RULE_condExpr = 15, 
		RULE_assignExpr = 16, RULE_expr = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "funcName", "funcCallExpr", "structExpr", "arrayExpr", "literalExpr", 
			"varDecl", "structDeclExpr", "varDeclExpr", "lambdaExpr", "funcDeclExpr", 
			"forExpr", "typeExpr", "varExpr", "condEntry", "condExpr", "assignExpr", 
			"expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'%'", "'>>'", "'<<'", "'>='", "'<='", 
			"'>'", "'<'", "'=='", "'!='", "'&&'", "'||'", "'|'", "'&'", "'^'", "'~'", 
			"'!'", "'.'", "'++'", "'--'", "'[]'", "'('", "')'", "'struct'", "'array'", 
			"'defstruct'", "'setq'", "'lambda'", "'defun'", "'for'", "'cond'", "'='", 
			null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
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
	public String getGrammarFileName() { return "Lang1.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Lang1Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Lang1Parser.EOF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitProgram(this);
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
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
				{
				{
				setState(36);
				expr();
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

	public static class FuncNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Lang1Parser.ID, 0); }
		public FuncNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitFuncName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncNameContext funcName() throws RecognitionException {
		FuncNameContext _localctx = new FuncNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funcName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << ID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class FuncCallExprContext extends ParserRuleContext {
		public ExprContext func;
		public ExprContext args;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FuncCallExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCallExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitFuncCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallExprContext funcCallExpr() throws RecognitionException {
		FuncCallExprContext _localctx = new FuncCallExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcCallExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(T__24);
			setState(47);
			((FuncCallExprContext)_localctx).func = expr();
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
				{
				{
				setState(48);
				((FuncCallExprContext)_localctx).args = expr();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			match(T__25);
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

	public static class StructExprContext extends ParserRuleContext {
		public Token name;
		public Token field;
		public ExprContext value;
		public List<TerminalNode> ID() { return getTokens(Lang1Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Lang1Parser.ID, i);
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
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitStructExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructExprContext structExpr() throws RecognitionException {
		StructExprContext _localctx = new StructExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_structExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(T__24);
			setState(57);
			match(T__26);
			setState(58);
			((StructExprContext)_localctx).name = match(ID);
			setState(59);
			match(T__24);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(60);
				match(T__24);
				setState(61);
				((StructExprContext)_localctx).field = match(ID);
				setState(62);
				((StructExprContext)_localctx).value = expr();
				setState(63);
				match(T__25);
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(70);
			match(T__25);
			setState(71);
			match(T__25);
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
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayExprContext arrayExpr() throws RecognitionException {
		ArrayExprContext _localctx = new ArrayExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arrayExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(T__24);
			setState(74);
			match(T__27);
			setState(75);
			((ArrayExprContext)_localctx).type = typeExpr();
			setState(76);
			match(T__24);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
				{
				{
				setState(77);
				((ArrayExprContext)_localctx).value = expr();
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(83);
			match(T__25);
			setState(84);
			match(T__25);
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
		public TerminalNode STR() { return getToken(Lang1Parser.STR, 0); }
		public StrLiteralContext(LiteralExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitStrLiteral(this);
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
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitStructLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullLiteralContext extends LiteralExprContext {
		public Token value;
		public TerminalNode NULL() { return getToken(Lang1Parser.NULL, 0); }
		public NullLiteralContext(LiteralExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitNullLiteral(this);
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
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitArrayLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumLiteralContext extends LiteralExprContext {
		public Token value;
		public TerminalNode NUM() { return getToken(Lang1Parser.NUM, 0); }
		public NumLiteralContext(LiteralExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitNumLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatLiteralContext extends LiteralExprContext {
		public Token value;
		public TerminalNode FLOAT() { return getToken(Lang1Parser.FLOAT, 0); }
		public FloatLiteralContext(LiteralExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitFloatLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanLiteralContext extends LiteralExprContext {
		public Token value;
		public TerminalNode BOOL() { return getToken(Lang1Parser.BOOL, 0); }
		public BooleanLiteralContext(LiteralExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralExprContext literalExpr() throws RecognitionException {
		LiteralExprContext _localctx = new LiteralExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_literalExpr);
		try {
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new StructLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				structExpr();
				}
				break;
			case 2:
				_localctx = new ArrayLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				arrayExpr();
				}
				break;
			case 3:
				_localctx = new StrLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				((StrLiteralContext)_localctx).value = match(STR);
				}
				break;
			case 4:
				_localctx = new NumLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(89);
				((NumLiteralContext)_localctx).value = match(NUM);
				}
				break;
			case 5:
				_localctx = new NullLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(90);
				((NullLiteralContext)_localctx).value = match(NULL);
				}
				break;
			case 6:
				_localctx = new FloatLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(91);
				((FloatLiteralContext)_localctx).value = match(FLOAT);
				}
				break;
			case 7:
				_localctx = new BooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(92);
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
		public Token name;
		public TypeExprContext type;
		public TerminalNode ID() { return getToken(Lang1Parser.ID, 0); }
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__24);
			setState(96);
			((VarDeclContext)_localctx).name = match(ID);
			setState(97);
			((VarDeclContext)_localctx).type = typeExpr();
			setState(98);
			match(T__25);
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
		public TerminalNode ID() { return getToken(Lang1Parser.ID, 0); }
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
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitStructDeclExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDeclExprContext structDeclExpr() throws RecognitionException {
		StructDeclExprContext _localctx = new StructDeclExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_structDeclExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__24);
			setState(101);
			match(T__28);
			setState(102);
			((StructDeclExprContext)_localctx).name = match(ID);
			setState(103);
			match(T__24);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(104);
				((StructDeclExprContext)_localctx).fields = varDecl();
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(110);
			match(T__25);
			setState(111);
			match(T__25);
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
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitVarDeclExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclExprContext varDeclExpr() throws RecognitionException {
		VarDeclExprContext _localctx = new VarDeclExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_varDeclExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(T__24);
			setState(114);
			match(T__29);
			setState(115);
			((VarDeclExprContext)_localctx).var = varDecl();
			setState(116);
			((VarDeclExprContext)_localctx).value = expr();
			setState(117);
			match(T__25);
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
		public ExprContext body;
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LambdaExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitLambdaExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaExprContext lambdaExpr() throws RecognitionException {
		LambdaExprContext _localctx = new LambdaExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_lambdaExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__24);
			setState(120);
			match(T__30);
			setState(121);
			((LambdaExprContext)_localctx).ret_type = typeExpr();
			setState(122);
			match(T__24);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(123);
				((LambdaExprContext)_localctx).args = varDecl();
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(129);
			match(T__25);
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
				{
				{
				setState(130);
				((LambdaExprContext)_localctx).body = expr();
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136);
			match(T__25);
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
		public Token name;
		public TypeExprContext ret_type;
		public VarDeclContext args;
		public ExprContext body;
		public TerminalNode ID() { return getToken(Lang1Parser.ID, 0); }
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FuncDeclExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDeclExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitFuncDeclExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDeclExprContext funcDeclExpr() throws RecognitionException {
		FuncDeclExprContext _localctx = new FuncDeclExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funcDeclExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__24);
			setState(139);
			match(T__31);
			setState(140);
			((FuncDeclExprContext)_localctx).name = match(ID);
			setState(141);
			((FuncDeclExprContext)_localctx).ret_type = typeExpr();
			setState(142);
			match(T__24);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(143);
				((FuncDeclExprContext)_localctx).args = varDecl();
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(149);
			match(T__25);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
				{
				{
				setState(150);
				((FuncDeclExprContext)_localctx).body = expr();
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(156);
			match(T__25);
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
		public ExprContext initial;
		public ExprContext cond;
		public ExprContext end;
		public ExprContext body;
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
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitForExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForExprContext forExpr() throws RecognitionException {
		ForExprContext _localctx = new ForExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_forExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(T__24);
			setState(159);
			match(T__32);
			setState(160);
			((ForExprContext)_localctx).initial = expr();
			setState(161);
			((ForExprContext)_localctx).cond = expr();
			setState(162);
			((ForExprContext)_localctx).end = expr();
			setState(163);
			match(T__24);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
				{
				{
				setState(164);
				((ForExprContext)_localctx).body = expr();
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170);
			match(T__25);
			setState(171);
			match(T__25);
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
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitArrayTypeExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StructTypeExprContext extends TypeExprContext {
		public Token name;
		public TerminalNode ID() { return getToken(Lang1Parser.ID, 0); }
		public StructTypeExprContext(TypeExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitStructTypeExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlainTypeContext extends TypeExprContext {
		public Token type;
		public TerminalNode ID() { return getToken(Lang1Parser.ID, 0); }
		public PlainTypeContext(TypeExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitPlainType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeExprContext typeExpr() throws RecognitionException {
		TypeExprContext _localctx = new TypeExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_typeExpr);
		try {
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new StructTypeExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				match(T__24);
				setState(174);
				match(T__26);
				setState(175);
				((StructTypeExprContext)_localctx).name = match(ID);
				setState(176);
				match(T__25);
				}
				break;
			case 2:
				_localctx = new ArrayTypeExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(T__24);
				setState(178);
				match(T__27);
				setState(179);
				((ArrayTypeExprContext)_localctx).type = typeExpr();
				setState(180);
				match(T__25);
				}
				break;
			case 3:
				_localctx = new PlainTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(182);
				((PlainTypeContext)_localctx).type = match(ID);
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

	public static class VarExprContext extends ParserRuleContext {
		public FuncNameContext funcName() {
			return getRuleContext(FuncNameContext.class,0);
		}
		public VarExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitVarExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarExprContext varExpr() throws RecognitionException {
		VarExprContext _localctx = new VarExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_varExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			funcName();
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

	public static class CondEntryContext extends ParserRuleContext {
		public ExprContext cond;
		public ExprContext body;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CondEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condEntry; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitCondEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondEntryContext condEntry() throws RecognitionException {
		CondEntryContext _localctx = new CondEntryContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_condEntry);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(T__24);
			setState(188);
			((CondEntryContext)_localctx).cond = expr();
			setState(189);
			match(T__24);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
				{
				{
				setState(190);
				((CondEntryContext)_localctx).body = expr();
				}
				}
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(196);
			match(T__25);
			setState(197);
			match(T__25);
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

	public static class CondExprContext extends ParserRuleContext {
		public List<CondEntryContext> condEntry() {
			return getRuleContexts(CondEntryContext.class);
		}
		public CondEntryContext condEntry(int i) {
			return getRuleContext(CondEntryContext.class,i);
		}
		public CondExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitCondExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondExprContext condExpr() throws RecognitionException {
		CondExprContext _localctx = new CondExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_condExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(T__24);
			setState(200);
			match(T__33);
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(201);
				condEntry();
				}
				}
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(207);
			match(T__25);
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

	public static class AssignExprContext extends ParserRuleContext {
		public ExprContext left;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AssignExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignExprContext assignExpr() throws RecognitionException {
		AssignExprContext _localctx = new AssignExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_assignExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(T__24);
			setState(210);
			match(T__34);
			setState(211);
			((AssignExprContext)_localctx).left = expr();
			setState(212);
			((AssignExprContext)_localctx).right = expr();
			setState(213);
			match(T__25);
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
		public FuncDeclExprContext funcDeclExpr() {
			return getRuleContext(FuncDeclExprContext.class,0);
		}
		public LambdaExprContext lambdaExpr() {
			return getRuleContext(LambdaExprContext.class,0);
		}
		public VarDeclExprContext varDeclExpr() {
			return getRuleContext(VarDeclExprContext.class,0);
		}
		public ForExprContext forExpr() {
			return getRuleContext(ForExprContext.class,0);
		}
		public LiteralExprContext literalExpr() {
			return getRuleContext(LiteralExprContext.class,0);
		}
		public StructDeclExprContext structDeclExpr() {
			return getRuleContext(StructDeclExprContext.class,0);
		}
		public CondExprContext condExpr() {
			return getRuleContext(CondExprContext.class,0);
		}
		public AssignExprContext assignExpr() {
			return getRuleContext(AssignExprContext.class,0);
		}
		public FuncCallExprContext funcCallExpr() {
			return getRuleContext(FuncCallExprContext.class,0);
		}
		public VarExprContext varExpr() {
			return getRuleContext(VarExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Lang1Visitor ) return ((Lang1Visitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expr);
		try {
			setState(225);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				funcDeclExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				lambdaExpr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(217);
				varDeclExpr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(218);
				forExpr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(219);
				literalExpr();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(220);
				structDeclExpr();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(221);
				condExpr();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(222);
				assignExpr();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(223);
				funcCallExpr();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(224);
				varExpr();
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u00e6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\7\2(\n\2\f\2\16\2+\13\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\7\4"+
		"\64\n\4\f\4\16\4\67\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7"+
		"\5D\n\5\f\5\16\5G\13\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\7\6Q\n\6\f\6\16"+
		"\6T\13\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7`\n\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\7\tl\n\t\f\t\16\to\13\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\7\13\177\n\13\f\13\16\13\u0082"+
		"\13\13\3\13\3\13\7\13\u0086\n\13\f\13\16\13\u0089\13\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\7\f\u0093\n\f\f\f\16\f\u0096\13\f\3\f\3\f\7\f\u009a"+
		"\n\f\f\f\16\f\u009d\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00a8"+
		"\n\r\f\r\16\r\u00ab\13\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16\u00ba\n\16\3\17\3\17\3\20\3\20\3\20\3\20\7\20\u00c2"+
		"\n\20\f\20\16\20\u00c5\13\20\3\20\3\20\3\20\3\21\3\21\3\21\7\21\u00cd"+
		"\n\21\f\21\16\21\u00d0\13\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00e4\n\23\3\23"+
		"\2\2\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\3\4\2\3\32**\2\u00f0"+
		"\2)\3\2\2\2\4.\3\2\2\2\6\60\3\2\2\2\b:\3\2\2\2\nK\3\2\2\2\f_\3\2\2\2\16"+
		"a\3\2\2\2\20f\3\2\2\2\22s\3\2\2\2\24y\3\2\2\2\26\u008c\3\2\2\2\30\u00a0"+
		"\3\2\2\2\32\u00b9\3\2\2\2\34\u00bb\3\2\2\2\36\u00bd\3\2\2\2 \u00c9\3\2"+
		"\2\2\"\u00d3\3\2\2\2$\u00e3\3\2\2\2&(\5$\23\2\'&\3\2\2\2(+\3\2\2\2)\'"+
		"\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2,-\7\2\2\3-\3\3\2\2\2./\t\2\2\2"+
		"/\5\3\2\2\2\60\61\7\33\2\2\61\65\5$\23\2\62\64\5$\23\2\63\62\3\2\2\2\64"+
		"\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\67\65\3\2\2\289\7"+
		"\34\2\29\7\3\2\2\2:;\7\33\2\2;<\7\35\2\2<=\7*\2\2=E\7\33\2\2>?\7\33\2"+
		"\2?@\7*\2\2@A\5$\23\2AB\7\34\2\2BD\3\2\2\2C>\3\2\2\2DG\3\2\2\2EC\3\2\2"+
		"\2EF\3\2\2\2FH\3\2\2\2GE\3\2\2\2HI\7\34\2\2IJ\7\34\2\2J\t\3\2\2\2KL\7"+
		"\33\2\2LM\7\36\2\2MN\5\32\16\2NR\7\33\2\2OQ\5$\23\2PO\3\2\2\2QT\3\2\2"+
		"\2RP\3\2\2\2RS\3\2\2\2SU\3\2\2\2TR\3\2\2\2UV\7\34\2\2VW\7\34\2\2W\13\3"+
		"\2\2\2X`\5\b\5\2Y`\5\n\6\2Z`\7+\2\2[`\7(\2\2\\`\7\'\2\2]`\7)\2\2^`\7&"+
		"\2\2_X\3\2\2\2_Y\3\2\2\2_Z\3\2\2\2_[\3\2\2\2_\\\3\2\2\2_]\3\2\2\2_^\3"+
		"\2\2\2`\r\3\2\2\2ab\7\33\2\2bc\7*\2\2cd\5\32\16\2de\7\34\2\2e\17\3\2\2"+
		"\2fg\7\33\2\2gh\7\37\2\2hi\7*\2\2im\7\33\2\2jl\5\16\b\2kj\3\2\2\2lo\3"+
		"\2\2\2mk\3\2\2\2mn\3\2\2\2np\3\2\2\2om\3\2\2\2pq\7\34\2\2qr\7\34\2\2r"+
		"\21\3\2\2\2st\7\33\2\2tu\7 \2\2uv\5\16\b\2vw\5$\23\2wx\7\34\2\2x\23\3"+
		"\2\2\2yz\7\33\2\2z{\7!\2\2{|\5\32\16\2|\u0080\7\33\2\2}\177\5\16\b\2~"+
		"}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083"+
		"\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0087\7\34\2\2\u0084\u0086\5$\23\2"+
		"\u0085\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088"+
		"\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\7\34\2\2"+
		"\u008b\25\3\2\2\2\u008c\u008d\7\33\2\2\u008d\u008e\7\"\2\2\u008e\u008f"+
		"\7*\2\2\u008f\u0090\5\32\16\2\u0090\u0094\7\33\2\2\u0091\u0093\5\16\b"+
		"\2\u0092\u0091\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095"+
		"\3\2\2\2\u0095\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u009b\7\34\2\2"+
		"\u0098\u009a\5$\23\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099"+
		"\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e\3\2\2\2\u009d\u009b\3\2\2\2\u009e"+
		"\u009f\7\34\2\2\u009f\27\3\2\2\2\u00a0\u00a1\7\33\2\2\u00a1\u00a2\7#\2"+
		"\2\u00a2\u00a3\5$\23\2\u00a3\u00a4\5$\23\2\u00a4\u00a5\5$\23\2\u00a5\u00a9"+
		"\7\33\2\2\u00a6\u00a8\5$\23\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2"+
		"\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9"+
		"\3\2\2\2\u00ac\u00ad\7\34\2\2\u00ad\u00ae\7\34\2\2\u00ae\31\3\2\2\2\u00af"+
		"\u00b0\7\33\2\2\u00b0\u00b1\7\35\2\2\u00b1\u00b2\7*\2\2\u00b2\u00ba\7"+
		"\34\2\2\u00b3\u00b4\7\33\2\2\u00b4\u00b5\7\36\2\2\u00b5\u00b6\5\32\16"+
		"\2\u00b6\u00b7\7\34\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00ba\7*\2\2\u00b9\u00af"+
		"\3\2\2\2\u00b9\u00b3\3\2\2\2\u00b9\u00b8\3\2\2\2\u00ba\33\3\2\2\2\u00bb"+
		"\u00bc\5\4\3\2\u00bc\35\3\2\2\2\u00bd\u00be\7\33\2\2\u00be\u00bf\5$\23"+
		"\2\u00bf\u00c3\7\33\2\2\u00c0\u00c2\5$\23\2\u00c1\u00c0\3\2\2\2\u00c2"+
		"\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\3\2"+
		"\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c7\7\34\2\2\u00c7\u00c8\7\34\2\2\u00c8"+
		"\37\3\2\2\2\u00c9\u00ca\7\33\2\2\u00ca\u00ce\7$\2\2\u00cb\u00cd\5\36\20"+
		"\2\u00cc\u00cb\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf"+
		"\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\7\34\2\2"+
		"\u00d2!\3\2\2\2\u00d3\u00d4\7\33\2\2\u00d4\u00d5\7%\2\2\u00d5\u00d6\5"+
		"$\23\2\u00d6\u00d7\5$\23\2\u00d7\u00d8\7\34\2\2\u00d8#\3\2\2\2\u00d9\u00e4"+
		"\5\26\f\2\u00da\u00e4\5\24\13\2\u00db\u00e4\5\22\n\2\u00dc\u00e4\5\30"+
		"\r\2\u00dd\u00e4\5\f\7\2\u00de\u00e4\5\20\t\2\u00df\u00e4\5 \21\2\u00e0"+
		"\u00e4\5\"\22\2\u00e1\u00e4\5\6\4\2\u00e2\u00e4\5\34\17\2\u00e3\u00d9"+
		"\3\2\2\2\u00e3\u00da\3\2\2\2\u00e3\u00db\3\2\2\2\u00e3\u00dc\3\2\2\2\u00e3"+
		"\u00dd\3\2\2\2\u00e3\u00de\3\2\2\2\u00e3\u00df\3\2\2\2\u00e3\u00e0\3\2"+
		"\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e2\3\2\2\2\u00e4%\3\2\2\2\21)\65ER_"+
		"m\u0080\u0087\u0094\u009b\u00a9\u00b9\u00c3\u00ce\u00e3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}