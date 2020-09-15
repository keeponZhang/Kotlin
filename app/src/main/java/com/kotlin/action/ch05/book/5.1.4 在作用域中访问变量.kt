package com.kotlin.action.ch05.book.在作用域中访问变量

import android.widget.Button

/**
 *createBy keepon
 */

//捕捉可变变量：实现细节
//Java 只九许你捕捉final变量。当你想捕捉可变变量的时候，可以使用下面
//两种技巧：要么声明一个单元素的教组，其中存储可变值；要么创建一个包装
//类的实例，其中存储要改变的值的引用。如果你在Kotlin中显式地使用这些技术，
//代码看起来是这样的：
//class Ref<T>(var value: T)
//val counter = Ref (O)          //模拟捕捉可变变量的类
//val inc = { counter.value++ }   //形式上是不变量被捕捉了,但是存储在学段中的实际值是可以修改的

//在实际代码中，你不需要创建这样的包装器，可以直接修改这个变量：
//var counter = 0
//val inc = { counter++ )
//这是什么原理？第一例子展示的就是第二个例子背后的原理。任何时候你
//捕捉了一个final变量（val),它的值被拷贝下来，这和Java一样。而当你捕
//捉了一个可变变量（var）时，它的值被作为Ref 类的一个实例被存储下来。
//Ref变量是final的能轻易地被捕捉，然而实际值被存储在其字段中，并且可以
//在lambda内修改 。


//这里有一个重要的注意事项，如果lambda被用作事件处理器或者用在其他异步
//执行的情况，对局部变量的修改只会在lambda执行的时候发生。例如，下面这段代
//码并不是记录按钮点击次数的正确方法：
//fun tryToCountButtonClicks(button: Button): Int {
//    var clicks = 0
//    button.setOnClickListener {
//        it.visibility
//        clicks++ }
//    return clicks
//}
//
//这个函数始终返回0。尽管onClick 处理器可以修改clicks的值，你并不
//能观察到值发生了变化，因为onClick 处理器是在函数返回之后调用的.
//这个函数正确的实现需要把点击次数存储在函数外依然可以访问的地方一一例如类的属性，
//而不是存储在函数的局部变量中。