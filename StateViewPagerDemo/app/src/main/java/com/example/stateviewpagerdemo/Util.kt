package com.example.stateviewpagerdemo

import androidx.fragment.app.Fragment

class Util {

    companion object{
        fun getFragmentList() : List<Fragment> {
            return arrayListOf(
                FirstFragment.newInstance(),
                SecondFragment.newInstance(),
                ThirdFragment.newInstance()
            )
        }

        fun initBooleanFlagList(size: Int): ArrayList<Boolean> {
            val flagList = ArrayList<Boolean>()
            for (i in 0 until size) {
                flagList.add(false)
            }
            return flagList
        }
    }
}
