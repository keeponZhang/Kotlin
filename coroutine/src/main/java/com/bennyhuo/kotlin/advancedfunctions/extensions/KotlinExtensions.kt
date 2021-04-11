package com.bennyhuo.kotlin.advancedfunctions.extensions

import java.io.File

class Person(var name: String, var age: Int)

fun main() {
    val person = Person("benny", 20)

    //一个带有revevier，一个是传进去的
    person.let {

    }
    person.let(::println)
    person.run(::println)

    val person2 = person.also {
        it.name = "hhh"
    }

    val person3 = person.apply {
        name = "xxx"
    }

    //use是帮你做了异常处理

    File("build.gradle").inputStream().reader().buffered()
            .use {
                println(it.readLines())
            }
    File("build.gradle").inputStream().reader().buffered()
            .let {
                println(it.readLines())
            }
}