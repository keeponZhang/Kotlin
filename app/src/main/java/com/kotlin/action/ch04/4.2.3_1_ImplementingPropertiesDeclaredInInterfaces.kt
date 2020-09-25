package ch04.ex2_3_1_ImplementingPropertiesDeclaredInInterfaces

fun getFacebookName(accountId: Int) = "fb:$accountId"

//在Kotlin中，接口可以包含抽象属性声明。这里有一个具有这样声明的接口定义的例子：
interface User {
    val nickname: String
}
//private需要在constructor前面
//open class PrivateUser0 constructor private (
//override val nickname: String) : User

open class PrivateUser private constructor(
    override val nickname: String
) : User


//如果继承了Button 类并且没有提供任何的构造方法，必须显式地调用父类的
//构造方法，即使它没有任何的参数：
//class PrivateUser2 : PrivateUser("")

//如果没有给一个类声明任何的构造方法，将会生成一个不做任何事情的默认构造方法,这个跟java是一致的
open class PrivateUser3
open class PrivateUser4(
    override val nickname: String
) : User

class SubscribingUser(val email: String) : User {
    //    对于SubscribingUser来说，nickname属性通过一个自定义getter实
//    现。这个属性没有一个支持字段来存储它的值，它只有一个getter在每次调用时
//    从email中得到昵称。
    override val nickname: String
        get() = email.substringBefore('@')
}

//这意味着实现User接口的类需要提供一个取得nickname值的方法
//主构造方法定义属性
class SubscribingUser2(override val nickname: String) : User {

}

class FacebookUser(val accountId: Int) : User {
    //属性初始化
    //field就是支持字段
    override val nickname = getFacebookName(accountId)
    var nickname2: String = ""
        //    在setter中，既能读取它也能修改它
//     加了private,外部就不能调用setf方法
        private set(value: String) {
            field = value
        }
        // 在getter中，只能读取
        get() {
            return field
        }
}

fun main(args: Array<String>) {
//    PrivateUser是私有的，所以会报错
//    println(PrivateUser("test@kotlinlang.org").nickname)
    val facebookUser = FacebookUser(4)
//    facebookUser.nickname2=4
    val privateUser4 = PrivateUser4("keepon")
    privateUser4.toString()
    privateUser4.nickname
    println(SubscribingUser("test@kotlinlang.org").nickname)
}
