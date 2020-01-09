package ch05.ex2_1_4_FilterMap3

data class Person(val name: String, val age: Int)

fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    //调用map 返回的其实是一个集合
    println(people.map { it.name })
    println(people.filter { it.age > 30 }.map(Person::name))
    println(people.filter { it.age == people.maxBy(Person::age)?.age })
}
