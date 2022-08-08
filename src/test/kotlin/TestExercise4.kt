import com.google.common.io.Files
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File
import java.io.IOException
import java.nio.charset.StandardCharsets
import kotlin.test.assertEquals

class TestExercise4 {

    private var lines: List<Int>? = null
    private var correctResults: List<Long> =
        listOf(452, 271200, 160269440, 94705116032, 55962400789504, 33068860966434816)
    private var sep: String = "n="

    @BeforeEach
    fun setup() {
        val file: File = File("src/test/resources/PI2Ej4DatosEntrada.txt")
        try {
            lines = Files.readLines(file, StandardCharsets.UTF_8).map { it.removePrefix(sep).toInt() }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Test
    fun testFunctional() {
        val result = lines?.map { Exercise4.functional(it) }
        for (i in 0 until result?.size!!) {
            assertEquals(correctResults[i], result[i], "Functional doesn't work on line $i.")
        }
    }

    @Test
    fun testIterativeFor() {
        val result = lines?.map { Exercise4.iterativeFor(it) }
        for (i in 0 until result?.size!!) {
            assertEquals(correctResults[i], result[i], "Iterative for doesn't work on line $i.")
        }
    }

    @Test
    fun iterativeWhile() {
        val result = lines?.map { Exercise4.iterativeWhile(it) }
        for (i in 0 until result?.size!!) {
            assertEquals(correctResults[i], result[i], "Iterative while doesn't work on line $i.")
        }
    }

    @Test
    fun recursiveWithMemory() {
        val result = lines?.map { Exercise4.recursiveWithMemory(it) }
        for (i in 0 until result?.size!!) {
            assertEquals(correctResults[i], result[i], "Recursive with memory doesn't work on line $i.")
        }
    }

    @Test
    fun recursiveWithOutMemory() {
        val result = lines?.map { Exercise4.recursiveWithOutMemory(it) }
        for (i in 0 until result?.size!!) {
            assertEquals(correctResults[i], result[i], "Recursive with out memory doesn't work on line $i.")
        }
    }
}
