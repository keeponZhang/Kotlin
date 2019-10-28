package com.keepon.kotlin.chapter10

/**
 * createBy	 keepon
 */
//背后的原理是：

//函数类型被声明为普通的接口：一个函数类型的变量是FunctionN接口的一个实现。
//Kotlin标准库定义了一系列的接口：Function0<R>表示没有参数的函数，Function1<P1, R>表示一个参数的函数。

//一个函数类型的变量就是实现了对应的Function接口的实现类的实例，每个接口定义了一个invoke方法，实现类的invoke方法包含了lambda函数体，
//调用这个方法就会执行函数。
//
//在Java中可以很简单地调用使用了函数类型的Kotlin函数，Java 8的lambda会被自动转换为函数类型的值：

//Kotlin 声明
fun processTheAnswer(f : (Int) -> Int) {
    println(f(42))
}

//在旧版的Java中，可以传递一个实现了函数接口中的invoke方法的匿名内部类的实例：

//processTheAnswer(
//new Function1<Integer, Integer>() {
//    @override
//    public Integer invoke(Integer number) {
//        System.out.println(number);
//        return number + 1;
//    }
//}
//)




























































