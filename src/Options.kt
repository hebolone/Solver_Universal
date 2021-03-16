class Options {
    enum class TOption {
        SHOW_ALL_STEPS,
        SHOW_DATETIME,
        PRINT_IN_LINE
    }
    companion object {
        var ShowAllSteps : Boolean = true
        var ShowDateTime : Boolean = false
        var PrintInLine  : Boolean = false
        fun SetOption(iOption : TOption, iValue : Boolean) {
            when (iOption) {
                TOption.SHOW_ALL_STEPS -> ShowAllSteps = iValue
                TOption.PRINT_IN_LINE -> PrintInLine = iValue
                TOption.SHOW_DATETIME -> ShowDateTime = iValue
            }
        }
    }
}