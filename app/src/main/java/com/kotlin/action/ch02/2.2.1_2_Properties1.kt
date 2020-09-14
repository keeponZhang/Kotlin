package ch02.person

//从Java到Kotlin的转换过程中public修饰符消失了。在Kotlin中，
//public是默认的可见性，所以你能省略它。
class Person(
    val name: String,
    var isMarried: Boolean
)

fun main(args: Array<String>) {
//    调用构造方法不需要关键字new
    val person = Person("Bob", true)
//    person.name = "keepon"
    println(person.name)
    println(person.isMarried)
}

//可以直接引用属性，不再需要调用getter逻辑没有变化，但代码更简洁了。
//可变属性的setter也是这样：在Java 中，使用person.setMarried(false)
//来表示离婚，而在Kotlin中，可以这样写person.isMarried =false。
