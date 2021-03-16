import MenuManager.*

fun main(args : Array<String>) {
    val mm = MenuManager("SIMO SOLVER")
    val problems = CProblems()
    val mnuSettings = CMenu("s", "Settings", {})
    val mnuShowSteps = CMenuVar<Boolean>("t", "Show all steps (when possible)", {
        Options.ShowAllSteps = ! Options.ShowAllSteps
    }, {
        return@CMenuVar Options.ShowAllSteps
    }, mnuSettings)
    val mnuShowDateTime = CMenuVar<Boolean>("d", "Show date time when printing results", {
        Options.ShowDateTime = ! Options.ShowDateTime
    }, {
        return@CMenuVar Options.ShowDateTime
    }, mnuSettings)

    var counter = 0

    mm.run {
        AddMenu((++counter).toString(), "Problem $counter") { (problems::ProblemSolver)(FactoryProvider.TSolver.PROBLEM_1) }
        AddMenu((++counter).toString(), "Problem $counter") { (problems::ProblemSolver)(FactoryProvider.TSolver.PROBLEM_2) }
        AddMenu((++counter).toString(), "Problem $counter") { (problems::ProblemSolver)(FactoryProvider.TSolver.PROBLEM_3) }
        AddMenu((++counter).toString(), "Problem $counter", problems::Problem_4)
        AddMenu((++counter).toString(), "Problem $counter") { (problems::ProblemSolver)(FactoryProvider.TSolver.PROBLEM_5) }
        AddMenu((++counter).toString(), "Problem $counter") { (problems::ProblemSolver)(FactoryProvider.TSolver.PROBLEM_6) }
        AddMenu(listOf(mnuSettings, mnuShowSteps, mnuShowDateTime))
        Interpreter()
    }
}
