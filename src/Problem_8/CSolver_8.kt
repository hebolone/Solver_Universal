package Problem_8

import Events.CSolverBase

class CSolver_8 : CSolverBase() {
    override fun Solve() {
        var result = 0
        (1..100).forEach {
            i -> run {
                result += (if(isEven(i)) -1 else 1)*(i * i)
                if(GetStepsVisible())
                    println("$i -> $result")
            }
        }
        println("Result: $result")
    }
    private fun isEven(iValue : Int) = iValue % 2 == 0
}
