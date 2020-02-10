package compiler.ast_visitors

import compiler.ast.*
import compiler.compilerError
import parser.*

class CSTToASTLang3: Lang3BaseVisitor<ASTNode>() {
    override fun visitProgram(ctx: Lang3Parser.ProgramContext): ASTNode {
        return ASTProgram(
                ASTLoc(ctx.start),
                ctx.statement().map {stat -> visitStatement(stat)}
        )
    }

    override fun visitVarDeclExpr(ctx: Lang3Parser.VarDeclExprContext): ASTNode {
        return ASTVarDecl(
                ASTLoc(ctx.start),
                ctx.`var`.name.text,
                visitTypeExpr(ctx.`var`.type),
                visitExpr(ctx.value)
        )
    }

    fun visitStatement(ctx: Lang3Parser.StatementContext): ASTNode = when(ctx) {
        is Lang3Parser.StatementFuncDeclStatementContext -> visitFuncDeclExpr(ctx.funcDeclExpr())
        is Lang3Parser.StatementVarDeclStatementContext -> visitVarDeclExpr(ctx.varDeclExpr())
        is Lang3Parser.StatementForStatementContext -> visitForExpr(ctx.forExpr())
        is Lang3Parser.StatementStructDeclStatementContext -> visitStructDeclExpr(ctx.structDeclExpr())
        is Lang3Parser.StatementIfStatementContext -> visitIfStatement(ctx.ifStatement())
        is Lang3Parser.StatementInlineIfStatementContext -> visitInlineIfStatement(ctx.inlineIfStatement())
        is Lang3Parser.StatementUnlessIfStatementContext -> visitUnlessIfStatement(ctx.unlessIfStatement())
        is Lang3Parser.StatementSwitchStatementContext -> visitSwitchStatement(ctx.switchStatement())
        is Lang3Parser.StatementReturnStatementContext -> visitReturnStatement(ctx.returnStatement())
        is Lang3Parser.StatementExprStatementContext -> visitExpr(ctx.expr())
        is Lang3Parser.StatementLineCommentContext -> visitLineComment(ctx.lineComment())
        is Lang3Parser.StatementRangeStatementContext -> visitRangeExpr(ctx.rangeExpr())
        else -> compilerError("no such statement class ${ctx.javaClass}", ASTLoc(ctx.start))
    }

    fun visitInlineIfBodyStatement(ctx: Lang3Parser.InlineIfBodyStatementContext): ASTNode = when(ctx) {
        is Lang3Parser.InlineIfFuncDeclStatementContext -> visitFuncDeclExpr(ctx.funcDeclExpr())
        is Lang3Parser.InlineIfVarDeclStatementContext -> visitVarDeclExpr(ctx.varDeclExpr())
        is Lang3Parser.InlineIfForStatementContext -> visitForExpr(ctx.forExpr())
        is Lang3Parser.InlineIfStructDeclStatementContext -> visitStructDeclExpr(ctx.structDeclExpr())
        is Lang3Parser.InlineIfIfStatementContext -> visitIfStatement(ctx.ifStatement())
        is Lang3Parser.InlineIfUnlessIfStatementContext -> visitUnlessIfStatement(ctx.unlessIfStatement())
        is Lang3Parser.InlineIfSwitchStatementContext -> visitSwitchStatement(ctx.switchStatement())
        is Lang3Parser.InlineIfReturnStatementContext -> visitReturnStatement(ctx.returnStatement())
        is Lang3Parser.InlineIfExprStatementContext -> visitExpr(ctx.expr())
        is Lang3Parser.InlineRangeExprStatementContext -> visitRangeExpr(ctx.rangeExpr())
        else -> compilerError("no such statement class ${ctx.javaClass}", ASTLoc(ctx.start))
    }

    override fun visitLineComment(ctx: Lang3Parser.LineCommentContext): ASTNode {
        return ASTComment(ASTLoc(ctx.start), ctx.text.substring(1))
    }

    override fun visitStructDeclExpr(ctx: Lang3Parser.StructDeclExprContext): ASTNode {
        return ASTStructDecl(
                ASTLoc(ctx.start),
                ctx.varDecl().map {field -> ASTStructFieldType(field.name.text, visitTypeExpr(field.type)) },
                ctx.name.text
        )
    }

