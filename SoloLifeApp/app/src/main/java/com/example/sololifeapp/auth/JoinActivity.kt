package com.example.sololifeapp.auth

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.sololifeapp.R
import com.example.sololifeapp.databinding.ActivityJoinBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class JoinActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJoinBinding
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_join)

        auth = Firebase.auth




        binding.joinBtn.setOnClickListener {

            var isGoToJoin = true

            val email = binding.emailArea.text.toString()
            val password1 = binding.passwordArea1.text.toString()
            val password2 = binding.passwordArea2.text.toString()

            // email, pwd1, pwd2 가 비어있는 지 확인
            if(email.isEmpty()) {
                Toast.makeText(this, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            } else if(password1.isEmpty() || password1.length < 6){
                Toast.makeText(this, "비밀번호는 6자리 이상 입력해주세요.", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            } else if(password2.isEmpty()){
                Toast.makeText(this, "비밀번호 재확인을 입력해주세요.", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            } else if(password1 != password2) { // 비밀번호가 동일한지 확인
                Toast.makeText(this, "비밀번호를 동일하게 입력해주세요.", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }

            if(isGoToJoin) {
            auth.createUserWithEmailAndPassword(email, password1)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "회원가입에 성공하셨습니다.\n로그인 후 이용해주세요.", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, LoginActivity::class.java))
                    } else {
                        Toast.makeText(this, "회원가입에 실패하셨습니다. ", Toast.LENGTH_SHORT).show()

                    }

                }
            }

        }

    }
}
