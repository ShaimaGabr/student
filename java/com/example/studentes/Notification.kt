package com.example.studentes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.studentes.databinding.FragmentNotificationBinding
import com.example.studentes.databinding.FragmentProfildiplomaBinding

class Notification : Fragment() {
    lateinit var binding: FragmentNotificationBinding
    val viewmodel:ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentNotificationBinding.inflate(inflater)
        binding.lifecycleOwner=this
        binding.viewModel=viewmodel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel.notification(requireContext())
        viewmodel.noti.observe(viewLifecycleOwner, Observer {
            binding.recycl.adapter=AdapterNotification(it,viewmodel)
        })

    }
}