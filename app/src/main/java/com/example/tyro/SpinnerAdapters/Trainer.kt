package com.example.tyro.SpinnerAdapters

data class Trainer(val trainer: String)

object Trainers{
    private val trainer = arrayListOf<String>(
        "Any",
        "Ankit",
        "Kim",
        "Jim"
    )
    var list: ArrayList<Trainer>?=null
    get() {
        if(field != null){
            return field
        }
        field = ArrayList()
        for(i in trainer.indices){

            val trainer = Trainer(trainer[i])
            field!!.add(trainer)
        }
        return field
    }

}