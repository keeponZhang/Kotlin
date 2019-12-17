package ch01.ex1_ATasteOfKotlin

data class Person(
    val name: String,
    val age: Int? = null
)

fun main(args: Array<String>) {
    val persons = listOf(Person("Alice"),
        Person("Bob", age = 29))

    val oldest = persons.maxBy { it.age ?: 0 }  //如果age 属性为null, Elvis 运算符（？ ： ）会返回零
    println("The oldest is: $oldest")
}

// The oldest is: Person(name=Bob, age=29)
