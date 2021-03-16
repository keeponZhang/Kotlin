package ch05.ex4_1_SAMConstructors

import com.kotlin.action.ch04.java.TestRunnable

fun main(args: Array<String>) {
    var testRunnable = TestRunnable()
    testRunnable.postponeComputation(100) {
        println(42)
//        注意lambda 内部没有匿名对象那样的this ：没有办法引用到lambda 转换
//        成的匿名类实例。从编译器的角度来看， lambda 是一个代码块，不是一个对象，
//        而且也不能把它当成对象引用。Lambda 中的this 引用指向的是包围它的类。
//        println(this)
    }

    testRunnable.postponeComputation(100, object : Runnable {
        override fun run() {
            println(12)
            println(this)
        }
    })
}

//如果有一个方法返回的是一个函数式接口的实例，不能直接返回一个lambda
fun createAllDoneRunnable(): Runnable {
    return Runnable {
        println("All!")
    }
}