package com.keepon.kotlin.chapter1

/**
 * createBy	 keepon
 */
//简单枚举类
enum class Color{
    RED,ORANGE,YELLOW,GREEN,BLUE,INGIGO,VIOLET
}
//带属性的枚举类
enum class ColorShuXing(val r:Int,val g:Int,val b:Int){
    RED(255,0,0),
    ORANGE(255,165,0),
    YELLOW(255,255,0)
}

//当声明一个带属性的枚举类时，有几点需要注意：
//当声明每个枚举常量的时候，必须提供该常量的属性值。
//如果要在枚举类中定义任何方法，就要使用分号把枚举常量列表和方法分开。