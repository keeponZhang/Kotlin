package ch02.person

//从Java 到Kotlin 的转换过程中public 修饰符消失了。在Kotlin 中，
//public 是默认的可见性，所以你能省略它。
class Person(
    val name: String,
    var isMarried: Boolean
)

fun main(args: Array<String>) {
    val person = Person("Bob", true)
//    person.name = "keepon"
    println(person.name)
    println(person.isMarried)
}

//可以直接引用属性，不再需要调用ge tter o 逻辑没有变化，但代码更简洁了。
//可变属性的se忧er 也是这样：在Java 中，使用person.setMarried(false)
//来表示离婚，而在Kotlin 中，可以这样写person .isMarried = false 。
