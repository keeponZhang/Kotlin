package com.keepon.kotlin.other

/**
 * createBy	 keepon
 */
//定义几个类：
open class Animal

class Cat : Animal()

class Dog : Animal()
//上界
//先来抛砖引玉，我们先定义一个泛型类：
class Zoom0<T>(t: T)


//我们来给Zoom加一个上界：
class Zoom<T:Animal>(t: T)


//这样的泛型类拥有一个泛型参数T，由于我们没有给T加入任何界定，所以T可以是任意类型。我们可以随意的传入泛型参数：

//无上界
val zoom = Zoom0(Any())
val zoom1 = Zoom0(Cat())

//有上界
// 错误，因为Any不是继承自Animal的类
//val zoom2 = Zoom(Any())
// 正确
val zoom3 = Zoom(Cat())
// 正确
val zoom4 = Zoom(Dog())

//我们可以看到，在声明Zoom的时候，如果给它的泛型参数声明了上界，那传入的所有泛型参数都必须是这个上界的子类，
//否则就会报编译期错误。上界看起来是个很简单的知识点，但是和后面的协变，逆变等知识息息相关，所以这里简单提一下。
//
//作者：Raidriar
//链接：<a href='https://www.jianshu.com/p/016a24ba7a25'>https://www.jianshu.com/p/016a24ba7a25</a>
//来源：简书
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




































