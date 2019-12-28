package compiler.ast_visitors

import compiler.ast.*

/** Base abstract syntax tree visitor **/

open class ASTBaseVisitor<T>(val defaultValue: T) {
    open fun visitASTNode(node: ASTNode): T {
        when(node) {
            is ASTProgram -> visitASTProgram(node)
            is ASTComment -> visitASTComment(node)
            is ASTLiteral -> visitASTLiteral(node)
            is ASTType -> visitASTType(node)
            is ASTVarExpr -> visitASTVarExpr(node)
            is ASTFuncBinding -> visitASTFuncBinding(node)
            is ASTFuncApplication -> visitASTFuncApplication(node)
            is ASTAssignment -> visitASTAssignment(node)
            is ASTVarDecl -> visitASTVarDecl(node)
            is ASTConditional -> visitASTConditional(node)
            is ASTForLoop -> visitASTForLoop(node)
            is ASTStructDecl -> visitASTSTructDecl(node)
        }
        return defaultValue
    }

    open fun visitASTProgram(node: ASTProgram): T {
        for(n in node.nodes) {
            visitASTNode(n)
        }
        return defaultValue
    }

    open fun visitASTComment(node: ASTComment): T = defaultValue

    open fun visitASTLiteral(node: ASTLiteral): T {
        when(node) {
            is ASTStringLiteral -> visitASTStringLiteral(node)
            is ASTIntLiteral -> visitASTIntLiteral(node)
            is ASTFloatLiteral -> visitASTFloatLiteral(node)
            is ASTBoolLiteral -> visitASTBoolLiteral(node)
            is ASTNullLiteral -> visitASTNullLiteral(node)
            is ASTArrayLiteral -> visitASTArrayLiteral(node)
            is ASTStructLiteral -> visitASTStructLiteral(node)
        }

        return defaultValue
    }

    open fun visitASTStringLiteral(node: ASTStringLiteral): T = defaultValue
    open fun visitASTIntLiteral(node: ASTIntLiteral): T = defaultValue
    open fun visitASTFloatLiteral(node: ASTFloatLiteral): T = defaultValue
    open fun visitASTBoolLiteral(node: ASTBoolLiteral): T = defaultValue
    open fun visitASTNullLiteral(node: ASTNullLiteral): T = defaultValue
    open fun visitASTArrayLiteral(node: ASTArrayLiteral): T = defaultValue
    open fun visitASTStructLiteral(node: ASTStructLiteral): T = defaultValue

    open fun visitASTType(node: ASTType): T {
        when(node) {
            is ASTStringType -> visitASTStringType(node)
            is ASTIntType -> visitASTIntType(node)
            is ASTFloatType -> visitASTFloatType(node)
            is ASTBoolType -> visitASTBoolType(node)
            is ASTArrayType -> visitASTArrayType(node)
            is ASTAnyStructType -> visitASTAnyStructType(node)
            is ASTStructType -> visitASTStructType(node)
        }

        return defaultValue
    }

    open fun visitASTStringType(node: ASTStringType): T = defaultValue
    open fun visitASTIntType(node: ASTIntType): T = defaultValue
    open fun visitASTFloatType(node: ASTFloatType): T = defaultValue
    open fun visitASTBoolType(node: ASTBoolType): T = defaultValue
    open fun visitASTAnyStructType(node: ASTAnyStructType): T = defaultValue
    open fun visitASTArrayType(node: ASTArrayType): T = defaultValue
    open fun visitASTStructType(node: ASTStructType): T = defaultValue

    open fun visitASTVarExpr(node: ASTVarExpr): T = defaultValue
    open fun visitASTFuncBinding(node: ASTFuncBinding): T = defaultValue
    open fun visitASTFuncApplication(node: ASTFuncApplication): T = defaultValue
    open fun visitASTAssignment(node: ASTAssignment): T = defaultValue
    open fun visitASTVarDecl(node: ASTVarDecl): T = defaultValue
    open fun visitASTConditional(node: ASTConditional): T = defaultValue
    open fun visitASTForLoop(node: ASTForLoop): T = defaultValue
    open fun visitASTSTructDecl(node: ASTStructDecl): T = defaultValue
}