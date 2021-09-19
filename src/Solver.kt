import MenuManager.*

fun main() {
    val mm = MenuManager("SIMO SOLVER")
    val mnuSettings = CMenu("s", "Settings", {})
    val mnuShowSteps = CMenuVar("t", "Show all steps (when possible)", {
        Options.ShowAllSteps = ! Options.ShowAllSteps
    }, {
        return@CMenuVar Options.ShowAllSteps
    }, mnuSettings)
    val mnuShowDateTime = CMenuVar("d", "Show date time when printing results", {
        Options.ShowDateTime = ! Options.ShowDateTime
    }, {
        return@CMenuVar Options.ShowDateTime
    }, mnuSettings)

    var counter = 0
    val problemList = listOf(
        FactoryProvider.TSolver.PROBLEM_1,
        FactoryProvider.TSolver.PROBLEM_2,
        FactoryProvider.TSolver.PROBLEM_3,
        FactoryProvider.TSolver.PROBLEM_4,
        FactoryProvider.TSolver.PROBLEM_5,
        FactoryProvider.TSolver.PROBLEM_6,
        FactoryProvider.TSolver.PROBLEM_7,
        FactoryProvider.TSolver.PROBLEM_8
    )

    mm.run {
        problemList.forEach {
            val description = getAnnotationValue(it)
            AddMenu((++counter).toString(), description) { problemSolver(it) }
        }
        AddMenu(listOf(mnuSettings, mnuShowSteps, mnuShowDateTime))
        Interpreter()
    }
}

fun getAnnotationValue(enum:FactoryProvider.TSolver) : String = enum.declaringClass.getField(enum.name).getAnnotation(Description::class.java).description

fun problemSolver(iProblem : FactoryProvider.TSolver) = FactoryProvider.getSolver(iProblem).Solve()
