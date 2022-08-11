package com.example.sololifeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.sololifeapp.auth.IntroActivity
import com.example.sololifeapp.databinding.ActivityMainBinding
import com.example.sololifeapp.utils.FBAuth
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
// ...
// Initialize Firebase Auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        auth = Firebase.auth

        binding.logoutBtn.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this@MainActivity, IntroActivity::class.java))
        }



//         Logout
//        binding.logoutBtn.setOnClickListener {
//            auth.signOut()
//            Toast.makeText(this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()
//
//            val intent = Intent(this, IntroActivity::class.java)
//            // 로그아웃 후 뒤로 가기 버튼 클릭 시 메인화면으로 돌아가지 않게 하는 코드
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//            startActivity(intent)
//
//        }
    }
}
