package com.example.studentes

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.studentes.databinding.FragmentProfilBinding


class profil : Fragment() {
lateinit var binding:FragmentProfilBinding
val viewmodel:ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val callback1=object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {

                val intent= Intent(requireContext(),MainActivity::class.java)

                startActivity(intent)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,callback1)
        // Inflate the layout for this fragment
        binding= FragmentProfilBinding.inflate(inflater)
        binding.lifecycleOwner=this
        binding.viewModel=viewmodel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel.information(requireContext())
        viewmodel.getdatafromserver(requireContext())
        viewmodel.newsList.observe(viewLifecycleOwner, Observer {
            binding.attend.adapter=attendanceAdapter(it,viewmodel)
        })
        ///////con to adapter


    }

}