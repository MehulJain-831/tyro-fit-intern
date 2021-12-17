package com.example.tyro.SpinnerAdapters

data class Equipment(val equipment: String)

object Equipments{
    private val equipment = arrayListOf<String>(
        "None",
        "Yes"
    )
    var list: ArrayList<Equipment>?=null
    get() {
        if(field != null){
            return field
        }
        field = ArrayList()
        for(i in equipment.indices){

            val equipmentDropdown = Equipment(equipment[i])
            field!!.add(equipmentDropdown)
        }
        return field
    }

}