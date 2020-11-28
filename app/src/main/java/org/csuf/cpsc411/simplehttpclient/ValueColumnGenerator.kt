package org.csuf.cpsc411.simplehttpclient

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class ValueColumnGenerator(val ctx : Context) {
    fun generate() : LinearLayout {
        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.DKGRAY)
        //
        val vParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        vParams.topMargin = 5

        // Claim title input field
        var value = EditText(ctx)
        value.id = R.id.title
        value.setTextSize(16F)
        value.setHint("Enter Claim Title")
        value.setBackgroundColor(Color.WHITE)
        layoutObj.addView(value, vParams)

        // date input field
        value = EditText(ctx)
        value.id = R.id.date
        value.setTextSize(16F)
        value.setHint("MM/DD/YYYY")
        value.setBackgroundColor(Color.WHITE)
        layoutObj.addView(value, vParams)

        return layoutObj
    }
}