package com.kotlin.action.kotlinbean.KStudent.kt

/**
 *createBy keepon
 */
class Student(age: Int, name: String) {
    private var age: Int
    private var name: String
    fun getAge(): Int {
        return age
    }

    fun setAge(age: Int) {
        this.age = age
    }

    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    init {
        this.age = age
        this.name = name
    }
}
