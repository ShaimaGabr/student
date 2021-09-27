package com.example.studentes

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface
InterfaceSignin {
    @FormUrlEncoded
    @POST("TGA/hr/studentt.php")
    suspend fun signin(@Field("user_name")user_name:String,@Field("user_ID")user_ID:String):Response<ModelSignin>
//    @GET("Api.php")
//    fun allemployee():Call<Model_employ>
}