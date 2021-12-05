package com.example.jetpacktest.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.zhang.firstcode.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 * createBy	 keepon
 */
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel { ViewModelLayer(10086) }
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.result.observe(this, Observer {
            binding.test.text = it.toString()
        })
    }
}

data class DataModel(val code: Int, val message: String = "") {
    override fun toString(): String = "Data----$code Msg----$message"
}

object RepositoryLayer {
    suspend fun getSomeData(id: Int): DataModel = withContext(Dispatchers.IO) {
        delay(2000)
        DataModel(200, "Result$id")
    }
}

class ViewModelLayer(private val id: Int) : ViewModel() {
    val result = liveData {
        try {
            emit(DataModel(0, "!!Loading!!"))
            emit(RepositoryLayer.getSomeData(id))
        } catch (e: Exception) {
            emit(DataModel(-1, "error"))
        }
    }
}
