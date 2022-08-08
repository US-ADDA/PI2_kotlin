import com.fadda.common.tuples.triplet.IntTriplet


class Exercise5 {

    companion object {
        fun recursiveWithOutMemory(a: Int, b: Int, c: Int): Int {
            return if (a < 3 || b < 3 || c < 3) a + b * b + 2 * c
            else if (a.mod(b) == 0) recursiveWithOutMemory(a - 1, b / 2, c / 2) +
                    recursiveWithOutMemory(a - 3, b / 3, c / 3)
            else recursiveWithOutMemory(a / 3, b - 3, c - 3) +
                    recursiveWithOutMemory(a / 2, b - 2, c - 2)
        }

        fun recursiveWithMemory(a: Int, b: Int, c: Int): Int {
            return recursiveWithMemory(a, b, c, mutableMapOf())
        }

        fun recursiveWithMemory(a: Int, b: Int, c: Int, memory: MutableMap<IntTriplet, Int>): Int {
            val key: IntTriplet = IntTriplet(a, b, c)
            memory[key] = if (memory.containsKey(key)) memory[key]!!
            else if (key.first < 3 || key.second < 3 || key.third < 3) key.first + key.second * key.second + 2 * key.third
            else if (key.first.mod(key.second) == 0) recursiveWithMemory(
                key.first - 1,
                key.second / 2,
                key.third / 2,
                memory
            ) +
                    recursiveWithMemory(key.first - 3, key.second / 3, key.third / 3, memory)
            else recursiveWithMemory(key.first / 3, key.second - 3, key.third - 3, memory) +
                    recursiveWithMemory(key.first / 2, key.second - 2, key.third - 2, memory)
            return memory[key]!!
        }

        fun iterativeFor(a: Int, b: Int, c: Int): Int {
            val memory: MutableMap<IntTriplet, Int> = HashMap()
            for (i in 0..a) for (j in 0..b) for (k in 0..c) {
                val key = IntTriplet(i, j, k)
                memory[key] = if (i < 3 || j < 3 || k < 3) i + j * j + 2 * k
                else if (i % j == 0) memory[IntTriplet(i - 1, j / 2, k / 2)]!! +
                        memory[IntTriplet(i - 3, j / 3, k / 3)]!!
                else memory[IntTriplet(i / 3, j - 3, k - 3)]!! +
                        memory[IntTriplet(i / 2, j - 2, k - 2)]!!
            }
            return memory[IntTriplet(a, b, c)]!!
        }

        fun iterativeWhile(a: Int, b: Int, c: Int): Int {
            val memory: MutableMap<IntTriplet, Int> = HashMap()
            var i = 0
            var j = 0
            var k = 0
            while (i <= a) {
                while (j <= b) {
                    while (k <= c) {
                        val key = IntTriplet(i, j, k)
                        memory[key] = if (i < 3 || j < 3 || k < 3) i + j * j + 2 * k
                        else if (i % j == 0) memory[IntTriplet(i - 1, j / 2, k / 2)]!! +
                                memory[IntTriplet(i - 3, j / 3, k / 3)]!!
                        else memory[IntTriplet(i / 3, j - 3, k - 3)]!! +
                                memory[IntTriplet(i / 2, j - 2, k - 2)]!!
                        k++
                    }
                    j++
                    k = 0
                }
                i++
                j = 0
            }
            return memory[IntTriplet(a, b, c)]!!
        }


    }
}
