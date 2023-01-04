package com.example.app8.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.app8.DataManager
import com.example.app8.R

class SearchFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.content_search, container, false)

        // database and UI code below
        val dm = DataManager(activity!!)
        val btnSearch = view.findViewById<Button>(R.id.btnSearch)
        val etSearch = view.findViewById<EditText>(R.id.etSearch)
        val tvResult = view.findViewById<TextView>(R.id.tvResult)

        btnSearch.setOnClickListener { _ ->
            val result = dm.searchName(etSearch.text.toString())

            // make sure a result is found before traversing the cursor
            if (result.count > 0) {
                result.moveToNext()
                tvResult.text = "Result: ${result.getString(1)} - ${result.getString(2)}"
            }
        }

        return view

    }
}