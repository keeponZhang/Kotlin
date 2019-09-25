package com.keepon.kotlin.chapter2

/**
 * createBy	 keepon
 */

class User(val id:Int,val name:String,val address:String)

//在Java的一个函数当中，有可能存在重复代码，例如在注册模块中，
//可能需要校验输入的多个字段是否有效，那么校验的逻辑就可以提取出一个函数，而Kotlin就提供了一种方法：可以在函数中嵌套这些提取的函数，局部函数定义方式和普通函数是相同的。
fun saveUser(user:User){
    fun validate(value: String,fieldName:String){
        if(value.isEmpty()){
            throw IllegalArgumentException(
                    "Can't save user ${user.id} :"+"empty $fieldName")
        }
    }
    validate(user.name,"Name")
    validate(user.address,"Address")
    println("saveUser 成功 $user")
}

fun main(args: Array<String>) {
    saveUser(User(1,"keepon","Gz"))
    saveUser(User(1,"",""))
}