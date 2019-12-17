package com.keepon.kotlin.chapter6

/**
 * createBy	 keepon
 */
fun  callNullJava(){
    val s:String? = null
    //这里不会报错
    JavaCallKotin.nullFunC(s)
    //这里会报错，因为java那边是要求不可空的
//    JavaCallKotlin.nonnullFunC(s)

//    如果注解不存在时，Java类型会变成Kotlin中的 平台类型。平台类型本质上就是Kotlin不知道可空性信息的类型，这意味着，你要像在Java中一样，对你在这个类型上做的操作负有全部责任，编译器将会允许所有的操作
    //没有注解，这时是可以编译通过的
    JavaCallKotin.nonAnnotationFunC(s)
}







































