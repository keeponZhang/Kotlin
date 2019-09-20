package net.println.kotlin.chapter4.innerclass;

/**
 * Created by benny on 4/4/17.
 */
public class InnerClassJava {
    private int a;

    public class Inner{
        public void hello(){
            System.out.println(InnerClassJava.this.a);
        }
    }
    public static  class StaticInner{

    }
    public static void main(String... args) {
        //直接new会报错，因为非静态内部类持有外部类的引用
//        new Inner();
        //这个new方法相当于类方法
        Inner inner = new InnerClassJava().new Inner();
        InnerClassJava innerClassJava = new InnerClassJava();

        //静态内部类可以随便new，跟外部类没有关系
        StaticInner staticInner = new StaticInner();

        View view = new View();
        //实现了OnClickListener接口的匿名内部类实例
        view.setOnClickListener(new OnClickListener() {
            public void onClick() {

            }
        });
    }
}
