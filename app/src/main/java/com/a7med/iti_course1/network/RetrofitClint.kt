package com.a7med.iti_course1.network

import com.a7med.iti_course1.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClint {

    fun getRetrofit():ApiInterface{

        var interceptor =HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        var okHttp =OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit:Retrofit=Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp)
            .build()

        return retrofit.create(ApiInterface::class.java)




         }


}