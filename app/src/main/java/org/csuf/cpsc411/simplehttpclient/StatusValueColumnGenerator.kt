package org.csuf.cpsc411.simplehttpclient

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class StatusValueColumnGenerator(val ctx : Context) {
    fun generate() : LinearLayout {
        val layoutObj = LinearLayout(ctx)

        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)

        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.DKGRAY)

        val vParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        vParams.weight = 3.0F

        // status message field
        var value = TextView(ctx)
        value.id = R.id.status
        value.setTextSize(16F)
        value.maxEms = 5
        value.text = "<Status Message>"
        value.setTextColor(Color.BLACK)
        value.setPadding(15, 0, 10, 0)
        value.gravity = Gravity.LEFT
        value.setBackgroundColor(Color.LTGRAY)
        layoutObj.addView(value, vParams)

        return layoutObj
    }
}