package com.example.sololifeapp.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.sololifeapp.R
import com.example.sololifeapp.databinding.ActivityBoardInsideBinding

class BoardInsideActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBoardInsideBinding
    private val TAG = BoardInsideActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_board_inside)

        val title = intent.getStringExtra("title").toString()
        val content = intent.getStringExtra("content").toString()
        val time = intent.getStringExtra("time").toString()

//        Log.d(TAG, title)
//        Log.d(TAG, content)
//        Log.d(TAG, time)

        binding.titleArea.text = title
        binding.contentArea.text = content
        binding.timeArea.text = time

    }
}