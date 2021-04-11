package com.bennyhuo.kotlin.advancedfunctions.sams;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaSams {

    public static void main(String... args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("run in executor.");
            }
        });

        //java方法支持
        executor.submit(() -> System.out.println("run in executor."));

        //抽象类不能sam
        submit(new Function() { // cannot sam.
            @Override
            void apply() {

            }
        });

        submit(() -> {

        });

        //kotlin方法
        KotlinSamsKt.submit(() -> {
            System.out.println("Hello");
        });
    }

    public static void submit(Function function){
        function.apply();
    }

    //kotlin解开也能sam
    public static void submit(Invokable invokable){
        invokable.invoke();
    }
}

abstract class Function {
    abstract void apply();
}