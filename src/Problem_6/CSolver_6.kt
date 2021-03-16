package Problem_6

import Events.CSolverBase
import kotlin.math.pow

class CSolver_6 : CSolverBase() {
    override fun Solve() =
        (10..99).forEach {
            if(calculate(it))
                LaunchOnMessage("$it,")
        }
    private fun calculate(i : Int) : Boolean = ((i.toDouble().pow(2) - 1.0).toInt() % 15) == 0
}