package com.example.studentes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.studentes.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    var backPressedTime: Long = 0
    lateinit var bindig:ActivityMain2Binding
    val viewmodel : HomeViewmodel by viewModels()
    var list_of_items = arrayOf("DIPLOMA","COURSE")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main2)
        bindig= DataBindingUtil.setContentView(this,R.layout.activity_main2)
        bindig.lifecycleOwner=this
        bindig.viewModel=viewmodel
        /////////////////////////////////////
        viewmodel.interapp(this)
        //////click_button
        bindig.send.setOnClickListener {
            // Toast.makeText(requireContext(),"failed3", Toast.LENGTH_SHORT).show()
            viewmodel.getdata(this)

        }
        // bind.textspiner!!.

        // Create an ArrayAdapter using a simple spinner layout and languages array
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, list_of_items)
        // Set layout to use when the list of choices appear
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        bindig.textspiner!!.setAdapter(aa)
        bindig.textspiner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Toast.makeText(requireContext(),  parent!!.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()
                viewmodel.selectedItemPosition.value=parent!!.getItemAtPosition(position).toString()
            } // to close the onItemSelected

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })
    }
}