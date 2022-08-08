import com.fadda.common.collections.IntegerSet
import com.google.common.io.Files
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File
import java.io.IOException
import java.nio.charset.StandardCharsets
import kotlin.test.assertEquals

class TestExercise3 {

    private var lines: List<Triple<List<Int>, Int, Int>>? = null
    private var correctResults: List<IntegerSet> = listOf(
        IntegerSet.of(2, 3, 4, 5, 6),
        IntegerSet.of(0),
        IntegerSet.of(9),
        IntegerSet.of(),
        IntegerSet.of(8, 9, 10),
        IntegerSet.of(0, 1, 2, 3, 4),
    )
    private var sep1: String = "#"
    private var sep2: String = ","

    @BeforeEach
    fun setup() {
        val file: File = File("src/test/resources/PI2Ej3DatosEntrada.txt")
        try {
            lines = Files.readLines(file, StandardCharsets.UTF_8).map { it ->
                val info = it.split(sep1)
                val range = info[1].split(sep2)
                Triple(info[0].split(sep2).map { it.toInt() }, range[0].toInt(), range[1].toInt())
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Test
    fun testRecursiveFinal() {
        val result = lines?.map { Exercise3.recursiveFinal(it.first, it.second, it.third) }
        assertEquals(correctResults, result, "Recursive final doesn't work")
    }

    @Test
    fun recursiveNoFinal() {
        val result = lines?.map { Exercise3.recursiveNoFinal(it.first, it.second, it.third) }
        assertEquals(correctResults, result, "Recursive no final doesn't work")
    }

    @Test
    fun testIterativeFor() {
        val result = lines?.map { Exercise3.iterativeFor(it.first, it.second, it.third) }
        assertEquals(correctResults, result, "Iterative while doesn't work")
    }

    @Test
    fun testNothing() {
        val result = lines?.map { Exercise3.nothing(it.first, it.second, it.third) }
        assertEquals(correctResults, result, "Nothing doesn't work")
    }
}
