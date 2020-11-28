package org.csuf.cpsc411.simplehttpclient

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class StatusLabelColumnGenerator (val ctx : Context) {

    fun generate() : LinearLayout {
        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.LTGRAY)
        val lbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        lbParams.weight = 1.0F
        var lbl = TextView(ctx)

        lbl.text = "Status:"
        lbl.gravity = Gravity.CENTER_HORIZONTAL
        lbl.setTextColor(Color.BLACK)
        lbl.setTextSize(16F)

        lbl.setPadding(30, 0, 30, 0)
        lbl.setBackgroundColor(Color.LTGRAY)
        layoutObj.addView(lbl, lbParams)

        return layoutObj
    }

}