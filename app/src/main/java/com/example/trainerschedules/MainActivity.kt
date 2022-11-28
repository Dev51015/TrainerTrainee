package com.example.trainerschedules

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import kotlinx.android.synthetic.main.activity_add_client.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvClientItems.adapter = ClientsAdapter(DataObject.getAllData())
        rvClientItems.layoutManager = LinearLayoutManager(this)

        addClient.setOnClickListener {
            startActivity(Intent(this,AddClient::class.java))
        }

        deleteAll.setOnClickListener {
            DataObject.deleteAll()
            rvClientItems.adapter = ClientsAdapter(DataObject.getAllData())
            rvClientItems.layoutManager = LinearLayoutManager(this)
        }
    }
}