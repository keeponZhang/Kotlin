package com.kotlin.action.ch06;

import android.support.annotation.NonNull;

/* Java */
public class Person {
    // @NonNull
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
