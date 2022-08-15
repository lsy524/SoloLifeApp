package com.example.sololifeapp.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.sololifeapp.R
import com.example.sololifeapp.databinding.ActivityBoardInsideBinding
import com.example.sololifeapp.model.BoardModel
import com.example.sololifeapp.util.FBRef
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class BoardInsideActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBoardInsideBinding
    private val TAG = BoardInsideActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_board_inside)


        // 방법 1. listView 에 있는 데이터 title, content, time 을 다 다른 액티비티로 전달해줘서 만들기
        /*
        // 방법 1-2 보내준 데이터를 받음
        val title = intent.getStringExtra("title").toString()
        val content = intent.getStringExtra("content").toString()
        val time = intent.getStringExtra("time").toString()

        // 방법 1-3 받을 데이터를 해당 요소에 할당
        binding.titleArea.text = title
        binding.contentArea.text = content
        binding.timeArea.text = time
         */

        // 방법 2-4 보내준 데이터를 받음
        val key = intent.getStringExtra("key").toString()
//        Toast.makeText(this, key, Toast.LENGTH_SHORT).show()
        getBoardData(key)
        getImageData(key)
    }

    // 방법 2-5 받은 데이터를 토대로 데이터를 가져옴
    private fun getBoardData(key: String) {
        // 데이터베이스에서 게시글 데이터를 가져오는 코드
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // 방법 2-7 BoardModel 형태로 데이터를 가져옴
                // 데이터 하나만 가져오면 되기 때문에 for 문 실행 X
                val dataModel = dataSnapshot.getValue(BoardModel::class.java) // BoardModel 형태로 데이터를 받는 다는 의미

                // 방법 2-8 데이터를 해당 view 에 할당
                binding.titleArea.text = dataModel!!.title
                binding.contentArea.text = dataModel.content
                binding.timeArea.text = dataModel.time
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        }
        // 방법 2-6 board filed 에 key 값을 가리키게 만듬
        FBRef.boardRef.child(key).addValueEventListener(postListener)
    }

    // 이미지를 다운로드 메서드
    private fun getImageData(key: String) {
        
        // 스토리지에 "$key.png" 값으로 이미지를 가져오겠다는 의미
        val storageReference = Firebase.storage.reference.child("$key.png")

        val imageViewFromFB = binding.getImageArea

        storageReference.downloadUrl.addOnCompleteListener(OnCompleteListener{ task ->
            if(task.isSuccessful) {
                Glide.with(this)
                    .load(task.result)
                    .into(imageViewFromFB)
            } else {

            }
        })
    }
}