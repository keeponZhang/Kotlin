package net.println.kotlin.chapter4

/**
 * Created by benny on 3/26/17.
 */
abstract class A{
    var i = 0
     fun defaultA(){
        println("hello $i")
    }
    open  fun defaultAOpen(){
        println("defaultAOpen $i")
    }
    abstract  fun noDefaultA()
}

interface B{
    //可以定义不可以初始化
    var j: Int
    //没有状态
    //相当于默认实现
    fun defaultB(){
        println("defaultB  ")
    }
    fun noDefaultB()
}

class C(override var j: Int) : B{
    override fun noDefaultB() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

//跟java一样，多实现，单继承
class  D : A(){
    override fun noDefaultA() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    //这里提示不能覆写
//    override fun defaultA() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
    override fun defaultAOpen() {
        println("在D中覆写A的defaultAOpen方法")
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}