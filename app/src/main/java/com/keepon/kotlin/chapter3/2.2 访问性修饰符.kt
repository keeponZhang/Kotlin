package com.keepon.kotlin.chapter3

/**
 * createBy	 keepon
 */
//一般类
//在Kotlin中，类和方法默认都是final的，如果想允许创建一个类的子类，需要使用open修饰符来标示这个类，此外还需要给每一个允许被重写的属性或方法添加open修饰符
//如果重写了一个基类的成员，重写了的函数同样默认是open的，如果想改变这一行为，可以显示地将重写的成员标注为final

//抽象类
//我们可以将一个类声明为abstract，这种类不能被实例化，一个从抽象类通常包含一些没有实现并且必须在子类重写的抽象成员：
//抽象类中的抽象函数：没有函数体就默认是abstract的，不一定要加上关键字，其访问性始终是open的
//抽象类中的非抽象函数：默认是final的，如果需要重写，那么需要加上open修饰符。

//重点：open、final和abstract这三个访问修饰符都 只适用于类，不能用在接口 当中：
//open：用于声明一个类可以被继承，或者方法可以被子类重写。
//final：不允许类被继承，或者不允许方法被重写。
//abstract：声明抽象类，或者抽象类中的抽象方法。
//当我们需要重写方法时，必须加上override修饰符。

open class RichButton : Clickable {
    fun disable() {}
    open fun animate() {}
    final override fun click() {
        println()
    }

    override fun showOff2() {
        TODO("Not yet implemented")
    }
}

open class RichButton2