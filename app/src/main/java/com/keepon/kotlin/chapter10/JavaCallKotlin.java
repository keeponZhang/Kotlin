package com.keepon.kotlin.chapter10;

import java.util.ArrayList;
import java.util.List;

import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/**
 * createBy	 keepon
 */
public class JavaCallKotlin {
    public void javaCallKotlin(){
        List<String> strings = new ArrayList();
        strings.add("42");
//        在Java中可以很容易地使用Kotlin标准库中以lambda作为参数的扩展函数，但是必须要 显示地传递一个接收者作为第一个参数：
        CollectionsKt.forEach(strings, s -> {
            System.out.println(s);
            return Unit.INSTANCE;
        });
    }
//    在Java中，函数或者lambda可以返回Unit。但因为在Kotlin中Unit类型是有一个值的，所以需要显示地返回它。一个返回void的lambda不能作为返回Unit的函数类型的实参，
//    就像之前的例子中的(String) -> Unit。


}
