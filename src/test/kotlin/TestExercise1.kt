import com.google.common.io.Files
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File
import java.io.IOException
import java.nio.charset.StandardCharsets
import kotlin.test.assertEquals

class TestExercise1 {

    private var lines: List<Triple<Int, Int, Int>>? = null
    private var correctResults: List<String> =
        listOf("640001520061(40)", "800043(22)", "155(64)", "155(51)", "(151)", "(251)")
    private var sep: String = ","


    @BeforeEach
    fun setup() {
        val file: File = File("src/test/resources/PI2Ej1DatosEntrada.txt")
        try {
            lines = Files.readLines(file, StandardCharsets.UTF_8).map {
                it.split(sep)
                Triple(it.split(sep)[0].toInt(), it.split(sep)[1].toInt(), it.split(sep)[2].toInt())
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Test
    fun testFunctional() {
        val result = lines?.map { Exercise1.functional(it.first, it.second, it.third) }
        for (i in correctResults.indices)
            assertEquals(correctResults[i], result?.get(i), "Functional doesn't work on line $i.")
    }


    @Test
    fun testIterativeWhile() {
        val result = lines?.map { Exercise1.iterativeWhile(it.first, it.second, it.third) }
        for (i in correctResults.indices)
            assertEquals(correctResults[i], result?.get(i), "Iterative while doesn't work on line $i.")
    }

    @Test
    fun recursiveFinal() {
        val result = lines?.map { Exercise1.recursiveFinal(it.first, it.second, it.third) }
        for (i in correctResults.indices)
            assertEquals(correctResults[i], result?.get(i), "Recursive final doesn't work on line $i.")
    }

    @Test
    fun recursiveNoFinal() {
        val result = lines?.map { Exercise1.recursiveNoFinal(it.first, it.second, it.third) }
        for (i in correctResults.indices)
            assertEquals(correctResults[i], result?.get(i), "Recursive no final doesn't work on line $i.")
    }
}
