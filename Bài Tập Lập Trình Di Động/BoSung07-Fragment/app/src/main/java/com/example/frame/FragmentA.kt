package com.example.frame
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_a.*
class FragmentA :Fragment() {
    private val navigationController by lazy{
        requireActivity() as NavigationFragment
    }
    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_a,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAddFragA.setOnClickListener {
            navigationController.navigaTo(FragmentB.newInstance(),"tagFragB","stackB")
        }
    }
    companion object{
        fun newInstance() = FragmentA()
    }
}