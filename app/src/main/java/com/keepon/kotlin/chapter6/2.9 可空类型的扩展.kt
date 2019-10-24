package com.keepon.kotlin.chapter6

/**
 * createBy	 keepon
 */

//为可空类型定义扩展函数时一种更强大的处理null值的方式，可以允许接收者为null的（扩展函数）调用，并在该函数中处理null，而不是在确保变量不为null后再调用它的方法。
//
//只有扩展函数能做到这点，普通成员方法的调用是通过对象实例分发的，因此实例为null时（成员方法）永远不能被执行。
//
//在Kotlin标准库中定义的isNullOfEmpty就可以由String?类型的接收者调用：

fun verifyUserInput(input:String?){
    //fun String?.isNullOfBlank() : Boolean = this == null || this.isBlank()
    if(input.isNullOrBlank()){
        println("please fill in required fields")
    }
}

fun main(args: Array<String>) {
    verifyUserInput("")
    verifyUserInput(null)
}




















