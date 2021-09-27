package com.example.studentes

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ConnnectionSignin {
fun Retrofit_connection():InterfaceSignin{
    return Retrofit.Builder().baseUrl("https://www.itgateacademy.com/")
        .addConverterFactory(GsonConverterFactory.create()).build().create(InterfaceSignin::class.java)
                                         }
}