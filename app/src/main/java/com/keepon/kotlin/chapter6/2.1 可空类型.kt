package com.keepon.kotlin.chapter6

/**
 * createBy	 keepon
 */
//当我们在声明方法时，如果允许在这个方法被调用的时候传给它null的实参，则需要显示地 在类型名称后面加上问号来标记它：

fun strlenSafe(s:String?):Int{
   return if(s!=null) s.length else 0
}

fun main(args: Array<String>) {
    println(strlenSafe("keepon"))
    println( strlenSafe(null))
}
















