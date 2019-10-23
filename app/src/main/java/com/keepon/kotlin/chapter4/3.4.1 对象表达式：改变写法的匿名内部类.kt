package com.keepon.kotlin.chapter4

/**
 * createBy	 keepon
 */
//object关键字不仅能够用来表明单例式的对象，还能用来声明 匿名对象，它替代了Java中匿名内部类的用法。
//例如，让我们来看看怎样将一个典型的匿名内部类用法转换成Kotlin：

interface OnClickListener{
    fun onClick()
}

class Button{
    var listener:OnClickListener?=null
    fun setOnClickListener(listener: OnClickListener){
        this.listener = listener;
    }

    fun click(){
        listener?.onClick()
    }
}

fun main(args: Array<String>) {
    val button  = Button()
    button.setOnClickListener(
            object :OnClickListener{
                override fun onClick() {
                    println("Button is clicked")
                }
            }
    )
    button.click()

    //将匿名对象存储到变量中
    val button2  = Button()
    val listener2 = object :OnClickListener{
        override fun onClick() {
            println("Button2 is Clicked")
        }

    }
    button2.setOnClickListener(listener2)
    button2.click()

//    将匿名对象存储到变量中



//    在对象表达式中修改变量的值
//    与Java的匿名类一样，在对象表达式中的代码可以访问创建它的函数中的变量，但是与Java不同，访问并被限制在final变量，还可以在对象表达式中修改变量的值。

    //这里不需要被命名为final
    var  clickCount = 0;
    val button3  = Button()
    val listener3 = object :OnClickListener{
        override fun onClick() {
            clickCount++
            println("Button3 is Clicked count ${clickCount}")
        }

    }
    button3.setOnClickListener(listener3)
    button3.click()
}



























