package com.example.tyro.Retrofit

data class Data(var id: Int,
                var name: String,
                var trainer_name: String,
                var difficulty_level_name: String,
                var duration: Int,
                var image: String,
                var workout_plans: List<WorkoutPlan>)