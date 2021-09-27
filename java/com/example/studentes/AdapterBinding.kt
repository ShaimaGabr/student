package com.example.studentes

import android.os.Build
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter

object AdapterBinding {

    @RequiresApi(Build.VERSION_CODES.O)
    @JvmStatic
    @BindingAdapter("loadUrl")
    fun WebView.setUrl(url: String) {
//        this.settings.javaScriptEnabled=true
//        this.settings.setSupportZoom(false)
//        //  binding.webView.loadUrl("https://www.facebook.com/ITGateAcademy/")
//        this.webViewClient = object : WebViewClient() {
//            override fun shouldOverrideUrlLoading(view: WebView?, Url: String?): Boolean {
//                view?.loadUrl(Url!!)
//                return true
//            }
//        }
        this.loadUrl(url)
    }

}