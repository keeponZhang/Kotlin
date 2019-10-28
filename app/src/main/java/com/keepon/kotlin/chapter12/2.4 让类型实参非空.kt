package com.keepon.kotlin.chapter12

/**
 * createBy	 keepon
 */
//如果你声明的是泛型类或者泛型函数，包括可空的类型实参在内，任何类型实参都可以替换它的类型形参。事实上，没有指定上界的类型形参将会使用Any?作为默认的上界，关于Any的含义可以参考 Kotlin 知识梳理(7) - Kotlin 的类型系统 中的2.4节。
//
//如果你想保证替换类型形参的始终是非空类型，可以通过指定一个约束来实现，如果除了可空性之外没有任何限制，那么可以使用Any代替默认的Any?作为上界。
//
//class Processor<T : Any> {
//    fun process(value : T) {
//        value.hashCode()
//    }
//}
//除了Any之外，还可以指定任意非空类型作为上界，来让类型参数非空。


























