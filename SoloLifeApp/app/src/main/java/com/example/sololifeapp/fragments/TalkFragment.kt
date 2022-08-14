package com.example.sololifeapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.sololifeapp.R
import com.example.sololifeapp.adapter.BoardListLVAdapter
import com.example.sololifeapp.board.BoardWriteActivity
import com.example.sololifeapp.databinding.FragmentTalkBinding
import com.example.sololifeapp.model.BoardModel


class TalkFragment : Fragment() {
    private lateinit var binding: FragmentTalkBinding

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

        val boardList = mutableListOf<BoardModel>() // boardModel 데이터를 담을 리스트 정의
        boardList.add(BoardModel("a", "B","c","d"))
        val boardRVAdapter = BoardListLVAdapter(boardList) // 어댑터 정의
        binding.boardListView.adapter = boardRVAdapter // 어댑터를 boardListView 와 연결



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

}