    override fun visitIfStatement(ctx: Lang3Parser.IfStatementContext): ASTNode {
        var conds = ctx.expr().map {c -> visitExpr(c)}
        val bodies = ctx.ifStatementBody().map {b -> b.statement().map {s -> visitStatement(s)}}
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

    override fun visitInlineIfStatement(ctx: Lang3Parser.InlineIfStatementContext): ASTNode {
        val isUnless = ctx.type.text == "unless"
        return ASTConditional(
                ASTLoc(ctx.start),
                listOf(
                        if(isUnless) ASTFuncApplication(
                                ASTLoc(ctx.start),
                                ASTVarExpr(ASTLoc(ctx.start), "!"),
                                listOf(visitExpr(ctx.cond))
                        )
                        else visitExpr(ctx.cond)),
                listOf(listOf(visitInlineIfBodyStatement(ctx.body)))
        )
    }

    override fun visitUnlessIfStatement(ctx: Lang3Parser.UnlessIfStatementContext): ASTNode {
        return ASTConditional(
                ASTLoc(ctx.start),
                listOf(ASTFuncApplication(
                        ASTLoc(ctx.start),
                        ASTVarExpr(ASTLoc(ctx.start), "!"),
                        listOf(visitExpr(ctx.cond))
                )),
                listOf(ctx.ifStatementBody().statement().map {b -> visitStatement(b)})
        )
    }

    override fun visitSwitchStatement(ctx: Lang3Parser.SwitchStatementContext): ASTNode {
        val valueExpr = visitExpr(ctx.value)
        return ASTConditional(
                ASTLoc(ctx.start),
                ctx.switchCase().map {c ->
                    if(c.cond === null) ASTBoolLiteral(ASTLoc(ctx.start), true) else ASTFuncApplication(ASTLoc(ctx.start), ASTVarExpr(ASTLoc(ctx.start), "=="), listOf(valueExpr, visitExpr(c.cond)))
                },
                ctx.switchCase().map {c -> c.statement().map {b -> visitStatement(b)}}
        )
    }

    override fun visitFuncDeclExpr(ctx: Lang3Parser.FuncDeclExprContext): ASTNode {
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

    override fun visitReturnStatement(ctx: Lang3Parser.ReturnStatementContext): ASTNode {
        return ASTFuncApplication(
                ASTLoc(ctx.start),
                ASTVarExpr(ASTLoc(ctx.start), "return"),
                listOf(visitExpr(ctx.value))
        )
    }

    override fun visitForExpr(ctx: Lang3Parser.ForExprContext): ASTNode {
        return ASTForLoop(
                ASTLoc(ctx.start),
                if(ctx.initial.expr() !== null) visitExpr(ctx.initial.expr()) else visitVarDeclExpr(ctx.initial.varDeclExpr()),
                visitExpr(ctx.cond),
                visitExpr(ctx.end),
                ctx.statement().map {b -> visitStatement(b)}
        )
    }

    override fun visitRangeExpr(ctx: Lang3Parser.RangeExprContext): ASTNode {
        /* generate for loop from range form
        * for loop initial setups variable, condition is < end, end is var++ */
        return ASTForLoop(
            ASTLoc(ctx.start),
            ASTVarDecl(
                ASTLoc(ctx.start),
                ctx.varDecl().name.text,
                visitTypeExpr(ctx.varDecl().typeExpr()),
                visitExpr(ctx.low)
            ),
            ASTFuncApplication(
                ASTLoc(ctx.start),
                ASTVarExpr(ASTLoc(ctx.start), "<"),
                listOf(ASTVarExpr(ASTLoc(ctx.start), ctx.varDecl().name.text), visitExpr(ctx.high))
            ),
            ASTAssignment(ASTLoc(ctx.start),
                ASTVarExpr(ASTLoc(ctx.start), ctx.varDecl().name.text),
                ASTFuncApplication(ASTLoc(ctx.start),
                    ASTVarExpr(ASTLoc(ctx.start), "+"),
                    listOf(
                        ASTVarExpr(ASTLoc(ctx.start), ctx.varDecl().name.text),
                        ASTIntLiteral(ASTLoc(ctx.start), 1)
                    )
                )
            ),
            ctx.statement().map { s -> visitStatement(s) }
        )
    }

    fun visitTypeExpr(ctx: Lang3Parser.TypeExprContext): ASTType = when(ctx) {
        is Lang3Parser.StructTypeExprContext -> visitStructTypeExpr(ctx)
        is Lang3Parser.ArrayTypeExprContext -> visitArrayTypeExpr(ctx)
        is Lang3Parser.PlainTypeContext -> visitPlainType(ctx)
        else -> compilerError("no such type expression ${ctx.javaClass}", ASTLoc(ctx.start))
    }

    override fun visitStructTypeExpr(ctx: Lang3Parser.StructTypeExprContext): ASTType {
        return ASTStructType(
                ASTLoc(ctx.start),
                ctx.name.text
        )
    }

    override fun visitArrayTypeExpr(ctx: Lang3Parser.ArrayTypeExprContext): ASTType {
        return ASTArrayType(
                ASTLoc(ctx.start),
                visitTypeExpr(ctx.type)
        )
    }

    override fun visitPlainType(ctx: Lang3Parser.PlainTypeContext): ASTType {
        return stringTypeToASTType(ctx.type.text, ASTLoc(ctx.start))
    }

    fun visitExpr(ctx: Lang3Parser.ExprContext): ASTNode = when(ctx) {
        is Lang3Parser.LitExprContext -> visitLiteralExpr(ctx.literalExpr())
        is Lang3Parser.ParenExprContext -> visitExpr(ctx.expr())
        is Lang3Parser.AssignmentExprContext -> visitAssignmentExpr(ctx)
        is Lang3Parser.VarExprContext -> ASTVarExpr(ASTLoc(ctx.start), ctx.ID().text)
        is Lang3Parser.DotExprContext -> ASTFuncApplication(
                ASTLoc(ctx.start),
                ASTVarExpr(ASTLoc(ctx.start), "."),
                listOf(visitExpr(ctx.varName), visitExpr(ctx.sub)))
        is Lang3Parser.ArraySubExprContext -> ASTFuncApplication(
                ASTLoc(ctx.start),
                ASTVarExpr(ASTLoc(ctx.start), "[]"),
                listOf(visitExpr(ctx.varName), visitExpr(ctx.sub)))
        is Lang3Parser.PostfixExprContext -> ASTFuncApplication(
                ASTLoc(ctx.start),
                ASTVarExpr(ASTLoc(ctx.start), ctx.op.text),
                listOf(visitExpr(ctx.varName))
        )
        is Lang3Parser.PrefixExprContext -> ASTFuncApplication(
                ASTLoc(ctx.start),
                ASTVarExpr(ASTLoc(ctx.start), ctx.op.text),
                listOf(visitExpr(ctx.varName))
        )
        is Lang3Parser.InfixExprContext -> ASTFuncApplication(
                ASTLoc(ctx.start),
                ASTVarExpr(ASTLoc(ctx.start), ctx.op.text),
                listOf(visitExpr(ctx.left), visitExpr(ctx.right))
        )
        is Lang3Parser.FuncExprContext -> visitFuncExpr(ctx)
        is Lang3Parser.ClosureExprContext -> visitClosureExpr(ctx)
        else -> compilerError("no such expr type: ${ctx.javaClass}", ASTLoc(ctx.start))
    }

    override fun visitAssignmentExpr(ctx: Lang3Parser.AssignmentExprContext): ASTNode {
        return if(ctx.op.text == "=") ASTAssignment(ASTLoc(ctx.start), visitExpr(ctx.left), visitExpr(ctx.right))
        else {
            /* compound assignment */
            if(!ctx.op.text.endsWith("=")) compilerError("compound operator doesn't end with =", ASTLoc(ctx.start))
            val op = ctx.op.text.substring(0 until ctx.op.text.length-1)
            ASTAssignment(
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

    override fun visitClosureExpr(ctx: Lang3Parser.ClosureExprContext): ASTNode {
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

    override fun visitFuncExpr(ctx: Lang3Parser.FuncExprContext): ASTNode {
        return ASTFuncApplication(
                ASTLoc(ctx.start),
                visitExpr(ctx.func),
                ctx.expr().filterIndexed {index, _ -> index >= 1}.map {expr -> visitExpr(expr)}
        )
    }

    fun visitLiteralExpr(ctx: Lang3Parser.LiteralExprContext): ASTNode = when(ctx) {
        is Lang3Parser.StructLiteralContext -> visitStructExpr(ctx.structExpr())
        is Lang3Parser.ArrayLiteralContext -> visitArrayExpr(ctx.arrayExpr())
        is Lang3Parser.StrLiteralContext -> ASTStringLiteral(ASTLoc(ctx.start), ctx.value.text)
        is Lang3Parser.NumLiteralContext -> ASTIntLiteral(ASTLoc(ctx.start), ctx.value.text.toLong())
        is Lang3Parser.NullLiteralContext -> ASTNullLiteral(ASTLoc(ctx.start))
        is Lang3Parser.FloatLiteralContext -> ASTFloatLiteral(ASTLoc(ctx.start), ctx.value.text.toDouble())
        is Lang3Parser.BooleanLiteralContext -> ASTBoolLiteral(ASTLoc(ctx.start), ctx.value.text!!.toBoolean())
        else -> compilerError("no such literal type ${ctx.javaClass}", ASTLoc(ctx.start))
    }

    override fun visitStructExpr(ctx: Lang3Parser.StructExprContext): ASTNode {
        return ASTStructLiteral(
                ASTLoc(ctx.start),
                ASTStructType(ASTLoc(ctx.start), ctx.name.text),
                ctx.expr().indices.map {i -> ASTStructField(ctx.ID(i+1).text, visitExpr(ctx.expr(i)))}
        )
    }

    override fun visitArrayExpr(ctx: Lang3Parser.ArrayExprContext): ASTNode {
        return ASTArrayLiteral(
                ASTLoc(ctx.start),
                ASTArrayType(ASTLoc(ctx.start), visitTypeExpr(ctx.typeExpr())),
                ctx.expr().map {expr -> visitExpr(expr)}
        )
    }
}