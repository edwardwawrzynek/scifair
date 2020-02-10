package compiler.ast_visitors

import compiler.ast.*
import compiler.compilerError
import parser.*

/**
 * Turn the context specific parse tree (CST) produced by antlr into an Abstract Syntax Tree (AST) for language 1
 */

class CSTToASTLang1: Lang1BaseVisitor<ASTNode>() {
    /** Construct top level ast node */
    override fun visitProgram(ctx: Lang1Parser.ProgramContext): ASTNode {
        return ASTProgram(ASTLoc(ctx.start), ctx.expr().map {
            expr: Lang1Parser.ExprContext ->
                visitExpr(expr)}
        )
    }

    override fun visitLineComment(ctx: Lang1Parser.LineCommentContext): ASTNode {
        return ASTComment(ASTLoc(ctx.start), ctx.text.slice(1 until ctx.text.length))
    }

    override fun visitBlankLine(ctx: Lang1Parser.BlankLineContext): ASTNode {
        return ASTComment(ASTLoc(ctx.start), "", true)
    }

    /** type expressions */
    fun visitTypeExpr(ctx: Lang1Parser.TypeExprContext): ASTType = when(ctx) {
        is Lang1Parser.StructTypeExprContext -> ASTStructType(ASTLoc(ctx.start), ctx.name.text)
        is Lang1Parser.ArrayTypeExprContext -> ASTArrayType(ASTLoc(ctx.start), visitTypeExpr(ctx.type))
        is Lang1Parser.PlainTypeContext -> stringTypeToASTType(ctx.type.text, ASTLoc(ctx.start))
        else -> compilerError("no such type class: ${ctx.javaClass}")
    }

    override fun visitStructTypeExpr(ctx: Lang1Parser.StructTypeExprContext): ASTNode = visitTypeExpr(ctx)
    override fun visitArrayTypeExpr(ctx: Lang1Parser.ArrayTypeExprContext): ASTNode = visitTypeExpr(ctx)
    override fun visitPlainType(ctx: Lang1Parser.PlainTypeContext): ASTNode = visitTypeExpr(ctx)

    /** function binding and assignment */
    override fun visitFuncDeclExpr(ctx: Lang1Parser.FuncDeclExprContext): ASTNode {
        val funcType = ASTFunctionType(
                ASTLoc(ctx.start),
                visitTypeExpr(ctx.ret_type),
                ctx.varDecl().map {arg -> visitTypeExpr(arg.type)}
        )
        return ASTVarDecl(
                ASTLoc(ctx.start),
                ctx.name.text,
                funcType,
                ASTFuncBinding(
                        ASTLoc(ctx.start),
                        ctx.varDecl().map {arg -> arg.name.text},
                        funcType,
                        ctx.expr().map {expr -> visitExpr(expr)}
                )
        )
    }

    override fun visitLambdaExpr(ctx: Lang1Parser.LambdaExprContext): ASTNode {
        return ASTFuncBinding(
                ASTLoc(ctx.start),
                ctx.varDecl().map {v -> v.name.text},
                ASTFunctionType(
                        ASTLoc(ctx.start),
                        visitTypeExpr(ctx.ret_type),
                        ctx.varDecl().map {v -> visitTypeExpr(v.type) }
                ),
                ctx.expr().map {expr -> visitExpr(expr)}
        )
    }

    override fun visitVarDeclExpr(ctx: Lang1Parser.VarDeclExprContext): ASTNode {
        return ASTVarDecl(
                ASTLoc(ctx.start),
                ctx.`var`.name.text,
                visitTypeExpr(ctx.`var`.type),
                visitExpr(ctx.value)
        )
    }

    override fun visitForExpr(ctx: Lang1Parser.ForExprContext): ASTNode {
        return ASTForLoop(
                ASTLoc(ctx.start),
                visitExpr(ctx.initial),
                visitExpr(ctx.cond),
                visitExpr(ctx.end),
                ctx.expr().filterIndexed {index, _ -> index >= 3}.map {expr -> visitExpr(expr)}
        )
    }

    override fun visitStructDeclExpr(ctx: Lang1Parser.StructDeclExprContext): ASTNode {
        return ASTStructDecl(
                ASTLoc(ctx.start),
                ctx.varDecl().map {
                    field -> ASTStructFieldType(
                        field.name.text,
                        visitTypeExpr(field.type))
                },
                ctx.name.text
        )
    }

    override fun visitVarExpr(ctx: Lang1Parser.VarExprContext): ASTNode {
        return ASTVarExpr(ASTLoc(ctx.start), ctx.text)
    }

    override fun visitFuncCallExpr(ctx: Lang1Parser.FuncCallExprContext): ASTNode {
        return ASTFuncApplication(
                ASTLoc(ctx.start),
                visitExpr(ctx.func),
                ctx.expr()
                        .filterIndexed { index, _ -> index > 0}
                        .map { expr -> visitExpr(expr)}
        )
    }

    override fun visitAssignExpr(ctx: Lang1Parser.AssignExprContext): ASTNode {
        return ASTAssignment(
                ASTLoc(ctx.start),
                visitExpr(ctx.left),
                visitExpr(ctx.right)
        )
    }

    override fun visitCondExpr(ctx: Lang1Parser.CondExprContext): ASTNode {
        return ASTConditional(
                ASTLoc(ctx.start),
                ctx.condEntry().map {entry -> visitExpr(entry.cond)},
                ctx.condEntry().map {entry ->
                    entry.expr()
                            .filterIndexed {index, _ -> index > 0}
                            .map {expr -> visitExpr(expr)}
                }
        )
    }

    override fun visitNullLiteral(ctx: Lang1Parser.NullLiteralContext) = ASTNullLiteral(ASTLoc(ctx.start))

    override fun visitNumLiteral(ctx: Lang1Parser.NumLiteralContext) = ASTIntLiteral(ASTLoc(ctx.start), ctx.value.text.toLong())

    override fun visitStrLiteral(ctx: Lang1Parser.StrLiteralContext) = ASTStringLiteral(ASTLoc(ctx.start), ctx.value.text)

    override fun visitFloatLiteral(ctx: Lang1Parser.FloatLiteralContext) = ASTFloatLiteral(ASTLoc(ctx.start), ctx.value.text.toDouble())

    override fun visitBooleanLiteral(ctx: Lang1Parser.BooleanLiteralContext) = ASTBoolLiteral(ASTLoc(ctx.start), ctx.value.text?.toBoolean() ?: compilerError("boolean value ${ctx.value.text} is not valid", ASTLoc(ctx.start)))

    override fun visitStructExpr(ctx: Lang1Parser.StructExprContext): ASTNode {
        val fields = mutableListOf<ASTStructField>()
        for(i in 0 until ctx.expr().size) {
            fields += ASTStructField(
                    ctx.ID(i+1).text,
                    visitExpr(ctx.expr(i))
            )
        }
        return ASTStructLiteral(
                ASTLoc(ctx.start),
                ASTStructType(ASTLoc(ctx.start), ctx.name.text),
                fields
        )
    }

    override fun visitArrayExpr(ctx: Lang1Parser.ArrayExprContext): ASTNode {
        return ASTArrayLiteral(
                ASTLoc(ctx.start),
                ASTArrayType(ASTLoc(ctx.start), visitTypeExpr(ctx.type)),
                ctx.expr().map {expr -> visitExpr(expr)}
        )
    }
}