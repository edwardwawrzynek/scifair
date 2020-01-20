package compiler.ast_visitors

import compiler.ast.*
import compiler.compilerError

/**
 * Symbol table implementation
 * Basically just a linked list of tables
 */
class Symbol(val type: ASTType)

class SymbolTable(val parentTable: SymbolTable?) {
    private val table = HashMap<String, Symbol>()

    fun findSymbol(sym: String): Symbol? {
        if(table[sym] != null) return table[sym]
        if(parentTable != null) return parentTable.findSymbol(sym)
        return null
    }

    fun addSymbol(name: String, sym: Symbol) {
        table[name] = sym
    }
}

/**
 * A Javascript backend for the ast
 * All visitor methods return the type of the node they visited, or null if node doesn't have a type (statement, etc)
 */
class JSBackend(val emit: Emitter): ASTBaseVisitor<ASTType?>(null) {

    companion object {
        val structTypeTable = SymbolTable(null)
    }

    fun emit(msg: String) {
        emit.emit(msg, 0)
    }

    override fun visitASTProgram(node: ASTProgram): ASTType? {
        for(n in node.nodes) {
            visitASTNode(n)
            emit(";\n")
        }

        return null
    }

    override fun visitASTComment(node: ASTComment): ASTType? {
        emit("/*${node.comment}*/")
        return null
    }

    /**
     * visit a structure declaration, and add a type to the structure table
     */
    override fun visitASTSTructDecl(node: ASTStructDecl): ASTType? {
        emit("class ${node.name} {\n")
        emit("constructor({")
        node.type.map {field -> emit("${field.name}, ")}
        emit("}) {\n")
        node.type.map {field -> emit("this.${field.name} = ${field.name};\n")}
        emit("}\n}")

        /* add entry to struct table */
        val type = ASTFullStructType(node.loc, node.type, node.name)

        structTypeTable.addSymbol(node.name, Symbol(type))

        return null
    }

    /**** Literals ****/

    /**
     * visit a structure literal
     * mostly just checking that the supplied fields match the structure's type
     */
    override fun visitASTStructLiteral(node: ASTStructLiteral): ASTType? {
        /** lookup struct type in symbol table **/
        val type = structTypeTable.findSymbol(node.type.typeName)
        if(type === null) {
            compilerError("no such structure type '${node.type.typeName}'", node.loc)
        }

        emit("(new ${node.type.typeName}({")
        val specifiedFields = mutableListOf<String>()
        node.value.map { entry ->
            /* make sure struct has field */
            if(entry.name !in (type.type as ASTFullStructType).fields.map {f -> f.name}
            ) {
                compilerError("structure type '${node.type.typeName}' does not have field '${entry.name}'", node.loc)
            }
            emit("${entry.name}: ")
            val fieldType = visitASTNode(entry.value)
            /* make sure type of value matches expected type for field */
            val expectedType = type.type.fields.find { f -> f.name == entry.name}!!.type
            if(fieldType == null) {
                compilerError("initial value for field '${entry.name}' must be an expression", node.loc)
            } else if(fieldType != expectedType) {
                compilerError("field '${entry.name}' of structure '${node.type.typeName}' is expected to be type '${expectedType}', but was initialized to type '${fieldType}'", node.loc)
            }
            emit(", ")
            specifiedFields.add(entry.name)
        }
        emit("}))")

        /* make sure all fields were specified */
        (type.type as ASTFullStructType).fields.forEach {
            field ->
            if(field.name !in specifiedFields)
                compilerError("field '${field.name}' in structure type '${node.type.typeName}' not initialized", node.loc)
        }

        return type.type
    }

    override fun visitASTIntLiteral(node: ASTIntLiteral): ASTType? {
        emit("${node.value}")

        return ASTIntType(node.loc)
    }

    override fun visitASTStringLiteral(node: ASTStringLiteral): ASTType? {
        emit(node.value)

        return ASTStringType(node.loc)
    }

    override fun visitASTNullLiteral(node: ASTNullLiteral): ASTType? {
        emit("null")

        return ASTAnyStructType(node.loc)
    }

    override fun visitASTVarDecl(node: ASTVarDecl): ASTType? {
        emit("let ${node.name} = ")
        visitASTNode(node.initialValue)

        return null
    }
}