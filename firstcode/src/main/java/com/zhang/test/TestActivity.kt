package com.zhang.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bennyhuo.kotlin.coroutines.utils.log
import com.zhang.firstcode.databinding.ActivityTestBinding
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

/**
 * createBy	 keepon
 */
class TestActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflate = ActivityTestBinding.inflate(layoutInflater)
        setContentView(inflate.root)
        inflate.test.setOnClickListener {
//            testException1()
//            testException2()
//            testException3()
//            testException4()
            testException5()
        }
    }

    private fun testException1() {
        MainScope().launch {
            supervisorScope {
                val deferred = async {
                    throw Exception("test")
                }
                try {
                    deferred.await()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                log("end")
            }
        }
    }

    private fun testException2() {
//        这里try不住
        MainScope().launch {
            try {
                async {
                    throw Exception("test")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun testException3() {
//        这里try不住
        GlobalScope.launch {
            try {
                async {
                    log("begin")
                    throw Exception("test")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun testException4() {

        val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            log("xys", "---${coroutineContext}  ${throwable.printStackTrace()}")
        }
        MainScope().launch(exceptionHandler) {
            async {
                throw Exception("test")
            }
        }
    }
//    很遗憾，这样就不能捕获异常，因为CoroutineExceptionHandler属于异常抛出的协程，它本身无法处理
    private fun testException5() {
        val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            log("xys", "---${coroutineContext}  ${throwable.printStackTrace()}")
        }
        MainScope().launch() {
            async(exceptionHandler) {
                throw Exception("test")
            }
        }
    }

    private val scope = MainScope()

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}
