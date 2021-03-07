package com.amgdeveloper.deliverydriver.data.server

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by amgdeveloper
 */
class DeliveryServer(baseUrl: String) {

    val okHttpClient = HttpLoggingInterceptor().run {
        level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(this).build()
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        //.client(okHttpClient)
        .build()

    var service: DeliveryService = retrofit.create(DeliveryService::class.java)

    private fun getHttpLoginInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        return interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY }
    }
}