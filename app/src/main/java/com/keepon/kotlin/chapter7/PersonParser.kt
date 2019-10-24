package com.keepon.kotlin.chapter7

import com.keepon.kotlin.chapter6.Person
//List<String>将是非空的，因为调用者总是需要接收错误信息。
//列表中的元素将是可空的，因为不是每个输出列表中的条目都有关联的错误信息。
//List<String>将是可变的，因为实现代码需要向其中添加元素。

//下面这句话很重要  （这个与类型参数的可空性又不一样，参考Kotlin 知识梳理(6) 2.11 可空性和 Java）
//前面我们介绍过，Kotlin把那些定义在Java代码中的类型看成 平台类型，Kotlin没有任何关于平台类型的可空性信息，
//所以编译器允许Kotlin代码将其视为可空或者非空，同样，Java中声明的集合类型的变量也被视为平台类型
//


class PersonParser : DataParser<Person> {
    //String? 也不会报错，因为java的String是可以为空的，
//    override fun parseData(input : String?, output : MutableList<Person>,
//                           errors : MutableList<String?>){
//    }
    override fun parseData(input : String, output : MutableList<Person>,
                           errors : MutableList<String?>){
    }

}

