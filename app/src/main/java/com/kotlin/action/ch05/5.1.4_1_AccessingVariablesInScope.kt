package ch05.ex1_4_1_AccessingVariablesInScope

fun printMessagesWithPrefix(messages: Collection<String>, prefix: String) {
    //这里Kotlin 和Java 的一个显著区别就是，在Kotlin 中不会仅限于访问final 变量，在lambda 内部也可以修改这些变量
    messages.forEach {
        println("$prefix $it")
    }
}

fun main(args: Array<String>) {
    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessagesWithPrefix(errors, "Error:")
}
