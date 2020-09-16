package ch04.ex2_3_1_ImplementingPropertiesDeclaredInInterfaces

fun getFacebookName(accountId: Int) = "fb:$accountId"

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
class PrivateUser2 : PrivateUser("")

//如果没有给一个类声明任何的构造方法，将会生成一个不做任何事情的默认构造方法,这个跟java是一致的
open class PrivateUser3
class SubscribingUser(val email: String) : User {
    override val nickname: String
        get() = email.substringBefore('@')
}

class FacebookUser(val accountId: Int) : User {
    override val nickname = getFacebookName(accountId)
}

fun main(args: Array<String>) {
    println(PrivateUser("test@kotlinlang.org").nickname)
    println(SubscribingUser("test@kotlinlang.org").nickname)
}
