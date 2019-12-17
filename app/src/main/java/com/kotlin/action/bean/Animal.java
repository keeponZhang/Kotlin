package com.kotlin.action.bean;

/**
 * createBy keepon
 */
public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }


    public static String getStaticName(){
        return "i am Animal";
    }
}
