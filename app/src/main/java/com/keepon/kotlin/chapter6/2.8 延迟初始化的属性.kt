package com.keepon.kotlin.chapter6

/**
 * createBy	 keepon
 */
//很多框架都会在对象实例创建后用专门的方法来初始化对象，例如Activity的onCreate方法，但是你不能在构造方法中完全放弃非空属性的初始化器，
//仅仅在一个特殊的方法里初始化它，如果某个属性是非空类型，那么必须在构造方法中提供非空的初始化值，否则你就必须使用可空类型。
//但是如果使用了可空类型，那么该属性的每次访问都需要null检查或者!!运算符。

class Person2{
  private  var name :String?
  private  lateinit var name2 :String
    constructor(name:String){
        this.name = name
        this.name2 = name
    }
//    凡是用到name属性的时候，都需要通过安全调用运算符?.检查后，才能调用String的方法，这是相当麻烦的。为了解决这个问题，我们可以将name属性声明成可以延迟初始化的
    fun  performFunc(){
        println("contains = ${name?.contains("keepon")?: false}")
    }

    //如果在属性被初始化前调用了它的方法，那么会抛出下面的异常。
    fun  performFunc2(){
        println("contains = ${name2.contains("keepon")?: false}")
    }
}

fun main(args: Array<String>) {
    val p = Person2("keepon")
    p.performFunc()
    p.performFunc2()
}

































