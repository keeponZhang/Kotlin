package ch03.ex1_1_CreatingCollectionsInKotlin

val set = hashSetOf(1, 7, 53)
val list = arrayListOf(1, 7, 53)
val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")


//为什么Kotlin没有自己专门的集合类呢？那是因为使用标准的Java集合类，
//为什么Kotlin可以更容易与Java代码交互。当从Kotlin中调用Java函数的时候，不用转换
//它的集合类来匹配Java的类，反之亦然。
fun main(args: Array<String>) {
    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)
}
