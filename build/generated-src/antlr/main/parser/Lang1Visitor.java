// Generated from parser/Lang1.g4 by ANTLR 4.7.2

	package parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Lang1Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Lang1Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Lang1Parser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(Lang1Parser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link Lang1Parser#funcName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncName(Lang1Parser.FuncNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link Lang1Parser#funcCallExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallExpr(Lang1Parser.FuncCallExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Lang1Parser#structExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructExpr(Lang1Parser.StructExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Lang1Parser#arrayExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(Lang1Parser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code structLiteral}
	 * labeled alternative in {@link Lang1Parser#literalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructLiteral(Lang1Parser.StructLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayLiteral}
	 * labeled alternative in {@link Lang1Parser#literalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(Lang1Parser.ArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code strLiteral}
	 * labeled alternative in {@link Lang1Parser#literalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrLiteral(Lang1Parser.StrLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numLiteral}
	 * labeled alternative in {@link Lang1Parser#literalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumLiteral(Lang1Parser.NumLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link Lang1Parser#literalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullLiteral(Lang1Parser.NullLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatLiteral}
	 * labeled alternative in {@link Lang1Parser#literalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatLiteral(Lang1Parser.FloatLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanLiteral}
	 * labeled alternative in {@link Lang1Parser#literalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(Lang1Parser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Lang1Parser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(Lang1Parser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link Lang1Parser#structDeclExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclExpr(Lang1Parser.StructDeclExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Lang1Parser#varDeclExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclExpr(Lang1Parser.VarDeclExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Lang1Parser#lambdaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpr(Lang1Parser.LambdaExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Lang1Parser#funcDeclExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDeclExpr(Lang1Parser.FuncDeclExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Lang1Parser#forExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForExpr(Lang1Parser.ForExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code structTypeExpr}
	 * labeled alternative in {@link Lang1Parser#typeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructTypeExpr(Lang1Parser.StructTypeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayTypeExpr}
	 * labeled alternative in {@link Lang1Parser#typeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayTypeExpr(Lang1Parser.ArrayTypeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plainType}
	 * labeled alternative in {@link Lang1Parser#typeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlainType(Lang1Parser.PlainTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Lang1Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(Lang1Parser.ExprContext ctx);
}