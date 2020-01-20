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


    private val structTypeTable = SymbolTable(null)
    /* start symbol table with a global symbol table */
    private val symbolTableList = mutableListOf<SymbolTable>(SymbolTable(null))

    init {
        /* TODO: read builtins from file */
        getSymbolTable().addSymbol("print", Symbol(ASTFunctionType(null, ASTIntType(null), listOf(ASTStringType(null)))))
    }

    private fun pushSymbolTable() {
        symbolTableList.add(SymbolTable(getSymbolTable()))
    }

    private fun popSymbolTable() {
        symbolTableList.removeAt(symbolTableList.size - 1)
    }

    private fun getSymbolTable(): SymbolTable {
        return symbolTableList.last()
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

    /** visit an array literal, checking the types of each value match the expected type */
    override fun visitASTArrayLiteral(node: ASTArrayLiteral): ASTType? {
        emit("[")

        node.value.forEach { entry ->
            val type = visitASTNode(entry)
            emit(", ")

            if(type == null) {
                compilerError("expected an expression", entry.loc)
            } else if(type != (node.type as ASTArrayType).type) {
                compilerError("expected an expression of type '${node.type.type}', but expression is of type '${type}'", entry.loc)
            }
        }
        emit("]")

        return node.type
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

    override fun visitASTFloatLiteral(node: ASTFloatLiteral): ASTType? {
        emit("${node.value}")

        return ASTFloatType(node.loc)
    }

    override fun visitASTBoolLiteral(node: ASTBoolLiteral): ASTType? {
        emit("${node.value}")

        return ASTBoolType(node.loc)
    }


    /** visit a variable declaration */
    override fun visitASTVarDecl(node: ASTVarDecl): ASTType? {
        emit("let ${node.name} = ")
        val initType = visitASTNode(node.initialValue)
        if(node.type != null && initType != node.type) {
            compilerError("initial value is expected to be of type '${node.type}, but is of type '${initType}'", node.loc)
        }

        val realType = if(initType is ASTAnyStructType && node.type != null)
            node.type
        else
            initType

        if(getSymbolTable().findSymbol(node.name) != null) {
            compilerError("redefinition or shadowing of variable '${node.name}'", node.loc)
        }

        getSymbolTable().addSymbol(node.name, Symbol(realType!!))

        return realType
    }

    /** visit a function expression */
    override fun visitASTFuncBinding(node: ASTFuncBinding): ASTType? {
        pushSymbolTable()
        emit("((")
        var i = 0
        node.argNames.forEach {
            arg ->
            emit("${arg}, ")
            /* add argument entry to symbol table */
            getSymbolTable().addSymbol(arg, Symbol(node.type.argTypes[i]))
            i++
        }
        emit(") => {\n")


        node.body.forEach { stmnt ->
            visitASTNode(stmnt)
        }

        emit("})")

        popSymbolTable()

        return node.type
    }

    override fun visitASTFuncApplication(node: ASTFuncApplication): ASTType? {
        if(node.expr is ASTVarExpr && node.expr.name in specialFunctionNames) {
            /* handle function call with special syntax */
            val func = node.expr.name

            if(func == "return") {
                emit("return ")
                if(node.args.size != 1) compilerError("return must be invoked with one parameter", node.loc)
                visitASTNode(node.args[0])
                emit(";")
            } else if(func == ".") {
                emit("(")
                if(node.args.size != 2) compilerError("field access must be invoked with two parameters", node.loc)
                val type = visitASTNode(node.args[0])
                if(type == null) compilerError(". operator can only be applied to an expression", node.loc)
                if(node.args[1] !is ASTVarExpr) compilerError("field name must be a name, not an expression", node.loc)
                if(!type.hasField((node.args[1] as ASTVarExpr).name)) {
                    compilerError("type '${type}' has no field '${(node.args[1] as ASTVarExpr).name}", node.loc)
                }
                emit(").${(node.args[1] as ASTVarExpr).name}")
                return type.fieldType((node.args[1] as ASTVarExpr).name)
            } else if(func == "[]") {
                emit("(")
                if(node.args.size != 2) compilerError("array index access must be invoked with two parameters", node.loc)
                val type = visitASTNode(node.args[0])
                if(type !is ASTArrayType) compilerError("array index operator can only be applied to array types, but it is applied to expression of type '$type' here", node.loc)
                emit(")[")
                val indexType = visitASTNode(node.args[1])
                emit("]")
                if(indexType !is ASTIntType) {
                    compilerError("expected array index to be of type 'int', but it is of type '$indexType'", node.args[1].loc)
                }
                return type.type
            } else {
                /* function is a "normal" arithmetic operator */
                if(func in prefixOps || func in postFixOps) {
                    if(node.args.size != 1) compilerError("$func operator only takes one argument", node.loc)
                    if(func in prefixOps)
                        emit(func)
                    emit("(")
                    val type = visitASTNode(node.args[0])
                    if(!(type?.hasOp(func)!!)) compilerError("$func operator not defined on type '${type}'", node.loc)
                    emit(")")
                    if(func in postFixOps)
                        emit(func)
                } else {
                    if(node.args.size != 2) compilerError("$func operator takes two arguments", node.loc)
                    emit("(")
                    val type1 = visitASTNode(node.args[0])
                    emit(") $func (")
                    val type2 = visitASTNode(node.args[1])
                    emit(")")

                    if(!(type1!!.hasOp(func))) compilerError("$func operator not defined on type '${type1}'")
                    if(type1 != type2) compilerError("arguments to $func operator must be the same type, but they are of types '${type1}' and '${type2}'")
                }
            }
        } else {
            val type = visitASTNode(node.expr)
            emit("(")
            if(type == null) {
                compilerError("function call must be on expression", node.loc)
            }
            if(type !is ASTFunctionType) {
                compilerError("expression is not a function", node.loc)
            }
            if(type.argTypes.size != node.args.size) {
                compilerError("expected ${type.argTypes.size} argument(s) to function, but ${node.args.size} were passed", node.loc)
            }
            type.argTypes.indices.map {i ->
                val arg = node.args[i]
                val expectType = type.argTypes[i]

                val argType = visitASTNode(arg)
                emit(", ")

                if(argType == null) {
                    compilerError("argument must be expression", arg.loc)
                }

                if(argType != expectType) {
                    compilerError("function expects argument of type '${expectType}', but argument passed is of type '${argType}'", arg.loc)
                }
            }
            emit(")")

            return type.returnType
        }

        return null
    }

    override fun visitASTVarExpr(node: ASTVarExpr): ASTType? {
        /* lookup variable in symbol table */
        val sym = getSymbolTable().findSymbol(node.name)
        if(sym == null) {
            compilerError("variable '${node.name}' is not defined", node.loc)
        }

        emit(node.name)

        return sym.type
    }
}