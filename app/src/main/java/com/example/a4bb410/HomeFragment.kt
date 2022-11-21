package com.example.a4bb410

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a4bb410.databinding.FragmentHomeBinding
import kotlin.math.log

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!
    private lateinit var serviceAdapter: ServiceAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        serviceAdapter = ServiceAdapter(listOf(

            ServiceItemModel("1", "General", "Los mejores especialistas en medicina general",
            R.drawable.ico_general.toString()
            ),

            ServiceItemModel("2", "Especilista", "Los mejores medicos especialistas",
                R.drawable.ico_especialidad.toString()
            ),

            ServiceItemModel("3", "Odontología", "Los mejores especialistas en odontología",
                R.drawable.ico_odontologia.toString()
            ),

            ServiceItemModel("4", "Dermatología", "Los mejores especialistas en dermatología",
                R.drawable.ico_dermatologia.toString()
            ),

            ServiceItemModel("5", "Pediatria", "Los mejores especialistas en pediatría",
                R.drawable.ico_pediatria.toString()
            )
        ))
        serviceAdapter.listener = object : OneServiceClickListener{
            override fun onClick(item: ServiceItemModel) {
                val direction = HomeFragmentDirections.actionHomeFragmentToSpecialistFragment()
                direction.name = item.title
                direction.description = item.description
                direction.search = false
                findNavController().navigate(direction)
            }

        }
        binding.homeFragmentRecycler.apply {
            adapter = serviceAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }


}