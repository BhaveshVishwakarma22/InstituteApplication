package com.lenovo.instituteapplication.api

import com.google.gson.Gson
import com.lenovo.instituteapplication.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

//    fun getInstance():Retrofit{
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }

    val api: SimpleApi by lazy{
        retrofit.create(SimpleApi::class.java)
    }

}