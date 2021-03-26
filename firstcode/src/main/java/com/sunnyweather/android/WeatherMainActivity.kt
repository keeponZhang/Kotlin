package com.sunnyweather.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.liveData
import com.zhang.firstcode.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class WeatherMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_sunnyweather)
    }
}
