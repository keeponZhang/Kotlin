package com.kotlin.action.ch04.book.修改访问器的可见性


/**
 *createBy keepon
 */

//接下来关于属性的更多话题
//在本书接下来的部分，我们还会继续关于属性的讨论。这里有一些参考话题：
//· 在非空属性上使用的lateinit修饰符表明这个属性会将初始化推迟到
//构造方法被调用过后，这是一些框架的常见用法。这些功能将在第6 章中
//涵盖到。
//· 惰性初始化属性，作为更通用的委托属性的一部分，将会在第7 章中
//涵盖到。为了与Java 框架的兼容性，可以在Kotlin中使用注解来模仿
//Java的功能。例如，属性上的＠JvmField注解用来在没有访问器的情况
//下暴露一个public的字段。你会在第10章学到更多关于注解的内容。
//• const修饰符使得使用注解更加方便，并且允许使用基本数据类型或者
//String的属性作为注解参数。第10章会给出相关的细节。