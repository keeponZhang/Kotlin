package com.kotlin.action.ch04.book.可见性修饰符默认为public


/**
 *createBy keepon
 */

//总的来说，Kotlin中的可见性修饰符与Java中的类似。同样可以使用public 、
//protected和private修饰符。但是默认的可见性是不一样的：如果省略了修饰
//符，声明就是public的。
//
//作为替代方案，Kotlin提供了一个新的修饰符，internal，表示“只在模
//块内部可见飞一个模块就是一组一起编译的Kotlin文件。这有可能是一个Intellij
//IDEA 模块、一个Eclipse项目、一个Maven或Gradle项目或者一组使用调用Ant
//任务进行编译的文件。
//
//internal可见性的优势在于它提供了对模块实现细节的真正封装。使用Java
//时，这种封装很容易被破坏，因为外部代码可以将类定义到与你代码相同的包中，
//从而得到访问你的包私有声明的权限。
//
//Kotlin禁止从public函数giveSpeech去引用低可见的类型TalkativeButton
//（这个例子中是internal)。一个通用的规则是：类的基础类型和类型参数列表中
//用到的所有类，或者函数的签名都有与这个类或者函数本身相同的可见性。这个规
//则可以确保你在需要调用函数或者继承一个类时能够始终访问到所有的类型。要解
//决上面例子中的问题，既可以把函数改为internal的，也可以把类改成public的。
//注意， protected修饰符在Java和Kotlin中不同的行为。在Java中，可以从
//同一个包中访问一个protected的成员，但是Kotlin不允许这样做。在Kotlin中
//可见性规则非常简单，protected成员只在类和它的子类中可见。同样还要注意
//的是类的扩展函数不能访问它的private和protected成员。



//下面这个是重点
//在Java 中，可以从同一个包中访问一个protected的成员，但是Kotlin不允许这样做。在Kotlin中
//可见性规则非常简单，protected成员只在类和它的子类中可见


//java访问控制权限（yes代表可以访问）
// 	           private	  default(默认）	 protected	    public
//同一类	        yes	       yes	            yes	         yes
//同一包中的类	 		   yes              yes	         yes
//子类	 	 	                            yes	         yes
//其他包中的类	 	 	 	                             yes



//kotlin修饰符          类成员          类成员顶层声明
//public （默认）       所有地方可见     所有地方可见
//internal            模块中可见        模块中可见
//protected           子类中可见
//private             类中可见         文件中可见





//Kotlin的可见性修饰符和Java
//Kotlin中的public、protected和private修饰符在编译成Java字节
//码时会被保留。你从Java代码使用这些Kotlin声明时就如同他们在Java中声明
//了同样的可见性。唯一的例外是private类：在这种情况下它会被编译成包私
//有声明（在Java中你不能把类声明为private）。
//但是，你可能会问，internal修饰符将会发生什么？Java中并没有直接
//与之类似的东西。包私有可见性是一个完全不同的东西：一个模块通常会由多
//个包组成，并且不同模决可能会包含来自同一个包的声明。因此internal 修
//饰符在字节码中会变成public。
//这些Kotlin声明和它们Java翻版（或者说它们的字节码呈现）的对应关
//系解释了为什么有时你能从Java代码中访问一些你不能从Kotlin中访问的东西。
//例如，可以从另一个模块的Java代码中访问internal类或顶层声明，抑或从
//同一个包的Java代码中访问一个protected 的成员（与你在Java中做的相似）。
//但是注意类的internal成员的名字会被破坏。从技术上讲，internal
//成员也是可以在Java中使用的，但是它们在Java代码中看起来很难看。当你从
//另一个模块继承类时，可以帮助避免在重写时出现出乎意料的冲突，并且避免
//意外使用internal类。


//另一个Kotlin与Java之间可见性规则的区别就是在Kotlin中一个外部类不能看
//到其内部（或者嵌套）类中的private成员。让我们接下来讨论Kotlin中的内部
//和嵌套类来看一个例子。
