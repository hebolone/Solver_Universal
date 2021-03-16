package Events

interface ISolver {
    fun Solve()
    fun SetStepsVisibleFunc(iFunc : () -> Boolean) : ISolver
    fun SetOnMessage(iHandler : (String) -> Unit) : ISolver
    fun SetOption(iOption : Options.TOption, iValue : Boolean) : ISolver
}

abstract class CSolverBase() : ISolver {
    //  *** MEMBERS ***
    private val eventhandler_onMessage = EventHandler<String>()
    val onMessage = Event(eventhandler_onMessage)
    protected var GetStepsVisible : () -> Boolean = { false }
    //  *** METHODS ***
    protected fun LaunchOnMessage(iMessage : String) = eventhandler_onMessage(iMessage)
    override fun SetStepsVisibleFunc(iFunc : () -> Boolean) : ISolver {
        GetStepsVisible = iFunc
        return this
    }
    override fun SetOnMessage(iHandler: (String) -> Unit): ISolver {
        onMessage += { iHandler(it) }
        return this
    }
    override fun SetOption(iOption : Options.TOption, iValue : Boolean) : ISolver {
        Options.SetOption(iOption, iValue)
        return this
    }
}