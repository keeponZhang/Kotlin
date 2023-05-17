package cn.kotliner.coroutine.ui.operatorSample

import cn.kotliner.coroutine.ui.operatorSample.custom.CombinedContext
import cn.kotliner.coroutine.ui.operatorSample.custom.CoroutineContext

/**
 * Time:2023/5/17 11:50
 * Author:
 * Description:
 */
class MyCombinedContext(left: CoroutineContext, element: CoroutineContext.Element) : CombinedContext(left, element) {
    override fun <R> fold(initial: R, operation: (R, CoroutineContext.Element) -> R): R {
        println("MyCombinedContext $name 准备 fold ")
        return super.fold(initial, operation)
    }
}