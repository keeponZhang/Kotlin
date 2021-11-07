package com.bennyhuo.kotlin.coroutines

import com.bennyhuo.kotlin.coroutines.core.Disposable
//import com.sun.org.apache.xpath.internal.operations.Bool
import kotlin.coroutines.CoroutineContext

typealias OnComplete = () -> Unit

typealias CancellationException = java.util.concurrent.CancellationException
typealias OnCancel = () -> Unit

interface Job : CoroutineContext.Element {
    companion object Key : CoroutineContext.Key<Job>

    override val key: CoroutineContext.Key<*> get() = Job

    val isActive: Boolean

    val isCompleted: Boolean
//    可以在job添加一些回调，当结束的时候可以回调告诉你
    fun invokeOnCompletionListener(onComplete: OnComplete): Disposable
//  成功和失败都会返回Disposable
    fun invokeOnCancelListener(onCancel: OnCancel): Disposable

//    这个要注意下,就是移除监听，移除
    fun remove(disposable: Disposable)

    suspend fun join()

    fun cancel()
}