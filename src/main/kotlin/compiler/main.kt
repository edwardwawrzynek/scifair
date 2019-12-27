package compiler

import compiler.ast.ASTNodeLocation
import kotlin.system.exitProcess

/** get currently active file **/
fun getActiveFilename(): String {
    return "test.lang"
}

/** error printing **/
fun error(msg: String, loc: ASTNodeLocation? = null): Nothing {
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

    }
}