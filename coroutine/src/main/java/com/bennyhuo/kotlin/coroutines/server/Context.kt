package com.bennyhuo.kotlin.coroutines.server

import java.io.File

object Context {
    val host = "http://localhost:8081"

    val workDir = File(".").absoluteFile

    fun urlOf(file: File): String {
        return "${host}/${file.absoluteFile.relativeTo(workDir).path}"
    }
}

//挂起函数：以suspend修饰的函数
//挂起函数只能在其他挂起函数或协程种调用
//挂起函数调用时包含了协程挂起的语义
//挂起函数返回时则包含了协程恢复的语义

//协程有n个挂起点，n+2次resume被调用


//协程上下文
//协程执行过程种需要携带数据
//索引是CoroutineContext.Key
//元素是CoroutineContext.Element


//拦截器
//拦截器ContinuationInterceptor是一类协程上下文元素
//可以对协程上下文所在协程的Continuation进行拦截

//SafeContinuation的作用就是确保：
//1.resume只被调用一次
//2.如果在当前线程调用栈上直接调用则不会挂起

//1.SafeContinuation仅在挂起点时出现
//2.拦截器在每次恢复执行协程体时调用
//3.SuspendLambda是协程函数体