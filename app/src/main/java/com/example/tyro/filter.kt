package com.example.tyro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Spinner
import androidx.navigation.findNavController
import com.example.tyro.SpinnerAdapters.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [filter.newInstance] factory method to
 * create an instance of this fragment.
 */
class filter : Fragment() {
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


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_filter, container, false)
        setupCustomSpinner(view)
        view.findViewById<ImageView>(R.id.done_button).setOnClickListener {
            view.findNavController().navigate(R.id.action_filter_to_workoutFragment)
        }
        return view
    }
    private fun setupCustomSpinner(view: View) {
        val adapterDifficulty = DifficultyArrayAdapter(requireContext(), Difficulties.list!!)
        val spinnerDifficulty = view.findViewById<Spinner>(R.id.spinnerDifficulty)
        spinnerDifficulty.adapter = adapterDifficulty

        val adapterTrainer = TrainerArrayAdapter(requireContext(), Trainers.list!!)
        val spinnerTrainer = view.findViewById<Spinner>(R.id.spinnerTrainer)
        spinnerTrainer.adapter = adapterTrainer

        val adapterEquipment = EquipmentArrayAdapter(requireContext(), Equipments.list!!)
        val spinnerEquipment = view.findViewById<Spinner>(R.id.spinnerEquipment)
        spinnerEquipment.adapter = adapterEquipment


    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment filter.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            filter().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}