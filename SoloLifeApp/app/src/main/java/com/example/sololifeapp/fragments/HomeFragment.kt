package com.example.sololifeapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.sololifeapp.R
import com.example.sololifeapp.auth.IntroActivity
import com.example.sololifeapp.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        auth = Firebase.auth


        onClick(binding.tipTap)
        onClick(binding.talkTap)
        onClick(binding.bookmarkTap)
        onClick(binding.storeTap)
        onClick(binding.logoutBtn)


        return binding.root
    }

    private fun onClick(v: View) {
        when(v.id) {
            R.id.tipTap-> binding.tipTap.setOnClickListener{ it.findNavController().navigate(R.id.action_homeFragment_to_tipFragment) }
            R.id.talkTap -> binding.talkTap.setOnClickListener { it.findNavController().navigate(R.id.action_homeFragment_to_talkFragment) }
            R.id.bookmarkTap -> binding.bookmarkTap.setOnClickListener { it.findNavController().navigate(R.id.action_homeFragment_to_bookmarkFragment) }
            R.id.storeTap -> binding.storeTap.setOnClickListener { it.findNavController().navigate(R.id.action_homeFragment_to_storeFragment) }
            R.id.logoutBtn -> binding.logoutBtn.setOnClickListener {
                auth.signOut()
                val intent = Intent(context, IntroActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }

        }
    }
}