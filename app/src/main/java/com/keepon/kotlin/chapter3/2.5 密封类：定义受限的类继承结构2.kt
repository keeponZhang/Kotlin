package com.keepon.kotlin.chapter3

/**
 * createBy	 keepon
 */
sealed class    Expr2{
    class Num2(val value:Int):Expr2()
    class Sum2(val left:Expr2,val right:Expr2):Expr2()
}

fun  eval(e:Expr2):Int=
        when(e){
            is Expr2.Num2 -> e.value
            is Expr2.Sum2 -> eval(e.right)+ eval(e.right)
            //这里不用else
        }