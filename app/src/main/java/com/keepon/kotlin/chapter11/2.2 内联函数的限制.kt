package com.keepon.kotlin.chapter11

/**
 * createBy	 keepon
 */
//鉴于内联的运作方式，不是所有使用 lambda 的函数都可以被内联。当函数被内联的时候，作为参数的lambda表达式的函数体会被 替换到最终生成的代码中。
//
//这将限制函数体中的lambda参数的使用：
//
//如果lambda参数 被调用，这样的代码能被容易地内联。
//如果lambda参数 在某个地方被保存起来，以便以后继续使用，lambda表达式的代码 将不能被内联，因此必须要 有一个包含这些代码的对象存在。
//
//一般来说，参数如果 被直接调用或者作为参数传递 给另外一个inline函数，它是可以被内联的，否则，编译器会 禁止参数被内联 并给出错误信息Illeagal usage of inline-parameter。

//例如，许多作用于序列的函数会返回一些类的实例，这些类代表对应的序列操作并接收lambda作为构造方法的参数，以下是Sequence.map函数的定义：
//fun <T, R> Sequence<T>.map(transform : (T) -> R) : Sequence<R> {
//    return TransformingSequence(this, transform);
//}
//map函数没有直接调用作为transform参数传递进来的函数。而是将这个函数传递给一个类的构造方法，构造方法将它保存在一个属性当中。
//为了支持这一点，作为transform参数传递的lambda需要 被编译成标准的非内联表示法，即一个实现了函数接口的匿名类。
//
//如果一个函数期望两个或更多的lambda函数，可以选择只内联其中一些参数，因为一个lambda可能会包含很多代码或者 以不允许内联的方式调用，
//接收这样的非内联lambda的参数，可以用noinline修饰符来标记它：
//inline fun foo(inlined : () -> Unit, noinline noinlined : () -> Unit) {
//
//}
//注意，编译器完全支持 内联跨模块的函数或者第三方库定义的函数，也可以在 Java 中调用绝大部分内联函数。






































