package ch05.ex1_3_2_SyntaxForLambdaExpressions1

fun main(args: Array<String>) {
    println(42)
//    加了{} 没有东西答应
    var c = { println(52) }
    val b = println(72)
    println(b)
    println(run { c })
}
