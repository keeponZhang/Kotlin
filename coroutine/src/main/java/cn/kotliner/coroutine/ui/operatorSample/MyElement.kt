package cn.kotliner.coroutine.ui.operatorSample

import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

class MyElement : AbstractCoroutineContextElement(MyElement) {
    public companion object Key : CoroutineContext.Key<MyElement>
}