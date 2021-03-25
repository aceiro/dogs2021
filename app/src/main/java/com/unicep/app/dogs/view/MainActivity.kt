package com.unicep.app.dogs.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.unicep.app.dogs.R

class MainActivity : AppCompatActivity() {
    private lateinit var _navigation: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _navigation = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, _navigation)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(_navigation, null)
    }
}