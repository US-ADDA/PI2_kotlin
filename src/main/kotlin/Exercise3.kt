import com.fadda.common.collections.IntegerSet

class Exercise3 {

    companion object {
        fun functional(list: List<Int>, a: Int, b: Int): IntegerSet {
            return IntegerSet.of(*list.filter { it in a until b }.toTypedArray())
        }

        fun iterativeFor(list: List<Int>, a: Int, b: Int): IntegerSet {
            val result = IntegerSet.empty()
            for (i in list) if (i in a until b) result.add(i)
            return result
        }

        // Esta es la opción que en la práctica se deberá de utilizar.
        fun nothing(list: List<Int>, a: Int, b: Int): IntegerSet {
            return IntegerSet.ofRange(a, b).intersection(list)
        }

        // Se podría aplicar algún algoritmo como binary search o quick sort, pero en sí no tiene sentido, ya que el
        // propio IntegerSet ya te da las herramientas necesarias para hacer este ejercicio.
        // Si preferís con un algoritmo en la versión antigua está.
        fun recursiveFinal(list: List<Int>, a: Int, b: Int): IntegerSet {
            return recursiveFinal(list, a, b, 0, IntegerSet.empty())
        }

        fun recursiveFinal(list: List<Int>, a: Int, b: Int, i: Int, result: IntegerSet): IntegerSet {
            if (i == list.size) return result
            else if (list[i] in a until b) result.add(list[i])
            return recursiveFinal(list, a, b, i + 1, result)
        }

        fun recursiveNoFinal(list: List<Int>, a: Int, b: Int): IntegerSet {
            return recursiveNoFinal(list, a, b, 0)
        }

        fun recursiveNoFinal(list: List<Int>, a: Int, b: Int, i: Int): IntegerSet {
            return if (i == list.size) IntegerSet.empty()
            else if (list[i] in a until b) {
                val set = recursiveNoFinal(list, a, b, i + 1)
                set.add(list[i])
                set
            } else recursiveNoFinal(list, a, b, i + 1)
        }


    }
}
