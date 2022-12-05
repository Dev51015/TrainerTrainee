package com.example.trainerschedules

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_update_client.*

class ViewAndUpdateClient : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_client)

        val priorities = arrayOf("normal", "medium", "high")
        val heightUnits = arrayOf("cm","feet")
        val weightUnits = arrayOf("kg","pounds")

        val pos = intent.getIntExtra("id", -1)
        val clientName = DataObject.getData(pos).name
        val clientPriority = DataObject.getData(pos).priority
        val clientGoal = DataObject.getData(pos).goal
        val clientAge = DataObject.getData(pos).age
        val clientHeight = DataObject.getData(pos).height
        val heightUnit = DataObject.getData(pos).heightUnit
        val clientWeight = DataObject.getData(pos).weight
        val weightUnit = DataObject.getData(pos).weightUnit
        val fatPercent = DataObject.getData(pos).fatPercent
        val musclePercent = DataObject.getData(pos).musclePercent

        updateName.setText(clientName)
        updateGoal.setText(clientGoal)
        updateAge.setText(clientAge)
        updateClientHeight.setText(clientHeight)
        updateClientWeight.setText(clientWeight)
        updateFatPercentage.setText(fatPercent)
        updateMusclePercentage.setText(musclePercent)

        //Setting up priority spinner's adapter and listener
        val priorityArrayAdapter =  ArrayAdapter(this, R.layout.item_priority,priorities)
        priorityArrayAdapter.setDropDownViewResource(R.layout.item_priority)

        val prioritySpinner : Spinner = findViewById(R.id.updatePriority)
        prioritySpinner.adapter = priorityArrayAdapter
        prioritySpinner.setSelection(priorityArrayAdapter.getPosition(clientPriority))
        prioritySpinner.setBackgroundColor(R.color.black)

        //Setting up height unit spinner's adapter and listener
        val heightArrayAdapter =  ArrayAdapter(this, R.layout.item_priority,heightUnits)
        heightArrayAdapter.setDropDownViewResource(R.layout.item_priority)

        val heightSpinner : Spinner = findViewById(R.id.updateHeightUnit)
        heightSpinner.adapter = heightArrayAdapter
        heightSpinner.setSelection(priorityArrayAdapter.getPosition(heightUnit))
        heightSpinner.setBackgroundColor(R.color.black)


        //Setting up weight unit spinner's adapter and listener
        val weightArrayAdapter =  ArrayAdapter(this, R.layout.item_priority,weightUnits)
        weightArrayAdapter.setDropDownViewResource(R.layout.item_priority)

        val weightSpinner : Spinner = findViewById(R.id.updateWeightUnit)
        weightSpinner.adapter = weightArrayAdapter
        weightSpinner.setSelection(priorityArrayAdapter.getPosition(weightUnit))
        weightSpinner.setBackgroundColor(R.color.black)

        val updateBtn = findViewById<ImageView>(R.id.updateClient)
        val deleteBtn = findViewById<ImageView>(R.id.deleteClient)
        val cancelUpdate = findViewById<ImageView>(R.id.cancelUpdate)
        updateBtn.setOnClickListener {
            DataObject.updateData(pos,
                                  updateName.text.toString(),
                                  updatePriority.selectedItem.toString(),
                                  updateGoal.text.toString(),
                                  updateAge.text.toString(),
                                  updateClientHeight.text.toString(),
                                  updateHeightUnit.selectedItem.toString(),
                                  updateClientWeight.text.toString(),
                                  updateWeightUnit.selectedItem.toString(),
                                  updateFatPercentage.text.toString(),
                                  updateMusclePercentage.text.toString())

            startActivity(Intent(this,MainActivity::class.java))
        }



        deleteBtn.setOnClickListener {
            DataObject.deleteData(pos)
            startActivity(Intent(this,MainActivity::class.java))
        }

        cancelUpdate.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}