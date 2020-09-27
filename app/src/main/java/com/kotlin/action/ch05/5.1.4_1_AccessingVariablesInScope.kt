package ch05.ex1_4_1_AccessingVariablesInScope

fun printMessagesWithPrefix(messages: Collection<String>, prefix: String) {
    //这里Kotlin和Java的一个显著区别就是，在Kotlin中不会仅限于访问final变量，在lambda内部也可以修改这些变量
    //lambda的入参不一定是自己传进去的，这里就是forEach里面调用action，并且传参
    messages.forEach { b ->
        println("$prefix $b")
    }
}

fun main(args: Array<String>) {
    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessagesWithPrefix(errors, "Error:")
}
