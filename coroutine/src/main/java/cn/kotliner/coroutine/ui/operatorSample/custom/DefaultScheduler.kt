package cn.kotliner.coroutine.ui.operatorSample.custom

object DefaultScheduler : ExecutorCoroutineDispatcher() {
    val IO = IOExecutorCoroutineDispatcher()
    val Main = IOExecutorCoroutineDispatcher()
    override fun dispatch(context: CoroutineContext, block: Runnable) {
    }


    class IOExecutorCoroutineDispatcher : ExecutorCoroutineDispatcher() {
        override fun dispatch(context: CoroutineContext, block: Runnable) {
        }

    }
}