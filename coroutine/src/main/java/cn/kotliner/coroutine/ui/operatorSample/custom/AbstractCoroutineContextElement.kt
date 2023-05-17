package cn.kotliner.coroutine.ui.operatorSample.custom

public abstract class AbstractCoroutineContextElement(
    public override val key: CoroutineContext.Key<*>,
    override var name: String = ""
) :
    CoroutineContext.Element