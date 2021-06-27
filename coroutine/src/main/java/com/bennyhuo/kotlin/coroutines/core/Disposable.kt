package com.bennyhuo.kotlin.coroutines.core

import com.bennyhuo.kotlin.coroutines.Job
import com.bennyhuo.kotlin.coroutines.OnCancel

typealias OnCompleteT<T> = (Result<T>) -> Unit
//你可以通过这个东西随时把你移除掉
interface Disposable {
    fun dispose()
}
//这里要注意传入构造函数的变量，OnCompleteT跟OnComplete不一样
class CompletionHandlerDisposable<T>(val job: Job, val onComplete: OnCompleteT<T>): Disposable {
    override fun dispose() {
//        协程结束的时候不需要再调用我啦
        job.remove(this)
    }
}

class CancellationHandlerDisposable(val job: Job, val onCancel: OnCancel): Disposable {
    override fun dispose() {
        job.remove(this)
    }
}

sealed class DisposableList {
    object Nil: DisposableList()
//    最后一个
    class Cons(val head: Disposable, val tail: DisposableList): DisposableList()
}

fun DisposableList.remove(disposable: Disposable): DisposableList {
    return when(this){
//        最后一个了，直接返回this就可以，没有其他可以移动
        DisposableList.Nil -> this
        is DisposableList.Cons -> {
//            head找到了，因为这里返回的是DisposableList，所以返回tail
            if(head == disposable){
                return tail
            } else {
//                没有的或继续递归，此时需要构建一个，看看tail能不能遍历下去
                DisposableList.Cons(head, tail.remove(disposable))
            }
        }
    }
}

tailrec fun DisposableList.forEach(action: (Disposable) -> Unit): Unit = when(this){
//    最后一个了，当然返回空
    DisposableList.Nil ->Unit
    is DisposableList.Cons -> {
//        如果是Cons，显示遍历head
        action(this.head)
//        this.tail又是DisposableList，所以又重新调用一边forEach
        this.tail.forEach(action)
    }
}

//是DisposableList的拓展函数
inline fun <reified T: Disposable> DisposableList.loopOn(crossinline action: (T) -> Unit) = forEach {
    when(it){
//        action接收的是一个T
        is T -> action(it)
    }
}