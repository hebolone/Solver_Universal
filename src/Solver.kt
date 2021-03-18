import MenuManager.*

fun main() {
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
    val problemList = listOf<FactoryProvider.TSolver>(
        FactoryProvider.TSolver.PROBLEM_1,
        FactoryProvider.TSolver.PROBLEM_2,
        FactoryProvider.TSolver.PROBLEM_3,
        FactoryProvider.TSolver.PROBLEM_4,
        FactoryProvider.TSolver.PROBLEM_5,
        FactoryProvider.TSolver.PROBLEM_6
    )

    mm.run {
        problemList.forEach {
            var description = getAnnotationValue(it)
            AddMenu((++counter).toString(), description) { (problems::ProblemSolver)(it) }
        }
        AddMenu(listOf(mnuSettings, mnuShowSteps, mnuShowDateTime))
        Interpreter()
    }
}

fun getAnnotationValue(enum:FactoryProvider.TSolver) : String {
    return enum.declaringClass.getField(enum.name).getAnnotation(Description::class.java).description
}