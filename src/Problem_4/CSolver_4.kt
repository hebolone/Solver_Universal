package Problem_4

import Events.CMainSolver

class CSolver_4(iInput : String) : CMainSolver() {
    //  *** MEMBERS ***
    private val m_OriginalList = mutableListOf<Int>()
    private val m_Input = iInput
    //  *** METHODS ***
    override fun Solve() {
        var canContinue = false
        try {
            m_Input.split(',').toList().map { it.trim().toInt() }.forEach { m_OriginalList.add(it) }
            canContinue = true
        }
        catch(exc : Exception) {
            LaunchOnMessage("Invalid arguments")
        }

        if(!canContinue) {
            return
        }
        //  Create SubArray
        val listOfArrays = mutableListOf(m_OriginalList)
        var currentIndex = 0
        while(!CheckSubArray(listOfArrays[currentIndex])) {
            listOfArrays.add(CreateSubArray(listOfArrays[currentIndex]))
            currentIndex++
        }
        if(listOfArrays.last().size == 1) {
            LaunchOnMessage("No solution found")
            return
        }
        //  Go up to the first array
        var lastValue = 0
        listOfArrays.reversed().forEach {
            it.add(it[it.size - 1] + lastValue)
            lastValue = it.last()
            if(GetStepsVisible())
                LaunchOnMessage("$it")
        }
        //  Print solution
        LaunchOnMessage("Solution ${listOfArrays.first()}")
    }
    private fun CreateSubArray(iInput : List<Int>) : MutableList<Int> {
        val subArray = mutableListOf<Int>()
        (1..(iInput.size - 1)).forEach { subArray.add(iInput[it] - iInput[it - 1]) }
        return subArray
    }
    private fun CheckSubArray(iInput : List<Int>) : Boolean {
        //  Return true if all values are the same value
        var retValue = iInput.size > 1
        (1..(iInput.size - 1)).forEach { if(iInput[it] != iInput[it - 1]) retValue = false }
        return retValue
    }
}