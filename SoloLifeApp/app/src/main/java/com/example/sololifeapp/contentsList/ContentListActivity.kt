package com.example.sololifeapp.contentsList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sololifeapp.R
import com.example.sololifeapp.adapter.ContentRVAdapter

class ContentListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_list)

        // recyclerView 변수 선언
        val rv : RecyclerView = findViewById(R.id.rv)

        // 샘플 데이터
        val item = arrayListOf<String>("a","b","c","d")

        // 어댑터 생성
        val rvAdapter = ContentRVAdapter(item)

        // RecyclerView 에 어댑터 연결
        rv.adapter = rvAdapter

        // layout 을 어떤식으로 보여즐지 결정?
        // 한줄에 2개 씩 보여줌
        // LinearLayoutManager => 기본은 vertical
        rv.layoutManager = GridLayoutManager(this, 2)

    }
}