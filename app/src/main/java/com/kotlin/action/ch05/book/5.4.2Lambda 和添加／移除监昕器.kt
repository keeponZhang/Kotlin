package com.kotlin.action.ch05.book.Lambda添加和移除监昕器


/**
 *createBy keepon
 */

//Lambda和添加／移除监昕器
//注意lambda 内部没有匿名对象那样的this ：没有办法引用到lambda 转换
//成的匿名类实例。从编译器的角度来看，lambda 是一个代码块，不是一个对象，
//而且也不能把它当成对象引用。Lambda中的this引用指向的是包围它的类。
//如果你的事件监听器在处理事件时还需要取消它自己，不能使用lambda 这
//样做。这种情况使用实现了接口的匿名对象。在匿名对象内， this关键字指向
//该对象实例，可以把它传给移除监听器的API 。












