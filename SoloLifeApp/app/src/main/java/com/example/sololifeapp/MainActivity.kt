package com.example.sololifeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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
