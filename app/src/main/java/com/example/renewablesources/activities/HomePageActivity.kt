package com.example.renewablesources.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.widget.Button
import android.widget.ImageButton
import com.example.renewablesources.R

class HomePageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val imageButton1 : ImageButton = (findViewById(R.id.recImgBtn))

        imageButton1.setOnClickListener{

            val intent = Intent(this, RecommendedUsageAmount::class.java)
            startActivity(intent)
        }

        val imageButton2 : ImageButton = (findViewById(R.id.solarImgButton))

        imageButton2.setOnClickListener{

            val intent = Intent(this, FetchRenewableSources::class.java)
            startActivity(intent)
        }
    }


}