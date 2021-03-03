package com.keepon.kotlin.chapter11

inline fun runRunnable(crossinline block: () -> Unit) {
    //内联函数的blcok可以用return，而匿名内部类生成的block不能用retrun,这里可以用crossinline
    val runnable = Runnable() {
        block()
    }
}
















































