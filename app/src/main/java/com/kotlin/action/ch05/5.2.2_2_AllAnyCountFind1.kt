package ch05.ex2_2_2_AllAnyCountFind1

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3)
    //不是所有
    println(!list.all { it == 3 })
    //有一个符合就返回true
    println(list.any { it != 3 })
    println(list.any { it == 3 })
}
