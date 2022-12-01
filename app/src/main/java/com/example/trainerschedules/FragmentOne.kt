package com.example.trainerschedules

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.SpinnerAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_one.*
import kotlinx.android.synthetic.main.fragment_one.view.*

class FragmentOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragOne = inflater.inflate(R.layout.fragment_one, container, false)


        val priorities = arrayOf("normal", "medium", "high")
        val heightUnits = arrayOf("cm","feet")
        val weightUnits = arrayOf("kg","pounds")

        //Setting up priority spinner's adapter and listener
        val priorityArrayAdapter =  ArrayAdapter(activity!!, R.layout.item_priority,priorities)
        priorityArrayAdapter.setDropDownViewResource(R.layout.item_priority)

        val prioritySpinner : Spinner = fragOne.findViewById(R.id.prioritySpinner)
        prioritySpinner.adapter = priorityArrayAdapter
        prioritySpinner.setBackgroundColor(R.color.black)

        prioritySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
                Toast.makeText(activity?.applicationContext, "Selected priority is " + priorities[pos],Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        //Setting up height unit spinner's adapter and listener
        val heightArrayAdapter =  ArrayAdapter(activity!!, R.layout.item_priority,heightUnits)
        heightArrayAdapter.setDropDownViewResource(R.layout.item_priority)

        val heightSpinner : Spinner = fragOne.findViewById(R.id.heightUnitSpinner)
        heightSpinner.adapter = heightArrayAdapter
        heightSpinner.setBackgroundColor(R.color.black)

        heightSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
                Toast.makeText(activity?.applicationContext, "Selected height unit is " + heightUnits[pos],Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        //Setting up weight unit spinner's adapter and listener
        val weightArrayAdapter =  ArrayAdapter(activity!!, R.layout.item_priority,weightUnits)
        weightArrayAdapter.setDropDownViewResource(R.layout.item_priority)

        val weightSpinner : Spinner = fragOne.findViewById(R.id.weightUnitSpinner)
        weightSpinner.adapter = weightArrayAdapter
        weightSpinner.setBackgroundColor(R.color.black)

        weightSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
                Toast.makeText(activity?.applicationContext, "Selected weight unit is " + weightUnits[pos],Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        // Inflate the layout for this fragment
        return fragOne

        


    }
}