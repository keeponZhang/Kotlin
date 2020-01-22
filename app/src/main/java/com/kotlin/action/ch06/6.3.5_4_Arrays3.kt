package ch06.ex3_5_4_Arrays3

fun main(args: Array<String>) {
//    为了表示基本数据类型的数组， Kotlin 提供了若干独立的类，每一种基本数据类型都对应一个
    //没有拆装箱过程，效率较高
    //通过构造方法创建
    val squares = IntArray(5) { i -> (i + 1) * (i + 1) }
    println(squares.joinToString())

    //通过工厂函数创建
    intArrayOf(4)
    intArrayOf(0, 1, 1, 1)
}
