package Problem_7

import Events.CSolverBase
import java.util.*

class CSolver_7 : CSolverBase() {
    private enum class TColor {
        RED, BLACK
    }
    private enum class TSide(val side : Int) {
        FRONT(0),
        BACK(1);
        companion object {
            fun getByValue(value: Int) = values().first { it.side == value }
        }
    }
    private val _Random = Random()
    private data class Card(val sideA : TColor, val sideB : TColor)
    private fun Card.selectSide(side : TSide) : TColor =
        when(side) {
            TSide.FRONT -> this.sideA
            TSide.BACK -> this.sideB
        }
    private data class Result(var red : Int = 0, var black : Int = 0)
    private fun Result.GetTotal() : Triple<Int, Double, Double> {
        val total = red + black
        return Triple(total, red.toDouble() / total.toDouble(), black.toDouble() / total.toDouble())
    }
    private fun Double.format(digits: Int) = "%.${digits}f".format(this)
    private val _Sides = 2
    //------------------------------------------------------------------------------------------------------------------
    override fun Solve() {
        //  Prepare cards
        val cards = listOf(
            Card(TColor.RED, TColor.RED),
            Card(TColor.RED, TColor.BLACK),
            Card(TColor.BLACK, TColor.BLACK),
            )
        val result = Result()
        //  Generate random number
        (1..10000).forEach {
            val randomCard = GenerateRandom(cards.size)
            val randomSide = TSide.getByValue(GenerateRandom(_Sides))
            val extractedCard = cards[randomCard]
            val extractedColor = extractedCard.selectSide(randomSide)

            if(extractedColor == TColor.RED) {
                //  Let's see other face card :-)
                when(randomCard) {
                    0 -> result.red ++
                    1 -> result.black ++
                }
            }
        }
        val resultTotal = result.GetTotal()
        println("Total: ${resultTotal.first}, red: ${result.red} ( ${resultTotal.second.format(2)}%), black: ${result.black} (${resultTotal.third.format(2)} %)")
    }
    private fun GenerateRandom(noOfCards : Int) : Int {
        return _Random.nextInt(noOfCards)
    }
}

