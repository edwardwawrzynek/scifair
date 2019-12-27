package compiler.ast

import compiler.getActiveFilename
import java.io.*
import org.antlr.v4.runtime.*

/** The nodes of the abstract syntax tree
 *  because most of the work on the ast is carried out by visitors,
 *  these are mostly just data structures without methods
 */

/** Location of ast node in source file **/
class ASTNodeLocation(val lineNum: Int, val linePos: Int, val fileName: String) {

    fun print() {
        try {
            val file = BufferedReader(FileReader(fileName))
            for (i in 0 until lineNum - 1) {
                file.readLine()
            }
            val line = file.readLine()
            println(line)

            for (i in 0 until linePos) {
                if (line[i] == '\t') {
                    print("\t")
                } else {
                    print(" ")
                }
            }
            System.out.println("\u001B[1;31m^\u001B[39;22m")


        } catch (err: IOException) {
            println("IOException")
        }

    }

    companion object {
        fun fromToken(tok: Token): ASTNodeLocation {
            return ASTNodeLocation(tok.line, tok.charPositionInLine, getActiveFilename())
        }
    }
}


/** Root AST Node class **/
open class ASTNode ()

/** A program (array of ast nodes) **/
class ASTProgram(val nodes: List<ASTNode>): ASTNode()

/** Comment (including blank lines) **/
class ASTComment(val comment: String): ASTNode()

/** Literal nodes **/
open class ASTLiteral(): ASTNode()

class ASTStringLiteral(val value: String): ASTLiteral()

class ASTIntLiteral(val value: Long): ASTLiteral()

class ASTFloatLiteral(val value: Double): ASTLiteral()

class ASTBoolLiteral(val value: Boolean): ASTLiteral()

class ASTNullLiteral(): ASTLiteral()

class ASTArrayLiteral(val type: ASTType, val value: List<ASTNode>): ASTLiteral()

data class ASTStructField(val name: String, val value: ASTNode)

class ASTStructLiteral(val type: ASTStructType, val value: List<ASTStructField>): ASTLiteral()

/** AST Types **/
open class ASTType(): ASTNode()

class ASTStringType(): ASTType()

class ASTIntType(): ASTType()

class ASTFloatType(): ASTType()

class ASTBoolType(): ASTType()

class ASTArrayType(val type: ASTType): ASTType()

/** used for annotating type on nulls */
class ASTAnyStructType(): ASTType()

class ASTStructType(val typeName: String): ASTType()

class ASTFunctionType(val returnType: ASTType, val argTypes: List<ASTType>): ASTType()

/** Variable expression */
class AstVarExpr(val name: String): ASTNode()

/** Function Binding **/
class ASTFuncBinding(val argNames: List<String>, val argTypes: List<ASTType>, val body: List<ASTNode>): ASTNode()

/** Function Application **/
class ASTFuncApplication(val expr: ASTNode, val args: List<ASTNode>): ASTNode()

/** Assignment **/
class ASTAssignment(val left: ASTNode, val right: ASTNode): ASTNode()

/** Variable declaration **/
class ASTVarDecl(val name: String, val type: ASTType?, val initialValue: ASTNode?): ASTNode() {
    /** for type inference */
    fun withResolvedType(type: ASTType): ASTVarDecl {
        return ASTVarDecl(name, type, initialValue)
    }
}

/** Conditional chain */
class ASTConditional(val conditions: List<ASTNode>, val bodies: List<List<ASTNode>>): ASTNode()

/** For loop */
class ASTForLoop(val initial: ASTNode, val condition: ASTNode, val end: ASTNode, val body: List<ASTNode>): ASTNode()