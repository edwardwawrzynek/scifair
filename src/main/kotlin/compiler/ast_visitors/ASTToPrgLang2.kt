package compiler.ast_visitors

import compiler.ast.*
import compiler.compilerError

/* Function names that receive special handling in output */
private val specialFunctionNames = listOf("return", ".", "[]", "++", "--", "!", "~", "*", "/", "%", "+", "-", "<<", ">>", "<", "<=", ">=", "==", "!=", "&", "|", "^", "&&", "||")

private val prefixOps = listOf("!", "~")
private val postFixOps = listOf("++", "--")

/* operators that have compound equivalents */
private val compoundEquivOps = listOf("+", "-", "*", "/", "%", "<<", ">>", "&", "^", "|")

/* order of operations for special functions */
private val funcOrderOps = listOf(
        listOf("."),
        listOf("[]"),
        listOf("++", "--"),
        listOf("!", "~"),
        listOf("*", "/", "%"),
        listOf("+", "-"),
        listOf("<<", ">>"),
        listOf("<", "<=", ">", ">="),
        listOf("==", "!="),
        listOf("&"),
        listOf("|"),
        listOf("^"),
        listOf("&&"),
        listOf("||")
)

/** Generate a source program from a abstract syntax tree for lang2
 * There is a bit of pattern matching that has to be performed on the ast, but most of the transformations are straightforward */
class ASTToPrgLang2(val emit: Emitter): ASTBaseVisitor<Unit>(Unit) {

    var indent = 0

    fun emit(msg: String, indnt: Int = indent) {
        emit.emit(msg, indnt)
    }

    override fun visitASTComment(node: ASTComment) {
        if(!node.isBlankLine) emit("//${node.comment}")
    }

    /* if a ASTNode needs a semicolon after it (assuming it is a statment) */
    private fun needsSemicolon(node: ASTNode) = when(node) {
        is ASTVarDecl -> {
            /* function declarations don't need a semicolon */
            node.initialValue !is ASTFuncBinding
        }
        is ASTForLoop, is ASTConditional, is ASTComment -> false
        else -> true
    }

    override fun visitASTProgram(node: ASTProgram) {
        for(n in node.nodes) {
            visitASTNode(n)
            if(needsSemicolon(n)) emit(";")
            emit("\n")
        }
        return defaultValue
    }

    override fun visitASTSTructDecl(node: ASTStructDecl) {
        emit("struct ${node.name} {")
        for(field_i in node.type.indices) {
            indent++
            val field = node.type[field_i]
            emit("\n")
            visitASTType(field.type)
            emit(" ${field.name};")
            indent--
        }
        emit("\n}")

    }

    override fun visitASTStructLiteral(node: ASTStructLiteral) {
        emit("(struct ${node.type.typeName}) {")
        for(field_i in node.value.indices) {
            val field = node.value[field_i]
            emit(" .${field.name} = ")
            visitASTNode(field.value)
            if(field_i < node.value.size -1 ) emit(",")
        }
        emit(" }")
    }

    override fun visitASTArrayLiteral(node: ASTArrayLiteral) {
        emit("(")
        visitASTType((node.type))
        emit(") {")
        for(i in node.value.indices) {
            val value = node.value[i]
            visitASTNode(value)
            if(i < node.value.size -1 ) emit(", ")
        }
        emit("}")
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

            visitASTType(type)
            emit(" ${arg}")
            if(i < func.argNames.size -1) emit(", ")
        }
        emit(") {")
        indent++
        for(expr in func.body) {
            emit("\n")
            visitASTNode(expr)
            if(needsSemicolon(expr)) emit(";")
        }
        indent--
        emit("\n}")
    }

    override fun visitASTVarDecl(node: ASTVarDecl) {
        if(node.type === null) compilerError("uninferred type on variable", node.loc)
        /* handle function declaration special case */
        if(node.type is ASTFunctionType) {
            visitASTType(node.type.returnType)
            emit(" ${node.name} ")
            visitFuncArgsAndBody(node.initialValue as ASTFuncBinding)
            emit("")
        } else {
            visitASTType(node.type)
            emit(" ${node.name} = ")
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
                visitASTType(node.type)
                emit("[]")
            }
            is ASTFunctionType -> compilerError("can't emit function types yet", node.loc)
        }
    }

    private fun compareASTNode(a: ASTNode, b: ASTNode): Boolean {
        if(a.javaClass != b.javaClass) return false
        if(a.javaClass.kotlin.members != b.javaClass.kotlin.members) return false
        return true
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
        for(i in node.conditions.indices) {
            val cond = node.conditions[i]
            val body = node.bodies[i]
            if(cond is ASTBoolLiteral && cond.value == true) {
                emit("else ")
            } else {
                if (i == 0) emit("if (")
                else emit("else if (")

                visitASTNode(cond)
                emit(") ")
            }
            emit("{")
            indent++
            for(expr in body) {
                emit("\n")
                visitASTNode(expr)
                if(needsSemicolon(expr)) emit(";")
            }
            indent--
            emit("\n}")
            if(i < node.conditions.size - 1) emit(" ")
        }
    }

    override fun visitASTFuncBinding(node: ASTFuncBinding) {
        visitASTType(node.type.returnType)
        emit(" ")
        visitFuncArgsAndBody(node)
    }

    override fun visitASTForLoop(node: ASTForLoop) {
        emit("for (")
        visitASTNode(node.initial)
        emit("; ")
        visitASTNode(node.condition)
        emit("; ")
        visitASTNode(node.end)
        emit(") {")
        indent++
        for(expr in node.body) {
            emit("\n")
            visitASTNode(expr)
            if(needsSemicolon(expr)) emit(";")
        }
        indent--
        emit("\n}")
    }
}