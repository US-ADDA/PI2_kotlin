import com.fadda.common.tuples.quartet.Quartet
import com.fadda.common.tuples.triplet.IntTriplet
import java.util.stream.Stream

class Exercise1 {

    companion object {

        fun iterativeWhile(a: Int, b: Int, c: Int): String {
            var tuple: IntTriplet = IntTriplet(a, b, c)
            var result: String = ""
            while (true) {
                if (tuple.first < 3 && tuple.second < 3 && tuple.third < 3) {
                    result += "(${tuple.first * tuple.second * tuple.third})"
                    break
                } else if (tuple.first < 5 || tuple.second < 5 || tuple.third < 5) {
                    result += "(${tuple.first + tuple.second + tuple.third})"
                    break
                } else if (tuple.first.mod(2) == 0 && tuple.second.mod(2) == 0 && tuple.third.mod(2) == 0) {
                    result += tuple.first * tuple.second * tuple.third
                    tuple = IntTriplet(tuple.first / 2, tuple.second - 2, tuple.third / 2)
                } else {
                    result += tuple.first + tuple.second + tuple.third
                    tuple = IntTriplet(tuple.first / 3, tuple.second - 3, tuple.third / 3)
                }
            }
            return result
        }

        fun functional(a: Int, b: Int, c: Int): String {
            return Stream.iterate(
                Quartet(a, b, c, "")
            ) {
                if (it.first < 3 && it.second < 3 && it.third < 3) {
                    Quartet(null, null, null, it.fourth + "(${it.first * it.second * it.third})")
                } else if (it.first < 5 || it.second < 5 || it.third < 5) {
                    Quartet(null, null, null, it.fourth + "(${it.first + it.second + it.third})")
                } else if (it.first.mod(2) == 0 && it.second.mod(2) == 0 && it.third.mod(2) == 0) {
                    Quartet(it.first / 2, it.second - 2, it.third / 2, it.fourth + "${it.first * it.second * it.third}")
                } else {
                    Quartet(it.first / 3, it.second - 3, it.third / 3, it.fourth + "${it.first + it.second + it.third}")
                }
            }
                .filter { it.first == null }
                .map { it.fourth }
                .findFirst()
                .orElse("")
        }

        fun recursiveFinal(a: Int, b: Int, c: Int): String {
            return recursiveFinal(a, b, c, "")
        }

        fun recursiveFinal(a: Int, b: Int, c: Int, result: String): String {
            return if (a < 3 && b < 3 && c < 3) result + "(${a * b * c})"
            else if (a < 5 || b < 5 || c < 5) result + "(${a + b + c})"
            else if (a.mod(2) == 0 && b.mod(2) == 0 && c.mod(2) == 0)
                recursiveFinal(a / 2, b - 2, c / 2, result + (a * b * c))
            else recursiveFinal(a / 3, b - 3, c / 3, result + (a + b + c))
        }

        fun recursiveNoFinal(a: Int, b: Int, c: Int): String {
            return if (a < 3 && b < 3 && c < 3) "(${a * b * c})"
            else if (a < 5 || b < 5 || c < 5) "(${a + b + c})"
            else if (a.mod(2) == 0 && b.mod(2) == 0 && c.mod(2) == 0)
                (a * b * c).toString() + recursiveFinal(a / 2, b - 2, c / 2)
            else (a + b + c).toString() + recursiveFinal(a / 3, b - 3, c / 3)
        }
    }
}
