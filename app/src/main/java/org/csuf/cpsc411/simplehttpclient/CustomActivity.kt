package org.csuf.cpsc411.simplehttpclient

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.loopj.android.http.AsyncHttpClient

class CustomActivity : AppCompatActivity() {
//    lateinit var pList : MutableList<Person>
//    lateinit var pService : PersonService
    lateinit var claimService : ClaimService

    fun refreshScreen(cTitle : EditText, cDate : EditText) {
        Log.d("Claim Service", "Refreshing the Screen. ")

        // clear input fields
        cTitle.text.clear()
        cDate.text.clear()

//        val claimTitleView : EditText = findViewById(R.id.title) // claim title view
//        val cTitle = claimTitleView.text // claim title text
//        val claimDateView : EditText = findViewById(R.id.date) // date view
//        val cDateText = claimDateView.text // date text
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val fldRowGenerator = FieldValueViewGenerator(this, "SSN")
        //val colGenerator = LabelColumnGenerator(this)
        //val colView = colGenerator.generate()
//        val client = AsyncHttpClient()


        val fldRowGenerator = ObjDetailScreenGenerator(this)
        val colView = fldRowGenerator.generate()

        setContentView(colView)

        // add button view
        val bView : Button = findViewById(R.id.add_btn)
        bView.setOnClickListener{
            var cObj = Claim(null, null, false) // create Claim object

            // input field values
            val cTitle : EditText = findViewById(R.id.title) // claim title
            val cDate : EditText = findViewById(R.id.date) // claim date
            val statusMessage : TextView = findViewById(R.id.status)

            if (cTitle.text.toString().trim() == "" || cDate.text.toString().trim() == "") {
                statusMessage.text = "Claim \"${cTitle.text}\" failed to be created."
            } else {
                // set cObj title and date to input values
                cObj.title = cTitle.text.toString()
                cObj.date = cDate.text.toString()
                ClaimService(this).addClaim(cObj) // add Claim object to database server
                statusMessage.text = "Claim \"${cTitle.text}\" was successfully created."
            }

            refreshScreen(cTitle, cDate) // clear input fields

//            ClaimService(this).addClaim(Claim("testing button click", "11/21/2020", true))
//            val pObj = pService.next()
//            refreshScreen(pObj)
        }

//        pService = PersonService(this)
//        pService.getAll()
//        setContentView(R.layout.activity_main)
    }
}