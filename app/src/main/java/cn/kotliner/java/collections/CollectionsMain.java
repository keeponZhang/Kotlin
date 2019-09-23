package cn.kotliner.java.collections;

import cn.kotliner.kotlin.collections.Test;

/**
 * Created by benny on 5/30/17.
 */
public class CollectionsMain {
    public static void main(String... args) {
        //这个会报错
        Test.INSTANCE.getList().add(4);
    }
}
