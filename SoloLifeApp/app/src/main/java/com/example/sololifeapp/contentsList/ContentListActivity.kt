package com.example.sololifeapp.contentsList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sololifeapp.R

class ContentListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_list)

        val rv: RecyclerView = findViewById(R.id.rv)

        val items = ArrayList<String>()
        items.add("a")
        items.add("b")
        items.add("c")
        items.add("d")

        val rvAdapter = ContentRVAdapter(items)
        rv.adapter = rvAdapter

        // rv.layoutManager = LinearLayoutManager(this) // 한줄에 하나씩 세로로 출력
        rv.layoutManager = GridLayoutManager(this, 2) // 한줄에 입력한 갯수 만큼 가로에 배치하고 전체 세로로 출력  
    }
}