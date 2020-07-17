package com.example.stateviewpagerdemo

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment

abstract class HandlerFragment : Fragment() {
    private var handler = Handler()
    var count = 0
    abstract fun getTotalText(): Int
    abstract fun removeAllText()
    abstract fun onDo(index: Int)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refresh(false, false)
    }

    fun refresh(shouldStop: Boolean, flag: Boolean) {
        if (shouldStop && !isDone()) {
            handler.removeCallbacksAndMessages(null)
            removeAllText()
            count = 0
        } else if (isDone()) {
            return
        }
        for (i in 0 until getTotalText()) {
            handler.postDelayed(Runnable {
                onDo(i)
                count++
            }, 500L * i)
        }
    }

    private fun isDone(): Boolean {
        return count == getTotalText()
    }

}