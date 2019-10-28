package com.keepon.kotlin.chapter9

/**
 * createBy	 keepon
 */
//让我们来总结一下委托属性是怎么工作的，假设你已经有了一个具有委托属性的类：

class Foo2 {
    var p  by Delegate()
}

//Delegate实例将会被保存到一个隐藏的属性中，它被称为<delegate>，编译器也将用一个KProperty类型的对象来表示这个属性，它被称为<property>，编译器生成的的代码如下：


//class Foo2 {
//    private val <delegate> = Delegate()
//
//    var prop : Type {
//        get() = <delegate>.getValue(this, <property>)
//        set(value : Type) = <delegate>.setValue(this, <property>, value)
//    }
//}



















































