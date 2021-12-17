package com.example.tyro.SpinnerAdapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.tyro.R
import kotlinx.android.synthetic.main.spinner_difficulty.view.*
import kotlinx.android.synthetic.main.spinner_difficulty_close.view.*

class EquipmentArrayAdapter(context: Context, equipmentList: List<Equipment>) : ArrayAdapter<Equipment>(context,0, equipmentList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val equipment = getItem(position)
        val view = LayoutInflater.from(context).inflate(R.layout.spinner_difficulty_close, parent, false)
        view.textDifficultyClose.text = equipment!!.equipment
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val equipment = getItem(position)
        val view = LayoutInflater.from(context).inflate(R.layout.spinner_difficulty, parent, false)
        view.textDifficulty.text = equipment!!.equipment
        return view
    }
}