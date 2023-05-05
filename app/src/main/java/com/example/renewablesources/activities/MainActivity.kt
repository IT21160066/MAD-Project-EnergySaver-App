package com.example.renewablesources.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.renewablesources.R

class MainActivity : AppCompatActivity() {

    private lateinit var btnInsertSourceData: Button
    private lateinit var btnFetchSourceData: Button
    private lateinit var hBtn: Button

    private lateinit var recUsage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnInsertSourceData = findViewById(R.id.btnInsertSourceData)
        btnFetchSourceData = findViewById(R.id.btnFetchSourceData)
        hBtn = findViewById(R.id.hBtn)

        recUsage = findViewById(R.id.recUsage)

        btnInsertSourceData.setOnClickListener{

            val intent = Intent(this, InsertRenewableSources::class.java)
            startActivity(intent)
        }

        btnFetchSourceData.setOnClickListener{
            val intent = Intent(this, FetchRenewableSources::class.java)
            startActivity(intent)
        }

        recUsage.setOnClickListener{
            val intent = Intent(this, RecommendedUsageAmount::class.java)
            startActivity(intent)
        }

        hBtn.setOnClickListener{
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }

//       val firebase : DatabaseReference = FirebaseDatabase.getInstance().getReference()
    }
}