package com.keepon.kotlin.chapter3

/**
 * createBy	 keepon
 */

//在Kotlin中，接口可以包含抽象属性的声明：
//但是接口并没有说明这个值应该存储到一个支持字段还是通过getter来获取，接口本身并不包含任何状态，
//因此只有实现这个接口的类在需要的时候会存储这个值。


//下面是三个例子：
fun getFaceBookName(accountId:Int ) = "fb:$accountId"
interface User5{
    val nickName:String

//    接口除了可以声明抽象属性外，还可以包含具有getter和setter的属性，只要它们没有引用一个支持字段（支持字段需要在接口中存储状态，而这是不允许的）：
//    有一个自定义的getter，可以被子类继承。
    val realName:String
    get() = "zhang"+nickName
}

class PrivateUser(override  val nickName:String):User5

class SubscribingUser(val email:String):User5{
    override val nickName:String
    get() = email.substringBefore("@")
}
class FaceBookUser(val accountId:Int):User5{
    override val nickName = getFaceBookName(accountId)
}

//PrivateUser：直接在主构造方法中声明了这个属性，这个属性实现了来自于User的抽象属性，所以要标记为override。
//SubscribingUser：通过一个自定义的getter实现，这个属性没有一个支持字段来存储它的值，它只有一个getter在每次调用时从email中得到昵称。
//FacebookUser：在初始化时，将nickname属性与值关联。

fun main(args: Array<String>) {
    val user = SubscribingUser("test@qq.com")
    println("nickName =${user.nickName},realName = {${user.realName}}")
}









