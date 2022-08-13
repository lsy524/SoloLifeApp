package com.example.sololifeapp.contentsList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sololifeapp.R
import com.example.sololifeapp.adapter.ContentRVAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ContentListActivity : AppCompatActivity() {

    private lateinit var myRef : DatabaseReference  // 데이터 참조 변수 생성

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_list)

        val items = ArrayList<ContentModel>() // 데이터를 저장할 리스트 변수

        val rvAdapter = ContentRVAdapter(items, baseContext) // 어댑터 생성

        val database = Firebase.database // 데이터베이스 정의

         // category 에 따라 myRef Reference 참조 변경
        // val getCategory = intent.getStringExtra("category") // tipFragment 에서 받아온 category 를 저장할 변수 생성
        when(intent.getStringExtra("category")) {
            "category1" -> myRef = database.getReference("contents")
            "category2" -> myRef = database.getReference("contents2")
            "category3" -> myRef = database.getReference("contents3")
            "category4" -> myRef = database.getReference("contents4")
            "category5" -> myRef = database.getReference("contents5")
            "category6" -> myRef = database.getReference("contents6")
            "category7" -> myRef = database.getReference("contents7")
            "category8" -> myRef = database.getReference("contents8")
        }



        // 데이터베이스에서 데이터 읽어오는 코드 
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (dataModel in dataSnapshot.children) {
                    // Log.d("ContentListActivity", dataModel.toString())
                    val item = dataModel.getValue(ContentModel::class.java) // dataModel 에 있는 데이터를 ContentModel 형식으로 받는 다는 의미
                    items.add(item!!) // 데이터베이스에 있는 데이터를 items(데이터를 저장할 리스트 변수)에 추가

                }
                rvAdapter.notifyDataSetChanged() // 리사이클러 뷰 전체 업데이트
                 // Log.d("ContentListActivity", items.toString())
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        }
        myRef.addValueEventListener(postListener)


        // recyclerView 변수 선언
        val rv : RecyclerView = findViewById(R.id.rv)

        // RecyclerView 에 어댑터 연결
        rv.adapter = rvAdapter

        // layout 을 어떤식으로 보여즐지 결정?
        // 한줄에 2개 씩 보여줌
        // LinearLayoutManager => 기본은 vertical
        rv.layoutManager = GridLayoutManager(this, 2)

        // 리사이클러 뷰 아이템 클릭 방법 1
        /*
        // 리사이클러뷰의 아이템 중 클릭되면 발생하는 코드
        rvAdapter.itemClick = object : ContentRVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                Toast.makeText(baseContext, items[position].title, Toast.LENGTH_LONG).show()
                val intent = Intent(this@ContentListActivity, ContentShowActivity::class.java)
                // 클릭된 아이템의 webUrl 을 ContentShowActivity 로 데이터를 보냄
                intent.putExtra("url",items[position].webUrl)
                startActivity(intent)
            }

        }
        */

    }
}

// 샘플 데이터
/* items.add(ContentModel("밥솥 리코타치즈 황금레시피", "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FblYPPY%2Fbtq66v0S4wu%2FRmuhpkXUO4FOcrlOmVG4G1%2Fimg.png", "https://philosopher-chan.tistory.com/1235?category=941578"))
   items.add(ContentModel("황금노른자장 황금레시피", "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FznKK4%2Fbtq665AUWem%2FRUawPn5Wwb4cQ8BetEwN40%2Fimg.png","https://philosopher-chan.tistory.com/1236?category=941578"))
   items.add(ContentModel("사골곰탕 파스타 황금레시피", "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbtig9C%2Fbtq65UGxyWI%2FPRBIGUKJ4rjMkI7KTGrxtK%2Fimg.png","https://philosopher-chan.tistory.com/1237?category=941578"))
   items.add(ContentModel("아웃백 투움바 파스타 황금레시피", "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcOYyBM%2Fbtq67Or43WW%2F17lZ3tKajnNwGPSCLtfnE1%2Fimg.png","https://philosopher-chan.tistory.com/1238?category=941578"))
*/

// 데이터베이스에 데이터 추가
/*
    myRef.push().setValue(
        ContentModel("밥솥 리코타치즈 황금레시피", "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FblYPPY%2Fbtq66v0S4wu%2FRmuhpkXUO4FOcrlOmVG4G1%2Fimg.png", "https://philosopher-chan.tistory.com/1235?category=941578")
    )
*/