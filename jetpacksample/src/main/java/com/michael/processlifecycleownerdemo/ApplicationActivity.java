package com.michael.processlifecycleownerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zhang.jetpacksample.R;

import androidx.appcompat.app.AppCompatActivity;

public class ApplicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

        findViewById(R.id.btnToSecondActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ApplicationActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
