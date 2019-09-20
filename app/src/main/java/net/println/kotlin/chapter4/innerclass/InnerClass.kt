package net.println.kotlin.chapter4.innerclass

/**
 * Created by benny on 4/4/17.
 */
open class Outter{
    val a: Int = 0
    //默认是public的  inner修饰表示非静态内部类

    inner class Inner{
        val a: Int = 5

        fun hello(){
            println(this@Outter.a)
        }
    }
    //默认是静态内部类
    class Inner2{
        val a: Int = 5
    }

}

interface OnClickListener{
    fun onClick()
}
interface OnClickListener2{
    fun onClick2()
}

class View{
    var onClickListener: OnClickListener? = null
}

fun main(args: Array<String>) {
    val inner = Outter().Inner()

    val inner2 = Outter.Inner2()


    val view = View()
    //匿名内部类 ， object : OnClickListener表示一个对象实现了OnClickListener接口
    //这里表示继承了Outter类，实现了OnClickListener接口的对象
    view.onClickListener = object :Outter(), OnClickListener{
        override fun onClick() {

        }
    }
}