package com.zhang

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 *createBy keepon
 */
//https://blog.csdn.net/u012165769/article/details/118488207


fun main() {
    testOne()
//    testTwo()
}

fun testOne() {
//    如果combined中没有拦截器，会传入一个默认的拦截器，即Dispatchers.Default,这也解释了为什么我们没有传入拦截器时会有一个默认切换线程的效果
    GlobalScope.launch {
        print("1:" + Thread.currentThread().name)
        delay(1000)
        print("2:" + Thread.currentThread().name)
    }
}

//打印结果为：DefaultDispatcher-worker-1
fun testTwo() {
    TestViewModel().viewModelScope.launch {
        print("1:" + Thread.currentThread().name)
        delay(1000)
        print("2:" + Thread.currentThread().name)
    }
}
//打印结果为: main