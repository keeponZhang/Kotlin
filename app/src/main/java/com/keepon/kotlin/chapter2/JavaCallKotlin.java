package com.keepon.kotlin.chapter2;

/**
 * createBy	 keepon
 */
public class JavaCallKotlin {
    public void JavaCallKotlin(){
        //java调用顶层函数
        _3_3_顶层函数Kt.kotlinFunc();

        //java调用顶层属性
        _3_3_顶层属性Kt.getKotlinVal();

        _3_3_顶层属性Kt.setKotlinVar("keepon");
        _3_3_顶层属性Kt.getKotlinVar();
        String kontlinConst = _3_3_顶层属性Kt.kotlinConst;
    }
}



