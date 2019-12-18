package com.kotlin.action.bean.javacall;

import com.kotlin.action.bean.Animal;
import com.kotlin.action.bean.Button;
import com.kotlin.action.bean.Dog;
import com.kotlin.action.bean.interfaces.State;

import java.util.ArrayList;

import ch02.ex2_2_CustomAccessors.Rectangle;
import ch02.person.Person;
import ch03.ex3_3_3_6_properties._3_3_3_6_propertiesKt;
import ch03.ex3_3_3_UtilityFunctionsAsExtensions2._3_3_3_3_UtilityFunctionsAsExtensions2Kt;
import ch03.ex3_3_5_UtilityFunctionsAsExtensions4.StringFunctions;
import ch03.ex3_strings._3_3_ExtensionsKt;
import ch03.exUtilityFunctionsAsExtensions3_3_3_4._3_3_3_4_UtilityFunctionsAsExtensions3Kt;

/**
 * createBy keepon
 */
public class JavaCallKotlin {
    public static void main(String[] args) {
        // test1();
        // test2();
        // test3();
        // test4();
        // test5();
        // test6();
        // test7();
        test8();
    }

    private static void test8() {
        Button button = new Button();
        State currentState = button.getCurrentState();
    }

    private static void test7() {
        System.out.println("12.345-6.A".split(".").length); //0 这里点号（．）是表示任何字符的正则表达式。
        System.out.println("12.345-6.A".split("34").length);
    }

    private static void test6() {
        Animal animal = new Dog("jim");
        System.out.println("JavaCallKotlin test6 "  +animal.getStaticName());

    }

    // 实质上，扩展函数是静态函数，它把调用对象作为了它的第一个参数。调用扩
    // 展函数，不会创建适配的对象或者任何运行时的额外消耗。
    private static void test5() {
        System.out.println("JavaCallKotlin test5 "+ _3_3_ExtensionsKt.lastChar("this"));
    }

    private static void test4() {
        for (int i = 0; i < 5; i++) {
            _3_3_3_6_propertiesKt.performOperation();
            _3_3_3_6_propertiesKt.reportOperationCount();
        }

    }

    private static void test3() {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            integers.add(i);
        }
        System.out.println("JavaCallKotlin test3 " +
                _3_3_3_3_UtilityFunctionsAsExtensions2Kt.joinToString(integers, ",", "(", ")"));
        // 如果需要从Java 代码中做频繁的调用，而且希望
        // 它能对Java 的调用者更简便，可以用＠ JvmOverloads 注解它。这个指示编译
        // 器生成Java 重载函数，从最后一个开始省略每个参数。
        System.out.println("JavaCallKotlin test3 " +
                _3_3_3_4_UtilityFunctionsAsExtensions3Kt.joinToString(integers));
        System.out.println("JavaCallKotlin test3 " +
                StringFunctions.joinToString(integers));
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
