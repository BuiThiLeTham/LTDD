package com.example.a23it253_buithiletham

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_perfect_number -> {
                    startActivity(Intent(this, PerfectNumberActivity::class.java))
                    true
                }
                R.id.nav_linear_equation -> {
                    startActivity(Intent(this, LinearEquationActivity::class.java))
                    true
                }
                R.id.nav_computer_management -> {
                    startActivity(Intent(this, ComputerManagementActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}