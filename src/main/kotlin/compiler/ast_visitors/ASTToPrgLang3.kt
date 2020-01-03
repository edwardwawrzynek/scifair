package compiler.ast_visitors

import compiler.ast.*
import compiler.compilerError

/** Generate a source program from a abstract syntax tree for lang3
 * Pattern matching is used for the special forms of general cases present in Lang3 */
class ASTToPrgLang3(val emit: Emitter): ASTBaseVisitor<Unit>(Unit) {

    var indent = 0

    fun emit(msg: String, indnt: Int = indent) {
        emit.emit(msg, indnt)
    }

    override fun visitASTComment(node: ASTComment) {
        if(!node.isBlankLine) emit("#${node.comment}")
    }

    override fun visitASTProgram(node: ASTProgram) {
        for(n in node.nodes) {
            visitASTNode(n)
            emit("\n")
        }
    }

    override fun visitASTSTructDecl(node: ASTStructDecl) {
        emit("struct ${node.name} {")
        for(field_i in node.type.indices) {
            indent++
            val field = node.type[field_i]
            emit("\n")
            emit("${field.name}: ")
            visitASTType(field.type)
            indent--
        }
        emit("\n}")

    }

    override fun visitASTStructLiteral(node: ASTStructLiteral) {
        emit("struct ${node.type.typeName} {")
        for(field_i in node.value.indices) {
            val field = node.value[field_i]
            emit("${field.name}: ")
            visitASTNode(field.value)
            if(field_i < node.value.size -1 ) emit(", ")
        }
        emit("}")
    }

    override fun visitASTArrayLiteral(node: ASTArrayLiteral) {
        emit("")
        visitASTType((node.type))
        emit(" [")
        for(i in node.value.indices) {
            val value = node.value[i]
            visitASTNode(value)
            if(i < node.value.size -1 ) emit(", ")
        }
        emit("]")
    }

    override fun visitASTLiteral(node: ASTLiteral) {
        when(node) {
            is ASTStructLiteral -> visitASTStructLiteral(node)
            is ASTArrayLiteral -> visitASTArrayLiteral(node)
            else -> emit("${node.value}")
        }
    }

    private fun visitFuncArgsAndBody(func: ASTFuncBinding) {
        emit("(")
        for(i in func.argNames.indices) {
            val arg = func.argNames[i]
            val type = func.type.argTypes[i]

            emit("${arg}: ")
            visitASTType(type)
            if(i < func.argNames.size -1) emit(", ")
        }
        emit(") -> ")
        visitASTType(func.type.returnType)
        val isInlineBody = func.body.size == 1
        if(isInlineBody) emit(" => ") else emit(" {")
        indent++
        for(expr in func.body) {
            if(!isInlineBody) emit("\n")
            visitASTNode(expr)
        }
        indent--
        if(!isInlineBody) emit("\n}")
    }

    override fun visitASTVarDecl(node: ASTVarDecl) {
        if(node.type === null) compilerError("uninferred type on variable", node.loc)
        /* handle function declaration special case */
        if(node.type is ASTFunctionType) {
            emit("fn ${node.name} ")
            visitFuncArgsAndBody(node.initialValue as ASTFuncBinding)
            emit("")
        } else {
            emit("${node.name}: ")
            visitASTType(node.type)
            emit(" = ")
            visitASTNode(node.initialValue)
        }
    }

    /* find order of operation index of op (lower num -> higher precedence */
    private fun findOpPrecedence(op: String): Int? {
        for(i in funcOrderOps.indices) {
            if(op in funcOrderOps[i]) return i
        }

        return null
    }

    override fun visitASTFuncApplication(node: ASTFuncApplication) {
        /* handle infix, postfix, prefix, return, and array operators */
        if(node.expr is ASTVarExpr && node.expr.name in specialFunctionNames) {
            val op = node.expr.name
            val opPrec = findOpPrecedence(op)
            if(op == "return") {
                emit("return ")
                if(node.args.size != 1) compilerError("return only accepts one parameter", node.loc)
                visitASTNode(node.args[0])
            } else if(op == "[]") {
                if(opPrec === null) compilerError("can't find precedence for operator $op", node.loc)
                if(node.args.size != 2) compilerError("[] only accepts one parameter", node.loc)
                if(node.args[0] is ASTFuncApplication && (node.args[0] as ASTFuncApplication).expr is ASTVarExpr) {
                    val argOp = (node.args[0] as ASTFuncApplication).expr as ASTVarExpr
                    val prec = findOpPrecedence(argOp.name)
                    if(prec != null && prec > opPrec) {
                        emit("(")
                        visitASTNode(node.args[0])
                        emit(")")
                    } else {
                        visitASTNode(node.args[0])
                    }
                } else {
                    visitASTNode(node.args[0])
                }
                emit("[")
                visitASTNode(node.args[1])
                emit("]")
            } else {
                if(opPrec === null) compilerError("can't find precedence for operator $op", node.loc)
                if(op in prefixOps || op in postFixOps){
                    if(node.args.size != 1) compilerError("function ${op} takes one arg", node.loc)
                }
                else {
                    if(node.args.size != 2) compilerError("function ${op} takes two args", node.loc)
                }
                if(op in prefixOps) emit(op)

                for(arg_i in node.args.indices) {
                    var arg = node.args[arg_i]

                    /* determine if parenthesis are needed */
                    if(arg is ASTFuncApplication && arg.expr is ASTVarExpr) {
                        val argPrec = findOpPrecedence((arg.expr as ASTVarExpr).name)
                        if(argPrec !== null && argPrec > opPrec) {
                            emit("(")
                            visitASTNode(arg)
                            emit(")")
                        } else {
                            visitASTNode(arg)
                        }
                    } else {
                        visitASTNode(arg)
                    }

                    if(!(op in prefixOps || op in postFixOps) && arg_i < node.args.size - 1) {
                        if(op == ".") emit(op)
                        else emit(" $op ")
                    }
                }

                if(op in postFixOps) emit(op)
            }
        } else {
            visitASTNode(node.expr)
            emit("(")
            for(arg_i in node.args.indices) {
                val arg = node.args[arg_i]
                visitASTNode(arg)
                if(arg_i < node.args.size - 1) emit(", ")
            }
            emit(")")
        }
    }

