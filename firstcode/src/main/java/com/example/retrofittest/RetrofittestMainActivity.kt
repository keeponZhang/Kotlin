package com.example.retrofittest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.coroutineScope
import com.zhang.firstcode.R
import kotlinx.android.synthetic.main.activity_main_retrofittest.*
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.coroutineContext

class RetrofittestMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_retrofittest)
        getAppDataBtn.setOnClickListener {
            val appService = ServiceCreator.create<AppService>()
            appService.getAppData().enqueue(object : Callback<List<App>> {
                override fun onResponse(call: Call<List<App>>, response: Response<List<App>>) {
                    val list = response.body()
                    if (list != null) {
                        for (app in list) {
                            Log.d("MainActivity", "id is ${app.id}")
                            Log.d("MainActivity", "name is ${app.name}")
                            Log.d("MainActivity", "version is ${app.version}")
                        }
                    }
                }

                override fun onFailure(call: Call<List<App>>, t: Throwable) {
                    t.printStackTrace()
                }
            })
        }
        lifecycle.coroutineScope.launch {
//            这种类型的架构，使得等待调用的结果变得更加容易。然而，由于协程的结构化并发，如果不能被取消，deferred可能会导致内存泄露。所以，确保CompletableDeferred被正确取消的最简单的方法是将它与它的parent job绑定。
            val appService = ServiceCreator.create<AppService>()
            val call: Call<List<App>> = appService.getAppData()
            val deferred = CompletableDeferred<List<App>>(coroutineContext[Job])
            call.enqueue(object : Callback<List<App>> {
                override fun onResponse(call: Call<List<App>>, response: Response<List<App>>) {
                    response.body()?.let { deferred.complete(it) }
                }

                override fun onFailure(call: Call<List<App>>, t: Throwable) {
                    deferred.completeExceptionally(t)
                }
            })
            val await = deferred.await()

//            尽管对于理解上下文的构成很有趣，但这个例子在实践中完全没有用处。我们可以通过将启动的上下文参数保留为默认的空值来获得完全相同的行为。
            val inheritedContext = sequenceOf(
                    Job,
                    ContinuationInterceptor,
                    CoroutineExceptionHandler,
                    CoroutineName
            ).mapNotNull { key -> coroutineContext[key] }
                    .fold(EmptyCoroutineContext) { ctx: CoroutineContext, elt ->
                        ctx + elt
                    }
            launch(inheritedContext) {
                /* ... */
            }


            GlobalScope.launch(Dispatchers.Main) {
                val deferred = async {
                    /* ... */
                }
                /* ... */
            }
//            鉴于async是在作用域上调用的（而不是一个顶级函数），它将继承作用域的dispatcher，这里被指定为Dispatchers.Main，而不是使用默认的dispatcher。在以前的coroutines版本中，async中的代码将在Dispatchers.Default提供的工作线程上运行，但现在它将在UI线程上运行，这可能导致应用程序阻塞甚至崩溃。
            launch(Dispatchers.Main) {
                val deferred = async(Dispatchers.Default) {
                    /* ... */
                }
                /* ... */
            }
        }
    }
}


