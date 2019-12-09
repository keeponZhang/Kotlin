package net.println.kotlin.chapter4;

/**
 * Created by benny on 4/4/17.
 */
public class StaticJava {
    public static void main(String... args) {
        Latitude latitude = Latitude.ofDouble(3.0);
        //会报错，因为没有 @JvmStatic
       // Latitude.ofLatitude(latitude);

        System.out.println(Latitude.TAG);
    }
}
