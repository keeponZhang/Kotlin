package ch01.ex1_ATasteOfKotlin

data class Person(
    val name: String,
    val age: Int? = null
)

fun main(args: Array<String>) {
    val persons = listOf(Person("Alice"),
        Person("Bob", age = 29))
    val persons2 = listOf<Person>()
    val oldest = persons.maxBy { it.age ?: 0 }  //如果age属性为null, Elvis运算符（？：）会返回零
    val oldest2 = persons2.maxBy { it.age ?: 0 }  //oldest2 is null数组是空的话，返回为空
    println("The oldest is: $oldest oldest2 is $oldest2")
}

// The oldest is: Person(name=Bob, age=29)
