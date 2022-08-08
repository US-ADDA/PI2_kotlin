import com.fadda.common.collections.Matrix


class Exercise2 {

    companion object {

        fun recursiveFinal(matrix: Matrix<String>): List<String> {
            return recursiveFinal(matrix, ArrayList())
        }

        fun recursiveFinal(matrix: Matrix<String>, result: ArrayList<String>): List<String> {
            if (matrix.area() >= 4) {
                result.add(matrix.corners()[0] + matrix.corners()[1] + matrix.corners()[2] + matrix.corners()[3])
                recursiveFinal(matrix.view(0), result)
                recursiveFinal(matrix.view(1), result)
                recursiveFinal(matrix.view(2), result)
                recursiveFinal(matrix.view(3), result)
            }
            return result
        }

        fun recursiveNoFinal(matrix: Matrix<String>): List<String> {
            return if (matrix.area() >= 4)
                mutableListOf(matrix.corners()[0] + matrix.corners()[1] + matrix.corners()[2] + matrix.corners()[3]) +
                        recursiveNoFinal(matrix.view(0)) +
                        recursiveNoFinal(matrix.view(1)) +
                        recursiveNoFinal(matrix.view(2)) +
                        recursiveNoFinal(matrix.view(3))
            else mutableListOf()
        }
    }
}
