package ch05.ex1_2_LambdasAndCollections

data class Person(private val name: String, val age: Int)

fun findTheOldest(people: List<Person>) {
    var maxAge = 0
    var theOldest: Person? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}

fun findTheOldest2(people: List<Person>) {
    people.maxBy({ person -> person.age })
    println(people)
}

fun findTheOldest3(people: List<Person>) {
    val getAge = { p: Person -> p.age }
    val p = Person("keeopon", 100)
    val dmitrysAgeFunction = p::age
    println("findTheOldest3 ${getAge}")
//   在Kotlin1.0中，当接收一个类的方法或属性引用时，你始终需要提供一个该类的实例来调用这个引用。
    println("findTheOldest3 ${getAge(p)}")
    println("findTheOldest3 dmitrysAgeFunction ${dmitrysAgeFunction}")
    //在Kotlin1.1中可以使用绑定成员引用
    //下面这个才是正确调用方法，因为引用的是函数，因为相当于匿名函数
    println("findTheOldest3 dmitrysAgeFunction ${dmitrysAgeFunction()}")
    //下面这个不用传实例，会默认传
    people.maxBy(getAge)
    println(people)
}

fun Person.isAdult() = age >= 21
//可以一样引用拓展函数
val predicate = Person::isAdult

fun findTheOldest4(people: List<Person>) {
    //成员引用
    people.maxBy(Person::age)
    println(people)
}

fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    findTheOldest(people)
    findTheOldest2(people)
    findTheOldest3(people)
    findTheOldest4(people)
}
