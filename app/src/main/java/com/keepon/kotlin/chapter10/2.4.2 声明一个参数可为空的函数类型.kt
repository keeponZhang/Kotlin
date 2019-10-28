package com.keepon.kotlin.chapter10

/**
 * createBy	 keepon
 */

//当声明一个参数为可空的函数类型时，不能直接调用作为参数传递进来的函数：Kotlin会因为检测到潜在的空指针而导致编译失败，在这种情况下有两种处理方式：
//
//显示地检查 null
//显示地检查null是一种比较容易理解的方法：
fun foo(callback : (()->Unit)?) {
    if (callback != null) {
        callback()
    }
}

//通过安全调用语法调用
//除此之外，因为函数类型是一个包含invoke方法的接口的具体实现，作为一个普通方法，invoke可以通过安全调用语法调用：

fun foo2(callback : (()->Unit)?) {
    callback?.invoke() /* 默认实现 */
}




























