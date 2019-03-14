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

        // Sends user to Location Page
        NextPgbtn.setOnClickListener{
            val intent = Intent(this, LocationPgActivity :: class.java)
            startActivity(intent)
        }
    }
}