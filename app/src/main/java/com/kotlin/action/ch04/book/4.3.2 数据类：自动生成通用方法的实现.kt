package com.kotlin.action.ch04.book.数据类


/**
 *createBy keepon
 */

//data class Client(val name: String, val postalCode: Int)
//很简单，是吧？现在就得到了一个重写了所有标准Java 方法的类：
//• equals 用来比较实例
//• hashCode 用来作为例如HashMap 这种基于哈希容器的键
//• toString 用来为类生成按声明顺序排列的所有字段的字符串表达形式
//equals 和hashCode 方法会将所有在主构造方法中声明的属性纳入考虑。生
//成的equals 法会检测所有的属性的值是否相等。hashCode 方法会返回一个根据
//所有属性生成的哈希值。请注意没有在主构造方法中声明的属性将不会加入到相等
//性检查和哈希值计算中去。
