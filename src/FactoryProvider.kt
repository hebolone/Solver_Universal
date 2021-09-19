import Events.ISolver
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class FactoryProvider {
    enum class TSolver {
        @Description("Soluzioni di un sistema di equazioni")
        PROBLEM_1,
        @Description("Quanti 8 ci sono da 1 a 100")
        PROBLEM_2,
        @Description("Elimino un numero sì e uno no più volte. Cosa rimane?")
        PROBLEM_3,
        @Description("Risolvi sequenze")
        PROBLEM_4,
        @Description("Bastoncino spezzato che forma un triangolo")
        PROBLEM_5,
        @Description("Quadrati di numeri a 2 cifre meno 1 divisibili per 15")
        PROBLEM_6,
        @Description("3 carte, qual è la probabilità che l'altra faccia sia rossa")
        PROBLEM_7,
        @Description("Sommatoria di quadrati alternati")
        PROBLEM_8
    }
    companion object {
        fun getSolver(iProblem: TSolver) : ISolver = when (iProblem) {
            TSolver.PROBLEM_1 -> Problem_1.CSolver_1(1000, 10)
            TSolver.PROBLEM_2 -> Problem_2.CSolver_2()
            TSolver.PROBLEM_3 -> Problem_3.CSolver_3(1, 128)
            TSolver.PROBLEM_4 -> Problem_4.CSolver_4()
            TSolver.PROBLEM_5 -> Problem_5.CSolver_5(10000000)
            TSolver.PROBLEM_6 -> Problem_6.CSolver_6().SetOption(Options.TOption.PRINT_IN_LINE, true)
            TSolver.PROBLEM_7 -> Problem_7.CSolver_7()
            TSolver.PROBLEM_8 -> Problem_8.CSolver_8()
        }.SetStepsVisibleFunc { Options.ShowAllSteps }.SetOnMessage { (::receiveOnMessage)(it) }
    }
}

fun receiveOnMessage(iMessage : String) {
    val now = LocalDateTime.now()
    val datetimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
    val datetimeFormatted : String = if(Options.ShowDateTime) now.format(datetimeFormatter) else ""
    val newLine = if(Options.PrintInLine) "" else System.getProperty("line.separator")
    print("$datetimeFormatted $iMessage$newLine")
}

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class Description(val description: String)

