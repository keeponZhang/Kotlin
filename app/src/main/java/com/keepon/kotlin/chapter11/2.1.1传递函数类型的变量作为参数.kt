package com.keepon.kotlin.chapter11

/**
 * createBy	 keepon
 */
//在调用内联函数的时候，也可以传递函数类型的变量作为参数，还是上面的例子，我们换一种调用方式：

inline fun inlineFunc2(prefix : String, action : () -> Unit) {
    println("call before $prefix")
    action()
    println("call after $prefix")
}

fun main(args: Array<String>) {
    //后面的括号相当于初始化
    val call: () -> Unit= { println("HaHa Keepon") }
    inlineFunc2("inlineFunc", call)
}
//那么此时最终被编译成的Java字节码为：
//fun main(args: Array<String>) {
//    println("call before inlineFunc ")
//    action()
//    println("call after inlineFunc")
//}
//在这种情况，只有inlineFunc的实现部分被内联了，而lambda的代码在内联函数被调用点是不可用的。


//如果在两个不同的位置使用同一个内联函数，但是用的是不同的lambda，
//那么内联函数会在每一个被调用的位置分别内联，内联函数的代码会被拷贝到使用它的两个不同位置，并把不同的lambda替换到其中。

















































