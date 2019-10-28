package com.keepon.kotlin.chapter12

/**
 * createBy	 keepon
 */
//类型参数约束 可以限制作为 泛型类和泛型函数的类型实参的类型。例如计算列表元素之和的函数sum，
//它可以用在List<String>和List<Double>上，但不可用在List<String>上，可以 定义一个类型参数约束，说明sum的类型形参必须是数字。
//
//如果你把一个类型指定为泛型类型形参的上界约束，在泛型类型具体的初始化中，其对应的类型实参就必须是这个具体类型或者它的子类型。
//约束的定义方式为：把冒号放在类型参数名称之后，作为类型形参上界的类型紧随其后，例如：
//
//fun <T : Number> List<T>.sum() : T
//
//如果需要在一个类型参数上指定多个约束，需要使用不同的语法：
//fun <T> ensureTrailingPeriod(seq : T)
//        where T : CharSequence, T : Appendable {
//    //...
//}
//在这种情况下，作为类型实参的类型必须实现CharSequence和Appendable两个接口。













































