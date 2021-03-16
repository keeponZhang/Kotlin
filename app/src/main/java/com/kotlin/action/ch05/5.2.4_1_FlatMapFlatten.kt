package ch05.ex2_4_1_FlatMapFlatten

fun main(args: Array<String>) {
    val strings = listOf("abc", "def")
    //最终返回一个list，it.toList生成的list会被遍历，重新加入一个集合
    println(strings.flatMap { it.toList() })
}
