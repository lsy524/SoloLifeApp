package com.example.sololifeapp.contentsList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Toast
import com.example.sololifeapp.R

class ContentShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_show)

        val getWebView: WebView = findViewById(R.id.webView)

        val getUrl = intent.getStringExtra("url")

        getWebView.loadUrl(getUrl.toString())

    }
}