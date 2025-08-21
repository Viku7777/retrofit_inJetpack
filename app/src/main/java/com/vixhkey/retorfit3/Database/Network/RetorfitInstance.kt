package com.vixhkey.retorfit3.Database.Network

import com.vixhkey.retorfit3.Utils.AppUrls.AppUrls
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
//import okhttp3.logging.HttpLoggingInterceptor
//
//object NetworkModule {
//    fun client(): OkHttpClient {
//
//
//        return OkHttpClient.Builder()
//            .addInterceptor(logging)
//            .connectTimeout(30, TimeUnit.SECONDS)
//            .readTimeout(30, TimeUnit.SECONDS)
//            .writeTimeout(30, TimeUnit.SECONDS)
//            .build()
//    }
//}

object RetorfitInstance {
    val Api by lazy {
        Retrofit.Builder().baseUrl(AppUrls.baseUrlForPost).addConverterFactory(GsonConverterFactory.create()).build()
            .create(
            ApiServices::class.java)
    }

}