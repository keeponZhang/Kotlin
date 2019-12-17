package com.kotlin.action.bean;

/**
 * createBy keepon
 */
public class Person {
    public String getName() {
        return name;
    }

    private final String name;

    private Person( String name) {
        this.name = name;
    }

}
