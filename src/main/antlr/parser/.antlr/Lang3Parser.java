// Generated from /home/edward/Documents/scifair/src/main/antlr/parser/Lang3.g4 by ANTLR 4.7.1

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
public class Lang3Parser extends Parser {
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
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, BOOL=57, NULL=58, NUM=59, FLOAT=60, 
		ID=61, STR=62, CHR=63, WS=64, COMMENT=65, LINE_COMMENT=66, TERMINATOR=67;
	public static final int
		RULE_program = 0, RULE_expr = 1, RULE_structExpr = 2, RULE_arrayExpr = 3, 
		RULE_literalExpr = 4, RULE_varDecl = 5, RULE_structDeclExpr = 6, RULE_varDeclExpr = 7, 
		RULE_lambdaExpr = 8, RULE_funcDeclExpr = 9, RULE_forInitialExpr = 10, 
		RULE_forExpr = 11, RULE_rangeExpr = 12, RULE_typeExpr = 13, RULE_ifStatementBody = 14, 
		RULE_ifStatement = 15, RULE_inlineIfStatement = 16, RULE_unlessIfStatement = 17, 
		RULE_switchCase = 18, RULE_switchStatement = 19, RULE_returnStatement = 20, 
		RULE_inlineIfBodyStatement = 21, RULE_statement = 22, RULE_eos = 23, RULE_lineComment = 24;
	public static final String[] ruleNames = {
		"program", "expr", "structExpr", "arrayExpr", "literalExpr", "varDecl", 
		"structDeclExpr", "varDeclExpr", "lambdaExpr", "funcDeclExpr", "forInitialExpr", 
		"forExpr", "rangeExpr", "typeExpr", "ifStatementBody", "ifStatement", 
		"inlineIfStatement", "unlessIfStatement", "switchCase", "switchStatement", 
		"returnStatement", "inlineIfBodyStatement", "statement", "eos", "lineComment"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'.'", "'['", "']'", "'++'", "'--'", "','", "'!'", 
		"'~'", "'*'", "'/'", "'%'", "'+'", "'-'", "'<<'", "'>>'", "'<'", "'<='", 
		"'>'", "'>='", "'=='", "'!='", "'&'", "'|'", "'^'", "'&&'", "'||'", "'='", 
		"'+='", "'-='", "'*='", "'/='", "'%='", "'<<='", "'>>='", "'&='", "'^='", 
		"'|='", "'struct'", "'{'", "':'", "'}'", "'->'", "'=>'", "'fn'", "'for'", 
		"'range'", "'in'", "'..'", "'if'", "'elsif'", "'else'", "'unless'", "'switch'", 
		"'return'", null, "'null'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "BOOL", "NULL", 
		"NUM", "FLOAT", "ID", "STR", "CHR", "WS", "COMMENT", "LINE_COMMENT", "TERMINATOR"
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
	public String getGrammarFileName() { return "Lang3.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private boolean lineTerminatorAhead() {
	        int possibleIndexEosToken = this.getCurrentToken().getTokenIndex() - 1;
	        Token ahead = _input.get(possibleIndexEosToken);
	        if (ahead.getChannel() != Lexer.HIDDEN) {
	            return false;
	        }

	        if (ahead.getType() == TERMINATOR) {
	            // There is definitely a line terminator ahead.
	            return true;
	        }

	        if (ahead.getType() == WS) {
	            // Get the token ahead of the current whitespaces.
	            possibleIndexEosToken = this.getCurrentToken().getTokenIndex() - 2;
	            ahead = _input.get(possibleIndexEosToken);
	        }

	        // Get the token's text and type.
	        String text = ahead.getText();
	        int type = ahead.getType();

	        // Check if the token is, or contains a line terminator.
	        return (type == COMMENT && (text.contains("\r") || text.contains("\n"))) ||
	                (type == TERMINATOR);
	    }

	public Lang3Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Lang3Parser.EOF, 0); }
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
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__8) | (1L << T__9) | (1L << T__39) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0) || _la==LINE_COMMENT) {
				{
				{
				setState(50);
				statement();
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(56);
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
		public TerminalNode ID() { return getToken(Lang3Parser.ID, 0); }
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
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(59);
				match(T__0);
				setState(60);
				expr(0);
				setState(61);
				match(T__1);
				}
				break;
			case 2:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(63);
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
				setState(64);
				((PrefixExprContext)_localctx).varName = expr(15);
				}
				break;
			case 3:
				{
				_localctx = new LitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65);
				literalExpr();
				}
				break;
			case 4:
				{
				_localctx = new ClosureExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(66);
				lambdaExpr();
				}
				break;
			case 5:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(67);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(128);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(126);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new DotExprContext(new ExprContext(_parentctx, _parentState));
						((DotExprContext)_localctx).varName = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(70);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(71);
						match(T__2);
						setState(72);
						((DotExprContext)_localctx).sub = expr(20);
						}
						break;
					case 2:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(73);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(74);
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
						setState(75);
						((InfixExprContext)_localctx).right = expr(15);
						}
						break;
					case 3:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(76);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(77);
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
						setState(78);
						((InfixExprContext)_localctx).right = expr(14);
						}
						break;
					case 4:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(79);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(80);
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
						setState(81);
						((InfixExprContext)_localctx).right = expr(13);
						}
						break;
					case 5:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(82);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(83);
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
						setState(84);
						((InfixExprContext)_localctx).right = expr(12);
						}
						break;
					case 6:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(85);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(86);
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
						setState(87);
						((InfixExprContext)_localctx).right = expr(11);
						}
						break;
					case 7:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(88);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(89);
						((InfixExprContext)_localctx).op = match(T__23);
						setState(90);
						((InfixExprContext)_localctx).right = expr(10);
						}
						break;
					case 8:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(91);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(92);
						((InfixExprContext)_localctx).op = match(T__24);
						setState(93);
						((InfixExprContext)_localctx).right = expr(9);
						}
						break;
					case 9:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(94);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(95);
						((InfixExprContext)_localctx).op = match(T__25);
						setState(96);
						((InfixExprContext)_localctx).right = expr(8);
						}
						break;
					case 10:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(97);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(98);
						((InfixExprContext)_localctx).op = match(T__26);
						setState(99);
						((InfixExprContext)_localctx).right = expr(7);
						}
						break;
					case 11:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(100);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(101);
						((InfixExprContext)_localctx).op = match(T__27);
						setState(102);
						((InfixExprContext)_localctx).right = expr(6);
						}
						break;
					case 12:
						{
						_localctx = new AssignmentExprContext(new ExprContext(_parentctx, _parentState));
						((AssignmentExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(103);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(104);
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
						setState(105);
						((AssignmentExprContext)_localctx).right = expr(5);
						}
						break;
					case 13:
						{
						_localctx = new ArraySubExprContext(new ExprContext(_parentctx, _parentState));
						((ArraySubExprContext)_localctx).varName = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(106);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(107);
						match(T__3);
						setState(108);
						((ArraySubExprContext)_localctx).sub = expr(0);
						setState(109);
						match(T__4);
						}
						break;
					case 14:
						{
						_localctx = new PostfixExprContext(new ExprContext(_parentctx, _parentState));
						((PostfixExprContext)_localctx).varName = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(111);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(112);
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
						setState(113);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(114);
						match(T__0);
						setState(120);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(115);
								((FuncExprContext)_localctx).args = expr(0);
								setState(116);
								match(T__7);
								}
								} 
							}
							setState(122);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
						}
						{
						setState(123);
						((FuncExprContext)_localctx).args = expr(0);
						}
						setState(124);
						match(T__1);
						}
						break;
					}
					} 
				}
				setState(130);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
		public List<TerminalNode> ID() { return getTokens(Lang3Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Lang3Parser.ID, i);
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
			setState(131);
			match(T__39);
			setState(132);
			((StructExprContext)_localctx).name = match(ID);
			setState(133);
			match(T__40);
			setState(141);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(134);
					((StructExprContext)_localctx).field = match(ID);
					setState(135);
					match(T__41);
					setState(136);
					((StructExprContext)_localctx).value = expr(0);
					setState(137);
					match(T__7);
					}
					} 
				}
				setState(143);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(144);
				((StructExprContext)_localctx).field = match(ID);
				setState(145);
				match(T__41);
				setState(146);
				((StructExprContext)_localctx).value = expr(0);
				}
			}

			setState(149);
			match(T__42);
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
			setState(151);
			match(T__3);
			setState(152);
			match(T__4);
			setState(153);
			((ArrayExprContext)_localctx).type = typeExpr();
			setState(154);
			match(T__3);
			setState(160);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(155);
					((ArrayExprContext)_localctx).value = expr(0);
					setState(156);
					match(T__7);
					}
					} 
				}
				setState(162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__8) | (1L << T__9) | (1L << T__39) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
				{
				setState(163);
				((ArrayExprContext)_localctx).value = expr(0);
				}
			}

			setState(166);
			match(T__4);
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
		public TerminalNode STR() { return getToken(Lang3Parser.STR, 0); }
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
		public TerminalNode NULL() { return getToken(Lang3Parser.NULL, 0); }
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
		public TerminalNode NUM() { return getToken(Lang3Parser.NUM, 0); }
		public NumLiteralContext(LiteralExprContext ctx) { copyFrom(ctx); }
	}
	public static class FloatLiteralContext extends LiteralExprContext {
		public Token value;
		public TerminalNode FLOAT() { return getToken(Lang3Parser.FLOAT, 0); }
		public FloatLiteralContext(LiteralExprContext ctx) { copyFrom(ctx); }
	}
	public static class BooleanLiteralContext extends LiteralExprContext {
		public Token value;
		public TerminalNode BOOL() { return getToken(Lang3Parser.BOOL, 0); }
		public BooleanLiteralContext(LiteralExprContext ctx) { copyFrom(ctx); }
	}

	public final LiteralExprContext literalExpr() throws RecognitionException {
		LiteralExprContext _localctx = new LiteralExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_literalExpr);
		try {
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__39:
				_localctx = new StructLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				structExpr();
				}
				break;
			case T__3:
				_localctx = new ArrayLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				arrayExpr();
				}
				break;
			case STR:
				_localctx = new StrLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
				((StrLiteralContext)_localctx).value = match(STR);
				}
				break;
			case NUM:
				_localctx = new NumLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(171);
				((NumLiteralContext)_localctx).value = match(NUM);
				}
				break;
			case NULL:
				_localctx = new NullLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(172);
				((NullLiteralContext)_localctx).value = match(NULL);
				}
				break;
			case FLOAT:
				_localctx = new FloatLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(173);
				((FloatLiteralContext)_localctx).value = match(FLOAT);
				}
				break;
			case BOOL:
				_localctx = new BooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(174);
				((BooleanLiteralContext)_localctx).value = match(BOOL);
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

	public static class VarDeclContext extends ParserRuleContext {
		public Token name;
		public TypeExprContext type;
		public TerminalNode ID() { return getToken(Lang3Parser.ID, 0); }
		public TypeExprContext typeExpr() {
			return getRuleContext(TypeExprContext.class,0);
		}
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
			setState(177);
			((VarDeclContext)_localctx).name = match(ID);
			setState(178);
			match(T__41);
			setState(179);
			((VarDeclContext)_localctx).type = typeExpr();
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
		public TerminalNode ID() { return getToken(Lang3Parser.ID, 0); }
		public List<EosContext> eos() {
			return getRuleContexts(EosContext.class);
		}
		public EosContext eos(int i) {
			return getRuleContext(EosContext.class,i);
		}
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
			setState(181);
			match(T__39);
			setState(182);
			((StructDeclExprContext)_localctx).name = match(ID);
			setState(183);
			match(T__40);
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(184);
				((StructDeclExprContext)_localctx).fields = varDecl();
				setState(185);
				eos();
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(192);
			match(T__42);
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
			setState(194);
			((VarDeclExprContext)_localctx).var = varDecl();
			setState(195);
			match(T__28);
			setState(196);
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
		public VarDeclContext args;
		public TypeExprContext ret_type;
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
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				match(T__0);
				setState(204);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(199);
						((LambdaExprContext)_localctx).args = varDecl();
						setState(200);
						match(T__7);
						}
						} 
					}
					setState(206);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(207);
					((LambdaExprContext)_localctx).args = varDecl();
					}
				}

				setState(210);
				match(T__1);
				setState(211);
				match(T__43);
				setState(212);
				((LambdaExprContext)_localctx).ret_type = typeExpr();
				setState(213);
				match(T__40);
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__8) | (1L << T__9) | (1L << T__39) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0) || _la==LINE_COMMENT) {
					{
					{
					setState(214);
					((LambdaExprContext)_localctx).body = statement();
					}
					}
					setState(219);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(220);
				match(T__42);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				match(T__0);
				setState(228);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(223);
						((LambdaExprContext)_localctx).args = varDecl();
						setState(224);
						match(T__7);
						}
						} 
					}
					setState(230);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				}
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(231);
					((LambdaExprContext)_localctx).args = varDecl();
					}
				}

				setState(234);
				match(T__1);
				setState(235);
				match(T__43);
				setState(236);
				((LambdaExprContext)_localctx).ret_type = typeExpr();
				setState(237);
				match(T__44);
				{
				setState(238);
				((LambdaExprContext)_localctx).body = statement();
				}
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

	public static class FuncDeclExprContext extends ParserRuleContext {
		public Token name;
		public VarDeclContext args;
		public TypeExprContext ret_type;
		public StatementContext body;
		public TerminalNode ID() { return getToken(Lang3Parser.ID, 0); }
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
			setState(288);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				match(T__45);
				setState(243);
				((FuncDeclExprContext)_localctx).name = match(ID);
				setState(244);
				match(T__0);
				setState(250);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(245);
						((FuncDeclExprContext)_localctx).args = varDecl();
						setState(246);
						match(T__7);
						}
						} 
					}
					setState(252);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				}
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(253);
					((FuncDeclExprContext)_localctx).args = varDecl();
					}
				}

				setState(256);
				match(T__1);
				setState(257);
				match(T__43);
				setState(258);
				((FuncDeclExprContext)_localctx).ret_type = typeExpr();
				setState(259);
				match(T__40);
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__8) | (1L << T__9) | (1L << T__39) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0) || _la==LINE_COMMENT) {
					{
					{
					setState(260);
					((FuncDeclExprContext)_localctx).body = statement();
					}
					}
					setState(265);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(266);
				match(T__42);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(268);
				match(T__45);
				setState(269);
				((FuncDeclExprContext)_localctx).name = match(ID);
				setState(270);
				match(T__0);
				setState(276);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(271);
						((FuncDeclExprContext)_localctx).args = varDecl();
						setState(272);
						match(T__7);
						}
						} 
					}
					setState(278);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(279);
					((FuncDeclExprContext)_localctx).args = varDecl();
					}
				}

				setState(282);
				match(T__1);
				setState(283);
				match(T__43);
				setState(284);
				((FuncDeclExprContext)_localctx).ret_type = typeExpr();
				setState(285);
				match(T__44);
				setState(286);
				((FuncDeclExprContext)_localctx).body = statement();
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

	public static class ForInitialExprContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarDeclExprContext varDeclExpr() {
			return getRuleContext(VarDeclExprContext.class,0);
		}
		public ForInitialExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInitialExpr; }
	}

	public final ForInitialExprContext forInitialExpr() throws RecognitionException {
		ForInitialExprContext _localctx = new ForInitialExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_forInitialExpr);
		try {
			setState(292);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(290);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(291);
				varDeclExpr();
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

	public static class ForExprContext extends ParserRuleContext {
		public ForInitialExprContext initial;
		public ExprContext cond;
		public ExprContext end;
		public StatementContext body;
		public ForInitialExprContext forInitialExpr() {
			return getRuleContext(ForInitialExprContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ForExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forExpr; }
	}

	public final ForExprContext forExpr() throws RecognitionException {
		ForExprContext _localctx = new ForExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_forExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(T__46);
			setState(295);
			((ForExprContext)_localctx).initial = forInitialExpr();
			setState(296);
			match(T__7);
			setState(297);
			((ForExprContext)_localctx).cond = expr(0);
			setState(298);
			match(T__7);
			setState(299);
			((ForExprContext)_localctx).end = expr(0);
			setState(300);
			match(T__40);
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__8) | (1L << T__9) | (1L << T__39) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0) || _la==LINE_COMMENT) {
				{
				{
				setState(301);
				((ForExprContext)_localctx).body = statement();
				}
				}
				setState(306);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(307);
			match(T__42);
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

	public static class RangeExprContext extends ParserRuleContext {
		public VarDeclContext iterator;
		public ExprContext low;
		public ExprContext high;
		public StatementContext body;
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public RangeExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeExpr; }
	}

	public final RangeExprContext rangeExpr() throws RecognitionException {
		RangeExprContext _localctx = new RangeExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_rangeExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			match(T__47);
			setState(310);
			((RangeExprContext)_localctx).iterator = varDecl();
			setState(311);
			match(T__48);
			setState(312);
			((RangeExprContext)_localctx).low = expr(0);
			setState(313);
			match(T__49);
			setState(314);
			((RangeExprContext)_localctx).high = expr(0);
			setState(315);
			match(T__40);
			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__8) | (1L << T__9) | (1L << T__39) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0) || _la==LINE_COMMENT) {
				{
				{
				setState(316);
				((RangeExprContext)_localctx).body = statement();
				}
				}
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(322);
			match(T__42);
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
		public TerminalNode ID() { return getToken(Lang3Parser.ID, 0); }
		public StructTypeExprContext(TypeExprContext ctx) { copyFrom(ctx); }
	}
	public static class PlainTypeContext extends TypeExprContext {
		public Token type;
		public TerminalNode ID() { return getToken(Lang3Parser.ID, 0); }
		public PlainTypeContext(TypeExprContext ctx) { copyFrom(ctx); }
	}

	public final TypeExprContext typeExpr() throws RecognitionException {
		TypeExprContext _localctx = new TypeExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_typeExpr);
		try {
			setState(330);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__39:
				_localctx = new StructTypeExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(324);
				match(T__39);
				setState(325);
				((StructTypeExprContext)_localctx).name = match(ID);
				}
				break;
			case T__3:
				_localctx = new ArrayTypeExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(326);
				match(T__3);
				setState(327);
				match(T__4);
				setState(328);
				((ArrayTypeExprContext)_localctx).type = typeExpr();
				}
				break;
			case ID:
				_localctx = new PlainTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(329);
				((PlainTypeContext)_localctx).type = match(ID);
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
		enterRule(_localctx, 28, RULE_ifStatementBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(332);
				statement();
				}
				}
				setState(335); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__8) | (1L << T__9) | (1L << T__39) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0) || _la==LINE_COMMENT );
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
		enterRule(_localctx, 30, RULE_ifStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			match(T__50);
			setState(338);
			((IfStatementContext)_localctx).cond = expr(0);
			setState(339);
			match(T__40);
			{
			setState(340);
			((IfStatementContext)_localctx).body = ifStatementBody();
			}
			setState(341);
			match(T__42);
			setState(350);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(342);
					match(T__51);
					setState(343);
					((IfStatementContext)_localctx).cond = expr(0);
					setState(344);
					match(T__40);
					{
					setState(345);
					((IfStatementContext)_localctx).body = ifStatementBody();
					}
					setState(346);
					match(T__42);
					}
					} 
				}
				setState(352);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			setState(358);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(353);
				match(T__52);
				setState(354);
				match(T__40);
				{
				setState(355);
				((IfStatementContext)_localctx).body = ifStatementBody();
				}
				setState(356);
				match(T__42);
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

	public static class InlineIfStatementContext extends ParserRuleContext {
		public InlineIfBodyStatementContext body;
		public Token type;
		public ExprContext cond;
		public InlineIfBodyStatementContext inlineIfBodyStatement() {
			return getRuleContext(InlineIfBodyStatementContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InlineIfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineIfStatement; }
	}

	public final InlineIfStatementContext inlineIfStatement() throws RecognitionException {
		InlineIfStatementContext _localctx = new InlineIfStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_inlineIfStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			((InlineIfStatementContext)_localctx).body = inlineIfBodyStatement();
			setState(361);
			((InlineIfStatementContext)_localctx).type = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__50 || _la==T__53) ) {
				((InlineIfStatementContext)_localctx).type = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(362);
			((InlineIfStatementContext)_localctx).cond = expr(0);
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

	public static class UnlessIfStatementContext extends ParserRuleContext {
		public ExprContext cond;
		public IfStatementBodyContext body;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IfStatementBodyContext ifStatementBody() {
			return getRuleContext(IfStatementBodyContext.class,0);
		}
		public UnlessIfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unlessIfStatement; }
	}

	public final UnlessIfStatementContext unlessIfStatement() throws RecognitionException {
		UnlessIfStatementContext _localctx = new UnlessIfStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_unlessIfStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			match(T__53);
			setState(365);
			((UnlessIfStatementContext)_localctx).cond = expr(0);
			setState(366);
			match(T__40);
			{
			setState(367);
			((UnlessIfStatementContext)_localctx).body = ifStatementBody();
			}
			setState(368);
			match(T__42);
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

	public static class SwitchCaseContext extends ParserRuleContext {
		public ExprContext cond;
		public StatementContext body;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SwitchCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchCase; }
	}

	public final SwitchCaseContext switchCase() throws RecognitionException {
		SwitchCaseContext _localctx = new SwitchCaseContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_switchCase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__3:
			case T__8:
			case T__9:
			case T__39:
			case BOOL:
			case NULL:
			case NUM:
			case FLOAT:
			case ID:
			case STR:
				{
				setState(370);
				((SwitchCaseContext)_localctx).cond = expr(0);
				}
				break;
			case T__52:
				{
				setState(371);
				match(T__52);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(374);
			match(T__43);
			setState(375);
			match(T__40);
			setState(379);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__8) | (1L << T__9) | (1L << T__39) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__50) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0) || _la==LINE_COMMENT) {
				{
				{
				setState(376);
				((SwitchCaseContext)_localctx).body = statement();
				}
				}
				setState(381);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(382);
			match(T__42);
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

	public static class SwitchStatementContext extends ParserRuleContext {
		public ExprContext value;
		public SwitchCaseContext conds;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<SwitchCaseContext> switchCase() {
			return getRuleContexts(SwitchCaseContext.class);
		}
		public SwitchCaseContext switchCase(int i) {
			return getRuleContext(SwitchCaseContext.class,i);
		}
		public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatement; }
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_switchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			match(T__54);
			setState(385);
			((SwitchStatementContext)_localctx).value = expr(0);
			setState(386);
			match(T__40);
			setState(390);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__8) | (1L << T__9) | (1L << T__39) | (1L << T__52) | (1L << BOOL) | (1L << NULL) | (1L << NUM) | (1L << FLOAT) | (1L << ID) | (1L << STR))) != 0)) {
				{
				{
				setState(387);
				((SwitchStatementContext)_localctx).conds = switchCase();
				}
				}
				setState(392);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(393);
			match(T__42);
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
		enterRule(_localctx, 40, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			match(T__55);
			setState(396);
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

	public static class InlineIfBodyStatementContext extends ParserRuleContext {
		public InlineIfBodyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineIfBodyStatement; }
	 
		public InlineIfBodyStatementContext() { }
		public void copyFrom(InlineIfBodyStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InlineIfVarDeclStatementContext extends InlineIfBodyStatementContext {
		public VarDeclExprContext varDeclExpr() {
			return getRuleContext(VarDeclExprContext.class,0);
		}
		public InlineIfVarDeclStatementContext(InlineIfBodyStatementContext ctx) { copyFrom(ctx); }
	}
	public static class InlineIfIfStatementContext extends InlineIfBodyStatementContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public InlineIfIfStatementContext(InlineIfBodyStatementContext ctx) { copyFrom(ctx); }
	}
	public static class InlineIfFuncDeclStatementContext extends InlineIfBodyStatementContext {
		public FuncDeclExprContext funcDeclExpr() {
			return getRuleContext(FuncDeclExprContext.class,0);
		}
		public InlineIfFuncDeclStatementContext(InlineIfBodyStatementContext ctx) { copyFrom(ctx); }
	}
	public static class InlineIfForStatementContext extends InlineIfBodyStatementContext {
		public ForExprContext forExpr() {
			return getRuleContext(ForExprContext.class,0);
		}
		public InlineIfForStatementContext(InlineIfBodyStatementContext ctx) { copyFrom(ctx); }
	}
	public static class InlineIfStructDeclStatementContext extends InlineIfBodyStatementContext {
		public StructDeclExprContext structDeclExpr() {
			return getRuleContext(StructDeclExprContext.class,0);
		}
		public InlineIfStructDeclStatementContext(InlineIfBodyStatementContext ctx) { copyFrom(ctx); }
	}
	public static class InlineIfUnlessIfStatementContext extends InlineIfBodyStatementContext {
		public UnlessIfStatementContext unlessIfStatement() {
			return getRuleContext(UnlessIfStatementContext.class,0);
		}
		public InlineIfUnlessIfStatementContext(InlineIfBodyStatementContext ctx) { copyFrom(ctx); }
	}
	public static class InlineIfSwitchStatementContext extends InlineIfBodyStatementContext {
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public InlineIfSwitchStatementContext(InlineIfBodyStatementContext ctx) { copyFrom(ctx); }
	}
	public static class InlineIfReturnStatementContext extends InlineIfBodyStatementContext {
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public InlineIfReturnStatementContext(InlineIfBodyStatementContext ctx) { copyFrom(ctx); }
	}
	public static class InlineRangeExprStatementContext extends InlineIfBodyStatementContext {
		public RangeExprContext rangeExpr() {
			return getRuleContext(RangeExprContext.class,0);
		}
		public InlineRangeExprStatementContext(InlineIfBodyStatementContext ctx) { copyFrom(ctx); }
	}
	public static class InlineIfExprStatementContext extends InlineIfBodyStatementContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InlineIfExprStatementContext(InlineIfBodyStatementContext ctx) { copyFrom(ctx); }
	}

	public final InlineIfBodyStatementContext inlineIfBodyStatement() throws RecognitionException {
		InlineIfBodyStatementContext _localctx = new InlineIfBodyStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_inlineIfBodyStatement);
		try {
			setState(408);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new InlineIfFuncDeclStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(398);
				funcDeclExpr();
				}
				break;
			case 2:
				_localctx = new InlineIfVarDeclStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(399);
				varDeclExpr();
				}
				break;
			case 3:
				_localctx = new InlineIfForStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(400);
				forExpr();
				}
				break;
			case 4:
				_localctx = new InlineRangeExprStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(401);
				rangeExpr();
				}
				break;
			case 5:
				_localctx = new InlineIfStructDeclStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(402);
				structDeclExpr();
				}
				break;
			case 6:
				_localctx = new InlineIfIfStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(403);
				ifStatement();
				}
				break;
			case 7:
				_localctx = new InlineIfSwitchStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(404);
				switchStatement();
				}
				break;
			case 8:
				_localctx = new InlineIfUnlessIfStatementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(405);
				unlessIfStatement();
				}
				break;
			case 9:
				_localctx = new InlineIfReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(406);
				returnStatement();
				}
				break;
			case 10:
				_localctx = new InlineIfExprStatementContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(407);
				expr(0);
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StatementLineCommentContext extends StatementContext {
		public LineCommentContext lineComment() {
			return getRuleContext(LineCommentContext.class,0);
		}
		public StatementLineCommentContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class StatementVarDeclStatementContext extends StatementContext {
		public VarDeclExprContext varDeclExpr() {
			return getRuleContext(VarDeclExprContext.class,0);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public StatementVarDeclStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class StatementUnlessIfStatementContext extends StatementContext {
		public UnlessIfStatementContext unlessIfStatement() {
			return getRuleContext(UnlessIfStatementContext.class,0);
		}
		public StatementUnlessIfStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class StatementStructDeclStatementContext extends StatementContext {
		public StructDeclExprContext structDeclExpr() {
			return getRuleContext(StructDeclExprContext.class,0);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public StatementStructDeclStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class StatementFuncDeclStatementContext extends StatementContext {
		public FuncDeclExprContext funcDeclExpr() {
			return getRuleContext(FuncDeclExprContext.class,0);
		}
		public StatementFuncDeclStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class StatementSwitchStatementContext extends StatementContext {
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public StatementSwitchStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class StatementInlineIfStatementContext extends StatementContext {
		public InlineIfStatementContext inlineIfStatement() {
			return getRuleContext(InlineIfStatementContext.class,0);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public StatementInlineIfStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class StatementReturnStatementContext extends StatementContext {
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public StatementReturnStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class StatementRangeStatementContext extends StatementContext {
		public RangeExprContext rangeExpr() {
			return getRuleContext(RangeExprContext.class,0);
		}
		public StatementRangeStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class StatementExprStatementContext extends StatementContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public StatementExprStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class StatementIfStatementContext extends StatementContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public StatementIfStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class StatementForStatementContext extends StatementContext {
		public ForExprContext forExpr() {
			return getRuleContext(ForExprContext.class,0);
		}
		public StatementForStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_statement);
		try {
			setState(432);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				_localctx = new StatementFuncDeclStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(410);
				funcDeclExpr();
				}
				break;
			case 2:
				_localctx = new StatementVarDeclStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(411);
				varDeclExpr();
				setState(412);
				eos();
				}
				break;
			case 3:
				_localctx = new StatementForStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(414);
				forExpr();
				}
				break;
			case 4:
				_localctx = new StatementRangeStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(415);
				rangeExpr();
				}
				break;
			case 5:
				_localctx = new StatementStructDeclStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(416);
				structDeclExpr();
				setState(417);
				eos();
				}
				break;
			case 6:
				_localctx = new StatementIfStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(419);
				ifStatement();
				}
				break;
			case 7:
				_localctx = new StatementInlineIfStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(420);
				inlineIfStatement();
				setState(421);
				eos();
				}
				break;
			case 8:
				_localctx = new StatementUnlessIfStatementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(423);
				unlessIfStatement();
				}
				break;
			case 9:
				_localctx = new StatementSwitchStatementContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(424);
				switchStatement();
				}
				break;
			case 10:
				_localctx = new StatementReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(425);
				returnStatement();
				setState(426);
				eos();
				}
				break;
			case 11:
				_localctx = new StatementExprStatementContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(428);
				expr(0);
				setState(429);
				eos();
				}
				break;
			case 12:
				_localctx = new StatementLineCommentContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(431);
				lineComment();
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

	public static class EosContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Lang3Parser.EOF, 0); }
		public EosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eos; }
	}

	public final EosContext eos() throws RecognitionException {
		EosContext _localctx = new EosContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_eos);
		try {
			setState(437);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(434);
				match(EOF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(435);
				if (!(lineTerminatorAhead())) throw new FailedPredicateException(this, "lineTerminatorAhead()");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(436);
				if (!(_input.LT(1).getText().equals("}") )) throw new FailedPredicateException(this, "_input.LT(1).getText().equals(\"}\") ");
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
		public TerminalNode LINE_COMMENT() { return getToken(Lang3Parser.LINE_COMMENT, 0); }
		public LineCommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lineComment; }
	}

	public final LineCommentContext lineComment() throws RecognitionException {
		LineCommentContext _localctx = new LineCommentContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_lineComment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 23:
			return eos_sempred((EosContext)_localctx, predIndex);
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
	private boolean eos_sempred(EosContext _localctx, int predIndex) {
		switch (predIndex) {
		case 15:
			return lineTerminatorAhead();
		case 16:
			return _input.LT(1).getText().equals("}") ;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3E\u01bc\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\7\2\66\n\2\f\2\16\29\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\5\3G\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\7\3y\n\3\f\3\16\3|\13\3\3\3\3\3\3\3\7\3\u0081\n\3\f\3\16\3"+
		"\u0084\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u008e\n\4\f\4\16\4\u0091"+
		"\13\4\3\4\3\4\3\4\5\4\u0096\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7"+
		"\5\u00a1\n\5\f\5\16\5\u00a4\13\5\3\5\5\5\u00a7\n\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\5\6\u00b2\n\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\7\b\u00be\n\b\f\b\16\b\u00c1\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\7\n\u00cd\n\n\f\n\16\n\u00d0\13\n\3\n\5\n\u00d3\n\n\3\n\3\n\3\n\3"+
		"\n\3\n\7\n\u00da\n\n\f\n\16\n\u00dd\13\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00e5"+
		"\n\n\f\n\16\n\u00e8\13\n\3\n\5\n\u00eb\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n"+
		"\u00f3\n\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00fb\n\13\f\13\16\13\u00fe"+
		"\13\13\3\13\5\13\u0101\n\13\3\13\3\13\3\13\3\13\3\13\7\13\u0108\n\13\f"+
		"\13\16\13\u010b\13\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0115"+
		"\n\13\f\13\16\13\u0118\13\13\3\13\5\13\u011b\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u0123\n\13\3\f\3\f\5\f\u0127\n\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\7\r\u0131\n\r\f\r\16\r\u0134\13\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\7\16\u0140\n\16\f\16\16\16\u0143\13\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u014d\n\17\3\20\6\20\u0150\n\20"+
		"\r\20\16\20\u0151\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\7\21\u015f\n\21\f\21\16\21\u0162\13\21\3\21\3\21\3\21\3\21\3\21\5"+
		"\21\u0169\n\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\5\24\u0177\n\24\3\24\3\24\3\24\7\24\u017c\n\24\f\24\16\24\u017f"+
		"\13\24\3\24\3\24\3\25\3\25\3\25\3\25\7\25\u0187\n\25\f\25\16\25\u018a"+
		"\13\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\5\27\u019b\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30"+
		"\u01b3\n\30\3\31\3\31\3\31\5\31\u01b8\n\31\3\32\3\32\3\32\2\3\4\33\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\2\13\3\2\13\f\3\2\r"+
		"\17\3\2\20\21\3\2\22\23\3\2\24\27\3\2\30\31\3\2\37)\3\2\b\t\4\2\65\65"+
		"88\2\u01ef\2\67\3\2\2\2\4F\3\2\2\2\6\u0085\3\2\2\2\b\u0099\3\2\2\2\n\u00b1"+
		"\3\2\2\2\f\u00b3\3\2\2\2\16\u00b7\3\2\2\2\20\u00c4\3\2\2\2\22\u00f2\3"+
		"\2\2\2\24\u0122\3\2\2\2\26\u0126\3\2\2\2\30\u0128\3\2\2\2\32\u0137\3\2"+
		"\2\2\34\u014c\3\2\2\2\36\u014f\3\2\2\2 \u0153\3\2\2\2\"\u016a\3\2\2\2"+
		"$\u016e\3\2\2\2&\u0176\3\2\2\2(\u0182\3\2\2\2*\u018d\3\2\2\2,\u019a\3"+
		"\2\2\2.\u01b2\3\2\2\2\60\u01b7\3\2\2\2\62\u01b9\3\2\2\2\64\66\5.\30\2"+
		"\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28:\3\2\2\29\67\3\2"+
		"\2\2:;\7\2\2\3;\3\3\2\2\2<=\b\3\1\2=>\7\3\2\2>?\5\4\3\2?@\7\4\2\2@G\3"+
		"\2\2\2AB\t\2\2\2BG\5\4\3\21CG\5\n\6\2DG\5\22\n\2EG\7?\2\2F<\3\2\2\2FA"+
		"\3\2\2\2FC\3\2\2\2FD\3\2\2\2FE\3\2\2\2G\u0082\3\2\2\2HI\f\25\2\2IJ\7\5"+
		"\2\2J\u0081\5\4\3\26KL\f\20\2\2LM\t\3\2\2M\u0081\5\4\3\21NO\f\17\2\2O"+
		"P\t\4\2\2P\u0081\5\4\3\20QR\f\16\2\2RS\t\5\2\2S\u0081\5\4\3\17TU\f\r\2"+
		"\2UV\t\6\2\2V\u0081\5\4\3\16WX\f\f\2\2XY\t\7\2\2Y\u0081\5\4\3\rZ[\f\13"+
		"\2\2[\\\7\32\2\2\\\u0081\5\4\3\f]^\f\n\2\2^_\7\33\2\2_\u0081\5\4\3\13"+
		"`a\f\t\2\2ab\7\34\2\2b\u0081\5\4\3\ncd\f\b\2\2de\7\35\2\2e\u0081\5\4\3"+
		"\tfg\f\7\2\2gh\7\36\2\2h\u0081\5\4\3\bij\f\6\2\2jk\t\b\2\2k\u0081\5\4"+
		"\3\7lm\f\24\2\2mn\7\6\2\2no\5\4\3\2op\7\7\2\2p\u0081\3\2\2\2qr\f\23\2"+
		"\2r\u0081\t\t\2\2st\f\22\2\2tz\7\3\2\2uv\5\4\3\2vw\7\n\2\2wy\3\2\2\2x"+
		"u\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}~\5\4\3\2"+
		"~\177\7\4\2\2\177\u0081\3\2\2\2\u0080H\3\2\2\2\u0080K\3\2\2\2\u0080N\3"+
		"\2\2\2\u0080Q\3\2\2\2\u0080T\3\2\2\2\u0080W\3\2\2\2\u0080Z\3\2\2\2\u0080"+
		"]\3\2\2\2\u0080`\3\2\2\2\u0080c\3\2\2\2\u0080f\3\2\2\2\u0080i\3\2\2\2"+
		"\u0080l\3\2\2\2\u0080q\3\2\2\2\u0080s\3\2\2\2\u0081\u0084\3\2\2\2\u0082"+
		"\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\5\3\2\2\2\u0084\u0082\3\2\2\2"+
		"\u0085\u0086\7*\2\2\u0086\u0087\7?\2\2\u0087\u008f\7+\2\2\u0088\u0089"+
		"\7?\2\2\u0089\u008a\7,\2\2\u008a\u008b\5\4\3\2\u008b\u008c\7\n\2\2\u008c"+
		"\u008e\3\2\2\2\u008d\u0088\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2"+
		"\2\2\u008f\u0090\3\2\2\2\u0090\u0095\3\2\2\2\u0091\u008f\3\2\2\2\u0092"+
		"\u0093\7?\2\2\u0093\u0094\7,\2\2\u0094\u0096\5\4\3\2\u0095\u0092\3\2\2"+
		"\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\7-\2\2\u0098\7"+
		"\3\2\2\2\u0099\u009a\7\6\2\2\u009a\u009b\7\7\2\2\u009b\u009c\5\34\17\2"+
		"\u009c\u00a2\7\6\2\2\u009d\u009e\5\4\3\2\u009e\u009f\7\n\2\2\u009f\u00a1"+
		"\3\2\2\2\u00a0\u009d\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a7\5\4"+
		"\3\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\u00a9\7\7\2\2\u00a9\t\3\2\2\2\u00aa\u00b2\5\6\4\2\u00ab\u00b2\5\b\5\2"+
		"\u00ac\u00b2\7@\2\2\u00ad\u00b2\7=\2\2\u00ae\u00b2\7<\2\2\u00af\u00b2"+
		"\7>\2\2\u00b0\u00b2\7;\2\2\u00b1\u00aa\3\2\2\2\u00b1\u00ab\3\2\2\2\u00b1"+
		"\u00ac\3\2\2\2\u00b1\u00ad\3\2\2\2\u00b1\u00ae\3\2\2\2\u00b1\u00af\3\2"+
		"\2\2\u00b1\u00b0\3\2\2\2\u00b2\13\3\2\2\2\u00b3\u00b4\7?\2\2\u00b4\u00b5"+
		"\7,\2\2\u00b5\u00b6\5\34\17\2\u00b6\r\3\2\2\2\u00b7\u00b8\7*\2\2\u00b8"+
		"\u00b9\7?\2\2\u00b9\u00bf\7+\2\2\u00ba\u00bb\5\f\7\2\u00bb\u00bc\5\60"+
		"\31\2\u00bc\u00be\3\2\2\2\u00bd\u00ba\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf"+
		"\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00bf\3\2"+
		"\2\2\u00c2\u00c3\7-\2\2\u00c3\17\3\2\2\2\u00c4\u00c5\5\f\7\2\u00c5\u00c6"+
		"\7\37\2\2\u00c6\u00c7\5\4\3\2\u00c7\21\3\2\2\2\u00c8\u00ce\7\3\2\2\u00c9"+
		"\u00ca\5\f\7\2\u00ca\u00cb\7\n\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00c9\3\2"+
		"\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d3\5\f\7\2\u00d2\u00d1\3\2"+
		"\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\7\4\2\2\u00d5"+
		"\u00d6\7.\2\2\u00d6\u00d7\5\34\17\2\u00d7\u00db\7+\2\2\u00d8\u00da\5."+
		"\30\2\u00d9\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df\7-"+
		"\2\2\u00df\u00f3\3\2\2\2\u00e0\u00e6\7\3\2\2\u00e1\u00e2\5\f\7\2\u00e2"+
		"\u00e3\7\n\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00e1\3\2\2\2\u00e5\u00e8\3\2"+
		"\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8"+
		"\u00e6\3\2\2\2\u00e9\u00eb\5\f\7\2\u00ea\u00e9\3\2\2\2\u00ea\u00eb\3\2"+
		"\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\7\4\2\2\u00ed\u00ee\7.\2\2\u00ee"+
		"\u00ef\5\34\17\2\u00ef\u00f0\7/\2\2\u00f0\u00f1\5.\30\2\u00f1\u00f3\3"+
		"\2\2\2\u00f2\u00c8\3\2\2\2\u00f2\u00e0\3\2\2\2\u00f3\23\3\2\2\2\u00f4"+
		"\u00f5\7\60\2\2\u00f5\u00f6\7?\2\2\u00f6\u00fc\7\3\2\2\u00f7\u00f8\5\f"+
		"\7\2\u00f8\u00f9\7\n\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00f7\3\2\2\2\u00fb"+
		"\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u0100\3\2"+
		"\2\2\u00fe\u00fc\3\2\2\2\u00ff\u0101\5\f\7\2\u0100\u00ff\3\2\2\2\u0100"+
		"\u0101\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\7\4\2\2\u0103\u0104\7."+
		"\2\2\u0104\u0105\5\34\17\2\u0105\u0109\7+\2\2\u0106\u0108\5.\30\2\u0107"+
		"\u0106\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2"+
		"\2\2\u010a\u010c\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u010d\7-\2\2\u010d"+
		"\u0123\3\2\2\2\u010e\u010f\7\60\2\2\u010f\u0110\7?\2\2\u0110\u0116\7\3"+
		"\2\2\u0111\u0112\5\f\7\2\u0112\u0113\7\n\2\2\u0113\u0115\3\2\2\2\u0114"+
		"\u0111\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2"+
		"\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u011b\5\f\7\2\u011a"+
		"\u0119\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\7\4"+
		"\2\2\u011d\u011e\7.\2\2\u011e\u011f\5\34\17\2\u011f\u0120\7/\2\2\u0120"+
		"\u0121\5.\30\2\u0121\u0123\3\2\2\2\u0122\u00f4\3\2\2\2\u0122\u010e\3\2"+
		"\2\2\u0123\25\3\2\2\2\u0124\u0127\5\4\3\2\u0125\u0127\5\20\t\2\u0126\u0124"+
		"\3\2\2\2\u0126\u0125\3\2\2\2\u0127\27\3\2\2\2\u0128\u0129\7\61\2\2\u0129"+
		"\u012a\5\26\f\2\u012a\u012b\7\n\2\2\u012b\u012c\5\4\3\2\u012c\u012d\7"+
		"\n\2\2\u012d\u012e\5\4\3\2\u012e\u0132\7+\2\2\u012f\u0131\5.\30\2\u0130"+
		"\u012f\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2"+
		"\2\2\u0133\u0135\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0136\7-\2\2\u0136"+
		"\31\3\2\2\2\u0137\u0138\7\62\2\2\u0138\u0139\5\f\7\2\u0139\u013a\7\63"+
		"\2\2\u013a\u013b\5\4\3\2\u013b\u013c\7\64\2\2\u013c\u013d\5\4\3\2\u013d"+
		"\u0141\7+\2\2\u013e\u0140\5.\30\2\u013f\u013e\3\2\2\2\u0140\u0143\3\2"+
		"\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0144\3\2\2\2\u0143"+
		"\u0141\3\2\2\2\u0144\u0145\7-\2\2\u0145\33\3\2\2\2\u0146\u0147\7*\2\2"+
		"\u0147\u014d\7?\2\2\u0148\u0149\7\6\2\2\u0149\u014a\7\7\2\2\u014a\u014d"+
		"\5\34\17\2\u014b\u014d\7?\2\2\u014c\u0146\3\2\2\2\u014c\u0148\3\2\2\2"+
		"\u014c\u014b\3\2\2\2\u014d\35\3\2\2\2\u014e\u0150\5.\30\2\u014f\u014e"+
		"\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152"+
		"\37\3\2\2\2\u0153\u0154\7\65\2\2\u0154\u0155\5\4\3\2\u0155\u0156\7+\2"+
		"\2\u0156\u0157\5\36\20\2\u0157\u0160\7-\2\2\u0158\u0159\7\66\2\2\u0159"+
		"\u015a\5\4\3\2\u015a\u015b\7+\2\2\u015b\u015c\5\36\20\2\u015c\u015d\7"+
		"-\2\2\u015d\u015f\3\2\2\2\u015e\u0158\3\2\2\2\u015f\u0162\3\2\2\2\u0160"+
		"\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0168\3\2\2\2\u0162\u0160\3\2"+
		"\2\2\u0163\u0164\7\67\2\2\u0164\u0165\7+\2\2\u0165\u0166\5\36\20\2\u0166"+
		"\u0167\7-\2\2\u0167\u0169\3\2\2\2\u0168\u0163\3\2\2\2\u0168\u0169\3\2"+
		"\2\2\u0169!\3\2\2\2\u016a\u016b\5,\27\2\u016b\u016c\t\n\2\2\u016c\u016d"+
		"\5\4\3\2\u016d#\3\2\2\2\u016e\u016f\78\2\2\u016f\u0170\5\4\3\2\u0170\u0171"+
		"\7+\2\2\u0171\u0172\5\36\20\2\u0172\u0173\7-\2\2\u0173%\3\2\2\2\u0174"+
		"\u0177\5\4\3\2\u0175\u0177\7\67\2\2\u0176\u0174\3\2\2\2\u0176\u0175\3"+
		"\2\2\2\u0177\u0178\3\2\2\2\u0178\u0179\7.\2\2\u0179\u017d\7+\2\2\u017a"+
		"\u017c\5.\30\2\u017b\u017a\3\2\2\2\u017c\u017f\3\2\2\2\u017d\u017b\3\2"+
		"\2\2\u017d\u017e\3\2\2\2\u017e\u0180\3\2\2\2\u017f\u017d\3\2\2\2\u0180"+
		"\u0181\7-\2\2\u0181\'\3\2\2\2\u0182\u0183\79\2\2\u0183\u0184\5\4\3\2\u0184"+
		"\u0188\7+\2\2\u0185\u0187\5&\24\2\u0186\u0185\3\2\2\2\u0187\u018a\3\2"+
		"\2\2\u0188\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018b\3\2\2\2\u018a"+
		"\u0188\3\2\2\2\u018b\u018c\7-\2\2\u018c)\3\2\2\2\u018d\u018e\7:\2\2\u018e"+
		"\u018f\5\4\3\2\u018f+\3\2\2\2\u0190\u019b\5\24\13\2\u0191\u019b\5\20\t"+
		"\2\u0192\u019b\5\30\r\2\u0193\u019b\5\32\16\2\u0194\u019b\5\16\b\2\u0195"+
		"\u019b\5 \21\2\u0196\u019b\5(\25\2\u0197\u019b\5$\23\2\u0198\u019b\5*"+
		"\26\2\u0199\u019b\5\4\3\2\u019a\u0190\3\2\2\2\u019a\u0191\3\2\2\2\u019a"+
		"\u0192\3\2\2\2\u019a\u0193\3\2\2\2\u019a\u0194\3\2\2\2\u019a\u0195\3\2"+
		"\2\2\u019a\u0196\3\2\2\2\u019a\u0197\3\2\2\2\u019a\u0198\3\2\2\2\u019a"+
		"\u0199\3\2\2\2\u019b-\3\2\2\2\u019c\u01b3\5\24\13\2\u019d\u019e\5\20\t"+
		"\2\u019e\u019f\5\60\31\2\u019f\u01b3\3\2\2\2\u01a0\u01b3\5\30\r\2\u01a1"+
		"\u01b3\5\32\16\2\u01a2\u01a3\5\16\b\2\u01a3\u01a4\5\60\31\2\u01a4\u01b3"+
		"\3\2\2\2\u01a5\u01b3\5 \21\2\u01a6\u01a7\5\"\22\2\u01a7\u01a8\5\60\31"+
		"\2\u01a8\u01b3\3\2\2\2\u01a9\u01b3\5$\23\2\u01aa\u01b3\5(\25\2\u01ab\u01ac"+
		"\5*\26\2\u01ac\u01ad\5\60\31\2\u01ad\u01b3\3\2\2\2\u01ae\u01af\5\4\3\2"+
		"\u01af\u01b0\5\60\31\2\u01b0\u01b3\3\2\2\2\u01b1\u01b3\5\62\32\2\u01b2"+
		"\u019c\3\2\2\2\u01b2\u019d\3\2\2\2\u01b2\u01a0\3\2\2\2\u01b2\u01a1\3\2"+
		"\2\2\u01b2\u01a2\3\2\2\2\u01b2\u01a5\3\2\2\2\u01b2\u01a6\3\2\2\2\u01b2"+
		"\u01a9\3\2\2\2\u01b2\u01aa\3\2\2\2\u01b2\u01ab\3\2\2\2\u01b2\u01ae\3\2"+
		"\2\2\u01b2\u01b1\3\2\2\2\u01b3/\3\2\2\2\u01b4\u01b8\7\2\2\3\u01b5\u01b8"+
		"\6\31\21\2\u01b6\u01b8\6\31\22\2\u01b7\u01b4\3\2\2\2\u01b7\u01b5\3\2\2"+
		"\2\u01b7\u01b6\3\2\2\2\u01b8\61\3\2\2\2\u01b9\u01ba\7D\2\2\u01ba\63\3"+
		"\2\2\2&\67Fz\u0080\u0082\u008f\u0095\u00a2\u00a6\u00b1\u00bf\u00ce\u00d2"+
		"\u00db\u00e6\u00ea\u00f2\u00fc\u0100\u0109\u0116\u011a\u0122\u0126\u0132"+
		"\u0141\u014c\u0151\u0160\u0168\u0176\u017d\u0188\u019a\u01b2\u01b7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}