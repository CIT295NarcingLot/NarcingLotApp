package com.example.narcinglotapp

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.submitter_pg.*

// Creates the Submitter instance and is required for an activity
class SubmitterPgActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.submitter_pg)

        // stores values from other pages
        val sMake = intent.getStringExtra("Make");
        val sModel = intent.getStringExtra("Model")
        val sColor = intent.getStringExtra("Color")
        val sPlate = intent.getStringExtra("Plate")
        val sVin = intent.getStringExtra("VIN")

        // stores values from other pages
        val sLocation = intent.getStringExtra("Location")
        val sAddress = intent.getStringExtra("Address")
        val sCity = intent.getStringExtra("City")
        val sZip = intent.getStringExtra("Zip")

        // stores values from other pages and creates a variable to reset the values for this page
        val setFirst = intent.getStringExtra("FirstN")
        val setLast = intent.getStringExtra("LastN")
        val setHaddress = intent.getStringExtra("HAddress")
        val setHcity = intent.getStringExtra("HCity")
        val setHzip = intent.getStringExtra("HZIP")
        val setDLnum = intent.getStringExtra("DLnum")
        val setDLstate = intent.getStringExtra("DLstate")

        val spinnerL = intent.getStringExtra("SpinnerL")
        val spinnerO = intent.getStringExtra("SpinnerO")
        val spinnerS = intent.getStringExtra("SpinnerS")

        // sets the text fields to the stored values
        subfn.setText(setFirst)
        lnsub.setText(setLast)
        addsub.setText(setHaddress)
        citysubenter.setText(setHcity)
        zipsubenter.setText(setHzip)
        dlnumenter.setText(setDLnum)
        dlstateenter.setText(setDLstate)

        // Sends user back to Location Page
        PreButton.setOnClickListener{
            val intent = Intent(this, LocationPgActivity :: class.java)

            // turns the entered text into a variable to be used
            val first = subfn.text.toString()
            val last = lnsub.text.toString()
            val address = addsub.text.toString()
            val city = citysubenter.text.toString()
            val zip = zipsubenter.text.toString()
            val dlnum = dlnumenter.text.toString()
            val dlstate = dlstateenter.text.toString()

            val spinnerS = spinner2.getSelectedItem().toString()

            // sends submitter values to previous page
            intent.putExtra("FirstN", first)
            intent.putExtra("LastN", last)
            intent.putExtra("HAddress", address)
            intent.putExtra("HCity", city)
            intent.putExtra("HZIP", zip)
            intent.putExtra("DLnum", dlnum)
            intent.putExtra("DLstate", dlstate)

            // sends location values  to previous page
            intent.putExtra("Location", sLocation)
            intent.putExtra("Address", sAddress)
            intent.putExtra("City", sCity)
            intent.putExtra("ZIP", sZip)

            // sends offender values to previous page
            intent.putExtra("Make", sMake)
            intent.putExtra("Model", sModel)
            intent.putExtra("Color", sColor)
            intent.putExtra("Plate", sPlate)
            intent.putExtra("Vin", sVin)

            intent.putExtra("SpinnerL", spinnerS)
            intent.putExtra("SpinnerO", spinnerO)
            intent.putExtra("SpinnerS", spinnerL)

            startActivity(intent)
        }

        // Sets the entry fields to nothing
        resetButtonS.setOnClickListener{
            subfn.setText("")
            lnsub.setText("")
            addsub.setText("")
            citysubenter.setText("")
            zipsubenter.setText("")
            dlnumenter.setText("")
            dlstateenter.setText("")
        }


        // creates an on click listener for the open camera button that opens the camera
        cameraButtonS.setOnClickListener{
            // this opens up the default camera app on the phone
            var takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 142)
        }

        // creates an on click listener for the pick picture button that opens the gallery
        pickPButtonS.setOnClickListener{
            // opens the gallery to get a picture
            val pickPictureIntent = Intent(Intent.ACTION_PICK)
            pickPictureIntent.type = "image/*"
            startActivityForResult(pickPictureIntent, 150)
        }


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // checks if it is using the camera
        if(requestCode == 142){
            var bmp = data?.extras?.get("data") as Bitmap
            imageViewS.setImageBitmap(bmp)
        }
        // checks if it is using the gallery
        if(requestCode == 150){
            imageViewS.setImageURI(data?.data)
        }
    }
}