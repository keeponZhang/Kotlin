package com.bennyhuo.kotlin.coroutines.core

import com.bennyhuo.kotlin.coroutines.dispatcher.Dispatcher
import com.bennyhuo.kotlin.coroutines.utils.log
import java.util.concurrent.LinkedBlockingDeque
import kotlin.coroutines.CoroutineContext

typealias EventTask = () -> Unit

class BlockingQueueDispatcher: LinkedBlockingDeque<EventTask>(), Dispatcher {
    override fun dispatch(block: () -> Unit) {
//        offer添加不会抛异常
        log("BlockingQueueDispatcher dispatch $block")
        offer(block)
    }
}

class BlockingCoroutine<T>(context: CoroutineContext, private val eventQueue: LinkedBlockingDeque<EventTask>)
    : AbstractCoroutine<T>(context){
//    这里是消费
    fun joinBlocking(): T {
//        take没有会阻塞
        while(!isCompleted){
            eventQueue.take().invoke()
            //这个执行继续，表示block被执行几次，就是resumewith被执行几次
            log("------------------joinBlocking-----------------")
        }
        return (state.get() as CoroutineState.Complete<T>).let {
            it.value ?: throw it.exception!!
        }
    }
}