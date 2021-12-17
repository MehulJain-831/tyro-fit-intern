package com.example.tyro

import com.example.tyro.Retrofit.Workout
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//https://3.108.207.62:3003/api/user/workout/all?category_id=14

//base URL of our API
const val BASE_URL = "http://3.108.207.62:3003/"

//definition of the interface
interface TyroFitAPI {
    @GET("api/user/workout/all?category_id=14")
    fun getAll(): Call<Workout>
}



//creating a singleton object of retrofit
object TyroFitWorkoutService{
    val workoutInstance: TyroFitAPI
    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        workoutInstance = retrofit.create(TyroFitAPI::class.java)
    }
}