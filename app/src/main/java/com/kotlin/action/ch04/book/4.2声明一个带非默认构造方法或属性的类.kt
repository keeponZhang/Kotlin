package com.kotlin.action.ch04.book.声明一个带非默认构造方法或属性的类



/**
 *createBy keepon
 */
//正如你所知，在Java中一个类可以声明一个或多个构造方法。Kotlin 也是类似
//的，只是做出了一点修改：区分了主构造方法（通常是主要而简洁的初始化类的方法，
//并且在类体外部声明）和从构造方法（在类体内部声明〉。同样也允许在初始化语
//句块中添加额外的初始化逻辑。首先我们会关注声明主构造方法和初始化语句块的
//语法，然后我们会阐明如何声明多个构造方法。最后，我们还会再谈谈属性。