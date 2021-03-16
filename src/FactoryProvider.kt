import Events.ISolver
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class FactoryProvider<out T> {
    enum class TSolver {
        PROBLEM_1,
        PROBLEM_2,
        PROBLEM_3,
        PROBLEM_4,
        PROBLEM_5,
        PROBLEM_6
    }
    companion object {
        fun GetSolver(iProblem: TSolver) : ISolver = when (iProblem) {
            TSolver.PROBLEM_1 -> Problem_1.CSolver_1(1000, 10)
            TSolver.PROBLEM_2 -> Problem_2.CSolver_2()
            TSolver.PROBLEM_3 -> Problem_3.CSolver_3(1, 128)
            TSolver.PROBLEM_5 -> Problem_5.CSolver_5(10000000)
            TSolver.PROBLEM_6 -> Problem_6.CSolver_6().SetOption(Options.TOption.PRINT_IN_LINE, true)
            else -> throw Exception()
        }.SetStepsVisibleFunc { Options.ShowAllSteps }.SetOnMessage { (::ReceiveOnMessage)(it) }
    }
}

fun ReceiveOnMessage(iMessage : String) {
    val now = LocalDateTime.now()
    val datetimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
    val datetimeFormatted : String = if(Options.ShowDateTime) now.format(datetimeFormatter) else ""
    val newLine = if(Options.PrintInLine) "" else System.getProperty("line.separator")
    print("$datetimeFormatted $iMessage$newLine")
}