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

        }

        Submitbtn.setOnClickListener{

            //FORM COMPLETION
            if(subfn.text.toString()=="" ||
                lnsub.text.toString()=="" ||
                addsub.text.toString()=="" ||
                citysubenter.text.toString()=="" ||
                zipsubenter.text.toString()=="" ||
                dlnumenter.text.toString()=="" ||

                Subspinner.selectedItem.equals("Select One") ||
                Subspinner.selectedItem.equals("Select One") ||
                checkBox2.isChecked!=true) {
                    val builder = AlertDialog.Builder(this@SubmitterPgActivity)
                    builder.setTitle("FORM INCOMPLETE")
                    builder.setMessage("Please complete all fields before moving to the next page.")
                    val dialog: AlertDialog = builder.create()
                    dialog.show()
            }
        }
        //FRAUD AGREEMENT
        fraudButton.setOnClickListener{
            val builder = AlertDialog.Builder(this@SubmitterPgActivity)
            builder.setTitle("FRAUD AGREEMENT")
            builder.setMessage("By submitting this form, you, the user, affirm that no fraud, error, omission, misrepresentation, negligence or the similar has taken place in the connection to nor the origination of this submission.  Faudulent user submissions are subject to limited legal action. Submitting user assumes all responsibility and liability for his/her fraudulent submissions.")
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }
}