package cn.kotliner.coroutine.async

import java.util.concurrent.Executors

/**
 * Created by benny on 5/29/17.
 */

private val pool by lazy {
    Executors.newCachedThreadPool()
}

//val block: ()-> Unit这里是构造函数参数
class AsyncTask(val block: ()-> Unit){
    fun execute() = pool.execute(block)
}