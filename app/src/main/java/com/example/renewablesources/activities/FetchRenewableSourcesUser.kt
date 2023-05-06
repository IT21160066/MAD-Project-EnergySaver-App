package com.example.renewablesources.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import android.view.View
import com.example.renewablesources.R
import com.example.renewablesources.adapters.RenewableSourceAdapter
import com.example.renewablesources.models.RenewableSourceModel

class FetchRenewableSourcesUser : AppCompatActivity() {

    private lateinit var rnSourceRecyclerView: RecyclerView
    private lateinit var sourceLoadingData: TextView
    private lateinit var rnSourceList: ArrayList<RenewableSourceModel>
    private lateinit var  dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetch_renewable_sources_user)

        rnSourceRecyclerView  = findViewById(R.id.rnSourceView)
        rnSourceRecyclerView.layoutManager = LinearLayoutManager(this)
        rnSourceRecyclerView.setHasFixedSize(true)
        sourceLoadingData = findViewById(R.id.sourceLoadingData)
        rnSourceList = arrayListOf<RenewableSourceModel>()

        getSourceData()

    }

    private fun getSourceData(){

        rnSourceRecyclerView.visibility = View.GONE
        sourceLoadingData.visibility = View.VISIBLE

        dbRef = FirebaseDatabase.getInstance().getReference("RenewableSources")

        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                rnSourceList.clear()
                if(snapshot.exists()){
                    for (srcSnap in snapshot.children){
                        val srcData = srcSnap.getValue(RenewableSourceModel::class.java)
                        rnSourceList.add(srcData!!)
                    }
                    val mAdapter = RenewableSourceAdapter(rnSourceList)
                    rnSourceRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickListener(object : RenewableSourceAdapter.OnItemClickListener{
                        override fun onItemClick(position: Int) {
                            val intent = Intent(this@FetchRenewableSourcesUser, RenewableSourceDetailsUserActivity::class.java)

                            intent.putExtra("srcId", rnSourceList[position].rnSourceId)
                            intent.putExtra("srcName", rnSourceList[position].sourceName)
                            intent.putExtra("srcContent", rnSourceList[position].sourceContent)
                            intent.putExtra("srcRating", rnSourceList[position].sourceRating)
                            startActivity(intent)

                        }

                    })

                    rnSourceRecyclerView.visibility = View.VISIBLE
                    sourceLoadingData.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}