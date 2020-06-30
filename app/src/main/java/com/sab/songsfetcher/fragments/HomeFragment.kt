package com.sab.songsfetcher.fragments

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.sab.songsfetcher.MainActivity

import com.sab.songsfetcher.R

import com.sab.songsfetcher.databinding.FragmentHomeBinding
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKScope
import java.lang.ref.WeakReference

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    private lateinit var homeBinding: FragmentHomeBinding
    lateinit var mView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        Toast.makeText(context, "Not logged in", Toast.LENGTH_SHORT).show()

        // Inflate the layout for this fragment
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        homeBinding.loginButton.setOnClickListener {

            VK.login(this!!.requireActivity(), listOf(VKScope.AUDIO))
            Log.d("MyTag", "Login was called in" + this!!.requireActivity().toString())
//            Navigation.findNavController(homeBinding.root).navigate(R.id.action_homeFragment_to_songsListFragment)
        }
        homeBinding.quitButton.setOnClickListener {
            VK.logout()
            activity?.finish() }
        mView = homeBinding.root
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if(VK.isLoggedIn()){
            Navigation.findNavController(homeBinding.root).navigate(R.id.action_homeFragment_to_songsListFragment)
            Toast.makeText(context, "Logged in", Toast.LENGTH_SHORT).show()
        }
        super.onViewCreated(view, savedInstanceState)
        fun moveToList(){
            Navigation.findNavController(homeBinding.root).navigate(R.id.action_homeFragment_to_songsListFragment)

        }
    }

companion object{

}
}
