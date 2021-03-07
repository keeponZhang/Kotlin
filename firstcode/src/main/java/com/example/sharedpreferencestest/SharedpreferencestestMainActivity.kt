package com.example.sharedpreferencestest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.putString
import android.util.Log
import androidx.core.content.edit
import com.zhang.firstcode.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_sharedpreferencestest.*

class SharedpreferencestestMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_sharedpreferencestest)
        saveButton.setOnClickListener {
            getSharedPreferences("data", Context.MODE_PRIVATE).edit {
                putString("name", "Tom")
                putInt("age", 28)
                putBoolean("married", false)
            }

            getSharedPreferences("data", Context.MODE_PRIVATE).open {
                putString("name", "Tom")
                putInt("age", 28)
                putBoolean("married", false)
            }
        }
        restoreButton.setOnClickListener {
            val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
            val name = prefs.getString("name", "")
            val age = prefs.getInt("age", 0)
            val married = prefs.getBoolean("married", false)
            Log.d("MainActivity", "name is $name")
            Log.d("MainActivity", "age is $age")
            Log.d("MainActivity", "married is $married")
        }
    }

}