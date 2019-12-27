package compiler.ast_visitors

import compiler.ast.*
import parser.*
import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.tree.TerminalNode

/**
 * Turn the context specific parse tree (CST) produced by antlr into an Abstract Syntax Tree (AST) for language 1
 */

class CSTToASTLang1: Lang1BaseVisitor<ASTNode>() {
    /** Construct top level ast node */
    override fun visitProgram(ctx: Lang1Parser.ProgramContext): ASTNode {
        return ASTProgram(ctx.expr().map {
            expr: Lang1Parser.ExprContext ->
                visitExpr(expr)}
        )
    }

    fun visitTypeExpr(ctx: Lang1Parser.TypeExprContext): ASTType = when(ctx) {
        is Lang1Parser.StructTypeExprContext -> ASTStructType(ctx.name.text)
        is Lang1Parser.ArrayExprContext -> ASTArrayType(visitTypeExpr(ctx.type))
        is Lang1Parser.PlainTypeContext -> stringTypeToASTType(ctx.type.text, ASTNodeLocation.fromToken(ctx.start))
        else -> error("no such type class: ${ctx.javaClass}")
    }

    override fun visitFuncDeclExpr(ctx: Lang1Parser.FuncDeclExprContext): ASTNode {
        return ASTVarDecl(
                ctx.name.text,
                ASTFunctionType(
                        visitTypeExpr(ctx.ret_type),
                        ctx.varDecl().map {arg -> visitTypeExpr(arg.type)}
                ),
                ASTFuncBinding(
                        ctx.varDecl().map {arg -> arg.name.text},
                        ctx.varDecl().map {arg -> visitTypeExpr(arg.type)},
                        ctx.expr().map {expr -> visitExpr(expr)}
                )
        )
    }
}