package com.keepon.kotlin.chapter13

/**
 * createBy	 keepon
 */

//只有一种例外可以避免这种限制：内联函数。内联函数的类型形参能够被实化，意味着你可以 在运行时引用实际的类型实参。前面我们介绍过内联函数的两个优点：
//
//编译器会把每一次函数调用都替换成函数实际的代码实现
//如果该函数使用了lambda，lambda的代码也会内联，所以不会创建匿名类

//这里，我们介绍它一个新的优点：对于泛型函数来说，它们的类型参数可以被实化。我们将方面的函数修改如下，声明为inline并且用reified标记类型参数，就能用该函数检查value是不是T的实例：

inline fun <reified T> isA(value: Any) = value is T
//
////filterIsIntance函数可以接收一个集合，选择其中那些指定类的实例，然后返回这些被选中的实
fun main(args: Array<String>) {
    println(isA<String>("abc"))
    println(isA<String>(123))

    val items = listOf("one", 2, "three")
    println(items.filterIsInstance<String>())
}

//该函数的简化实现为：
//inline fun <reified T> Iterable<*>.filterIsIntance() : List<T> {
//    val destination = mutableListOf<T>()
//    for (element in this) {
//        if (element is T) {
//            destination.add(element)
//        }
//    }
//}

//我们之所以可以在inline函数中使用element is T这样的判断，而不能在普通的类或函数中执行的原因是因为：
//编译器把 实现内联函数的字节码 插入每一次调用发生的地方，每次你 调用带实化类型参数的函数 时，
//编译器都知道这次特定调用中 用作类型实参的确切类型，因此，编译器可以生成 引用作为类型实参的具体类 的字节码。
//
//因为生成的字节码引用了具体类，而不是类型参数，它不会被运行时发生类型擦除。注意，带reified类型参数的inline函数不能在Java代码中调用，
//普通的内联函数可以像常规函数那样在Java中调用 - 它们可以被调用而不能被内联。带实化类型参数的函数需要额外的处理，来把类型实参的值替换到字节码中，
//所以它们必须永远是内联的，这样它们不可能用Java那样普通的方式调用。



















