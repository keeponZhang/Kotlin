package com.bennyhuo.kotlin.coroutines.sample.yuanli

object EmptyCoroutineContextV2 : CoroutineContextV2 {
    public override fun <E : ElementV2> get(
            key: CoroutineContextV2.KeyV2<E>
    ): E? = null

    public override fun <R> fold(initial: R, operation: (R, ElementV2) -> R): R = initial

    public override fun plus(context: CoroutineContextV2): CoroutineContextV2 = context
    public override fun minusKey(
            key: CoroutineContextV2.KeyV2<*>, elementV2: ElementV2
    ): CoroutineContextV2 = this

    public override fun hashCode(): Int = 0
    public override fun toString(): String = "EmptyCoroutineContext"
}