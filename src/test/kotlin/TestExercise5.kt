import com.fadda.common.tuples.triplet.IntTriplet
import com.google.common.io.Files
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File
import java.io.IOException
import java.nio.charset.StandardCharsets
import kotlin.test.assertEquals

class TestExercise5 {

    private var lines: List<IntTriplet>? = null
    private var correctResults: List<Int> = listOf(76, 201, 1860, 8658, 1187, 186)
    private var sep: String = ","

    @BeforeEach
    fun setup() {
        val file: File = File("src/test/resources/PI2Ej5DatosEntrada.txt")
        try {
            lines = Files.readLines(file, StandardCharsets.UTF_8).map {
                val line = it.split(sep)
                IntTriplet(line[0].toInt(), line[1].toInt(), line[2].toInt())
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Test
    fun testIterativeFor() {
        val result = lines?.map { Exercise5.iterativeFor(it.first, it.second, it.third) }
        for (i in 0 until result?.size!!) {
            assertEquals(correctResults[i], result[i], "Iterative for doesn't work on line $i.")
        }
    }

    @Test
    fun testIterativeWhile() {
        val result = lines?.map { Exercise5.iterativeWhile(it.first, it.second, it.third) }
        for (i in 0 until result?.size!!) {
            assertEquals(correctResults[i], result[i], "Iterative while doesn't work on line $i.")
        }
    }

    @Test
    fun testRecursiveWithMemory() {
        val result = lines?.map { Exercise5.recursiveWithMemory(it.first, it.second, it.third) }
        for (i in 0 until result?.size!!) {
            assertEquals(correctResults[i], result[i], "Recursive with memory doesn't work on line $i.")
        }
    }

    @Test
    fun testRecursiveWithOutMemory() {
        val result = lines?.map { Exercise5.recursiveWithOutMemory(it.first, it.second, it.third) }
        for (i in 0 until result?.size!!) {
            assertEquals(correctResults[i], result[i], "Recursive without memory doesn't work on line $i.")
        }
    }

}
