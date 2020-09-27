package ch04.ex2_1_InitializingClasses


//这段被括号围起来的语句块就叫作主构造方法
class User(
    val nickname: String = "keepon",  //如果属性用相应的构造方法参数来初始化
    val isSubscribed: Boolean = true
)

//如果主构造方法没有注解或可见性修饰符，同样可以去掉constructor 关键字。
class User2 constructor(
    _nickname: String,   //构造方法参数
    val isSubscribed: Boolean = true
) {
    //属性
    val nickname: String

    init {
        nickname = _nickname
    }
}

fun main(args: Array<String>) {
//    val keepon =
//        User((null as String?)!!, false, 3,
//            null as DefaultConstructorMarker?)
    val keepon = User()
    println("${keepon.nickname}")
//    val keepon2 = User2()
//    println("${keepon2.nickname}")
//    val alice =
//        User("Alice", false, 2, null as DefaultConstructorMarker?)
    val alice = User("Alice")
    println(alice.isSubscribed)
    val bob = User("Bob", false)
    println(bob.isSubscribed)
    val carol = User("Carol", isSubscribed = false)
    println(carol.isSubscribed)
}
