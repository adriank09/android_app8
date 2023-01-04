package com.example.app8.ui.insert

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.app8.DataManager
import com.example.app8.R

class InsertFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.content_insert, container, false)

        // database and UI code below
        val dm = DataManager(activity!!)
        val btnInsert = view.findViewById<Button>(R.id.btnInsert)
        val etName = view.findViewById<EditText>(R.id.etName)
        val etAge = view.findViewById<EditText>(R.id.etAge)

        btnInsert.setOnClickListener { _ ->
            dm.insert(etName.text.toString(), etAge.text.toString().toInt())
        }

        return view
    }
}