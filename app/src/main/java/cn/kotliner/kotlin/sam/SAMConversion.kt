package cn.kotliner.kotlin.sam

import cn.kotliner.java.sam.SAMInJava

fun main(args: Array<String>) {
    val samInJava = SAMInJava()
    //只有一个接口方法，可以用lambda表达式替代
    val lambda = {
        println("Hello")
    }

    //add 一个lambda表达式，相当于传了一个lambda接口实例
    samInJava.addTask(lambda)
//    samInJava.addTask(lambda)
//    samInJava.addTask(lambda)
//    samInJava.addTask(lambda)
//
    //remove一个也remove不掉，lambda并不是一个实例
//    samInJava.removeTask(lambda)
//    samInJava.removeTask(lambda)
//    samInJava.removeTask(lambda)
//    samInJava.removeTask(lambda)
//
    val samInKotlin = SAMInKotlin()
    //需要定义typealias Runnable=()->Unit，不然报错
//    samInKotlin.addObserver(){
//
//    }
    samInKotlin.addTask {
    }
}