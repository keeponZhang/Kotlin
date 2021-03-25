open class Person(val name: String, val age: Int)

open class Student(name: String, age: Int) : Person(name, age)
open class SmallStudent(name: String, age: Int = 1) : Student(name, age) {
    var nickName: String? = null
}

class Teacher(name: String, age: Int) : Person(name, age)

class SimpleData<out T>(val data: T?) {

    fun get(): T? {
        return data
    }
}

//逆变，意味着T只能出现在in位置，而不能出现在out位置
interface Transformer<in T> {
    fun transform(t: T): String
}

interface Transformer2<T> {
    fun transform(t: T): String
}

interface Transformer3<in T> {
    fun transform(name: String, age: Int): @UnsafeVariance T
}

interface Transformer4<out T> {
    fun transform(t: String): T
}

fun main(args: Array<String>) {
    val student = Student("Tom", 19)
    val smallStudent = SmallStudent("Tom", 19)
    val data = SimpleData<Student>(student)
    handleMyData(data)
    val studentData = data.get()

    val trans = object : Transformer<Person> {
        override fun transform(t: Person): String {
            return "${t.name} ${t.age}"
        }
    }

    handleTransformer(trans)


    val trans4 = object : Transformer4<SmallStudent> {
        override fun transform(t: String): SmallStudent {
            return SmallStudent("")
        }
    }
    handleTransformer4(trans4)


    val trans2 = object : Transformer2<Person> {
        override fun transform(t: Person): String {
            return "${t.name} ${t.age}"
        }
    }
//  这里会报错  Transformer<Person>并不是Transformer<Student>的子类
//    handleTransformer(trans2)


    val trans3 = object : Transformer3<Person> {
        override fun transform(name: String, age: Int): Person {
            return Teacher(name, age)
        }
    }
//    Exception in thread "main" java.lang.ClassCastException: Teacher cannot be cast to Student
//    at TransformKt.handleTransformer3(transform.kt:67)
//    at TransformKt.main(transform.kt:54)
    handleTransformer3(trans3)
}

fun handleMyData(data: SimpleData<Person>) {
    val personData = data.get()
}

fun handleTransformer(trans: Transformer<Student>) {
    val student = Student("Tom", 19)
    //trans真正是 Transformer<Person>，还是多态
    val result = trans.transform(student)
}

fun handleTransformer3(trans3: Transformer3<Student>) {
    var result = trans3.transform("Tom", 19)
}

fun handleTransformer4(trans4: Transformer4<Student>) {
    val student = Student("Tom", 19)
    var result = trans4.transform("student")
}