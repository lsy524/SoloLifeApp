package com.example.sololifeapp.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.sololifeapp.R
import com.example.sololifeapp.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro)

        onClick(binding.loginBtn)
        onClick(binding.joinBtn)
    }

    private fun onClick(v: View) {
        when(v.id) {
            R.id.loginBtn -> binding.loginBtn.setOnClickListener {
                startActivity(Intent(this, LoginActivity::class.java))
            }

            R.id.joinBtn -> binding.joinBtn.setOnClickListener {
                startActivity(Intent(this, JoinActivity::class.java))
            }
        }
    }
}