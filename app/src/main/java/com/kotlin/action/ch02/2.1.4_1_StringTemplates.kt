package ch02.ex1_4_1_StringTemplates

fun main(args: Array<String>) {
    val name = if (args.size > 0) args[0] else "Kotlin"
//    字符串模板
    println("Hello, $name!")
}
