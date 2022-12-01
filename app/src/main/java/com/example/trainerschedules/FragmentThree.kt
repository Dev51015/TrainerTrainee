package com.example.trainerschedules

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentThree : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragThree = inflater.inflate(R.layout.fragment_three, container, false)
        val saveBtn : Button = fragThree.findViewById(R.id.saveBtn)


        /*saveBtn.setOnClickListener {
            savedName = arguments?.getString("name")
            //savedPriority = arguments?.getString("priority")
            DataObject.setData(savedName, "")
            startActivity(Intent(activity?.applicationContext, MainActivity::class.java))
        }*/

        // Inflate the layout for this fragment
        return fragThree
    }

}