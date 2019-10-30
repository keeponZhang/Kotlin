package com.keepon.kotlin.other

/**
 * createBy	 keepon
 */

//泛型实化在Java中是个不存在的概念，属于Kotlin的新特性；它能在运行时保留泛型信息，这听起来违反了JVM的机制，但是它确实可以做到，
//而且原理很简单。在不使用实化的情况下，下面的代码是不能通过编译的。

//fun <T> create(): T = mRetrofit.create(T::class.java)
//因为T在运行时不存在，所以没法通过T拿到T的class对象。

//但是加上实化以后：
//inline fun <reified T> create(): T = mRetrofit.create(T::class.java)
//这个方法不仅可以被合法声明，而且在调用时也会非常优雅。
//val service = create<NetworkService>()

//create()方法不接收任何对象作为参数，而是只是传入了一个类型参数，就可以根据传入类型的不同返回我们需要的对象

//原理很简单，create()方法被声明称inline了，学过高阶函数的应该已经了解了，
//任何被声明称inline的函数都会把函数体内的所有代码直接复制到每一个被调用的地方，而由于泛型参数的不同，
//所以每一个调用inline函数的位置都会因为泛型的不同而有所不同，这样做其实就是间接的保留了泛型的运行时信息，
//看起来这似乎还是对伪泛型的投机取巧，但实际上非常有用。
//
//作者：Raidriar
//链接：<a href='https://www.jianshu.com/p/016a24ba7a25'>https://www.jianshu.com/p/016a24ba7a25</a>
//来源：简书
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


































