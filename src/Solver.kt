import MenuManager.*

fun main(args : Array<String>) {
    val mm = MenuManager("SIMO SOLVER")
    val solvers = CProblems()
    val mnuSettings = CMenu("s", "Settings", {})
    val mnuShowSteps = CMenuVar<Boolean>("s", "Show all steps (when possible)", {
        Options.ShowAllSteps = ! Options.ShowAllSteps
    }, {
        return@CMenuVar Options.ShowAllSteps
    }, mnuSettings)
    val mnuShowDateTime = CMenuVar<Boolean>("d", "Show date time when printing results", {
        Options.ShowDateTime = ! Options.ShowDateTime
    }, {
        return@CMenuVar Options.ShowDateTime
    }, mnuSettings)

    mm.AddMenu("1", "Problem 1", solvers::Problem_1)
    mm.AddMenu("2", "Problem 2", solvers::Problem_2)
    mm.AddMenu("3", "Problem 3", solvers::Problem_3)
    mm.AddMenu(mnuSettings)
    mm.AddMenu(mnuShowSteps)
    mm.AddMenu(mnuShowDateTime)
    mm.Interpreter()
}
