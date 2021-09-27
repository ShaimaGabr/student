package com.example.studentes

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConnectionAttendance {
    fun Retrofit_connection():InterfaceAttendance{
        return Retrofit.Builder().baseUrl("https://www.itgateacademy.com/")
               // .addConverterFactory(GsonConverterFactory.create()).build().create(InterfaceAttendance::class.java)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create())).build().create(InterfaceAttendance::class.java)
        // .addConverterFactory(GsonConverterFactory.create()).build().create(interfacescan::class.java)
    }
}