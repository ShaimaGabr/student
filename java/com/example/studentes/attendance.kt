package com.example.studentes

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.app.ActivityCompat
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import com.example.studentes.databinding.FragmentAttendanceBinding
import com.example.studentes.databinding.FragmentWepsitBinding

private const val CAMERA_REQUEST_CODE=101
class attendance : Fragment() {
lateinit var binding: FragmentAttendanceBinding
val viewmodel:ScanViewModel by viewModels()
    lateinit var codeScanner: CodeScanner
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ////////////////////////////////////
        val callback1=object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {

                val intent= Intent(requireContext(),MainActivity::class.java)

                startActivity(intent)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,callback1)
        /////////////////////////////////
        // Inflate the layout for this fragment
        binding= FragmentAttendanceBinding.inflate(inflater)
        binding.lifecycleOwner=this
        binding.viewModel=viewmodel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ///////////////////////////1//////////////
      //  viewmodel.scan.value= binding.scannerView.toString()

        viewmodel.setupPermision(requireActivity(),requireContext())
      codeScanner=CodeScanner(requireContext(),binding.scannerView)
        viewmodel.codeScanner(codeScanner,requireContext(), Activity(),requireView())
//        codeScanner.apply {
//            camera= CodeScanner.CAMERA_BACK
//            formats= CodeScanner.ALL_FORMATS
//            autoFocusMode= AutoFocusMode.SAFE
//            scanMode= ScanMode.CONTINUOUS
//            isAutoFocusEnabled=true
//            isFlashEnabled=false
//            decodeCallback= DecodeCallback {
//                activity?.runOnUiThread {
//                    viewmodel.scan.value=it.text
//                    viewmodel.move(requireView())
//                    ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED
//                    //  DesignerToast.Info(requireContext(), "RUNAWAY YOUR PHONE AND WAIT", Gravity.CENTER, Toast.LENGTH_SHORT)
//                   // Toast.makeText(context,it.text,Toast.LENGTH_SHORT).show()
//                  //  Navigation.findNavController(requireView()).navigate(R.id.action_attendance2_to_location)
//
//                    // checkplace(it.text)
//                }
//
//            }
//            errorCallback= ErrorCallback {
//                activity?.runOnUiThread{
//                    Log.e("Main","Camera initialization error:${it.message}")
//                }
//            }
//        }
        ///////////////////////
        binding.scannerView.setOnClickListener {
            codeScanner.startPreview()
        }
        ///////////////////////////////2//////////////////////

    }

    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            CAMERA_REQUEST_CODE->{
                if(grantResults.isEmpty()||grantResults[0]!= PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(requireContext(),"you need the camera permission to be able to use this app", Toast.LENGTH_SHORT).show()
                }
                else{}
            }
        }
    }
}