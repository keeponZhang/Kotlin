package com.kotlin.action.bean.javacall;

import java.util.ArrayList;

import ch02.ex2_2_CustomAccessors.Rectangle;
import ch02.person.Person;
import ch03.ex3_3_3_UtilityFunctionsAsExtensions2._3_3_3_3_UtilityFunctionsAsExtensions2Kt;
import ch03.ex3_3_4_UtilityFunctionsAsExtensions3._3_3_3_4_UtilityFunctionsAsExtensions3Kt;

/**
 * createBy keepon
 */
public class JavaCallKotlin {
    public static void main(String[] args) {
        // test1();
        // test2();
        test3();
    }

    private static void test3() {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            integers.add(i);
        }
        System.out.println("JavaCallKotlin test3 "+_3_3_3_3_UtilityFunctionsAsExtensions2Kt.joinToString(integers, ",", "(",")"));
        // 如果需要从Java 代码中做频繁的调用，而且希望
        // 它能对Java 的调用者更简便，可以用＠ JvmOverloads 注解它。这个指示编译
        // 器生成Java 重载函数，从最后一个开始省略每个参数。
        System.out.println("JavaCallKotlin test3 "+
                _3_3_3_4_UtilityFunctionsAsExtensions3Kt.joinToString(integers ));

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
