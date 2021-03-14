package com.keepon.kotlin.chapter8

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

/**
 * createBy	 keepon
 */

//要创建一个区间时，使用的是..语法，例如1..10代表所有从1到10的数字，..运算符是调用rangeTo函数的一个简洁方法。
//rangeTo返回一个区间，你可以为自己的类定义这个运算符，但是，如果该类实现了Comparable接口，那么就不需要了，
//你可以通过Kotlin标准库创建一个任意可比较元素的区间，这个库定义了可以用于任何可比较元素的rangeTo函数

//operator fun <T : Comparable<T>> T.rangeTo(that : T) : ClosedRange<T>

//这个函数返回一个区间ClosedRanged，可以用来检测其它一些元素是否属于它。

@RequiresApi(Build.VERSION_CODES.O)
fun main(args: Array<String>) {
    val now  = LocalDate.now()
    val vacation = now..now.plusDays(10)
    println(now.plusWeeks(1) in vacation)
}
//上面的now..now.plusDays(10)将会被编译器转换为now.rangeTo(now.plusDays(10))，它并不是LocalDate的成员函数，而是Comparable的一个扩展函数。
