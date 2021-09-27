package com.example.studentes

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface interfaceNotifi {
    @FormUrlEncoded
    @POST("fetchapi.php")
     fun notification(@Field("course_id")course_id:String):Call<notificationModel>
}