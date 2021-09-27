package com.example.studentes

import android.content.Context
import android.graphics.ColorSpace
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileViewModel:ViewModel() {

    val name=MutableLiveData<String>("")
    val id=MutableLiveData<String>("")
    val img=MutableLiveData<String>(null)
    val vis=MutableLiveData<String>("")
    val stu_id=MutableLiveData<String>("")
    val course_id=MutableLiveData<String>("")
    val no=MutableLiveData<String>("NO ATTEND FOR THIS COURSE")
    fun information(context: Context){

        val pref= context.getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE)
         name.value=pref.getString("NAME", null)
        id.value=pref.getString("ID", null)
        stu_id.value=pref.getString("STUDENT_ID",null)
        course_id.value=pref.getString("COURSE_ID",null)

    }
    var newsList=MutableLiveData<List<AttendanceModelItem>>()
    var newsListo=MutableLiveData<List<ModelnameItem>>()
    var attend =MutableLiveData<List<DiplomaAttendItem>>()
    var noti =MutableLiveData<List<notificationModelItem>>()
    ///////////////////list artical such as model in Adapter
    ///////call api on response
    fun getdatafromserver(context:Context){

            CoroutineScope(Dispatchers.IO).async {
                val response            =ConnectionAttendance.Retrofit_connection().MyAttend(course_id.value!!,stu_id.value!!)
                CoroutineScope(Dispatchers.Main).async {
                    if(response.isSuccessful){
                        newsList.value=response.body()!!
                    }else{
                        Toast.makeText(context,"failed${response.message()}", Toast.LENGTH_SHORT).show()
                    }


            }}


    }
    fun name(valu:String){
        CoroutineScope(Dispatchers.IO).async {
            val response            =ConnectionAttendance.Retrofit_connection().diplomacon(valu)
            CoroutineScope(Dispatchers.Main).async {
                if(response.isSuccessful){
                    newsListo.value=response.body()!!
                }else{

                }


            }}

    }
    ////////////////////
    fun diplomaatte(){
        CoroutineScope(Dispatchers.IO).async {
            val response            =ConnectionAttendance.Retrofit_connection().diplomaAtend(stu_id.value!!)
            CoroutineScope(Dispatchers.Main).async {
                if(response.isSuccessful){
                    attend.value=response.body()!!
                }else{

                }


            }}
    }
    fun notification(context: Context){
//        CoroutineScope(Dispatchers.IO).async {
//            val response            =ConnectionNotification.Retrofit_connection().notification("11")
//            CoroutineScope(Dispatchers.Main).async {
//                if(response.isSuccessful){
//                    noti.value=response.body()!!
//                }else{
//
//                }
//
//
//            }}
        ConnectionNotification.Retrofit_connection().notification("11").enqueue(object :Callback<notificationModel>{
            override fun onResponse(
                call: Call<notificationModel>,
                response: Response<notificationModel>
            ) {
                Toast.makeText(context, response.body()!![0].message,Toast.LENGTH_SHORT).show()

            }

            override fun onFailure(call: Call<notificationModel>, t: Throwable) {
                Toast.makeText(context, t.message,Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun selectattcourse(id:String,context: Context){

        CoroutineScope(Dispatchers.IO).async {
            val response            =ConnectionAttendance.Retrofit_connection().diplomaAtendsom(stu_id.value!!,id)
            CoroutineScope(Dispatchers.Main).async {
                if(response.isSuccessful){
                    attend.value=response.body()!!
                }else{

                }


            }}
    }
}