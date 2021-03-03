package com.keepon.kotlin.chapter2;

import java.util.Arrays;
import java.util.List;

/**
 * createBy	 keepon
 */
public class JavaCallKotlin {
    public void JavaCallKotlin(){
        //java调用顶层函数
        _3_3_顶层函数Kt.kotlinFunc();
        _3_3_顶层函数Kt.DINGCENGFUN();

        //java调用顶层属性
        _3_3_顶层属性Kt.getKotlinVal();

        _3_3_顶层属性Kt.setKotlinVar("keepon");
        _3_3_顶层属性Kt.getKotlinVar();
        String kontlinConst = _3_3_顶层属性Kt.kotlinConst;

        //在 Java 中使用扩展函数
        //接收者对象作为第一个参数(调用者作为参数传进去)
        char lastChar = _4_1_扩展函数的定义和使用Kt.lastChar("Java中使用扩展函数");
        System.out.println("JavaCallKotlin JavaCallKotlin "+lastChar);


    }

    public static void main(String[] args) {
        String[] strings = {"a", "b"};
        List<String> strings1 = Arrays.asList(strings);
        strings1.add("c");
    }

}




