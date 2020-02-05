package compiler.ast_visitors

import compiler.ast.*
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

/**
 * Unit tests for AST to Lang1 conversions
 */

class ASTToPrgLang1Test {
    companion object {
        val emit = TestEmitter()
        val asttolang = ASTToPrgLang1(emit)
        /* give all test ast nodes blank source locations */
        val noLoc = ASTNodeLocation(0, 0, "")
    }

    /* array literals + assignment */
    @Test
    fun assignArrayTest() {
        emit.clear()
        asttolang.visitASTProgram(ASTProgram(noLoc,
                listOf(
                        ASTVarDecl(noLoc,
                                "test_var",
                                ASTArrayType(noLoc, ASTIntType(noLoc)),
                                ASTArrayLiteral(noLoc, ASTArrayType(noLoc, ASTIntType(noLoc)), listOf(
                                        ASTIntLiteral(noLoc, 1),
                                        ASTIntLiteral(noLoc, 2))))
                )
        ))
        assertEquals("(setq (test_var (array int)) (array int (1 2)))\n", emit.value)
        emit.clear()
    }

    /* structure defs, structure literals */
    @Test
    fun structTest() {
        emit.clear()
        asttolang.visitASTProgram(ASTProgram(noLoc,
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
        ))

        assertEquals("" +
                "(defstruct struct_test (\n" +
                "\t(field1 int)\n" +
                "\t(field2 (struct struct_test))))\n" +
                "(setq (test_var (struct struct_test)) (struct struct_test ((field1 5) (field2 null))))\n",
                emit.value
        )
        emit.clear()
    }

    /* test comment emission */
    @Test
    fun commentTest() {
        emit.clear()
        asttolang.visitASTProgram(ASTProgram(noLoc,
                listOf(
                        ASTComment(noLoc, " test comment"),
                        ASTIntLiteral(noLoc, 5),
                        ASTComment(noLoc, " Another comment")
                )
                )
        )

        assertEquals("; test comment\n5\n; Another comment\n", emit.value)
        emit.clear()
    }

    /* test conditionals (and operators + function application) */
    @Test
    fun condTest() {
        emit.clear()
        asttolang.visitASTProgram(ASTProgram(noLoc,
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
        ))
        assertEquals("" +
                "(cond\n" +
                "\t((== test_var 5) ((print \"a message\")))\n" +
                "\t(false (\n" +
                "\t\t5\n" +
                "\t\t6)))\n", emit.value)
        emit.clear()
    }

    /* test loops */
    @Test
    fun loopTest() {
        emit.clear()
        asttolang.visitASTProgram(ASTProgram(noLoc,
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
                )))
        )
        assertEquals("" +
                "(for (setq (i int) 0) (== i 10) (= i (+ i 1)) (\n" +
                "\t(printnum i)))\n", emit.value)
        emit.clear()
    }

}