package ch05.ex1_4_2_AccessingVariablesInScope1

//和Java不一样， Kotlin允许在lambda 内部访问非final变量甚至修改它们。
//从lambda 内访问外部变量，我们称这些变量被lambda 捕捉，就像这个例子中的
//prefix 、clientErrors 以及serverErrors 一样。
//注意，默认情况下，局部变量的生命期被限制在声明这个变量的函数中。但是
//如果它被lambda 捕捉了，使用这个变量的代码可以被存储并稍后再执行。你可能会
//问这是什么原理。当你捕捉final变量时，它的值和使用这个值的lambda 代码一起
//存储。而对非final变量来说，它的值被封装在一个特殊的包装器中，这样你就可以
//改变这个值，而对这个包装器的引用会和lambda代码一起存储。
fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0
    responses.forEach {
        if (it.startsWith("4")) {
            clientErrors++
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors")
}

fun main(args: Array<String>) {
    val responses = listOf("200 OK", "418 I'm a teapot",
                           "500 Internal Server Error")
    printProblemCounts(responses)
}
