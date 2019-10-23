package com.keepon.kotlin.chapter5

/**
 * createBy	 keepon
 */

//现在，让我们回到最开始寻找集合中年龄最大的人的例子，它原本的调用方法如下，maxBy函数接收一个lambda表达式{ p : Person -> p.age }作为参数：
//
//people.maxBy({ p : Person -> p.age })
//上面这段代码的解释为：花括号中的代码片段是lambda表达式，把它作为实参传给函数，这个lambda接收一个类型为Person的参数并返回它的年龄。下面，我们一起来看一下如何简化这个表达式：
//
//第一步：Kotlin有一个语法规定，如果lambda表达式是函数调用的 最后一个实参，它可以 放到括号的外边，因此上面的例子简化为：
////第一步：将 lambda 表达式放到括号的外边。
//people.maxBy() { p : Person -> p.age }
//
//第二步：当lambda是函数 唯一的实参，还可以 去掉调用代码中的空括号对
////第二步：去掉空括号对。
//people.maxBy { p : Person -> p.age }
//
//第三步：和局部变量一样，如果lambda参数的类型可以被推倒出来，你就不需要显示地指定它，以maxBy函数为例，
//其 参数类型始终和集合的元素类型相同，因此编译器知道你是对Person对象的集合调用maxBy函数，可以简化为：
//
////第三步：省略 lambda 参数类型。
//people.maxBy { p -> p.age }
//
//
//但是如果我们用变量存储lambda，那么就没有可以推断出参数类型的上下文，所以你必须显示地指定参数类型
//
////无法推断出参数的类型，必须显示地指定参数的类型。
//val getAge = { p : Person : p.age }
//people.maxBy (getAge)
//
//第四步：如果当前上下文期望的是 只有一个参数的 lambda ，并且这个参数的类型可以推断出来，那么可以使用默认参数名称it代替命名参数：
//
////第四步：使用默认参数名称。
//people.maxBy { it.age }

















