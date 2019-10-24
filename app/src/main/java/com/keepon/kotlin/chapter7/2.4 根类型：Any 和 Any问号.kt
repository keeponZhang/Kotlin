package com.keepon.kotlin.chapter7

/**
 * createBy	 keepon
 */
//
//Any类型是Kotlin所有非空类型的超类型，包括像Int这样的基本数据类型，和Java一样，把基本数据类型的值赋给Any类型的变量会自动装箱。
//
//在Kotlin中，如果你需要可以持有任何可能值的变量，包括null在内，必须使用Any?类型。
//
//在底层，Any类型对应java.lang.Object，Kotlin把Java方法参数和返回类型中用到的Object类型看作Any，当Kotlin函数函数中使用Any时，它会被编译成Java字节码中的Object。
//
//所有的Kotlin类都包含下面三个方法：toString、equals和hashCode，这些方法都继承自Any。Any不能使用其它Object的方法（例如wait和notify），但是可以通过手动把值转换成java.lang.Object来调用这些方法。

