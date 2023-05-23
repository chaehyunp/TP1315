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
    val homeUrl = "testhue96.dothome.co.kr/home.html/"
    val shopUrl = "testhue96.dothome.co.kr/shop.html/"
    val shareUrl = "testhue96.dothome.co.kr/share.html/"
    val orderUrl = "testhue96.dothome.co.kr/order.html/"
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
            R.id.shop -> {
                binding.webview.loadUrl(shopUrl ?: "")
            }
            R.id.share -> {
                binding.webview.loadUrl(shareUrl ?: "")
            }
            R.id.order -> {
                binding.webview.loadUrl(orderUrl ?: "")
            }
        }
    }
}