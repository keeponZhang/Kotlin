package net.println.kotlin.chapter3

import net.println.kotlin.chapter4.delegates.X

/**
 * Created by benny on 3/9/17.
 */


//kotlin get 和set 实现
class B{
    //kotlin 默认的访问控制是public
    public var b = 0
    get(){
        println("someone try to get b")
        return field
    }
    //可以简写成
    //get() = field
    //protected访问控制
    protected set(value){
        println("someone try to set b")
        field = value
    }
    //可以简写
   // protected set

    var c = 22
        //这里会报错，应为默认是public，这里改成protected,外界访问不到，可以在var前面加protected
//    protected  get

}
class X
class A{
    //基本类型初始化
    var b = 0
    //延迟初始化，只能放在 var前面
    lateinit var c: String
    lateinit var d: X
    //val 延迟初始化 by delegate（lazy）
    val e: X by lazy {
        println("init X")
        X()
    }

    var cc: String? = null
}

fun main(args: Array<String>) {

    println("start")
    val a = A()
    println("init a")
    println(a.b)
    println(a.e)

    a.d = X()
    println(a.d)
    a.c  = "keepon";
    println(a.c)
    // 用到c之前没初始化会报kotlin.UninitializedPropertyAccessException: lateinit property c has not been initialized

    println(a.cc?.length)
}