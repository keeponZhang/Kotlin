package com.keepon.kotlin.chapter5

/**
 * createBy	 keepon
 */
//我们还可以以同样的方式引用扩展函数，这里我们定义一个扩展函数isAdult方法，选出年龄大于21的人。

fun  Person.isAdult()  = age>=21
fun  Person2.isAdult()  = age>=21

fun main(args: Array<String>) {
    val personlist = listOf<Person>(Person("alice",12), Person("keeon",22))
    val  predicate = Person::isAdult
    val  predicate2 = Person2::isAdult
    //闭包要是输入为person 输出为 boolean predicate,成员引用也要符合
    println(personlist.filter(predicate))
    //下面这个不符合，会报错
//    println(personlist.filter(predicate2))
    println(personlist.filter{person -> person.age>=12 })
}









