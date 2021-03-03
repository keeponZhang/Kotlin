package com.keepon.kotlin.chapter6

/**
 * createBy	 keepon
 */
//当可空参数最常见的一种用法就是被传递给一个接收非空参数的函数之前，需要进行相应的检查。比如说下面这个sendEmailTo函数，它接收一个String类型的参数并向这个地址发送一封邮件。
//假如我们传递给它一个空的emailName，那么在编译时就会抛出异常
fun  sendEmailTo(email:String){
    println("sending email to $email")
}

fun main(args: Array<String>) {
    val nullEmail:String? = null;
    val nullEmail2:String? = "nullEmail";
//    sendEmailTo(nullEmail)

    //不使用 let
    if(nullEmail!=null){
        sendEmailTo(nullEmail)
    }


    //使用 let
//    下面，我们再来看一下如果通过let解决上面的问题，let函数做的事情就是把一个调用它的对象变成lambda表达式的参数，
//    如果结合安全调用语法，它能有效地把调用let函数的可空对象，转变成非空类型：
    //其实把调用这作为参数传进去，这里就是nullEmail2
    nullEmail?.let { it -> sendEmailTo(it) }
    nullEmail2?.let { nullEmail2 -> sendEmailTo(nullEmail2) }
    //let函数只在nullEmail的值非空时才被调用，所以就能在lambda中把nullEmail当做非空的实参来使用。
}








































