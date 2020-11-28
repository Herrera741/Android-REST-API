package org.csuf.cpsc411.simplehttpclient

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.widget.LinearLayout

class StatusDetailSectionGenerator (val ctx : Context) {
    lateinit var layoutObj : LinearLayout
    fun generate() : LinearLayout {
        // create layout section
        layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.HORIZONTAL
        layoutObj.setBackgroundColor(Color.LTGRAY)

        // create layout columns
        val lcParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.MATCH_PARENT)
        val colGenerator = StatusLabelColumnGenerator(ctx) // create label section
        var lblView = colGenerator.generate()
        lcParams.weight = 1.0F
        layoutObj.addView(lblView, lcParams)

        // create layout values columns
        val valGenerator = StatusValueColumnGenerator(ctx) // create value section for labels
        val vcParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        lblView = valGenerator.generate()
//        vcParams.marginStart = 5
        vcParams.weight = 3.0F
        layoutObj.addView(lblView, vcParams)

        return layoutObj
    }

}