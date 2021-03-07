package com.example.activitytest;

import android.app.Activity;

public class JavaTest {

    public void invokeStaticMethod() {
        ActivityBox.INSTANCE.addActivity(new Activity());
        HelperKt.doSomething();
        //直接静态方法调用才需要 @JvmStatic
        Util.doAction2();
        // Util.doAction3();
    }

}
