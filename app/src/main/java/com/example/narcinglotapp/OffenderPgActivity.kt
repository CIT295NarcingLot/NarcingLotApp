package com.example.narcinglotapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.offender_pg.*

// Creates the Offender instance and is required for an activity
class OffenderPgActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.offender_pg)
        NextPgbtn.isEnabled=false;
        if(MakeEnter.toString()!="" &&
           ModelEnter.toString()!="" &&
           ColorEnter.toString()!="" &&
           PlateEnter.toString()!="" &&
           VINEnter.toString()!="" &&
           Offspinner.toString()!= "Select One"){
                NextPgbtn.isEnabled=true;
        }

        // Sends user to Location Page
        NextPgbtn.setOnClickListener{
            val intent = Intent(this, LocationPgActivity :: class.java)
            startActivity(intent)
        }

        // Sets the entry fields to nothing
        resetButton.setOnClickListener{
            MakeEnter.setText("")
            ModelEnter.setText("")
            ColorEnter.setText("")
            PlateEnter.setText("")
            VINEnter.setText("")
        }
    }
}