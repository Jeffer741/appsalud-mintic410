package com.example.a4bb410

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
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

        val navController = findNavController(R.id.nav_host_home_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.homeFragment,
            R.id.locationFragment,
            R.id.specialistFragment,
            R.id.profileFragment
        ))
        binding.activityHomeBottomNavigation.setupWithNavController(navController)
        binding.activityHomeToolbar.setupWithNavController(navController, appBarConfiguration)

    }

}