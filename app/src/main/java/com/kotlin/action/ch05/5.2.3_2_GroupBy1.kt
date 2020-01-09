package ch05.ex2_3_2_GroupBy1

fun main(args: Array<String>) {
    val list = listOf("a", "ab", "b")
    //String::first不用传进去对象，因为groupByTo函数会把对象传入
    println(list.groupBy(String::first))
}
