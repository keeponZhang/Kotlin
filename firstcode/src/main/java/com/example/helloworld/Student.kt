package com.example.helloworld

class Student(val sno: String = "", val grade: Int = 0, name: String = "", age: Int = 0) : Person(name, age), Study {
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

fun main() {
    val     student2 = Student2()
}