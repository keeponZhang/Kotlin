package com.keepon.kotlin.chapter6

/**
 * createBy	 keepon
 */
//Kotlin中所有泛型类和泛型函数的类型参数默认都是可空的，任何类型，包括可空类型在内，都可以替换类型参数。这种情况下，使用类型参数作为类型的声明都允许为null，
//尽管类型参数T没有用问号结尾，所以我们必须使用安全调用：

fun <T> printHashCode(t:T){
    //t被推导出可控类型Any?，因为t可能为null，所以必须使用安全调用
    println(t?.hashCode())
}
//要使参数类型非空，必须要为它指定一个非空的上界，那样泛型就会拒绝可空值作为实参：
fun <T :Any> printHashCode2(t:T){
    println(t.hashCode())
}


















