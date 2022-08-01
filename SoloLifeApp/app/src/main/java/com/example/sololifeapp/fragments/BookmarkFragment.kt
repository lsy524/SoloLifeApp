package com.example.sololifeapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.sololifeapp.R
import com.example.sololifeapp.databinding.FragmentBookmarkBinding


class BookmarkFragment : Fragment() {

    private lateinit var binding: FragmentBookmarkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bookmark, container, false)



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
}