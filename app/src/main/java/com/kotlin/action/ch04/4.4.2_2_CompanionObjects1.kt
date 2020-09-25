package ch04.ex4_2_2_CompanionObjects1

fun getFacebookName(accountId: Int) = "fb:$accountId"

//伴生对象可以访问类中的所有private成员，包括private 构造方法，它是实现工厂模式的理想选择。
//(本质其实是多生成了一个public类型的构造方法)
class User private constructor(val nickname: String) {
    private val age = 50

    companion object {

        fun newSubscribingUser(email: String) =
            User(email.substringBefore('@'))

        //伴生对象可以访问类中的所有private成员
        fun newSubscribingUser2(): Int {
            return User("keepon").age
        }

        fun newFacebookUser(accountId: Int) =   //用工厂方法通过Facebook账号创建一个新用户
            User(getFacebookName(accountId))
    }
}

fun main(args: Array<String>) {
//    伴生对象其实会生成一个静态成员对象
    val subscribingUser = User.newSubscribingUser("bob@gmail.com")
    User.newSubscribingUser2()
    val facebookUser = User.newFacebookUser(4)
    println(subscribingUser.nickname)
}
