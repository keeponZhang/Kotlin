package cn.kotliner.kotlin.collections

/**
 * Created by benny on 5/28/17.
 */
//默认值在通过标志位运算后才会赋值
fun main(args: Array<String>) {
    val arrayList = ArrayList<String>()
    arrayList.add("keepon")
    arrayList.add("mly")
    arrayList.removeAt(0)
    //参数引用用小括号
    arrayList.forEach(::println)


    //不可变的list
    val list = listOf("Hello", "World")
    val list2 = mutableListOf("Hello", "World")

    val map = mapOf("key" to "value", "2" to "whatever")
    Test
}

object Test {
    val list = listOf(1, 2, 4)
    fun test(): String = "keepon"
}