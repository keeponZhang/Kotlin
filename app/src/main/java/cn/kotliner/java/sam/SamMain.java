package cn.kotliner.java.sam;

import java.util.Observable;
import java.util.Observer;

import cn.kotliner.kotlin.sam.SAMInKotlin;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/**
 * Created by benny on 5/30/17.
 */
public class SamMain {
    public static void main(String... args) {
        SAMInKotlin samInKotlin = new SAMInKotlin();
        samInKotlin.addTask(new Function0<Unit>() {
            public Unit invoke() {
                return null;
            }
        });
        samInKotlin.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {

            }
        });
    }
}
