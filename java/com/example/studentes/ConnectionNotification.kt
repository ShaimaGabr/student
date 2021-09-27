package com.example.studentes

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConnectionNotification {
    fun Retrofit_connection():interfaceNotifi{
        return Retrofit.Builder().baseUrl("http://192.168.1.250/")
            // .addConverterFactory(GsonConverterFactory.create()).build().create(InterfaceAttendance::class.java)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create())).build().create(interfaceNotifi::class.java)
        // .addConverterFactory(GsonConverterFactory.create()).build().create(interfacescan::class.java)
    }
}