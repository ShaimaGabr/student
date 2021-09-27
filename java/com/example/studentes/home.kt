package com.example.studentes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.studentes.databinding.FragmentHomeBinding


class home : Fragment() {
lateinit var bind:FragmentHomeBinding
val viewmodel : HomeViewmodel by viewModels()
    var list_of_items = arrayOf("COURSE", "DIPLOMA")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind= FragmentHomeBinding.inflate(inflater)
        bind.lifecycleOwner=this
        bind.viewModel=viewmodel
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ///////////interapp
//
        }


}