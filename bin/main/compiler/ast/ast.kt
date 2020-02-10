package compiler.ast

import com.cedarsoftware.util.DeepEquals
import compiler.Main
import java.io.*
import org.antlr.v4.runtime.*

/** The nodes of the abstract syntax tree
 *  because most of the work on the ast is carried out by visitors,
 *  these are mostly just data structures without methods
 */

/** Root AST Node class **/
/** The loc field represents the spot in the program from which the ast was generated
 * it is used for error reporting and is not an inherently necessary part of the ast
 */
open class ASTNode(val loc: ASTNodeLocation?)

/** A program (array of ast nodes) **/
class ASTProgram(loc: ASTNodeLocation?, val nodes: List<ASTNode>): ASTNode(loc)

/** Comment (including blank lines) **/
class ASTComment(loc: ASTNodeLocation?, val comment: String, val isBlankLine: Boolean = false): ASTNode(loc)

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

data class ASTStructField(val name: String, val value: ASTNode) {
    override fun equals(other: Any?): Boolean {
        return other is ASTStructField && other.name == name && DeepEquals.deepEquals(other.value, value)
    }
}

class ASTStructLiteral(loc: ASTNodeLocation?, val type: ASTStructType, override val value: List<ASTStructField>): ASTLiteral(loc)

/** AST Types **/
open class ASTType(loc: ASTNodeLocation?): ASTNode(loc) {
    open fun hasField(field: String) = false
    open fun fieldType(field: String): ASTType? = null

    open fun hasOp(op: String): Boolean = false
}

class ASTStringType(loc: ASTNodeLocation?): ASTType(loc) {
    override fun toString() = "string"
    override fun equals(other: Any?) = other is ASTStringType
    override fun hasOp(op: String) = op in listOf("+")
}

class ASTIntType(loc: ASTNodeLocation?): ASTType(loc) {
    override fun toString() = "int"
    override fun equals(other: Any?) = other is ASTIntType
    override fun hasOp(op: String) = op in listOf("++", "--", "!", "~", "*", "/", "%", "+", "-", "<<", ">>", "<", "<=", ">", ">=", "==", "!=", "&", "|", "^", "&&", "||")
}

class ASTFloatType(loc: ASTNodeLocation?): ASTType(loc) {
    override fun toString() = "float"
    override fun equals(other: Any?) = other is ASTFloatType
    override fun hasOp(op: String) = op in listOf("++", "--", "!", "~", "*", "/", "%", "+", "-", "<<", ">>", "<", "<=", ">", ">=", "==", "!=", "&", "|", "^", "&&", "||")
}

class ASTBoolType(loc: ASTNodeLocation?): ASTType(loc) {
    override fun toString() = "bool"
    override fun equals(other: Any?) = other is ASTBoolType
    override fun hasOp(op: String) = op in listOf("!", "==", "!=", "&&", "||")
}

class ASTArrayType(loc: ASTNodeLocation?, val type: ASTType): ASTType(loc) {
    override fun toString() = "[]${type}"
    override fun equals(other: Any?) = other is ASTArrayType && other.type == type

    override fun hasField(field: String) = field in listOf("length", "push")
    override fun fieldType(field: String): ASTType? {
        return when(field) {
            "length" -> ASTIntType(null)
            "push" -> ASTFunctionType(null, ASTIntType(null), listOf(type))
            else -> null
        }
    }
}

/** used for annotating type on nulls */
class ASTAnyStructType(loc: ASTNodeLocation?): ASTType(loc) {
    override fun toString() = "struct *"
    override fun equals(other: Any?) = other is ASTAnyStructType || other is ASTStructType || other is ASTFullStructType
}

/** represents a structure type */
class ASTStructType(loc: ASTNodeLocation?, val typeName: String): ASTType(loc) {
    override fun toString() = "struct $typeName"
    override fun equals(other: Any?) = (other is ASTStructType && other.typeName == typeName) || (other is ASTFullStructType && other.name == typeName) || other is ASTAnyStructType
}

/** represents a structure type with field types looked up in the structure table */
class ASTFullStructType(loc: ASTNodeLocation?, val fields: List<ASTStructFieldType>, val name: String): ASTType(loc) {
    override fun toString() = "struct $name"
    override fun equals(other: Any?) = (other is ASTFullStructType && other.name == name) || (other is ASTStructType && other.typeName == name) || other is ASTAnyStructType

    override fun hasField(field: String) = field in fields.map {f -> f.name}
    override fun fieldType(field: String) = fields.find { f -> f.name == field }?.type
}

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

    override fun equals(other: Any?): Boolean {
        return other is ASTNodeLocation
    }
}

fun ASTLoc(tok: Token): ASTNodeLocation = ASTNodeLocation(tok.line, tok.charPositionInLine, Main.getActiveFilename())
