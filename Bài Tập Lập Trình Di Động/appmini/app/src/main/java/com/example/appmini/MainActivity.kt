package com.example.appmini

import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.appmini.R.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(id.toolbar)


        val drawerLayout: androidx.drawerlayout.widget.DrawerLayout = findViewById(id.drawer_layout)
        val navigationView: NavigationView = findViewById(id.navigation_view)
        val bottomNav: BottomNavigationView = findViewById(id.bottom_navigation)
        val fab: FloatingActionButton = findViewById(id.fab)
        val textView: TextView = findViewById(id.textView)

        registerForContextMenu(textView)  // Context Menu

        // Navigation Drawer
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                id.nav_settings -> Toast.makeText(this, "Mở Cài đặt", Toast.LENGTH_SHORT).show()
                id.nav_logout -> Toast.makeText(this, "Đăng xuất", Toast.LENGTH_SHORT).show()
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // Bottom Navigation
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                id.nav_home -> Toast.makeText(this, "Trang chủ", Toast.LENGTH_SHORT).show()
                id.nav_profile -> Toast.makeText(this, "Hồ sơ", Toast.LENGTH_SHORT).show()
            }
            true
        }

        // Floating Action Button
        fab.setOnClickListener {
            Toast.makeText(this, "Bạn đã nhấn FAB", Toast.LENGTH_SHORT).show()
        }
    }

    // Option Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            id.menu_info -> showAlertDialog()
            id.menu_exit -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    // Context Menu
    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            id.menu_delete -> {
                Toast.makeText(this, "Đã xóa", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    // AlertDialog
    private fun showAlertDialog() {
        AlertDialog.Builder(this)
            .setTitle("Thông báo")
            .setMessage("Đây là AlertDialog!")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .show()
    }
}