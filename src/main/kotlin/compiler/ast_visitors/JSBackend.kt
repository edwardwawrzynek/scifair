package compiler.ast_visitors

import compiler.ast.*

/**
 * A Javascript backend for the ast
 * doesn't do any kind of ast verification
 * no symbol tables, type checking, etc
 * It emits badly formatted code
 * TODO: a real backend
 */

class JSBackend(val emit: Emitter): ASTBaseVisitor<Unit>(Unit) {

    fun emit(msg: String) {
        emit.emit(msg, 0)
    }

    override fun visitASTProgram(node: ASTProgram) {
        for(n in node.nodes) {
            visitASTNode(n)
            emit(";\n")
        }
    }

    override fun visitASTComment(node: ASTComment) {
        emit("//${node.comment}")
    }

    override fun visitASTSTructDecl(node: ASTStructDecl) {
        emit("class ${node.name} {\n")
        emit("constructor({")
        node.type.map {field -> emit("${field.name}, ")}
        emit("}) {\n")
        node.type.map {field -> emit("this.${field.name} = ${field.name};\n")}
        emit("}\n}")
    }

    override fun visitASTStructLiteral(node: ASTStructLiteral) {
        emit("(new ${node.type.typeName}({")
        node.value.map { entry ->
            emit("${entry.name}: ")
            visitASTNode(entry.value)
            emit(", ")
        }
        emit("}))")
    }

    override fun visitASTVarDecl(node: ASTVarDecl) {
        emit("let ${node.name} = ")
        visitASTNode(node.initialValue)
    }
}