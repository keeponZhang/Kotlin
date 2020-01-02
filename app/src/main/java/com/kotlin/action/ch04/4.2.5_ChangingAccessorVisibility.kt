package ch04.ex2_5_ChangingAccessorVisibility

class LengthCounter {
    var counter: Int = 0
        private set    //不能在类外部修改这个属性

    fun addWord(word: String) {
        counter += word.length
    }
}

fun main(args: Array<String>) {
    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi!")
//    lengthCounter.counter = 10
    println(lengthCounter.counter)
}
