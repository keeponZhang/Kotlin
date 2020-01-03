package ch04.ex4_2_2_CompanionObjects2

import com.kotlin.action.bean.javacall.JavaStatic

class Person(val name: String) {
    companion object Loader {
        fun fromJson(jsonText: String): Person {
            return Person(jsonText)
        }
    }
}

class Person3(val name: String) {
    companion object {

    }
}

//相当于拓展静态方法
fun Person3.Companion.fromJSON3(json: String): Person3 {

    return Person3(json)
}

interface JSONFactory<T> {
    fun fromJSON2(jsonText: String): T
}

//fun loadFromJSON<T> (factory: JSONFactory<T>: T) {
//}

class Person2(val name: String) {
    //这个注解只可以用在伴生对象
//    @JvmStatic
//    fun test() {
//        println("test")
//    }

    companion object : JSONFactory<Person2> {
        @JvmStatic
        override fun fromJSON2(jsonText: String): Person2 {
            return Person2(jsonText)
        }

        //被这个注解修饰，会生成静态方法
        @JvmStatic
        fun fromJSON3(jsonText: String): Person2 {
            return Person2(jsonText)
        }
    }
    //伴生对象只能有一个
//    companion object keepon : JSONFactory<Person2> {
//        override fun fromJSON2(jsonText: String): Person2 {
//            return Person2(jsonText)
//        }
//    }
}

fun main(args: Array<String>) {
    //有伴生对象，类名就是伴生对象
    println(Person == Person.Loader)
    println(Person)
    //可以用两种方式调用fromJson
    Person.Loader.fromJson("keeon")
    Person.fromJson("keeon")
    Person2.fromJSON2("keepon2")
    //kotlin可以直接调用java的静态方法
    JavaStatic.javaStaticMethod()

    Person3.fromJSON3("keepon")
}

