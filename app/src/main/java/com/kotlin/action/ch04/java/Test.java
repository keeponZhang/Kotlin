package com.kotlin.action.ch04.java;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import ch04.ex2_1_InitializingClasses.User;

/**
 * createBy keepon
 */
class Test {
    public static void main(String[] args) {
        Animal animal = new  Animal();
        //同一个包里可以访问procted，这在kotlin是不行的
        String name = animal.name;
        File file = new File("button.out");

        ObjectOutputStream oout = null;
        try {
            oout = new ObjectOutputStream(new FileOutputStream(file));
            Button button = new Button();
            State currentState = button.getCurrentState();
            //java.io.NotSerializableException: com.kotlin.action.ch04.java.Button
            //这里会抛异常,虽然我们序列化的是currentState，currentState持有外部类Button的引用
            oout.writeObject(currentState);
        } catch (IOException e) {
                e.printStackTrace();
        }finally {
            try {
                oout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        // ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        // Object newPerson = oin.readObject(); // 没有强制转换到Person类型
        // oin.close();


    }
}
