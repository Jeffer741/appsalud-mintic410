package com.example.a4bb410

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a4bb410.databinding.FragmentSignUpBinding
import com.example.a4bb410.databinding.FragmentSpecialistBinding


/**
 * A simple [Fragment] subclass.
 * Use the [SpecialistFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpecialistFragment : Fragment() {

    private var _binding: FragmentSpecialistBinding? = null
    private val binding: FragmentSpecialistBinding get() = _binding!!
    private val args: SpecialistFragmentArgs by navArgs()
    private lateinit var doctorAdapter: DoctorAdapter
    private lateinit var categories: MutableList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSpecialistBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        doctorAdapter = DoctorAdapter(listOf())
        binding.homeFragmentRecycler.apply {
            adapter = doctorAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        val services = listOf(

            ServiceItemModel("1", "General", "Los mejores especialistas en medicina general",
                R.drawable.ico_general.toString()
            ),

            ServiceItemModel("2", "Especialista", "Los mejores medicos especialistas",
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
        )

        categories = services.map { it.title }.toMutableList()
        categories.add(0,"Todos")
        val specialists = listOf(
            DoctorItemModel("1", "Dr Andres Gutierrez", "Especialista", "350+pacientes",
                R.drawable.doc1.toString(), 5, "lorem Ipsum is simply dummy text of the printing and typesetting industry."),
            DoctorItemModel("2", "Dr María Gutierrez", "Odontología", "100+pacientes",
                R.drawable.doc2.toString(), 4, "lorem Ipsum is simply dummy text of the printing and typesetting industry."),
            DoctorItemModel("3", "Dr Camila Hernandez", "Dermatología", "200+pacientes",
                R.drawable.doc3.toString(), 3, "lorem Ipsum is simply dummy text of the printing and typesetting industry."),
            DoctorItemModel("4", "Dr Samuel Reyes", "Pediatria", "500+pacientes",
                R.drawable.doc4.toString(), 4, "lorem Ipsum is simply dummy text of the printing and typesetting industry."),
            DoctorItemModel("5", "Dr Jorge Reyes", "General", "350+pacientes",
                R.drawable.doc5.toString(), 5, "lorem Ipsum is simply dummy text of the printing and typesetting industry."),
            DoctorItemModel("6", "Dr Lorena Rojas", "General", "100+pacientes",
                R.drawable.doc6.toString(), 3, "lorem Ipsum is simply dummy text of the printing and typesetting industry."),
            DoctorItemModel("7", "Dr Laura Moreno", "Especialista", "200+pacientes",
                R.drawable.doc7.toString(), 4, "lorem Ipsum is simply dummy text of the printing and typesetting industry."),
            DoctorItemModel("8", "Dr Luis Reyes", "Padiatria", "500+pacientes",
                R.drawable.doc8.toString(), 5, "lorem Ipsum is simply dummy text of the printing and typesetting industry.")
        )

       if (args.search) {
           binding.specialistFragmentRecyclerSearchLayout.visibility = View.VISIBLE
           binding.specialistFragmentRecyclerTitle.visibility = View.GONE
           binding.specialistFragmentTitle.text = getString(R.string.specilist_title)
           binding.specialistFragmentSubtitle.text = getString(R.string.specilist_subtitle)
           doctorAdapter.updateDataSet(specialists)
           binding.specialistFragmentRecyclerSearch.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line,categories))
           binding.specialistFragmentRecyclerSearch.setOnItemClickListener { parent, view, position, id ->
               if (position == 0){
                   doctorAdapter.updateDataSet(specialists)
               }else{
                   val category = categories[position]
                   doctorAdapter.updateDataSet(specialists.filter { it -> it.speciality == category})
               }
           }
           
       } else {
           binding.specialistFragmentRecyclerSearchLayout.visibility = View.GONE
           binding.specialistFragmentRecyclerTitle.visibility = View.VISIBLE
           binding.specialistFragmentTitle.text = args.name
           binding.specialistFragmentSubtitle.text = args.description
           doctorAdapter.updateDataSet(specialists.filter { it -> it.speciality == args.name })
       }
    }


}

