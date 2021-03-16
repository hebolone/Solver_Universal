import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CProblems {
    //  *** MEMBERS ***
    //  *** METHODS ***
    fun ProblemSolver(iProblem : FactoryProvider.TSolver) {
        val solver = FactoryProvider.GetSolver(iProblem)
        solver.Solve()
    }
//    fun Problem_1() {
//        val solver = Problem_1.CSolver_1(1000, 10)
//        solver.onMessage += { ReceiveOnMessage(it) }
//        solver.Solve()
//    }
//    fun Problem_2(iMin :Int, iMax : Int) {
//        val solver = Problem_2.CSolver_2(iMin, iMax)
//        solver.onMessage += { ReceiveOnMessage(it) }
//        solver.Solve()
//    }
//    fun Problem_3() {
//        val solver = Problem_3.CSolver_3(1, 128)
//        solver.SetStepsVisibleFunc { Options.ShowAllSteps }
//        solver.onMessage += { ReceiveOnMessage(it) }
//        solver.Solve()
//    }
    fun Problem_4() {
        //  Ask user input
        println("Inserisci i dati dividendoli con una virgola: 1,2,3...")
        print(">")
        val userInput = readLine()!!
        //  Init class
        val solver = Problem_4.CSolver_4(userInput)
        solver.SetStepsVisibleFunc { Options.ShowAllSteps }
        solver.onMessage += { ReceiveOnMessage(it) }
        solver.Solve()
    }
//    fun Problem_5(iTries : Int) {
//        val solver = Problem_5.CSolver_5(iTries)
//        solver.SetStepsVisibleFunc { Options.ShowAllSteps }
//        solver.Solve()
//    }
//    fun Problem_6() {
//        val solver = Problem_6.CSolver_6()
//        solver.onMessage += { ReceiveOnMessageInLine(it) }
//        solver.Solve()
//    }
    //---------------------------------------------------------------------------------------------
    private fun ReceiveOnMessage(iMessage : String) {
        val now = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val formatted : String = if(Options.ShowDateTime) now.format(formatter) else ""
        println("$formatted $iMessage")
    }
//    private fun ReceiveOnMessageInLine(iMessage : String) = print(iMessage)
}