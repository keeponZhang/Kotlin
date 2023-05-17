package cn.kotliner.coroutine.ui.operatorSample.custom

public object EmptyCoroutineContext : CoroutineContext {
    override var name: String = "EmptyCoroutineContext"


    public override fun <E : CoroutineContext.Element> get(key: CoroutineContext.Key<E>): E? = null
    public override fun <R> fold(initial: R, operation: (R, CoroutineContext.Element) -> R): R = initial
    public override fun plus(context: CoroutineContext): CoroutineContext = context
    public override fun minusKey(key: CoroutineContext.Key<*>): CoroutineContext = this
    public override fun hashCode(): Int = 0
    public override fun toString(): String = "EmptyCoroutineContext"
}