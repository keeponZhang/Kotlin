package ch06.ex1_11_1_2_PlatformTypes1

import com.kotlin.action.ch06.Person

fun yellAtSafe(person: Person) {
    //String！ 表示法被Kotlin 编译器用来表示来自Java代码的平台类型。你不能在自己的代码中使用这种语法。
//   IllegalStateException: person.name must not be null
//    val i: String? = person.name
    println((person.name ?: "Anyone").toUpperCase() + "!!!")
    //kotlin编译器不知道getName 能不能返回null，所以你必须自己处理它
    println(person.name.toUpperCase())
}

fun main(args: Array<String>) {
    // 编译不会报错，但是运行会报java.lang.IllegalStateException: person.name must not be null
    yellAtSafe(Person(null))
//    传空会报错
//    yellAtSafe(null)
}
