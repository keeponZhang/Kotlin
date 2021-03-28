package net.println.kotlin.chapter3

/**
 * Created by benny on 3/19/17.
 */
fun main(vararg args: String) {
//    for (arg in args){
//        println(arg)
//    }

    val list = arrayListOf(1,3,4,5)

    val array = intArrayOf(1,3,4,5)
    // *array现在只支持array
    hello(3.0, *array)
    //具名参数
    hello(3.0, *array,string = "keepon")
}

//vararg变长参数(因为具名参数的存在，变长参数可以在任意的位置)   String = "Hello"
fun hello(double: Double, vararg ints: Int, string: String = "Hello"){
    println(double)
    ints.forEach(::println)
    println(string)
}