package com.keepon.kotlin.chapter1

/**
 * createBy	 keepon
 */
//Kotlin可以在字符串字面值中引用局部变量，只需要在变量名称前面加上字符$。
//如果要在字符串中使用$，需要对它进行转义。
fun strFun(){
    val money = 100
    println("I have \$$money")
}
//除了可以引用局部变量之外，还可以引用更加复杂的表达式，只需要把表达式用花括号扩起来。
fun strFun2(a:Int,b:Int){
    println("a is ${if(a>b)"bigger" else "smmler"} than b")
}
fun main(args: Array<String>) {
    strFun()
    strFun2(2,3)
}


