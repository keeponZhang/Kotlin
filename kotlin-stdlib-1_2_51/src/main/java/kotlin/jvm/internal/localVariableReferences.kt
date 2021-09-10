/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package kotlin.jvm.internal

import kotlin.reflect.KDeclarationContainer

private fun notSupportedError(): Nothing {
    throw kotlin.UnsupportedOperationException("Not supported for local property reference.")
}

@SinceKotlin("1.1")
open class LocalVariableReference : PropertyReference0() {
    override fun getOwner(): KDeclarationContainer = notSupportedError()

    override fun get(): Any? = notSupportedError()

}

@SinceKotlin("1.1")
open class MutableLocalVariableReference : MutablePropertyReference0() {
    override fun getOwner(): KDeclarationContainer = notSupportedError()

    override fun get(): Any? = notSupportedError()

    override fun set(value: Any?): Unit = notSupportedError()
}