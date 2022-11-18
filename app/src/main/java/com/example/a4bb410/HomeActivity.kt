package com.example.a4bb410

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.a4bb410.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.activityHomeToolbar.title = ""
        setSupportActionBar(binding.activityHomeToolbar)
    }

    override fun onStart() {
        super.onStart()
        binding.activityHomeToolbarImage.setOnClickListener {
            Log.d( "HOLA", "HOLA")

        }    
    }

}