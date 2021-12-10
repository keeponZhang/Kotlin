package com.michael.roommigrationdemo;

import android.os.Bundle;

import com.michael.roommigrationdemo.database.MyDatabase;
import com.zhang.jetpacksample.R;

import androidx.appcompat.app.AppCompatActivity;

public class RoomMigrationMainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_migration_main);
        MyDatabase.getInstance(this);
    }
}
