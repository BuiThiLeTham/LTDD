package com.example.frame
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_a.*
import kotlinx.android.synthetic.main.fragment_c.*
class FragmentC :Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_c,container,false)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnBackC.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
        btnPopBackC.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack("stackA",0)
        }
//Retrieve value from FragmentA
        val fragmentA:FragmentA =
            requireActivity().supportFragmentManager.findFragmentByTag("tagFragA") as
                    FragmentA
        if(fragmentA != null)
            Toast.makeText(requireActivity(),fragmentA.tvFragmentA.text,Toast.LENGTH_LONG
            ).show()
    }
    companion object{
        fun newInstance() = FragmentC()
    }
}
