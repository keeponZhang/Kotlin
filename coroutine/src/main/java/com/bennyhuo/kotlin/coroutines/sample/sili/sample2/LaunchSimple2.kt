package com.bennyhuo.kotlin.coroutines.sample.sili.sample2

import com.bennyhuo.kotlin.coroutines.launch
import com.bennyhuo.kotlin.coroutines.launchOne
import com.bennyhuo.kotlin.coroutines.newCoroutineContext
import com.bennyhuo.kotlin.coroutines.scope.cancel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


//响应取消的是响应调用的协程
 fun main() {
    //https://fanmingyi.blog.csdn.net/article/details/105027646
    GlobalScope.launch {
        println("MainActivity.onCreate")
    }

    //com.bennyhuo.kotlin.coroutines.scope.GlobalScope.launch {
    //    println("MainActivity.onCreate")
    //}
    //com.bennyhuo.kotlin.coroutines.scope.GlobalScope.launchOne {
    //    println("MainActivity.onCreate")
    //}
}


