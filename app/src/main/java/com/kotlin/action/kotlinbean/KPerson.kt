package com.kotlin.action.kotlinbean.KPerson.kt

/**
 *createBy keepon
 */

class Person(name: String) {
    fun getName(): String {
        return name
    }

    private val name: String

    init {
        this.name = name
    }
}

