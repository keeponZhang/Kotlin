package net.println.kotlin.chapter3

/**
 * Created by benny on 3/19/17.
 */
private const val USERNAME = "kotlin"
private const val PASSWORD = "jetbrains"

private const val ADMIN_USER = "admin"
private const val ADMIN_PASSWD = "admin"

private const val DEBUG = 1
private const val USER = 0

fun main(args: Array<String>) {
    //分支表达式
    val mode = if(args.isNotEmpty() && args[0] == "1"){
        println("返回值是分支的最后一句表达式")
        DEBUG
    }else{
        USER
    }

    println("请输入用户名：")
    val username = readLine()
    println("请输入密码：")
    val passwd = readLine()

    //分支语句
    if(mode == DEBUG && username == ADMIN_USER && passwd == ADMIN_PASSWD) {
        println("管理员登录成功")
    }else if(username == USERNAME && passwd == PASSWORD){
        println("登录成功")
    }else{
        println("登录失败")
    }
}