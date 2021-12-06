package com.michael.lifecycleservicedemo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.zhang.jetpacksample.R;

public class ServiceActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        findViewById(R.id.btnStartService).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ServiceActivity.this, MyService.class);
                startService(intent);
            }
        });

        findViewById(R.id.btnStopService).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ServiceActivity.this, MyService.class);
                stopService(intent);
            }
        });
    }
}
