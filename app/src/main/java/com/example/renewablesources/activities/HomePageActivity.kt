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

        val imageButton4 : ImageButton = (findViewById(R.id.solarImgButton))

        imageButton4.setOnClickListener{

            val intent = Intent(this, FetchRenewableSourcesUser::class.java)
            startActivity(intent)
        }

//        val homebtn : Button = (findViewById(R.id.homebtn))
//
//        homebtn.setOnClickListener{
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
    }


}