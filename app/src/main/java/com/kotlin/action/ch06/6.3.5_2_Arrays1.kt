package ch06.ex3_5_2_Arrays1

fun main(args: Array<String>) {
//    Array 构造方法接收数组的大小和一个调用lambda表达式，调用lambda表达式来创建每一个数组元素
    val letters = Array<String>(26) { i -> ('a' + i).toString() }
    println(letters.joinToString(""))
}
