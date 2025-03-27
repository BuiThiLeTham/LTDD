package com.example.a23it206_hoanganhphi

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navHostFragment: NavHostFragment
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Set up toolbar
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        
        // Set up drawer layout
        drawerLayout = findViewById(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        
        // Set up navigation
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        
        // Set up app bar configuration with drawer layout
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.primeNumberFragment, R.id.historyFragment, R.id.hocPhanFragment, 
                R.id.quanLyHocPhanFragment, R.id.tinhTongFragment
            ), drawerLayout
        )
        
        // Connect app bar with navigation controller
        setupActionBarWithNavController(navController, appBarConfiguration)
        
        // Connect navigation view with navigation controller
        val navView = findViewById<NavigationView>(R.id.nav_view)
        navView.setupWithNavController(navController)
        navView.setNavigationItemSelectedListener(this)
    }
    
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks
        val navController = navHostFragment.navController
        when (item.itemId) {
            R.id.primeNumberFragment -> navController.navigate(R.id.primeNumberFragment)
            R.id.historyFragment -> navController.navigate(R.id.historyFragment)
            R.id.hocPhanFragment -> navController.navigate(R.id.hocPhanFragment)
            R.id.quanLyHocPhanFragment -> navController.navigate(R.id.quanLyHocPhanFragment)
            R.id.tinhTongFragment -> navController.navigate(R.id.tinhTongFragment)
        }
        
        // Close drawer after item is selected
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    
    override fun onSupportNavigateUp(): Boolean {
        val navController = navHostFragment.navController
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    
    override fun onBackPressed() {
        // Close drawer if open when back button is pressed
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}