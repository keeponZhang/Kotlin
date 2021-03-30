package com.keepon.kotlin.chapter6

/**
 * createBy	 keepon
 */

//安全转换运算符会尝试把值转换成指定的类型，如果类型不合适就返回null，下面的例子中，先判断传入的参数是否是Person类型，
//如果不是，那么就直接返回false，而在之后的代码中智能转换就会生效，编译器确定了变量otherPerson值的类型是Person，
//我们就可以直接访问它的name属性。

data class Person(val name:String)

fun  Person.comparePerson(other:Any ?):Boolean {
    //as?转换不成成功就返回null
    val otherPerson = other as? Person ?: return false
    return name == other.name
}


fun  Person.comparePerson2(other:Person ?):Boolean {
    // other.name 会报错
//    other.name
    other.toString()
    return false
}

fun main(args: Array<String>) {
    val str = "string"

    val p1 = Person("Keepon")
    val p2 = Person("Keepon")
    println("comparePerson="+p1.comparePerson(p2))
    println("comparePerson="+p1.comparePerson(str))
    println("comparePerson2="+p1.comparePerson2(null))
}














