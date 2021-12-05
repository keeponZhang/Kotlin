package com.example.jetpacktest.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.zhang.firstcode.databinding.ActivityTestBinding

/**
 * createBy	 keepon
 */

class TestActivity : AppCompatActivity() {

    val viewModel by viewModel { DataViewModel(1) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflate = ActivityTestBinding.inflate(LayoutInflater.from(this))
        viewModel.apply {
            requestData(1).observe(this@TestActivity,
                    Observer { inflate.test.text = it })
        }
    }
}
