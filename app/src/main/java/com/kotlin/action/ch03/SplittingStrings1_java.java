package com.kotlin.action.ch03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplittingStrings1_java {
    public static void main(String... args) {
        // System.out.println("12.345-6.A".split("."));
        // test0();


        // test();

        // test(test1, test2, test3);
        // test2();
        // test3();
        // test4();
        // test5();
        test6();
    }

    private static void test6() {
        Pattern pattern = Pattern.compile("Java");
        String test = "JavaJava";
        Matcher matcher = pattern.matcher(test);
        System.out.println(matcher.replaceAll("Python"));//返回PythonPython
        System.out.println(matcher.replaceFirst("python"));//返回PythonJava
    }

    private static void test5() {
        Pattern pattern = Pattern.compile("Java");
        String test = "Java";
        Matcher matcher = pattern.matcher(test);

        matcher.find();
        System.out.println(matcher.group());//返回Java

        matcher.reset();//从起始位置重新匹配

        matcher.find();
        System.out.println(matcher.group());//返回Java

        matcher.reset("Python");
        System.out.println(matcher.find());//返回false
    }

    private static void test4() {
        Pattern pattern = Pattern.compile("Java");
        // String test = "123JavaJava";
        String test = "123JavaJbava";
        Matcher matcher = pattern.matcher(test);
        matcher.region(7, 11);
        System.out.println(matcher.regionStart());//返回7
        System.out.println(matcher.regionEnd());//返回11
        matcher.find();
        System.out.println(matcher.group());//返回Java
    }

    private static void test3() {
        // Matcher类提供了start(int gropu)，end(int group)，group(int i)，groupCount()用于分组操作
        // Pattern pattern = Pattern.compile("(Java)(Pyt1hon)");
        Pattern pattern = Pattern.compile("Java");
        String test = "123JavaPython456";
        Matcher matcher = pattern.matcher(test);
        matcher.find();
        System.out.println(matcher.groupCount());//返回2

        System.out.println(matcher.group(1));//返回第一组匹配到的字符串"Java"，注意起始索引是1
        System.out.println(matcher.start(1));//返回3，第一组起始索引
        System.out.println(matcher.end(1));//返回7 第一组结束索引

        System.out.println(matcher.group(2));//返回第二组匹配到的字符串"Python"
        System.out.println(matcher.start(2));//返回7，第二组起始索引
        System.out.println(matcher.end(2));//返回13 第二组结束索引
    }

    private static void test2() {
        // Matcher类提供了start()，end()，group()分别用于返回字符串的起始索引，结束索引，以及匹配到到的字符串。
        Pattern pattern = Pattern.compile("Java");
        String test = "123Java456";

        Matcher matcher = pattern.matcher(test);
        matcher.find();
        System.out.println(matcher.start());//返回3
        System.out.println(matcher.end());//返回7
        System.out.println(matcher.group());//返回Java
    }

    private static void test() {
        String test1 = "Java";
        String test2 = "Java1234";
        String test3 = "1234Java";
        // Pattern类也自带一个静态匹配方法matches(String regex, CharSequence input)，但只能进行全字符串匹配并且只能返回是否匹配上的boolean值
        //里面也会用到Pattern.compile
        // System.out.println(Pattern.matches("Java",test1));//返回true
        // System.out.println(Pattern.matches("Java",test2));//返回false
    }

    private static void test0() {
        // Pattern pattern = Pattern.compile("Java");
        // System.out.println(pattern.pattern());//返回此模式的正则表达式即Java

        // Pattern pattern = Pattern.compile("Java");
        String test="123Java456Java789Jdava";
        // String[] result = pattern.split(test);
        //输出结果123
        // 456
        // 789Jdava
        // String[] result = pattern.split(test,2);
        //输出结果123
        // 456Java789Jdava
        // String[] result = pattern.split(test,-2);//负数也不显示
        // for(String s : result)
        //     System.out.println(s);
    }

    private static void test(String test1, String test2, String test3) {
        Pattern pattern = Pattern.compile("Java");
        // 最后就要过渡到Matcher类了，Pattern类中的matcher(CharSequence input)会返回一个Matcher对象。
        //注意，matcher后面的输入参数
        Matcher matcher = pattern.matcher(test1);
        // Matcher类提供了三个返回boolean值得匹配方法：matches()，lookingAt()，find()，find(int start)，其中matches()用于全字符串匹配，
        // lookingAt从字符串最开头开始匹配满足的子串，find可以对任意位置字符串匹配,其中start为起始查找索引值。
        System.out.println(matcher.matches());//返回true
        matcher = pattern.matcher(test2);
        System.out.println(matcher.matches());//返回false

        matcher = pattern.matcher(test2);
        System.out.println(matcher.lookingAt());//返回true
        matcher = pattern.matcher(test3);
        System.out.println(matcher.lookingAt());//返回false

        matcher = pattern.matcher(test1);
        System.out.println(matcher.find());//返回true
        matcher = pattern.matcher(test2);
        System.out.println(matcher.find());//返回true
        matcher = pattern.matcher(test3);
        System.out.println(matcher.find(2));//返回true
        matcher = pattern.matcher(test3);
        System.out.println(matcher.find(5));//返回false
    }
}

