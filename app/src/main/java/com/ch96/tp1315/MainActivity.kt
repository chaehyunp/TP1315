package com.ch96.tp1315

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.ch96.tp1315.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val homeUrl = "http://testhue96.dothome.co.kr/1315/index.html"
    val wineUrl = "http://testhue96.dothome.co.kr/1315/wine.html"
    val menuUrl = "http://testhue96.dothome.co.kr/1315/menu.html"
    val mapUrl = "http://testhue96.dothome.co.kr/1315/map.html"
    val helpUrl = "http://testhue96.dothome.co.kr/1315/help.html"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.webview.webViewClient = WebViewClient()
        binding.webview.webChromeClient = WebChromeClient()
        binding.webview.settings.javaScriptEnabled = true

        binding.webview.loadUrl(homeUrl)


        binding.bnv.setOnItemSelectedListener (NavigationBarView.OnItemSelectedListener {
            changeBnv(it)
            return@OnItemSelectedListener true
        })

    }

    fun changeBnv(it: MenuItem){
        when(it.itemId) {
            R.id.home -> {
                binding.webview.loadUrl(homeUrl ?: "")
            }
            R.id.wine -> {
                binding.webview.loadUrl(wineUrl ?: "")
            }
            R.id.menu -> {
                binding.webview.loadUrl(menuUrl ?: "")
            }
            R.id.map -> {
                binding.webview.loadUrl(mapUrl ?: "")
            }
            R.id.help -> {
                binding.webview.loadUrl(helpUrl ?: "")
            }
        }
    }

    override fun onBackPressed() {
        if(binding.webview.canGoBack()) binding.webview.goBack()
        else finish()
    }
}