package ch05.ex2_3_1_GroupBy

data class Person(val name: String, val age: Int)

fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 30),
            Person("Bob", 29), Person("Carol", 31))
    //返回HashMap(key,List)
    println(
        people.groupBy
        { it.name })
}
