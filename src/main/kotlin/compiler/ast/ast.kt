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
}

fun ASTLoc(tok: Token): ASTNodeLocation = ASTNodeLocation(tok.line, tok.charPositionInLine, getActiveFilename())

/** Root AST Node class **/
/** The loc field represents the spot in the program from which the ast was generated
 * it is used for error reporting and is not an inherently necessary part of the ast
 */
open class ASTNode(val loc: ASTNodeLocation?)

/** A program (array of ast nodes) **/
class ASTProgram(loc: ASTNodeLocation?, val nodes: List<ASTNode>): ASTNode(loc)

/** Comment (including blank lines) **/
class ASTComment(loc: ASTNodeLocation?, val comment: String): ASTNode(loc)

/** Literal nodes **/
open class ASTLiteral(loc: ASTNodeLocation?): ASTNode(loc) {
    open val value get(): Any? = null
}

class ASTStringLiteral(loc: ASTNodeLocation?, override val value: String): ASTLiteral(loc)

class ASTIntLiteral(loc: ASTNodeLocation?, override val value: Long): ASTLiteral(loc)

class ASTFloatLiteral(loc: ASTNodeLocation?, override val value: Double): ASTLiteral(loc)

class ASTBoolLiteral(loc: ASTNodeLocation?, override val value: Boolean): ASTLiteral(loc)

class ASTNullLiteral(loc: ASTNodeLocation?): ASTLiteral(loc)

class ASTArrayLiteral(loc: ASTNodeLocation?, val type: ASTType, override val value: List<ASTNode>): ASTLiteral(loc)

data class ASTStructField(val name: String, val value: ASTNode)

class ASTStructLiteral(loc: ASTNodeLocation?, val type: ASTStructType, override val value: List<ASTStructField>): ASTLiteral(loc)

/** AST Types **/
open class ASTType(loc: ASTNodeLocation?): ASTNode(loc)

class ASTStringType(loc: ASTNodeLocation?): ASTType(loc)

class ASTIntType(loc: ASTNodeLocation?): ASTType(loc)

class ASTFloatType(loc: ASTNodeLocation?): ASTType(loc)

class ASTBoolType(loc: ASTNodeLocation?): ASTType(loc)

class ASTArrayType(loc: ASTNodeLocation?, val type: ASTType): ASTType(loc)

/** used for annotating type on nulls */
class ASTAnyStructType(loc: ASTNodeLocation?): ASTType(loc)

class ASTStructType(loc: ASTNodeLocation?, val typeName: String): ASTType(loc)

class ASTFunctionType(loc: ASTNodeLocation?, val returnType: ASTType, val argTypes: List<ASTType>): ASTType(loc)

/** struct declaration */
class ASTStructFieldType(val name: String, val type: ASTType)

class ASTStructDecl(loc: ASTNodeLocation?, val type: List<ASTStructFieldType>, val name: String): ASTNode(loc)

/** Variable expression */
class ASTVarExpr(loc: ASTNodeLocation?, val name: String): ASTNode(loc)

/** Function Binding **/
class ASTFuncBinding(loc: ASTNodeLocation?, val argNames: List<String>, val type: ASTFunctionType, val body: List<ASTNode>): ASTNode(loc)

/** Function Application **/
class ASTFuncApplication(loc: ASTNodeLocation?, val expr: ASTNode, val args: List<ASTNode>): ASTNode(loc)

/** Assignment **/
class ASTAssignment(loc: ASTNodeLocation?, val left: ASTNode, val right: ASTNode): ASTNode(loc)

/** Variable declaration **/
class ASTVarDecl(loc: ASTNodeLocation?, val name: String, val type: ASTType?, val initialValue: ASTNode): ASTNode(loc) {
    /** for type inference */
    fun withResolvedType(type: ASTType): ASTVarDecl {
        return ASTVarDecl(loc, name, type, initialValue)
    }
}

/** Conditional chain */
class ASTConditional(loc: ASTNodeLocation?, val conditions: List<ASTNode>, val bodies: List<List<ASTNode>>): ASTNode(loc)

/** For loop */
class ASTForLoop(loc: ASTNodeLocation?, val initial: ASTNode, val condition: ASTNode, val end: ASTNode, val body: List<ASTNode>): ASTNode(loc)