package com.example.jetpacktest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.bennyhuo.kotlin.coroutines.utils.log
import org.omg.PortableInterceptor.Interceptor
import retrofit2.converter.gson.GsonConverterFactory

/**
 * createBy	 keepon
 */
class DataViewModel2(val id: Int) : BaseViewModel() {

    val result = liveData {
        val response = RetrofitClient.getXXX.getXXX(1)
        if (response.isSuccess) {
            emit(response.data.toString())
        }
    }

}
