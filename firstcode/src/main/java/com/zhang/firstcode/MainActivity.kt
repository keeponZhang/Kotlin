package com.zhang.firstcode

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.bennyhuo.kotlin.coroutinebasics.utils.log
import com.zhang.firstcode.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
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
//            test1()
            test2()
        }
    }

    private fun test2() {
        GlobalScope.launch {
            log("日志0")
            //   1.开启协程，
//            testsuspend()
            testsuspend2()
//    日志4这里是跟日志2一个线程，因为这里没有恢复协程时，直接继续执行了
            com.bennyhuo.kotlin.coroutines.utils.log("日志4")
        }
    }
    private suspend fun testsuspend2() = withContext(Dispatchers.IO) {
        log("日志testsuspend2")
    }
    private suspend fun testsuspend() {
        val job = GlobalScope.launch {
            com.bennyhuo.kotlin.coroutines.utils.log("日志1")
            delay(1000)
            com.bennyhuo.kotlin.coroutines.utils.log("日志2")
        }
        com.bennyhuo.kotlin.coroutines.utils.log("日志job.isActive=${job.isActive}")
        //    cancel就进入join的状态
        //    job.cancel()
        com.bennyhuo.kotlin.coroutines.utils.log("准备调用join")
        job.join()
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
