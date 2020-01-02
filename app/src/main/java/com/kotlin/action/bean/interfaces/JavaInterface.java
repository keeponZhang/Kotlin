package com.kotlin.action.bean.interfaces;

/**
 * createBy keepon
 */
public interface JavaInterface {
    //java 接口方法如果有默认实现就要加default关键字，kotlin不用，kotlin是支持有默认方法实现的
    default void interfaceTest(){
        System.out.println("JavaInterface interfaceTest ");
    }
    //java 接口是可以有属性的，但是是final类型的，kotlin与有属性，子类必须重写改属性
    public final boolean istest = true;
}
