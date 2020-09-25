package ch04.ex4_2_2_CompanionObjects2_2

import com.kotlin.action.bean.javacall.JavaStatic



class Person3 private constructor(val name: String) {
    companion object {
    }
}

class Person4(val name: String) {
    companion object {

    }
}

//相当于拓展静态方法,但是是不能访问私有构造方法的
//fun Person3.Companion.fromJSON3(json: String): Person3 {
//   return Person3(json)
//}

fun Person4.Companion.fromJSON4(json: String): Person4 {
    return Person4(json)
}

fun Person4.fromJSON5(json: String): Person4 {
    return Person4(json)
}
fun main(args: Array<String>) {

    //kotlin可以直接调用java的静态方法
    JavaStatic.javaStaticMethod()

//    Person3.fromJSON3("keepon")
//    这个只需要Person4.Companion调用
    Person4.fromJSON4("keepon")
    Person4.Companion.fromJSON4("keepon")
//    这个需要Person4对象调用
//    Person4.fromJSON5("keepon")
}

