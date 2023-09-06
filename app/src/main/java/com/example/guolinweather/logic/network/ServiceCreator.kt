package com.example.guolinweather.logic.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private const val TAG = "ServiceCreator"
    private const val BASE_URL = "https://api.caiyunapp.com/"


     class LoggingIntercepter:Interceptor{
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            Log.e(TAG, String.format("===发起方========== %s %s %s",request.url(),chain.connection(),request.headers()))
            val response = chain.proceed(request)

            Log.e(TAG, String.format("====接收方========= %s %s",response.request().url(),response.headers()))
            return response
        }

    }

    val okHttpClient=OkHttpClient.Builder().addInterceptor(LoggingIntercepter())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    inline fun <reified T> create(): T = create(T::class.java)

}