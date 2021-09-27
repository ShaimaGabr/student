package com.example.studentes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.studentes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var backPressedTime: Long = 0

    lateinit var nav:NavController
   // lateinit var nav: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
       binding= DataBindingUtil.setContentView(this, R.layout.activity_main)
       nav= Navigation.findNavController(this, R.id.nav_host_fragment)

       binding.bottomNavigation.add(MeowBottomNavigation.Model(0, R.drawable.ic_baseline_crop_free_24))
       binding.bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_baseline_emoji_people_24))
       binding.bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.ic_baseline_home_24))
       binding.bottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.ic_baseline_facebook_24))
       binding.bottomNavigation.add(MeowBottomNavigation.Model(4, R.drawable.itgat))
       binding.bottomNavigation.show(2)
       binding.bottomNavigation.setOnClickMenuListener {
           when(it.id){
               2 -> {
                   nav.popBackStack(R.id.welcome, false)
               }
               0 -> {
                   nav.popBackStack(R.id.welcome, false)
                   nav.navigate(R.id.action_welcome_to_attendance2)
               }
               3 -> {
                   nav.popBackStack(R.id.welcome, false)
                   nav.navigate(R.id.action_welcome_to_face2)
               }
               4 -> {
                   nav.popBackStack(R.id.welcome, false)
                   nav.navigate(R.id.action_welcome_to_wepsit2)
               }
               1 -> {
                   nav.popBackStack(R.id.welcome, false)
                   nav.navigate(R.id.action_welcome_to_profildiploma)
               }

           }}}

    override fun onStart() {
        super.onStart()
        val pref= getSharedPreferences("PREFS_NAME", MODE_PRIVATE)
        val name=pref.getString("NAME", null)
        // Toast.makeText(context,"Welcome"+name,Toast.LENGTH_SHORT).show()
        if (name==null){
            val intent= Intent(this, MainActivity2::class.java)

            startActivity(intent)
        }else{

        }
    }

}
