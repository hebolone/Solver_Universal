package Events

open class CMainSolver() {
    //  *** MEMBERS ***
    protected val eventhandler_onMessage = EventHandler<String>()
    val onMessage = Event(eventhandler_onMessage)
    protected var GetStepsVisible : () -> Boolean = { false }
    //  *** METHODS ***
    protected fun LaunchOnMessage(iMessage : String) {
        eventhandler_onMessage(iMessage)
    }
    fun SetStepsVisibleFunc(iFunc : () -> Boolean) {
        GetStepsVisible = iFunc
    }
}