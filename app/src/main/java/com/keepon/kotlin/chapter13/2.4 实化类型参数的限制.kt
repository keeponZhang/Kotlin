package com.keepon.kotlin.chapter13

/**
 * createBy	 keepon
 */

//我们可以按下面的方式来使用实化类型参数
//
//用在类型检查和类型转换中：is、!is、as、as?
//使用Kotlin反射API，::class
//获取对应的java.lang.Class，::class.java
//作为调用其它函数的类型实参
//
//
//不能做下面的事情：
//
//创建指定为类型参数的类的实例
//调用类型参数类的伴生对象的方法
//调用 带实化类型参数函数 的时候使用 非实化类型形参作为类型实参
//把类、属性或者非内联函数的类型参数标记为reified，因为实化类型参数只能用在内联函数上，使用实化类型参数意味着函数和所有传给它的lambda都会被内联，如果内联函数使用lambda的方法导致lambda不能被内联，或者你不想lambda因为性能的关系被内联，可以使用noinline修饰符。
//




















