package net.println.kotlin.chapter5.currying

import java.io.OutputStream
import java.nio.charset.Charset

/**
 * Created by benny on 4/15/17.
 */
//currying 简单说就是多元函数变换成一元函数调用链

fun hello(x:String,y:Int,z:Double):Boolean{
    return  true
}
//科理化就是完成由多个参数的函数变换成一系列单参数函数的变换
//（y:Int)是输入第一个参数的返回，(z:Double)是输入第二个参数的返回，参考log2
//fun curriedHello(x:String):(y:Int)->(z:Double)->Boolean{
//    return false
//}



fun log(tag: String, target: OutputStream, message: Any?){
    target.write("[$tag] $message\n".toByteArray())
}

fun log2(tag: String)
    = fun(target: OutputStream)
    = fun(message: Any?)
    = target.write("[$tag] $message\n".toByteArray())

fun main(args: Array<String>) {
    //科理化
//    log("benny", System.out, "HelloWorld")
    //log2("benny")(System.out) 只传两个参数不会有东西打印出来
//    log2("benny")(System.out)("HelloWorld Again.")
    // ::log表示去函数的引用，如果符合拓展方法，可以如下调用
//   ::log.curried()("benny")(System.out)("HelloWorld Again.")


    //偏函数

    //consoleLogWithTag是原函数的偏函数
    val consoleLogWithTag = (::log.curried())("benny")(System.out)
    //
    consoleLogWithTag("HelloAgain Again1.")
    consoleLogWithTag("HelloAgain Again2.")
//    consoleLogWithTag("HelloAgain Again3.")
//    consoleLogWithTag("HelloAgain Again4.")
//
//    val bytesUTF = "我是中国人".toByteArray(charset("utf-8"))
//    val bytes = "我是中国人".toByteArray(charset("utf-8"))
//
//    val stringFromutf = makeStringFromUTF(bytesUTF)
//    val stringFromGBK = makeStringFromGbkBytes(bytes)
//
//    println("stringFromutf $stringFromutf")
//    println("stringFromGBK $stringFromGBK")
}

fun <P1, P2, P3, R> Function3<P1, P2, P3, R>.curried()
    = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = this(p1, p2, p3)

val makeString = fun(byteArray: ByteArray, charset: Charset): String{
    return String(byteArray, charset)
}
//第二个参数已经指定为GBK
////表示p2已经调用了，makeStringFromGbkBytes再次调用的话，传入P1的参数即可
val makeStringFromGbkBytes = makeString.partial2(charset("GBK"))
val makeStringFromUTF = makeString.partial2(charset("utf-8"))


fun <P1, P2, R> Function2<P1, P2, R>.partial2(p2: P2) = fun(p1: P1) = this(p1, p2)
fun <P1, P2, R> Function2<P1, P2, R>.partial1(p1: P1) = fun(p2: P2) = this(p1, p2)