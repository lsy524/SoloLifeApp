package com.example.sololifeapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.sololifeapp.R
import com.example.sololifeapp.contentsList.ContentModel
import com.example.sololifeapp.databinding.FragmentBookmarkBinding
import com.example.sololifeapp.utils.FBAuth
import com.example.sololifeapp.utils.FBRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener


class BookmarkFragment : Fragment() {

    private lateinit var binding: FragmentBookmarkBinding

    private val TAG = BookmarkFragment::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bookmark, container, false)

        // 1. 전체 카테고리에 있는 컨텐츠 데이터를 다 가져옴
        getCategoryData()

        // 2. 사용자가 북마크한 정보를 다 가져옴
        getBookmarkData()

        // 3. 전체 컨텐츠 중에서, 사용자가 북마크한 정보만 보여줌

        onClick(binding.homeTap)
        onClick(binding.tipTap)
        onClick(binding.talkTap)
        onClick(binding.storeTap)


        return binding.root
    }

    private fun onClick(v: View) {
        when(v.id) {
            R.id.homeTap -> binding.homeTap.setOnClickListener { it.findNavController().navigate(R.id.action_bookmarkFragment_to_homeFragment) }
            R.id.tipTap-> binding.tipTap.setOnClickListener{ it.findNavController().navigate(R.id.action_bookmarkFragment_to_tipFragment) }
            R.id.talkTap -> binding.talkTap.setOnClickListener { it.findNavController().navigate(R.id.action_bookmarkFragment_to_talkFragment) }
            R.id.storeTap -> binding.storeTap.setOnClickListener { it.findNavController().navigate(R.id.action_bookmarkFragment_to_storeFragment) }
        }
    }

    // 1. 전체 카테고리에 있는 컨텐츠 데이터를 가져오는 메서드
    private fun getCategoryData() {
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for(dataModel in dataSnapshot.children) {
                    Log.d(TAG, dataModel.toString())
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        }

        FBRef.category1.addValueEventListener(postListener)
        FBRef.category2.addValueEventListener(postListener)
    }

    // 2. 사용자가 북마크한 정보를 가져오는 메서드
    private fun getBookmarkData() {
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for(dataModel in dataSnapshot.children) {
                    Log.e(TAG, dataModel.toString())
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        }
        FBRef.bookmarkRef.child(FBAuth.getUid()).addValueEventListener(postListener)


    }
}