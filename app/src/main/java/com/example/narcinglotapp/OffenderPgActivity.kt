package com.example.narcinglotapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.location_pg.*
import kotlinx.android.synthetic.main.offender_pg.*

// Creates the Offender instance and is required for an activity
class OffenderPgActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.offender_pg)

        // Sends user to Location Page
        NextPgbtn.setOnClickListener{
            val intent = Intent(this, LocationPgActivity :: class.java)

            //PULL INFO TO VARIABLES
            val offMake=MakeEnter;
            val offModel=ModelEnter;
            val offColor=ColorEnter;
            val offPlate=PlateEnter;
            val offState=OffStateSpinner;
            val offVIN=VINEnter;

            startActivity(intent)
        }
    }
}