package com.example.trainerschedules

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_update_client.*

class UpdateClient : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_client)
        val pos = intent.getIntExtra("id", -1)
        val clientName = DataObject.getData(pos).name
        etUpdateName.setText(clientName)

        updateBtn.setOnClickListener {
            DataObject.updateData(pos,etUpdateName.text.toString())
            startActivity(Intent(this,MainActivity::class.java))
        }

        deleteBtn.setOnClickListener {
            DataObject.deleteData(pos)
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

}