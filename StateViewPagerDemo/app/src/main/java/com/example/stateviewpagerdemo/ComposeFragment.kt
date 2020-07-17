package com.example.stateviewpagerdemo

import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_container.*

abstract class ComposeFragment : HandlerFragment() {

    private val TAG: String? = ComposeFragment::class.simpleName
    private lateinit var textParams: LinearLayout.LayoutParams
    var line = -1
    private lateinit var lineLayout: LinearLayout
    abstract fun getNumTextOnLine(): Int
    abstract fun getTextByIndex(index: Int): String

    override fun removeAllText() {
        container.removeAllViewsInLayout()
    }

    override fun onDo(index: Int) {
        val currentLine = count / getNumTextOnLine()
        if (line < currentLine) {
            line = currentLine
            lineLayout = LinearLayout(context).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                orientation = LinearLayout.HORIZONTAL
            }
            container.apply {
                orientation = LinearLayout.VERTICAL
                addView(lineLayout)
            }
        }
        val text = TextView(context!!).apply {
            textParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 0, 10, 0)
            }
            layoutParams = textParams
            text = getTextByIndex(index)
        }
        lineLayout.addView(text)

    }


}