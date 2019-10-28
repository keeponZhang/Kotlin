package com.keepon.kotlin.chapter10

/**
 * createBy	 keepon
 */

//为了声明一个以lambda作为实参的函数，你需要知道如何声明 对应形参的类型。
//下面我们先看一个简单的例子，把lambda表达式保存在局部变量当中：

val sum = { x : Int, y : Int -> x + y }
val action = { println(42) }

//在上面的例子中，我们省去了类型的声明。但是编译器可以推导出sum和action这两个 变量具有函数类型，这些变量的显示声明为：
//有两个 Int 型参数和 Int 型返回值的函数
//val sum : (Int, Int) -> Int = {x, y -> x + y}
////没有参数和返回值的函数
//val action : () -> Unit = { println(42) }

//声明函数类型，需要 将函数参数类型放在括号中，紧接着是一个箭头和函数的返回类型：
//(Int, String) -> Unit

//Unit类型用于表示函数不返回任何有用的值，在声明一个普通的函数时，Unit类型的返回值是可以忽略的，
//但是一个 函数类型声明总是需要一个显示的返回类型，所以在这种场景下Unit是不能省略的。

//在{x, y -> x + y}中，因为它们的类型已经在函数类型的变量声明部分指定了，不需要在lambda当中重复声明。
//
//就像其它方法一样，函数类型的返回值也可以标记为可空类型：
//var canReturnNull : (Int, Int) -> Int? = { null }


//也可以定义一个 函数类型的可空变量，为了明确表示 变量本身可空，而不是函数类型的返回类型可空，
//你需要 将整个函数类型的定义包含在括号内并在括号后添加一个问号：
//
//var funOrNull : ((Int, Int) -> Int)? = null


//函数类型的参数名
//可以为函数类型声明中的参数指定名字：
////函数类型的参数现在有了名字...
//fun performRequest(url : String, callback : (code : Int, content : String) -> Unit) {
//    //....
//}

//调用方法为：
//
//>> val url = "http://kotl.in"
////可以使用 API 中提供的参数名字作为 lambda 参数的名字....
//>> performRequest(url) { code, content -> / *...* / }
//>> performRequest(url) { code, page -> / *...* / }
//
//参数名称不会影响类型的匹配，当你声明一个lambda时，不必使用和函数类型声明中一模一样的参数名称，但命名会提升代码的可读性并且能用于IDE的代码补全。














