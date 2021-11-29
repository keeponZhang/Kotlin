package com.bennyhuo.kotlin.coroutines.sample.yuanli.sample

import com.bennyhuo.kotlin.coroutines.sample.yuanli.AbstractCoroutineContextElementV2
import com.bennyhuo.kotlin.coroutines.sample.yuanli.CoroutineContextV2
import com.bennyhuo.kotlin.coroutines.sample.yuanli.CoroutineDispatcherV2
import com.bennyhuo.kotlin.coroutines.utils.log

/**
 * createBy	 keepon
 */


//https://blog.csdn.net/u012165769/article/details/121248282?spm=1001.2014.3001.5501
public class My4CoroutineName(
        val name: String
) : AbstractCoroutineContextElementV2(My4CoroutineName) {

    public companion object Key : CoroutineContextV2.KeyV2<My4CoroutineName>

    override fun getString(): String {
        return "${javaClass.simpleName}:($name)"
    }

    override fun toString(): String = "${javaClass.simpleName}:($name)"
}

public class My5CoroutineName(
        val name: String
) : AbstractCoroutineContextElementV2(My5CoroutineName) {
    public companion object Key : CoroutineContextV2.KeyV2<My5CoroutineName>

    override fun getString(): String {
        return "${javaClass.simpleName}:($name)"
    }

    override fun toString(): String = "${javaClass.simpleName}:($name)"
}

public class My6CoroutineName(
        val name: String
) : AbstractCoroutineContextElementV2(My6CoroutineName) {
    public companion object Key : CoroutineContextV2.KeyV2<My6CoroutineName>

    override fun getString(): String {
        return "${javaClass.simpleName}:($name)"
    }

    override fun toString(): String = "${javaClass.simpleName}:($name)"
}

public class My3CoroutineName(
        val name: String
) : AbstractCoroutineContextElementV2(My3CoroutineName) {
    public companion object Key : CoroutineContextV2.KeyV2<My3CoroutineName>

    override fun getString(): String {
        return "${javaClass.simpleName}:($name)"
    }

    override fun toString(): String = "${javaClass.simpleName}:($name)"
}

fun main() {

//    test1()
//    test2()
//    test2_1()
//    test2_2()
//    test2_3()
//    test3()
    test3_2()
}

fun test1() {
    val my3CoroutineName = My3CoroutineName("A")
    val my3CoroutineName2 = My3CoroutineName("B")
//    这里因为Key一样，所以会被覆盖
    val coroutineContextV2 = my3CoroutineName + my3CoroutineName2
    log("$coroutineContextV2")
}

fun test2() {
    val my3CoroutineName2 = My3CoroutineName("B")
    val my4CoroutineName3 = My4CoroutineName("C")
    val my5CoroutineName4 = My5CoroutineName("D")
    val coroutineContextV2 = my3CoroutineName2 + my4CoroutineName3
//    log("coroutineContextV2=$coroutineContextV2 ")

    val coroutineContextV21 = coroutineContextV2 + my5CoroutineName4
//    log("coroutineContextV21=$coroutineContextV21")
}

//加号运算符将CoroutineContext实例相互结合。它会合并它们所包含的元素，
//用操作符右边的上下文中的元素覆盖左边的上下文中的元素，很像Map上的行为。
//[加号运算符]返回一个包含来自这个上下文的元素和其他上下文的元素的上下文。这个上下文中与另一个上下文中Key值相同的元素会被删除。
//(Dispatchers.Main, “name”) + (Dispatchers.IO) = (Dispatchers.IO, “name”)
//实际：studyContext.test2_1 coroutineContextV21=[My4CoroutineName:(C), My3CoroutineName:(D)
// ]，与上面的结论有点不一样
fun test2_1() {
    val my3CoroutineName2 = My3CoroutineName("B")
    val my4CoroutineName3 = My4CoroutineName("C")
    val my5CoroutineName4 = My3CoroutineName("D")
    val coroutineContextV2 = my3CoroutineName2 + my4CoroutineName3
//    log("coroutineContextV2=$coroutineContextV2 ")

    val coroutineContextV21 = coroutineContextV2 + my5CoroutineName4
    log("coroutineContextV21=$coroutineContextV21")
}

