class Exercise4 {

    companion object {
        fun recursiveWithOutMemory(n: Int): Long {
            return when (n) {
                0 -> 2
                1 -> 4
                2 -> 6
                else -> 2 * recursiveWithOutMemory(n - 1) +
                        4 * recursiveWithOutMemory(n - 2) +
                        6 * recursiveWithOutMemory(n - 3)
            }
        }

        fun recursiveWithMemory(n: Int): Long {
            return recursiveWithMemory(n, mutableMapOf())
        }

        fun recursiveWithMemory(n: Int, memory: MutableMap<Int, Long>): Long {
            if (memory.containsKey(n)) return memory[n]!!
            val res = when (n) {
                0 -> 2
                1 -> 4
                2 -> 6
                else -> 2 * recursiveWithMemory(n - 1, memory) +
                        4 * recursiveWithMemory(n - 2, memory) +
                        6 * recursiveWithMemory(n - 3, memory)
            }
            memory[n] = res
            return res
        }

        fun iterativeFor(n: Int): Long? {
            val map: MutableMap<Int, Long> = HashMap()
            for (i in 0..n) {
                when (i) {
                    0 -> map[0] = 2
                    1 -> map[1] = 4
                    2 -> map[2] = 6
                    else -> map[i] = 2 * map[i - 1]!! + 4 * map[i - 2]!! + 6 * map[i - 3]!!
                }
                map.remove(i - 3)
            }
            return map[n]
        }

        fun iterativeWhile(n: Int): Long {
            var map: MutableMap<Int, Long> = HashMap()
            var i = 0
            while (i <= n) {
                when (i) {
                    0 -> map[0] = 2
                    1 -> map[1] = 4
                    2 -> map[2] = 6
                    else -> map[i] = 2 * map[i - 1]!! + 4 * map[i - 2]!! + 6 * map[i - 3]!!
                }
                map.remove(i - 3)
                i++
            }
            return map[n]!!
        }

        fun functional(n: Int): Long? {
            val map: MutableMap<Int, Long> = HashMap()
            return (0..n).map {
                when (it) {
                    0 -> map[0] = 2
                    1 -> map[1] = 4
                    2 -> map[2] = 6
                    else -> map[it] = 2 * map[it - 1]!! + 4 * map[it - 2]!! + 6 * map[it - 3]!!
                }
                map[it]
            }.last()
        }
    }

}
