package ch04.ex4_2_2_CompanionObjects3

import com.kotlin.action.bean.javacall.JavaStatic

interface JSONFactory<T> {
    fun fromJSON6(jsonText: String): T
    fun fromJSONNoChange(jsonText: String): String
}

//fun loadFromJSON<T> (factory: JSONFactory<T>: T) {
//}

class Person6(val name: String) {
    //这个注解只可以用在伴生对象
//    @JvmStatic
//    fun test() {
//        println("test")
//    }
    val age: Int = 22;

    @JvmField
    val age2: Int = 33;

    companion object : JSONFactory<Person6> {
// @JvmField和 @JvmStatic要在伴生对象利用才有效果
        @JvmField
        val age3: Int = 44;

        @JvmStatic
        override fun fromJSON6(jsonText: String): Person6 {
            return Person6(jsonText)
        }

        //被这个注解修饰，会生成静态方法
        @JvmStatic
        fun fromJSON6_2(jsonText: String): Person6 {
            return Person6(jsonText)
        }

        override fun fromJSONNoChange(jsonText: String): String {
            TODO("Not yet implemented")
        }
    }
//    伴生对象只能有一个
//    companion object keepon : JSONFactory<Person6> {
//        override fun fromJSON6(jsonText: String): Person6 {
//            return Person6(jsonText)
//        }
//    }
}

fun main(args: Array<String>) {

    //可以用两种方式调用fromJson
    Person6.fromJSON6("keepon6")
    //kotlin可以直接调用java的静态方法
    JavaStatic.javaStaticMethod()
}

