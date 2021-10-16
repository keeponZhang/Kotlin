package com.bennyhuo.kotlin.coroutines.core

import com.bennyhuo.kotlin.coroutinebasics.utils.log

sealed class CoroutineState {
    //表示要取消的集合list，是CoroutineState的成员变量，这里其实放的就是完成或者取消的回调
    private var disposableList: DisposableList = DisposableList.Nil

    //直接做了一份复制，调用之前会创建一个CoroutineState
    fun from(state: CoroutineState): CoroutineState {
        this.disposableList = state.disposableList
        return this
    }

    fun with(disposable: Disposable): CoroutineState {
//        传进来的disposable跟原来的disposableList创建一个新的disposableList
        this.disposableList = DisposableList.Cons(disposable, this.disposableList)
        return this
    }

    //移除
    fun without(disposable: Disposable): CoroutineState {
        this.disposableList = this.disposableList.remove(disposable)
        return this
    }

    // disposableList放的就是完成或者取消的回调
//    Continuation完成后，回调resumeWith之后，会调用到这里
    fun <T> notifyCompletion(result: Result<T>) {
        this.disposableList.loopOn<CompletionHandlerDisposable<T>> {
//it就是泛型参数类型
            log("CoroutineState notifyCompletion CompletionHandlerDisposable $it")
            it.onComplete(result)
        }
    }

    fun notifyCancellation() {
//        找到所有CancellationHandlerDisposable状态的，
        disposableList.loopOn<CancellationHandlerDisposable> {
            it.onCancel()
        }
    }

    fun clear() {
        this.disposableList = DisposableList.Nil
    }

    override fun toString(): String {
        return "CoroutineState.${this.javaClass.simpleName}"
    }

    class InComplete : CoroutineState()
    class Cancelling : CoroutineState()

    //    就是Result里面的T
    class Complete<T>(val value: T? = null, val exception: Throwable? = null) : CoroutineState()
}