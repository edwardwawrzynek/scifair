package compiler.ast_visitors

import compiler.ast.*
import compiler.compilerError

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
            is ASTStructType -> emit("struct ${node.typeName}")
            is ASTArrayType -> {
                visitASTType(node.type)
                emit("[]")
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
            }
            indent--
            emit("\n}")
            if(i < node.conditions.size - 1) emit(" ")
        }
    }

    override fun visitASTFuncBinding(node: ASTFuncBinding) {
        visitASTType(node.type.returnType)
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
        }
        indent--
        emit("\n}")
    }
}