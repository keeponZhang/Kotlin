package com.keepon.kotlin.chapter3

/**
 * createBy	 keepon
 */
//定义从构造方法：constructor
//大多数在Java中需要重载构造方法的场景都被Kotlin支持命名参数和参数默认值的语法所覆盖了。
//而当我们需要扩展一个框架来提供多个构造方法，以便于通过不同的方式来初始化类的时候，就会需要用到从构造方法，从构造方式使用constructor方法引出，例如下面的代码：


//辅助类
class Context(val name:String)
class Attribute(val name:String)


//View
open  class View{
    var ctx = Context("I am default")
    var attr = Attribute("I am default")
    constructor(ctx:Context){
        this.ctx = ctx
    }
    constructor(ctx:Context,attr:Attribute){
        this.ctx = ctx
        this.attr = attr
    }
}

//    子类调用父类的从构造方法：super
class Button2:View{
    constructor(ctx: Context) : super(ctx)
}

//子类调用自己的另一个构造方法：this
class Button3:View{
    constructor(ctx: Context) : this(ctx, Attribute("I am Button3 attr"))
    constructor(ctx: Context,attr: Attribute) : super(ctx,attr)
}


//需要注意：如果类没有主构造方法，那么每个从构造方法必须初始化基类（通过super关键字）或者委托给另一个这样做了的构造方法（通过this关键字）
//也就是说，每个从构造方法必须以一个朝外的箭头开始，并且结束于任意一个基类构造方法
class Button4:View{
    constructor(ctx: Context,attr: Attribute) : super(ctx,attr)
}

fun main(args: Array<String>) {
    val view = View(Context("I am context"))
    println("contextName = ${view.ctx.name},attrName = ${view.attr.name}")

    val button2 = Button2(Context("I am Button2 context"))
    println("contextName = ${button2.ctx.name},attrName = ${button2.attr.name}")


    val button3 = Button3(Context("I am Button3 context"))
    println("contextName = ${button3.ctx.name},attrName = ${button3.attr.name}")

}




















