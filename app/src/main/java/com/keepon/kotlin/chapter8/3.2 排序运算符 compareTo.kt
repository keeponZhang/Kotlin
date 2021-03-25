package com.keepon.kotlin.chapter8

/**
 * createBy	 keepon
 */

//在Kotlin中，对于实现了Comparable接口中定义的compareTo方法的类可以按约定调用，
//比较运算符<、>、<=、>=的使用将被转换为compareTo，compareTo的返回类型必须为int，
//也就是说p1 < p2表达式等价于p1.compareTo(p2) < 0。

//下面，我们定义一个Person类，让其根据年龄来比较大小：

class Person(val name: String, val age: Int) : Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other, Person::age)
    }
}

fun main(args: Array<String>) {
    val p1 = Person("alice", 22)
    val p2 = Person("keeon", 14)
    println(p1 > p2)
}

//在上面的例子中，我们用到了Kotlin标准库函数中的compareValuesBy函数来简洁地实现compareTo方法，这个函数 接收用来计算比较值的一系列回调，按顺序依次调用回调方法，两两一组分别做比较：
//如果值不同，则返回比较结果
//如果相同，则继续调用下一个
//如果没有更多的回调来调用，则返回0
//这些回调函数可以像lambda一样传递，或者像这里做的一样，作为属性引用传递。


