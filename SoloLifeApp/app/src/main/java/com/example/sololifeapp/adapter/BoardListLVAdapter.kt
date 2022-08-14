package com.example.sololifeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.sololifeapp.R
import com.example.sololifeapp.model.BoardModel

class BoardListLVAdapter(private val boardList : MutableList<BoardModel>) : BaseAdapter() {
    override fun getCount() = boardList.size

    override fun getItem(position: Int): Any {
        return boardList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // 뷰를 가져와서 연결해주는 부분
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView

        if(view == null) {
            view = LayoutInflater.from(parent?.context).inflate(R.layout.board_list_item, parent,false)
        }

        return view!!
    }
}