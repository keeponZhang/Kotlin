package ch07.ex2_2_1_OrderingOperators

import kotlin.comparisons.compareValuesBy

open class Person(
    val firstName: String, val lastName: String
) : Comparable<Person> {

    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other,
            Person::lastName, Person::firstName)
    }
}

//会继承实现的接口
class Student : Person("22", "33") {

}

//会报错
//class Student2 : Person("22", "33"), Comparable<Student> {
//    override fun compareTo(other: Student): Int {
//        return compareValuesBy(this, other,
//            Person::lastName, Person::firstName)
//    }
//}

fun main(args: Array<String>) {
    val p1 = Person("Alice", "Smith")
    val p2 = Person("Bob", "Johnson")
    val s1 = Student()
    println(p1 < p2)
    println(p1 >= p2)
    println(p1 == p2)
    println(p1 < s1)
    println(s1 < p1)
}
