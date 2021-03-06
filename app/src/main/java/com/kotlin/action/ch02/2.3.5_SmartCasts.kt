package ch02.ex3_5_SmartCasts

interface Expr
class Num2(var value: Int) : Expr {
    var value2: Int = 1
    var value1: Int = 1
        //get() = 函数体
        get() = value - 1
//    get 前面不能用open
//      open   get() = value - 1
}

class Num(var value: Int) : Expr
class Sum(var left: Expr, var right: Expr) : Expr

fun eval(e: Expr): Int {
    var e2: Expr = Num(2)
    if (e2 is Num) {
        println("e2 is Num")
        //这里判断后再改变类型，是不行的，所以说智能转换只在变量经过is检查且之后不再发生变化的情况下有效。
        //       e2 = Sum(Num(2), Num(2))
        return e2.value
    }
//    在这里改变类型是可以的
//    e2 = Sum(Num(2), Num(2))
    var e3: Expr = Num2(2)
    if (e3 is Num2) {
        println("e2 is Num")
        //这里判断后再改变类型，是不行的，所以说智能转换只在变量经过is检查且之后不再发生变化的情况下有效。
        //    e2 = Sum(Num(2), Num(2))
        return e3.value2
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
