package com.example.sololifeapp.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.sololifeapp.R
import com.example.sololifeapp.adapter.BoardListLVAdapter
import com.example.sololifeapp.board.BoardInsideActivity
import com.example.sololifeapp.board.BoardWriteActivity
import com.example.sololifeapp.contentsList.ContentModel
import com.example.sololifeapp.databinding.FragmentTalkBinding
import com.example.sololifeapp.model.BoardModel
import com.example.sololifeapp.util.FBRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener


class TalkFragment : Fragment() {
    private lateinit var binding: FragmentTalkBinding
    private val TAG = TalkFragment::class.java.simpleName
    private val boardDataList = mutableListOf<BoardModel>() //getFBBoardData method 에 dataModel 을 담을 리스트

    private lateinit var boardRVAdapter : BoardListLVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_talk, container, false)

        onClick(binding.homeTap)
        onClick(binding.tipTap)
        onClick(binding.bookmarkTap)
        onClick(binding.storeTap)
        onClick(binding.writeBtn)

        boardRVAdapter = BoardListLVAdapter(boardDataList) // 어댑터 정의
        binding.boardListView.adapter = boardRVAdapter // 어댑터를 boardListView 와 연결

        // 게시글 클릭 시 BoardModel(title, content, time)을 다른 액티비티로 보내는 방법
        // 방법 1. listView 에 있는 데이터 title, content, time 을 다 다른 액티비티로 전달해줘서 만들기
        binding.boardListView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(requireContext(), BoardInsideActivity::class.java)
            intent.putExtra("title",boardDataList[position].title)
            intent.putExtra("content",boardDataList[position].content)
            intent.putExtra("time",boardDataList[position].time)
            startActivity(intent)
        }


        // 방법 2. 파이어베이스에 있는 board 에 대한 데이터의 id 를 기반으로 다시 데이터를 받아오는 방법

        getFBBoardData()

        return binding.root
    }

    private fun onClick(v: View) {
        when(v.id) {
            R.id.homeTap -> binding.homeTap.setOnClickListener { it.findNavController().navigate(R.id.action_talkFragment_to_homeFragment) }
            R.id.tipTap-> binding.tipTap.setOnClickListener{ it.findNavController().navigate(R.id.action_talkFragment_to_tipFragment) }
            R.id.bookmarkTap -> binding.bookmarkTap.setOnClickListener { it.findNavController().navigate(R.id.action_talkFragment_to_bookmarkFragment) }
            R.id.storeTap -> binding.storeTap.setOnClickListener { it.findNavController().navigate(R.id.action_talkFragment_to_storeFragment) }
            R.id.writeBtn -> binding.writeBtn.setOnClickListener { startActivity(Intent(requireContext(), BoardWriteActivity::class.java)) }
        }
    }

    private fun getFBBoardData() {

        // 데이터베이스에서 게시글 데이터를 가져오는 코드
         val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                boardDataList.clear()
                for (dataModel in dataSnapshot.children) {
                    val item = dataModel.getValue(BoardModel::class.java) // 데이터를 boardModel 형태로 출력
                    boardDataList.add(item!!) // boardDataList 에 추가

                }
                // Log.d(TAG, boardDataList.toString())
                boardRVAdapter.notifyDataSetChanged()

            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        }
        FBRef.boardRef.addValueEventListener(postListener)

    }

}