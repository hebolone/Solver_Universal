package Problem_5

import Events.CMainSolver
import java.util.*

class CSolver_5(private val iTries: Int = 1000000) : CMainSolver() {
    private val m_Random = Random()
    private val SEGMENTLENGTH = 1000
    private data class CResults(var OK : Int = 0, var KO : Int = 0)
    override fun Solve() {
        val result = CResults()
        (1..iTries).forEach {
            val rnd01 = GenerateRandom()
            val rnd02 = GenerateRandom()

            val array = arrayOf(rnd01, rnd02)
            array.sort()

            val segment_01 = array[0]
            val segment_02 = array[1] - array[0]
            val segment_03 = SEGMENTLENGTH - segment_01 - segment_02

            val segment_max = arrayOf(segment_01, segment_02, segment_03).max()
            if(segment_max!! < (SEGMENTLENGTH / 2))
                result.OK ++
            else
                result.KO ++
        }
        LaunchOnMessage("Launches: $iTries, OK: ${result.OK}, KO: ${result.KO}")
    }
    private fun GenerateRandom() : Int {
        return m_Random.nextInt(SEGMENTLENGTH)
    }
}