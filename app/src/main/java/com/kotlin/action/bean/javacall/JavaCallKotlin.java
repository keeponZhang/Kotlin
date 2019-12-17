package com.kotlin.action.bean.javacall;

import ch02.ex2_2_CustomAccessors.Rectangle;
import ch02.person.Person;

/**
 * createBy keepon
 */
public class JavaCallKotlin {
    public static void main(String[] args) {
        // test1();
        test2();
    }

    private static void test2() {
        Rectangle rectangle = new Rectangle(41, 43);
        System.out.println(rectangle.isSquare());
    }

    private static void test1() {
        Person person = new Person("Bob", true);
        System.out.println(person.getName());
        //boolean类型方法是直接字段加括号
        System.out.println("JavaCallKotlin main " + person.isMarried());
    }

}
