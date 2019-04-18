package com.example.narcinglotapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
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

            //FORM COMPLETION
            if(MakeEnter.text.toString()=="" ||
                ModelEnter.text.toString()=="" ||
                ColorEnter.text.toString()=="" ||
                PlateEnter.text.toString()=="" ||
                VINEnter.text.toString()=="" ||
                Offspinner.selectedItem.equals("Select One")){
                    val builder = AlertDialog.Builder(this@OffenderPgActivity)
                    builder.setTitle("FORM INCOMPLETE")
                    builder.setMessage("Please complete all fields before moving to the next page.")
                    val dialog: AlertDialog = builder.create()
                    dialog.show()
            }else {
                startActivity(intent)
            }
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