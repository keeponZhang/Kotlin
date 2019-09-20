package net.println.kotlin.chapter5.compose

/**
 * Created by benny on 4/15/17.
 */
//f(g(x))   m(x) = f(g(x))
val add3 = fun(i: Int){  i + 5} // g(x)
val add5 = {i: Int -> i + 5} // g(x)
val multiplyBy2 = {i : Int -> i * 2} // f(x)

fun main(args: Array<String>) {
    println(multiplyBy2(add5(8))) // (5 + 8) * 2

    val add5AndMultiplyBy2 = add5 andThen multiplyBy2
    //multiplyBy2跟返回的add5ComposeMultiplyBy2都是函数类型，add5ComposeMultiplyBy2这个函数类型调用add5ComposeMultiplyBy2(8)表示p1传入的是8
    println(add5AndMultiplyBy2(8)) // m(x) = f(g(x))

    val add5ComposeMultiplyBy2 = add5 compose  multiplyBy2
    println(add5ComposeMultiplyBy2(8)) // m(x) = g(f(x))
}

//P1 P2为参数值 R为返回值
//infix 中缀表达式
//function: Function1<P2, R>): Function1<P1,R>  输入值为Function1，返回值也是Function1，都是函数类型这里是返回了闭包函数
//Function1 第一个为参数(multiplyBy2)，第二个为返回值(add5AndMultiplyBy2)，根据add5ComposeMultiplyBy2(8)，P1为8，这是针对整个函数的

//分析 val add5AndMultiplyBy2 = add5 andThen multiplyBy2
//  println(add5AndMultiplyBy2(8))
// 1.function: Function1<P2, R> ==multiplyBy2 表示接受的function输入为P2，返回为R，
// 2.Function1<P1,R> = add5AndMultiplyBy2 = add5 andThen multiplyBy2,这也是一个function,输入为P1，返回为R
//3.add5AndMultiplyBy2(8)很明显P1为8
//4.this == add5,function.invoke(this.invoke(p1))克制，function接收的是P2，所以Function1<P1, P2>中应该指的是调用者的输入值和返回值，这里明显是add5
//怎么确认andThen前面的泛型类型，其实指的就是调用者的
infix fun <P1, P2, R> Function1<P1, P2>.andThen(function: Function1<P2, R>): Function1<P1,R>{
    //这里p1是闭包输入参数8
    return fun(p1: P1): R{
        //this 表示调用者,这里this是指代add5，function指代multiplyBy2
        println("this $this  p1 $p1")
        return function.invoke(this.invoke(p1))
    }
}

//这里compose后面的先执行，后面还会执行，所以function的返回值为P2，作为调用者的输入参数
infix fun <P1,P2, R> Function1<P2, R>.compose(function: Function1<P1, P2>): Function1<P1, R>{
    return fun(p1: P1): R{
        //这里p1是闭包输入参数8,this表示add5，function.invoke(p1)的返回值要作为add5的参数，所以两个类型要一样， P2不能改成R
        return this.invoke(function.invoke(p1))
    }
}

