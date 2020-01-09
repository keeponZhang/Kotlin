package ch05.ex1_3_4_SyntaxForLambdaExpressions4

fun main(args: Array<String>) {
//    lambda并没有被限制在这样小的规模，它可以包含更多的语句
    val sum = { x: Int, y: Int ->
        println("Computing the sum of $x and $y...")
        x + y
    }
    println(sum(1, 2))
}
