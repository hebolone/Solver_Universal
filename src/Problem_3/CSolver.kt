package Problem_3

import Events.CMainSolver

class CSolver(iMIN : Int, iMAX : Int) : CMainSolver() {
    private var container = (iMIN..iMAX).toMutableList()
    fun Solve() {
        var step = 1
        while(container.size != 1) {
            step ++
            var delete = true
            val iterator = container.iterator()
            while(iterator.hasNext()) {
                iterator.next()
                if(delete){
                    iterator.remove()
                }
                delete = ! delete
            }
            //  At the end I will print steps
            //  Prepare output message
            if(GetStepsVisible())
                LaunchOnMessage("Step $step (${container.size} elements) = ${container.joinToString(separator = ",")}")
            container.reverse()
        }
        LaunchOnMessage("Final result: ${container.first()} after $step steps.")
    }
}