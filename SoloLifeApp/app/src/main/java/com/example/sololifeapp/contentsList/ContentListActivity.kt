package com.example.sololifeapp.contentsList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sololifeapp.R

class ContentListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_list)

        val rv: RecyclerView = findViewById(R.id.rv)

        val items = ArrayList<ContentModel>()
        items.add(ContentModel("밥솥 리코타치즈 황금레시피","https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FblYPPY%2Fbtq66v0S4wu%2FRmuhpkXUO4FOcrlOmVG4G1%2Fimg.png", "https://philosopher-chan.tistory.com/1235?category=941578"))
        items.add(ContentModel("황금노른자장 황금레시피","https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FznKK4%2Fbtq665AUWem%2FRUawPn5Wwb4cQ8BetEwN40%2Fimg.png","https://philosopher-chan.tistory.com/1236?category=941578"))
        items.add(ContentModel("사골곰탕 파스타 황금레시피","https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbtig9C%2Fbtq65UGxyWI%2FPRBIGUKJ4rjMkI7KTGrxtK%2Fimg.png","https://philosopher-chan.tistory.com/1237?category=941578"))

        val rvAdapter = ContentRVAdapter(items, baseContext)
        rv.adapter = rvAdapter

        // rv.layoutManager = LinearLayoutManager(this) // 한줄에 하나씩 세로로 출력
        rv.layoutManager = GridLayoutManager(this, 2) // 한줄에 입력한 갯수 만큼 가로에 배치하고 전체 세로로 출력

        rvAdapter.itemClick = object : ContentRVAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(this@ContentListActivity, ContentShowActivity::class.java)

                intent.putExtra("url", items[position].webUrl)
                startActivity(intent)
            }

        }
    }
}