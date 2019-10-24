package com.keepon.kotlin.chapter6

/**
 * createBy	 keepon
 */
//Kotlin有方便的运算符来提供代替null的默认值，它被称作Elvis运算符，我们在2.3的基础上增加红框内的代码，使得name为空的时候将返回值设为Unknow：
class Employee2(val name:String,val manager:Employee2?)
//Elvis接收两个运算数：如果第一个运算数（name）不为null，运算结果就是第一个运算数；如果第一个运算数为null，运算结果就是第二个运算数。
fun managerName(employee: Employee2):String? = employee.manager?.name ?:"unknow"

fun main(args: Array<String>) {

    val ceo = Employee2("DaBoss",null)
    val developer = Employee2("Bob smith",ceo)
    println(managerName(ceo))
    println(managerName(developer))
}



















