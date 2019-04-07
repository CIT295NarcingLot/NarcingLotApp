package com.example.narcinglotapp

import android.app.AlertDialog
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

        // Sets the entry fields to nothing
        resetButton.setOnClickListener{
            subfn.setText("")
            lnsub.setText("")
            addsub.setText("")
            citysubenter.setText("")
            zipsubenter.setText("")
            dlnumenter.setText("")
            dlstateenter.setText("")
        }
        //FRAUD AGREEMENT
        fraudButton.setOnClickListener{
            val builder = AlertDialog.Builder(this@SubmitterPgActivity)
            builder.setTitle("FRAUD AGREEMENT")
            builder.setMessage("Legal Information will Display here.")
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }
}