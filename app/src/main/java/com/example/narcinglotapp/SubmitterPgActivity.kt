package com.example.narcinglotapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.submitter_pg.*

// Creates the Submitter instance and is required for an activity
class SubmitterPgActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.submitter_pg)

        // Sends user back to Location Page
        PreButton.setOnClickListener{
            val intent = Intent(this, LocationPgActivity :: class.java)
            startActivity(intent)
        }
    }
}