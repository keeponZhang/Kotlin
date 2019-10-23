package com.keepon.kotlin.chapter5

/**
 * createBy	 keepon
 */


//Java只允许捕捉final变量，而当你想捕捉可变变量的时候，可以使用两种技巧：
//
//声明一个单元素的数组，其中存储可变值
//创建一个包装类的实例，其中存储要改变的值的引用
//这样，当捕捉了一个可变变量var的时候，它的值被作为Ref类的一个实例被存储下来，Ref变量是final的能轻易被捕捉，然后实际值存储在其字段中，并且可以在lambda内被修改。
//
