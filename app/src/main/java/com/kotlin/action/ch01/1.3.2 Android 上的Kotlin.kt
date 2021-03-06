package com.kotlin.action.ch01.Android上的Katlin.kt



/**
 *createBy keepon
 */

//一个典型的移动应用和一个典型的企业应用完全不同。它更小，更少地依赖与
//现有的代码集成，通常需要快速交付，同时需要保证在大量的设备上能够可靠地运
//行。这类项目Kotlin也能胜任。
//Kotlin的语言特性，加上支持Android框架的特殊编译器插件，让Android 的
//开发体验变得高效和愉悦。常见的开发任务，比如给控件添加监昕器或是把布局元
//素绑定到字段，可以用更少的代码完成，有时甚至根本不用写任何代码（编译器会
//10 第1章Kotlin：定义和目的
//帮你生成)。同样由Kotlin团队打造的库Anko( https://github.com/kotlin/anko）给许
//多标准AndroidAPI添加了Kotlin友好的适配器，进一步提升了Android 的开发体验。
//
//使用Kotlin带来的另一优势就是更好的应用可靠性。如果你有开发Android
//应用的经验，你一定对“ Unfortunately, Process Has Stopped，对话框深恶痛
//绝。如果你的应用有未处理的异常，这个对话框就会出现，而这种异常一般
//是NullPointerException（空指针异常）。Kotlin的类型系统通过精确地
//跟踪null值，大大减轻了空指针异常问题带来的压力。大部分Java 中会导致
//NullPointerException的代码在Kotlin中无法编译成功，以确保这些错误在
//应用到达用户手中之前得到修正。
//
//同时，由于Kotlin完全兼容Java6，使用它并不会带来任何新的编译问题。你
//可以享受所有Kotlin的酷炫新特性，而你的用户仍然可以在他们的设备上使用你的
//应用，即使他们的设备并没有运行最新版本的Android系统。
//说到性能，Kotlin也没有带来任何负面影响。Kotlin编译器生成的代码执行起
//来和普通的Java 代码效率一样。Kotlin使用的运行时（库〉体积相当小，所以编译
//出来的应用程序包体积也不会增加多少。当你使用lambda 的时候，它们会被许多
//Kotlin 标准库函数内联。lambda的内联确保不会创建新对象，因此应用程序也不必
//忍受额外的GC 暂停。