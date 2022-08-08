import com.fadda.common.collections.Matrix
import com.google.common.io.Files
import org.junit.jupiter.api.BeforeEach
import java.io.File
import java.io.IOException
import java.nio.charset.StandardCharsets
import kotlin.test.Test
import kotlin.test.assertEquals

class TestExercise2 {

    private var lines: Matrix<String>? = null
    private var correctResults: List<List<String>> = listOf(
        listOf(
            "abstract_char_parte_ejemplos",
            "abstract_break_instanceof_long",
            "abstract_assert_class_continue",
            "boolean_break_default_do",
            "extends_final_instanceof_int",
            "finally_float_interface_long",
            "byte_char_module_non-sealed",
            "byte_case_double_else",
            "catch_char_enum_exports",
            "for_if_module_native",
            "implements_import_new_non-sealed",
            "package_protected_parte_compartidos",
            "package_permits_short_static",
            "private_protected_strictfp_super",
            "throws_transient_parte_comun",
            "try_void_datos_compartidos",
            "public_return_grafos_ejemplos",
            "public_sealed_switch_synchronized",
            "record_return_this_throw",
            "volatile_while_grafos_solve",
            "var_yield_geneticos_ejemplos"
        ),
        listOf(
            "Paranecesarioalgoritmoejemplos",
            "ParadiseñoconocerJava",
            "Paraabordartenerasimilados",
            "eldiseñoloselementos",
            "algúnlenguaje.conocerel",
            "ParaseguirlenguajeJava",
            "denecesarioyAprenderemos",
            "dealgoritmosdela",
            "esnecesarioprogramaciónen",
            "elcontenidoysus",
            "hacefaltapeculiaridades.Aprenderemos",
            "laselalgoritmoAl",
            "lastécnicaslastécnicas",
            "paraeldediseño",
            "análisisyalgoritmoen",
            "lastransformacionesotros.Al",
            "diseñoiterativos,finalejemplos",
            "diseñodedealgoritmos",
            "algoritmositerativos,recursivos,su",
            "deunfinalse",
            "tipodeincluyenejemplos"
        )
    )
    private var sep: String = " "
    private var test: Int = 1

    @BeforeEach
    fun setup() {
        val file: File = File("src/test/resources/PI2Ej2DatosEntrada$test.txt")
        try {
            lines = Matrix.of(Files.readLines(file, StandardCharsets.UTF_8).map { it.split(sep).toTypedArray() }
                .toTypedArray())
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Test
    fun testRecursiveFinal() {
        val result = Exercise2.recursiveFinal(lines!!)
        for (i in correctResults.indices)
            assertEquals(correctResults[test - 1][i], result[i], "Recursive final doesn't work on line $i.")
    }

    @Test
    fun testRecursiveNoFinal() {
        val result = Exercise2.recursiveNoFinal(lines!!)
        for (i in correctResults.indices)
            assertEquals(correctResults[test - 1][i], result[i], "Recursive no final doesn't work on line $i.")
    }

}
