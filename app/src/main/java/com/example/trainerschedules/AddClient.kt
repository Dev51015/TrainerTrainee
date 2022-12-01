package com.example.trainerschedules

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_add_client.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_one.*
import kotlinx.android.synthetic.main.fragment_three.*
import java.io.Console

class AddClient : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_client)

        val fragmentOne = FragmentOne()
        val fragmentTwo = FragmentTwo()
        val fragmentThree = FragmentThree()

        setCurrentFragment(fragmentOne)

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.traineeInfo -> setCurrentFragment(fragmentOne)
                R.id.training -> setCurrentFragment(fragmentTwo)
                R.id.traineeMeals -> setCurrentFragment(fragmentThree)
                R.id.saveInfo -> save()
            }
            true
        }

       /* val priorities = arrayOf("normal", "medium", "high")
        val heightUnits = arrayOf("cm","feet")
        val weightUnits = arrayOf("kg","pounds")

        //Setting up priority spinner's adapter and listener
        val priorityArrayAdapter =  ArrayAdapter(this, R.layout.item_priority,priorities)
        priorityArrayAdapter.setDropDownViewResource(R.layout.item_priority)

        val prioritySpinner : Spinner = findViewById(R.id.prioritySpinner)
        prioritySpinner.adapter = priorityArrayAdapter
        prioritySpinner.setBackgroundColor(R.color.black)

        prioritySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
                Toast.makeText(applicationContext, "Selected priority is " + priorities[pos],Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        //Setting up height unit spinner's adapter and listener
        val heightArrayAdapter =  ArrayAdapter(this, R.layout.item_priority,heightUnits)
        heightArrayAdapter.setDropDownViewResource(R.layout.item_priority)

        val heightSpinner : Spinner = findViewById(R.id.heightUnitSpinner)
        heightSpinner.adapter = heightArrayAdapter
        heightSpinner.setBackgroundColor(R.color.black)

        heightSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
                Toast.makeText(applicationContext, "Selected height unit is " + heightUnits[pos],Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        //Setting up weight unit spinner's adapter and listener
        val weightArrayAdapter =  ArrayAdapter(this, R.layout.item_priority,weightUnits)
        weightArrayAdapter.setDropDownViewResource(R.layout.item_priority)

        val weightSpinner : Spinner = findViewById(R.id.weightUnitSpinner)
        weightSpinner.adapter = weightArrayAdapter
        weightSpinner.setBackgroundColor(R.color.black)

        weightSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
                Toast.makeText(applicationContext, "Selected weight unit is " + weightUnits[pos],Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }*/

        /*saveBtn.setOnClickListener {
            val clientName = etClientName.text.toString()
            val clientPriority = prioritySpinner.selectedItem.toString()
            DataObject.setData(clientName, clientPriority)
            startActivity(Intent(this, MainActivity::class.java))
        }

        cancelBtn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }*/

    }

    private fun setCurrentFragment (fragment : Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    }


    private fun save(){
        val clientName = etClientName.text.toString()
        val clientPriority = prioritySpinner.selectedItem.toString()
        DataObject.setData(clientName, clientPriority)
        return startActivity(Intent(this, MainActivity::class.java))
    }

}

