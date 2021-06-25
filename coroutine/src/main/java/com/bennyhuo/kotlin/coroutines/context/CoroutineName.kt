package com.bennyhuo.kotlin.coroutines.context

import kotlin.coroutines.CoroutineContext

//这个是自定义的
class CoroutineName(val name: String): CoroutineContext.Element {
    companion object Key: CoroutineContext.Key<CoroutineName>

    override val key = Key

    override fun toString(): String {
        return name
    }
}