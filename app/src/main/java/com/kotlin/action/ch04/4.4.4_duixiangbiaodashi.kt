package ch04.ex4_2_2_CompanionObjects2.duixiangbiaodash

import com.kotlin.action.bean.javacall.JavaStatic
import java.awt.event.MouseEvent

interface MouseAdapter {
    fun mouseClicked(e: MouseEvent)
    fun mouseEnter(e: MouseEvent)
}

interface JianAdapter {
    fun dazi()
}

fun main(args: Array<String>) {
    //object是创建一个类并且创建一个对象，但是与与对象声明不同，匿名对象不是单例的。每次对象表达式被执行都会
    //创建一个新的对象实例。
    //kotlin匿名内部类访问局部变量，没有被限定为final
    var count = 10;
    val listener = object : MouseAdapter, JianAdapter {
        override fun mouseClicked(e: MouseEvent) {
            count++
            TODO(
                "not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun mouseEnter(e: MouseEvent) {
            TODO(
                "not implemented") //To change body of created functions use File | Settings | File Templates.
        }


//        与Java 匿名内部类只能扩展一个类或实现一个接口不同， Kotlin 的匿名对象可
//        以实现多个接口或者不实现接口。
        override fun dazi() {
            TODO(
                "not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}