package com.keepon.kotlin.chapter3

/**
 * createBy	 keepon
 */
interface  Expr
class Num(val value:Int):Expr
class Sum(val left:Expr,val right:Expr):Expr
fun  eval(e:Expr):Int=
        when(e){
            is Num -> e.value
            is Sum -> eval(e.right)+ eval(e.right)
            else -> throw RuntimeException("no found")
        }