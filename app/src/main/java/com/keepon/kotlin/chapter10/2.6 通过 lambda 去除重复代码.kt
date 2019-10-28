package com.keepon.kotlin.chapter10

/**
 * createBy	 keepon
 */
//我们来看一个分析网站的例子，SiteVisit类用来保存每次访问的路径、持续时间和用户的操作系统。

data class SiteVisit(
        val path: String,
        val duration: Double,
        val os: OS
)

enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

val log2 = listOf(
        SiteVisit("/", 34.0, OS.WINDOWS),
        SiteVisit("/", 222.0, OS.MAC),
        SiteVisit("/login", 12.0, OS.WINDOWS),
        SiteVisit("/signup", 8.0, OS.IOS),
        SiteVisit("/", 16.3, OS.ANDROID)
)

//接下来，我们通过扩展函数的方式，定义一个方法用于统计 符合特定条件 的操作系统用户的平均使用时长。
fun List<SiteVisit>.averageDuration(predicate : (SiteVisit) -> Boolean) =
        filter(predicate).map(SiteVisit::duration).average()
//运行下面的代码：
fun main(args: Array<String>) {
    println(log2.averageDuration {it.os in setOf(OS.WINDOWS, OS.ANDROID) })
}


//对于一些广为人知的设计模式可以使用函数类型和lambda表达式进行简化，
//比如策略模式。没有lambda表达式的情况下，你需要声明一个接口，并为每一种可能的策略提供实现类。使用函数类型，可以用一个通用的函数类型来描述策略，然后传递不同的lambda表达式作为不同的策略。
//
//作者：泽毛
//链接：<a href='https://www.jianshu.com/p/4da8968ec305'>https://www.jianshu.com/p/4da8968ec305</a>
//来源：简书
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



















































