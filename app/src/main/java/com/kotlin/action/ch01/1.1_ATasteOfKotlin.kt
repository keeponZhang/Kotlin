package ch01.ex1_ATasteOfKotlin

//val 不能省略
data class Person(
        val name: String = "boy",
        val age: Int? = null
)

data class Person2(
        val name: String,
        val age: Int? = 18,
        val avatar: String? = null
)

fun main(args: Array<String>) {
    //1,2,4
    //new Person("Alice", (Integer)null, 2, (DefaultConstructorMarker)null); 2表示第二位
    Person("Alice")
    //3表示1和2都是空的
    //      new Person((String)null, (Integer)null, 3, (DefaultConstructorMarker)null);
    //不会马上填默认值，值会用null代替先
    Person()
    Person("keepon", 12)
    Person2("keepon", 12)
    Person2("keepon")
    Person2("keepon", avatar = "")
    val persons = listOf(Person("Alice"),
            Person("Bob", age = 29))
    val persons2 = listOf<Person>()
    val oldest = persons.maxBy { it.age ?: 0 }  //如果age属性为null, Elvis运算符（？：）会返回零
    val oldest2 = persons2.maxBy { it.age ?: 0 }  //oldest2 is null数组是空的话，返回为空
    println("The oldest is: $oldest oldest2 is $oldest2")
}

// The oldest is: Person(name=Bob, age=29)
