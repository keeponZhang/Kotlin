package net.println.kotlin.chapter4

/**
 * Created by benny on 4/3/17.
 */
//open val age age也可以被覆写
abstract class Person(open val age: Int){
    abstract fun work()
}
abstract class Person2(open val age: Int,open val name: String){
    abstract fun work()
}

class MaNong(age: Int): Person(age){
    //自定义的访问器：用val开头作为声明，紧跟着的是属性的名称和类型，接下来是get()关键字，最后是一个函数体
    override val age: Int
        get() = 21
    //与上面的写法相等
//        get() {
//        return 21 ;
//    }

    //覆写方法，override必须有
    override fun work() {
        println("我是码农，我在写代码")
    }
}

class Doctor(age: Int): Person(age){
    override fun work() {
        println("我是医生，我在给病人看病")
    }
    var name = "doctor"
}

class Doctor2(age: Int, name:String ): Person2(age,name){
    override fun work() {
        println("我是医生2，我在给病人看病")
    }
    //override的要父类存在的
   override val age :Int
   get()=33

    override val name :String
        get()="doctor2"
}

class Doctor3(age: Int, var name:String ): Person(age){
    override fun work() {
        println("我是医生3，我在给病人看病")
    }
    //override的要父类存在的
    override val age :Int
        get()=33


}

fun main(args: Array<String>) {
    val person: Person = MaNong(23)
    person.work()
    println(person.age)

    val person2 : Person = Doctor(24)
    person2.work()
    println(person2.age)
    if(person2 is Doctor){
        println( person2.name)
    }
    val person3 : Person = Doctor3(24,"keepon")
    person3.work()
    println(person3.age)

    if(person3 is Doctor3){
        println("person3.name ${person3.name}" )
    }

}