package ch06.ex2_2_NullablePrimitiveTypes

import com.kotlin.action.bean.JAnimal

//在Person 类中声明的age属性的值被当作java.lang.Integer 存储。但
//是只有在你使用来自Java的类时这些细节才有意义。为了在Kotlin中选出正确的类型，你只需要考虑对变量或者属性来说，null是否是它们可能的值。
data class Person(
    val name: String,
    val age: Int? = null
) {

    fun isOlderThan(other: Person): Boolean? {
        //不能直接这样比，会报错，因为其中一个都有可能为空
//        age > other.age
        if (age == null || other.age == null)
            return null
        return age > other.age
    }
}

fun main(args: Array<String>) {
    var jAnimal: JAnimal? = JAnimal("pig")
    jAnimal = null
    val testi: Int = 10
    //像这种可空类型会编译成Integer,上面不可空的会编译成int（因为两者都是不可空）
    //Kotlin 中的可空类型不能用Java 的基本数据类型表示，因为null 只能被存储在Java 的引用类型的变量中
//    这意味着任何时候只要使用了基本数据类型的可空版本，它就会编译成对应的包装类型。
    var test2: Int? = 10
    println("" + testi + "  " + test2)
    println(Person("Sam", 35).isOlderThan(Person("Amy", 42)))
    println(Person("Sam", 35).isOlderThan(Person("Jane")))

//    如果你用基本数据类型作为泛型类的类型参数，那么Kotlin 会使用该类型的包装形式。例如，下面这段代码
//    创建了一个Integer 包装类的列表 ， 尽管你从来没有指定过可空类型或者用过 null 值 ：
    //下面会用Integer包装
    val listOfInts = listOf(1, 2, 3)
//    这是由Java 虚拟机实现泛型的方式决定的。JVM 不支持用基本数据类型作为
//    类型参数，所以泛型类(Java和kotlin一样〉必须始终使用类型的包装表示。因此，
//    假如你要高效地存储基本数据类型元素的大型集合，要么使用支持这种集合的第三方库,要么使用数组来存储
}
