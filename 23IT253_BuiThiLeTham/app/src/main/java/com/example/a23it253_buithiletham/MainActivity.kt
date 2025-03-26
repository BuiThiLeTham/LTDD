package com.example.a23it253_buithiletham

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.a23it253_buithiletham.PrimeNumberFragment
import com.example.a23it253_buithiletham.R
import com.example.a23it253_buithiletham.SumFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_prime -> loadFragment(PrimeNumberFragment())
                R.id.nav_sum -> loadFragment(SumFragment())
            }
            true
        }

        loadFragment(PrimeNumberFragment()) // Mặc định hiển thị màn hình kiểm tra số nguyên tố
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
