package com.keepon.kotlin.chapter8;

/**
 * createBy	 keepon
 */
public class JavaCallKotlin {
    public static void main(String args[]){
        javaCallKotlin();
    }
    public static void javaCallKotlin(){
        Point point = new Point(1,3);
        Point point2 = new Point(3,1);

        String s = point + "";
        //用加号会报错
//        int i = point + point2;
        //java调用重载运算符需要放在类里面
        System.out.println("JavaCallKotlin javaCallKotlin " );
        point2.plus(point);

    }
    public  void kotlinCallJava(){

    }
}
