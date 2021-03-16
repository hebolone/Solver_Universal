package Problem_3

import Events.CSolverBase

class CSolver_3(iMIN : Int, iMAX : Int) : CSolverBase() {
    private var container = (iMIN..iMAX).toMutableList()
    override fun Solve() {
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