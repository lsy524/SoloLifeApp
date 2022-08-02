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
import com.example.sololifeapp.contentsList.ContentListActivity
import com.example.sololifeapp.databinding.FragmentTipBinding


class TipFragment : Fragment() {

    private lateinit var binding: FragmentTipBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_tip, container, false)

        onClick(binding.homeTap)
        onClick(binding.talkTap)
        onClick(binding.bookmarkTap)
        onClick(binding.storeTap)
        onClick(binding.category1)

        return binding.root
    }


    private fun onClick(v: View) {
        when(v.id) {
            R.id.homeTap -> binding.homeTap.setOnClickListener{ it.findNavController().navigate(R.id.action_tipFragment_to_homeFragment) }
            R.id.talkTap -> binding.talkTap.setOnClickListener { it.findNavController().navigate(R.id.action_tipFragment_to_talkFragment) }
            R.id.bookmarkTap -> binding.bookmarkTap.setOnClickListener { it.findNavController().navigate(R.id.action_tipFragment_to_bookmarkFragment) }
            R.id.storeTap -> binding.storeTap.setOnClickListener { it.findNavController().navigate(R.id.action_tipFragment_to_storeFragment) }
            R.id.category1 -> binding.category1.setOnClickListener { startActivity(
                Intent(context, ContentListActivity::class.java)) }
        }
    }
}