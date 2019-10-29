package com.keepon.kotlin.chapter13

/**
 * createBy	 keepon
 */

//另一种实化类型参数的常见使用场景是接收java.lang.Class类型参数的API构建适配器。例如JDK中的ServiceLoader，
//它接收一个代表接口或抽象类的java.lang.Class，并返回实现了该接口的实例。
//val serviceImpl = ServiceLoader.load(Service::class.java)

//::class.java的语法展现了如何获取java.lang.Class对应的Kotlin类，这和Java中的Service.Class是完全等同的，现在我们用 带实化类型参数的函数 重写这个例子：
//val serviceImpl = loadService<String>()

//loadService的定义为如下，要加载的服务类 现在被指定成了loadService 函数的类型实参：
//inline fun <reified T> loadService() {
//    //把 "T::class" 当成类型形参的类访问。
//    return ServiceLoader.load(T::class.java)
//}



//这种用在普通类上的::class.java语法也可以同样用在实化类型参数上，
//使用这种语法会产生对应到指定为类型参数的类的java.lang.Class，你可以正常地使用它，最后我们以一个startActivity的调用来结束本节的讨论：
//
//inline fun <reified T : Activity> Context.startActivity {
//    val intent = new Intent(this, T::class.java)
//    startActivity(intent)
//}
//
//>> startActivity<DetailActivity>()























