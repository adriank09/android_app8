package com.example.app8.ui.delete

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.app8.DataManager
import com.example.app8.R

class DeleteFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.content_delete, container, false)

        // database and UI code below
        val dm = DataManager(activity!!)
        val btnDelete = view.findViewById<Button>(R.id.btnDelete)
        val etName = view.findViewById<EditText>(R.id.etDeleteName)

        btnDelete.setOnClickListener { _ ->
            dm.delete(etName.text.toString())
        }

        return view
    }
}