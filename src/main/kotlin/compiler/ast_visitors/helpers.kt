package compiler.ast_visitors

import compiler.ast.*
import compiler.error

/** Convert an string type name to an astnode type **/
fun stringTypeToASTType(type: String, loc: ASTNodeLocation): ASTType = when(type) {
    "int" -> ASTIntType()
    "float" -> ASTFloatType()
    "bool" -> ASTBoolType()
    "null" -> ASTAnyStructType()
    "string" -> ASTStringType()
    else -> error("no such type: ${type}", loc)
}