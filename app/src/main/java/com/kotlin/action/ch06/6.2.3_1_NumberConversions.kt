package ch06.ex2_3_1_NumberConversions

fun main(args: Array<String>) {
    val x = 1
    val list = listOf(1L, 2L, 3L)
    //这个不会通过编译
//    println(x in list)
    println(x.toLong() in list)
}
