package com.keepon.kotlin.chapter3

/**
 * createBy	 keepon
 */

//现在，我们已经学习了两种属性的用法：
//
//存储值的属性
//具有自定义访问器在每次访问时计算值的属性
//现在，我们结合以上两种，来实现一个既可以存储值，又可以在值被访问和修改时提供额外逻辑的属性：

//注意这里是个类，前面的是接口
class User6(val name:String){
    var address:String = "unspecified"
    set(value:String){
        println("""
            Address was changed for $name:"$field" ->"$value".
        """.trimIndent())
        //使用特殊的标识符来访问支持字段的值
        field = value
    }
}

//上面的address就是 有支持字段的属性，它和 没有支持字段的属性 的区别在于：
//如果显示地引用或者使用默认的访问器实现，编译器会为属性生成支持字段。
//如果你提供了一个自定义的访问器实现并且没有使用field，支持字段就不会被呈现出来。


fun main(args: Array<String>) {
    val user = User6("Alice")
    user.address = "Eleel 467,7987 Muou"
}



















