package ch02.ex1_4_3_StringTemplates2

fun main(args: Array<String>) {
    println("Hello, ${if (args.size > 0) args[0] else "someone"}!")
    val bo = true;
    println("tt ${if (bo) "22" else "44"}")
}


