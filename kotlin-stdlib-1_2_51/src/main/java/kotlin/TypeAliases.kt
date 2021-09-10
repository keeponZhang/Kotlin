/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

@file:Suppress("ACTUAL_WITHOUT_EXPECT") // for building kotlin-runtime

package kotlin


@SinceKotlin("1.1") public actual typealias Error = java.lang.Error
@SinceKotlin("1.1") public actual typealias Exception = java.lang.Exception
@SinceKotlin("1.1") public actual typealias RuntimeException = java.lang.RuntimeException
@SinceKotlin("1.1") public actual typealias IllegalArgumentException = java.lang.IllegalArgumentException
@SinceKotlin("1.1") public actual typealias IllegalStateException = java.lang.IllegalStateException
@SinceKotlin("1.1") public actual typealias IndexOutOfBoundsException = java.lang.IndexOutOfBoundsException
@SinceKotlin("1.1") public actual typealias UnsupportedOperationException = java.lang.UnsupportedOperationException

@SinceKotlin("1.1") public actual typealias NumberFormatException = java.lang.NumberFormatException
@SinceKotlin("1.1") public actual typealias NullPointerException = java.lang.NullPointerException
@SinceKotlin("1.1") public actual typealias ClassCastException = java.lang.ClassCastException
@SinceKotlin("1.1") public actual typealias AssertionError = java.lang.AssertionError

@SinceKotlin("1.1") public actual typealias NoSuchElementException = java.util.NoSuchElementException


@SinceKotlin("1.1") public actual typealias Comparator<T> = java.util.Comparator<T>