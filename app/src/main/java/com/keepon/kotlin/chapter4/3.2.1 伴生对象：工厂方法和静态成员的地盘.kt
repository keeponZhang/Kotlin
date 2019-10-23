package com.keepon.kotlin.chapter4

/**
 * createBy	 keepon
 */
//3.2 伴生对象：工厂方法和静态成员的地盘
//
//
//Kotlin的类不能拥有静态成员，作为替代，Kotlin依赖包级别函数（在大多数情形下能够替代Java的静态方法）和对象声明
//（在其他情况下替代Java的静态方法，同时还包括静态字段），在大多数情况下，推荐使用顶层函数，但是顶层函数不能访问类的private变量。
//
//因此，如果你需要写一个 在没有类实例的情况下 调用但是需要 访问类内部的函数，可以将其写成那个类中的 对象声明的成员.
//
//在类中定义的对象之一可以使用一个特殊的关键字来标记 companion，如果这样做，就获得了直接 通过容器类名称来访问这个对象的方法和属性的能力，
//不再需要显示地指明对象的名称，下面是一个基础的示例：

fun invodeInnerMethod(){
    Outer().innerMethod2()
}

class Outer{

    //使用companion+object 关键字，不再指定类名
    //这里去掉inner也行
    companion object inner{
         fun innerMethod(){
            println("innerMethod is called")
        }
    }
    fun innerMethod2(){
        println("innerMethod2 is called")
    }
    //Only one companion object is allowed per class
//    companion object inner2{
//        fun innerMethod2(){
//            println("innerMethod2 is called")
//        }
//    }
}

fun main(args: Array<String>) {
    invodeInnerMethod()

    Outer.innerMethod()
}

















