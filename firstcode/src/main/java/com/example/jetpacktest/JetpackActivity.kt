package com.example.jetpacktest

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.zhang.firstcode.R
import kotlinx.android.synthetic.main.activity_main_jetpacktest.*
import kotlin.concurrent.thread

class JetpackActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_jetpacktest)
        lifecycle.addObserver(MyObserver())
        val myObserver2 = MyObserver2(lifecycle)
        myObserver2.lifecycle.currentState
        lifecycle.addObserver(myObserver2)
        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reserved", 0)
        //这里应该是
        viewModel = ViewModelProviders.of(this, MainViewModelFactory(countReserved))
                .get(MainViewModel::class.java)
        plusOneBtn.setOnClickListener {
            viewModel.plusOne()
        }
        clearBtn.setOnClickListener {
            viewModel.clear()
        }
        //被动更新
        viewModel.counter.observe(this, Observer { count ->
            infoText.text = count.toString()
        })
//        viewModel.counter.observe(this) { count ->
//            infoText.text = count.toString()
//        }



//        viewModel.user.observe(this, Observer
//        { user ->
//            infoText.text = user.firstName
//        })

        val userDao = AppDatabase.getDatabase(this).userDao()
        val user1 = User("Tom", "Brady", 40)
        val user2 = User("Tom", "Hanks", 63)
        addDataBtn.setOnClickListener {
            thread {
                user1.id = userDao.insertUser(user1)
                user2.id = userDao.insertUser(user2)
            }
        }


       //switchMap
        registUser.setOnClickListener {
            viewModel.user
                    .observe(this, Observer
                    { user ->
                        infoText.text = user.firstName
                    })
        }
        changeUserId.setOnClickListener {
            val userId = (0..10000).random().toString()
            viewModel.changeUserId(userId)
        }


        //map
        registerUserNameBtn.setOnClickListener {
            viewModel.userName.observe(this, Observer
            { name ->
                Log.e("TAG", "JetpackActivity onCreate $name:");
            })
        }

        changeUser.setOnClickListener {
            viewModel.changeUser(System.currentTimeMillis())
        }
        updateDataBtn.setOnClickListener {
            thread {
                user1.age = 42
                userDao.updateUser(user1)
            }
        }
        deleteDataBtn.setOnClickListener {
            thread {
                userDao.deleteUserByLastName("Hanks")
            }
        }
        queryDataBtn.setOnClickListener {
            thread {
                for (user in userDao.loadAllUsers()) {
                    Log.d("MainActivity", user.toString())
                }
            }
        }
        doWorkBtn.setOnClickListener {
            val request = OneTimeWorkRequest.Builder(SimpleWorker::class.java).build()
            WorkManager.getInstance(this).enqueue(request)
        }
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt("count_reserved", viewModel.counter.value ?: 0)
        }
    }
}
