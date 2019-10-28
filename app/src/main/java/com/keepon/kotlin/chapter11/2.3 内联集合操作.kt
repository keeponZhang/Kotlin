package com.keepon.kotlin.chapter11

import com.keepon.kotlin.chapter8.Person

/**
 * createBy	 keepon
 */
//大部分标准库中的集合函数都带有lambda参数。例如filter，它被声明为内联函数，
//这意味着filter函数，以及传递给它的lambda字节码会被内联到filter被调用的地方，因此我们不用担心性能问题

//假如我们像下面这样，连续调用filter和map两个操作：
fun test(){
    val p1 = Person("alice",22)
    val p2 = Person("keeon",14)
    val peoplelist = listOf(p1,p2)
    println(peoplelist.filter{ it.age > 30 }.map(Person :: name))
}

//这个例子使用了一个lambda表达式和一个成员引用，filter和map函数都被声明为inline函数，所以不会额外产生类或者对象，但是上面的代码会创建一个中间集合来保存列表过滤的结果。






































