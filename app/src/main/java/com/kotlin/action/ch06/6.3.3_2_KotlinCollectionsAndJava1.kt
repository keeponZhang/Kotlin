package ch06.ex3_3_2_KotlinCollectionsAndJava1

import com.kotlin.action.ch06.CollectionUtils

// Kotlin
// collections.kt
//这里虽然使用了只读类型，但是调用了java方法集合，这个集合后来还是被修改了
//因此，如果你写了一个Kotlin 函数，使用了集合并传递给了Java ，你有责任使用正确的参数类型
fun printInUppercase(list: List<String>) {
    println(CollectionUtils.uppercaseAll(list))
    //下面这个会报错
//    for (s in list) {
//        s = "keepon"
//    }
    println(list.first())
}

fun main(args: Array<String>) {
    val list = listOf("a", "b", "c")
    printInUppercase(list)
}
