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

        // stores values from other pages and creates a variable to reset the values for this page
        val setMake = intent.getStringExtra("Make")
        val setModel = intent.getStringExtra("Model")
        val setColor = intent.getStringExtra("Color")
        val setPlate = intent.getStringExtra("Plate")
        val setVin = intent.getStringExtra("Vin")

        // stores values from other pages
        val oLocation = intent.getStringExtra("Location")
        val oAddress = intent.getStringExtra("Address")
        val oCity = intent.getStringExtra("City")
        val oZip = intent.getStringExtra("Zip")

        // stores values from other pages
        val oFirst = intent.getStringExtra("FirstN")
        val oLast = intent.getStringExtra("LastN")
        val oHaddress = intent.getStringExtra("HAddress")
        val oHcity = intent.getStringExtra("HCity")
        val oHzip = intent.getStringExtra("HZIP")
        val oDLnum = intent.getStringExtra("DLnum")
        val oDLstate = intent.getStringExtra("DLstate")

        // sets the text fields to the stored values
        MakeEnter.setText(setMake)
        ModelEnter.setText(setModel)
        ColorEnter.setText(setColor)
        PlateEnter.setText(setPlate)
        VINEnter.setText(setVin)


        // Sends user to Location Page
        NextPgbtn.setOnClickListener{
            val intent = Intent(this, LocationPgActivity :: class.java)

            // turns the entered text into a variable to be used
            val make = MakeEnter.text.toString()
            val model = ModelEnter.text.toString()
            val color = ColorEnter.text.toString()
            val plate = PlateEnter.text.toString()
            val vin = VINEnter.text.toString()

            // sends offender values to next page
            intent.putExtra("Make", make)
            intent.putExtra("Model", model)
            intent.putExtra("Color", color)
            intent.putExtra("Plate", plate)
            intent.putExtra("VIN", vin)

            // sends location values to next page
            intent.putExtra("Location", oLocation)
            intent.putExtra("Address", oAddress)
            intent.putExtra("City", oCity)
            intent.putExtra("ZIP", oZip)

            // sends submitter values to next page
            intent.putExtra("FirstN", oFirst)
            intent.putExtra("LastN", oLast)
            intent.putExtra("HAddress", oHaddress)
            intent.putExtra("HCity", oHcity)
            intent.putExtra("HZIP", oHzip)
            intent.putExtra("DLnum", oDLnum)
            intent.putExtra("DLstate", oDLstate)

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