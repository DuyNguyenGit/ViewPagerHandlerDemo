package com.example.stateviewpagerdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentList = Util.getFragmentList()
        val flagList = Util.initBooleanFlagList(fragmentList.size)

        Log.d("MainActivity", "onCreate: >>>" + flagList[0])
        val adapter = MyPagerAdapter(fragmentList, supportFragmentManager)
        view_pager.adapter = adapter
        view_pager.offscreenPageLimit = 2

        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                val flag = flagList[position]
                if (!flag) {
                    val handlerFragment: HandlerFragment =
                        adapter.getRegisteredFragment(position) as HandlerFragment
                    handlerFragment.refresh(true, flag)
                    flagList[position] = true
                } else {
                    Log.d("MainActivity", "onPageSelected: >>>")
                }
            }
        })
    }
}