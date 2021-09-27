package com.example.studentes

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.icu.text.SimpleDateFormat
import android.location.Location
import android.location.LocationManager
import android.telephony.TelephonyManager
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import java.util.*

class LocationViewModel:ViewModel() {
    var inseert=MutableLiveData<String>("")
    var GpsStatus = false
    fun location(context: Context,requir:Activity){


        //////////////////////////
        fun checkGpsStatus() : Boolean {
            if( ActivityCompat.checkSelfPermission(context,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(requir, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),1)
            }

            ///////////////
            val locationManager: LocationManager = requir.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            GpsStatus = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
            return GpsStatus
        }

            // /////////////////////////////////////around_place///////////////////////////////////////////////////////////
            if(checkGpsStatus()){
              var  fusedLocationClient=   LocationServices.getFusedLocationProviderClient(requir)
                if (ActivityCompat.checkSelfPermission(
                        context,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        context,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    return
                }
                fusedLocationClient.lastLocation
                    .addOnSuccessListener { location : Location? ->
                        try {
                            val startPoint = Location("IT-GATE")
                            startPoint.latitude = 30.0645317
                            startPoint.longitude = 31.3288259

                            val endPoint = Location("User Location")
                            endPoint.latitude = location!!.latitude
                            endPoint.longitude = location.longitude

                            val distance: Float = startPoint.distanceTo(endPoint)
                            Log.i("Distance", distance.toString())
                            if (distance > 100)
                                Toast.makeText(
                                    context, "You Need To Scan Inside IT-Gate Center",
                                    Toast.LENGTH_SHORT
                                ).show()
                            else {
                                //TODO here we need to call api
                    Toast.makeText(context,"Done",Toast.LENGTH_SHORT).show()
                    insert(context)
                                Toast.makeText(context, inseert.toString(),Toast.LENGTH_SHORT).show()
                            }
                        }catch (e:Exception){
                            Toast.makeText(context,"no GPS Recover",Toast.LENGTH_SHORT).show()
                        }
                    }

            }else{
                Toast.makeText(context, "You need to open GPS first ", Toast.LENGTH_SHORT).show()
            }
            //////////////////////////////////////////// end_around_place///////////////////////////////////////////////////

        }
    @SuppressLint("NewApi")
    fun insert(context: Context){
        val date= SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        val pref= context.getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE)
        val stat=pref.getString("STAT", null)
        val coid=pref.getString("COURSE_ID", null)
        val stuid=pref.getString("STUDENT_ID", null)
        if(stat=="COURSE"){
            CoroutineScope(Dispatchers.IO).async {
                val response            =ConnectionAttendance.Retrofit_connection().scanCourse(stuid!!,date,
                    coid!!
                )
                CoroutineScope(Dispatchers.Main).async {
                    if(response.isSuccessful){
                       // newsList.value=response.body()!!.articles
                        inseert.value=response.body()!!.response
                    }else{
                        Toast.makeText(context,"failed${response.message()}",Toast.LENGTH_SHORT).show()
                    }

                }
            }

        }else{
            CoroutineScope(Dispatchers.IO).async {
                val response            =ConnectionAttendance.Retrofit_connection().scandiploma(stuid!!,date)
                CoroutineScope(Dispatchers.Main).async {
                    if(response.isSuccessful){
                        // newsList.value=response.body()!!.articles
                        inseert.value=response.body()!!.response
                    }else{
                        Toast.makeText(context,"failed${response.message()}",Toast.LENGTH_SHORT).show()
                    }

                }
            }

        }

    }



}