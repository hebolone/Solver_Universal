import MenuManager.*

fun main(args : Array<String>) {
    val mm = MenuManager("SIMO SOLVER")
    val problems = CProblems()
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

    mm.run {
        AddMenu("1", "Problem 1", problems::Problem_1)
        AddMenu("2", "Problem 2", { (problems::Problem_2)(1, 100) })
        AddMenu("3", "Problem 3", problems::Problem_3)
        AddMenu(mnuSettings)
        AddMenu(mnuShowSteps)
        AddMenu(mnuShowDateTime)
        Interpreter()
    }
}
