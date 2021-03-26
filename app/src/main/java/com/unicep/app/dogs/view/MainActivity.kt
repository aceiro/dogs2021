package com.unicep.app.dogs.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.unicep.app.dogs.R

class MainActivity : AppCompatActivity() {
    private lateinit var _navigation: NavController
    private val _tag = "MainActivity"
    init {
        Log.d(_tag, "Init :: lifecycle activity")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(_tag, "Called :: onCreate(savedInstanceState) ")
        setContentView(R.layout.activity_main)
        setupNavigation()
    }
    private fun setupNavigation(){
        _navigation = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, _navigation)
    }

    override fun onStart() {
        super.onStart()
        Log.d(_tag, "Called :: onStart() ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(_tag, "Called :: onResume() ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(_tag, "Called :: onStop() ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(_tag, "Called :: onDestroy() ")
    }

    override fun onSupportNavigateUp(): Boolean {
        Log.d(_tag, "Called :: onSupportNavigateUp() ")
        return NavigationUI.navigateUp(_navigation, null)
    }


}