package com.kotlin.action.ch04.book.内部类和嵌套类

/**
 *createBy keepon
 */

//类A 在另一个类B 中声明           在Java 中              在Kotlin 中
//嵌套类（不存储外部类的引用）    static class A           class A
//内部类（存储外部类的引用）       class A               inner class A


//在Kotlin 中引用外部类实例的语法也与Java 不同。需要使用this@Outer 从
//Inner 类去访问Outer 类：

class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}
