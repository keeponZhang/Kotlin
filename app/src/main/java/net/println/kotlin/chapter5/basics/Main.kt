package net.println.kotlin.chapter5.basics

/**
 * Created by benny on 4/15/17.
 */
fun main(args: Array<String>) {
    //函数引用
    args.forEach(::println)

    //类名::来限定方法，这样可以拿到方法的引用
    val helloWorld = Hello::world
    val helloWorld2 = ::world2

    //引用成员方法 类名::方法名
    args.filter(String::isNotEmpty)
//    args.filter(String::isNotEmpty(调用的对象))

    val pdfPrinter = PdfPrinter()
    args.forEach(pdfPrinter::println)
    //PdfPrinter::println 类名::方法名 去调用，会报错  String::isNotEmpty之所以可以，因为String::isNotEmpty是一个拓展方法，
    // String::isNotEmpty有默认的参数，就是调用它的那个实例
    //带有Receiver的引用
//    args.forEach(PdfPrinter::println)
}

class PdfPrinter{
    fun println(any: Any){
        kotlin.io.println(any)
    }
}
inline fun world2(){
    println("Hello World2.")
}
class Hello{
    fun world(){
        println("Hello World.")
    }

}