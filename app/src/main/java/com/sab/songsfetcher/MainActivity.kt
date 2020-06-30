package com.sab.songsfetcher

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.sab.songsfetcher.fragments.HomeFragment
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.d("MyTad", "onResult was called")
        val callback = object: VKAuthCallback {
            override fun onLogin(token: VKAccessToken) {
                Toast.makeText(this@MainActivity, "Success!", Toast.LENGTH_SHORT)
                // User passed authorization

                Log.d("MyTad", "success")
            }

            override fun onLoginFailed(errorCode: Int) {
                // User didn't pass authorization
                Toast.makeText(this@MainActivity, "Fail!", Toast.LENGTH_SHORT)
                Log.d("MyTad", "fail")
            }
        }
        if (data == null || !VK.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
