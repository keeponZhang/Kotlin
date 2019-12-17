package com.kotlin.action.bean;

/**
 * createBy keepon
 */
public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public static String getStaticName(){
        return "i am Dog";
    }
}
