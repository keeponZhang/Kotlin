package com.keepon.kotlin.chapter3

/**
 * createBy	 keepon
 */
//sealed类。为父类添加一个sealed修饰符，对可能创建的子类做出严格的限制，所有的直接子类必须嵌套在父类中
sealed class    Expr2{
    class Num2(val value:Int):Expr2()
//    class Mutil(val value:Int):Expr2()
    class Sum2(val left:Expr2,val right:Expr2):Expr2()
}

fun  eval(e:Expr2):Int=
        when(e){
            is Expr2.Num2 -> e.value
            is Expr2.Sum2 -> eval(e.right)+ eval(e.right)
            //这里不用else
            //这里必须写Expr2的所有子类，不然编译就会报错
        }