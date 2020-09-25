package com.kotlin.action.ch04.java;

/**
 * createBy keepon
 */
class StaticTest {
    private StaticTest(){}
    private int outerAge;
    private static String sName;
    public void testInner(){
        Inner inner = new Inner();
        int innerAge = inner.innerAge;
    }
    public static class Inner{
        private int innerAge;
        public void test(){
            String a =   StaticTest.sName;
            // int b =   StaticTest.age;
            //即使是私有的也是可以访问，牛逼
            StaticTest staticTest= new StaticTest();
            //静态内部类创建的对象，居然可以访问他的私有变量
            int age = staticTest.outerAge;
        }
    }
}


