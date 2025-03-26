package com.example.frame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_a.*
import kotlinx.android.synthetic.main.fragment_b.*
class FragmentB :Fragment() {
    private val navigationController by lazy{
        requireActivity() as NavigationFragment
    }
    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_b,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAddFragB.setOnClickListener {
            navigationController.navigaTo(FragmentC.newInstance(),"tagFragC","stackC")
        }
        btnBackB.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
        btnRemoveFragB.setOnClickListener {
            val fragmentB:FragmentB =
                requireActivity().supportFragmentManager.findFragmentByTag("tagFragB") as
                        FragmentB
            if(fragmentB != null)
                requireActivity().supportFragmentManager.beginTransaction().remove(fragmentB)
                    .commit()
            else
                Toast.makeText(requireActivity(),"Fragment A không tồn tại
                    !",Toast.LENGTH_LONG).show()
        }
    }
    companion object {
        fun newInstance() = FragmentB()
    }
}