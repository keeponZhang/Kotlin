package cn.kotliner.coroutine.ui.operatorSample.custom


/**
 * Time:2023/5/17 15:03
 * Time:2023/5/17 15:03
 * Author:
 * Description:
 */
object Dispatchers {
    @JvmStatic
    public val IO: CoroutineDispatcher = DefaultScheduler.IO

    @JvmStatic
    public val Main: CoroutineDispatcher = DefaultScheduler.Main
}