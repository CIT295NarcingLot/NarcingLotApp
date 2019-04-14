package com.example.narcinglotapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.location_pg.*
import java.util.zip.ZipEntry

// Creates the Location instance and is required for an activity
class LocationPgActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.location_pg)
        nextButton.isEnabled=false;
        if(locationEnter.toString()!="" &&
           streetEnter.toString()!="" &&
           cityEnter.toString()!="" &&
           zipEnter.toString()!="" &&
           Statespinner.toString()!=""){
                nextButton.isEnabled=true;
        }

        // Sends user to Submitter Page
        nextButton.setOnClickListener{
            val intent = Intent(this, SubmitterPgActivity :: class.java)
            startActivity(intent)
        }

        // Sends user back to Offender Page
        preButton.setOnClickListener{
            val intent = Intent(this, OffenderPgActivity :: class.java)
            startActivity(intent)
        }

        // Sets the entry fields to nothing
        resetbutton.setOnClickListener{
            locationEnter.setText("")
            streetEnter.setText("")
            cityEnter.setText("")
            zipEnter.setText("")
        }
    }
}