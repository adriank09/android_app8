package com.example.app8.ui.results

import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.app8.DataManager
import com.example.app8.R
import org.w3c.dom.Text

class ResultsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.content_results, container, false)

        // database and UI code below
        val dm = DataManager(activity!!)
        val tvResults = view.findViewById<TextView>(R.id.tvResults)

        val c = dm.selectAll()
        var list = ""
        if (c.count > 0) {
            while (c.moveToNext()) {
                list += "${c.getString(1)} - ${c.getString(2)}${System.lineSeparator()}"
            }
        }
        tvResults.text = list

        return view
    }
}