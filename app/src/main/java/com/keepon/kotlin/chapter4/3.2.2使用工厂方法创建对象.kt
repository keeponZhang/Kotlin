package com.keepon.kotlin.chapter4

/**
 * createBy	 keepon
 */
//下面是使用伴生对象来实现工厂方法的例子：

fun getFaceBookName(accountId:Int)="fb$accountId"
class User private constructor(val  nickName:String){
    companion object{
        val test = "aa"
        fun newSubScribingUser(email:String):User{
            return User(email.substringBefore("@"))
        }
        fun newFaceBookUser(accountId: Int) = User(getFaceBookName(accountId))
    }
}

fun main(args: Array<String>) {
    val subscribingUser = User.newSubScribingUser("bob@gmail.com")
    val facebookUser = User.newFaceBookUser(4)
    println("subscribingUser.nickname = ${subscribingUser.nickName}")
    println("facebookUser.nickname = ${facebookUser.nickName}")
}



































