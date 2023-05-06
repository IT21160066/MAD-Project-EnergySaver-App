package com.example.renewablesources.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.renewablesources.R
import com.example.renewablesources.models.RenewableSourceModel
import com.google.firebase.database.FirebaseDatabase

class RenewableSourceDetailsUserActivity : AppCompatActivity() {

    //private lateinit var tvSrcId: TextView
    private lateinit var tvSrcName: TextView
    private lateinit var tvSrcContent: TextView
    private lateinit var tvSrcRating: TextView
    private lateinit var btnUpdate: Button
    private lateinit var btnDelete: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_renewable_source_details_user)

        initView()
        setValuesToViews()

//        btnUpdate.setOnClickListener {
//            openUpdateDialog(
//                intent.getStringExtra("srcId").toString(),
//                intent.getStringExtra("srcName").toString()
//            )
//        }
//
//        btnDelete.setOnClickListener {
//            deleteRecord(
//                intent.getStringExtra("srcId").toString()
//            )
//        }

    }

    private fun initView() {
//        tvSrcId = findViewById(R.id.tvSrcId)
        tvSrcName = findViewById(R.id.tvSrcName)
        tvSrcContent = findViewById(R.id.tvSrcContent)
        tvSrcRating = findViewById(R.id.tvSrcRating)

//        btnUpdate = findViewById(R.id.btnUpdate)
//        btnDelete = findViewById(R.id.btnDelete)
    }

    private fun setValuesToViews() {
//        tvSrcId.text = intent.getStringExtra("srcId")
        tvSrcName.text = intent.getStringExtra("srcName")
        tvSrcContent.text = intent.getStringExtra("srcContent")
        tvSrcRating.text = intent.getStringExtra("srcRating")

    }

//    private fun deleteRecord(
//        id: String
//    ){
//        val dbRef = FirebaseDatabase.getInstance().getReference("RenewableSources").child(id)
//        val mTask = dbRef.removeValue()
//
//        mTask.addOnSuccessListener {
//            Toast.makeText(this, "Renewable resource data deleted", Toast.LENGTH_LONG).show()
//
//            val intent = Intent(this, FetchRenewableSourcesUser::class.java)
//            finish()
//            startActivity(intent)
//        }.addOnFailureListener{ error ->
//            Toast.makeText(this, "Deleting Err ${error.message}", Toast.LENGTH_LONG).show()
//        }
//    }

//    private fun openUpdateDialog(
//        srcId: String,
//        srcName: String
//    ) {
//        val mDialog = AlertDialog.Builder(this)
//        val inflater = layoutInflater
//        val mDialogView = inflater.inflate(R.layout.update_renewable_sources, null)
//
//        mDialog.setView(mDialogView)
//
//        val etSrcName = mDialogView.findViewById<EditText>(R.id.etSrcName)
//        val etSrcContent = mDialogView.findViewById<EditText>(R.id.etSrcContent)
//        val etSrcRating = mDialogView.findViewById<EditText>(R.id.etSrcRating)
//
//        val btnUpdateData = mDialogView.findViewById<Button>(R.id.btnUpdateData)
//
//        etSrcName.setText(intent.getStringExtra("srcName").toString())
//        etSrcContent.setText(intent.getStringExtra("srcContent").toString())
//        etSrcRating.setText(intent.getStringExtra("srcRating").toString())
//
//        mDialog.setTitle("Updating $srcName Record")
//
//        val alertDialog = mDialog.create()
//        alertDialog.show()
//
//        btnUpdateData.setOnClickListener {
//            updateSourceData(
//                srcId,
//                etSrcName.text.toString(),
//                etSrcContent.text.toString(),
//                etSrcRating.text.toString()
//            )
//
//            Toast.makeText(applicationContext, "Renewable resource data Updated", Toast.LENGTH_LONG).show()
//
//            tvSrcName.text = etSrcName.text.toString()
//            tvSrcContent.text = etSrcContent.text.toString()
//            tvSrcRating.text = etSrcRating.text.toString()
//
//            alertDialog.dismiss()
//        }
//    }

//    private fun updateSourceData(
//        id: String,
//        name: String,
//        content: String,
//        rating: String
//    ) {
//        val dbRef = FirebaseDatabase.getInstance().getReference("RenewableSources").child(id)
//        val srcInfo = RenewableSourceModel(id, name, content, rating)
//        dbRef.setValue(srcInfo)
//    }

}