package com.keepon.kotlin.chapter4


/**
 * createBy	 keepon
 */
//就像其它对象声明一样，伴生对象也可以实现接口，可以将包含它的类的名字当做实现了该接口的对象实例来使用。

interface LogObject{
    fun log()
}

class Person3(val name:String){
    companion object :LogObject{
        override fun log() {
            println("I am Person3")
        }
    }
}

fun logObject(logObject: LogObject){
    logObject.log()
}

fun main(args: Array<String>) {
    val person3 = Person3("keepon")
    //这传对象反而不行，会报错
//    logObject(person3)
    logObject(Person3)
}































