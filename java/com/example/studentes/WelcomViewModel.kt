package com.example.studentes

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation

class WelcomViewModel:ViewModel() {

    fun attend(view:View){
        Navigation.findNavController(view).navigate(R.id.action_welcome_to_attendance2)
    }
    fun profil(view:View,context: Context){
        val pref= context.getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE)
        val stat=pref.getString("STAT", null)
       if(stat=="COURSE"){
       // Toast.makeText(context,stat,Toast.LENGTH_SHORT).show()
        Navigation.findNavController(view).navigate(R.id.action_welcome_to_profil)
        }
        else{
            Navigation.findNavController(view).navigate(R.id.action_welcome_to_profildiploma)
        }
    }
    fun face(view:View){
        Navigation.findNavController(view).navigate(R.id.action_welcome_to_face2)
    }
    fun wep(view:View){
        Navigation.findNavController(view).navigate(R.id.action_welcome_to_wepsit2)
    }
    val webViewUrl = MutableLiveData<String>("https://www.facebook.com/ITGateAcademy/")

    val webViewUrlTwo = MutableLiveData<String>("https://www.itgateacademy.com/index.php")
    fun notifcation(view: View){
        Navigation.findNavController(view).navigate(R.id.action_welcome_to_notification)
    }
}