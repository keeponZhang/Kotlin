package ch02.ex1_4_3_StringTemplates2

fun main(args: Array<String>) {
//   还可以在双引号中直接嵌套双引号，只要它们处在某个表达式的范围内（即花括号内）：
    println("Hello, ${if (args.size > 0) args[0] else "someone"}!")
    val bo = true;
    println("tt ${if (bo) "22" else "44"}")
}


