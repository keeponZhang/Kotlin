package com.keepon.kotlin.chapter13

/**
 * createBy	 keepon
 */
//逆变的概念可以看成是协变的镜像，对一个逆变类来说，它的子类型化关系与用作类型实参的类的子类型化关系是相反的：如果B是A的子类型，那么Consumer<A>就是Consumer<B>的子类型。
//以Comparator接口为例，这个接口定义了一个compare方法，用于比较两个指定的对象：
//interface Comparator<in T> {
//    fun compare(e1 : T, e2 : T) : Int { ... }
//}
//
//这个接口方法只是消费类型为T的值，这说明T只在in位置使用，因此它的声明之前用了in关键字。
//
//一个为特定类型的值定义的比较器显然可以比较该类型任意子类型的值，例如，如果有一个Comparator<Any>，可以用它比较任意具体类型的值。
//val anyComparator = Comparator<Any> { e1, e2 -> e1.hashCode() - e2.hashCode() }
//val strings : List<String> = ...
//strings.sortedWith(anyComparator)
//
//sortedWith期望一个Comparator<String>，传给它一个能比较更一般的类型的比较器是安全的。如果你要在特定类型的对象上执行比较，可以使用能处理该类型或者它的超类型的比较器。
//
//这说明Comparator<Any>是Comparator<String>的子类型，其中Any是String的超类型。不同类型之间的子类型关系 和 这些类型的比较器之间的子类型关系 截然相反。
//
//in关键字的意思是，对应类型的值是传递进来给这个类的方法的，并且被这些方法消费。和协变的情况类似，约束类型参数的使用将导致特定的子类型化关系。
//
//一个类可以在一个类型参数上协变，同时在另外一个类型参数上逆变。
//Function接口就是一个经典的例子：
//
//interface Function1<in P, out R> {
//    operator fun invoke(p : P) : R
//}
//这意味着对这个函数类型的第一类型参数来说，子类型化反转了，而对于第二个类型参数来说，子类型化保留了。例如，你有一个高阶函数，该函数尝试对你所有的猫进行迭代，你可以把一个接收动物的lambda传递给它。
//
//fun enumerate(f : (Cat) -> Number) { ... }
//fun Animal.getIndex() : Int = ...
//
//>> enumerate(Animal :: getIndex)
//





















