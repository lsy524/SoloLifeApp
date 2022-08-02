package com.example.sololifeapp.contentsList

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.sololifeapp.R
import com.example.sololifeapp.utils.FBAuth
import com.example.sololifeapp.utils.FBRef

class ContentRVAdapter(val items: ArrayList<ContentModel>, val context: Context, val keyList: ArrayList<String>, val bookmarkIdList: MutableList<String>) : RecyclerView.Adapter<ContentRVAdapter.ViewHolder>(){

    // 아이템 클릭 방법 1
//    interface ItemClick {
//        fun onClick(view: View, position: Int)
//    }
//
//    var itemClick: ItemClick? = null

    // 각각의 아이템 하나 씩 가져옴 하나의 레이아웃으로 만들어줌
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentRVAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.content_rv_item, parent, false)

        Log.d("로그", keyList.toString())
        Log.d("로그", bookmarkIdList.toString())

        return ViewHolder(v)
    }

    // 아이템들을 ViewHolder 메서드에서 아이템들을 하나 하나 씩 넣을 수 있게 연결
    override fun onBindViewHolder(holder: ContentRVAdapter.ViewHolder, position: Int) {

        // 아이템 클릭 방법 2
//        if(itemClick != null) {
//            holder.itemView.setOnClickListener{ v ->
//                itemClick?.onClick(v, position)
//            }
//        }
        holder.bindItem(items[position], keyList[position])
    }

    // 아이템의 개수가 몇개인지
    override fun getItemCount() = items.size

    // itemView = content_rv_item
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(item: ContentModel, key : String){

            itemView.setOnClickListener{
                val intent = Intent(context, ContentListActivity::class.java)
                intent.putExtra("url", item.webUrl)
                itemView.context.startActivity(intent)

            }

            val contentTitle = itemView.findViewById<TextView>(R.id.textArea)
            val imageUrl = itemView.findViewById<ImageView>(R.id.imageArea)
            val bookmarkArea = itemView.findViewById<ImageView>(R.id.bookmarkArea)

            if(bookmarkIdList.contains(key)) {
                bookmarkArea.setImageResource(R.drawable.bookmark_color)
            } else {
                bookmarkArea.setImageResource(R.drawable.bookmark_white)

            }

            bookmarkArea.setOnClickListener{
                Log.d("로그", FBAuth.getUid())
                Toast.makeText(context, key, Toast.LENGTH_SHORT).show()
                if(bookmarkIdList.contains(key)) {
                    // 북마크 있는 경우
                    bookmarkIdList.remove(key)
                    FBRef.bookmarkRef
                        .child(FBAuth.getUid())
                        .child(key)
                        .removeValue()


                } else {
                    // 북마크 없는  경우
                    FBRef.bookmarkRef
                        .child(FBAuth.getUid())
                        .child(key)
                        .setValue(BookmarkModel(true))
                }
            }
            contentTitle.text = item.title

            Glide.with(context).load(item.imageUrl).into(imageUrl)
        }
    }

}