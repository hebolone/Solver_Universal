package Problem_2

import Events.CMainSolver

class CSolver(private val iMIN : Int = 1, private val iMAX : Int = 100) : CMainSolver() {
    //  *** EVENTS ***
    //  *** MEMBERS ***
    private val excluded = intArrayOf(5, 7)
    private val MIN_COUNTDIGIT = 1
    private val MAX_COUNTDIGIT = 100
    private val numbersToSearch = intArrayOf(8)
    private val counterDigits = (MIN_COUNTDIGIT..MAX_COUNTDIGIT).sumBy { countDigit(it, numbersToSearch) }
    //  *** METHODS ***
    override fun Solve(){
        val counter = (iMIN..iMAX).count { checkDigitPresent(it, excluded) }
        LaunchOnMessage("Range from $iMIN to $iMAX: $counter numbers are not valid, ${iMAX - counter} are")

        LaunchOnMessage("Number ${numbersToSearch.map { it.toString() }} is present $counterDigits times from $MIN_COUNTDIGIT to $MAX_COUNTDIGIT")
    }
    private fun checkDigitPresent(iNumber : Int, iExcluded : IntArray) : Boolean {
        val strInput = iNumber.toString()
        val strExcluded = iExcluded.map { it.toString() }
        return (1..strInput.length).count { strExcluded.contains(strInput[it - 1].toString()) } > 0
    }

    private fun countDigit(iNumber : Int, iIncluded : IntArray) : Int {
        val strInput = iNumber.toString()
        val strIncluded = iIncluded.map { it.toString() }
        return (1..strInput.length).count { strIncluded.contains(strInput[it - 1].toString()) }
    }
}

