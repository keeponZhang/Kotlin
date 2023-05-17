package cn.kotliner.coroutine.ui.operatorSample

import cn.kotliner.coroutine.ui.operatorSample.custom.AbstractCoroutineContextElement
import cn.kotliner.coroutine.ui.operatorSample.custom.CoroutineContext


class MyElement : AbstractCoroutineContextElement(MyElement) {
    public companion object Key : CoroutineContext.Key<MyElement>
}