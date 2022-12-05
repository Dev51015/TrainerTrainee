package com.example.trainerschedules

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_add_client.*
import kotlinx.android.synthetic.main.fragment_one.*
import kotlinx.android.synthetic.main.fragment_two.*

class AddClient : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_client)


        val navigateBack = findViewById<ImageView>(R.id.mainMenu)
        navigateBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        val addClient = findViewById<ImageView>(R.id.addTrainee)
        addClient.setOnClickListener {
            save()
        }

        val fragmentOne = FragmentOne()
        val fragmentTwo = FragmentTwo()

        setCurrentFragment(fragmentOne)

        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.traineeInfo -> setCurrentFragment(fragmentOne)
                R.id.chat -> setCurrentFragment(fragmentTwo)
            }
            true
        }


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
        val clientGoal = etGoal.text.toString()
        val clientAge = etClientAge.text.toString()
        val clientWeight = etClientWeight.text.toString()
        val weightUnit = weightUnitSpinner.selectedItem.toString()
        val clientHeight = etClientHeight.text.toString()
        val heightUnit = heightUnitSpinner.selectedItem.toString()
        val fatPercentage = etFatPercentage.text.toString()
        val musclePercentage = etMusclePercentage.text.toString()

        DataObject.setData(clientName,
                           clientPriority,
                           clientGoal,
                           clientAge,
                           clientHeight,
                           heightUnit,
                           clientWeight,
                           weightUnit,
                           fatPercentage,
                           musclePercentage)

        return startActivity(Intent(this, MainActivity::class.java))
    }

}

