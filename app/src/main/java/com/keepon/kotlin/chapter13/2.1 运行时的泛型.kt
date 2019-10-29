package com.keepon.kotlin.chapter13

/**
 * createBy	 keepon
 */

//和Java一样，Kotlin的泛型在运行时也被擦除了，这意味着 泛型类实例不会携带用于创建它的类型实参的信息。

//例如，如果你创建了一个List<String>，在运行时你只能看到它是一个List，不能识别出列表本打算包含的是String类型的元素。
//
//接下来我们谈谈伴随着擦除类型信息的约束，因为类型实参String没有被存储下来，你不能检查它们。
//例如，你不能判断一个列表是一个包含字符串的列表还是包含其它对象的列表，也就是说，在is检查中不可能使用类型实参中的类型，例如

//fun main(args: Array<String>) {
//    val authors = listOf("first", "second")
////    将会在编译时抛出下面的异常：  Cannot check for instance of erased type
////    if (authors is List<Int>) {
////    }
//    if (authors is List<*>){
//
//    }
//}
//Kotlin不允许使用 没有指定类型实参的泛型类型，如果希望检查一个值是否是列表，而不是set或者其它对象，可以使用特殊的 星号投影 语法来做这个检查：



//在as和as?转换中仍然可以使用一般的泛型类型，但是如果该类 有正确的基础类型但类型实参是错误的，
//转换也不会失败，因为在运行时转换发生的时候类型实参是未知的。因此，这样的转换会导致编译器发出unchecked cast的警告，例如下面这段程序：

fun printSum(c: Collection<*>) {
    val intList = c as? List<Int>
            ?: throw IllegalArgumentException("List is expected")
    println(intList.sum())
}

fun main(args: Array<String>) {
    //(1) 正常运行。
    printSum(listOf(1, 2, 3))
    //(2) as 检查是成功的，但是调用 intList.sum() 方法时会抛出异常。
    printSum(listOf("a", "b", "c"))

    printSum2(listOf(1, 2, 3))
}


//在(2)调用时，并不会抛出IllegalArgumentException异常，而是在调用sum函数时才发生，因为sum函数试着从列表中读取Number值然后把它们加在一起，
//把String当做Number使用的尝试会导致运行时的ClassCastException。
//
//假如在编译期，Kotlin已经知道了相应的类型信息，那么is检查是允许的：
fun printSum2(c: Collection<Int>) {
    if (c is List<Int>) {
        println(c.sum())
    }
}

//c是否拥有类型List<Int>的检查是可行的，因为我们将函数类型的形参类型声明为了Collection<Int>，因此编译期就确定了集合包含的是整型数字。
//
//不过，Kotlin有特殊的语法结构可以允许你 在函数体中使用具体的类型实参，但只有inline函数可以，接下来让我们来看看这个特性。












