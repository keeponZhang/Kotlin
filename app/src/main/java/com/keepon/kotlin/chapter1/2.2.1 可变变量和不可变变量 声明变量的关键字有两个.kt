package com.keepon.kotlin.chapter1

/**
 * createBy	 keepon
 */
//(1) 不可变引用 val
//使用val声明的变量不能在初始化之后再次赋值，它对应的是Java的final变量。
//默认情况下，应该尽可能地使用val关键字来声明所有的Kotlin变量。在定义了val变量的代码块执行期间，val变量只能进行唯一一次初始化，但是，如果编译器能确保唯一一条初始化语句会被执行，可以根据条件使用不同的值来初始化它。

fun valFun3(){
    val result :String
    result = if(isSuccessFul())"successFul" else "failed"
    println("result=$result")
}

fun isSuccessFul(): Boolean {
    return true;
}


//2) 可变引用 var
//这种变量的值可以改变，但是它的类型却是改变不了的。
//如果需要在变量中存储不匹配类型的值，必须手动把值转换或强制转换到正确的类型。
fun valFun4(){
    var result :String
    result = "keepon"
    //下面会报错
//    result = 3
}
fun main(args: Array<String>) {
    val list = valFun3()
}











