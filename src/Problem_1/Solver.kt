package Problem_1

import Events.*

class CSolver_1 (iStartingX : Int, iIterations : Int) : CSolverBase() {
    //  *** DATA TYPES ***
    private data class CResultStep(val iResult : Int, val iMultiplier : Int) {
        val Result : Int = iResult
        val Multiplier : Int = iMultiplier
    }
    //  *** PROPERTIES ***
    //  *** MEMBERS ***
    private val m_StartingX : Int = iStartingX
    private val m_Iterations : Int = iIterations
    private val funcs : List<(Int, Int) -> Int> = listOf(
            { x, m -> x + 4 + 8 * m },
            { x, m -> x + 3 + 88 * m },
            { x, m -> x - 5 + 256 * m }
    )
    //  *** METHODS ***
    private fun IsDivisible(iNumber : Int, iDivisor : Int) : Boolean = iNumber % iDivisor == 0
    private fun SingleStep(iFunc : (Int, Int) -> Int, iInput : CResultStep, iDivisor : Int) : List<CResultStep> {
        val retValue : MutableList<CResultStep> = mutableListOf()
        for (m : Int in 0..m_Iterations) {
            val temp : Int = iFunc(iInput.Result, m)
            if (IsDivisible(temp, iDivisor)) {
                val r = CResultStep(temp, m)
                retValue.add(r)
            }
        }
        return retValue
    }
    override fun Solve() {
        IntArray(m_StartingX) { it }.toList().forEach {
            val s1 : List<CResultStep> = SingleStep(funcs[0], CResultStep(it, 0), 11)
            s1.forEach {
                i1 ->
                val s2 : List<CResultStep> = SingleStep(funcs[1], i1, 3)
                s2.forEach {
                    i2 ->
                    val s3 : List<CResultStep> = SingleStep(funcs[2], i2, 5)
                    s3.forEach {
                        i3 ->
                        if(it == i3.Result - 10) {
                            LaunchOnMessage("Solution found for X: $it, Result: ${i3.Result - 10} (${i1.Multiplier}=${i1.Result}, ${i2.Multiplier}=${i2.Result}, ${i3.Multiplier}=${i3.Result})")
                        }
                    }
                }
            }
        }
    }
    /*fun CalculateSingleStep(iStartingX : Int, iMultipliers : IntArray) {
        var result : Int = iStartingX
        var counter = 0
        while(counter < funcs.size) {
            result = funcs[counter](result, iMultipliers[counter])
            counter++
        }
        LaunchOnMessage("Starting from: $iStartingX (multipliers: ${iMultipliers[0]},${iMultipliers[1]},${iMultipliers[2]}) result: $result - 10 = ${result - 10}")
    }*/
}