fun test2_2() {
    val my3CoroutineName2 = My3CoroutineName("B")
    val my4CoroutineName3 = My4CoroutineName("C")
    val my5CoroutineName4 = My4CoroutineName("D")
    val coroutineContextV2 = my3CoroutineName2 + my4CoroutineName3
//    log("coroutineContextV2=$coroutineContextV2 ")

    val coroutineContextV21 = coroutineContextV2 + my5CoroutineName4
    log("coroutineContextV21=$coroutineContextV21")
}

fun test2_3() {
    val my3CoroutineName2 = My3CoroutineName("B")
    val my4CoroutineName3 = My4CoroutineName("C")
    val my5CoroutineName4 = My4CoroutineName("D")
    val coroutineContextV2 = my3CoroutineName2 + my4CoroutineName3
//    log("coroutineContextV2=$coroutineContextV2 ")

    val coroutineContextV21 = coroutineContextV2 + my5CoroutineName4
    log("coroutineContextV21=$coroutineContextV21")
}

fun test3() {
    val my3CoroutineName2 = CoroutineDispatcherV2("main")
    val my4CoroutineName3 = My4CoroutineName("C")
    val my5CoroutineName4 = CoroutineDispatcherV2("IO")
    val coroutineContextV2 = my3CoroutineName2 + my4CoroutineName3
    log("coroutineContextV2=$coroutineContextV2 ")

//    val coroutineContextV21 = coroutineContextV2 + my5CoroutineName4
//    log("coroutineContextV21=$coroutineContextV21")
}

fun test3_2() {
    val my3CoroutineName2 = My3CoroutineName("B")
    val my4CoroutineName3 = My4CoroutineName("C")
    val my5CoroutineName4 = My5CoroutineName("D")
    val my5CoroutineName5 = My3CoroutineName("F")
//    log("CoroutineContextV2相加0,准备被加的为 $my4CoroutineName3")
    val coroutineContextV2 = my3CoroutineName2 + my4CoroutineName3 + my5CoroutineName4
    log("test3_2 coroutineContextV2=${coroutineContextV2.getString()} ")
//    log("CoroutineContextV2相加1,准备被加的为 $my5CoroutineName4")
//    val coroutineContextV21 = coroutineContextV2 + my5CoroutineName4
//    log("CoroutineContextV2相加2,准备被加的为 $my5CoroutineName5")
//    val coroutineContextV22 = coroutineContextV21 + my5CoroutineName5
//    log("coroutineContextV21=$coroutineContextV21")
}

fun test3_1() {
    val my3CoroutineName2 = My3CoroutineName("B")
    val my4CoroutineName3 = My4CoroutineName("C")
    val my5CoroutineName4 = My5CoroutineName("D")
    val coroutineContextV2 = my3CoroutineName2 + my4CoroutineName3
//    log("coroutineContextV2=$coroutineContextV2 ")

    val coroutineContextV21 = my5CoroutineName4 + coroutineContextV2
//    log("coroutineContextV21=$coroutineContextV21")
}

fun test4() {
    val my3CoroutineName2 = My3CoroutineName("B")
    val my4CoroutineName3 = My4CoroutineName("C")
    val my5CoroutineName4 = My5CoroutineName("D")
    val my5CoroutineName5 = My6CoroutineName("F")
    val coroutineContextV2 = my3CoroutineName2 + my4CoroutineName3
//    log("coroutineContextV2=$coroutineContextV2 ")

    val coroutineContextV21 = my5CoroutineName4 + my5CoroutineName5
    val coroutineContextV22 = coroutineContextV2 + coroutineContextV21
//    log("coroutineContextV21=$coroutineContextV21")
}
//https://blog.csdn.net/qfanmingyiq/article/details/105081080