    override fun visitASTVarExpr(node: ASTVarExpr) {
        emit("${node.name}")
    }

    override fun visitASTType(node: ASTType) {
        when(node) {
            is ASTStringType -> emit("string")
            is ASTIntType -> emit("int")
            is ASTFloatType -> emit("float")
            is ASTBoolType -> emit("bool")
            is ASTAnyStructType -> emit("any")
            is ASTStructType -> emit("struct ${node.typeName}")
            is ASTArrayType -> {
                emit("[]")
                visitASTType(node.type)
            }
            is ASTFunctionType -> compilerError("can't emit function types yet", node.loc)
        }
    }

    override fun visitASTAssignment(node: ASTAssignment) {
        /* handle compound assignments */
        if(node.right is ASTFuncApplication && node.right.expr is ASTVarExpr && node.right.expr.name in compoundEquivOps && compareASTNode(node.left, node.right.args[0])) {
            visitASTNode(node.left)
            emit(" ${node.right.expr.name}= ")
            visitASTNode(node.right.args[1])
        } else {
            visitASTNode(node.left)
            emit(" = ")
            visitASTNode(node.right)
        }
    }

    override fun visitASTConditional(node: ASTConditional) {
        /* check for unless */
        val isUnless = node.conditions[0] is ASTFuncApplication && (node.conditions[0] as ASTFuncApplication).expr is ASTVarExpr && ((node.conditions[0] as ASTFuncApplication).expr as ASTVarExpr).name == "!"

        /* check for switch statement */
        var isSwitch = true
        var switchNumberEqChecks = 0
        var switchValueBeingChecked: ASTNode? = null
        for(cond in node.conditions) {
            /* check that condition is not an equality check and not a true literal (else clause) */
            if(!(cond is ASTFuncApplication && cond.expr is ASTVarExpr && cond.expr.name == "==") && !(cond is ASTBoolLiteral && cond.value)) {
                isSwitch = false
                break
            }
            if((cond is ASTFuncApplication && cond.expr is ASTVarExpr && cond.expr.name == "==")) {
                switchNumberEqChecks++
                /* make sure equality check is happening on the sam variable */
                if(switchValueBeingChecked == null) switchValueBeingChecked = cond.args[0]
                else if(!compareASTNode(cond.args[0], switchValueBeingChecked)) {
                    isSwitch = false
                    break
                }
            }
        }
        /* switch needs at least two equality checks */
        if(switchNumberEqChecks < 2) isSwitch = false

        /* handle inline if */
        if(node.conditions.size == 1 && node.bodies[0].size == 1) {
            visitASTNode(node.bodies[0][0])
            if(isUnless){
                emit(" unless ")
                /* remove not operation */
                visitASTNode((node.conditions[0] as ASTFuncApplication).args[0])
            } else {
                emit(" if ")
                visitASTNode(node.conditions[0])
            }
        }
        /* handle unless conditional */
        else if(node.conditions.size == 1 && isUnless) {
            emit("unless ")
            /* remove not operation */
            visitASTNode((node.conditions[0] as ASTFuncApplication).args[0])
            emit(" {")
            indent++
            for (expr in node.bodies[0]) {
                emit("\n")
                visitASTNode(expr)
            }
            indent--
            emit("\n}")

        }
        /* handle switch statement */
        else if(isSwitch) {
            emit("switch ")
            visitASTNode((node.conditions[0] as ASTFuncApplication).args[0])
            emit(" {")
            indent++
            for(case_i in node.conditions.indices) {
                emit("\n")
                if(node.conditions[case_i] is ASTBoolLiteral) {
                    emit("else")
                } else {
                    visitASTNode((node.conditions[case_i] as ASTFuncApplication).args[1])
                }
                emit(" -> {")
                indent++
                node.bodies[case_i].map {stat ->
                    emit("\n")
                    visitASTNode(stat)
                }
                indent--
                emit("\n}")
            }
            indent--
            emit("\n}")

        } else {
            for (i in node.conditions.indices) {
                val cond = node.conditions[i]
                val body = node.bodies[i]
                if (cond is ASTBoolLiteral && cond.value == true) {
                    emit("else")
                } else {
                    if (i == 0) emit("if ")
                    else emit("elsif ")

                    visitASTNode(cond)
                }
                emit(" {")
                indent++
                for (expr in body) {
                    emit("\n")
                    visitASTNode(expr)
                }
                indent--
                emit("\n}")
                if (i < node.conditions.size - 1) emit(" ")
            }
        }
    }

    override fun visitASTFuncBinding(node: ASTFuncBinding) {
        visitFuncArgsAndBody(node)
    }

    override fun visitASTForLoop(node: ASTForLoop) {
        emit("for ")
        visitASTNode(node.initial)
        emit(", ")
        visitASTNode(node.condition)
        emit(", ")
        visitASTNode(node.end)
        emit(" {")
        indent++
        for(expr in node.body) {
            emit("\n")
            visitASTNode(expr)
        }
        indent--
        emit("\n}")
    }
}