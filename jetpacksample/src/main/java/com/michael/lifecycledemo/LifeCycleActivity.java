package com.michael.lifecycledemo;

import android.os.Bundle;

import com.zhang.jetpacksample.R;

import androidx.appcompat.app.AppCompatActivity;

public class LifeCycleActivity extends AppCompatActivity {

    private MyLocationListener myLocationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_demo);
        myLocationListener = new MyLocationListener(this, new MyLocationListener.OnLocationChangedListener() {
            @Override
            public void onChanged(double latitude, double longitude) {
                // 展示收到的位置信息
            }
        });
        // 将观察者与被观察者绑定
        getLifecycle().addObserver(myLocationListener);
    }
}
