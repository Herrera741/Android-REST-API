package org.csuf.cpsc411.simplehttpclient

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class ObjDetailScreenGenerator(val ctx : Context) {
    lateinit var layoutObj : LinearLayout
    fun generate() : LinearLayout {

        // 1. Create a linearLayout object to reuse for each layout
        layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.LTGRAY)

        // 2. add field title
        val lblTitle = TextView(ctx)
        val lParams2 = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        lblTitle.text = "Please Enter Claim Information"
        lblTitle.gravity = Gravity.CENTER
        lblTitle.textSize = 18F
        lblTitle.setTypeface(null, Typeface.BOLD)
        lblTitle.setTextColor(Color.BLACK)
        lblTitle.setPadding(0, 80, 0, 80)
        lblTitle.id = R.id.fieldTitle
        layoutObj.addView(lblTitle, lParams2)

        // 3. add ObjDetailSection
        val fldRowGenerator = ObjDetailSectionGenerator(ctx)
        var colView = fldRowGenerator.generate()
        layoutObj.addView(colView)

        // 4. 'Add' Button LinearLayout
        val aLayout = LinearLayout(ctx)
        val aParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        // only applied to height now
        aParams.gravity = Gravity.RIGHT
        aLayout.layoutParams = aParams
        aLayout.orientation = LinearLayout.HORIZONTAL
        aLayout.setPadding(0, 50, 50, 50)
//        aLayout.setBackgroundColor(Color.GRAY)
        val aButton = Button(ctx)
        aButton.text = "ADD"
        aButton.setId(R.id.add_btn)
        aButton.setBackgroundColor(Color.CYAN)
        val abParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        abParams.gravity = Gravity.BOTTOM
        aLayout.addView(aButton, abParams)
        layoutObj.addView(aLayout, aParams)

        // 5. add status section
        val fldRowGenerator2 = StatusDetailSectionGenerator(ctx)
        colView = fldRowGenerator2.generate()
        layoutObj.addView(colView)

        return layoutObj
    }
}