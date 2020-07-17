package com.example.stateviewpagerdemo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class SecondFragment : ComposeFragment() {
    private lateinit var array: Array<String>
    override fun getNumTextOnLine(): Int {
        return 6
    }

    override fun getTextByIndex(index: Int): String {
        return array[index]
    }

    override fun getTotalText(): Int {
        return array.size
    }

    override fun onResume() {
        super.onResume()
        Log.e("SecondFragment", "onResume: >>>SecondFragment")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        array = resources.getStringArray(R.array.planets_array)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    companion object {
        fun newInstance() = SecondFragment()
    }
}