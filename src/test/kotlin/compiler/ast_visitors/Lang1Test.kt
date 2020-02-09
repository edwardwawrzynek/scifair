package compiler.ast_visitors

import compiler.ast.*
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import parser.*
import com.cedarsoftware.util.DeepEquals.*
import com.tylerthrailkill.helpers.prettyprint.pp

/**
 * Unit tests for lang1 -> ast and ast -> lang1 conversions
 * given an ast and its representation, check that it is parsed and generated correctly
 */

class ASTToPrgLang1Test {
    companion object {
        val emit = TestEmitter()
        val asttolang = ASTToPrgLang1(emit)
        val langtoast = null
        /* give all test ast nodes blank source locations */
        val noLoc = ASTNodeLocation(0, 0, "")

        fun parse(s: String): ASTNode {
            val lexer = Lang1Lexer(CharStreams.fromString(s))
            val tokens = CommonTokenStream(lexer)
            val parser = Lang1Parser(tokens)
            val tree = parser.program()

            return CSTToASTLang1().visitProgram(tree)
        }

        /** tests - a pair of an ast tree an expected output **/
        val tests: List<Pair<ASTProgram, String>> = listOf(
            Pair(
                ASTProgram(noLoc,
                    listOf(
                        ASTVarDecl(noLoc,
                            "test_var",
                            ASTArrayType(noLoc, ASTIntType(noLoc)),
                            ASTArrayLiteral(noLoc, ASTArrayType(noLoc, ASTIntType(noLoc)), listOf(
                                ASTIntLiteral(noLoc, 1),
                                ASTIntLiteral(noLoc, 2))))
                    )
                ),
                "(setq (test_var (array int)) (array int (1 2)))\n"
            ),
            Pair(
                ASTProgram(noLoc,
                    listOf(
                        ASTStructDecl(noLoc,
                            listOf(
                                ASTStructFieldType(
                                    "field1",
                                    ASTIntType(noLoc)),
                                ASTStructFieldType(
                                    "field2",
                                    ASTStructType(noLoc, "struct_test"))
                            ),
                            "struct_test"
                        ),
                        ASTVarDecl(noLoc,
                            "test_var",
                            ASTStructType(noLoc, "struct_test"),
                            ASTStructLiteral(noLoc,
                                ASTStructType(noLoc, "struct_test"),
                                listOf(
                                    ASTStructField("field1", ASTIntLiteral(noLoc, 5)),
                                    ASTStructField("field2", ASTNullLiteral(noLoc))
                                )
                            )
                        )
                    )
                ),
                "(defstruct struct_test (\n" +
                "\t(field1 int)\n" +
                "\t(field2 (struct struct_test))))\n" +
                "(setq (test_var (struct struct_test)) (struct struct_test ((field1 5) (field2 null))))\n"
            ),
            Pair(
                ASTProgram(noLoc,
                    listOf(
                        ASTComment(noLoc, " test comment"),
                        ASTIntLiteral(noLoc, 5),
                        ASTComment(noLoc, " Another comment")
                    )
                ),
                "; test comment\n5\n; Another comment\n"
            ),
            Pair(
                ASTProgram(noLoc,
                    listOf(
                        ASTConditional(noLoc,
                            listOf(
                                ASTFuncApplication(noLoc,
                                    ASTVarExpr(noLoc, "=="),
                                    listOf(
                                        ASTVarExpr(noLoc, "test_var"),
                                        ASTIntLiteral(noLoc, 5))
                                ),
                                ASTBoolLiteral(noLoc, false)
                            ),
                            listOf(
                                listOf(
                                    ASTFuncApplication(noLoc,
                                        ASTVarExpr(noLoc, "print"),
                                        listOf(ASTStringLiteral(noLoc, "\"a message\"")))
                                ),
                                listOf(
                                    ASTIntLiteral(noLoc, 5),
                                    ASTIntLiteral(noLoc, 6)
                                )
                            ))
                    )
                ),
                "(cond\n" +
                "\t((== test_var 5) ((print \"a message\")))\n" +
                "\t(false (\n" +
                "\t\t5\n" +
                "\t\t6)))\n"
            ),
            Pair(
                ASTProgram(noLoc,
                    listOf(
                        ASTForLoop(noLoc,
                            ASTVarDecl(noLoc,
                                "i",
                                ASTIntType(noLoc),
                                ASTIntLiteral(noLoc, 0)),
                            ASTFuncApplication(noLoc,
                                ASTVarExpr(noLoc, "=="),
                                listOf(
                                    ASTVarExpr(noLoc, "i"),
                                    ASTIntLiteral(noLoc, 10))),
                            ASTAssignment(noLoc,
                                ASTVarExpr(noLoc, "i"),
                                ASTFuncApplication(noLoc,
                                    ASTVarExpr(noLoc, "+"),
                                    listOf(
                                        ASTVarExpr(noLoc, "i"),
                                        ASTIntLiteral(noLoc, 1)
                                    ))),
                            listOf(
                                ASTFuncApplication(noLoc,
                                    ASTVarExpr(noLoc, "printnum"),
                                    listOf(ASTVarExpr(noLoc, "i"))
                                )
                            )
                        )
                    )
                ),
                "(for (setq (i int) 0) (== i 10) (= i (+ i 1)) (\n" +
                "\t(printnum i)))\n"
            )
        )
    }

    @Test fun runTests() {
        for(test in tests.subList(1, 2)) {
            emit.clear()
            asttolang.visitASTProgram(test.first)
            assertEquals(test.second, emit.value)
            emit.clear()
            val astNew = parse(test.second)
            assert(deepEquals(test.first, astNew))
        }
    }
}