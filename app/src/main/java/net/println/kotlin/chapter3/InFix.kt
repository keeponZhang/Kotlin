package net.println.kotlin.chapter3

/**
 * createBy	 keepon
 */
class Book1(){
    infix fun keepon(name:String){
        println("this is infix demo $name")
    }
}

fun main(args: Array<String>) {
    Book1() keepon "test"
}