/*
 * Copyright 2010-2018 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package com.bennyhuo.kotlin.coroutines.sample.yuanli

import com.bennyhuo.kotlin.coroutines.utils.log

/**
 * Base class for [CoroutineContext.Element] implementations.
 * AbstractCoroutineContextElementV2这个很重要，传入的key基本是伴生对象
 */
@SinceKotlin("1.3")
public abstract class AbstractCoroutineContextElementV2(
        public override val key:
        CoroutineContextV2.KeyV2<*>
) : ElementV2

/**
 * An empty coroutine context.
 */



