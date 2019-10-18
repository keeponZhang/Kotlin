package com.keepon.kotlin.chapter3

/**
 * createBy	 keepon
 */
//上面这段被括号围起来的语句块就叫做 主构造方法，它有两个目的：
//表明构造方法的参数。
//定义使用这些参数初始化的属性，也就是nikename。
open class User ( open val nickName:String)
//下面这个会报错
//class User3 public (val nickName:String)

//constructor：用来开始一个主构造方法和从构造方法的声明。
class User2 internal constructor( nickName:String){
    val _nickName:String
//    init：引入一个初始化块语句，这种语句块包含了在类被创建时执行的代码，并会与主构造方法一起使用，因为主构造方法有语法限制，这就是为什么要使用初始化语句块的原因。
    init {
        _nickName = nickName
    }
}

//在上面的例子中有几个可以简化的点：
//
//放在初始化语句块的语句可以和nikename的声明结合，因此可以去掉init语句。
//如果主构造方法没有注解或可见性修饰符，可以取消constructor关键字。
//如果属性用相应的构造方法参数来初始化，代码可以通过把val关键字加在参数前的方式来进行简化。



//而在Kotlin中，可以通过在基类列表的父类引用中提供父类构造方法参数的方式来做到这一点：
//父类val的属性可以覆写,需要用open
class TwiterUser( override var nickName:String):User(nickName){
    init {
        nickName = nickName+"：keepon"
    }
    fun  getName():String{
        return nickName
    }
}
class TwiterUser2 private constructor(nickName:String):User(nickName){
    fun  getName():String{
        return nickName
    }

}

fun main(args: Array<String>) {
    val tUser = TwiterUser("twitterUser")
    println("${tUser.nickName}")
    println(tUser.getName())

//因为构造函数被private修饰，下面会报错
//    val tUser2 = TwiterUser2("twitterUser")
}
