package com.example.helloworld

class Student(val sno: String = "", val grade: Int = 0, name: String = "", age: Int = 0) :
    Person(name, age), Study {
    override fun readBooks() {
        println(name + " is reading.")
    }
}

//相当于有无参构造函数，调用了父构造函数
class Student2 :
    Person("11", 12), Study {
    override fun readBooks() {
        println(name + " is reading.")
    }
}

//只有次构造函数，没有主构造函数，Person后面也不用调用Person的构造函数
class Student3 : Person {
    constructor(name: String, age: Int) : super(name, age) {
    }
}
//
class Student4 : Person2() {

}

fun main() {
    val student2 = Student2()
}