package com.example.tyro.Retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tyro.R

class WorkoutAdapter(val context: Context, val data: List<Data>) :
    RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder>() {

    val BASE_URL: String = "https://tyrofit-app-dev.s3.ap-south-1.amazonaws.com/workout_thumbnails/"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout_workout, parent, false)
        return WorkoutViewHolder(view)
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        val data = data[position]
        holder.workoutName.text = data.name
        holder.workoutTrainer.text = "with " + data.trainer_name
        holder.workoutLevel.text = data.difficulty_level_name
        holder.workoutDuration.text = (data.duration/60).toString()+" min"
        Glide.with(context).load(BASE_URL+data.image).into(holder.workoutImage)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class  WorkoutViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var workoutImage = itemView.findViewById<ImageView>(R.id.imageView)
        var workoutName = itemView.findViewById<TextView>(R.id.name)
        var workoutTrainer = itemView.findViewById<TextView>(R.id.trainer)
        var workoutLevel = itemView.findViewById<TextView>(R.id.level)
        var workoutDuration = itemView.findViewById<TextView>(R.id.duration)
    }
}