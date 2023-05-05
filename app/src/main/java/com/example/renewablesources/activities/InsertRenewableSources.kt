package com.example.renewablesources.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.renewablesources.R
import com.example.renewablesources.models.RenewableSourceModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class InsertRenewableSources : AppCompatActivity() {

    private lateinit var rnSourceName: EditText
    private lateinit var rnSourceContent: EditText
    private lateinit var rnSourceRating: EditText
    private lateinit var btnRnSaveData: Button

    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_renawble_sources)

        rnSourceName = findViewById(R.id.rnSourceName)
        rnSourceContent = findViewById(R.id.rnSourceContent)
        rnSourceRating = findViewById(R.id.rnSourceRating)

        btnRnSaveData = findViewById(R.id.btnRnSaveData)

        dbRef = FirebaseDatabase.getInstance().getReference("RenewableSources")

        btnRnSaveData.setOnClickListener {
            saveSourceData()
        }
    }

    private fun saveSourceData(){

        val sourceName = rnSourceName.text.toString()
        val sourceContent = rnSourceContent.text.toString()
        val sourceRating = rnSourceRating.text.toString()

        if(sourceName.isEmpty()){
            rnSourceName.error = "please enter name"
        }
        if(sourceContent.isEmpty()){
            rnSourceContent.error = "please enter content"
        }
        if(sourceRating.isEmpty()){
            rnSourceRating.error = "please enter rating"
        }

        val rnSourceId = dbRef.push().key!!

        val rnSource = RenewableSourceModel(rnSourceId,sourceName,sourceContent,sourceRating)

        dbRef.child(rnSourceId).setValue(rnSource)
            .addOnCompleteListener{
                Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show()

                rnSourceName.text.clear()
                rnSourceContent.text.clear()
                rnSourceRating.text.clear()

            }.addOnFailureListener{err->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
            }
    }



}