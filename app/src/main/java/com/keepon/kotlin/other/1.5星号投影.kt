package com.keepon.kotlin.other

/**
 * createBy	 keepon
 */
//这个概念比较简单，如果你不在乎泛型类的泛型参数到底是什么，而是仅仅只想将这个泛型类作为一种类型，我们就可以使用“ * ”代替类型参数，从而表明，类型参数是什么并不重要。最常见的例子就是KClass<T>，它是Java中Class在Kotlin中的实现，举例来说，Dog类的KClass对象的具体类型就是KClass<Dog>，而Cat类的KClass对象的具体类型是KClass<Cat>。
//
//假如我们有一个函数，它的内部使用了动态代理，它需要一个KClass类型的对象(是Cat 还是Dog不重要)，但是我在协变小节刚开始的时候说了KClass只是一个类，而不是一个类型，但是动态代理的精髓在于可以动态生成任何代理对象。这时候我们就使用星号代替类型参数
//
////实现省略
//fun function(class: KClass<*>)
//
//function(Cat::class)
//function(Dog::class)
//任何类型的Class对象都可以传入function函数。































