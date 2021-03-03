package com.kotlin.action.ch02;

import ch02.person.Person;
import cn.kotliner.kotlin.collections.KotlinMainKt;
import cn.kotliner.kotlin.collections.Test;

/* Java */

public class PersonUsage {
    public static void main(String[] args) {
        Person person = new Person("Bob", true);
        System.out.println(person.getName());
        System.out.println(person.isMarried());
        Test.INSTANCE.getList();
        Test.INSTANCE.test();
    }
}
