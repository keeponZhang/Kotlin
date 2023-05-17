/*
 * Copyright 2016-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

package cn.kotliner.coroutine.ui.operatorSample.custom


/**
 * User-specified name of coroutine. This name is used in debugging mode.
 * See [newCoroutineContext][CoroutineScope.newCoroutineContext] for the description of coroutine debugging facilities.
 */
public data class CoroutineName(
    /**
     * User-defined coroutine name.
     */
    override var name: String
) : AbstractCoroutineContextElement(CoroutineName) {
    /**
     * Key for [CoroutineName] instance in the coroutine context.
     */
    public companion object Key : CoroutineContext.Key<CoroutineName>

    override fun <R> fold(initial: R, operation: (R, CoroutineContext.Element) -> R): R {
        println("CoroutineName $name  准备fold")
        return super.fold(initial, operation)
    }

    /**
     * Returns a string representation of the object.
     */
    override fun toString(): String = "CoroutineName($name)"
}
