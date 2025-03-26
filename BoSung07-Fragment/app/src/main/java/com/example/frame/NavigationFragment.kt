package com.example.frame
import androidx.fragment.app.Fragment
interface NavigationFragment {
    fun navigaTo(fragment:Fragment,tag:String,backStack:String)
}