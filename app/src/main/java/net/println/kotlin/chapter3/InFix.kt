package net.println.kotlin.chapter3

/**
 * createBy	 keepon
 */
class Book1() {
    infix fun keepon(name: String) {
        println("this is 类里面使用中缀   $this $name")
    }

    //中缀表达式必须是一个参数
//    infix fun keepon2(name: String, age: Int) {
//        println("this is 类里面使用中缀   $this $name")
//    }
}

//中缀函数必须是拓展函数或者放在类里(右边的是参数)
infix fun String.tuozhan(name: String) {
    println("this is 拓展函数使用中缀 $this $name")
}

fun main(args: Array<String>) {
    Book1() keepon "test"
    "keepon" tuozhan "age"
}