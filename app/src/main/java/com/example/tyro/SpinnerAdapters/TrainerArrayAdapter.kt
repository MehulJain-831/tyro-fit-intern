package com.example.tyro.SpinnerAdapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.tyro.R
import kotlinx.android.synthetic.main.spinner_trainer.view.*
import kotlinx.android.synthetic.main.spinner_trainer_close.view.*

class TrainerArrayAdapter(context: Context, trainerList: List<Trainer>) : ArrayAdapter<Trainer>(context,0, trainerList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val trainer = getItem(position)
        val view = LayoutInflater.from(context).inflate(R.layout.spinner_trainer_close, parent, false)
        view.textTrainerClose.text = trainer!!.trainer
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val trainer = getItem(position)
        val view = LayoutInflater.from(context).inflate(R.layout.spinner_trainer, parent, false)
        view.textTrainer.text = trainer!!.trainer
        return view
    }
}