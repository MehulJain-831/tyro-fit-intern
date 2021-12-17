package com.example.tyro

data class Difficulty(val difficulty: String)

object Difficulties{
    private val difficulty = arrayListOf<String>(
        "Any",
        "Beginner",
        "Intermediate",
        "Advanced"
    )
    var list: ArrayList<Difficulty>?=null
    get() {
        if(field != null){
            return field
        }
        field = ArrayList()
        for(i in difficulty.indices){

            val difficultyDropdown = Difficulty(difficulty[i])
            field!!.add(difficultyDropdown)
        }
        return field
    }

}