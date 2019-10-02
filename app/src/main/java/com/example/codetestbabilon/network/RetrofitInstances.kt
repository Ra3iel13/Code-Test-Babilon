package com.example.codetestbabilon.network

import com.example.codetestbabilon.common.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstances {
    val retrofitInstances: Retrofit

        get() {
            val loggingInterceptor = HttpLoggingInterceptor()
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }
}