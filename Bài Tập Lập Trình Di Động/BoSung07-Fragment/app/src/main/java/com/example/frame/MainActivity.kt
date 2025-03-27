package com.example.frame
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() , NavigationFragment{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCounter.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(R.id.frameLayout1,FragmentA.newInstance(),"tagFragA")
                .addToBackStack("stackA")
                .commit()
        }
    }
    override fun navigaTo(fragment: Fragment,tag:String,backStack:String) {
        supportFragmentManager.beginTransaction()
            .add(R.id.frameLayout1, fragment,tag)
            .addToBackStack(backStack)
            .commit()
    }
    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount > 0){
            supportFragmentManager.popBackStack()
        }
        else
            super.onBackPressed()
    }
}