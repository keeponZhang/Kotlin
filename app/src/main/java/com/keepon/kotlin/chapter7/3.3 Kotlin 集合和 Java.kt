package com.keepon.kotlin.chapter7

/**
 * createBy	 keepon
 */

//每一个Kotlin接口都是其对应Java集合接口的一个实例，在Kotlin和Java之间转移并不需要转换；不需要包装器也不需要拷贝数据。
//
//每一种Java集合接口在Kotlin中都有两种表示：一种是只读的，另一种是可变的。在下图当中，
// 可以看出Kotlin集合接口的层级结构，Java类ArrayList和HashSet都继承了Kotlin可变接口。
//
//作者：泽毛
//链接：<a href='https://www.jianshu.com/p/8748d6489822'>https://www.jianshu.com/p/8748d6489822</a>
//来源：简书
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


//Kotlin中只读接口和可变接口的基本结构与java.util中的Java集合接口的结构是平行的。可变接口直接对应java.util包中的接口，而它们的只读版本缺少了所有产生改变的方法。
//上图中包含了Java类中的ArrayList和HashSet，在Kotlin看来，它们分别继承自MutableList和MutableSet接口，这样既得到了兼容性，也得到了可变接口和只读接口之间清晰的分离。
//
//除了集合之外，Kotlin中Map类也被表示成了两种不同的版本：Map和MutableMap。我们之前见到的listOf/setOf/mapOf所返回的都是只读版本。
//
//当你有一个使用java.util.Collection做形参的Java方法，可以把任意Collection或MutableCollection的值作为实参传递给这个形参。
//Java并不会区分只读集合和可变集合，也就是说即使Kotlin中把集合声明成只读的，Java代码也可以修改这个集合，
//例如下面的代码，虽然我们将printInUppercase接收的list参数声明为只读的，但是仍然可以通过Java代码修改它。
