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
		T__31=32, T__32=33, BOOL=34, NULL=35, NUM=36, FLOAT=37, ID=38, STR=39, 
		CHR=40, WS=41, LINE_COMMENT=42;
	public static final int
		RULE_program = 0, RULE_funcName = 1, RULE_funcCallExpr = 2, RULE_structExpr = 3, 
		RULE_arrayExpr = 4, RULE_literalExpr = 5, RULE_varDecl = 6, RULE_structDeclExpr = 7, 
		RULE_varDeclExpr = 8, RULE_lambdaExpr = 9, RULE_funcDeclExpr = 10, RULE_forExpr = 11, 
		RULE_typeExpr = 12, RULE_expr = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "funcName", "funcCallExpr", "structExpr", "arrayExpr", "literalExpr", 
			"varDecl", "structDeclExpr", "varDeclExpr", "lambdaExpr", "funcDeclExpr", 
			"forExpr", "typeExpr", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'%'", "'='", "'>>'", "'<<'", "'>='", 
			"'<='", "'>'", "'<'", "'=='", "'!='", "'&&'", "'||'", "'|'", "'&'", "'^'", 
			"'~'", "'!'", "'.'", "'++'", "'--'", "'('", "')'", "'struct'", "'array'", 
			"'defstruct'", "'setq'", "'lambda'", "'defun'", "'for'", null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "BOOL", "NULL", 
			"NUM", "FLOAT", "ID", "STR", "CHR", "WS", "LINE_COMMENT"
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
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
				{
				{
				setState(28);
				expr();
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
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
			setState(36);
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
		public FuncNameContext func;
		public ExprContext args;
		public FuncNameContext funcName() {
			return getRuleContext(FuncNameContext.class,0);
		}
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
			setState(38);
			match(T__24);
			setState(39);
			((FuncCallExprContext)_localctx).func = funcName();
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
				{
				{
				setState(40);
				((FuncCallExprContext)_localctx).args = expr();
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
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
			setState(48);
			match(T__24);
			setState(49);
			match(T__26);
			setState(50);
			((StructExprContext)_localctx).name = match(ID);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(51);
				match(T__24);
				setState(52);
				((StructExprContext)_localctx).field = match(ID);
				setState(53);
				((StructExprContext)_localctx).value = expr();
				setState(54);
				match(T__25);
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
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
			setState(63);
			match(T__24);
			setState(64);
			match(T__27);
			setState(65);
			((ArrayExprContext)_localctx).type = typeExpr();
			setState(66);
			match(T__24);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
				{
				{
				setState(67);
				((ArrayExprContext)_localctx).value = expr();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
			match(T__25);
			setState(74);
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
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new StructLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				structExpr();
				}
				break;
			case 2:
				_localctx = new ArrayLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				arrayExpr();
				}
				break;
			case 3:
				_localctx = new StrLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				((StrLiteralContext)_localctx).value = match(STR);
				}
				break;
			case 4:
				_localctx = new NumLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				((NumLiteralContext)_localctx).value = match(NUM);
				}
				break;
			case 5:
				_localctx = new NullLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(80);
				((NullLiteralContext)_localctx).value = match(NULL);
				}
				break;
			case 6:
				_localctx = new FloatLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(81);
				((FloatLiteralContext)_localctx).value = match(FLOAT);
				}
				break;
			case 7:
				_localctx = new BooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(82);
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
			setState(85);
			match(T__24);
			setState(86);
			((VarDeclContext)_localctx).name = match(ID);
			setState(87);
			((VarDeclContext)_localctx).type = typeExpr();
			setState(88);
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
			setState(90);
			match(T__24);
			setState(91);
			match(T__28);
			setState(92);
			((StructDeclExprContext)_localctx).name = match(ID);
			setState(93);
			match(T__24);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(94);
				((StructDeclExprContext)_localctx).fields = varDecl();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
			match(T__25);
			setState(101);
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
			setState(103);
			match(T__24);
			setState(104);
			match(T__29);
			setState(105);
			((VarDeclExprContext)_localctx).var = varDecl();
			setState(106);
			((VarDeclExprContext)_localctx).value = expr();
			setState(107);
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
			setState(109);
			match(T__24);
			setState(110);
			match(T__30);
			setState(111);
			((LambdaExprContext)_localctx).ret_type = typeExpr();
			setState(112);
			match(T__24);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(113);
				((LambdaExprContext)_localctx).args = varDecl();
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(119);
			match(T__25);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
				{
				{
				setState(120);
				((LambdaExprContext)_localctx).body = expr();
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
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
			setState(128);
			match(T__24);
			setState(129);
			match(T__31);
			setState(130);
			((FuncDeclExprContext)_localctx).name = match(ID);
			setState(131);
			((FuncDeclExprContext)_localctx).ret_type = typeExpr();
			setState(132);
			match(T__24);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(133);
				((FuncDeclExprContext)_localctx).args = varDecl();
				}
				}
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(139);
			match(T__25);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
				{
				{
				setState(140);
				((FuncDeclExprContext)_localctx).body = expr();
				}
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(146);
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
			setState(148);
			match(T__24);
			setState(149);
			match(T__32);
			setState(150);
			((ForExprContext)_localctx).initial = expr();
			setState(151);
			((ForExprContext)_localctx).cond = expr();
			setState(152);
			((ForExprContext)_localctx).end = expr();
			setState(153);
			match(T__24);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
				{
				{
				setState(154);
				((ForExprContext)_localctx).body = expr();
				}
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(160);
			match(T__25);
			setState(161);
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
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new StructTypeExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				match(T__24);
				setState(164);
				match(T__26);
				setState(165);
				((StructTypeExprContext)_localctx).name = match(ID);
				setState(166);
				match(T__25);
				}
				break;
			case 2:
				_localctx = new ArrayTypeExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				match(T__24);
				setState(168);
				match(T__27);
				setState(169);
				((ArrayTypeExprContext)_localctx).type = typeExpr();
				setState(170);
				match(T__25);
				}
				break;
			case 3:
				_localctx = new PlainTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(172);
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
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
		public FuncCallExprContext funcCallExpr() {
			return getRuleContext(FuncCallExprContext.class,0);
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
		enterRule(_localctx, 26, RULE_expr);
		try {
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				funcDeclExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				lambdaExpr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(177);
				varDeclExpr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(178);
				forExpr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(179);
				literalExpr();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(180);
				structDeclExpr();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(181);
				typeExpr();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(182);
				funcCallExpr();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u00bc\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\7\2 \n\2\f\2\16\2#\13\2\3"+
		"\2\3\2\3\3\3\3\3\4\3\4\3\4\7\4,\n\4\f\4\16\4/\13\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\7\5;\n\5\f\5\16\5>\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\7\6G\n\6\f\6\16\6J\13\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7"+
		"V\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\7\tb\n\t\f\t\16\te\13\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\7\13u\n"+
		"\13\f\13\16\13x\13\13\3\13\3\13\7\13|\n\13\f\13\16\13\177\13\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0089\n\f\f\f\16\f\u008c\13\f\3\f\3\f"+
		"\7\f\u0090\n\f\f\f\16\f\u0093\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\7\r\u009e\n\r\f\r\16\r\u00a1\13\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\5\16\u00b0\n\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\5\17\u00ba\n\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\2\3\4\2\3\32((\2\u00c6\2!\3\2\2\2\4&\3\2\2\2\6(\3\2\2\2\b\62\3\2\2"+
		"\2\nA\3\2\2\2\fU\3\2\2\2\16W\3\2\2\2\20\\\3\2\2\2\22i\3\2\2\2\24o\3\2"+
		"\2\2\26\u0082\3\2\2\2\30\u0096\3\2\2\2\32\u00af\3\2\2\2\34\u00b9\3\2\2"+
		"\2\36 \5\34\17\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"$\3\2"+
		"\2\2#!\3\2\2\2$%\7\2\2\3%\3\3\2\2\2&\'\t\2\2\2\'\5\3\2\2\2()\7\33\2\2"+
		")-\5\4\3\2*,\5\34\17\2+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\60\3\2"+
		"\2\2/-\3\2\2\2\60\61\7\34\2\2\61\7\3\2\2\2\62\63\7\33\2\2\63\64\7\35\2"+
		"\2\64<\7(\2\2\65\66\7\33\2\2\66\67\7(\2\2\678\5\34\17\289\7\34\2\29;\3"+
		"\2\2\2:\65\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=?\3\2\2\2><\3\2\2\2?"+
		"@\7\34\2\2@\t\3\2\2\2AB\7\33\2\2BC\7\36\2\2CD\5\32\16\2DH\7\33\2\2EG\5"+
		"\34\17\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2K"+
		"L\7\34\2\2LM\7\34\2\2M\13\3\2\2\2NV\5\b\5\2OV\5\n\6\2PV\7)\2\2QV\7&\2"+
		"\2RV\7%\2\2SV\7\'\2\2TV\7$\2\2UN\3\2\2\2UO\3\2\2\2UP\3\2\2\2UQ\3\2\2\2"+
		"UR\3\2\2\2US\3\2\2\2UT\3\2\2\2V\r\3\2\2\2WX\7\33\2\2XY\7(\2\2YZ\5\32\16"+
		"\2Z[\7\34\2\2[\17\3\2\2\2\\]\7\33\2\2]^\7\37\2\2^_\7(\2\2_c\7\33\2\2`"+
		"b\5\16\b\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2\2"+
		"fg\7\34\2\2gh\7\34\2\2h\21\3\2\2\2ij\7\33\2\2jk\7 \2\2kl\5\16\b\2lm\5"+
		"\34\17\2mn\7\34\2\2n\23\3\2\2\2op\7\33\2\2pq\7!\2\2qr\5\32\16\2rv\7\33"+
		"\2\2su\5\16\b\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3"+
		"\2\2\2y}\7\34\2\2z|\5\34\17\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2"+
		"\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081\7\34\2\2\u0081\25\3\2\2\2\u0082"+
		"\u0083\7\33\2\2\u0083\u0084\7\"\2\2\u0084\u0085\7(\2\2\u0085\u0086\5\32"+
		"\16\2\u0086\u008a\7\33\2\2\u0087\u0089\5\16\b\2\u0088\u0087\3\2\2\2\u0089"+
		"\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008d\3\2"+
		"\2\2\u008c\u008a\3\2\2\2\u008d\u0091\7\34\2\2\u008e\u0090\5\34\17\2\u008f"+
		"\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2"+
		"\2\2\u0092\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7\34\2\2\u0095"+
		"\27\3\2\2\2\u0096\u0097\7\33\2\2\u0097\u0098\7#\2\2\u0098\u0099\5\34\17"+
		"\2\u0099\u009a\5\34\17\2\u009a\u009b\5\34\17\2\u009b\u009f\7\33\2\2\u009c"+
		"\u009e\5\34\17\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3"+
		"\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2"+
		"\u00a3\7\34\2\2\u00a3\u00a4\7\34\2\2\u00a4\31\3\2\2\2\u00a5\u00a6\7\33"+
		"\2\2\u00a6\u00a7\7\35\2\2\u00a7\u00a8\7(\2\2\u00a8\u00b0\7\34\2\2\u00a9"+
		"\u00aa\7\33\2\2\u00aa\u00ab\7\36\2\2\u00ab\u00ac\5\32\16\2\u00ac\u00ad"+
		"\7\34\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00b0\7(\2\2\u00af\u00a5\3\2\2\2\u00af"+
		"\u00a9\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0\33\3\2\2\2\u00b1\u00ba\5\26\f"+
		"\2\u00b2\u00ba\5\24\13\2\u00b3\u00ba\5\22\n\2\u00b4\u00ba\5\30\r\2\u00b5"+
		"\u00ba\5\f\7\2\u00b6\u00ba\5\20\t\2\u00b7\u00ba\5\32\16\2\u00b8\u00ba"+
		"\5\6\4\2\u00b9\u00b1\3\2\2\2\u00b9\u00b2\3\2\2\2\u00b9\u00b3\3\2\2\2\u00b9"+
		"\u00b4\3\2\2\2\u00b9\u00b5\3\2\2\2\u00b9\u00b6\3\2\2\2\u00b9\u00b7\3\2"+
		"\2\2\u00b9\u00b8\3\2\2\2\u00ba\35\3\2\2\2\17!-<HUcv}\u008a\u0091\u009f"+
		"\u00af\u00b9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}