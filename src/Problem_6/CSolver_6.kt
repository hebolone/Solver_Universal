package Problem_6

import Events.CMainSolver
import kotlin.math.pow

class CSolver_6 : CMainSolver() {
    override fun Solve() {
        // x^2-1/15=0
        (10..99).forEach {
            if(calculate(it))
                print("${it},")
        }
    }
    private fun calculate(i : Int) : Boolean = ((i.toDouble().pow(2) - 1.0) % 15.0) == 0.0
}