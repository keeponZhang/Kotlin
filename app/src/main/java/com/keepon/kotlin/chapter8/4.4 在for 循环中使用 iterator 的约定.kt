package com.keepon.kotlin.chapter8

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

/**
 * createBy	 keepon
 */

//在for循环中使用in运算符表示 执行迭代操作，
//诸如for(x in list) { }将被转换成list.iterator()的调用，然后在上面重复调用hasNext和next方法。

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
        object : Iterator<LocalDate> {
            var current = start

            @RequiresApi(Build.VERSION_CODES.O)
            //apply调用者作为参数传进去
            override fun next(): LocalDate = current.apply {
                current = plusDays(2)
            }

            override fun hasNext(): Boolean {
                return current <= endInclusive
            }
        }

@RequiresApi(Build.VERSION_CODES.O)
fun main(args: Array<String>) {
    val newYear = LocalDate.ofYearDay(2017, 1)
    val daysOff = newYear.minusDays(10)..newYear
    for (dayOff in daysOff) {
        println(dayOff)
    }
}































