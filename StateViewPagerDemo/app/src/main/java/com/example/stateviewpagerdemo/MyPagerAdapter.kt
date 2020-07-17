package com.example.stateviewpagerdemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MyPagerAdapter(val fragmentList: List<Fragment>, fragmentManager: FragmentManager?) :
    SmartFragmentStatePagerAdapter(fragmentManager) {
    // Returns total number of pages
    override fun getCount(): Int {
        return fragmentList.size
    }

    // Returns the fragment to display for that page
    override fun getItem(position: Int): Fragment {
        return fragmentList.get(position)
    }
}