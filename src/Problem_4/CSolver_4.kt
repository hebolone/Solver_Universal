package Problem_4

import Events.CMainSolver

class CSolver_4(iInput : String) : CMainSolver() {
    //  *** MEMBERS ***
    private val m_OriginalList = mutableListOf<Int>()
    private val m_Input = iInput
    //  *** METHODS ***
    fun Solve() {
        var canContinue = false
        try {
            m_Input.split(',').toList().map { it.trim().toInt() }.forEach { m_OriginalList.add(it) }
            canContinue = true
        }
        catch(exc : Exception) {
            println("Invalid arguments")
        }

        if(!canContinue) {
            return
        }
        //  Create SubArray
        var listOfArrays = mutableListOf<MutableList<Int>>()
        listOfArrays.add(m_OriginalList)
        var currentIndex = 0
        while(!CheckSubArray(listOfArrays[currentIndex])) {
            val subArray = CreateSubArray(listOfArrays[currentIndex])
            listOfArrays.add(subArray)
            currentIndex++
        }
        if(listOfArrays.last().size == 1) {
            println("No solution found")
            return
        }
        //  Go up to the first array
        var lastValue = 0
        listOfArrays.reversed().forEach {
            it.add(it[it.size - 1] + lastValue)
            lastValue = it.last()
        }
        //  Print solution
        println("Solution ${listOfArrays.first()}")
    }
    private fun CreateSubArray(iInput : List<Int>) : MutableList<Int> {
        val subArray = mutableListOf<Int>()
        (1..(iInput.size - 1)).forEach { subArray.add(iInput[it] - iInput[it - 1]) }
        return subArray
    }
    private fun CheckSubArray(iInput : List<Int>) : Boolean {
        //  Return true if all values are the same value
        var retValue = true
        (1..(iInput.size - 1)).forEach { if(iInput[it] != iInput[it - 1]) retValue = false }
        return retValue
    }
}