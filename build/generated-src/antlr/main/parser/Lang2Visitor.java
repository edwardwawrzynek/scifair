// Generated from parser/Lang2.g4 by ANTLR 4.7.2

	package parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Lang2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Lang2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Lang2Parser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(Lang2Parser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentExpr}
	 * labeled alternative in {@link Lang2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpr(Lang2Parser.AssignmentExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link Lang2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpr(Lang2Parser.PrefixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link Lang2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExpr(Lang2Parser.VarExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code closureExpr}
	 * labeled alternative in {@link Lang2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClosureExpr(Lang2Parser.ClosureExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dotExpr}
	 * labeled alternative in {@link Lang2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotExpr(Lang2Parser.DotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link Lang2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixExpr(Lang2Parser.InfixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link Lang2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncExpr(Lang2Parser.FuncExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arraySubExpr}
	 * labeled alternative in {@link Lang2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraySubExpr(Lang2Parser.ArraySubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postfixExpr}
	 * labeled alternative in {@link Lang2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpr(Lang2Parser.PostfixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code litExpr}
	 * labeled alternative in {@link Lang2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLitExpr(Lang2Parser.LitExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link Lang2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(Lang2Parser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Lang2Parser#structExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructExpr(Lang2Parser.StructExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Lang2Parser#arrayExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(Lang2Parser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code structLiteral}
	 * labeled alternative in {@link Lang2Parser#literalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructLiteral(Lang2Parser.StructLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayLiteral}
	 * labeled alternative in {@link Lang2Parser#literalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(Lang2Parser.ArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code strLiteral}
	 * labeled alternative in {@link Lang2Parser#literalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrLiteral(Lang2Parser.StrLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numLiteral}
	 * labeled alternative in {@link Lang2Parser#literalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumLiteral(Lang2Parser.NumLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link Lang2Parser#literalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullLiteral(Lang2Parser.NullLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatLiteral}
	 * labeled alternative in {@link Lang2Parser#literalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatLiteral(Lang2Parser.FloatLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanLiteral}
	 * labeled alternative in {@link Lang2Parser#literalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(Lang2Parser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Lang2Parser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(Lang2Parser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link Lang2Parser#structDeclExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclExpr(Lang2Parser.StructDeclExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Lang2Parser#varDeclExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclExpr(Lang2Parser.VarDeclExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Lang2Parser#lambdaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpr(Lang2Parser.LambdaExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Lang2Parser#funcDeclExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDeclExpr(Lang2Parser.FuncDeclExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Lang2Parser#forExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForExpr(Lang2Parser.ForExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayTypeExpr}
	 * labeled alternative in {@link Lang2Parser#typeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayTypeExpr(Lang2Parser.ArrayTypeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code structTypeExpr}
	 * labeled alternative in {@link Lang2Parser#typeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructTypeExpr(Lang2Parser.StructTypeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plainType}
	 * labeled alternative in {@link Lang2Parser#typeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlainType(Lang2Parser.PlainTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Lang2Parser#ifStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatment(Lang2Parser.IfStatmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Lang2Parser#returnStatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatment(Lang2Parser.ReturnStatmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Lang2Parser#statment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatment(Lang2Parser.StatmentContext ctx);
}