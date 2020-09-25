package ch05.ex1_3_1_SyntaxForLambdaExpressions

fun main(args: Array<String>) {
    val sum = { x: Int, y: Int ->
        val b = 3
        x + y
    }
    println(sum(1, 2))
}
