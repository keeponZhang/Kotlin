package com.kotlin.action.bean;

/**
 * createBy keepon
 */
//java类不能用private修饰，kotlin是可以的
// private
public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }


    public static String getStaticName(){
        return "i am Animal";
    }
}
