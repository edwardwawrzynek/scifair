package compiler.ast_visitors

import compiler.ast.*
import compiler.compilerError
import parser.*

/**
 * Turn the context specific parse tree (CST) produced by antlr into an Abstract Syntax Tree (AST) for language 2
 */

class CSTToASTLang2: Lang2BaseVisitor<ASTNode>() {
    override fun visitProgram(ctx: Lang2Parser.ProgramContext): ASTNode {
        return ASTProgram(
                ASTLoc(ctx.start),
                ctx.statement().map {stat -> visitStatement(stat)}
        )
    }

    override fun visitStatement(ctx: Lang2Parser.StatementContext): ASTNode {
        /* TODO: make each statement rule a labeled rule in grammar so that we can have a type checking when instead
            of these clunky null checks
         */
        if(ctx.expr() !== null) return visitExpr(ctx.expr())
        if(ctx.varDeclExpr() !== null) return visitVarDeclExpr(ctx.varDeclExpr())
        if(ctx.returnStatement() !== null) return visitReturnStatement(ctx.returnStatement())
        if(ctx.structDeclExpr() !== null) return visitStructDeclExpr(ctx.structDeclExpr())
        if(ctx.ifStatement() !== null) return visitIfStatement(ctx.ifStatement())
        if(ctx.funcDeclExpr() !== null) return visitFuncDeclExpr(ctx.funcDeclExpr())
        if(ctx.forExpr() !== null) return visitForExpr(ctx.forExpr())
        if(ctx.blankLine() !== null) return ASTComment(ASTLoc(ctx.start), "", true)
        if(ctx.lineComment() !== null) return ASTComment(ASTLoc(ctx.start), ctx.lineComment().text.substring(2))

        compilerError("No such statement type: ${ctx.javaClass}", ASTLoc(ctx.start))
    }

    override fun visitIfStatement(ctx: Lang2Parser.IfStatementContext): ASTNode {
        var conds = ctx.expr().map {c -> visitExpr(c)}
        val bodies = ctx.ifStatmentBody().map {b -> b.statement().map {s -> visitStatement(s)}}
        if(bodies.size != conds.size) {
            /* check for else clause and insert true expression to compensate if needed */
            if(bodies.size - 1 == conds.size) conds = conds + ASTBoolLiteral(ASTLoc(ctx.start), true)
            else {
                compilerError("number of conditions and number of bodies does not match", ASTLoc(ctx.start))
            }
        }
        return ASTConditional(
                ASTLoc(ctx.start),
                conds,
                bodies
        )
    }

    override fun visitFuncDeclExpr(ctx: Lang2Parser.FuncDeclExprContext): ASTNode {
        val type = ASTFunctionType(
                ASTLoc(ctx.start),
                visitTypeExpr(ctx.ret_type),
                ctx.varDecl().map {a -> visitTypeExpr(a.typeExpr())}
        )
        return ASTVarDecl(
                ASTLoc(ctx.start),
                ctx.name.text,
                type,
                ASTFuncBinding(
                        ASTLoc(ctx.start),
                        ctx.varDecl().map {a -> a.name.text},
                        type,
                        ctx.statement().map {s -> visitStatement(s)}
                )
        )
    }

    override fun visitForExpr(ctx: Lang2Parser.ForExprContext): ASTNode {
        return ASTForLoop(
                ASTLoc(ctx.start),
                visitStatement(ctx.initial),
                visitExpr(ctx.cond),
                visitExpr(ctx.end),
                ctx.statement().filterIndexed {index, _ -> index >= 1}.map {s -> visitStatement(s)}
        )
    }

    override fun visitStructDeclExpr(ctx: Lang2Parser.StructDeclExprContext): ASTNode {
        return ASTStructDecl(
                ASTLoc(ctx.start),
                ctx.varDecl().map {field -> ASTStructFieldType(field.ID().text, visitTypeExpr(field.typeExpr())) },
                ctx.name.text
        )
    }

    override fun visitReturnStatement(ctx: Lang2Parser.ReturnStatementContext): ASTNode {
        /* return statement is a function call in ast */
        return ASTFuncApplication(
                ASTLoc(ctx.start),
                ASTVarExpr(ASTLoc(ctx.start), "return"),
                listOf(visitExpr(ctx.expr()))
        )
    }

    override fun visitVarDeclExpr(ctx: Lang2Parser.VarDeclExprContext): ASTNode {
        return ASTVarDecl(
                ASTLoc(ctx.start),
                ctx.`var`.name.text,
                visitTypeExpr(ctx.`var`.type),
                visitExpr(ctx.expr())
        )
    }

    override fun visitStructExpr(ctx: Lang2Parser.StructExprContext): ASTNode {
        return ASTStructLiteral(
                ASTLoc(ctx.start),
                ASTStructType(ASTLoc(ctx.start), ctx.name.text),
                ctx.expr().indices.map {i -> ASTStructField(ctx.ID(i+1).text, visitExpr(ctx.expr(i)))}
        )
    }

    override fun visitArrayExpr(ctx: Lang2Parser.ArrayExprContext): ASTNode {
        return ASTArrayLiteral(
                ASTLoc(ctx.start),
                ASTArrayType(ASTLoc(ctx.start), visitTypeExpr(ctx.typeExpr())),
                ctx.expr().map {expr -> visitExpr(expr)}
        )
    }

    fun visitTypeExpr(ctx: Lang2Parser.TypeExprContext): ASTType = when(ctx) {
        is Lang2Parser.StructTypeExprContext -> visitStructTypeExpr(ctx)
        is Lang2Parser.ArrayTypeExprContext -> visitArrayTypeExpr(ctx)
        is Lang2Parser.PlainTypeContext -> visitPlainType(ctx)
        else -> compilerError("no such type expression ${ctx.javaClass}", ASTLoc(ctx.start))
    }

