package ch04.ex4_2_2_CompanionObjects2

import com.kotlin.action.bean.javacall.JavaStatic

class Person private constructor(val name: String) {
    companion object Loader {
        fun fromJson(jsonText: String): Person {
            return Person(jsonText)
        }
    }
}

fun main(args: Array<String>) {
    //有伴生对象，类名就是伴生对象
//    其实就是创建静态内部类对象，然后这里是生成后变成了一个静态属性，所以可以直接调用
    println(Person == Person.Loader)
    println(Person)
    //可以用两种方式调用fromJson
    Person.Loader.fromJson("keeon")
    Person.fromJson("keeon")
    //kotlin可以直接调用java的静态方法
    JavaStatic.javaStaticMethod()
}

