package com.example.stateviewpagerdemo

import android.util.Log
import android.util.SparseArray
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

abstract class SmartFragmentStatePagerAdapter(fragmentManager: FragmentManager?) :
    FragmentStatePagerAdapter(fragmentManager!!) {
    // Sparse array to keep track of registered fragments in memory
    private val registeredFragments =
        SparseArray<Fragment>()

    // Register the fragment when the item is instantiated
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment =
            super.instantiateItem(container, position) as Fragment
        registeredFragments.put(position, fragment)
        return fragment
    }

    // Unregister when the item is inactive
    override fun destroyItem(
        container: ViewGroup,
        position: Int,
        `object`: Any
    ) {
        registeredFragments.remove(position)
        Log.d(
            TAG,
            "destroyItem: >>>$position"
        )
        super.destroyItem(container, position, `object`)
    }

    // Returns the fragment for the position (if instantiated)
    fun getRegisteredFragment(position: Int): Fragment {
        return registeredFragments[position]
    }

    companion object {
        private val TAG = SmartFragmentStatePagerAdapter::class.java.simpleName
    }
}