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
        val emitter = FileEmitter(FileWriter(fileName))

        val programVisit = ASTToPrgLang1(emitter)
        programVisit.visitASTNode(ast)
        emitter.close()
    }

    fun astToLang2(ast: ASTNode, fileName: String) {
        val emitter = FileEmitter(FileWriter(fileName))

        val programVisit = ASTToPrgLang2(emitter)
        programVisit.visitASTNode(ast)
        emitter.close()
    }

    fun astToLang3(ast: ASTNode, fileName: String) {
        val emitter = FileEmitter(FileWriter(fileName))

        val programVisit = ASTToPrgLang3(emitter)
        programVisit.visitASTNode(ast)
        emitter.close()
    }

    fun astBackend(ast: ASTNode, fileName: String) {
        val emitter = FileEmitter(FileWriter(fileName))

        val backend = JSBackend(emitter)
        backend.visitASTNode(ast)
        emitter.close()
    }

    /** get currently active file */
    fun getActiveFilename(): String {
        return srcFilename
    }

    fun usage(): Nothing {
        println("usage: lang <command> [options] [file]\n" +
                "commands:\n" +
                "compile --from src_lang --out out.js src.lang\n" +
                "convert --from src_lang --to dst_lang --out dst.lang src.lang")

        exitProcess(1)
    }

    /* compile cli subcommand */
    fun doCompile(file: String, lang: String, out_file: String) {
        val parsers = mapOf(
                "lang1" to this::lang1toAST,
                "lang2" to this::lang2toAST,
                "lang3" to this::lang3toAST
        )

        val parser = parsers[lang] ?: usage()
        val ast = parser(file)
        astBackend(ast, out_file)
    }

    /* convert cli subcommand */
    fun doConvert(src: String, dst: String, srcLang: String, dstLang: String) {
        val parsers = mapOf(
                "lang1" to this::lang1toAST,
                "lang2" to this::lang2toAST,
                "lang3" to this::lang3toAST
        )
        val writers = mapOf(
                "lang1" to this::astToLang1,
                "lang2" to this::astToLang2,
                "lang3" to this::astToLang3
        )

        val parser = parsers[srcLang] ?: usage()
        val writer = writers[dstLang] ?: usage()

        val ast = parser(src)
        writer(ast, dst)
    }

    fun parseArgs(args: Array<String>) {
        if(args.size < 2) usage()
        val cmd = args[0]
        if(cmd == "compile") {
            var src_lang: String? = null
            var out: String? = null
            var src_file: String? = null

            var i = 1
            while(i < args.size) {
                val arg = args[i]
                if (arg == "--from") {
                    i++
                    src_lang = args[i]
                } else if (arg == "--out") {
                    i++
                    out = args[i]
                } else {
                    src_file = arg
                }
                i++
            }

            if(src_file == null || out == null || src_lang == null) usage()
            doCompile(src_file, src_lang, out)

        } else if (cmd == "convert") {
            var src_lang: String? = null
            var dst_lang: String? = null
            var src_file: String? = null
            var dst_file: String? = null

            var i = 1
            while(i < args.size) {
                val arg = args[i]
                if (arg == "--from") {
                    i++
                    src_lang = args[i]
                } else if (arg == "--to") {
                    i++
                    dst_lang = args[i]
                } else if(arg == "--out") {
                    i++
                    dst_file = args[i]
                } else {
                    src_file = arg
                }
                i++
            }

            if(src_file == null || dst_file == null || src_lang == null || dst_lang == null) usage()

            doConvert(src_file, dst_file, src_lang, dst_lang)
        } else {
            usage()
        }
    }

    @JvmStatic fun main(args: Array<String>) {
        parseArgs(args)
        /*val ast = lang1toAST("lang1.txt")
        astToLang2(ast, "lang2.out")
        val ast2 = lang2toAST("lang2.out")
        astToLang3(ast2, "lang3.out")
        val ast3 = lang3toAST("lang3.out")
        astToLang1(ast3, "lang1.out")

        val emit = FileEmitter(FileWriter("out.js"))
        val backend = JSBackend(emit)
        backend.visitASTNode(ast3)
        emit.close()*/
    }
}