    override fun visitStructTypeExpr(ctx: Lang2Parser.StructTypeExprContext): ASTType {
        return ASTStructType(
                ASTLoc(ctx.start),
                ctx.name.text
        )
    }

    override fun visitArrayTypeExpr(ctx: Lang2Parser.ArrayTypeExprContext): ASTType {
        return ASTArrayType(
                ASTLoc(ctx.start),
                visitTypeExpr(ctx.type)
        )
    }

    override fun visitPlainType(ctx: Lang2Parser.PlainTypeContext): ASTType {
        return stringTypeToASTType(ctx.type.text, ASTLoc(ctx.start))
    }

    fun visitExpr(ctx: Lang2Parser.ExprContext): ASTNode = when(ctx) {
        is Lang2Parser.LitExprContext -> visitLiteralExpr(ctx.literalExpr())
        is Lang2Parser.ParenExprContext -> visitExpr(ctx.expr())
        is Lang2Parser.AssignmentExprContext -> visitAssignmentExpr(ctx)
        is Lang2Parser.VarExprContext -> ASTVarExpr(ASTLoc(ctx.start), ctx.ID().text)
        is Lang2Parser.DotExprContext -> ASTFuncApplication(
                ASTLoc(ctx.start),
                ASTVarExpr(ASTLoc(ctx.start), "."),
                listOf(visitExpr(ctx.varName), visitExpr(ctx.sub)))
        is Lang2Parser.ArraySubExprContext -> ASTFuncApplication(
                ASTLoc(ctx.start),
                ASTVarExpr(ASTLoc(ctx.start), "[]"),
                listOf(visitExpr(ctx.varName), visitExpr(ctx.sub)))
        is Lang2Parser.PostfixExprContext -> ASTFuncApplication(
                ASTLoc(ctx.start),
                ASTVarExpr(ASTLoc(ctx.start), ctx.op.text),
                listOf(visitExpr(ctx.varName))
        )
        is Lang2Parser.PrefixExprContext -> ASTFuncApplication(
                ASTLoc(ctx.start),
                ASTVarExpr(ASTLoc(ctx.start), ctx.op.text),
                listOf(visitExpr(ctx.varName))
        )
        is Lang2Parser.InfixExprContext -> ASTFuncApplication(
                ASTLoc(ctx.start),
                ASTVarExpr(ASTLoc(ctx.start), ctx.op.text),
                listOf(visitExpr(ctx.left), visitExpr(ctx.right))
        )
        is Lang2Parser.FuncExprContext -> visitFuncExpr(ctx)
        is Lang2Parser.ClosureExprContext -> visitClosureExpr(ctx)
        else -> compilerError("no such expr type: ${ctx.javaClass}", ASTLoc(ctx.start))
    }

    override fun visitAssignmentExpr(ctx: Lang2Parser.AssignmentExprContext): ASTNode {
        if(ctx.op.text == "=") return ASTAssignment(ASTLoc(ctx.start), visitExpr(ctx.left), visitExpr(ctx.right))
        else {
            /* compound assignment */
            if(!ctx.op.text.endsWith("=")) compilerError("compound operator doesn't end with =", ASTLoc(ctx.start))
            val op = ctx.op.text.substring(0 until ctx.op.text.length-1)
            return ASTAssignment(
                    ASTLoc(ctx.start),
                    visitExpr(ctx.left),
                    ASTFuncApplication(
                            ASTLoc(ctx.start),
                            ASTVarExpr(ASTLoc(ctx.start), op),
                            listOf(visitExpr(ctx.left), visitExpr(ctx.right))
                    )
            )
        }
    }

    override fun visitClosureExpr(ctx: Lang2Parser.ClosureExprContext): ASTNode {
        return ASTFuncBinding(
                ASTLoc(ctx.start),
                ctx.lambdaExpr().varDecl().map {v -> v.name.text},
                ASTFunctionType(
                        ASTLoc(ctx.start),
                        visitTypeExpr(ctx.lambdaExpr().ret_type),
                        ctx.lambdaExpr().varDecl().map {v -> visitTypeExpr(v.type)}
                        ),
                ctx.lambdaExpr().statement().map {s -> visitStatement(s)}
        )
    }

    override fun visitFuncExpr(ctx: Lang2Parser.FuncExprContext): ASTNode {
        return ASTFuncApplication(
                ASTLoc(ctx.start),
                visitExpr(ctx.func),
                ctx.expr().filterIndexed {index, _ -> index >= 1}.map {expr -> visitExpr(expr)}
        )
    }

    fun visitLiteralExpr(ctx: Lang2Parser.LiteralExprContext): ASTNode = when(ctx) {
        is Lang2Parser.StructLiteralContext -> visitStructExpr(ctx.structExpr())
        is Lang2Parser.ArrayLiteralContext -> visitArrayExpr(ctx.arrayExpr())
        is Lang2Parser.StrLiteralContext -> ASTStringLiteral(ASTLoc(ctx.start), ctx.value.text)
        is Lang2Parser.NumLiteralContext -> ASTIntLiteral(ASTLoc(ctx.start), ctx.value.text.toLong())
        is Lang2Parser.NullLiteralContext -> ASTNullLiteral(ASTLoc(ctx.start))
        is Lang2Parser.FloatLiteralContext -> ASTFloatLiteral(ASTLoc(ctx.start), ctx.value.text.toDouble())
        is Lang2Parser.BooleanLiteralContext -> ASTBoolLiteral(ASTLoc(ctx.start), ctx.value.text!!.toBoolean())
        else -> compilerError("no such literal type ${ctx.javaClass}", ASTLoc(ctx.start))
    }

}