package com.keepon.kotlin.chapter9

/**
 * createBy	 keepon
 */
//惰性初始化是一种常见的模式，直到 在第一次访问该属性 的时候，才根据需要创建对象的一部分。


//2.2.1 使用支持属性来实现惰性初始化
//使用这种技术来实现惰性初始化时，需要两个值，一个是对内部可见的可空_emails变量，另一个是提供对属性的读取访问的email变量，它是非空的，
//在email的get()函数中首先判断_emails变量是否为空，如果为空那么就先初始化它，否则直接返回。

class Person(val name : String) {
    val emails by lazy { loadEmails(this) }


}

//这里可以使用标准库函数lazy返回的委托，lazy函数返回一个对象，该对象具有一个名为getValue且签名正确的方法，
//因此可以把它与by关键字一起使用来创建一个委托属性。lazy的参数是一个lambda，可以调用它来初始化这个值，默认情况下，lazy函数是线程安全的。

private fun loadEmails(person: Person): Any {
    return ""
}





















