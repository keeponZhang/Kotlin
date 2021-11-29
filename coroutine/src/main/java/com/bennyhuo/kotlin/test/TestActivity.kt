package com.bennyhuo.kotlin.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bennyhuo.kotlin.coroutines.android.databinding.ActivityTestBinding
import com.bennyhuo.kotlin.coroutines.delay
import com.bennyhuo.kotlin.coroutines.launch
import com.bennyhuo.kotlin.coroutines.scope.GlobalScope
import com.bennyhuo.kotlin.coroutines.utils.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.withContext

/**
 * createBy	 keepon
 */
class TestActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflate = ActivityTestBinding.inflate(layoutInflater)
        setContentView(inflate.root)
        inflate.test.setOnClickListener {
            test1()
        }
    }

    private fun test1() {
        val job = GlobalScope.launch(Dispatchers.Main) {
            log("日志1")
            log("日志1.2")
            //        val result = hello4()
            withContext(Dispatchers.IO) {
                log("日志1.3")
            }
            //        这里基本不会执行到
            log("日志2", "5")
            delay(2000)
            log("日志3")
        }
        log(job.isActive)
        //    cancel就进入join的状态
        //    job.cancel()
        log("日志4")
    }

    val test2 = test2()
    private fun test2(): Boolean {
        return false
    }

    private val scope = MainScope()

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}
