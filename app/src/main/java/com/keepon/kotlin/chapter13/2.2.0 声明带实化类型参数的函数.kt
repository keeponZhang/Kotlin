package com.keepon.kotlin.chapter13

/**
 * createBy	 keepon
 */

//Kotlin泛型在运行时会被擦除，这意味着如果你有一个泛型类的实例，你无法弄清楚在这个实例创建时用的究竟是哪些类型实参。
//泛型函数的实参类型也是这样，在调用泛型函数的时候，在函数体中你不能决定调用它用的类型实参。

//将会在编译时抛出 "Cannot check for instance of erased type : T" 的异常
//fun <T> isA(value : Any) = value is T



















































