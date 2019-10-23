package com.keepon.kotlin.chapter5

/**
 * createBy	 keepon
 */

//当在函数内声明一个匿名内部类时，能够在这个匿名内部类引用这个函数的参数和局部变量，
//也可以用lambda做同样的事情，如果在函数内部使用lambda，也可以访问这个函数的参数，还有在lambda之前定义的局部变量。
//
//下面我们用标准库函数forEach来展示这种行为，它是最基本的集合操作函数之一：
//它所做的全部事情就是在集合中的每一个元素之上都调用给定的lambda：


fun printMessageWithPrefix(messages:Collection<String>,prefix:String){
    var clientError = 0
    messages.forEach(){
        println("$prefix $it")
//        在 lambda 中改变局部变量
        clientError++
    }
    println("clentError"+clientError)

}

//在Kotlin中，它允许在lambda内部访问非final变量甚至修改它们。从lambda内访问外部变量，我们称这些 变量被 lambda 捕捉，
//就像上面例子中的clientError。


//默认情况下，局部变量的生命周期被限制在声明这个局部变量的函数当中，但是如果它被lambda捕捉了，使用这个变量的代码可以被存储并稍后执行，原理为：
//当捕捉final变量时，它的值和使用这个值的lambda代码一起存储。
//对非final变量，它的值被封装在一个包装器中，这样你就可以改变这个值，而对这个包装器的引用会和lambda代码一起存储。

fun main(args: Array<String>) {
    val errors = listOf("403 ","404")
    printMessageWithPrefix(errors,"Error: ")
}






























