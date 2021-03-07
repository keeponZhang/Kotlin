package com.example.broadcastbestpractice

import android.content.Intent
import android.os.Bundle
import com.zhang.firstcode.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_broadcastbestpractice.*

class BroadcastbestpracticeMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_broadcastbestpractice)
        force_offline.setOnClickListener {
            val intent = Intent("com.example.broadcastbestpractice.FORCE_OFFLINE")
            intent.setPackage(packageName)
            sendBroadcast(intent)
        }
    }

}