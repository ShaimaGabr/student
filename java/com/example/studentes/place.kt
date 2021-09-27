package com.example.studentes

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import com.example.studentes.databinding.FragmentLocationBinding
import com.example.studentes.databinding.FragmentPlaceBinding


class place : Fragment() {
    lateinit var binding: FragmentPlaceBinding
    val viewmodedl:LocationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /////////////////
        val callback1=object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {

                val intent= Intent(requireContext(),MainActivity::class.java)

                startActivity(intent)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,callback1)
        // Inflate the layout for this fragment
        binding= FragmentPlaceBinding.inflate(inflater)
        binding.lifecycleOwner=this
        binding.viewModel=viewmodedl
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodedl.location(requireContext(),requireActivity())
    }

}