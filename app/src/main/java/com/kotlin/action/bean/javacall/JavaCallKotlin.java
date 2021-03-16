package com.kotlin.action.bean.javacall;

import com.kotlin.action.bean.Animal;
import com.kotlin.action.bean.Button;
import com.kotlin.action.bean.Dog;
import com.kotlin.action.bean.interfaces.JavaInterface;
import com.kotlin.action.bean.interfaces.State;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import ch02.ex2_2_CustomAccessors.Rectangle;
import ch02.person.Person;
import ch03.ex3_3_3_6_properties._3_3_3_6_propertiesKt;
import ch03.ex3_3_3_UtilityFunctionsAsExtensions2._3_3_3_3_UtilityFunctionsAsExtensions2Kt;
import ch03.ex3_3_5_UtilityFunctionsAsExtensions4.StringFunctions;
import ch03.ex3_strings._3_3_ExtensionsKt;
import ch03.exUtilityFunctionsAsExtensions3_3_3_4._3_3_3_4_UtilityFunctionsAsExtensions3Kt;
import ch04.ex4_1_1_ObjectDeclarations.CaseInsensitiveFileComparator;
import ch06.ex2_1_PrimitiveTypes.NullableStringPrinter;
import ch06.ex2_1_PrimitiveTypes.StringPrinter;
import ch07.ex1_2_1_CompoundAssignmentOperators.Point;

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
        // test8();
        //  test9();
        // test10();
        // test11();
        test12();
    }

    private static void test12() {
        //java 调用kotlin方法，要注意kotlin是否非空，调用时，kotlin如果是非空类型，转换成java会加上@NotNull注解
        // StringPrinter stringPrinter = new StringPrinter("keepon");
        // NullableStringPrinter nullableStringPrinter = new NullableStringPrinter();
        // //这里会报错，生成的字节码会加上@NotNull的注解
        // nullableStringPrinter.process(null);
        // stringPrinter.process(null);
        Point point = new Point(1, 2);
    }

    private static void test11() {
        Person person = new Person("keepon", false);
        //匿名内部类访问局部变量，局部变量需要用final修饰
        final int count = 3;
        testJavaInterface(new JavaInterface() {
            @Override
            public void interfaceTest() {
                person.getName();
                System.out.println("JavaCallKotlin interfaceTest "+count);
                // count++;
            }
        });
        // count++;
    }

    private static void testJavaInterface(JavaInterface javaInterface) {

    }

    private static void test10() {
        ch04.ex4_2_2_CompanionObjects2.Person.Loader.fromJson("keepon");
        //JvmStatic注解的才
        // ch04.ex4_2_2_CompanionObjects2. Person.fromJSON("");
        // ch04.ex4_2_2_CompanionObjects2_2.Person4.fromJSON4("");
    }

    private static void test9() {
        // Java 中使用Kotlin对象 ,Kotlin 中的对象声明被编译成了通过静态字段来持有它的单一实例的类，
        // 这个字段名字始终都是INSTANCE 。如果在Java 中实现羊例模式，你也许也会
        // 顺手做同样的事。因此，要从Java 代码使用Kotlin 对象，可以通过访问静态的 INSTANCE 字段：
        File filel = new File("keepon");
        File file2 = new File("keepon2");
        CaseInsensitiveFileComparator.INSTANCE.compare(filel, file2);
    }

    private static void test8() {
        Button button = new Button();
        State state = button.restorState();
        try {
            setSharedSerializable("keepon0", state);
        } catch (Exception e) {
            e.printStackTrace();
        }
        State currentState = button.getCurrentState();
        //java.io.NotSerializableException: com.kotlin.action.bean.Button
        try {
            setSharedSerializable("keepon", currentState);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void setSharedSerializable(String key, Serializable value) throws IOException {
        File f = new File("D:/test");
        if (!f.exists()) {
            f.mkdir();
        }
        File file = new File(f, key);
        if (!file.exists()) {
            file.createNewFile();
        }
        setSerializableObject((File) f, value);
    }

    public static void setSerializableObject(File file, Object value) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(value);
        out.flush();
        out.close();
    }

    private static void test7() {
        System.out.println("12.345-6.A".split(".").length); //0 这里点号（．）是表示任何字符的正则表达式。
        System.out.println("12.345-6.A".split("34").length);
    }

    private static void test6() {
        Animal animal = new Dog("jim");
        System.out.println("JavaCallKotlin test6 " + animal.getStaticName());

    }

    // 实质上，扩展函数是静态函数，它把调用对象作为了它的第一个参数。调用扩
    // 展函数，不会创建适配的对象或者任何运行时的额外消耗。
    private static void test5() {
        System.out.println("JavaCallKotlin test5 " + _3_3_ExtensionsKt.lastChar("this"));
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
