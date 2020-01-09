package ch05.ex3_2_1_CreatingSequences

fun main(args: Array<String>) {
    val naturalNumbers = generateSequence(0) {
        println(it)
        it + 1
    }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    //sum方法调用触发numbersTo100的iterator(),然后触发naturalNumbers的iterator()
    //takeWhilet通过iterator.next()返回的item，传入takeWhile的lambda表达式做变换
    println(numbersTo100.sum())
}
