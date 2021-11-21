package com.zhang.firstcode

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.bennyhuo.kotlin.coroutinebasics.utils.log
import com.zhang.firstcode.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        binding.test.setOnClickListener {
            test1()
        }
    }

    private fun test1() {
        GlobalScope.launch {
            val job = GlobalScope.launch(Dispatchers.Main) {
                log("日志1")
                withContext(Dispatchers.IO) {
                    log("日志2")
                    hello15()
                }
                log("日志4")
            }
            job.join()
            log("日志5")
        }
    }

    suspend fun hello15() = suspendCoroutine<Int> {
        com.bennyhuo.kotlin.coroutines.utils.log("日志3")
        it.resume(10086)
    }
}
