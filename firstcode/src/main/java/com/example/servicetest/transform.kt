open class Person(val name: String, val age: Int)

class Student(name: String, age: Int) : Person(name, age)

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

fun main(args: Array<String>) {
    val student = Student("Tom", 19)
    val data = SimpleData<Student>(student)
    handleMyData(data)
    val studentData = data.get()

    val trans = object : Transformer<Person> {
        override fun transform(t: Person): String {
            return "${t.name} ${t.age}"
        }
    }
    handleTransformer(trans)

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
    val result = trans.transform(student)
}

fun handleTransformer3(trans3: Transformer3<Student>) {
    var result = trans3.transform("Tom", 19)
}