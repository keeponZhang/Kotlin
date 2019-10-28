package com.keepon.kotlin.chapter11

/**
 * createBy	 keepon
 */
//当我们使用lambda表达式时，它会被正常地编译成匿名类。这表示每调用一次lambda表达式，
//一个额外的类就会被创建，并且如果lambda捕捉了某个变量，那么每次调用的时候都会创建一个新的对象，这会带来运行时的额外开销，导致使用lambda比使用一个直接执行相同代码的函数效率更低。
//
//如果使用inline修饰符标记一个函数，在函数被调用的时候编译器并不会生成函数调用的代码，
//而是 使用函数实现的真实代码替换每一次的函数调用。


//当一个函数被声明为inline时，它的函数体是内联的，也就是说，函数体会被直接替换到函数被调用地方，下面我们来看一个简单的例子，下面是我们定义的一个内联的函数：

inline fun inlineFunc(prefix : String, action : () -> Unit) {
    println("call before $prefix")
    action()
    println("call after $prefix")
}

//我们用如下的方法来使用这个内联函数：

fun main(args: Array<String>) {
    inlineFunc("inlineFunc") {
        println("HaHa")
    }
}

//最终它会被编译成下面的字节码：
//fun main(args: Array<String>) {
//    println("call before inlineFunc")
//    println("HaHa")
//    println("call after inlineFunc")
//}
//lambda表达式和inlineFunc的实现部分都被内联了，由lambda生成的字节码成了函数调用者定义的一部分，而不是被包含在一个实现了函数接口的匿名类中。




























































