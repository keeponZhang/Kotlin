package com.michael.databindingdemo.includelayout;

import android.os.Bundle;

import com.michael.databindingdemo.model.Book;
import com.zhang.jetpacksample.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

/**
 * 演示布局嵌套的绑定
 * */
public class IncludeLayoutActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ActivityIncludeLayoutBinding activityIncludeLayoutBinding = DataBindingUtil.setContentView(this, R.layout.activity_include_layout);
        Book book = new Book("Android高性能编程", "叶坤");
        activityIncludeLayoutBinding.setBook(book);
    }
}
