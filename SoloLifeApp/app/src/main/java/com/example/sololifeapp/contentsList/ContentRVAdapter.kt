package com.example.sololifeapp.contentsList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sololifeapp.R

//TODO Create RecyclerView........
class ContentRVAdapter(val items: ArrayList<String>) : RecyclerView.Adapter<ContentRVAdapter.ViewHolder>(){

    // 각각의 아이템 하나 씩 가져옴 하나의 레이아웃으로 만들어줌
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentRVAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.content_rv_item, parent, false)

        return ViewHolder(v)
    }

    // 아이템들을 ViewHolder 메서드에서 아이템들을 하나 하나 씩 넣을 수 있게 연결
    override fun onBindViewHolder(holder: ContentRVAdapter.ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    // 아이템의 개수가 몇개인지
    override fun getItemCount() = items.size


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(item: String){

        }
    }

}