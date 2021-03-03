package com.keepon.kotlin.chapter2

/**
 * createBy	 keepon
 */
//在Java中，所有的代码都需要写作类的函数，但是在项目中，很多代码并不能归属到类中，这时候我们一般会定义一个xxUtils类，并在其中声明static的静态方法。
//
//在kotlin中，我们可以把这些函数直接放到代码文件的顶层，不用从属于任何的类，这些放在文件顶层的函数仍然是包内的成员，如果你需要从包外访问它，则需要import，但不再需要额外包一层。

fun kotlinFunc(){
    println("这是顶层函数")
}
//public static final void kotlinFunc 顶层函数生成静态final函数
//修改被调用的方法名
@JvmName("DINGCENGFUN")
fun kotlinFunc2(){
    println("这是顶层函数2")
}
fun main(args: Array<String>) {
    kotlinFunc2()
}