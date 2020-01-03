package compiler

import compiler.ast.*
import compiler.ast_visitors.*
import org.antlr.v4.runtime.*
import kotlin.system.exitProcess
import java.io.*
import parser.*

import com.tylerthrailkill.helpers.prettyprint.pp

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

    /* TODO: read off command line **/
    var srcFilename = ""

    fun lang1toAST(fileName: String): ASTNode {
        srcFilename = fileName
        val fileInput = BufferedReader(FileReader(fileName))
        val input = CharStreams.fromReader(fileInput)
        val lexer = Lang1Lexer(input)
        val tokens = CommonTokenStream(lexer)
        val parser = Lang1Parser(tokens)
        val tree = parser.program()

        return CSTToASTLang1().visitProgram(tree)
    }

    fun lang2toAST(fileName: String): ASTNode {
        srcFilename = fileName
        val fileInput = BufferedReader(FileReader(fileName))
        val input = CharStreams.fromReader(fileInput)
        val lexer = Lang2Lexer(input)
        val tokens = CommonTokenStream(lexer)
        val parser = Lang2Parser(tokens)
        val tree = parser.program()

        return CSTToASTLang2().visitProgram(tree)
    }

    fun lang3toAST(fileName: String): ASTNode {
        srcFilename = fileName
        val fileInput = BufferedReader(FileReader(fileName))
        val input = CharStreams.fromReader(fileInput)
        val lexer = Lang3Lexer(input)
        val tokens = CommonTokenStream(lexer)
        val parser = Lang3Parser(tokens)
        val tree = parser.program()

        return CSTToASTLang3().visitProgram(tree)
    }

    fun astToLang1(ast: ASTNode, fileName: String) {
        val emitter = Emitter(FileWriter(fileName))

        val programVisit = ASTToPrgLang1(emitter)
        programVisit.visitASTNode(ast)
        emitter.close()
    }

    fun astToLang2(ast: ASTNode, fileName: String) {
        val emitter = Emitter(FileWriter(fileName))

        val programVisit = ASTToPrgLang2(emitter)
        programVisit.visitASTNode(ast)
        emitter.close()
    }

    /** get currently active file */
    fun getActiveFilename(): String {
        return srcFilename
    }

    @JvmStatic fun main(args: Array<String>) {
        val ast = lang3toAST("lang3.txt")
        pp(ast)
        astToLang2(ast, "lang3.out")
    }
}