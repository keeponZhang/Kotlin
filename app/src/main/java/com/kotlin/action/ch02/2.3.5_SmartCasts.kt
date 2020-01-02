package ch02.ex3_5_SmartCasts

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
    var e2: Expr = Num(2)
    if (e2 is Num) {
        println("e2 is Num")
        //这里判断后再改变类型，是不行的，所以说智能转换只在变量经过is 检查且之后不再发生变化的情况下有效。
//        e2 = Sum(Num(2), Num(2))
        return e2.value
    }

    if (e is Num) {
        val n = e as Num
        return n.value
    }
    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}

fun main(args: Array<String>) {
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
}
