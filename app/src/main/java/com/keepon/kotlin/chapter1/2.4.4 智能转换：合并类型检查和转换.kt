package com.keepon.kotlin.chapter1

/**
 * createBy	 keepon
 */

//在Java中，在检查完后还需要显示地加上类型转换。
//在kotlin中，如果你检查过一个变量是某种类型，后面就不需要再转换它，可以把它当做你检查过的类型来使用。
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun cal(expr: Expr): Int =
    when (expr) {
        is Num -> expr.value
        is Sum -> cal(expr.left) + cal(expr.right)
        else -> 0
    }

fun main(args: Array<String>) {
    println(cal(Sum(Sum(Num(2), Num(3)), Num(4))))
}


//智能转换 只在变量经过is检查且之后不再发生变化 的情况下有效，
//当你对一个类的属性进行智能转换的时候，这个属性必须是一个val属性，
//而且不能有自定义的访问器，否则，每次对属性的访问是否都能返回同样的值将无从验证。

