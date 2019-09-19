package net.println.kotlin.chapter4;

import net.println.kotlin.chapter4.objects.MusicPlayer;

/**
 * Created by benny on 4/3/17.
 */
public class PersonJava {

    public void work(){

    }

    public static class MaNong extends PersonJava{

        public void work() {
            super.work();
        }
    }


    public static void main(String... args) {
        MusicPlayer.INSTANCE.getState();
    }
}
