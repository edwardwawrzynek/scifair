package compiler.ast_visitors

import compiler.ast.*
import compiler.compilerError

/** Generate a source program from a abstract syntax tree for lang1 */
class ASTToPrgLang1(val emit: Emitter): ASTBaseVisitor<Unit>(Unit) {

    var indent = 0

    fun emit(msg: String, indnt: Int = indent) {
        emit.emit(msg, indnt)
    }

    override fun visitASTProgram(node: ASTProgram) {
        for(n in node.nodes) {
            visitASTNode(n)
            emit("\n")
        }
        return defaultValue
    }

    override fun visitASTSTructDecl(node: ASTStructDecl) {
        emit("(defstruct ${node.name} (\n")
        for(field_i in node.type.indices) {
            val field = node.type[field_i]
            emit("(${field.name} ", indent+1)
            visitASTType(field.type)
            emit(")", indent+1)
            if(field_i < node.type.size - 1) emit("\n", indent + 1)
        }
        emit("))")

    }

    override fun visitASTStructLiteral(node: ASTStructLiteral) {
        emit("(struct ${node.type.typeName} (")
        for(field_i in node.value.indices) {
            val field = node.value[field_i]
            emit("(${field.name} ")
            visitASTNode(field.value)
            emit(")")
            if(field_i < node.value.size -1 ) emit(" ")
        }
        emit("))")
    }

    override fun visitASTArrayLiteral(node: ASTArrayLiteral) {
        emit("(array ")
        visitASTType((node.type as ASTArrayType).type)
        emit(" (")
        for(i in node.value.indices) {
            val value = node.value[i]
            visitASTNode(value)
            if(i < node.value.size -1 ) emit(" ")
        }
        emit("))")
    }

    override fun visitASTLiteral(node: ASTLiteral) {
        when(node) {
            is ASTStructLiteral -> visitASTStructLiteral(node)
            is ASTArrayLiteral -> visitASTArrayLiteral(node)
            else -> emit("${node.value}")
        }
    }

    private fun visitFuncArgsAndBody(func: ASTFuncBinding) {
        visitASTType(func.type.returnType)
        emit(" (")
        for(i in func.argNames.indices) {
            val arg = func.argNames[i]
            val type = func.type.argTypes[i]

            emit("(${arg} ")
            visitASTType(type)
            emit(")")
            if(i < func.argNames.size -1) emit(" ")
        }
        emit(")")
        indent++
        for(expr in func.body) {
            emit("\n")
            visitASTNode(expr)
        }
        indent--
    }

    override fun visitASTVarDecl(node: ASTVarDecl) {
        if(node.type === null) compilerError("uninferred type on variable", node.loc)
        /* handle function declaration special case */
        if(node.type is ASTFunctionType) {
            emit("(defun ${node.name} ")
            visitFuncArgsAndBody(node.initialValue as ASTFuncBinding)
            emit(")")
        } else {
            emit("(setq (${node.name} ")
            visitASTType(node.type)
            emit(") ")
            visitASTNode(node.initialValue)
            emit(")")
        }
    }

    override fun visitASTFuncApplication(node: ASTFuncApplication) {
        emit("(")
        visitASTNode(node.expr)
        for(arg in node.args) {
            emit(" ")
            visitASTNode(arg)
        }
        emit(")")
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
            is ASTStructType -> emit("(struct ${node.typeName})")
            is ASTArrayType -> {
                emit("(array ")
                visitASTType(node.type)
                emit(")")
            }
            is ASTFunctionType -> compilerError("can't emit function types yet", node.loc)
        }
    }

    override fun visitASTAssignment(node: ASTAssignment) {
        emit("(= ")
        visitASTNode(node.left)
        emit(" ")
        visitASTNode(node.right)
        emit(")")
    }

    override fun visitASTConditional(node: ASTConditional) {
        emit("(cond")
        indent++
        for(i in node.conditions.indices) {
            val cond = node.conditions[i]
            val body = node.bodies[i]
            emit("\n(")
            visitASTNode(cond)
            emit(" (")
            /* single expression bodies go on inline */
            if(body.size == 1) {
                visitASTNode(body[0])
            } else {
                indent++
                for(expr in body) {
                    emit("\n")
                    visitASTNode(expr)
                }
                indent--
            }
            emit("))")
        }
        indent--
        emit(")")
    }

    override fun visitASTFuncBinding(node: ASTFuncBinding) {
        emit("(lambda ")
        visitFuncArgsAndBody(node)
        emit(")")
    }

    override fun visitASTForLoop(node: ASTForLoop) {
        emit("(for ")
        visitASTNode(node.initial)
        emit(" ")
        visitASTNode(node.condition)
        emit(" ")
        visitASTNode(node.end)
        emit(" (")
        indent++
        for(expr in node.body) {
            emit("\n")
            visitASTNode(expr)
        }
        indent--
        emit("))")
    }
}