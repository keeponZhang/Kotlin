package com.bennyhuo.kotlin.coroutines.sample.yuanli

public interface ElementV2 : CoroutineContextV2 {
    /**
     * A key of this coroutine context element.
     */
    public val key: CoroutineContextV2.KeyV2<*>

    @Suppress("UNCHECKED_CAST")
    public override operator fun <E : ElementV2> get(key: CoroutineContextV2.KeyV2<E>): E? =
            if (this.key === key) this as E else null

    public override fun <R> fold(initial: R, operation: (R, ElementV2) -> R): R =
            operation(initial, this)

    public override fun <R> fold2(initial: R, operation: (R, ElementV2) -> R): R =
            operation(initial, this)

    //不然就返回当期调用那个
    public override fun minusKey(
            key: CoroutineContextV2.KeyV2<*>, elementV2: ElementV2
    ): CoroutineContextV2 =
            if (this.key === key) EmptyCoroutineContextV2 else this
}