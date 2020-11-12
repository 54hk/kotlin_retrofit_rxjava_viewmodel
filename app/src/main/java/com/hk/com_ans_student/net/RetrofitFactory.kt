package com.hk.com_ans_student.net

import android.util.Log
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitFactory private constructor() {
    private val retrofit: Retrofit

    init {
        val gson = Gson().newBuilder().setLenient().serializeNulls().create()
        retrofit = Retrofit.Builder().baseUrl(ApiAddress.JOKE_BASE_URL)
            .client(initOkhttpClient()).addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    //  静态方法（同步）
    companion object {
        val instance: RetrofitFactory by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            RetrofitFactory()
        }
    }

    private fun initOkhttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS).addInterceptor(initLogInterceptor())
            .addInterceptor( CookieReadInterceptor ()).build()
        return okHttpClient
    }

    //日志拦截器
    private fun initLogInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.e("retrofit", message)
            }

        })
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    /**
     * 具体服务实例化
     */
    fun <T> getService(service: Class<T>): T {
        return retrofit.create(service)
    }

}