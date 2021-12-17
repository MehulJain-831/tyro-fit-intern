package com.example.tyro

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tyro.Retrofit.Workout
import com.example.tyro.Retrofit.WorkoutAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WorkoutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WorkoutFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    private lateinit var adapter: WorkoutAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_workout, container, false)
        getWorkout()
        var image = view.findViewById<ImageView>(R.id.filter_button).setOnClickListener {
            view.findNavController().navigate(R.id.action_workoutFragment_to_filter)
        }
        return view
    }

    private fun getWorkout() {
        val workout = TyroFitWorkoutService.workoutInstance.getAll()
        workout.enqueue(object : Callback<Workout> {
            override fun onResponse(call: Call<Workout>, response: Response<Workout>) {
                val workout = response.body()

                if (workout != null) {
                    adapter = WorkoutAdapter(requireContext(), workout.data)
                    val workoutList =
                        requireView().findViewById<RecyclerView>(R.id.workoutList) as RecyclerView
                    workoutList.adapter = adapter
                    workoutList.layoutManager = GridLayoutManager(requireContext(), 2)
                }
            }

            override fun onFailure(call: Call<Workout>, t: Throwable) {
                Log.d("TESTING", "Error in fetching data", t)
            }
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WorkoutFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WorkoutFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}