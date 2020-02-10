package compiler.ast_visitors

import compiler.ast.*
import compiler.compilerError
import java.io.*

import com.cedarsoftware.util.DeepEquals.*

/* Function names that receive special handling in output */
val specialFunctionNames = listOf("return", ".", "[]", "++", "--", "!", "~", "*", "/", "%", "+", "-", "<<", ">>", "<", "<=", ">", ">=", "==", "!=", "&", "|", "^", "&&", "||")

val prefixOps = listOf("!", "~")
val postFixOps = listOf("++", "--")

/* operators that have compound equivalents */
val compoundEquivOps = listOf("+", "-", "*", "/", "%", "<<", ">>", "&", "^", "|")

/* order of operations for special functions */
val funcOrderOps = listOf(
        listOf("."),
        listOf("[]"),
        listOf("++", "--"),
        listOf("!", "~"),
        listOf("*", "/", "%"),
        listOf("+", "-"),
        listOf("<<", ">>"),
        listOf("<", "<=", ">", ">="),
        listOf("==", "!="),
        listOf("&"),
        listOf("|"),
        listOf("^"),
        listOf("&&"),
        listOf("||")
)

/** Convert an string type name to an astnode type **/
fun stringTypeToASTType(type: String, loc: ASTNodeLocation): ASTType = when(type) {
    "int" -> ASTIntType(loc)
    "float" -> ASTFloatType(loc)
    "bool" -> ASTBoolType(loc)
    "any" -> ASTAnyStructType(loc)
    "string" -> ASTStringType(loc)
    else -> compilerError("no such type: ${type}", loc)
}

const val indentSpaces = true
const val indentSpacesSize = 2

/** class that handles directing output for ast -> program converters */
interface Emitter {
    fun emit(msg: String, indent: Int)
    fun close()
}

open class FileEmitter(val file: FileWriter): Emitter {
    /* Emit a string
     * indent handling - only print an indent if previously printed character was a newline
     */

    var lastChar = '\n'
    override fun emit(msg: String, indent: Int) {
        for(c in msg) {
            if(lastChar == '\n') emitIndent(indent)
            file.write(c.toString())
            lastChar = c
        }
    }

    override fun close() {
        file.close()
    }

    private fun emitIndent(indent: Int) {
        if(indentSpaces) {
            for(i in 0 until indent){
                for(n in 0 until indentSpacesSize) {
                    file.write(" ")
                }
            }
        } else {
            for(i in 0 until indent){
                file.write("\t")
            }
        }
    }
}

class TestEmitter(): Emitter {
    var value = ""

    var lastChar = '\n'
    override fun emit(msg: String, indent: Int) {
        for(c in msg) {
            if(lastChar == '\n') {
                (0 until indent).map { value += '\t' }
            }
            value += c
            lastChar = c
        }
    }

    fun clear() {
        value = ""
    }

    override fun close() {

    }
}

fun compareASTNode(a: ASTNode, b: ASTNode): Boolean {
    return deepEquals(a, b)
}