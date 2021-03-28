package net.println.kotlin.chapter2

/**
 * Created by benny on 2/26/17.
 */
fun getName(): String?{
    return null
}

fun main(args: Array<String>) {
//    val name: String = getName() ?: return
//    println(name.length)

    val value: String? = "HelloWorld"
    //便是空参数就抛异常
    println(value!!.length)
}