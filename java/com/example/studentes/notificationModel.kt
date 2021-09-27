package com.example.studentes

class notificationModel : ArrayList<notificationModelItem>()

data class notificationModelItem(
    val `0`: String,
    val `1`: String,
    val `2`: String,
    val course_id: String,
    val id: String,
    val message: String
)