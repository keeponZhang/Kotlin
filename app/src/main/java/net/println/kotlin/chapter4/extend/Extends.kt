package net.println.kotlin.chapter4.extend

/**
 * Created by benny on 4/4/17.
 */
fun main(args: Array<String>) {
    println("abc" * 16)
    println("keepon".times(3))
    println("keepon".a)
    println("abc".b)

}

//拓展方法 (反编译看后，其实就是用静态方法)
operator fun String.times(int: Int): String{
    val stringBuilder = StringBuilder()
    for(i in 0 until int){
        //this 指代调用者
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}

val String.a: String
    get() = "a"+this
////拓展属性不能初始化，下面这个会报错
//var String.cc :Int = 2

var String.b: Int
    set(value) {

    }
    get() = 5
