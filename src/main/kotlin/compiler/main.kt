package compiler

import compiler.ast.ASTNodeLocation
import compiler.ast_visitors.*
import org.antlr.v4.runtime.*
import kotlin.system.exitProcess
import java.io.*
import parser.*

import com.tylerthrailkill.helpers.prettyprint.pp

/** get currently active file **/
fun getActiveFilename(): String {
    return "lang2.txt"
}

/** error printing **/
fun compilerError(msg: String, loc: ASTNodeLocation? = null): Nothing {
    if(loc === null) {
        println("\u001b[1m(null): \u001B[31merror\u001b[39;22m: $msg")
    } else {
        println("\u001b[1m${loc.fileName}:${loc.lineNum}:${loc.linePos}: \u001b[31merror\u001b[39;22m: $msg")
        loc.print()
    }

    exitProcess(1)
}

object Main {
    @JvmStatic fun main(args: Array<String>) {
        val fileName = "lang2.txt"
        val fileInput = BufferedReader(FileReader(fileName))
        val input = CharStreams.fromReader(fileInput)
        val lexer = Lang2Lexer(input)
        val tokens = CommonTokenStream(lexer)
        val parser = Lang2Parser(tokens)
        val tree = parser.program()

        val ast = CSTToASTLang2().visitProgram(tree)
        pp(ast)

        val emitter = Emitter(FileWriter("lang1.out"))

        val programVisit = ASTToPrgLang1(emitter)
        programVisit.visitASTNode(ast)

        emitter.close()

    }
}