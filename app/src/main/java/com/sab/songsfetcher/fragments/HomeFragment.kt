package com.sab.songsfetcher.fragments

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.sab.songsfetcher.R
import com.sab.songsfetcher.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    private lateinit var homeBinding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        homeBinding.loginButton.setOnClickListener { Navigation.findNavController(homeBinding.root).navigate(R.id.action_homeFragment_to_songsListFragment) }
        homeBinding.quitButton.setOnClickListener { activity?.finish() }
        return homeBinding.root
    }

}
